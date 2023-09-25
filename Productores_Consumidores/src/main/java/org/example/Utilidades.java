package org.example;

public class Utilidades {
public static int numAzar(int max){
        return (int) (Math.random()*max);
    }
    public static void esperarTiempoAzar(int max){
        int tiempoAzar=(int) (Math.random()*max);
        try {
            Thread.sleep(tiempoAzar);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
