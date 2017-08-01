package ru.itstep.studyshell;

import java.io.File;
import java.util.List;

public class ShortFilesOutputStrategy implements FilesOutputStrategy {
	
	private OutputInterface out = new OutputInterface() {

		public void println(Object out) {
			System.out.println(out);
		}
	};
	
	
	public void setOut(OutputInterface out) {
		this.out = out;
	}

	public void output(List<File> files) {
		for(File file: files) {
			out.println(file.getPath());
		}
	}
}
