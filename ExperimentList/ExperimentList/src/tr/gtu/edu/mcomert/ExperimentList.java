package tr.gtu.edu.mcomert;
import javafx.beans.property.SimpleObjectProperty;

import java.net.SocketOption;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 */
public class ExperimentList //implements Iterable
{
    private Node head;

    /**
     *
     * @return head of the list
     */
    public Node getHead() {
        return head;
    }

    /**
     *lists all experiments in list, experiment view and day view
     */
    public void listAll()
    {
        System.out.println("List experiment view:");
        Node last = head;
        while( last != null)
        {
            System.out.println(last.exp.toString());
            last = last.nextExp;
        }
        System.out.println("List day view:");
        last = head;
        while( last != null) {
            System.out.println(last.exp.toString());
            last = last.nextDay;
        }
    }

    /**
     *
     * @param e is an experiment that will be added to list
     */
    public void addExp(Experiment e)
    {
        Node newNode = new Node(e);
        boolean flag = false;
        boolean flag2 = false;

        if(head == null)//If List is empty
        {
            head = newNode;
        }
        else//If List not empty
        {
            Node iter = head;
            while(iter != null)
            {
                if(e.getDay() == iter.exp.getDay()) //If there are experiment in list
                                                   // that is same day value with new experiment
                {
                    flag = true;
                    flag2 = true;
                    while (iter.nextExp!=null && iter.nextExp.exp.getDay()==e.getDay()) {
                        iter = iter.nextExp;
                    }
                    Node temp = iter.nextExp;
                    iter.nextExp = newNode;
                    newNode.nextExp = temp;
                }
                iter = iter.nextDay;
            }

            if(flag == false && e.getDay() < head.exp.getDay()) //If new experiment has smaller day value
                                                               // than first(head) experiment in list
            {
                flag2 = true;
                Node temp = head;
                head = newNode;
                newNode.nextExp = temp;

                newNode.nextDay = temp;
            }

            iter = head;
            while(iter.nextExp != null)
            {
                iter = iter.nextExp;
            }

            if(flag == false && e.getDay() > iter.exp.getDay())  //If new experiment has bigger day value than
                                                                // last experiment in list
            {
                flag2 = true;
                iter.nextExp = newNode;
                newNode.nextExp = null;

                iter = head;
                while(iter.nextDay != null)
                {
                    iter = iter.nextDay;
                }

                iter.nextDay = newNode;
                newNode.nextDay = null;
            }

            if(flag2 == false)//If day value of new experiment is bewteen two experiment in list
            {
                iter = head;
                while(iter.nextExp != null && iter.nextExp.exp.getDay() <= e.getDay())
                {
                    iter = iter.nextExp;
                }
                Node temp = iter.nextExp;
                iter.nextExp = newNode;
                newNode.nextExp = temp;

                iter = head;
                while(iter.nextDay != null && iter.nextDay.exp.getDay() <= e.getDay())
                {
                    iter = iter.nextDay;
                }
                iter.nextDay = newNode;
                newNode.nextDay = temp;
            }
        }
    }

    /**
     * prints screen experiment that is at given day and index
     * @param day of experiment
     * @param index determines place of experiment
     *
     */
    public void getExp(int day, int index)
    {
        Node iter = head;
        boolean flag3 = false;
        while(flag3 == false && iter != null)
        {
            if(iter.exp.getDay() == day)
            {
                flag3 = true;
                for(int i = 0; i < index; ++i)
                {
                    iter = iter.nextExp;
                }
                System.out.println(iter.exp);
            }
            iter = iter.nextDay;
        }
    }

    /**
     * set the experiment with the given day and position
     * @param day
     * @param index
     * @param e
     */
    public void setExp(int day, int index, Experiment e)
    {
        Node iter = head;
        boolean flag3 = false;
        while(flag3 == false && iter != null)
        {
            if(iter.exp.getDay() == day)
            {
                flag3 = true;
                for(int i = 0; i < index; ++i)
                {
                    iter = iter.nextExp;
                }
                iter.setExp(e);
            }
            iter = iter.nextDay;
        }
    }


