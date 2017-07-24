package ru.itstep.studyshell;

import java.io.File;
import java.util.List;

import interfaces.FilesOutputStrategy;

public class ShortFilesOutputStrategy implements FilesOutputStrategy{

    @Override
    public void output(List<File> files) {
	// TODO Auto-generated method stub
	
	String[] arrOfNames = new String[files.size()];
	
	int index=0;
	for (File list: files) {
	    arrOfNames[index++] = list.getName();
	}
	Console.printTable(arrOfNames, 3);

    }

}
