// in this example the bad thing is // ADD_STUDENT,UPDATE_STUDENT,REMOVE_STUDENT 
// GET_BY_ROLL_NUMBER_STUDENT,EXISTS_STUDENT,GET_STUDENT 
// in the next phase we will remove the suffix _STUDENT
// it is bad because the first part of splits array will
// be STUDENT, so the suffix is not required
// we have just kept it of reference as this is your
// first example related to doing this kind of network
// programming
import com.thinkingmachine.dl.exceptions.*;
import com.thinkingmachine.dl.interfaces.dto.*;
import com.thinkingmachine.dl.interfaces.dao.*;
import com.thinkingmachine.dl.dto.*;
import com.thinkingmachine.dl.dao.*;
import java.util.*;

class StudentHandler implements RequestHandler
{
    public String handleRequest(String []splits)
    {
        System.out.println("Student handler:handleRequest got called");
        // splits[0] contains STUDENT
        String command=splits[1];

        // ADD_STUDENT_PART STARTS HERE
        if(command.toUpperCase().equals("ADD_STUDENT"))
        {
            if(splits.length!=5)
            {
                return Protocol.FAILURE+Protocol.SEPARATOR+"DAOException"+Protocol.SEPARATOR+"Insufficient data to add student";
            }

            String name;
            int rollNumber;
            char gender;

            try
            {
                rollNumber=Integer.parseInt(splits[2].trim());
                if(rollNumber<=0)
                {
                    return "EXCEPTION"+Protocol.SEPARATOR+"Invalid roll number ("+splits[2]+")";
                }
            }catch(NumberFormatException numberFormatException)
            {
                return "EXCEPTION"+Protocol.SEPARATOR+"Invalid roll number";
            }

            name=splits[3].trim();
            if(name.length()==0 || name.length()>25)
            {
                return "EXCEPTION"+Protocol.SEPARATOR+"Name should be of minimim 2 characters and not more than 25 characters";
            }

            try
            {
                gender=splits[4].trim().toUpperCase().charAt(0);
                if(gender!='M' && gender!='F')
                {
                    return "EXCEPTION"+Protocol.SEPARATOR+"Invalid gender ("+splits[4]+")";
                }
            }catch(Exception e)
            {
                return "EXCEPTION"+Protocol.SEPARATOR+"Gender required (M/F)";
            }

            StudentDTOInterface studentDTOInterface;
            studentDTOInterface=new StudentDTO();
            studentDTOInterface.setRollNumber(rollNumber);
            studentDTOInterface.setName(name);
            studentDTOInterface.setGender(gender);

            try
            {
                addStudent(studentDTOInterface);
                return Protocol.SUCCESS+Protocol.SEPARATOR+"Student added";
            }catch(DAOException daoException)
            {
                return "EXCEPTION"+Protocol.SEPARATOR+daoException.getMessage();
            }
        }
        // ADD_STUDENT ENDS HERE

        if(command.toUpperCase().equals("UPDATE_STUDENT"))
        {
            if(splits.length!=5)
            {
                return Protocol.FAILURE+Protocol.SEPARATOR+"DAOException"+Protocol.SEPARATOR+"Insufficient data to update student";
            }

            String name;
            int rollNumber;
            char gender;

            try
            {
                rollNumber=Integer.parseInt(splits[2].trim());
                if(rollNumber<=0)
                {
                    return "EXCEPTION"+Protocol.SEPARATOR+"Invalid roll number ("+splits[2]+")";
                }
            }catch(NumberFormatException numberFormatException)
            {
                return "EXCEPTION"+Protocol.SEPARATOR+"Invalid roll number";
            }

            name=splits[3].trim();
            if(name.length()==0 || name.length()>25)
            {
                return "EXCEPTION"+Protocol.SEPARATOR+"Name should be of minimim 2 characters and not more than 25 characters";
            }

            try
            {
                gender=splits[4].trim().toUpperCase().charAt(0);
                if(gender!='M' && gender!='F')
                {
                    return "EXCEPTION"+Protocol.SEPARATOR+"Invalid gender ("+splits[4]+")";
                }
            }catch(Exception e)
            {
                return "EXCEPTION"+Protocol.SEPARATOR+"Gender required (M/F)";
            }

            StudentDTOInterface studentDTOInterface;
            studentDTOInterface=new StudentDTO();
            studentDTOInterface.setRollNumber(rollNumber);
            studentDTOInterface.setName(name);
            studentDTOInterface.setGender(gender);

            try
            {
                updateStudent(studentDTOInterface);
                return Protocol.SUCCESS+Protocol.SEPARATOR+"Student updated";
            }catch(DAOException daoException)
            {
                return "EXCEPTION"+Protocol.SEPARATOR+daoException.getMessage();
            }
        }

        if(command.toUpperCase().equals("REMOVE_STUDENT"))
        {
            if(splits.length!=3)
            {
                return Protocol.FAILURE+Protocol.SEPARATOR+"DAOException"+Protocol.SEPARATOR+"Insufficient data to remove student";
            }

            int rollNumber;

            try
            {
                rollNumber=Integer.parseInt(splits[2].trim());
                if(rollNumber<=0)
                {
                    return "EXCEPTION"+Protocol.SEPARATOR+"Invalid roll number ("+splits[2]+")";
                }
            }catch(NumberFormatException numberFormatException)
            {
                return "EXCEPTION"+Protocol.SEPARATOR+"Invalid roll number";
            }

            try
            {
                removeStudent(rollNumber);
                return Protocol.SUCCESS+Protocol.SEPARATOR+"Student deleted";
            }catch(DAOException daoException)
            {
                return "EXCEPTION"+Protocol.SEPARATOR+daoException.getMessage();
            }
        }

        if(command.toUpperCase().equals("GET_BY_ROLL_NUMBER_STUDENT"))
        {
            if(splits.length!=3)
            {
                return Protocol.FAILURE+Protocol.SEPARATOR+"DAOException"+Protocol.SEPARATOR+"Insufficient data to get student by roll number";
            }

            int rollNumber;

            try
            {
                rollNumber=Integer.parseInt(splits[2].trim());
                if(rollNumber<=0)
                {
                    return "EXCEPTION"+Protocol.SEPARATOR+"Invalid roll number ("+splits[2]+")";
                }
            }catch(NumberFormatException numberFormatException)
            {
                return "EXCEPTION"+Protocol.SEPARATOR+"Invalid roll number";
            }

            try
            {
                StudentDTOInterface studentDTOInterface;
                studentDTOInterface=getByRollNumberStudent(rollNumber);
 
                String responseData;
                responseData=Protocol.SUCCESS;
                responseData+=Protocol.SEPARATOR;
                responseData+=studentDTOInterface.getRollNumber();
                responseData+=Protocol.SEPARATOR;
                responseData+=studentDTOInterface.getName();
                responseData+=Protocol.SEPARATOR;
                responseData+=studentDTOInterface.getGender();

                return responseData;
            }catch(DAOException daoException)
            {
                return "EXCEPTION"+Protocol.SEPARATOR+daoException.getMessage();
            }
        }

        if(command.toUpperCase().equals("EXISTS_STUDENT"))
        {
            if(splits.length!=3)
            {
                return Protocol.FAILURE+Protocol.SEPARATOR+"DAOException"+Protocol.SEPARATOR+"Insufficient data to get student by roll number";
            }

            int rollNumber;

            try
            {
                rollNumber=Integer.parseInt(splits[2].trim());
                if(rollNumber<=0)
                {
                    return "EXCEPTION"+Protocol.SEPARATOR+"Invalid roll number ("+splits[2]+")";
                }
            }catch(NumberFormatException numberFormatException)
            {
                return "EXCEPTION"+Protocol.SEPARATOR+"Invalid roll number";
            }

            try
            {
                boolean b=existsStudent(rollNumber);

                String responseData;
                responseData=Protocol.SUCCESS;
                responseData+=Protocol.SEPARATOR;
                responseData+=b;

                return responseData;
            }catch(DAOException daoException)
            {
                return "EXCEPTION"+Protocol.SEPARATOR+daoException.getMessage();
            }
        }

        if(command.toUpperCase().equals("GET_STUDENT"))
        {
            try
            {
                List<StudentDTOInterface> students;
                students=getStudent();

                String responseData;
                responseData=Protocol.SUCCESS;
                responseData+=Protocol.SEPARATOR;
                // code to iterate the students (LIST)
                // on every cycle concat roll number // name and gender to response data (don't forget separator)
Iterator<StudentDTOInterface> iterator;
iterator=students.iterator();
StudentDTOInterface studentDTOInterface;
while(iterator.hasNext())
{
studentDTOInterface=iterator.next();
responseData+=studentDTOInterface.getRollNumber();
responseData+=Protocol.SEPARATOR;
responseData+=studentDTOInterface.getName();
responseData+=Protocol.SEPARATOR;
responseData+=studentDTOInterface.getGender();
responseData+=Protocol.SEPARATOR;
}	

                return responseData;
            }catch(DAOException daoException)
            {
                return "EXCEPTION"+Protocol.SEPARATOR+daoException.getMessage();
            }
        }

        return "EXCEPTION"+Protocol.SEPARATOR+"Invalid operation"; // dummy
    } // method handleRequest ends

