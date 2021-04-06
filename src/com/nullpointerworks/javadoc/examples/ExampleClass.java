package com.nullpointerworks.javadoc.examples;

import com.nullpointerworks.javadoc.xmlmaker.AbstractSourceParser;

/**
	Hello world! 3*6=18.
	@author Michiel
*/
public abstract class ExampleClass<T> extends AbstractSourceParser
{
	
	public static final int myInteger = 0;
	
	ExampleClass()
	{
		
	}
	
	public ExampleClass(int i)
	{
		
	}
	
	/**
		@param s - Some input string
		@version 1.0.0
	*/
	private ExampleClass(String s)
	{
		
	}
	
	public static String getExample() 
	{
		return "Example";
	}
	
	public final <G> G getType(G t)
	{
		return t;
	}
	
	
	
	
}
