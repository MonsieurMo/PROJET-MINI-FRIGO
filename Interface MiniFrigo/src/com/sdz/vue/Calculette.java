package com.sdz.vue;

import com.sdz.controler.AbstractControler;
import com.sdz.observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculette extends JFrame implements Observer {

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

    public Calculette(AbstractControler controler){

        //Creation de la fenetre
        this.setSize(700, 500);
        this.setTitle("Interface Frigo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        //Creation panel
        pan = new Panel();
        pan.setLayout(null);
        pan.setSize(800,550);
        this.setContentPane(pan);

        //Font
        Font f1 = new Font("f1",Font.BOLD,18);
        Font f2 = new Font("f1",Font.BOLD,14);

        //Label
        Temp.setBounds(10,10,200,30);
        Temp.setFont(f1);
        pan.add(Temp);

        Hum.setBounds(200,10,200,30);
        Hum.setFont(f1);
        pan.add(Hum);

        tempVoulu.setBounds(450,290,200,50);
        tempVoulu.setFont(f2);
        pan.add(tempVoulu);

        //Label graphique
        JLabel temp0 = new JLabel("0°C");
        temp0.setBounds(380,237,50,30);
        pan.add(temp0);

        JLabel temp10 = new JLabel("+10°C");
        temp10.setBounds(380,255-75,50,30);
        pan.add(temp10);

        JLabel temp20 = new JLabel("+20°C");
        temp20.setBounds(380,255-135,50,30);
        pan.add(temp20);

        JLabel temp30 = new JLabel("+30°C");
        temp30.setBounds(380,65,50,30);
        pan.add(temp30);


        //Text Field
        tempVouluField.setBounds(450,340,200,50);
        pan.add(tempVouluField);

        //Button
        update.setBounds(450,400,200,50);
        pan.add(update);

        update.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){

                //Action du bouton
                controler.setTempVoulu(Integer.parseInt(tempVouluField.getText()));
            }
        });


        //Attribution du controler
        this.controler = controler;

        //On rend la fenetre visible
        this.setVisible(true);
    }

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