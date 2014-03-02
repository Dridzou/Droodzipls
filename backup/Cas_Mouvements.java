package com.supinfo.projet.objets;

/**
 * Created by Hugo on 27/02/14.
 */


import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import sun.org.mozilla.javascript.tools.shell.Global;

import javax.swing.*;


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
        GlobalScreen.getInstance().addNativeKeyListener(playa);

    }



    public void mouvement(Cases [][] caseslol, int [] coordtab){




            int x = coordtab[0];
            int y = coordtab[1];

            //Déplacement vers le HAUT
            if (DernierInput.equals("Haut") || DernierInput.equals("z")) {

                // case du dessus vide
               if (caseslol[x-1][y].statut.equals(" ")){

                   caseslol[x-1][y].statut = "X";
                   if(caseslol[x][y].statut.equals("X")){
                       caseslol[x][y].statut = " ";
                   }
                   else if(caseslol[x][y].statut.equals("G")){
                       caseslol[x][y].statut = "O";
                   }

               }else if (caseslol[x-1][y].statut.equals("O")){

                    caseslol[x-1][y].statut = "G";

                    if(caseslol[x][y].statut.equals("X")){
                        caseslol[x][y].statut = " ";
                    }
                   else if(caseslol[x][y].statut.equals("G")){
                        caseslol[x][y].statut = "O";
                    }


                   //case au dessus caisse
               }else if (caseslol[x-1][y].statut.equals("B")){

                   //case au dessus de la caisse vide
                  if (caseslol[x-2][y].statut.equals(" ")){

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
                      caseslol[x-1][y].statut = "X";
                      if (caseslol[x][y].statut.equals("X")){

                          caseslol[x][y].statut = " ";

                      }else {
                          caseslol[x][y].statut = "O";
                      }
               }else if (caseslol[x-1][y].statut.equals("8")){

                      //case au dessus de la caisse vide
                      if (caseslol[x-2][y].statut.equals(" ")){

                          caseslol[x-2][y].statut = "B";
                          caseslol[x-1][y].statut = "G";
                          //
                          if (caseslol[x][y].statut.equals("X")){

                              caseslol[x][y].statut = " ";

                          }else if (caseslol[x][y].statut.equals("G")) {

                              caseslol[x][y].statut = "O";

                          }
                          //case au dessus de la caisse = cible
                      }else if (caseslol[x-2][y].statut.equals("O")){

                          caseslol[x-2][y].statut = "8";
                          caseslol[x-1][y].statut = "G";
                          if (caseslol[x][y].statut.equals("X")){

                              caseslol[x][y].statut = " ";

                          }else {
                              caseslol[x][y].statut = "O";

                  }
                }


    ////////////////////////////////////////////////////////////////////////////////////////////
        }else if (DernierInput.equals("Bas") || DernierInput.equals("s")) {

              // case du dessus vide
              if (caseslol[x+1][y].statut.equals(" ")){

                  caseslol[x+1][y].statut = "X";
                  if(caseslol[x][y].statut.equals("X")){
                      caseslol[x][y].statut = " ";
                  }
                  else if(caseslol[x][y].statut.equals("G")){
                      caseslol[x][y].statut = "O";
                  }

              }else if (caseslol[x+1][y].statut.equals("O")){

                  caseslol[x+1][y].statut = "G";

                  if(caseslol[x][y].statut.equals("X")){
                      caseslol[x][y].statut = " ";
                  }
                  else if(caseslol[x][y].statut.equals("G")){
                      caseslol[x][y].statut = "O";
                  }


                  //case au dessus caisse
              }else if (caseslol[x+1][y].statut.equals("B")){

                  //case au dessus de la caisse vide
                  if (caseslol[x+2][y].statut.equals(" ")){

                      caseslol[x+2][y].statut = "B";
                      caseslol[x+1][y].statut = "X";
                      //
                      if (caseslol[x][y].statut.equals("X")){

                          caseslol[x][y].statut = " ";

                      }else if (caseslol[x][y].statut.equals("G")) {

                          caseslol[x][y].statut = "O";

                      }
                      //case au dessus de la caisse = cible
                  }else if (caseslol[x+2][y].statut.equals("O")){

                      caseslol[x+2][y].statut = "8";
                      caseslol[x+1][y].statut = "X";
                      if (caseslol[x][y].statut.equals("X")){

                          caseslol[x][y].statut = " ";

                      }else {
                          caseslol[x][y].statut = "O";
                      }
                  }else if (caseslol[x+1][y].statut.equals("8")){

                      //case au dessus de la caisse vide
                      if (caseslol[x+2][y].statut.equals(" ")){

                          caseslol[x+2][y].statut = "B";
                          caseslol[x+1][y].statut = "G";
                          //
                          if (caseslol[x][y].statut.equals("X")){

                              caseslol[x][y].statut = " ";

                          }else if (caseslol[x][y].statut.equals("G")) {

                              caseslol[x][y].statut = "O";

                          }
                          //case au dessus de la caisse = cible
                      }else if (caseslol[x+2][y].statut.equals("O")){

                          caseslol[x+2][y].statut = "8";
                          caseslol[x+1][y].statut = "G";
                          if (caseslol[x][y].statut.equals("X")){

                              caseslol[x][y].statut = " ";

                          }else {
                              caseslol[x][y].statut = "O";

                          }
                      }

////////////////////////////////////////////////////////////////////////////////////
        }else if (DernierInput.equals("Gauche") || DernierInput.equals("q")){


              // case du dessus vide
              if (caseslol[x][y-1].statut.equals(" ")){

                  caseslol[x][y-1].statut = "X";
                  if(caseslol[x][y].statut.equals("X")){
                      caseslol[x][y].statut = " ";
                  }
                  else if(caseslol[x][y].statut.equals("G")){
                      caseslol[x][y].statut = "O";
                  }

              }else if (caseslol[x][y-1].statut.equals("O")){

                  caseslol[x][y-1].statut = "G";

                  if(caseslol[x][y].statut.equals("X")){
                      caseslol[x][y].statut = " ";
                  }
                  else if(caseslol[x][y].statut.equals("G")){
                      caseslol[x][y].statut = "O";
                  }


                  //case au dessus caisse
              }else if (caseslol[x][y-1].statut.equals("B")){

                  //case au dessus de la caisse vide
                  if (caseslol[x][y-2].statut.equals(" ")){

                      caseslol[x][y-2].statut = "B";
                      caseslol[x][y-1].statut = "X";
                      //
                      if (caseslol[x][y].statut.equals("X")){

                          caseslol[x][y].statut = " ";

                      }else if (caseslol[x][y].statut.equals("G")) {

                          caseslol[x][y].statut = "O";

                      }
                      //case au dessus de la caisse = cible
                  }else if (caseslol[x][y-2].statut.equals("O")){

                      caseslol[x][y-2].statut = "8";
                      caseslol[x][y-1].statut = "X";
                      if (caseslol[x][y].statut.equals("X")){

                          caseslol[x][y].statut = " ";

                      }else {
                          caseslol[x][y].statut = "O";
                      }
                  }else if (caseslol[x][y-1].statut.equals("8")){

                      //case au dessus de la caisse vide
                      if (caseslol[x][y-2].statut.equals(" ")){

                          caseslol[x][y-2].statut = "B";
                          caseslol[x][y-1].statut = "G";
                          //
                          if (caseslol[x][y].statut.equals("X")){

                              caseslol[x][y].statut = " ";

                          }else if (caseslol[x][y].statut.equals("G")) {

                              caseslol[x][y].statut = "O";

                          }
                          //case au dessus de la caisse = cible
                      }else if (caseslol[x][y-2].statut.equals("O")){

                          caseslol[x][y-2].statut = "8";
                          caseslol[x][y-1].statut = "G";
                          if (caseslol[x][y].statut.equals("X")){

                              caseslol[x][y].statut = " ";

                          }else {
                              caseslol[x][y].statut = "O";

                          }
                      }




///////////////////////////////////////////////////////////////////////////////////
        }else if (DernierInput.equals("Droite") || DernierInput.equals("d")){

	              // case du dessus vide
              if (caseslol[x][y+1].statut.equals(" ")){

                  caseslol[x][y+1].statut = "X";
                  if(caseslol[x][y].statut.equals("X")){
                      caseslol[x][y].statut = " ";
                  }
                  else if(caseslol[x][y].statut.equals("G")){
                      caseslol[x][y].statut = "O";
                  }

              }else if (caseslol[x][y+1].statut.equals("O")){

                  caseslol[x][y+1].statut = "G";

                  if(caseslol[x][y].statut.equals("X")){
                      caseslol[x][y].statut = " ";
                  }
                  else if(caseslol[x][y].statut.equals("G")){
                      caseslol[x][y].statut = "O";
                  }


                  //case au dessus caisse
              }else if (caseslol[x][y+1].statut.equals("B")){

                  //case au dessus de la caisse vide
                  if (caseslol[x][y+2].statut.equals(" ")){

                      caseslol[x][y+2].statut = "B";
                      caseslol[x][y+1].statut = "X";
                      //
                      if (caseslol[x][y].statut.equals("X")){

                          caseslol[x][y].statut = " ";

                      }else if (caseslol[x][y].statut.equals("G")) {

                          caseslol[x][y].statut = "O";

                      }
                      //case au dessus de la caisse = cible
                  }else if (caseslol[x][y+2].statut.equals("O")){

                      caseslol[x][y+2].statut = "8";
                      caseslol[x][y+1].statut = "X";
                      if (caseslol[x][y].statut.equals("X")){

                          caseslol[x][y].statut = " ";

                      }else {
                          caseslol[x][y].statut = "O";
                      }
                  }else if (caseslol[x][y+1].statut.equals("8")){

                      //case au dessus de la caisse vide
                      if (caseslol[x][y+2].statut.equals(" ")){

                          caseslol[x][y+2].statut = "B";
                          caseslol[x][y+1].statut = "G";
                          //
                          if (caseslol[x][y].statut.equals("X")){

                              caseslol[x][y].statut = " ";

                          }else if (caseslol[x][y].statut.equals("G")) {

                              caseslol[x][y].statut = "O";

                          }
                          //case au dessus de la caisse = cible
                      }else if (caseslol[x][y+2].statut.equals("O")){

                          caseslol[x][y+2].statut = "8";
                          caseslol[x][y+1].statut = "G";
                          if (caseslol[x][y].statut.equals("X")){

                              caseslol[x][y].statut = " ";

                          }else {
                              caseslol[x][y].statut = "O";

                          }
                      }




        }else if (DernierInput.equals("Echap")){
            //retour menu


        }else if (DernierInput.equals("R")){

            //reset map


       }

    }
}
