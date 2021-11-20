package br.com.gabriel.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3480966812793280885L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
}
