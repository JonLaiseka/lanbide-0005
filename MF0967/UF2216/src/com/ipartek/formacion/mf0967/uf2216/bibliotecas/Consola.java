package com.ipartek.formacion.mf0967.uf2216.bibliotecas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.function.Function;

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
		return gObject(mensaje, texto -> Integer.parseInt(texto));
	}

	public static long gLong(String mensaje) {
		return gObject(mensaje, texto -> Long.parseLong(texto));
	}

	public static BigDecimal gBigDecimal(String mensaje) {
		return gObject(mensaje, texto -> new BigDecimal(texto));
	}

	public static LocalDate gLocalDate(String mensaje) {
		return gObject(mensaje, texto -> LocalDate.parse(texto, DateTimeFormatter.ISO_DATE));
	}

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
