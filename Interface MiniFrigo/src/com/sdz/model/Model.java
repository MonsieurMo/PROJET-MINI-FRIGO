package com.sdz.model;

public class Model extends AbstractModel {

    public Model()
    {
        tab = new int[121];
    }


    /** Special Setter */
    @Override
    public void setTabTemp(int temp) {
        //Update Tabtemp
        for (int i=0;i<120;i++)
        {
            tab[i] = tab[i+1];
        }
        tab[120] = temp;
        notifyObserverTab(tab);
    }

    @Override
    public void setTempVoulu(int temp) {

        this.temperatureVoulu = temp;
        notifyObserverTempVoulu(String.valueOf(this.temperatureVoulu));

    }

    @Override
    public void setTemp(int temp) {

        this.temperature = temp;
        notifyObserverTemp(String.valueOf(this.temperature));

    }

    @Override
    public void setHum(int hum) {

        this.humidite = hum;
        notifyObserverHum(String.valueOf(this.humidite));

    }


    /** Special Getter*/
    @Override
    public void getTemp(String lecture) {
        int temp = 0;

        //Découpage de la string

        this.temperature = temp;
        //notifyObserver(String.valueOf(this.temperature));
    }

    @Override
    public void getHum(String lecture) {
        int humi = 0;

        //Découpage de la string


        this.humidite = humi;
        //notifyObserver(String.valueOf(this.humidite));
    }
}