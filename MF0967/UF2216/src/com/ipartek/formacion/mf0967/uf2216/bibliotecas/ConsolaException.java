package com.ipartek.formacion.mf0967.uf2216.bibliotecas;

public class ConsolaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConsolaException() {
		super();
	}

	public ConsolaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ConsolaException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConsolaException(String message) {
		super(message);
	}

	public ConsolaException(Throwable cause) {
		super(cause);
	}

}
