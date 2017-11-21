package com.sdz.controler;
import java.util.ArrayList;
import com.sdz.model.AbstractModel;

public abstract class AbstractControler {


    protected AbstractModel mod;

    public AbstractControler(AbstractModel mod)
    {
        this.mod = mod;

    }

    public abstract void setTempVoulu(int nombre);

    public abstract void lecture();
}