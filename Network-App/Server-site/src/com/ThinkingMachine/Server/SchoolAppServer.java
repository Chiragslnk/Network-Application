package com.thinkingmachine.server;
import java.net.*;
import java.util.*;
import java.io.*;
public class SchoolAppServer
{
volatile private boolean keepRunning;
private ServerSocket serverSocket;
static private int port=5050;
private List<RequestProcessor>clientRequestProcessor;
public SchoolAppServer()
{
try
{
this.serverSocket=new ServerSocket(port);
this.clientRequestProcessor=new ArrayList<>();
}catch(Exception e)
{
System.out.println(e);
}
}
static
{
try
{
port=5050;
File file=new File("server.conf");
if(file.exists()==false)
{
port=5050;//default port
}
else
{
RandomAccessFile randomAccessFile;
randomAccessFile=new RandomAccessFile(file,"rw");
if(randomAccessFile.length()>0)
{
String line;
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
line=randomAccessFile.readLine().trim().toUpperCase();
if(line.length()>5 && line.startsWith("PORT="))
{
String part=line.substring(5);
try
{
port=Integer.parseInt(part);
if(port<1 || port>65535)
{
System.out.println("server.conf error: port number "+port+",should be between(1-65535)");
randomAccessFile.close();
System.out.println(0);
}
break;
}catch(NumberFormatException numberFormatException)
{
System.out.println("server.conf error: +line");
randomAccessFile.close();
System.exit(0);
}
}
}
}
randomAccessFile.close();
}
}catch(Exception e)
{
System.out.println(e.getMessage());
}
}
static public int getPort()
{
return port;
}
public void startServer()
{
try
{
Socket socket;
RequestProcessor requestProcessor;
this.keepRunning=true;
while(keepRunning)
{
try
{
socket=serverSocket.accept();
requestProcessor=new RequestProcessor(socket);
}catch(Exception ee)
{
System.out.println(ee.getMessage());
}
}
}catch(Exception e)
{
System.out.println(e.getMessage());
System.exit(0);
}
}
public static void main(String gg[])
{
try
{
SchoolAppServer schoolAppServer;
schoolAppServer=new SchoolAppServer();
System.out.println("School Application Server Started on port:"+SchoolAppServer.getPort());
schoolAppServer.startServer();
}catch(Exception e)
{
System.out.println(e);
}
}
}
		