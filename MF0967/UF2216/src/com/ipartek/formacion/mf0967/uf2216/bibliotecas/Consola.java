package com.ipartek.formacion.mf0967.uf2216.bibliotecas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Consola {
	private static final Scanner SC = new Scanner(System.in);
	
	public static void pl() {
		System.out.println();
	}

	public static void pl(Object o) {
		System.out.println(o);
	}
	
	public static void ple(Object o) {
		System.err.println(o);
	}
	
	public static void p(Object o) {
		System.out.print(o);
	}
	
	public static String gString(String mensaje) {
		p(mensaje + ": ");
		return SC.nextLine();
	}
	
	public static int gInt(String mensaje) {
		return (int) gObject(mensaje, new IntegerConvertible());
	}
	
	public static long gLong(String mensaje) {
		return (long) gObject(mensaje, new LongConvertible());
	}
	
	public static BigDecimal gBigDecimal(String mensaje) {
		return (BigDecimal) gObject(mensaje, new BigDecimalConvertible());
	}
	
	public static LocalDate gLocalDate(String mensaje) {
		return (LocalDate) gObject(mensaje, new LocalDateConvertible());
	}
	
	public static Object gObject(String mensaje, Convertible c) {
		boolean correcto = false;
		
		Object o = null;
		
		do {
			try {
				String texto = gString(mensaje);
				
				o = c.convertir(texto);
				
				correcto = true;
			} catch (NumberFormatException e) {
				ple("El número no es válido");
			} catch(DateTimeParseException e) {
				ple("La fecha no es válida");
			}
		} while (!correcto);
		
		return o;
	}
}

interface Convertible {
	Object convertir(String texto);
}

class LocalDateConvertible implements Convertible {

	@Override
	public Object convertir(String texto) {
		return LocalDate.parse(texto, DateTimeFormatter.ISO_DATE);
	}
	
}

class IntegerConvertible implements Convertible {

	@Override
	public Object convertir(String texto) {
		return Integer.parseInt(texto);
	}
	
}

class LongConvertible implements Convertible {

	@Override
	public Object convertir(String texto) {
		return Long.parseLong(texto);
	}
	
}

class BigDecimalConvertible implements Convertible {

	@Override
	public Object convertir(String texto) {
		return new BigDecimal(texto);
	}
}