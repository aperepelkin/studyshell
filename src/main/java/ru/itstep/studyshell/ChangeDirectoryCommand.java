package ru.itstep.studyshell;

import java.io.File;

public class ChangeDirectoryCommand implements Command {
		
		private static final String COMMAND = "cd";
		
		private static class Factory extends BaseCommandFactory {

			public Factory() {
				super(COMMAND);
			}

			@Override
			protected Command createCommand(String option) {
				// TODO Auto-generated method stub
				return new ChangeDirectoryCommand(option);
			}
		}
		
		private String directory;
		
		public ChangeDirectoryCommand(String directory) {
			this.directory = directory;
		}

		public void execute() {
			App.getInstance().setDirectory(new File (App.getInstance().getDirectory(), directory));
		}
		
		public static CommandFactory createFactory() {
			return new Factory();
		}
	}
