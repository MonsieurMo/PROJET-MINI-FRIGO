package com.sdz.vue;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Etienne on 20/11/2017.
 */
public class Panel extends JPanel {

    int[] tabTemp;
    int[] tabHum;

    public Panel()
    {
        tabTemp = new int[121];
        tabHum = new int[121];
    }

    public void paintComponent(Graphics g)
    {

        g.drawRect(5,28,200,40);
        g.drawRect(205,28,290,40);
        g.drawRect(495,28,170,40);

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
        g2d.fillRect(8,95,364,183);

        //Tracage des lignes blanche
        g2d.setColor(Color.white);
        g2d.drawLine(8,275-30,371,275-30);//5
        g2d.drawLine(8,275-60,371,275-60);//10
        g2d.drawLine(8,275-90,371,275-90);//15
        g2d.drawLine(8,275-120,371,275-120);//20
        g2d.drawLine(8,275-150,371,275-150);//25


        //Set de la coleur pour le trait
        g2d.setColor(Color.red);
        g2d.setStroke(s1);

        //Graph 1 :
        for (int i=0;i<120;i++)
        {
            comptY1 = 275-(tabTemp[i]*6);
            comptY2 = 275-(tabTemp[i+1]*6);

            g2d.drawLine(comptX1,comptY1,comptX2,comptY2);

            comptX1 +=3;
            comptX2 +=3;
        }

    }

    public void paintGraph2(Graphics g)
    {
        int comptX1 = 10;
        int comptX2 = 13;

        int comptY1 = 515;
        int comptY2 = 515;

        //Creation de la fomre 2D
        Graphics2D g2d = (Graphics2D)g.create();

        //Set de l'épaisseur du trait et affectation
        Stroke s1 = new BasicStroke(2);
        g2d.setStroke(s1);

        //Crétion du rectangle
        g.fillRect(8,335,364,183);

        //Tracage des lignes blanche
        g2d.setColor(Color.white);
        g2d.drawLine(8,515-32,371,515-32);
        g2d.drawLine(8,515-72,371,515-72);
        g2d.drawLine(8,515-108,371,515-108);
        g2d.drawLine(8,515-144,371,515-144);

        //Set de la coleur pour le trait
        g2d.setColor(Color.red);

        //Graph 1 :
        for (int i=0;i<120;i++)
        {
            comptY1 = 515-(Math.round(tabHum[i]*1.8f));
            comptY2 = 515-(Math.round(tabHum[i+1]*1.8f));

            g2d.drawLine(comptX1,comptY1,comptX2,comptY2);

            comptX1 +=3;
            comptX2 +=3;
        }

    }

    public void setTabTemp(int[] tabTemp)
    {
        this.tabTemp = tabTemp;

    }

    public void setTabHum(int[] tabHum)
    {
        this.tabHum = tabHum;

    }



}
