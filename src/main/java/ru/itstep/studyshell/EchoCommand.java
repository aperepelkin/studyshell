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
		//тут код
			System.out.println(option);
			
			if (option.split(" ")[0].equals("echo")){
				System.out.println("gdfgdfgdfgdfg");
				return new EchoCommand(option.split(" ")[1]);
			}
			
			
			
			if(option.startsWith(COMMAND)){
				System.out.println("here");
				return new EchoCommand(option.split(" ")[1]);
				//до сюда==========================
			}
			
			return null;
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