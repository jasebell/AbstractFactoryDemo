package uk.co.dataissexy.demo.exceptions;

public class WritingException extends Exception{

	private static final long serialVersionUID = 1L;

	public WritingException(){
		super();
	}
	
	public WritingException(String msg){
		super(msg);
	}
}
