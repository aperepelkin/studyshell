package ru.itstep.studyshell;

public class PrintWorkingDirectoryCommand implements Command{
  
    public void execute() {
	
	System.out.println(ListDirectoryCommandFactory.getCurrentDirectory());
    }

}
