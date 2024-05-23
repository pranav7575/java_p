//Implement a Java program to perform basic operations on strings.

import java.lang.*;

public class I_StringOperation {
    public static void main(String[] args) {
        // String str = "Hello World";
        // System.out.println(str.length());
        // System.out.println(str.charAt(6));
        // System.out.println(str.substring(6));
        // System.out.println(str.substring(0, 5));
        // System.out.println(str.indexOf('o'));
        // System.out.println(str.indexOf('o', 5));
        // System.out.println(str.lastIndexOf('o'));
        // System.out.println(str.lastIndexOf('o', 5));
        // System.out.println(str.toUpperCase());
        // System.out.println(str.toLowerCase());
        // System.out.println(str.trim());
        // System.out.println(str.replace('o', 'a'));
        // System.out.println(str.startsWith("He"));
        // System.out.println(str.endsWith("ld"));
        // System.out.println(str.contains("World"));
        // System.out.println(str.equals("Hello World"));
        // System.out.println(str.equalsIgnoreCase("hello world"));

        String str1=new String("Hello");
        String  str2=new String("World");

        //Concatenation
        String str3=str1.concat(str2);
        System.out.println(str3);

        //length of string
        System.out.println(str1.length());
        
        //Converting to uppercase string
        System.out.println(str1.toUpperCase());

        //Converting to lowercase string
        System.out.println(str1.toLowerCase());

        //Checking if string is containing a particular string
        System.out.println(str1.contains("Hello"));

        //replace substring with another substring
        System.out.println(str1.replace("Hello", "Hi"));
    }
}