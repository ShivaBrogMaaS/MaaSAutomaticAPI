package com.test.corent.model;

public class RandomKey 
{
public String getPassword() 
{
String temp = Long.toHexString(Double.doubleToLongBits(Math.random()));
return temp;
}
}
