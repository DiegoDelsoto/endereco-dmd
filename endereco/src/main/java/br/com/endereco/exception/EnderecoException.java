package br.com.endereco.exception;

public class EnderecoException extends Exception {

	private static final long serialVersionUID = -8799423405382473800L;

	public EnderecoException() {
		super();
	}

	public EnderecoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EnderecoException(String message, Throwable cause) {
		super(message, cause);
	}

	public EnderecoException(String message) {
		super(message);
	}

	public EnderecoException(Throwable cause) {
		super(cause);
	}
	
	

}
