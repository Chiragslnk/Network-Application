import com.thinkingmachine.dl.interfaces.dto.*;
import com.thinkingmachine.dl.dao.*;
import com.thinkingmachine.dl.dto.*;
import com.thinkingmachine.dl.exceptions.*;
class TestGetByRollNumber
{
public static void main(String args[])
{
int rollNumber=Integer.parseInt(args[0]);
StudentDAO studentDAO=new StudentDAO();
try
{
StudentDTOInterface studentDTOInterface;
studentDTOInterface=studentDAO.getByRollNumber(rollNumber);
System.out.println(studentDTOInterface.getRollNumber());
System.out.println(studentDTOInterface.getName());
System.out.println(studentDTOInterface.getGender());
}catch(DAOException daoException)
{
System.out.println("Exception raised");
System.out.println(daoException);
}
}
}