package com.nullpointerworks.javadoc.xmlmaker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.util.FileUtil;
import com.nullpointerworks.util.file.textfile.TextFile;
import com.nullpointerworks.util.file.textfile.TextFileParser;

public class MainXMLMaker 
{
	
	public static void main(String[] args) 
	{
		new MainXMLMaker(args);
	}
	
	public MainXMLMaker(String[] args)
	{
		
		parseFile("src/com/nullpointerworks/javadoc/examples/ExampleClass.java");
		
		
	}
	
	public void parseFile(String f) 
	{
		List<SourceSegment> tokens = new ArrayList<SourceSegment>();
		ITokenizer parser = new SourceTokenizer(tokens);
		
		TextFile tf = null;
		try
		{
			tf = TextFileParser.file(f);
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}
		
		if (tf==null) return;
		String[] lines = tf.getLines();
		
		for (int i=0,l=lines.length; i<l; i++)
		{
			String line = lines[i];
			parser.nextLine(line);
		}
		
		String n = FileUtil.getFileNameFromPath(f);
		for (SourceSegment token : tokens)
		{
			System.out.println( token.getString() );
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	public void parseFiles(List<String> files) 
	{
		for (String f : files)
		{
			parseFile(f);
		}
	}

	public void parseDirectory(File dir, List<String> list, boolean traverseSub) 
	{
		File[] files = dir.listFiles();
		for (int i=0,l=files.length; i<l; i++)
		{
			File file = files[i];
			if (traverseSub && file.isDirectory()) 
			{
				parseDirectory(file, list, traverseSub);
			}
			else
			{
				list.add( file.getAbsolutePath() );
			}
		}
	}
}
