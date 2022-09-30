package com.ipartek.formacion.mf0967.uf2216.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	private static final boolean AUTOFLUSH = true;

	public static void main(String[] args) throws IOException {
		System.out.println("Conectando a servidor arrancado en el puerto 1234");

		Socket s = new Socket("localhost", 1234);

		PrintWriter pw = new PrintWriter(s.getOutputStream(), AUTOFLUSH);
		Scanner sc = new Scanner(s.getInputStream());

		String texto = sc.nextLine();
		System.out.println(texto);
		
		pw.println("Texto a convertir");
		
		texto = sc.nextLine();
		System.out.println(texto);

		pw.close();
		sc.close();
		s.close();
	}
}