    public void addStudent(StudentDTOInterface studentDTOInterface) throws DAOException
    {
        StudentDAOInterface studentDAOInterface;
        studentDAOInterface=new StudentDAO();
        studentDAOInterface.add(studentDTOInterface);
    }

    public void updateStudent(StudentDTOInterface studentDTOInterface) throws DAOException
    {
        StudentDAOInterface studentDAOInterface;
        studentDAOInterface=new StudentDAO();
        studentDAOInterface.update(studentDTOInterface);
    }

    public void removeStudent(int rollNumber) throws DAOException
    {
        StudentDAOInterface studentDAOInterface;
        studentDAOInterface=new StudentDAO();
        studentDAOInterface.remove(rollNumber);
    }

    public StudentDTOInterface getByRollNumberStudent(int rollNumber) throws DAOException
    {
        StudentDAOInterface studentDAOInterface;
        studentDAOInterface=new StudentDAO();
        return studentDAOInterface.getByRollNumber(rollNumber);
    }

    public boolean existsStudent(int rollNumber) throws DAOException
    {
        StudentDAOInterface studentDAOInterface;
        studentDAOInterface=new StudentDAO();
        return studentDAOInterface.exists(rollNumber);
    }

    public List<StudentDTOInterface> getStudent() throws DAOException
    {
        StudentDAOInterface studentDAOInterface;
        studentDAOInterface=new StudentDAO();
        return studentDAOInterface.get();
    }
}
