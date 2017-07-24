package cat;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import directory.Directory;
import operationWithFile.FileOperation;
import queue.QueueWorking;
import queue.ResultThreadOperation;
import ru.itstep.studyshell.Command;
import ru.itstep.studyshell.Console;

public class CatCommand implements Command{

    
    private String[] parametr;
    private boolean together = false;
    
    
    /**
     * @param parametr
     */
    public CatCommand(String[] parametr) {
        super();
        this.parametr = parametr;
    }


    @Override
    public void execute() {
        // TODO Auto-generated method stub
        
        out: for (String str: parametr) {
            if (str.equals("|")) {
                together = true;
                break out;
            }
        }
    
    
    String directory = null;
 
    StringBuilder sb = new StringBuilder();
    
    for (String splitParam: parametr){
        if (splitParam.contains("/")) {
            directory = Directory.getCurrentDirectory() + splitParam.replace("/", "\\");
        } else if (!splitParam.equals("|")) {
            sb.append(splitParam + " ");
        }
    }
    sb.setLength(Math.max(sb.length() - 1, 0));
    
    
    
    if (sb.length() == 0) {

	if (together) {
	    
	    if (directory != null) {
		    FileOperation.getInstance();
                    FileOperation.addAll(directory, null);
                
                    Thread threadAddMessage = new Thread(() -> {
                        ArrayList<String> lines;
                         try {
                             FileOperation.getFilter();
                             FileOperation.getInstance();

                             lines = (ArrayList<String>) Files.readAllLines(Paths.get(FileOperation.getFile()), Charset.defaultCharset());
                             for (String line: lines) {
                                 ResultThreadOperation.getInstance();
                                 ResultThreadOperation.add(line, true);
                             }
                         } catch (IOException e) {
                             Console.print("There is no file", "red", true);
                         }
                     
                     });
                
                
                    QueueWorking.getInstance();
                    QueueWorking.add(threadAddMessage);
                    QueueWorking.processing();
	   
	    
	    } else {
		Thread threadPrint = new Thread(() -> {
                    ResultThreadOperation.getInstance();
                    Console.print(ResultThreadOperation.getMessage(), "black", true);
                    ResultThreadOperation.clear();
                });
                
                QueueWorking.getInstance();
                QueueWorking.add(threadPrint);
                QueueWorking.processing();
	    }
	    
	    
            
            

        } else {
            
            
            ArrayList<String> lines;
	    try {
		lines = (ArrayList<String>) Files.readAllLines(Paths.get(directory), Charset.defaultCharset());
		for (String line: lines) {
		    Console.print(line, "black", true);
		}
		
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		Console.print("There is no file", "red", true);
	    }
            
        }
	
	
    }
    
    
    
    
    
        
    
        
        
           
        
        
        
        
    }

}
