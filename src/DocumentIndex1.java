/* 
 * Author: Rani Iyer
 * This class (and IndexEntry1) is a modified version of the DocumentIndex methods
 * we worked on as a class last term -- in my original project, I worked with Emma Kukielski
 * Therefore,I also used some of the help from the Java Methods Textbook
 * 
 */

import java.util.ArrayList;

public class DocumentIndex1 extends ArrayList<IndexEntry1>
{
  private int totalWords;
  
  public DocumentIndex1()
  {
    super();
  }
  
  public DocumentIndex1(int capacity)
  {
    super(capacity);
  }
  
  public int getTotal()
  {
    return totalWords;
  }
  public void addWord(String word)
  {
    int wordIndex = foundOrInserted(word);
    this.get(wordIndex).add();
    totalWords++;
  }
  
  public void addAllWords(String str)
  {
    String[] splitStr = str.split("\\W+");
    
    for(String n: splitStr)
    {
      if(n.isEmpty() == false && n.equalsIgnoreCase("a") == false && n.equalsIgnoreCase("and") == false 
          && n.equalsIgnoreCase("are") == false && n.equalsIgnoreCase("the") == false && n.equalsIgnoreCase("this") == false 
          && n.equalsIgnoreCase("to") == false && n.equalsIgnoreCase("is") == false && n.equalsIgnoreCase("of") == false 
          && n.equalsIgnoreCase("on") == false && n.equalsIgnoreCase("in") == false && n.equalsIgnoreCase("who") == false
          && n.equalsIgnoreCase("has") == false && n.equalsIgnoreCase("for") == false) // checking for "common" words 
        addWord(n);
    }
  }
  
  public String toString()
  {
    String total = "";
    for(IndexEntry1 index: this)
    {
      total+= index.getWord() + ": " + index.getSize() + "\n";
    }
    return total + this.totalWords;
  }
  
//                ********************* Private/Helper Methods ************************
  
  private int foundOrInserted(String word) 
  {
    word = word.toUpperCase();
    if (size() == 0)
    {
     add(new IndexEntry1(word)); // adds first IndexEntry to DocumentIndex, returns 0 for first index
     return 0;
    }
    
    for(int i = 0; i < size(); i++)
    {
      if(get(i).getWord().equals(word)) // if DocumentIndex already contains entry for word
        return i;                       // returns index of place in ArrayList<IndexEntry>
      
      else if(word.compareTo(get(i).getWord()) < 0) // if this word comes before the one tested
      {
        add(i, new IndexEntry1(word));
        return i; // add it at that place, shift ArrayList over
      }
    }
    
   add(new IndexEntry1(word)); 
   return size()-1;
   
  }
}
