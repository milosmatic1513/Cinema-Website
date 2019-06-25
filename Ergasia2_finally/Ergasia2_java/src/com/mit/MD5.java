package com.mit;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import java.security.SecureRandom;

public class MD5 {
    public static String  make_hash(String password,byte[] salt)
	{
	    MessageDigest md;
	    try
        {
	    	md = MessageDigest.getInstance("SHA-256");
	    	
	    	
	    	
	 
	    	md.update(salt);
	        
	    	byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
	        StringBuilder salted_hash = new StringBuilder();
	        for (byte b : hashedPassword)
	        	salted_hash.append(String.format("%02x", b));
	    	return salted_hash.toString();
	    	
		}
	    catch(Exception  e)
	    {
	    	System.out.println("Error during generation");
	    	return null;
	    	
	    }
	    
	 }
	 public static byte[] generate_salt()
	 {
		
    	SecureRandom random = new SecureRandom();
    	byte[] salt = new byte[16];
    	random.nextBytes(salt);
		 
		return salt;
	 }
	    

}
