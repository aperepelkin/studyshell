package filter;

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

public class FilterCommand implements Command{

    private String [] parametr;
    private boolean together = false;
    
    /**
     * @param parametr
     */
    public FilterCommand(String[] parametr) {
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
    String keywords = null;
    
    
    StringBuilder sb = new StringBuilder();
    
    for (String splitParam: parametr){
        if (splitParam.contains("/")) {
            directory = Directory.getCurrentDirectory() + splitParam.replace("/", "\\");
        } else if (!splitParam.equals("|")) {
            sb.append(splitParam + " ");
        }
    }
    sb.setLength(Math.max(sb.length() - 1, 0));
    if (sb.length() != 0) {
        keywords = sb.toString();
    }
    
    
        if (together) {
            // возможные варианты
            // filter /dir str |
            // filter str |
            // filter |

            
        if (keywords != null && directory != null) {
            // filter /dir str |
            
            FileOperation.getInstance();
            FileOperation.addAll(directory, keywords);
            
            Thread threadAddMessage = new Thread(() -> {
                 ArrayList<String> lines;
                 try {
                     final String getFilter = FileOperation.getFilter();
                     
                     FileOperation.getInstance();
                     lines = (ArrayList<String>) Files.readAllLines(Paths.get(FileOperation.getFile()), Charset.defaultCharset());
                     for (String line: lines) {
                         if (line.contains(getFilter)) {
                             ResultThreadOperation.getInstance();
                             ResultThreadOperation.add(line, true);
                         }
                     }
                 } catch (IOException e) {
                     Console.print("There is no file", "red", true);
                 }
                 
             });
            
            
                QueueWorking.getInstance();
                QueueWorking.add(threadAddMessage);
                QueueWorking.processing();
            
            
            } else if (keywords != null && directory == null) {
            // filter str |
                
        	QueueWorking.getInstance();
        	if (QueueWorking.isEmpty()) {
        	    
        	    ResultThreadOperation.getInstance();
        	    String [] getPrevious = ResultThreadOperation.getMessage().split("<br>");
        	    
        	    sb.delete(0, sb.length());
        	    
        	    for (String str: getPrevious){
        		if (str.contains(keywords)) {
        		    sb.append(str + "<br>");
        		}
        	    }
        	    
        	    FileOperation.getInstance();
                    FileOperation.addMessage(sb.toString());
        	    
        	    Thread threadAddMessage = new Thread(() -> {                       
                        ResultThreadOperation.getInstance();
                        ResultThreadOperation.clear();
                        ResultThreadOperation.add(FileOperation.getMessage(), false);
                        
                    });
        	    
        	    QueueWorking.getInstance();
                    QueueWorking.add(threadAddMessage);
                    QueueWorking.processing();
        	    
        	}
                
            } else if (keywords == null && directory == null) {
            // filter |
            
        	Thread threadPrint = new Thread(() -> {
		    ResultThreadOperation.getInstance();
		    Console.print(ResultThreadOperation.getMessage(), "black", true);
		    ResultThreadOperation.clear();
		});
		
		QueueWorking.getInstance();
		QueueWorking.add(threadPrint);
		QueueWorking.processing();
        	
        	
            
            } else if (keywords == null && directory != null) {
        	
        	ResultThreadOperation.getInstance();
    	        String getPreviousMessage = ResultThreadOperation.getMessage();


    	            FileOperation.getInstance();
                    FileOperation.addAll(directory, null);
                
                    Thread threadAddMessage = new Thread(() -> {
                        ArrayList<String> lines;
                         try {
                             FileOperation.getFilter();
                         
                             FileOperation.getInstance();
                             
                             ResultThreadOperation.getInstance();
                             ResultThreadOperation.clear();
                             
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
    	            
    	            
    	            
    	            
    	            
    	            
    	        
            }
            
            
        } else {
            
            
            ArrayList<String> lines;
	    try {
		lines = (ArrayList<String>) Files.readAllLines(Paths.get(directory), Charset.defaultCharset());
		
		if (keywords != null) {
		    for (String line: lines) {
			if (line.contains(keywords)) {
			    Console.print(line, "black", true);
			}
		    }
		} else {
		    for (String line: lines) {
			Console.print(line, "black", true);
		    }
		}
		
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		Console.print("There is no file", "red", true);
	    }
	    
            
            
        }

    
    }

}
