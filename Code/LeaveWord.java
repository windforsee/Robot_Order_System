import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.*;
import java.util.*;

public class LeaveWord  extends RobotGUI{


	JButton button;
	JFrame frame;
	public String greetingword[]=new String[4];
	
	LeaveWord(JFrame frame){
		this.frame=frame;
	}

	/**
	 *random produce the farewell word
	 */


	public void buildFinall(){
		int rand=(int)(Math.random()*4);

		File file=new File("Files/FarewellMessages.txt");
		Scanner input = null;
		try {
			input = new Scanner(file);
			int i=0;
			while(input.hasNext()) {
				greetingword[i]=input.nextLine();
				i++;
				}//random produce the Farewell word
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		button=new JButton(greetingword[rand]);//make word in frame and in center
		

		button.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 39));
		button.setBackground(new Color(102,255,204));//make the background color to be sky blue

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.CENTER,button);
		frame.setSize(1000,500);
		frame.setVisible(true);
		
	}


}




