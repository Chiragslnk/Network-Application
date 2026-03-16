import java.util.*;
import com.thinkingmachine.dl.interfaces.dto.*;
import com.thinkingmachine.dl.dao.*;
import com.thinkingmachine.dl.dto.*;
import com.thinkingmachine.dl.exceptions.*;
class TestGetStudents
{
public static void main(String args[])
{
StudentDAO studentDAO=new StudentDAO();
List<StudentDTOInterface> students;
try
{
students=studentDAO.get(); 
for(StudentDTOInterface studentDTOInterface:students)
{
System.out.println(studentDTOInterface.getRollNumber());
System.out.println(studentDTOInterface.getName()); System.out.println(studentDTOInterface.getGender());
}
}catch(DAOException daoException)
{
System.out.println("Exception raised");
System.out.println(daoException);
}
}
}