package ru.itstep.studyshell;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import commands.Commands;
import directory.Directory;
import queue.QueueWorking;



public class Console extends JFrame{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static JTextField commandArea;
    
    private static MyJTextPane myJTP;





    public static MyJTextPane getMyJTP() {
        return myJTP;
    }



    public static void setMyJTP(MyJTextPane myJTP) {
        Console.myJTP = myJTP;
    }
    
    
    private String getFileNameFromPart(String part){
	String directory = null;
	if (part.contains("/")) {
	    int indexLast = part.lastIndexOf("/");
	    String sub = part.substring(0, indexLast);
	    part = part.substring(indexLast+1, part.length());
	    directory = Directory.getCurrentDirectory() + "\\" + sub.replace("/", "\\\\");
	} else {
	    directory = Directory.getCurrentDirectory();
	}
	
	File[] listOfFiles = (new File(directory)).listFiles();
	if (part.equals("") && listOfFiles.length == 1){
	    return listOfFiles[0].getName();
	}
	for (File file: listOfFiles){
	    if (file.getName().indexOf(part) == 0) {
		return file.getName().substring(part.length());
	    }
	}
	return null;
	
    }


    private void tabPress() {
	String[] splitInput = commandArea.getText().split(" ");
	
	 
	
	
	String input = Commands.getCommand(splitInput[splitInput.length-1]);
	if (input != null && splitInput.length == 1){
	    StringBuilder sb = new StringBuilder();
	    for (int i=0; i<splitInput.length-1; i++)
		sb.append(splitInput[i] + " ");
	    sb.append(input);
	    commandArea.setText(sb.toString());
	} else {
	    if (splitInput[splitInput.length-1].indexOf("/") == 0) {
		StringBuilder sb = new StringBuilder();
		    sb.append(commandArea.getText());
		    String part = splitInput[splitInput.length-1].substring(1);
		    if (getFileNameFromPart(part) != null) {
			sb.append(getFileNameFromPart(part));
		    }
		    commandArea.setText(sb.toString());
	    }
	}
    }
    
    
    

    public Console(String nameWindow){
	super(nameWindow);
	
	
	myJTP = new MyJTextPane();
	
	JScrollPane jsp = new JScrollPane();
	jsp.setBounds(25,0,650,300);
	jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	jsp.setAutoscrolls(true);
	jsp.getViewport().add(myJTP);
	
	setLayout(null);
	
	commandArea = new JTextField(30);
	commandArea.setBounds(150, 310, 350, 25);

	add(jsp);
	add(commandArea);

	Directory.getInstanse();
	myJTP.addString("<font color=\"blue\"><b> "  + Directory.getConsoleMessage() + "</br></font></b>");
	
	
	commandArea.setFocusTraversalKeysEnabled(false);
	commandArea.addKeyListener(new KeyAdapter() {
	    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_TAB) {
		    tabPress();
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		    boldPrint(getTextCommand(), "green", true);
			
			String [] lines = getCommands();
			for (String line: lines) {
			    Command command = CommandRepository.getInstance().create(line);
				if (command != null) {
				    command.execute();
				}
			}
			
			QueueWorking.getInstance();
			QueueWorking.processing();
			
			
			Directory.getInstanse();
			print(Directory.getConsoleMessage(), "blue", false);
			commandArea.setText("");
		}
	    }
	});
	
	

	
    }
    
    
    
    public static void printTable(String[] array, int columnCount) {
	
	int rowIndex = 0;
	int maxRowSize = 30;
	StringBuilder sb = new StringBuilder();
	
	for (int i=0; i<array.length; i++) {
	    rowIndex++;
	    if (rowIndex == columnCount) {
		    sb.append(array[i]);
		    prePrint(sb.toString());
		    sb.delete(0, sb.length());
		    rowIndex = 0;
		} else {
		    sb.append(array[i]);
    		    for (int j=0; j<maxRowSize - array[i].length(); j++) {
    			sb.append(" ");
    		    }
		    
		}
	}
	
	if (rowIndex !=0) 
	    prePrint(sb.toString());
	
	

	
    }
    
    
    
    public static void prePrint(String str) {
	myJTP.addString(String.format("<pre>%s<br></pre>", str));
    }
    
    
    
    public static void print(String str, String color, boolean wrapping) {
	if (wrapping) {
	    myJTP.addString(String.format("<font color=\"%s\">%s<br></font>", color, str));
	} else {
	    myJTP.addString(String.format("<font color=\"%s\">%s</font>", color, str));
	}
	
    }
    
    
    public static void boldPrint(String str, String color, boolean wrapping) {
	if (wrapping) {
	    myJTP.addString(String.format("<b><font color=\"%s\">%s<br></b></font>", color, str));
	} else {
	    myJTP.addString(String.format("<font color=\"%s\"><b>%s</b></font>", color, str));
	}
	
    }
    
    
    
    public static String[] getCommands() {
	
	String str = commandArea.getText();
	
	StringBuilder sb = new StringBuilder();
	
	ArrayList<String> arrayResult = new ArrayList<>();

	if (str.contains("|") && str.indexOf("|") != 0) {
	    String [] splitStr = str.split(" ");
	    for (String s: splitStr) {
		if (!s.equals("|")){
		    sb.append(s + " ");
		} else {
		    sb.append("|");
		    arrayResult.add(sb.toString());
		    sb.delete(0, sb.length());
		}
	    }
	    sb.append("|");
	    arrayResult.add(sb.toString()); 
	} else {
	    arrayResult.add(str);
	}
	
	String [] result = new String [arrayResult.size()];
	int index = arrayResult.size()-1;
	for (String s: arrayResult) {
	    result[index--] = s;
	}
	
	return result;
    }
    
    
   
    
    public static String getTextCommand() {
	return commandArea.getText();
    }
    
    

    public class MyJTextPane extends JTextPane{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String temp;
	private int breakIndex;

	MyJTextPane(){
	    super();
	    this.setContentType("text/html");
	    this.setText("<html><head></head><body></body></html>");
	    this.setEditable(false);
	}
	
	public void clear(MyJTextPane my){
	    my.setContentType("text/html");
	    my.setText("<html><head></head><body></body></html>");
	}


	public void addString(String str){
	    temp = this.getText();
	    breakIndex = temp.lastIndexOf("</body>");
	    temp = temp.substring(0, breakIndex) + "" + str + temp.substring(breakIndex);
	    this.setText(temp);
	}
    }
    
    

    
    
    
}
