package com.ipartek.formacion.mf0967.uf2216.bibliotecas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.function.Function;

/**
 * Biblioteca para poder acceder a la consola de forma cómoda.
 * Recomendable usar con import static.
 * 
 * Todos los métodos g* repiten la introducción en el caso de que el valor no sea válido.
 */
public class Consola {
	private static final Scanner SC = new Scanner(System.in);

	/**
	 * Alternativa a println
	 */
	public static void pl() {
		System.out.println();
	}

	/**
	 * Mostrar en una línea independiente un objeto
	 * @param o objeto a visualizar
	 */
	public static void pl(Object o) {
		System.out.println(o);
	}

	/**
	 * Mostrar un error en una línea independiente
	 * @param o objeto que contiene el texto del error
	 */
	public static void ple(Object o) {
		System.err.println(o);
	}

	/**
	 * Muestra un objeto sin saltar de línea
	 * @param o objeto a visualizar
	 */
	public static void p(Object o) {
		System.out.print(o);
	}

	/**
	 * Pide por consola un String
	 * @param mensaje mensaje a visualizar
	 * @return texto introducido
	 */
	public static String gString(String mensaje) {
		p(mensaje + ": ");
		return SC.nextLine();
	}

	/**
	 * Pide por consola un entero
	 * @param mensaje mensaje a visualizar
	 * @return entero introducido
	 */
	public static int gInt(String mensaje) {
		return gObject(mensaje, texto -> Integer.parseInt(texto));
	}

	/**
	 * Pide por consola un long
	 * @param mensaje mensaje a visualizar
	 * @return long introducido
	 */
	public static long gLong(String mensaje) {
		return gObject(mensaje, texto -> Long.parseLong(texto));
	}

	/**
	 * Pide por consola un BigDecimal
	 * @param mensaje mensaje a visualizar
	 * @return BigDecimal introducido
	 */
	public static BigDecimal gBigDecimal(String mensaje) {
		return gObject(mensaje, texto -> new BigDecimal(texto));
	}

	/**
	 * Pide por consola un LocalDate
	 * @param mensaje mensaje a visualizar
	 * @return LocalDate introducido
	 */
	public static LocalDate gLocalDate(String mensaje) {
		return gObject(mensaje, texto -> LocalDate.parse(texto, DateTimeFormatter.ISO_DATE));
	}

	/**
	 * Pide por consola un objeto
	 * @param mensaje mensaje a visualizar
	 * @return objeto introducido
	 */
	public static <T> T gObject(String mensaje, Function<String, T> op) {
		boolean correcto = false;

		T o = null;

		do {
			try {
				String texto = gString(mensaje);

				o = op.apply(texto);

				correcto = true;
			} catch (NumberFormatException e) {
				ple("El número no es válido");
			} catch (DateTimeParseException e) {
				ple("La fecha no es válida");
			}
		} while (!correcto);

		return o;
	}
}
