package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry {

    protected String tookPlace;

    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist,String tookPlace) {
        super(n, d, m, y, h, min, s, dist);
        this.tookPlace = tookPlace;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getDay() {
        return super.getDay();
    }

    @Override
    public int getMonth() {
        return super.getMonth();
    }

    @Override
    public int getYear() {
        return super.getYear();
    }

    @Override
    public int getHour() {
        return super.getHour();
    }

    @Override
    public int getMin() {
        return super.getMin();
    }

    @Override
    public int getSec() {
        return super.getSec();
    }

    public String getTookPlace() {
        return tookPlace;
    }

    @Override
    public String getEntry() {
        String result = getName()+" swam " + getDistance()+" km " + "in a " + getTookPlace() + " in "
                +getHour()+ ":" +getMin()+":"+ getSec() +" on "
                +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
        return result;
    }

    // "Alice swam 3.0 km outdoors in 0:16:7 on 1/2/2003
}
