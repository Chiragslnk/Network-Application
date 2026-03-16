import com.thinkingmachine.dl.interfaces.dto.*;
import com.thinkingmachine.dl.dao.*;
import com.thinkingmachine.dl.dto.*;
import com.thinkingmachine.dl.exceptions.*;
class TestExists
{
public static void main(String args[])
{
int rollNumber=Integer.parseInt(args[0]);
StudentDAO studentDAO=new StudentDAO();
try
{
System.out.println(studentDAO.exists(rollNumber));
}catch(DAOException daoException)
{
System.out.println("Exception raised");
System.out.println(daoException);
}
}
}