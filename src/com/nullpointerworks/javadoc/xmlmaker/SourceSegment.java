package com.nullpointerworks.javadoc.xmlmaker;

import java.util.ArrayList;
import java.util.List;

public class SourceSegment 
{
	private List<String> tokens;
	
	public SourceSegment()
	{
		tokens = new ArrayList<String>();
	}
	
	public String getString() 
	{
		String res = tokens.remove(0);
		for (String s : tokens) res += (" "+s);
		return res;
	}
	
	public void addToken(String e)
	{
		tokens.add(e);
	}
	
	public List<String> getTokens()
	{
		return tokens;
	}
}
