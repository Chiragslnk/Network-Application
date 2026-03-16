import com.thinkingmachine.dl.dao.*;
import com.thinkingmachine.dl.dto.*;
import com.thinkingmachine.dl.exceptions.*;
class TestUpdateStudent
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
studentDAO.update(studentDTO);
System.out.println("Student Updated");
}catch(DAOException daoException)
{
System.out.println("Exception raised");
System.out.println(daoException);
}
}
}