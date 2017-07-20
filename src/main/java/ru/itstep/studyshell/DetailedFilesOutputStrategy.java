package ru.itstep.studyshell;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DetailedFilesOutputStrategy implements FilesOutputStrategy {

	public void output(List<File> files) {
		
		for( File f: files) {
			
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Long space = f.getTotalSpace();
			double spaceKb = space/1000;
			
			System.out.println("Последний Формат : " + sdf.format(f.lastModified()));
			System.out.println("Файл: " + f.isFile());
			System.out.println("Каталог: "+f.isDirectory());
			System.out.println(String.format("%d", )"Размер: " + spaceKb + "-Kb");
			System.out.println("Имя" +f.getName());
		}
		
	}

}
