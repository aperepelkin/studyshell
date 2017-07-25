package ru.itstep.studyshell;

import java.io.File;
import java.util.List;

public class ShortFilesOutputStrategy implements FilesOutputStrategy {

	public void output(List<File> files) {
		for(File file: files) {
			System.out.println(file.getPath());
		}
	}
}
