import java.io.*;
import java.net.*;
public class myserver
{
  public static void main(String args[])
  {
    try
     { ServerSocket ss= new ServerSocket(6666);
       Socket s=ss.accept(); //establishes Connection
       DataInputStream din=new DataInputStream(s.getInputStream());
       DataOutputStream dout=new DataOutputStream(s.getOutputStream());
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       String str="",str1="",str2="";
       while(!str1.equals("stop"))
       {
        str=din.readUTF();
        System.out.println("Client says:="+str);
        while((!str1.equals("over"))&&(!str1.equals("stop")))
        {
        str1=br.readLine();
        str2=str2+" "+str1;
        }
        dout.writeUTF(str2);
        dout.flush();
        str2="";
        str1="";
        }
       din.close();
       s.close();
       ss.close();
     }
     catch(Exception e)
     {System.out.println(e);
      }
   }
}
   