    /**
     * remove the experiment specified as index from given day
     * @param day
     * @param index
     */
    public void removeExp(int day, int index) {
        Node iter = head;
        boolean flag3 = false;
        while (flag3==false && iter!=null) {
            if (iter.exp.getDay()==day) {
                flag3 = true;
                for (int i = 0; i < index; ++i) {
                    iter = iter.nextExp;
                }
                if (iter==head)//removing head
                {
                    Node temp = head;
                    head = head.nextExp;
                    if (temp.nextExp.exp.getDay()==day) {
                        head.nextDay = temp.nextDay;
                    }
                }
                else if(iter.nextExp == null)//removing last element
                {
                    Node iter2 = head;
                    while(iter2.nextExp != iter)
                    {
                        iter2 = iter2.nextExp;
                    }
                    iter2.nextExp = null;
                    iter2.nextDay = null;
                }
                else// removing from between two experiments
                {
                    Node iter2 = head;
                    while(iter2.nextExp != iter)
                    {
                        iter2 = iter2.nextExp;
                    }

                    iter2.nextExp = iter.nextExp;

                    Node iter3 = head;
                    while(iter3.nextDay.exp.getDay() != iter.exp.getDay())
                    {
                        iter3 = iter3.nextDay;
                    }

                    if(iter2.nextExp.exp.getDay() == day)
                    {
                        iter3.nextDay = iter2.nextExp;
                        iter2.nextExp.nextDay = iter.nextDay;
                    }
                    else
                    {
                        iter3.nextDay = iter.nextDay;
                    }
                }

            }
            iter = iter.nextDay;
        }
    }

    /**
     * list all completed experiments in a given day
     * @param day
     */
    public void listExp(int day)
    {
        Node iter = head;
        boolean flag3 = false;
        while(flag3 == false && iter != null)
        {
            if(iter.exp.getDay() == day)
            {
                flag3 = true;
                while(iter != null && iter.exp.getDay() == day)
                {
                    if(iter.exp.isCompleted())
                        System.out.println(iter.exp);
                    iter = iter.nextExp;
                }
            }
            if(flag3 == false)
                iter = iter.nextDay;
        }
    }

    /**
     * remove all experiments in a given day
     * @param day
     */
    public void removeDay(int day)
    {
        Node iter = head;
        Node iter2 = head;
        int day2;


        while(iter.exp.getDay() != day)
        {
            iter = iter.nextDay;
        }

        if(iter == head)
        {
            head = iter.nextDay;
        }
        else {
            while(iter2.nextDay.exp.getDay() != day)
            {
                iter2 = iter2.nextDay;
            }
            iter2.nextDay = iter.nextDay;
            day2 = iter2.exp.getDay();
            while (iter2.nextExp.exp.getDay()==day2) {
                iter2 = iter2.nextExp;
            }
            iter2.nextExp = iter.nextDay;
        }
    }

    /**
     * sorts the experiments in a given day according to the accuracy,
     * the changes will be done on the list
     * @param day
     */
    public void orderDay(int day)
    {
        Node iter = head;

        while (iter.exp.getDay() != day)//to reach given day
        {
            iter = iter.nextDay;
        }

        //bubble sort, not most efficient but easy to implement, i am having a short time.
        while(iter != null && iter.exp.getDay() == day)
        {
            Node next = iter.nextExp;

            while(next != null && next.exp.getDay() == day)
            {
                if(iter.exp.getAccuracy() > next.exp.getAccuracy())
                {
                    Experiment temp2 = iter.exp;
                    iter.setExp(next.exp);
                    next.setExp(temp2);
                }
                next = next.nextExp;
            }
            iter = iter.nextExp;
        }
    }

    /**
     * sorts all the experiments in the list according to the accuracy,
     * the original list should not be changed since the day list may be damage
     * @return new ordered list
     */
    public ExperimentList orderExperiments()
    {
        Node iter = head;
        ExperimentList copyOflist = new ExperimentList();

        while (iter!=null)//copying elements in list to copyOflist, i think there are easier ways
        {
            copyOflist.addExp(iter.exp);
            iter = iter.nextExp;
        }

        copyOflist.sort(copyOflist.getHead());

        return copyOflist;
    }

    /**
     * takes current node of list to sort
     * @param iter
     */
    public void sort(Node iter)//uses bubble sort
    {
        while (iter != null)
        {
            Node next = iter.nextExp;

            while (next != null)
            {
                if (iter.exp.getAccuracy() > next.exp.getAccuracy()) //swap
                {
                    Experiment temp = iter.exp;
                    iter.exp = next.exp;
                    next.exp = temp;
                }
                next = next.nextExp;
            }
            iter = iter.nextExp;
        }
    }

    /**
     * Iterator Class
     */
    public class MyIterator implements Iterator {

        private Node current;

        public MyIterator()
        {
            current = head;
        }

        public boolean hasNext()
        {
            if(current == null)
                return false;
            return true;
        }

        public Experiment next() throws NoSuchElementException {
            if(current == null)
                throw new NoSuchElementException();
            Experiment tmp = current.exp;
            current = current.nextExp;
            return tmp;
        }
    }

    /**
     * to iterate over the link list
     * @return iterator
     */
    public Iterator iterator()
    {
        return new MyIterator();
    }
}
