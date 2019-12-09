package mcomert;

import java.util.Arrays;
import java.util.Iterator;

public class Main
{
    public static void main(String[] args)
    {
        //initialize 2D array
        int[][] arr;
        arr = new int[5][4];

        //fill array
        for(int i = 0; i < 5; ++i)
            for (int j = 0; j < 4; ++j)
                arr[i][j] = i+j;

        //print array
        for(int i = 0; i < 5; ++i)
            System.out.println(Arrays.toString(arr[i]));

        //Create a object of SatelliteData with 3 parameter constructor
        SatelliteData sd = new SatelliteData(arr, 5, 4);
        //Create an iterator, iterates over sd
        Iterator it = sd.iterator();
        //Print Gokturk 3 Satellite Data with the help of iterator
        while (it.hasNext())
        {
            System.out.print(it.next());
            if(it.hasNext())
                System.out.print("->");
        }
    }
}
