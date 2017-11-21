package com.sdz.controler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;


import com.sdz.model.AbstractModel;

public class Controler extends AbstractControler implements SerialPortEventListener{

    public Controler(AbstractModel cal) {
        super(cal);
    }

    public void setTempVoulu(int nombre)
    {
        mod.setTempVoulu(nombre);
    }

    /** Lecture arduino */
    public void lecture()
    {
        initialize();
        Thread t=new Thread() {
            public void run() {
                //the following line will keep this app alive for 1000 seconds,
                //waiting for events to occur and responding to them (printing incoming messages to console).
                try {Thread.sleep(1000000);} catch (InterruptedException ie) {}
            }
        };
        t.start();
        System.out.println("Started");

    }

    SerialPort serialPort;
    /** Le port normalement utilisé. */
    private static final String PORT_NAMES[] = {
            "COM1", // Windows
            "COM2", // Windows
            "COM3", // Windows
            "COM4", // Windows
            "COM5", // Windows
            "COM6", // Windows
            "COM7", // Windows
            "COM8", // Windows
    };
    /**
     * BufferedReader contenant les displays de l'arduino
     */
    private BufferedReader input;
    /** The output stream to the port */
    private OutputStream output;
    /**Temps d'attente max en milliseconde pour l'ouverture du port*/
    private static final int TIME_OUT = 2000;
    /** Bit par seconde du Port COM*/
    private static final int DATA_RATE = 9600;

    public void initialize() {
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        //Instance du port COM et recherche.
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    break;
                }
            }
        }
        if (portId == null) {
            System.out.println("Le port n'à pas été trouvé");
            return;
        }

        try {
            //Ouverture du port si il a été trouvé
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);

            // Paramétrage du port
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // Ouverture du stream
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            // Ajout des events listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    /**
     * Méthode appellé lors de l'arret de l'usage du port
     */
    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    /**
     * Lit ce que l'arduino écrit et l'affiche
     */
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine=input.readLine();
                mod.setTemp(Integer.parseInt(inputLine));
                mod.setTabTemp(Integer.parseInt(inputLine));
                System.out.println(inputLine);
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        // Ignore les autres event
    }

}