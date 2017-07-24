package queue;

public class ResultThreadOperation {
    
    
    private static ResultThreadOperation instance;
    private static StringBuilder sbMessage;
    
    private ResultThreadOperation() {
	
    }
    
    public static ResultThreadOperation getInstance() {
	if (instance == null) {
	    instance = new ResultThreadOperation();
	    sbMessage = new StringBuilder();
	}
	return instance;
    }
    
    
    public static void clear() {
	sbMessage.delete(0, sbMessage.length());
    }
    
    
    public static void add(String message, boolean wrapping) {
	if (wrapping) {
	    sbMessage.append(message + "<br>");
	} else {
	    sbMessage.append(message);
	}
    }
    
    
    
    public static String getMessage() {
	return sbMessage.toString();
    }
    
    
    

}
