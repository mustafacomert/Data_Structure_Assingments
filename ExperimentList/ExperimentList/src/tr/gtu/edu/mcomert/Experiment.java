package tr.gtu.edu.mcomert;

/**
 * to represent a experiment
 */
public class Experiment
{
    private String setup;
    private int day;
    private String time;
    private boolean completed;
    private float accuracy;

    /**
     * Constructor for initializing experiment properties
     * @param setup
     * @param day
     * @param time
     * @param completed
     * @param accuracy
     */
    public Experiment(String setup, int day, String time, boolean completed, float accuracy)
    {
        this.setup = setup;
        this.day = day;
        this.time = time;
        this.completed = completed;
        this.accuracy = accuracy;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Experiment{" +
                "setup='" + setup + '\'' +
                ", day=" + day +
                ", time='" + time + '\'' +
                ", accuracy=" + accuracy +
                ", completed=" + completed +
                '}';
    }
}