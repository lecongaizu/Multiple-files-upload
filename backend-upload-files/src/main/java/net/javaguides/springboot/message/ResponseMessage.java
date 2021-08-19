package net.javaguides.springboot.message;

/**
 * @author CongLV
 *
 */
public class ResponseMessage {
	
	private String message;
	
	public ResponseMessage(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
