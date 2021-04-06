package com.nullpointerworks.javadoc.xmlmaker;

import java.util.List;

public class SourceTokenizer extends AbstractSourceParser
{
	private List<SourceSegment> tokens;
	private SourceSegment current;
	private int skip = 0;
	
	public SourceTokenizer(List<SourceSegment> tokens) 
	{
		this.tokens = tokens;
		current = new SourceSegment();
	}
	
	public List<SourceSegment> getSegments()
	{
		return tokens;
	}
	
	@Override
	public void nextToken(String token) 
	{
		if (token.equals("}")) 
		{
			skip--;
			return;
		}
		
		if (skip < 2)
		if (token.equals(";") || token.equals("*/") || token.equals("{"))
		{
			
			if (token.equals("{"))
			{
				skip++;
			}
			
			tokens.add(current);
			current = null;
			return;
		}
		
		if (skip > 1) return;
		
		if (current==null) 
		{
			current = new SourceSegment();
		}
		
		current.addToken(token);
	}
}
