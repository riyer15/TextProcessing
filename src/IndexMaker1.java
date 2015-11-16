/*
 * This program takes a text file, creates an index (by line numbers)
 * for all the words in the file and writes the index
 * into the output file.  The program takes input and output file names
 * from the command-line args or prompts the user for the file names.
 * basically the equivalent of a test class!
 * 
 */

import java.util.Scanner;
import java.io.*;

public class IndexMaker1
{
  public static DocumentIndex1 preProcess() throws IOException
  {
    Scanner keyboard = new Scanner(System.in);
    String fileName;
    System.out.print("\nEnter input file name: ");
    fileName = keyboard.nextLine().trim();

    BufferedReader inputFile =
                 new BufferedReader(new FileReader(fileName), 1024);

    DocumentIndex1 index = new DocumentIndex1();

    String line;
    int lineNum = 0;
    while ((line = inputFile.readLine()) != null)
    {
      lineNum++;
      index.addAllWords(line);
    }
    return index;
  }
  

}
