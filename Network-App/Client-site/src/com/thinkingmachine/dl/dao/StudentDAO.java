package com.thinkingmachine.dl.dao;
import com.thinkingmachine.net.*;
import com.thinkingmachine.dl.dto.*;
import com.client.server.protocol.*;
import com.thinkingmachine.dl.interfaces.dao.*;
import com.thinkingmachine.dl.interfaces.dto.*;
import com.thinkingmachine.dl.exceptions.*;
import java.util.*;
import java.net.*;
import java.io.*;
import java.util.regex.*;
/*// ADD_STUDENT,UPDATE_STUDENT,REMOVE_STUDENT // GET_BY_ROLL_NUMBER_STUDENT,EXISTS_STUDENT,GET_STUDENT
*/ 
public class StudentDAO implements StudentDAOInterface
{
public void add(StudentDTOInterface studentDTO) throws DAOException
{
if(studentDTO.getName()==null) throw new DAOException("Name required");
String requestData;
requestData="STUDENT";
requestData+=Protocol.SEPARATOR;
requestData+="ADD_STUDENT";
requestData+=Protocol.SEPARATOR;
requestData+=studentDTO.getRollNumber();
requestData+=Protocol.SEPARATOR;
requestData+=studentDTO.getName();
requestData+=Protocol.SEPARATOR;
requestData+=studentDTO.getGender();
String responseData=RequestSender.sendRequest(requestData);
if(responseData.startsWith("EXCEPTION"))
{
String splits[]=responseData.split(Pattern.quote(Protocol.SEPARATOR));
System.out.println("Raising exception from add");
throw new DAOException(splits[1]);
}
}
public void update(StudentDTOInterface studentDTO) throws DAOException
{
if(studentDTO.getName()==null) throw new DAOException("Name required");
String requestData;
requestData="STUDENT";
requestData+=Protocol.SEPARATOR;
requestData+="UPDATE_STUDENT";
requestData+=Protocol.SEPARATOR;
requestData+=studentDTO.getRollNumber();
requestData+=Protocol.SEPARATOR;
requestData+=studentDTO.getName();
requestData+=Protocol.SEPARATOR;
requestData+=studentDTO.getGender(); 
String responseData=RequestSender.sendRequest(requestData);
if(responseData.startsWith("EXCEPTION"))
{
String splits[]=responseData.split(Pattern.quote(Protocol.SEPARATOR));
throw new DAOException(splits[1]);
}
}
public void remove(int rollNumber) throws DAOException
{
String requestData;
requestData="STUDENT";
requestData+=Protocol.SEPARATOR;
requestData+="REMOVE_STUDENT";
requestData+=Protocol.SEPARATOR;
requestData+=rollNumber;
String responseData=RequestSender.sendRequest(requestData);
if(responseData.startsWith("EXCEPTION"))
{
String splits[]=responseData.split(Pattern.quote(Protocol.SEPARATOR));
throw new DAOException(splits[1]);
}
}
public StudentDTOInterface getByRollNumber(int rollNumber) throws DAOException
{
String requestData;
requestData="STUDENT";
requestData+=Protocol.SEPARATOR;
requestData+="GET_BY_ROLL_NUMBER_STUDENT";
requestData+=Protocol.SEPARATOR;
requestData+=rollNumber;
String responseData=RequestSender.sendRequest(requestData);
String splits[]=responseData.split(Pattern.quote(Protocol.SEPARATOR));
if(splits[0].equals("EXCEPTION"))
{
throw new DAOException(splits[1]);
}
StudentDTOInterface studentDTOInterface=new StudentDTO();
studentDTOInterface.setRollNumber(Integer.parseInt(splits[1]));
studentDTOInterface.setName(splits[2]);
studentDTOInterface.setGender(splits[3].charAt(0));
return studentDTOInterface;
}
public boolean exists(int rollNumber) throws DAOException
{
String requestData;
requestData="STUDENT";
requestData+=Protocol.SEPARATOR;
requestData+="EXISTS_STUDENT";
requestData+=Protocol.SEPARATOR;
requestData+=rollNumber;
String responseData=RequestSender.sendRequest(requestData);
if(responseData.length()>0 && responseData.charAt(0)=='E')
{
throw new DAOException(responseData.substring(10+Protocol.SEPARATOR.length()));
}
return responseData.length()>0 && responseData.charAt(7+Protocol.SEPARATOR.length())=='t'; 
}
public List<StudentDTOInterface> get() throws DAOException
{
String requestData;
requestData="STUDENT";
requestData+=Protocol.SEPARATOR;
requestData+="GET_STUDENT"; 
String responseData=RequestSender.sendRequest(requestData);
System.out.println("{{"+responseData+"}}"); 
if(responseData.length()>0 && responseData.charAt(0)=='E')
{
throw new DAOException(responseData.substring(10+Protocol.SEPARATOR.length()));
}
String splits[]=responseData.split(Pattern.quote(Protocol.SEPARATOR)); 
List<StudentDTOInterface> students=new ArrayList<>();
StudentDTOInterface studentDTOInterface;
for(int i=1;i<splits.length;i+=3)
{
studentDTOInterface=new StudentDTO(); 
studentDTOInterface.setRollNumber(Integer.parseInt(splits[i]));
studentDTOInterface.setName(splits[i+1]); 
studentDTOInterface.setGender(splits[i+2].charAt(0));
students.add(studentDTOInterface);
}
return students;
}
}
