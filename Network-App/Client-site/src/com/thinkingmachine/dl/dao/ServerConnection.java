package com.thinkingmachine.dl.dao;
import com.thinkingmachine.dl.exceptions.*;
import java.io.*;
import java.net.*;
public class ServerConnection
{
private ServerConnection()
{
}
private static ServerConfiguration serverConfiguration;
static
{
try
{
File file=new File("server.cfg");
if(file.exists()==false)
{
throw new ServerConfigurationException("server.cfg not found");
}
String portString=null;
String server=null;
String line=null;
String splits[];
// example of try with resources
try( RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw"))
{
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
line=randomAccessFile.readLine();
splits=line.split("=");
if(splits.length==2)
{
if(splits[0].equals("port")) portString=splits[1];
else if(splits[0].equals("server")) server=splits[1];
}
}
if(server==null) throw new ServerConfigurationException("[driver] configuration missing in database.cfg"); 
else if(portString==null) throw new ServerConfigurationException("[connection_string] configurationmissing in database.cfg");
int port=Integer.parseInt(portString); 
if(port<1 || port>65535) throw new NumberFormatException(""); 
serverConfiguration=new ServerConfiguration(server,port); 
}catch(NumberFormatException numberFormatException)
{
throw new ServerConfigurationException("Port should be between (1-65535)");
}
catch(IOException ioException)
{
throw new ServerConfigurationException(ioException.getMessage());
}
}catch(Throwable throwable)
{
System.out.println(throwable.getMessage());
System.exit(0);
}
}
public static Socket connect()
{
Socket socket=null;
try
{
socket=new Socket(serverConfiguration.getServer(),serverConfiguration.getPort());
}catch(Throwable throwable)
{
System.out.println(throwable.getMessage());
System.exit(0);
}
return socket;
}
}