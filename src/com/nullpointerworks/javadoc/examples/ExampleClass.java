package com.nullpointerworks.javadoc.examples;

import com.nullpointerworks.javadoc.xmlmaker.tokenizer.AbstractTokenizer;

/**
	Hello world! 3*6=18.
	@author Michiel
*/
public class ExampleClass<T> extends AbstractTokenizer
{
	
	public static final int myInteger = 0;
	
	ExampleClass()
	{
		
		new ExampleClass<Integer>("");
		
	}
	
	public <K> ExampleClass(K t)
	{
		
	}
	
	/**
		@param s - Some input string
		@version 1.0.0
	*/
	private ExampleClass(String s, int i)
	{
		
	}
	
	public static String getExample() 
	{
		return "Example";
	}

	public T getTemplated() 
	{
		return null;
	}
	
	public final <G> G getType(G t)
	{
		return t;
	}

	@Override
	@SuppressWarnings("unused")
	public void nextToken(String token) 
	{
		String s;
	}
	
	
	
	
}
