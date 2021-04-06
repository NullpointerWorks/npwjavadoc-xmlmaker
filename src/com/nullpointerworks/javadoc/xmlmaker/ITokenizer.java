package com.nullpointerworks.javadoc.xmlmaker;

public interface ITokenizer 
{
	/**
	 * 
	 */
	public void nextLine(String line);
	
	/**
	 * 
	 */
	public void nextCharacter(String character);
	
	/**
	 * 
	 */
	public void nextToken(String token);
}
