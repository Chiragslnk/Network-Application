import com.thinkingmachine.dl.dao.*;
import com.thinkingmachine.dl.dto.*;
import com.thinkingmachine.dl.exceptions.*;
class TestRemoveStudent
{
public static void main(String args[])
{
int rollNumber=Integer.parseInt(args[0]);
StudentDAO studentDAO=new StudentDAO();
try
{
studentDAO.remove(rollNumber);
System.out.println("Student deleted");
}catch(DAOException daoException)
{
System.out.println("Exception raised");
System.out.println(daoException);
}
}
}