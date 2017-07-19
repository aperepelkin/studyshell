package ru.itstep.studyshell;

public class PrintWorkingDirectoryCommand implements Command{
  
    public void execute() {
	
         Console.print(ListDirectoryCommandFactory.getCurrentDirectory() + "<br>");
    }

}
