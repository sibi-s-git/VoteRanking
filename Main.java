import java.io.*;
import java.util.*;
import java.net.*;
class Main 
{
  public static void main(String[] args) 
  {
    Scanner in;
    String line;
    Player player;
    File file = new File("usernames.txt");
    try 
    {
      in = new Scanner(file);
      ArrayList<Player> names = new ArrayList<Player>();

      while (in.hasNext())
      {
        line = in.nextLine();
        player = new Player(line);
        names.add(player);
      }
      ArrayList<Player> namesSorted = playerSort(names);
      String fin ="";

      int j =0;
      for(int i = namesSorted.size()-1; i>-1; i--)
      {    
        fin = fin + (++j) + " " + namesSorted.get(i).getName()+ " " + namesSorted.get(i).getVotes() +"\n";
      }
      FileWriter output = new FileWriter("voterankings.txt");
      output.write(fin, 0, fin.length());
      output.close();

    } catch (IOException i)
    {
      System.out.println("Err: "+i.getMessage());
    }
  }
  public static ArrayList<Player> playerSort(ArrayList<Player> arr) 
	{  
    int n = arr.size();       
    for (int i = 1; i < n; i++)
    {   
      Player key = arr.get(i);  
      int j = i-1;            
      while ( (j > -1) && ( arr.get(j).getVotes() > key.getVotes() )) 
      {  
        arr.set(j+1,arr.get(j));  
        j--;  
      }  
      arr.set(j+1,key); 
    }  
    return arr;
  }
}