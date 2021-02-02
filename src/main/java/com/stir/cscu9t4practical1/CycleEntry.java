package com.stir.cscu9t4practical1;

public class CycleEntry extends Entry {

    protected String terrain;
    protected String tempo;
    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String terrain, String tempo) {
        super(n, d, m, y, h, min, s, dist);

        this.terrain = terrain;
        this.tempo = tempo;
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

    @Override
    public float getDistance() {
        return super.getDistance();
    }

    public String getTerrain() {
        return terrain;
    }

    public String getTempo() {
        return tempo;
    }

    @Override
    public String getEntry() {
        String result = getName()+" cycled " + getDistance()+" km in "
                +getHour()+ ":" +getMin()+":"+ getSec()  + " on "
                +getDay()+"/"+getMonth()+"/"+getYear()+ " on " +getTerrain()
                + " at " +getTempo() +" tempo"+"\n";
        return result;
    }

    //"Alice cycled 3.0 km in 0:16:7 on 1/2/2003 on asphalt at moderate tempo\n";
}
