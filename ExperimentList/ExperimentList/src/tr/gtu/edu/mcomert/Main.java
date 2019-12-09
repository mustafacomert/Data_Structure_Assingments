package tr.gtu.edu.mcomert;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * a driver program
 */
public class Main
{
    public static void main(String[] args)
    {
        ExperimentList list = new ExperimentList();
        Experiment exp = new Experiment("Exp1", 1, "", true, (float)0.9);
        Experiment exp2 = new Experiment("Exp2", 1, "", true, (float)0.2);
        Experiment exp3 = new Experiment("Exp3", 1, "", true, (float)0.5);
        Experiment exp4 = new Experiment("Exp4", 0, "", true, (float)0.7);
        Experiment exp5 = new Experiment("Exp5", 2, "", false, (float)0.7);
        Experiment exp6 = new Experiment("Exp6", 1, "", false, (float)0.3);
        Experiment exp7 = new Experiment("Exp7", 0, "", true, (float)0.4);
        Experiment exp8 = new Experiment("Exp8", 2, "", false, (float)0.7);
        Experiment exp9 = new Experiment("Exp9", 5, "", true, (float)0.7);
        Experiment exp10 = new Experiment("Exp10", 4, "", true, (float)0.7);
        Experiment exp11 = new Experiment("Exp11", 5, "", true, (float)0.55);
        System.out.println("Adding new experiments");
        list.addExp(exp);
        list.addExp(exp2);
        list.addExp(exp3);
        list.addExp(exp4);
        list.addExp(exp5);
        list.addExp(exp6);
        list.addExp(exp7);
        list.addExp(exp8);
        list.addExp(exp9);
        list.addExp(exp10);
        list.addExp(exp11);
        System.out.println("List All:");
        list.listAll();
        System.out.println("Getting Experiments one by one");
        list.getExp(0,0);
        list.getExp(0,1);
        list.getExp(1,0);
        list.getExp(1,1);
        list.getExp(1,2);
        list.getExp(1,3);
        list.getExp(2,0);
        list.getExp(2,1);
        list.getExp(4,0);
        list.getExp(5,0);
        list.getExp(5,1);

        System.out.println("Setting Experiment (5,0), Accuracy Changes 0.7 to 0.48:");
        Experiment exp12 = new Experiment("Exp12", 5,"",true, (float) 0.48);
        list.setExp(5,0, exp12);
        System.out.println("See The Difference: ");
        list.listAll();

        System.out.println("Remove (2,0):");
        list.removeExp(2,0);
        list.listAll();
        System.out.println("Again, Remove (2,0):");
        list.removeExp(2,0);
        list.listAll();

        System.out.println("List Experiment in Day 2:");
        list.listExp(2);

        System.out.println("Remove Day0");
        list.removeDay(0);
        list.listAll();

        System.out.println("Usage Of Iterator, To List All Experiments");
        Iterator itr =  list.iterator();
        try {
            while (itr.hasNext()) {
                System.out.println(itr.next().toString());
            }
        }
        catch (NoSuchElementException e)
        {
            System.out.println("Error Caught: " + e.toString());
            System.exit(0);
        }

        System.out.println("----------------------");
        list.listAll();
        System.out.println("Order Day1:");
        list.orderDay(1);
        list.listAll();

        System.out.println("Order All Experiments:");
        ExperimentList orderedList = list.orderExperiments();
        System.out.println("Original List Before Sorting");
        list.listAll();
        System.out.println("OrderedList After Sorting");
        orderedList.listAll();
        System.out.println("Original List After Sorting:");
        list.listAll();

        System.out.println("Listing All Complated Experiments in Day1");
        list.listExp(1);

    }
}
