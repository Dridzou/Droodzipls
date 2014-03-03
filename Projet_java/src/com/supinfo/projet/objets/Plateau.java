package com.supinfo.projet.objets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Hugo on 28/02/14.
 */
public class Plateau
{

    int nbrLign2 = 0;
    public int[] loadMap (Cases[][] gameMap)
    {
        int[] tabVar = new int [5];
        tabVar[2] = 0;
        tabVar[3] = 0;
        tabVar[4] = 0;
        byte[] buffer = new byte[276];
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream("src/lvl1.txt");
            fis.read(buffer);
            String content = new String(buffer);
            String[] tabSplit = content.split("!");

            nbrLign2 = tabSplit.length ;
            for(int j = 0; j < nbrLign2 - 1; j++)
            {
                for (int i = 0; i < 20; i++)
                {
                    String tabSplitSpl[] = tabSplit[j].split("");
                    gameMap[i][j] = new Cases(" ");
                    gameMap[i][j].setStatut(tabSplitSpl[i]);
                    if (tabSplitSpl[i].equals("X"))
                    {
                        tabVar[0] = i;
                        tabVar[1] = j;
                    }
                    if (tabSplitSpl[i].equals("O"))
                    {
                        tabVar[2]++;
                    }
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
        return (tabVar);
    }

    public void displayMap (Cases gameMap[][])
    {
        for(int j = 0; j < nbrLign2 - 1; j++)
        {
            for(int i=0; i < 20; i++)
            {
                System.out.print(gameMap[i][j].statut);
            }
        }
    }


    public Plateau()
    {

    }


}
