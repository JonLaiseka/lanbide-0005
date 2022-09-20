package com.ipartek.formacion.mf0967.uf2216;

// import java.lang.*; // Import implícito
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Lenguaje {
	public static void main(String[] args) {
		// Colecciones
		List<Integer> l = new ArrayList<>();
		
		l.add(10);
		l.add(20);
		l.add(30);
		
		System.out.println(l);
	}
	
	public static void mainArrays(String[] args) {
		// Arrays, arreglos, matrices
		int tamano = 3;
		int[] arr = new int[tamano];
		
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		
		System.out.println(arr[0] + ", " + arr[1] + ", " + arr[2]);
		
		// arr[3] = 40; // Lanza un ArrayIndexOutOfBoundsException
		
		System.out.println(arr.length);
		
		char[][] ajedrez = new char[8][8];
		
		ajedrez[0][0] = 'T';
		ajedrez[1][0] = 'P';
		ajedrez[6][7] = 'p';
		ajedrez[7][7] = 't';
		
		System.out.println(ajedrez[6][7]);
	}
	
	@SuppressWarnings("deprecation")
	public static void mainFechas(String[] args) {
		// 1.0
		Date d = new Date();

		System.out.println(d);

		System.out.println(d.getDate() + "-" + (d.getMonth() + 1) + "-" + (d.getYear() + 1900));
		System.out.println(d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds());

		// 1.1
		Calendar c = new GregorianCalendar();

		System.out.println(c);

		System.out.println(c.get(Calendar.DATE) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND));
		
		// 1.4 API externa JodaTime V1
		// 1.5 API externa JodaTime V2
		
		// 1.8 JodaTime -> java.time (JSR-310) Java Specification Request
		LocalDateTime ldt = LocalDateTime.now();
		
		System.out.println(ldt);
		
		System.out.println(ldt.getDayOfMonth() + "-" + ldt.getMonthValue() + "-" + ldt.getYear());
		System.out.println(ldt.getHour() + ":" + ldt.getMinute() + ":" + ldt.getSecond());
	}

	public static void mainTiposBasicos(String[] args) {
		double d1 = 4.8;
		double d2 = 0.4;

		@SuppressWarnings("unused")
		long l = 1234123123123L;

		System.out.println(d1 - d2);

		String nombre1 = new String("Javier");
		String nombre2 = new String("Javier");

		String nombre = "Javier";

		System.out.println(nombre1 == nombre2);
		System.out.println(nombre1.equals(nombre2));

		System.out.println(nombre1.length());
		System.out.println(nombre1.toUpperCase());
		System.out.println(nombre1.indexOf("vi"));

		System.out.println("Hola " + nombre);

		byte bb = 5;
		// Byte b = new Byte(bb);
		@SuppressWarnings("unused")
		Byte b = bb;

		@SuppressWarnings("unused")
		Integer i = null;
		// int ii = null;

		BigDecimal bd1 = new BigDecimal("4.8");
		BigDecimal bd2 = new BigDecimal("0.4");

		System.out.println(bd1.subtract(bd2));
	}

}
