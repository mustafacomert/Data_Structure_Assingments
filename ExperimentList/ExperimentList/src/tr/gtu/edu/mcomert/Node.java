package tr.gtu.edu.mcomert;

/**
 * Node class to supply linkedlist structure
 */
public class Node
{
    Experiment exp;
    Node nextExp;
    Node nextDay;

    public Node(){}

    /**
     * initialize experiment in the node
     * @param exp
     */
    public Node(Experiment exp)
    {
        this.exp = exp;
    }

    /**
     * set experiment
     * @param e
     */
    public void setExp(Experiment e)
    {
        exp = e;

        //i don't understand why this wasn't work(takes 2 hours)
        /*exp.setAccuracy(e.getAccuracy());
        exp.setCompleted(e.isCompleted());
        exp.setDay(e.getDay());
        exp.setSetup(e.getSetup());
        exp.setTime(e.getTime());*/
    }
}
