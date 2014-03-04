package com.supinfo.projet.objets;

/**
 * Created by Hugo on 27/02/14.
 */


import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import java.util.Scanner;



public class Joueur implements NativeKeyListener
{
    public int coordx;
    public int coordy;
    public String DernierInput;

    public Joueur(int coordx, int coordy) {
        this.coordx = coordx;
        this.coordy = coordy;
    }

    static Joueur playa = new Joueur (0,0);
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
        //  System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));


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

    }

    public void MouvScan(Cases [][] caseslol, int [] coordtab)
    {
        int varx = 0;
        int vary = 0;

        int x = coordtab[0];
        int y = coordtab[1];

        Scanner sc = new Scanner(System.in);
        String dir = "";

        //verifReset = false;


        do
        {
            System.out.println("Entrer une direction: \n(haut ou z, bas ou s, gauche ou q, droite ou d, echap pour un retour au menu, r pour reset la map)");
            dir = sc.nextLine().toLowerCase();
            System.out.println(dir);
            if (!dir.isEmpty() && !dir.equals("haut") && !dir.equals("z") && !dir.equals("bas") && !dir.equals("s") && !dir.equals("gauche") && !dir.equals("q") && dir.equals("droite") && dir.equals("d"))
            {
                System.out.println("Données invalides !");
            }
        }
        while(!dir.equals("haut") && !dir.equals("z") && !dir.equals("bas") && !dir.equals("s") && !dir.equals("gauche") && !dir.equals("q") && dir.equals("droite") && dir.equals("d") && !dir.equals("r"));


        if (dir.equals("gauche") || dir.equals("q"))
        {
            // case du dessus vide
            if (caseslol[x-1][y].statut.equals(" "))
            {

                caseslol[x-1][y].statut = "X";
                if(caseslol[x][y].statut.equals("X")){
                    caseslol[x][y].statut = " ";
                }
                else if(caseslol[x][y].statut.equals("G")){
                    caseslol[x][y].statut = "O";
                }

            }

            else if (caseslol[x-1][y].statut.equals("O")){

                caseslol[x-1][y].statut = "G";

                if(caseslol[x][y].statut.equals("X")){
                    caseslol[x][y].statut = " ";
                }
                else if(caseslol[x][y].statut.equals("G")){
                    caseslol[x][y].statut = "O";
                }


                //case au dessus caisse
            }
            else if (caseslol[x-1][y].statut.equals("B"))
            {

                //case au dessus de la caisse vide
                if (caseslol[x-2][y].statut.equals(" "))
                {

                    caseslol[x-2][y].statut = "B";
                    caseslol[x-1][y].statut = "X";
                    //
                    if (caseslol[x][y].statut.equals("X")){

                        caseslol[x][y].statut = " ";

                    }else if (caseslol[x][y].statut.equals("G")) {

                        caseslol[x][y].statut = "O";

                    }
                    //case au dessus de la caisse = cible
                }else if (caseslol[x-2][y].statut.equals("O")){

                    caseslol[x-2][y].statut = "8";
                    coordtab[3]++;
                    caseslol[x-1][y].statut = "X";
                    if (caseslol[x][y].statut.equals("X")){

                        caseslol[x][y].statut = " ";

                    }else {
                        caseslol[x][y].statut = "O";
                    }
                }
                }
                else if (caseslol[x-1][y].statut.equals("8")){
                    coordtab[3]--;
                    //case au dessus de la caisse vide
                    if (caseslol[x-2][y].statut.equals(" ")){

                        caseslol[x-2][y].statut = "B";
                        caseslol[x-1][y].statut = "G";
                        //
                        if (caseslol[x][y].statut.equals("X")){

                            caseslol[x][y].statut = " ";

                        }
                        else if (caseslol[x][y].statut.equals("G")) {

                            caseslol[x][y].statut = "O";

                        }
                        //case au dessus de la caisse = cible
                    }
                    else if (caseslol[x-2][y].statut.equals("O")){

                        caseslol[x-2][y].statut = "8";
                        coordtab[3]++;
                        caseslol[x-1][y].statut = "G";
                        if (caseslol[x][y].statut.equals("X")){

                            caseslol[x][y].statut = " ";

                        }
                        else {
                            caseslol[x][y].statut = "O";

                        }
                    }
                }

            if (caseslol[x-1][y].statut.equals("=") ||
                    (caseslol[x-1][y].statut.equals("B") && caseslol[x-2][y].statut.equals("=")) ||
                    (caseslol[x-1][y].statut.equals("B") && caseslol[x-2][y].statut.equals("B")) ||
                    (caseslol[x-1][y].statut.equals("B") && caseslol[x-2][y].statut.equals("8")) ||
                    (caseslol[x-1][y].statut.equals("8") && caseslol[x-2][y].statut.equals("=")) ||
                    (caseslol[x-1][y].statut.equals("8") && caseslol[x-2][y].statut.equals("B")) ||
                    (caseslol[x-1][y].statut.equals("8") && caseslol[x-2][y].statut.equals("8")))
            {}
            else
            {
                coordtab[0]--;
            }

        }
        else if (dir.equals("droite") || dir.equals("d"))
        {
            // case du dessus vide
            if (caseslol[x+1][y].statut.equals(" "))
            {
                caseslol[x+1][y].statut = "X";
                if(caseslol[x][y].statut.equals("X"))
                {
                    caseslol[x][y].statut = " ";
                }
                else if(caseslol[x][y].statut.equals("G"))
                {
                    caseslol[x][y].statut = "O";
                }
            }
            else if (caseslol[x+1][y].statut.equals("O"))
            {
                caseslol[x+1][y].statut = "G";

                if(caseslol[x][y].statut.equals("X"))
                {
                    caseslol[x][y].statut = " ";
                }
                else if(caseslol[x][y].statut.equals("G"))
                {
                    caseslol[x][y].statut = "O";
                }


                //case au dessus caisse
            }
            else if (caseslol[x+1][y].statut.equals("B"))
            {
                //case au dessus de la caisse vide
                if (caseslol[x+2][y].statut.equals(" "))
                {
                    caseslol[x+2][y].statut = "B";
                    caseslol[x+1][y].statut = "X";
                    //
                    if (caseslol[x][y].statut.equals("X"))
                    {
                        caseslol[x][y].statut = " ";

                    }
                    else if (caseslol[x][y].statut.equals("G"))
                    {
                        caseslol[x][y].statut = "O";
                    }
                    //case au dessus de la caisse = cible
                }
                else if (caseslol[x+2][y].statut.equals("O"))
                {
                    caseslol[x+2][y].statut = "8";
                    coordtab[3]++;
                    caseslol[x+1][y].statut = "X";
                    if (caseslol[x][y].statut.equals("X"))
                    {
                        caseslol[x][y].statut = " ";
                    }
                    else
                    {
                        caseslol[x][y].statut = "O";
                    }
                }
            }
                else if (caseslol[x+1][y].statut.equals("8"))
                {
                    coordtab[3]--;
                    //case au dessus de la caisse vide
                    if (caseslol[x+2][y].statut.equals(" "))
                    {
                        caseslol[x+2][y].statut = "B";
                        caseslol[x+1][y].statut = "G";
                        //
                        if (caseslol[x][y].statut.equals("X"))
                        {
                            caseslol[x][y].statut = " ";
                        }
                        else if (caseslol[x][y].statut.equals("G"))
                        {
                            caseslol[x][y].statut = "O";
                        }
                        //case au dessus de la caisse = cible
                    }
                    else if (caseslol[x+2][y].statut.equals("O"))
                    {
                        caseslol[x+2][y].statut = "8";
                        coordtab[3]++;
                        caseslol[x+1][y].statut = "G";
                        if (caseslol[x][y].statut.equals("X"))
                        {
                            caseslol[x][y].statut = " ";
                        }
                        else
                        {
                            caseslol[x][y].statut = "O";
                        }
                    }
                }

            if ((caseslol[x+1][y].statut.equals("=")) ||
                    ((caseslol[x+1][y].statut.equals("B")) && (caseslol[x+2][y].statut.equals("="))) ||
                    ((caseslol[x+1][y].statut.equals("B")) && (caseslol[x+2][y].statut.equals("B"))) ||
                    ((caseslol[x+1][y].statut.equals("B")) && (caseslol[x+2][y].statut.equals("8"))) ||
                    ((caseslol[x+1][y].statut.equals("8")) && (caseslol[x+2][y].statut.equals("="))) ||
                    ((caseslol[x+1][y].statut.equals("8")) && (caseslol[x+2][y].statut.equals("B"))) ||
                    ((caseslol[x+1][y].statut.equals("8")) && (caseslol[x+2][y].statut.equals("8"))))
            {}
            else
            {
                coordtab[0]++;
            }
        }
        else if (dir.equals("haut") || dir.equals("z"))
        {
            // case du dessus vide
            if (caseslol[x][y-1].statut.equals(" "))
            {
                caseslol[x][y-1].statut = "X";
                if(caseslol[x][y].statut.equals("X"))
                {
                    caseslol[x][y].statut = " ";
                }
                else if(caseslol[x][y].statut.equals("G"))
                {
                    caseslol[x][y].statut = "O";
                }

            }
            //case du dessus cible
            else if (caseslol[x][y-1].statut.equals("O"))
            {
                caseslol[x][y-1].statut = "G";

                if(caseslol[x][y].statut.equals("X"))
                {
                    caseslol[x][y].statut = " ";
                }
                else if(caseslol[x][y].statut.equals("G"))
                {
                    caseslol[x][y].statut = "O";
                }

                //case au dessus caisse
            }
            else if (caseslol[x][y-1].statut.equals("B"))
            {
                //case au dessus de la caisse vide
                if (caseslol[x][y-2].statut.equals(" "))
                {

                    caseslol[x][y-2].statut = "B";
                    caseslol[x][y-1].statut = "X";
                    //
                    if (caseslol[x][y].statut.equals("X"))
                    {

                        caseslol[x][y].statut = " ";

                    }
                    else if (caseslol[x][y].statut.equals("G"))
                    {
                        caseslol[x][y].statut = "O";
                    }
                    //case au dessus de la caisse = cible
                }
                else if (caseslol[x][y-2].statut.equals("O"))
                {
                    caseslol[x][y-2].statut = "8";
                    coordtab[3]++;
                    caseslol[x][y-1].statut = "X";
                    if (caseslol[x][y].statut.equals("X"))
                    {
                        caseslol[x][y].statut = " ";
                    }
                    else
                    {
                        caseslol[x][y].statut = "O";
                    }
                }
            }
            else if (caseslol[x][y-1].statut.equals("8"))
            {
                coordtab[3]--;
                //case au dessus de la caisse vide
                if (caseslol[x][y-2].statut.equals(" "))
                {
                    caseslol[x][y-2].statut = "B";
                    caseslol[x][y-1].statut = "G";
                    //
                    if (caseslol[x][y].statut.equals("X"))
                    {
                        caseslol[x][y].statut = " ";
                    }
                    else if (caseslol[x][y].statut.equals("G"))
                    {
                        caseslol[x][y].statut = "O";
                    }
                    //case au dessus de la caisse = cible
                }
                else if (caseslol[x][y-2].statut.equals("O"))
                {
                    caseslol[x][y-2].statut = "8";
                    coordtab[3]++;
                    caseslol[x][y-1].statut = "G";
                    if (caseslol[x][y].statut.equals("X"))
                    {
                        caseslol[x][y].statut = " ";
                    }
                    else
                    {
                        caseslol[x][y].statut = "O";
                    }
                }
            }
            if (caseslol[x][y-1].statut.equals("=") ||
                    (caseslol[x][y-1].statut.equals("B") && caseslol[x][y-2].statut.equals("=")) ||
                    (caseslol[x][y-1].statut.equals("B") && caseslol[x][y-2].statut.equals("B")) ||
                    (caseslol[x][y-1].statut.equals("B") && caseslol[x][y-2].statut.equals("8")) ||
                    (caseslol[x][y-1].statut.equals("8") && caseslol[x][y-2].statut.equals("=")) ||
                    (caseslol[x][y-1].statut.equals("8") && caseslol[x][y-2].statut.equals("B")) ||
                    (caseslol[x][y-1].statut.equals("8") && caseslol[x][y-2].statut.equals("8")))
            {}
            else
            {
                coordtab[1]--;
            }
        }
        else if (dir.equals("bas") || dir.equals("s"))
        {
            // case du dessus vide
            if (caseslol[x][y+1].statut.equals(" "))
            {
                caseslol[x][y+1].statut = "X";
                if(caseslol[x][y].statut.equals("X"))
                {
                    caseslol[x][y].statut = " ";
                }
                else if(caseslol[x][y].statut.equals("G"))
                {
                    caseslol[x][y].statut = "O";
                }
            }
            else if (caseslol[x][y+1].statut.equals("O"))
            {
                caseslol[x][y+1].statut = "G";

                if(caseslol[x][y].statut.equals("X"))
                {
                    caseslol[x][y].statut = " ";
                }
                else if(caseslol[x][y].statut.equals("G"))
                {
                    caseslol[x][y].statut = "O";
                }

                //case au dessus caisse
            }
            else if (caseslol[x][y+1].statut.equals("B"))
            {
                //case au dessus de la caisse vide
                if (caseslol[x][y+2].statut.equals(" "))
                {
                    caseslol[x][y+2].statut = "B";
                    caseslol[x][y+1].statut = "X";
                    //
                    if (caseslol[x][y].statut.equals("X"))
                    {
                        caseslol[x][y].statut = " ";
                    }
                    else if (caseslol[x][y].statut.equals("G"))
                    {
                        caseslol[x][y].statut = "O";
                    }
                    //case au dessus de la caisse = cible
                }
                else if (caseslol[x][y+2].statut.equals("O"))
                {
                    caseslol[x][y+2].statut = "8";
                    coordtab[3]++;
                    caseslol[x][y+1].statut = "X";
                    if (caseslol[x][y].statut.equals("X"))
                    {
                        caseslol[x][y].statut = " ";
                    }
                    else
                    {
                        caseslol[x][y].statut = "O";
                    }
                }
                else if (caseslol[x][y+1].statut.equals("8"))
                {
                    coordtab[3]--;
                    //case au dessus de la caisse vide
                    if (caseslol[x][y+2].statut.equals(" "))
                    {
                        caseslol[x][y+2].statut = "B";
                        caseslol[x][y+1].statut = "G";
                        //
                        if (caseslol[x][y].statut.equals("X"))
                        {
                            caseslol[x][y].statut = " ";
                        }
                        else if (caseslol[x][y].statut.equals("G"))
                        {
                            caseslol[x][y].statut = "O";
                        }
                        //case au dessus de la caisse = cible
                    }
                    else if (caseslol[x][y+2].statut.equals("O"))
                    {
                        caseslol[x][y+2].statut = "8";
                        coordtab[3]++;
                        caseslol[x][y+1].statut = "G";
                        if (caseslol[x][y].statut.equals("X"))
                        {
                            caseslol[x][y].statut = " ";
                        }
                        else
                        {
                            caseslol[x][y].statut = "O";
                        }
                    }
                }
            }

            if (caseslol[x][y+1].statut.equals("=") ||
                        (caseslol[x][y+1].statut.equals("B") && caseslol[x][y+2].statut.equals("=")) ||
                        (caseslol[x][y+1].statut.equals("B") && caseslol[x][y+2].statut.equals("B")) ||
                        (caseslol[x][y+1].statut.equals("B") && caseslol[x][y+2].statut.equals("8")) ||
                        (caseslol[x][y+1].statut.equals("8") && caseslol[x][y+2].statut.equals("=")) ||
                        (caseslol[x][y+1].statut.equals("8") && caseslol[x][y+2].statut.equals("B")) ||
                        (caseslol[x][y+1].statut.equals("8") && caseslol[x][y+2].statut.equals("8")))
            {}
            else
            {
                coordtab[1] ++;
            }
        }
        else if(dir.equals("r"))
        {
            coordtab[4] = 1;
        }
    }
}