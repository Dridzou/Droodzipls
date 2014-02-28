package com.supinfo.projet.objets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Hugo on 28/02/14.
 */
public class Plateau
{
    public int hauteur;
    public int largeur;

    public Plateau(int hauteur, int largeur)
    {
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    public int getHauteur()
    {
        return hauteur;
    }

    public void setHauteur(int hauteur)
    {
        this.hauteur = hauteur;
    }

    public int getLargeur()
    {
        return largeur;
    }

    public void setLargeur(int largeur)
    {
        this.largeur = largeur;
    }

    public void display(int hauteur, int largeur)
    {
        byte[] buffer = new byte[138];
        FileInputStream fis = null;

        try
        {
            fis = new FileInputStream("src/level1.txt");
            fis.read(buffer);
            String content = new String(buffer);
            String[][] map = new String[30][30];
            String[] tabSplit = content.split("!");

            int nbrLign = tabSplit.length ;
            for(int j = 0; j < nbrLign - 1; j++)
            {
                for (int i = 0; i < 20; i++)
                {
                    String tabSplitSpl[] = tabSplit[j].split("");
                    map[i][j] =  tabSplitSpl[i];
                }
            }

            for(int j = 0; j < nbrLign - 1; j++)
            {
                for(int i=0; i < 20; i++)
                {
                    System.out.print(map[i][j]);
                }
            }
        }

        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch (IOException e)
        {
            System.out.println("Unable to read or write the file");
        }
    }
}
