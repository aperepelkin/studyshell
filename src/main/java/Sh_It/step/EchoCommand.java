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
			String[] split = option.split(" ");
			if(option.startsWith(COMMAND))
				return new EchoCommand(option.split(" ")[1]);
			
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