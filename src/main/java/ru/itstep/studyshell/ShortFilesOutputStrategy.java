package ru.itstep.studyshell;

import java.io.File;
import java.util.List;

public class ShortFilesOutputStrategy implements FilesOutputStrategy{

	public void output(List<File> files) {
		
		for(File f: files) {
		System.out.println(f.getPath());
		}
	}
}
