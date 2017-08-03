package Sh_It.step;

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
			
			
			System.out.println(option);
			
			if (option.split(" ")[0].equals("echo")){
				System.out.println("gdfgdfgdfgdfg");
				return new EchoCommand(option.split(" ")[1]);
			}
			
			
			
			if(option.startsWith(COMMAND)){
				System.out.println("here");
				return new EchoCommand(option.split(" ")[1]);
			}
			
			return null;
		}

		
	}
	
	private String field;
	
	public EchoCommand(String directory) {
		this.field = field;
	}

	public void execute() {
		System.out.println(field );
		System.out.println("s");
	}
	
	public static CommandFactory createFactory() {
		return new Factory();
	}
}