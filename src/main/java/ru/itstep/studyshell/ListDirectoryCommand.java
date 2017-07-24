package ru.itstep.studyshell;

import java.io.File;
import java.util.Arrays;

import directory.Directory;
import interfaces.FilesOutputStrategy;

public class ListDirectoryCommand implements Command{
    
    
    private FilesOutputStrategy outputStrategy;
    

    
    
    
    public void execute() {
	// TODO Auto-generated method stub
	Directory.getInstanse();
	File folder = new File(Directory.getCurrentDirectory());
	
        File[] listOfFiles = folder.listFiles();

        String [] sb = new String[listOfFiles.length];
        for(int i=0; i<listOfFiles.length; i++) {
            sb[i] = listOfFiles[i].getName() + "\n <br>";
        }
        
        
        outputStrategy.output(Arrays.asList(listOfFiles));
        
        
	
    }
    
    
    public ListDirectoryCommand(FilesOutputStrategy outputStrategy) {
        this.outputStrategy = outputStrategy;
    } 
    
    
    

}
