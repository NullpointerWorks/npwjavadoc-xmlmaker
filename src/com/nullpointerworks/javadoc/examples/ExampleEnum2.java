package com.nullpointerworks.javadoc.examples;

public enum ExampleEnum2 
{
	/**
		test comment for enum type
	*/
	ONE("1"),
	
	/**
		test comment for enum type
		@since 1.0.0
	*/
	TWO("2"),
	THREE("3");
	
	private String string;
	private ExampleEnum2(String s)
	{
		string = s;
	}
}
