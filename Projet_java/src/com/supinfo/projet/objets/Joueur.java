package com.supinfo.projet.objets;

/**
 * Created by Hugo on 27/02/14.
 */


import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;


public class Joueur implements NativeKeyListener
{
    public int coordx;
    public int coordy;
    public String DernierInput;

    public Joueur(int coordx, int coordy) {
        this.coordx = coordx;
        this.coordy = coordy;
    }

    public int getCoordx() {
        return coordx;
    }

    public void setCoordx(int coordx) {
        this.coordx = coordx;
    }

    public int getCoordy() {
        return coordy;
    }

    public void setCoordy(int coordy) {
        this.coordy = coordy;
    }


    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        DernierInput = NativeKeyEvent.getKeyText(e.getKeyCode());



        if (e.getKeyCode() == NativeKeyEvent.VK_ESCAPE) {
            GlobalScreen.unregisterNativeHook();
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        ///  System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        // System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }

    public static void input() {
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        //Construct the example object and initialze native hook.
        GlobalScreen.getInstance().addNativeKeyListener(new Joueur(0,0));
    }


    public void mouvement(){


        if (DernierInput.equals("Haut") || DernierInput.equals("z")) {

            //

        }else if (DernierInput.equals("Bas") || DernierInput.equals("s")) {



        }else if (DernierInput.equals("Gauche") || DernierInput.equals("q")){



        }else if (DernierInput.equals("Droite") || DernierInput.equals("d")){




        }else if (DernierInput.equals("Echap")){
            //retour menu


        }else if (DernierInput.equals("R")){

            //reset map


        }





    }

}
