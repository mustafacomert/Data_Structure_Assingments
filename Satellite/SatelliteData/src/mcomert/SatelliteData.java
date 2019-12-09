package mcomert;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SatelliteData implements Iterable
{
    private int data[][];
    private int output[];
    private int currentIndex;
    private int outputSize;

    public SatelliteData(int arr[][], int row, int col)
    {
        data = new int[row][col];
        for(int i=0; i<data.length; i++)
            for(int j=0; j<data[i].length; j++)
                data[i][j]=arr[i][j];

        outputSize = row*col;
        output = new int[outputSize];
        transformDataOneDimensionRecursively(0, 0, 0, row, col);
    }

    /**
     *Recursive method to transform 2D data to One Dimension Spirally.
     * @param index Current index of one dimensional array.
     * @param startingRow First value is 0, incremented by each recursive call.
     * @param startingCol First value is 0, incremented by each recursive call.
     * @param rowLen Row length of 2D data.
     * @param colLen Column length of 2D data.
     */
    private void transformDataOneDimensionRecursively(int index, int startingRow, int startingCol,
                                                     int rowLen,  int colLen)
    {
        for (int i = startingRow; i < colLen; i++) {
            output[index++] = data[startingRow][i];
        }
        for (int i = startingRow+1; i < rowLen; i++) {
            output[index++] = data[i][colLen-1];
        }


        for (int i = colLen-2; i >= startingCol; i--) {
            output[index++] = data[rowLen-1][i];
        }


        for (int i = rowLen-2; i > startingRow; i--) {
            output[index++] = data[i][startingCol];
        }

        if(startingRow < rowLen && startingCol < colLen){
            transformDataOneDimensionRecursively(index, startingRow+1, startingCol+1, rowLen-1, colLen-1);
        }
    }

    /**
     * Iterator method.
     * @return Iterator.
     */
    public Iterator iterator()
    {
        return new Iterator()
        {
            @Override
            public boolean hasNext()
            {
                if(currentIndex < outputSize)
                    return true;
                return false;
            }

            @Override
            public Object next()
            {
                if(!hasNext())
                    throw new NoSuchElementException();

                return output[currentIndex++];
            }
        };
    }
}
