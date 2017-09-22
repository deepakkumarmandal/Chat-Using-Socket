import java.io.*;
import java.net.*;
public class myClient
{
  public static void main(String args[])
  {
    try
     { Socket s= new Socket("localhost",6666);
      DataInputStream din=new DataInputStream(s.getInputStream());
       DataOutputStream dout=new DataOutputStream(s.getOutputStream());
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       String str="",str1="",str3="";
       while(!str.equals("stop"))
       {
        while((!str.equals("over"))&&(!str.equals("stop")))
        {
        str=br.readLine();
        str1=str1+" "+str;
         }
        dout.writeUTF(str1);
        dout.flush();
        str="";
        str1="";
        str3=din.readUTF();
        System.out.println("Server says:="+str3);
      }
       dout.close();
       s.close();
      }
     catch(Exception e)
     {System.out.println(e);
      }
   }
}
   