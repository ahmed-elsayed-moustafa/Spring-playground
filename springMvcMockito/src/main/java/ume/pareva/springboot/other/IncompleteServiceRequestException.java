package ume.pareva.springboot.other;

public class IncompleteServiceRequestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IncompleteServiceRequestException() {
	}
	
	public IncompleteServiceRequestException(String message)
    {
       super(message);
    }
	
}
