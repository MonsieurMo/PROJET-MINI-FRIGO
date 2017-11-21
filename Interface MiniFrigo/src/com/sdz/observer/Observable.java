package com.sdz.observer;

public interface Observable {
    public void addObserver(Observer obs);
    public void removeObserver();

    public void notifyObserverTemp(String str);
    public void notifyObserverTempVoulu(String str);
    public void notifyObserverHum(String str);
    public void notifyObserverTab(int[] tab);
}