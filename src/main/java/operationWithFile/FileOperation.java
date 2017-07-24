package operationWithFile;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FileOperation {
    
    
    private static FileOperation instance;
    private static Queue<String> files;
    private static Queue<String> filters;
    private static Queue<String> message;
    
    
    private FileOperation(){
	
    }
    
    public static FileOperation getInstance() {
	if (instance == null){
	    files = new LinkedList<>();
	    filters = new LinkedList<>();
	    message = new LinkedList<>();
	    instance = new FileOperation();
	}
        return instance;
    }

 
    public static String getFile () {
	return files.poll();
    }
    
    public static String getFilter () {
	return filters.poll();
    }
    
    public static void addMessage(String message){
	FileOperation.message.add(message);
    }
    
    public static String getMessage(){
	return FileOperation.message.poll();
    }
  
    public static void addAll(String directory, String filter) {
	filters.add(filter);
	files.add(directory);
    }


}
