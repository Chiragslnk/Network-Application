import java.util.*;
class Tester
{
public static void main(String gg[]) throws Exception
{
Map<String,Class> modules;
modules=new HashMap<>(); modules.put("STUDENT",Class.forName("StudentHandler")); 
modules.put("BABU",Class.forName("BabuHandler")); 
//modules.put("FACULTY",Class.forName("FacultyHandler"));
String moduleName=gg[0];
Class c=modules.get(moduleName);
if(c==null)
{
System.out.println("Invalid module name");
return;
}
RequestHandler requestHandler=(RequestHandler)c.newInstance();
String response=requestHandler.handleRequest(gg);
System.out.println(response);
}
}