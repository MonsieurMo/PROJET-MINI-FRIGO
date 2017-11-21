package com.sdz.vue;

import com.sdz.controler.AbstractControler;
import com.sdz.observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Vue extends JFrame implements Observer {

    private AbstractControler controler;

    //Pan
    Panel pan;

    //Label
    private JLabel Temp = new JLabel("Température : 18°C");
    private JLabel Hum = new JLabel("Humidité : 15%");
    private JLabel tempVoulu = new JLabel("Température désiré : 15°C");

    //TextField
    private JTextField tempVouluField = new JTextField();

    //Button
    private JButton update = new JButton("Update Température");
    private JButton option = new JButton("Option");
    private JButton loadCOnfig = new JButton("Charger configuration");
    private JButton saveConfig = new JButton("Sauvegarder configuration");


    /**Constructeur */
    public Vue(AbstractControler controler){

        //Creation de la fenetre
        this.setSize(700, 575);
        this.setTitle("Interface Frigo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        //Creation panel
        pan = new Panel();
        pan.setLayout(null);
        pan.setSize(800,600);
        this.setContentPane(pan);

        //Font
        Font f1 = new Font("f1",Font.BOLD,18);
        Font f2 = new Font("f1",Font.BOLD,14);

        //Label
        Temp.setBounds(8,33,200,30);
        Temp.setFont(f1);
        pan.add(Temp);

        Hum.setBounds(198,33,200,33);
        Hum.setFont(f1);
        pan.add(Hum);

        tempVoulu.setBounds(450,360,200,50);
        tempVoulu.setFont(f2);
        pan.add(tempVoulu);



        //Température graph
        JLabel temp0 = new JLabel("0°C");
        temp0.setBounds(380,257,50,30);
        pan.add(temp0);

        JLabel temp10 = new JLabel("+10°C");
        temp10.setBounds(380,275-75,50,30);
        pan.add(temp10);

        JLabel temp20 = new JLabel("+20°C");
        temp20.setBounds(380,275-135,50,30);
        pan.add(temp20);

        JLabel temp30 = new JLabel("+30°C");
        temp30.setBounds(380,85,50,30);
        pan.add(temp30);

        JLabel graph1 = new JLabel("Température (en °C)");
        graph1.setFont(f2);
        graph1.setBounds(8,68,150,30);
        pan.add(graph1);

        JLabel sec120T = new JLabel("2 min");
        sec120T.setBounds(8,514,50,30);
        pan.add(sec120T);

        JLabel sec60T = new JLabel("1 min");
        sec60T.setBounds(176,514,50,30);
        pan.add(sec60T);

        JLabel sec0T = new JLabel("0 min");
        sec0T.setBounds(360,514,50,30);
        pan.add(sec0T);



        //Humidité graph
        JLabel hum0 = new JLabel("0%");
        hum0.setBounds(380,500,50,30);
        pan.add(hum0);

        JLabel hum100 = new JLabel("100%");
        hum100.setBounds(380,510-188,50,30);
        pan.add(hum100);

        JLabel hum20 = new JLabel("20%");
        hum20.setBounds(380,510-46,50,30);
        pan.add(hum20);

        JLabel hum40 = new JLabel("40%");
        hum40.setBounds(380,510-82,50,30);
        pan.add(hum40);

        JLabel hum60 = new JLabel("60%");
        hum60.setBounds(380,510-118,50,30);
        pan.add(hum60);

        JLabel hum80 = new JLabel("80%");
        hum80.setBounds(380,510-154,50,30);
        pan.add(hum80);

        JLabel graph2 = new JLabel("Humidité (en %)");
        graph2.setFont(f2);
        graph2.setBounds(8,305,150,30);
        pan.add(graph2);

        JLabel sec120H = new JLabel("2 min");
        sec120H.setBounds(8,273,50,30);
        pan.add(sec120H);

        JLabel sec60H = new JLabel("1 min");
        sec60H.setBounds(176,273,50,30);
        pan.add(sec60H);

        JLabel sec0H = new JLabel("0 min");
        sec0H.setBounds(360,273,50,30);
        pan.add(sec0H);


        //Text Field
        tempVouluField.setBounds(450,410,200,50);
        pan.add(tempVouluField);

        //Button
        update.setBounds(450,470,200,50);
        pan.add(update);

        update.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){

                //Action du bouton
                controler.setTempVoulu(Integer.parseInt(tempVouluField.getText()));
            }
        });

        option.setBounds(614,0,80,20);
        pan.add(option);

        loadCOnfig.setBounds(455,0,160,20);
        pan.add(loadCOnfig);

        saveConfig.setBounds(268,0,190,20);
        pan.add(saveConfig);


        //Attribution du controler
        this.controler = controler;

        //On rend la fenetre visible
        this.setVisible(true);
    }


    /** Partie observer : Update */

    //Implémentation du pattern observer
    public void updateTempVoulu(String str)
    {
        tempVoulu.setText("Température désiré : "+ str + "°C");
        this.repaint();
    }

    public void updateTemp(String str)
    {
        Temp.setText("Température : " + str + "°C");
        this.repaint();
    }

    public void updateHum(String str)
    {
        Hum.setText("Humidité : " + str + "%");
        this.repaint();
    }

    public void updateTab(int[] tab)
    {
        pan.setTabTemp(tab);
        this.repaint();
    }


}