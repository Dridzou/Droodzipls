/**
 * Created by Hugo on 25/02/14.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

        byte[] buffer = new byte[138];
        FileInputStream fis = null;

        try
        {
            fis = new FileInputStream("src/test_input.txt");
            fis.read(buffer);
            String content = new String(buffer);
            String[][] map = new String[30][30];
            String[] tabSplit = content.split("!");

            //for (int i = 0; i < tabSplit.length; i++)
            //{
            //    String LineOne = tabSplit[i];

            //}




            int nbrLign = tabSplit.length ;
            for(int j = 0; j < nbrLign - 1; j++)
            {
                for (int i = 0; i < 30; i++)
                {
                    String tabSplitSpl[] = tabSplit[j].split("");
                    map[i][j] =  tabSplitSpl[i];
                }
            }


            System.out.println(content);

//            for(int i=0; i<25; i++)
//            {
//                tab[0][i] = tabinter[i];
//            }
//
//            for(int i=0; i<25; i++)
//            {
//                for(int j = 0; j< 2; j++)
//                {
//                    System.out.println(tab[i][j]);
//                }
//            }
//
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