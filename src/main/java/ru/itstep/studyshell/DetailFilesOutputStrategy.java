package ru.itstep.studyshell;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import interfaces.FilesOutputStrategy;

public class DetailFilesOutputStrategy implements FilesOutputStrategy{

    @Override
    public void output(List<File> files) {
	// TODO Auto-generated method stub
	
        Console.print("Total: ", "black", false);
	Console.print(files.size() + "", "Maroon", true);
	
	//имя дата тип размер
	String [][] detailInfo = new String [files.size()][4];

	int indexRow = 0, indexCol = 0;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy HH:mm:ss");
	
	
	for (File list: files) {
	    detailInfo[indexRow][indexCol++] = list.getName();
	    detailInfo[indexRow][indexCol++] = dateFormat.format(new Date(list.lastModified()));
	    String type = getFileExtension(list);
	    detailInfo[indexRow][indexCol++] = type;
            detailInfo[indexRow][indexCol] = getFileSize(getDirSize(list));
            
            indexCol = 0;
            indexRow++;
	}
	
	for (int i=0; i<files.size(); i++)
	    Console.printTable(detailInfo[i], 4);
	
	
	
    }
    
    
    private long getDirSize(File dir) {
	    long size = 0;
	    if (dir.isFile()) {
	        size = dir.length();
	    } else {
	        File[] subFiles = dir.listFiles();
	        for (File file : subFiles) {
	            if (file.isFile()) {
	                size += file.length();
	            } else {
	                size += getDirSize(file);
	            }
	        }
	    }
	    return size;
	}



private String getFileSize(long size) {
    
    long gb = 1024L*1024*1024;
    long mb = 1024L*1024;
    long kb = 1024L;
    
    
        if (size >= gb) {
            return String.format("%.1f Gb", 1d * size / (double)(gb));
        } else if (size >= mb && size < gb){
            return String.format("%.1f Mb", 1d * size / (double)(mb));
	} else if (size < mb && size >= kb){
	    return String.format("%.1f Kb", 1d * size / (double)(kb));
	} else if (size < 1024L) {
	    return size + " byte";
	}
	return "0 byte";
}
    

    
    private String getFileExtension(File file) {
        String fileName = file.getName();
        // если в имени файла есть точка и она не является первым символом в названии файла
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
        return fileName.substring(fileName.lastIndexOf(".")+1);
        // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return "folder";
    }

}
