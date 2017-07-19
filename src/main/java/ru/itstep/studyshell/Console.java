package ru.itstep.studyshell;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class Console extends JFrame{
    
    private static JTextField commandArea;
    
    static MyJTextPane my;

    public Console(String nameWindow){
	super(nameWindow);
	
	
	my = new MyJTextPane();
	
	JScrollPane jsp = new JScrollPane();
	jsp.setBounds(45,0,500,300);
	jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	jsp.setAutoscrolls(true);
	jsp.getViewport().add(my);
	
	setLayout(null);
	
	commandArea = new JTextField(30);
	commandArea.setBounds(150, 310, 280, 25);
	

	
	
	
	add(jsp);
	add(commandArea);

	
	

	my.addString("<font color=\"blue\"><b> "  + ListDirectoryCommandFactory.consoleMessage + "</br></font></b>");
	
	
	commandArea.addActionListener(new ActionListener() {
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		my.addString("<b><font color=\"green\"> "  + getTextCommand() + "<br></font></b>");
		
		//my.changeColor(Color.BLACK);
		
		String line = getTextCommand();
		Command command = CommandRepository.getInstance().create(line);
		if (command != null) {
		    command.execute();
		}
		
		my.addString("<font color=\"blue\"><b> "  + ListDirectoryCommandFactory.consoleMessage + "</br></font></b>");
		commandArea.setText("");
		
	    }
	});
	
	
	
    }
    
    
    public static void print(String str) {
	my.addString(str);
    }
    
   
    
    public static String getTextCommand() {
	return commandArea.getText();
    }
    
    

    public class MyJTextPane extends JTextPane{
	private String temp;
	private int breakIndex;

	MyJTextPane(){
	    super();
	    this.setContentType("text/html");
	    this.setText("<html><head></head><body></body></html>");
	    this.setEditable(false);
	}


	public void addString(String str){
	    temp = this.getText();
	    breakIndex = temp.lastIndexOf("</body>");
	    temp = temp.substring(0, breakIndex) + "" + str + temp.substring(breakIndex);
	    this.setText(temp);
	}
    }
    
    

    
    
    
}
