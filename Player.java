import java.io.*;
import java.util.*;
import java.net.*;

class Player 
{
  int votes;
  String username;
  
  String api = "78c8d2d7-2413-44fc-9505-c66457abb92f";

  public Player(String ign)
  {  
    username = ign;
    votes = 0;
    try
    {
      URL url = new URL("https://api.hypixel.net/player?key=" + api+"&name="+ign);
      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      conn.setRequestProperty("Accept", "application/json");
      String response = null;
      DataInputStream input = null;
      input = new DataInputStream (conn.getInputStream());
      if (null != ((response = input.readLine()))) {
          input.close ();
      }
      
      conn.disconnect();
  
      String[] com = response.split(",");
      for (String i:com)
      {
        if (i.indexOf("total_votes")>-1)
        {
          String[] col = i.split(":");
          String v = col[1];
          System.out.println(username + " "+v);
          votes = Integer.parseInt (v) ;
          break;
        }
        
      }
    } catch (IOException i)
    {
      System.out.println(username + " try again later, or incorrect ign");
    }
    
  }
  public int getVotes()
  {
    return votes;
  }
  public String getName()
  {
    return username;
  }
}

        
        
        