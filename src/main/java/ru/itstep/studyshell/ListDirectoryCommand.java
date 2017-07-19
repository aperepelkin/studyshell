package ru.itstep.studyshell;

import java.io.File;
import java.util.Arrays;

public class ListDirectoryCommand implements Command{

    public void execute() {
	// TODO Auto-generated method stub
	
	File folder = new File(ListDirectoryCommandFactory.getCurrentDirectory());
	
        File[] listOfFiles = folder.listFiles();

        for(int i=0; i<listOfFiles.length; i++) {
           System.out.println(listOfFiles[i].getName());
        }
	
    }

}
