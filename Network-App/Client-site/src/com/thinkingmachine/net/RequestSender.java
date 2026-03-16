package com.thinkingmachine.net;
import com.client.server.protocol.*;
import java.net.*;
import java.io.*;
import com.thinkingmachine.dl.dao.*;
public class RequestSender
{
public static String sendRequest(String requestData)
{
requestData+=Protocol.TERMINATOR;
try
{
Socket socket=ServerConnection.connect();
OutputStream outputStream;
outputStream=socket.getOutputStream();
OutputStreamWriter outputStreamWriter; 
outputStreamWriter=new OutputStreamWriter(outputStream);
outputStreamWriter.write(requestData);
outputStreamWriter.flush();
System.out.println(requestData+" sent");
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
if(stringBuffer.length()>=lengthOfTerminator)
{
endPart=stringBuffer.substring(stringBuffer.length()-lengthOfTerminator);
if(endPart.equals(Protocol.TERMINATOR)) break;
}
// logic to break off when TERMINATOR 3char is found
}
String responseData=stringBuffer.toString();
inputStream.close();
socket.close();
System.out.println(responseData);
return responseData.substring(0,responseData.length()-Protocol.TERMINATOR.length());
}catch(IOException e)
{
return "EXCEPTION"+Protocol.SEPARATOR+e.getMessage();
}
}
}