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
		return (int) gObject(mensaje, 0);
	}
	
	public static long gLong(String mensaje) {
		return (long) gObject(mensaje, 0L);
	}
	
	public static BigDecimal gBigDecimal(String mensaje) {
		return (BigDecimal) gObject(mensaje, BigDecimal.ZERO);
	}
	
	public static LocalDate gLocalDate(String mensaje) {
		return (LocalDate) gObject(mensaje, LocalDate.now());
	}
	
	public static Object gObject(String mensaje, Object o) {
		boolean correcto = false;
		
		do {
			try {
				String texto = gString(mensaje);
				
				if(o instanceof LocalDate) {
					o = LocalDate.parse(texto, DateTimeFormatter.ISO_DATE);
				} else if(o instanceof Integer) {
					o = Integer.parseInt(texto);
				} else if(o instanceof Long) {
					o = Long.parseLong(texto);
				} else if(o instanceof BigDecimal) {
					o = new BigDecimal(texto);
				} else {
					throw new ConsolaException("El tipo " + o.getClass().getName() + " no está soportado");
				}
				
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
