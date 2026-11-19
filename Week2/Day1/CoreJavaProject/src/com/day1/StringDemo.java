package com.day1;

public class StringDemo {

	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "Java";
		String s3 = new String("Hello");
		String s4 = "Hello";
		System.out.println(s1==s4);
		System.out.println(s1==s3);
		System.out.println(s1.equals(s3));
		
		String name = "Alice";
		String newname = name.concat("Max");
		System.out.println(newname);
		System.out.println(name);
		
		System.out.println(name.length());
		
		System.out.println(name.indexOf('A'));
		
		System.out.println(newname.indexOf("Max"));
		
		String capName = "ALICE";
		System.out.println(name.equals(capName));
		System.out.println(name.equalsIgnoreCase(capName));
		System.out.println(name.toLowerCase().equals(capName.toLowerCase()));
		System.out.println(name.toUpperCase().equals(capName));
		
		String words = "Java,Python,C++,Java";
		System.out.println(words.replace("Java", "SQL"));
		System.out.println(words);
		
		String[] parts = words.split(",");
		for (String part : parts) {
			System.out.println(part);
		}
		
		StringBuffer bf = new StringBuffer("Hello");
		bf.append(" Java!");
		System.out.println(bf);
		
		String s5 = new String("Hello!");
		s5.concat(" Java!");
		System.out.println(s5);
		
		StringBuilder sb = new StringBuilder("Hello");
		sb.append(" Java!");
		System.out.println(sb);
		
		String s6 = " \n    Hello  \t   ";
		System.out.println(s6);
		System.out.println(s6.trim());
	}
}
