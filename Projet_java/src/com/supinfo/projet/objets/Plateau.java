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
    public void loadMap (Cases[][] gameMap)
    {
        byte[] buffer = new byte[138];
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream("src/level1.txt");
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
