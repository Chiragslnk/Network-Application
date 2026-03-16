package com.thinkingmachine.server;
import java.net.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import com.client.server.protocol.*;
class RequestProcessor extends Thread
{
private Socket socket; 
static Map<String,Class> modules=new HashMap<>();
static
{
try
{
modules.put("STUDENT",Class.forName("com.thinkingmachine.server.StudentHandler")); 
}catch(ClassNotFoundException classNotFoundException)
{
System.out.println(classNotFoundException.getMessage());
System.exit(0);
}
// many more module names as the application grows
// the above can be loaded from configuration file
// STUDENT,com.school.server.StudentHandler
}
RequestProcessor(Socket socket)
{
this.socket=socket;
start();
}
public void run()
{
try
{
InputStream inputStream=socket.getInputStream();
InputStreamReader inputStreamReader; 
inputStreamReader=new InputStreamReader(inputStream);
StringBuffer stringBuffer=new StringBuffer();
int element; 
int lengthOfTerminator=Protocol.TERMINATOR.length();
String endPart;
int i=0;
while(true)
{
element=inputStreamReader.read();
if(element==-1) break;
stringBuffer.append((char)element);
System.out.println(element);
if(stringBuffer.length()>=lengthOfTerminator)
{
endPart=stringBuffer.substring(stringBuffer.length()-lengthOfTerminator);
System.out.println(endPart);
if(endPart.equals(Protocol.TERMINATOR)) break;
}
// logic to break off when TERMINATOR 3char is found
}
String requestData=stringBuffer.toString();
System.out.println(requestData); // to check
String splits[];
if(requestData==null) requestData="";
requestData=requestData.trim();
System.out.println("{"+requestData+"}"); splits=requestData.split(java.util.regex.Pattern.quote(Protocol.SEPARATOR));
// apply validation
int ii=splits.length-1; 
splits[ii]=splits[ii].substring(0,splits[ii].length()-lengthOfTerminator);
String moduleName=splits[0];
System.out.println("["+moduleName+"]");
Class c=modules.get(moduleName);
// apply validation for c==null 
RequestHandler requestHandler=(RequestHandler)c.newInstance(); 
String responseData=requestHandler.handleRequest(splits);
responseData+=Protocol.TERMINATOR; 
OutputStream outputStream=socket.getOutputStream();
OutputStreamWriter outputStreamWriter; 
outputStreamWriter=new OutputStreamWriter(outputStream);
outputStreamWriter.write(responseData);
outputStreamWriter.flush();
inputStream.close();
outputStream.close();
}catch(Exception e)
{
System.out.println(e);
}
}
}