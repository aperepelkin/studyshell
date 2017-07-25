package ru.itstep.studyshell;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DetailedFilesOutputStrategy implements FilesOutputStrategy {
/*
	@Override
	public void output(List<File> files) {
		

	}
*/
	private String getFileSize(File file) {
		long size = file.length();
		String result = null;
		if (size > 1000) {
			result = file.length()/1024 + "Kb";
			
		} else if (size < 999) {
			result = file.length() + "b";
		}
		
		return result;
		
	}

	private String getFileExtension(File file) {
		String f = file.getName();
		if (f.lastIndexOf(".") != -1 && f.lastIndexOf(".") !=0) {
			return f.substring(f.lastIndexOf(".") + 1); 
		} else return "Folder"; 
		
		
	}

	public void output(List<File> files) {
		// TODO Auto-generated method stub
		for (File file : files) {
			SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy HH:mm:ss");
			
			System.out.println(file.getName()+ " " + sdf.format(new Date(file.lastModified())) + " " + getFileExtension(file) + " " + getFileSize(file));
		}
	}
}
