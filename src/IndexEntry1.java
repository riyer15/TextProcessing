
/* Author: Rani Iyer
 * This class creates an array with a string and
 * holds a "size," attribute that increases every time the 
 * "add" method is called -- this allows us to log
 * instances of a string within a body of text. 
 * 
 */

public class IndexEntry1 
{
  private String word;
  private int size;
  
  public IndexEntry1(String str)
  {
    word = str.toUpperCase();
    size = 1;
  }
  
  public IndexEntry1(String str, int numbers)
  {
    word = str.toUpperCase();
    size = numbers;
  }
  
  public void add()
  {
    size++;
  }
  
  public String getWord()
  {
    return word;
  }
  
  public int getSize()
  {
    return size;
  }
  
  public String toString()
  {
    return word + ": "+  size;
  }
  
}
