package com.sdz.observer;

/**
 * Created by Etienne on 20/11/2017.
 */
public interface Observer {
    public void updateTemp(String str);
    public void updateTempVoulu(String str);
    public void updateHum(String str);
    public void updateTab(int[] tab);
    public void updateTabHum(int[] tab);
    public void updateTempExt(String str);

}