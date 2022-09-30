package com.ipartek.formacion.mf0967.uf2216.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

	private static final boolean AUTOFLUSH = true;

	public static void main(String[] args) throws IOException {
		System.out.println("Arrancando servidor");
		
		ServerSocket ss = new ServerSocket(1234);
		
		System.out.println("Servidor arrancado en el puerto 1234");
		
		Socket s = ss.accept();
		
		PrintWriter pw = new PrintWriter(s.getOutputStream(), AUTOFLUSH);
		Scanner sc = new Scanner(s.getInputStream());
		
		pw.println("Bienvenido al servicio MAYUSCULATOR");
		String texto = sc.nextLine();
		
		pw.println(texto.toUpperCase());
		
		pw.close();
		sc.close();
		s.close();
		ss.close();
	}

}
