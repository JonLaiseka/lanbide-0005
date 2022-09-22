package com.ipartek.formacion.mf0967.uf2216;

import java.math.BigInteger;
import java.time.LocalTime;

public class Recursividad {

	public static void main(String[] args) {
		// Añadir -Xss100m en Run Configurations/Recursividad
		
		// System.out.println(Integer.MAX_VALUE + 1);
		
		System.out.println(LocalTime.now());
		System.out.println(factorial(new BigInteger("1000000")).toString().length());
		System.out.println(LocalTime.now());
	}

	/**
	 * 3! = 3 * 2 * 1<br/>
	 * 3! = 3 * 2!<br/>
	 * 2! = 2 * 1! 1! = 1<br/>
	 * <br/>
	 * n! = n * !n-1<br/>
	 */

	public static BigInteger factorial(BigInteger n) {
		if (BigInteger.ONE.compareTo(n) == 0)
			return BigInteger.ONE;
		return n.multiply(factorial(n.subtract(BigInteger.ONE)));
	}
}
