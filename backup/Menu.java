package com.supinfo.projet.objets;

import java.util.*;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.*;
import com.supinfo.projet.main.Launcher;

/**
 * Created by Romain on 01/03/14.
 */

public class Menu // implements NativeKeyListener
{

    public void displayMenu()
    {
        System.out.println( " _____       _         _                 \n" +
                            "/  ___|     | |       | |                \n" +
                            "\\ `--.  ___ | | _____ | |__   __ _ _ __  \n" +
                            " `--. \\/ _ \\| |/ / _ \\| '_ \\ / _` | '_ \\ \n" +
                            "/\\__/ / (_) |   < (_) | |_) | (_| | | | |\n" +
                            "\\____/ \\___/|_|\\_\\___/|_.__/ \\__,_|_| |_|\n");
        System.out.println("Appuyez sur Entrée pour jouer, Echap pour quitter.");

        Scanner sc = new Scanner(System.in);
        String start;

        do
        {
            start = sc.nextLine();
            if (!start.isEmpty() && !start.equals("x") && !start.equals(""))
            {
                System.out.println("Appuyez sur Entrée pour jouer, Echap pour quitter.");
            }
        }
        while (!start.equals("") && !start.equals("x"));

        if (start.equals("x"))
        {
            System.exit(1);
        }
    }


    /*public static void input()
    {
        try
        {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex)
        {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }
        //Construct the example object and initialze native hook.
        GlobalScreen.getInstance().addNativeKeyListener(new Menu());
    }

    public void nativeKeyPressed(NativeKeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case NativeKeyEvent.VK_ESCAPE :
                //System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
                GlobalScreen.unregisterNativeHook();
                break;

            case NativeKeyEvent.VK_ENTER :
                //System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
                // GlobalScreen.
                break;

        }
    }

    public void nativeKeyReleased(NativeKeyEvent e)
    {
        //System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public void nativeKeyTyped(NativeKeyEvent e)
    {
        //
        // System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }*/
}
