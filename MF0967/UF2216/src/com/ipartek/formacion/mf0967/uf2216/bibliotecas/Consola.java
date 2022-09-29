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
		boolean correcto = false;
		
		int i = 0;
		
		do {
			try {
				String texto = gString(mensaje);
				i = Integer.parseInt(texto);
				correcto = true;
			} catch (NumberFormatException e) {
				ple("No es un número válido");
			} 
		} while (!correcto);
		
		return i;
	}
	
	public static long gLong(String mensaje) {
		boolean correcto = false;
		
		long l = 0;
		
		do {
			try {
				String texto = gString(mensaje);
				l = Long.parseLong(texto);
				correcto = true;
			} catch (NumberFormatException e) {
				ple("No es un número válido");
			} 
		} while (!correcto);
		
		return l;
	}
	
	public static BigDecimal gBigDecimal(String mensaje) {
		boolean correcto = false;
		
		BigDecimal bd = null;
		
		do {
			try {
				String texto = gString(mensaje);
				bd = new BigDecimal(texto);
				correcto = true;
			} catch (NumberFormatException e) {
				ple("No es un número válido");
			} 
		} while (!correcto);
		
		return bd;
	}
	
	public static LocalDate gLocalDate(String mensaje) {
		boolean correcto = false;
		
		LocalDate ld = null;
		
		do {
			try {
				String texto = gString(mensaje + " (AAAA-MM-DD)");
				ld = LocalDate.parse(texto, DateTimeFormatter.ISO_DATE);
				correcto = true;
			} catch (DateTimeParseException e) {
				ple("No es una fecha válida");
			} 
		} while (!correcto);
		
		return ld;
	}
}
