package com.supinfo.projet.main;

/**
 * Created by Hugo on 25/02/14.
 */

import com.supinfo.projet.objets.Plateau;

import java.io.FileReader;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Launcher
{
    public static void main(String[] args)
    {
        System.out.println("Projet de Java");
        System.out.println();

        Plateau monPlateau = new Plateau(20, 20);

        int nbrLign = 0;
        monPlateau.display(nbrLign, 20);
    }
}