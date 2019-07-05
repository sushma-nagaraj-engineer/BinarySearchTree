package Project2;


public class UnderflowException extends RuntimeException {
	/**
	 * Exception class for access in empty containers
	 * such as stacks, queues, and priority queues.
	 * @author Mark Allen Weiss
	 */
}
// The underflow Exception here could also be overridden to display the message as required by the user
//	@Override
//	public String toString() {
//		return " UnderFlowException [Invalid: UnderFlow Occured]";
//	}
	
	
// Or it could also be implemented by passing a String message however here the default Underflow Exception is used rather than user defined Exception	
	
	//public UnderflowException() {
//		
//		
//		    }
//	
//		    public UnderflowException(String msg) {
//		        super(msg);
//	
//		    }
//	
	

 

