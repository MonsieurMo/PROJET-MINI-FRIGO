package com.sdz.model;

public class Model extends AbstractModel {

    public Model()
    {
        tabTemp = new int[121];
        tabHum = new int[121];
    }

    public void reader(String str)
    {
        String Strs[] = str.split("-");
        setTabTemp(Float.parseFloat(Strs[0]));
        setTemp(Float.parseFloat(Strs[0]));
        setTempExt(Float.parseFloat(Strs[1]));
        setHum(Float.parseFloat(Strs[2]));
        setTabHum(Float.parseFloat(Strs[2]));

    }


    /** Special Setter */
    @Override
    public void setTabTemp(float temp) {

        //Arrondie
        int arrondie = 0;
        try {
            arrondie = Math.round(temp);}
        catch(Throwable th){}


        //Update Tabtemp
        for (int i=0;i<120;i++)
        {
            tabTemp[i] = tabTemp[i+1];
        }
        tabTemp[120] = arrondie;
        notifyObserverTab(tabTemp);
    }

    @Override
    public void setTabHum(float hum) {

        //Arrondie
        int arrondie = 0;
        try {
            arrondie = Math.round(hum);}
        catch(Throwable th){}


        //Update Tabtemp
        for (int i=0;i<120;i++)
        {
            tabHum[i] = tabHum[i+1];
        }
        tabHum[120] = arrondie;
        notifyObserverTabHum(tabHum);
    }

    @Override
    public void setTempVoulu(float temp) {

        //Arrondie
        int arrondie = 0;
        try {
            arrondie = Math.round(temp);}
        catch(Throwable th){}

        this.temperatureVoulu = arrondie;
        notifyObserverTempVoulu(Float.toString(this.temperatureVoulu));

    }

    @Override
    public void setTemp(float temp) {

        //Arrondie
        try {
            temp = (Math.round(temp*10f)/10f);
            System.out.println(temp);
        }

        catch(Throwable th){}

        this.temperature = temp;
        notifyObserverTemp(Float.toString(this.temperature));

    }

    @Override
    public void setTempExt(float temp) {

        //Arrondie
        try {
            temp = (Math.round(temp*10f)/10f);
            System.out.println(temp);
        }

        catch(Throwable th){}

        this.temperatureExt = temp;
        notifyObserverTempExt(Float.toString(this.temperatureExt));

    }



    @Override
    public void setHum(float hum) {

        //Arrondie
        try {
            hum = Math.round(hum*10f)/10f;}
        catch(Throwable th){}

        this.humidite = hum;
        notifyObserverHum(String.valueOf(this.humidite));

    }

}