import com.thinkingmachine.dl.dao.*;
import com.thinkingmachine.dl.dto.*;
import com.thinkingmachine.dl.exceptions.*;
class TestAddStudent
{
public static void main(String args[])
{
int rollNumber=Integer.parseInt(args[0]);
String name=args[1];
char gender=args[2].charAt(0);
StudentDTO studentDTO=new StudentDTO();
studentDTO.setRollNumber(rollNumber);
studentDTO.setName(name);
studentDTO.setGender(gender);
StudentDAO studentDAO=new StudentDAO();
try
{
studentDAO.add(studentDTO);
}catch(DAOException daoException)
{
System.out.println(daoException);
System.out.println("Exception got raised");
}
}
}