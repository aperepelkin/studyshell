package tail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import directory.Directory;
import ru.itstep.studyshell.Command;
import ru.itstep.studyshell.Console;

public class TailCommand implements Command{

    String [] parametr;
    
    
    
    /**
     * @param parametr
     */
    public TailCommand(String[] parametr) {
	super();
	this.parametr = parametr;
    }


    private int getIntFromString(String str){
	str = str.replaceAll("[^0-9]+", "");
	return Integer.parseInt(str);
    }
    
    

    @Override
    public void execute() {
	
	//-n
	String param = null;
	
	//count of strings
	int count = 10;
	
	//
	int indexBegin = 0;
	
	// /dir/dir2
	String directory = null;
	
	//if false - last "count" rows
	//if true - from index "begin+1" to end
	boolean ans = true;
	
	
	for (String str: parametr){
	    if (str.contains("/")) {
		directory = str.replace("/", "\\");
	    } else if (!str.contains("/") && str.contains("-n")) {
		if(!str.matches("^\\D*$")){
			if (str.contains("+")) {
			    // -n+40
			    ans = false;
			    indexBegin = getIntFromString(str);
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
		  //from index "begin+1" to end 
		    ReadNLine(file.getAbsolutePath(), indexBegin, ans);
	    } else {
		  //last "count" rows
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
			for (int i=lines.size() - count; i < lines.size() ; i++) {
			    String s = lines.get(i);
			    Console.print(s, "black", true);
			}
		    }
	    } else {
		if (count <= lines.size()) {
		    for (int i=count; i< lines.size(); i++) {
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
