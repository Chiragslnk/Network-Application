class BabuHandler implements RequestHandler
{
public String handleRequest(String []splits)
{
System.out.println("Babu handler:handleRequest got called");
return Protocol.SUCCESS; // dummy
}
}