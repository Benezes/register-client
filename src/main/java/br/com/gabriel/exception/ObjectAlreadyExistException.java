package br.com.gabriel.exception;

public class ObjectAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 6849344434648152172L;

	public ObjectAlreadyExistException(String msg) {
		super(msg);
	}

}
