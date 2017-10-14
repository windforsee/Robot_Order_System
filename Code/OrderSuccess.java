import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class OrderSuccess  extends RobotGUI{
	
	JFrame frame;
	JButton button0;
	JButton button1 = new JButton("Back to menu");
	JButton button2 = new JButton("Leave the Robot");
	Font bigFont = new Font("serif",Font.BOLD,39);
	JPanel panel = new JPanel();
	JLabel spend;
	String [] joke = new String[4];
	
	OrderSuccess(JFrame frame){
		this.frame = frame;
	}
	
	public void tellJokes()  {
		
		 // printout the total spend money
		 
		int total = 0;
		Scanner input = null;
		File file1 = new File("Files/spendmoney.txt");
		try {
			input = new Scanner(file1);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		total = input.nextInt();
		input.close();
		
		
		String outprint = (String)("Now, you have ordered "+total+" гд in total");
		spend = new JLabel(outprint,JLabel.CENTER);
		Font bigFont = new Font("serif",Font.BOLD,39);
		spend.setFont(bigFont);//make the word bigger
		frame.getContentPane().add(BorderLayout.NORTH,spend);
		
		

		int rand = (int)(Math.random()*4);

		File file = new File("Files/Jokes.txt");
		Scanner input1 = null;
		try {
			input1 = new Scanner(file);
			int i = 0;
			while(input1.hasNext()) {
				joke[i] = input1.nextLine();
				i++;
				}//random produce the greeting word
			input1.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// type a joke
		
		
		
		button0=new JButton(joke[rand]);//make word in frame and in center
		button0.setFont(bigFont);
		button0.setBackground(new Color(130,206,230));
		frame.getContentPane().add(BorderLayout.CENTER,button0);
		frame.setVisible(true);
		
		
		button1.addActionListener(new backMenu());
		button2.addActionListener(new leave());
		button1.setFont(bigFont);
		button2.setFont(bigFont);
		button1.setBackground(new Color(0,255,255));
		button2.setBackground(new Color(144,238,144));
		panel.setBackground(new Color(102,255,204));
		panel.add(button1);
		panel.add(button2);
		frame.getContentPane().add(BorderLayout.SOUTH,panel);
		//choose to order or leave the restaurant
		
		
	}
	
	
	class backMenu implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			spend.setVisible(false);
			button0.setVisible(false);
			panel.setVisible(false);
			Homepage now = new Homepage(frame);
			now.buildHome();
		}
	}//Back to Menu
	
	class leave implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			spend.setVisible(false);
			button0.setVisible(false);
			panel.setVisible(false);
			LeaveWord now = new LeaveWord(frame);
			now.buildFinall();
			
		}
	}//Leave the restaurant
	
}