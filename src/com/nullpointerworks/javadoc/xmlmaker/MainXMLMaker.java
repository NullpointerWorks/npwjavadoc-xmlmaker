package com.nullpointerworks.javadoc.xmlmaker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.javadoc.xmlmaker.tokenizer.ITokenizer;
import com.nullpointerworks.javadoc.xmlmaker.tokenizer.SourceTokenizer;

import com.nullpointerworks.util.file.textfile.TextFile;
import com.nullpointerworks.util.file.textfile.TextFileParser;

import exp.nullpointerworks.xml.Document;
import exp.nullpointerworks.xml.Element;

/**

[visibility] [modifiers] [templates] [type] [name] [templates] [parameters] [extends] [implements] [value] 
[]  []  []  []  []  []  []  []  []  []


public abstract class ExampleClass<T> extends AbstractSourceParser
[public]  [abstract]  []  [class]  [ExampleClass]  [T]  []  [AbstractSourceParser]  []  []


public static final int myInteger = 0;
[public] [static, final]  []  [int] [myInteger]  []  []  []  [0]


ExampleClass()
[]  []  []  []  [ExampleClass]  []  []  []  []


public ExampleClass(int i)
[public]  []  []  []  [ExampleClass]  [int i]  []  []  []


public final <G> G getType(G t)
[public]  [final]  [G]  [G]  [getType]  []  [G t]  []  []  []





*/
public class MainXMLMaker 
{
	
	public static void main(String[] args) 
	{
		new MainXMLMaker(args);
	}
	
	public MainXMLMaker(String[] args)
	{
		
		List<SourceSegment> tokens = tokenizeFile("src/com/nullpointerworks/javadoc/examples/ExampleClass.java");
		//List<SourceSegment> tokens = tokenizeFile("src/com/nullpointerworks/javadoc/examples/ExampleEnum1.java");
		//List<SourceSegment> tokens = tokenizeFile("src/com/nullpointerworks/javadoc/examples/ExampleEnum2.java");
		
		for (SourceSegment token : tokens)
		{
			System.out.println( token.getString() );
		}
		
		
		
		Document doc = new Document();
		doc.setRootElement( new Element("source") );
		Element root = doc.getRootElement();
		
		makeInformation(root);
		
		
		
		
		
		
	}
	
	private void makeInformation(Element root)
	{
		Element info = new Element("info");

		Element type = new Element("type");
		Element name = new Element("name");
		Element mod = new Element("module");
		Element pack = new Element("package");
		
		
		makeInformationBlock(info);
		info.addChild(type);
		info.addChild(name);
		info.addChild(mod);
		info.addChild(pack);
		root.addChild(info);
	}
	
	private void makeInformationBlock(Element root)
	{
		Element info = new Element("info");
		Element author = new Element("author");
		Element version = new Element("version");
		Element since = new Element("since");
		Element see = new Element("see");
		Element comment = new Element("comment");
		info.addChild(author);
		info.addChild(version);
		info.addChild(since);
		info.addChild(see);
		info.addChild(comment);
		root.addChild(info);
	}
	
	// =========================================================
	
	private List<SourceSegment> tokenizeFile(String f) 
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
			return tokens;
		}
		
		if (tf==null) return tokens;
		String[] lines = tf.getLines();
		
		for (int i=0,l=lines.length; i<l; i++)
		{
			String line = lines[i];
			parser.nextLine(line);
		}
		
		return tokens;
	}
	
	private void tokenizeFiles(List<String> files) 
	{
		for (String f : files)
		{
			tokenizeFile(f);
		}
	}

	private void scanDirectory(File dir, List<String> list, boolean traverseSub) 
	{
		File[] files = dir.listFiles();
		for (int i=0,l=files.length; i<l; i++)
		{
			File file = files[i];
			if (traverseSub && file.isDirectory()) 
			{
				scanDirectory(file, list, traverseSub);
			}
			else
			{
				list.add( file.getAbsolutePath() );
			}
		}
	}
}
