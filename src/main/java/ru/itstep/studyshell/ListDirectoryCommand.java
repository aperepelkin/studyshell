package ru.itstep.studyshell;

import java.io.File;
import java.util.Arrays;

public class ListDirectoryCommand implements Command {

	
	
	private FilesOutputStrategy outputStrategy;
	
	public void execute() {
		File file = new File("./");
		File [] listOfFiles = file.listFiles();
		outputStrategy.output(Arrays.asList(listOfFiles));
	}

	public ListDirectoryCommand(FilesOutputStrategy outputStrategy) {
		
		
		this.outputStrategy = outputStrategy;
	}
}
