package com.comcast.GenericUtils;

import java.util.Random;

/**
 * generic methods releted to java
 * @author Chithra
 *
 */
public class JavaUtility {
/**
 * generate random numbers
 * @return
 */
	
	public int randomNumbers() 
	{
	Random random=new Random();
	int ran=random.nextInt(1000);
	return ran;
	
	}
}
