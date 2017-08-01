package ru.itstep.studyshell;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class ListDirectoryCommand implements Command{

	private static final String COMMAND = "ls";
	
	private static class Factory extends BaseCommandFactory {

		public Factory() {
			super(COMMAND);
		}

		@Override
		protected Command createCommand(String option) {
			if(option.equals(" -l"))
				return new ListDirectoryCommand(new DetailedFilesOutputStrategy());
			return new ListDirectoryCommand(new ShortFilesOutputStrategy());
		}
	}
	
	private FilesOutputStrategy outputStrategy;
	
	
	public void execute() {
		
		File file = (App.getInstance().getDirectory());
		File [] listOfFiles = file.listFiles();
		outputStrategy.output(Arrays.asList(listOfFiles));
	
	}


	public ListDirectoryCommand(FilesOutputStrategy outputStrategy) {
		this.outputStrategy = outputStrategy;
	}
	
	public static CommandFactory createFactory() {
		return new Factory();
	}
}