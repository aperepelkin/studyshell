package head;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import directory.Directory;
import ru.itstep.studyshell.Command;
import ru.itstep.studyshell.Console;

public class HeadCommand implements Command{

    
    String [] parametr;
    
    
    
    /**
     * @param parametr
     */
    public HeadCommand(String[] parametr) {
	super();
	this.parametr = parametr;
    }


    private int getIntFromString(String str){
	str = str.replaceAll("[^0-9]+", "");
	return Integer.parseInt(str);
    }
    
    
   
    
    

    @Override
    public void execute() {
	// TODO Auto-generated method stub


	
	//-n
		String param = null;
		
		//count of strings
		int count = 10;
		
		//
		int indexEnd = 0;
		
		// /dir/dir2
		String directory = null;
		
		//if false - first "count" rows
		//if true - from 0 to index "begin+1"
		boolean ans = true;
		
		
		for (String str: parametr){
		    if (str.contains("/")) {
			directory = str.replace("/", "\\");
		    } else if (!str.contains("/") && str.contains("-n")) {
			if(!str.matches("^\\D*$")){
				if (str.contains("-")) {
				    // -n-40
				    ans = false;
				    indexEnd = getIntFromString(str);
				} else {
				    // -n30
				    count = getIntFromString(str);
				}
			}
		    } else if(!str.matches("^\\D*$")){
			count = getIntFromString(str);
		    }
		}
		
		File file = null;
		if (directory != null) {
		    file = new File(Directory.getCurrentDirectory() + "\\\\" + directory);
		    
		    if (!ans) {
			//from 0 to index "begin+1"
			    ReadNLine(file.getAbsolutePath(), indexEnd, ans);
		    } else {
			  //first "count" rows
			    ReadNLine(file.getAbsolutePath(), count, ans);
		    }
		}
    }
    
    
    
    
    
    
    //if endOfFile == true - last count rows
    //if endOfFile == false - from count to end rows
    private static void ReadNLine(String dirToFile, int count, boolean endOfFile){
	
	try {
	    ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get(dirToFile), Charset.defaultCharset());
	    
	    if (endOfFile) {
		if (count >= lines.size()) {
			for (String list: lines){
			    Console.print(list, "black", true);
			}
		    } else {
			for (int i=0; i < count ; i++) {
			    String s = lines.get(i);
			    Console.print(s, "black", true);
			}
		    }
	    } else {
		if (count <= lines.size()) {
		    for (int i=0; i < Math.min(lines.size() - count, lines.size()); i++) {
			String s = lines.get(i);
			Console.print(s, "black", true);
		    }
		}
	    }
	    
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    Console.print("File not found", "red", true);
	}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

}
