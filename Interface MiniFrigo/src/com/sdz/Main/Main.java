package com.sdz.Main;

import com.sdz.controler.*;
import com.sdz.model.*;
import com.sdz.vue.Vue;

public class Main {

    public static void main(String[] args) {

        //Instanciation de notre modèle
        AbstractModel mod = new Model();

        //Création du contrôleur
        AbstractControler controler = new Controler(mod);

        //Création de notre fenêtre avec le contrôleur en paramètre
        Vue vue = new Vue(controler);

        //Ajout de la fenêtre comme observer de notre modèle
        mod.addObserver(vue);

        controler.lecture();
    }
}