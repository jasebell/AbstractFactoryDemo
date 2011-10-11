package uk.co.dataissexy.demo.exceptions;

public class ReadingException extends Exception{

	private static final long serialVersionUID = 1L;

	public ReadingException(){
		super();
	}
	
	public ReadingException(String msg){
		super(msg);
	}
}
