
/* 
 * Author: Rani Iyer
 * This class takes in a DocumentIndex and creates a set of curves based 
 * on the frequency of words in the document
 * I consulted Processing's javadocs and tutorials for some aspects of this class. 
 * 
 */

import java.io.IOException;
import java.util.Scanner;

import processing.core.PApplet;
import processing.core.PFont;


public class DocProcessing extends PApplet 
{

  private int mid = 512/2;
  private int width = 30;
  private int cons = 700;
  private int threshold = 60;
  double total = 33.0;
  PFont Bebas;

  public static DocumentIndex1 preProcess(String myText) throws IOException
  {

    DocumentIndex1 index = new DocumentIndex1();
    index.addAllWords(myText);
    return index;
  }


  public void setup() 
  {
    Bebas = createFont("BebasNeueLight", 13);
    textFont(Bebas);
    noStroke();
    Scanner keyboard = new Scanner(System.in);
    System.out.print("\nEnter input text: ");
    String allWords = keyboard.nextLine().trim();
    allWords+= keyboard.nextLine().trim();
    System.out.print("\nEnter text title: ");
    String title = keyboard.nextLine().trim();
    DocumentIndex1 myIndex;
    try
    {
      myIndex = DocProcessing.preProcess(allWords);
    }
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return;
    }
    size(myIndex.size()*width+30, mid*2);
    background(51, 153, 153);
    smooth();
    stroke(255);
    noFill();
    for(int i = 0; i < myIndex.size(); i++)
    {
      int height1 = (int)(myIndex.get(i).getSize()/total*cons);
      if(i%2 != 0)
      {
        if(height1 > threshold)
        {
          stroke(233, 76, 92);
          text(myIndex.get(i).getWord(),30+i*width-width/3, mid - 100);
          arc(30+i*width, mid, width, height1,-PI, 0);
        }
        else
        {
          stroke(255);
          text(myIndex.get(i).getWord(),30+i*width-width/3, mid - 100);
          arc(30+i*width, mid, width, height1,-PI, 0);
        }
        
        
      }
      else
      {
        if(height1 > threshold)
        {
          stroke(233, 76, 92);
          text(myIndex.get(i).getWord(),30+i*width-width/2, mid + 100);
          arc(30+i*width, mid, width, height1,0, PI);
        }
        else
        {
          stroke(255);
          arc(30+i*width, mid, width, height1, 0, PI);
          text(myIndex.get(i).getWord(),30+i*width-width/2, mid+100);
        }
        

      }
    }
    textSize(68);
    text(title, 50, 100);
    stroke(146, 155, 155);
    line(0, mid, myIndex.size()*width+25, mid);
  }

}
