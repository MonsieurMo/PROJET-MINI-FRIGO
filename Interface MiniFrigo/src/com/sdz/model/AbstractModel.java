package com.sdz.model;

import com.sdz.observer.Observable;
import com.sdz.observer.Observer;

import java.util.ArrayList;

public abstract class AbstractModel implements Observable {

    /** Variables */
    public float temperature = 0;
    public float temperatureExt = 0;
    public float humidite = 0;
    public int temperatureVoulu = 0;

    public int[] tabTemp;
    public int[] tabHum;

    /** Methodes */
    public abstract void reader(String str);

    public abstract void setTempVoulu(float temp);

    public abstract void setTemp(float temp);

    public abstract void setTabTemp(float temp);

    public abstract  void setTempExt(float temp);

    public abstract void setHum(float hum);

    public abstract  void setTabHum(float hum);



    /** Parties Observer */

    /** Liste des observer */
    private ArrayList<Observer> listObserver = new ArrayList<Observer>();


    //Implémentation du pattern observer
    public void addObserver(Observer obs) {
        this.listObserver.add(obs);
    }

    /** Partie Notification observer*/
    public void notifyObserverTemp(String str) {
        if(str.matches("^0[0-9]+"))
            str = str.substring(1, str.length());

        for(Observer obs : listObserver)
            obs.updateTemp(str);
    }

    public void notifyObserverTempVoulu(String str) {
        if(str.matches("^0[0-9]+"))
            str = str.substring(1, str.length());

        for(Observer obs : listObserver)
            obs.updateTempVoulu(str);
    }

    public void notifyObserverHum(String str) {
        if(str.matches("^0[0-9]+"))
            str = str.substring(1, str.length());

        for(Observer obs : listObserver)
            obs.updateHum(str);
    }

    public void notifyObserverTab(int[] tab) {

        for(Observer obs : listObserver)
            obs.updateTab(tab);
    }

    public void notifyObserverTabHum(int[] tab) {
        for(Observer obs : listObserver)
            obs.updateTabHum(tab);
    }

    public void notifyObserverTempExt(String str) {
        if(str.matches("^0[0-9]+"))
            str = str.substring(1, str.length());

        for(Observer obs : listObserver)
            obs.updateTempExt(str);
    }

    public void removeObserver() {
        listObserver = new ArrayList<Observer>();
    }
}