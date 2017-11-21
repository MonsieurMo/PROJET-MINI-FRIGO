package com.sdz.vue;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Etienne on 20/11/2017.
 */
public class Panel extends JPanel {

    int[] tabTemp;

    public Panel()
    {
        tabTemp = new int[121];
    }

    public void paintComponent(Graphics g)
    {
        //Graph 1 :
        paintGraph1(g);

        //Graph 2
        paintGraph2(g);


    }

    public void paintGraph1(Graphics g)
    {
        int comptX1 = 10;
        int comptX2 = 13;

        int comptY1;
        int comptY2;

        //Creation de la fomre 2D
        Graphics2D g2d = (Graphics2D)g.create();

        //Set de l'épaisseur du trait et affectation
        Stroke s1 = new BasicStroke(2);
        Stroke s2 = new BasicStroke(2);
        g2d.setStroke(s2);

        //Crétion du rectangle
        g2d.fillRect(8,75,364,183);

        //Tracage des lignes blanche
        g2d.setColor(Color.white);
        g2d.drawLine(8,255-30,371,255-30);//5
        g2d.drawLine(8,255-60,371,255-60);//10
        g2d.drawLine(8,255-90,371,255-90);//15
        g2d.drawLine(8,255-120,371,255-120);//20
        g2d.drawLine(8,255-150,371,255-150);//25


        //Set de la coleur pour le trait
        g2d.setColor(Color.red);
        g2d.setStroke(s1);

        //Graph 1 :
        for (int i=0;i<120;i++)
        {
            comptY1 = 255-(tabTemp[i]*6);
            comptY2 = 255-(tabTemp[i+1]*6);

            g2d.drawLine(comptX1,comptY1,comptX2,comptY2);

            comptX1 +=3;
            comptX2 +=3;
        }

    }

    public void paintGraph2(Graphics g)
    {
        int comptX1 = 10;
        int comptX2 = 13;

        int comptY1 = 450;
        int comptY2 = 450;

        //Creation de la fomre 2D
        Graphics2D g2d = (Graphics2D)g.create();

        //Set de l'épaisseur du trait et affectation
        Stroke s1 = new BasicStroke(2);
        g2d.setStroke(s1);

        //Crétion du rectangle
        g.fillRect(8,270,364,183);

        //Set de la coleur pour le trait
        g2d.setColor(Color.red);

        //Graph 1 :
        for (int i=0;i<120;i++)
        {
            //comptY1 = 450-(tab[i]*6);
            //comptY2 = 450-(tab[i+1]*6);

            g2d.drawLine(comptX1,comptY1,comptX2,comptY2);

            comptX1 +=3;
            comptX2 +=3;
        }

    }

    public void setTabTemp(int[] tabTemp)
    {
        this.tabTemp = tabTemp;

    }



}
