package ru.itstep.studyshell;

import java.io.File;
import java.util.Scanner;


public class EchoCommand implements Command{

	private static final String COMMAND = "echo";
	
	private static class Factory extends BaseCommandFactory {

		public Factory() {
			super(COMMAND);
		}

		@Override
		protected Command createCommand(String option) {
			// TODO Auto-generated method stub
			return new EchoCommand(option);
		}
	}
	
	private String field;
	
	public EchoCommand(String directory) {
		this.field = field;
	}

	public void execute() {
		System.out.println(field);
	}
	
	public static CommandFactory createFactory() {
		return new Factory();
	}
}