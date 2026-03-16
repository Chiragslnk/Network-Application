package com.thinkingmachine.dl.dao;
public class ServerConfiguration
{
private String server;
private int port;

public ServerConfiguration(String server,int port)
{
this.server=server;
this.port=port;
}

public ServerConfiguration()
{
this.server="";
this.port=0;
}
public void setServer(java.lang.String server)
{
this.server=server;
}
public java.lang.String getServer()
{
return this.server;
}
public void setPort(int port)
{
this.port=port;
}
public int getPort()
{
return this.port;
}
}