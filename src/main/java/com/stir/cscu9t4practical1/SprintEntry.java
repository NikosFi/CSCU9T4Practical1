package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry{

    protected int repetitions;
    protected int recoveryTime;


    public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist,int repetitions, int recoveryTime) {
        super(n, d, m, y, h, min, s, dist);
        this.repetitions = repetitions;
        this.recoveryTime = recoveryTime;
    }

    @Override
    public String getEntry() {
         String result = getName()+" sprinted " + getRepetitions() + "x"
                +getDistance()+"m in " +getHour()+ ":" +getMin()+":"+ getSec() +" with " + getRecovery() + " minutes recovery" + " on "
                +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
        return result;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getYear() {
        return super.getYear();
    }

    @Override
    public int getSec() {
        return super.getSec();
    }

    @Override
    public int getMonth() {
        return super.getMonth();
    }

    @Override
    public int getMin() {
        return super.getMin();
    }

    @Override
    public int getHour() {
        return super.getHour();
    }

    @Override
    public int getDay() {
        return super.getDay();
    }

    @Override
    public float getDistance() {
        return super.getDistance();
    }

    public int getRepetitions() {
        return this.repetitions;
    }

    public int getRecovery() {
        return this.recoveryTime;
    }
}
