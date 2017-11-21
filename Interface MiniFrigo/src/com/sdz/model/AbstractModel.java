package com.sdz.model;

import com.sdz.observer.Observable;
import com.sdz.observer.Observer;

import java.util.ArrayList;

public abstract class AbstractModel implements Observable {

    /** Variables */
    public int temperature = 0;
    public int humidite = 0;
    public int temperatureVoulu = 0;

    public int[] tab;

    /** Methodes */
    public abstract void setTempVoulu(int temp);

    public abstract void setTemp(int temp);

    public abstract void setTabTemp(int temp);

    public abstract void setHum(int hum);

    public abstract void getTemp(String lecture);

    public abstract void getHum(String lecture);






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

    public void removeObserver() {
        listObserver = new ArrayList<Observer>();
    }
}