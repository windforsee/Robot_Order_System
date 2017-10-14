import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class ConfirmMenu extends RobotGUI{

	JFrame frame;
	JLabel label;
	JLabel please;
	Font bigFont=new Font("serif",Font.BOLD,32);
	JPanel panel1;
	JPanel menulist;
	JPanel option;
	JTextField field;
	int choose;
	int i = 0;
	String restart;
	
	ConfirmMenu (JFrame frame,int choose,String choice,JPanel menulist,JPanel option,JTextField field){
		this.frame = frame;
		this.choose = choose;
		this.menulist = menulist;
		this.option = option;
		this.field = field;
		this.restart = choice;
	}
	
	public void confirm(){
		
		Scanner input = null;
		int restartStore[] = new int[12];
		File restartfile = new File("Files/"+ restart +"store.txt");
		// find the file witch is got the nod
		try {
			input = new Scanner(restartfile);
			int i = 0;
			while(input.hasNext()) {
				restartStore[i]=input.nextInt();
				i++;
				}
			input.close();
		
			if(choose==1){
				if(restartStore[1]==0){	
					menulist.setVisible(false);
					option.setVisible(false);
					NullDishes regainchoose=new NullDishes(frame,restart);
					regainchoose.buildrestartGUI();
				}
				else{
					please = new JLabel("Are you sure to order it?");
					Font bigFont = new Font("serif",Font.BOLD,39);
					please.setFont(bigFont);
					JButton yes = new JButton("YES");
					yes.addActionListener(new Yes1());	
				
					JButton no=new JButton("NO");
					no.addActionListener(new No());
				
					panel1=new JPanel();
					panel1.add(please);
					panel1.add(yes);
					panel1.add(no);
					panel1.setBackground(new Color(135,206,235));
					frame.getContentPane().add(BorderLayout.NORTH,panel1);
				}
			}
			if(choose==2){
				if(restartStore[3]==0){
					menulist.setVisible(false);
					option.setVisible(false);
					NullDishes regainchoose=new NullDishes(frame,restart);
					regainchoose.buildrestartGUI();
				}
				else{
					please = new JLabel("Are you sure to order it?");
					Font bigFont = new Font("serif",Font.BOLD,39);
					please.setFont(bigFont);
					JButton yes = new JButton("YES");
					yes.addActionListener(new Yes2());	
				
					JButton no = new JButton("NO");
					no.addActionListener(new No());
				
					panel1 = new JPanel();
					panel1.add(please);
					panel1.add(yes);
					panel1.add(no);
					panel1.setBackground(new Color(135,206,235));
					frame.getContentPane().add(BorderLayout.NORTH,panel1);
				}
			}
			if(choose==3){
				if(restartStore[5]==0){
					menulist.setVisible(false);
					option.setVisible(false);
					NullDishes regainchoose=new NullDishes(frame,restart);
					regainchoose.buildrestartGUI();
				}
				else{
					please = new JLabel("Are you sure to order it?");
					Font bigFont = new Font("serif",Font.BOLD,39);
					please.setFont(bigFont);
					JButton yes = new JButton("YES");
					yes.addActionListener(new Yes3());	
				
					JButton no = new JButton("NO");
					no.addActionListener(new No());
				
					panel1 = new JPanel();
					panel1.add(please);
					panel1.add(yes);
					panel1.add(no);
					panel1.setBackground(new Color(135,206,235));
					frame.getContentPane().add(BorderLayout.NORTH,panel1);
				}
			}
			if(choose==4){
				if(restartStore[7]==0){
					menulist.setVisible(false);
					option.setVisible(false);
					NullDishes regainchoose=new NullDishes(frame,restart);
					regainchoose.buildrestartGUI();
				}
				else{
					please = new JLabel("Are you sure to order it?");
					Font bigFont = new Font("serif",Font.BOLD,39);
					please.setFont(bigFont);
					JButton yes = new JButton("YES");
					yes.addActionListener(new Yes4());	
				
					JButton no = new JButton("NO");
					no.addActionListener(new No());
				
					panel1 = new JPanel();
					panel1.add(please);
					panel1.add(yes);
					panel1.add(no);
					panel1.setBackground(new Color(135,206,235));
					frame.getContentPane().add(BorderLayout.NORTH,panel1);
				}
			}
			if(choose==5){
				if(restartStore[9]==0){
					menulist.setVisible(false);
					option.setVisible(false);
					NullDishes regainchoose = new NullDishes(frame,restart);
					regainchoose.buildrestartGUI();
				}
				else{
					please = new JLabel("Are you sure to order it?");
					Font bigFont = new Font("serif",Font.BOLD,39);
					please.setFont(bigFont);
					JButton yes = new JButton("YES");
					yes.addActionListener(new Yes5());	
				
					JButton no = new JButton("NO");
					no.addActionListener(new No());
				
					panel1 = new JPanel();
					panel1.add(please);
					panel1.add(yes);
					panel1.add(no);
					panel1.setBackground(new Color(135,206,235));
					frame.getContentPane().add(BorderLayout.NORTH,panel1);
				}
			}
			if(choose==6){
				if(restartStore[11]==0){
					menulist.setVisible(false);
					option.setVisible(false);
					NullDishes regainchoose=new NullDishes(frame,restart);
					regainchoose.buildrestartGUI();
				}
				else{
					please=new JLabel("Are you sure to order it?");
					Font bigFont = new Font("serif",Font.BOLD,39);
					please.setFont(bigFont);
					JButton yes = new JButton("YES");
					yes.addActionListener(new Yes6());	
				
					JButton no = new JButton("NO");
					no.addActionListener(new No());
				
					panel1=new JPanel();
					panel1.add(please);
					panel1.add(yes);
					panel1.add(no);
					panel1.setBackground(new Color(135,206,235));
					frame.getContentPane().add(BorderLayout.NORTH,panel1);
				}
			}
		if(choose!=1&&choose!=2&&choose!=3&&choose!=4&&choose!=5&&choose!=6) {
				
				frame.getContentPane().removeAll();
				WrongMenu wrong=new WrongMenu(frame);
				wrong.buildMenuGUI();
		}
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}//confirm the dishes
	

	public class  Yes1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Scanner input = null;
			int fishStore[]=new int[12];
			int total=0;
			File fishfile=new File("Files/"+ restart +"store.txt");
			try {
				input = new Scanner(fishfile);
				int i=0;
				while(input.hasNext()) {
					fishStore[i]=input.nextInt();
					i++;
					}
				input.close();
	
				fishStore[1]=fishStore[1]-1;

				File file1=new File("Files/spendmoney.txt");
				Scanner input1=new Scanner(file1);
				total=input1.nextInt();
				total=total+fishStore[0];
				input1.close();
	
				i=0;
				PrintWriter output=new PrintWriter("Files/"+ restart +"store.txt"); 
		
				while(i<=10){
					output.print(fishStore[i]); 
					output.print(" "); 
					output.println(fishStore[i+1]); 
					i=i+2;
				}
				output.close();
		
				PrintWriter output1=new PrintWriter("Files/spendmoney.txt");
				output1.print(total);
				output1.close();
	
			panel1.setVisible(false);
			menulist.setVisible(false);
			option.setVisible(false);
			OrderSuccess success=new OrderSuccess(frame);
			success.tellJokes();
			}catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	public class  Yes2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Scanner input = null;
			int fishStore[]=new int[12];
			int total=0;
			File fishfile=new File("Files/"+ restart +"store.txt");
			try {
				input = new Scanner(fishfile);
				int i=0;
				while(input.hasNext()) {
					fishStore[i]=input.nextInt();
					i++;
					}
				input.close();
	
				fishStore[3]=fishStore[3]-1;

				File file1=new File("Files/spendmoney.txt");
				Scanner input1=new Scanner(file1);
				total=input1.nextInt();
				total=total+fishStore[2];
				input1.close();
	
				i=0;
				PrintWriter output=new PrintWriter("Files/"+ restart +"store.txt"); 
		
				while(i<=10){
					output.print(fishStore[i]); 
					output.print(" "); 
					output.println(fishStore[i+1]); 
					i=i+2;
				}
				output.close();
		
				PrintWriter output1=new PrintWriter("Files/spendmoney.txt");
				output1.print(total);
				output1.close();
	
			panel1.setVisible(false);
			menulist.setVisible(false);
			option.setVisible(false);
			OrderSuccess success=new OrderSuccess(frame);
			success.tellJokes();
			}catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	public class  Yes3 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Scanner input = null;
			int fishStore[]=new int[12];
			int total=0;
			File fishfile=new File("Files/"+ restart +"store.txt");
			try {
				input = new Scanner(fishfile);
				int i=0;
				while(input.hasNext()) {
					fishStore[i]=input.nextInt();
					i++;
					}
				input.close();
	
				fishStore[5]=fishStore[5]-1;

				File file1=new File("Files/spendmoney.txt");
				Scanner input1=new Scanner(file1);
				total=input1.nextInt();
				total=total+fishStore[4];
				input1.close();
	
				i=0;
				PrintWriter output=new PrintWriter("Files/"+ restart +"store.txt"); 
		
				while(i<=10){
					output.print(fishStore[i]); 
					output.print(" "); 
					output.println(fishStore[i+1]); 
					i=i+2;
				}
				output.close();
		
				PrintWriter output1=new PrintWriter("Files/spendmoney.txt");
				output1.print(total);
				output1.close();
	
			panel1.setVisible(false);
			menulist.setVisible(false);
			option.setVisible(false);
			OrderSuccess success=new OrderSuccess(frame);
			success.tellJokes();
			}catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	public class  Yes4 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Scanner input = null;
			int fishStore[]=new int[12];
			int total=0;
			File fishfile=new File("Files/"+ restart +"store.txt");
			try {
				input = new Scanner(fishfile);
				int i=0;
				while(input.hasNext()) {
					fishStore[i]=input.nextInt();
					i++;
					}
				input.close();
	
				fishStore[7]=fishStore[7]-1;

				File file1=new File("Files/spendmoney.txt");
				Scanner input1=new Scanner(file1);
				total=input1.nextInt();
				total=total+fishStore[6];
				input1.close();
	
				i=0;
				PrintWriter output=new PrintWriter("Files/"+ restart +"store.txt"); 
		
				while(i<=10){
					output.print(fishStore[i]); 
					output.print(" "); 
					output.println(fishStore[i+1]); 
					i=i+2;
				}
				output.close();
		
				PrintWriter output1=new PrintWriter("Files/spendmoney.txt");
				output1.print(total);
				output1.close();
	
			panel1.setVisible(false);
			menulist.setVisible(false);
			option.setVisible(false);
			OrderSuccess success=new OrderSuccess(frame);
			success.tellJokes();
			}catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	public class  Yes5 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Scanner input = null;
			int fishStore[]=new int[12];
			int total=0;
			File fishfile=new File("Files/"+ restart +"store.txt");
			try {
				input = new Scanner(fishfile);
				int i=0;
				while(input.hasNext()) {
					fishStore[i]=input.nextInt();
					i++;
					}
				input.close();
	
				fishStore[9]=fishStore[9]-1;

				File file1=new File("Files/spendmoney.txt");
				Scanner input1=new Scanner(file1);
				total=input1.nextInt();
				total=total+fishStore[8];
				input1.close();
	
				i=0;
				PrintWriter output=new PrintWriter("Files/"+ restart +"store.txt"); 
		
				while(i<=10){
					output.print(fishStore[i]); 
					output.print(" "); 
					output.println(fishStore[i+1]); 
					i=i+2;
				}
				output.close();
		
				PrintWriter output1=new PrintWriter("Files/"+ restart +"store.txt");
				output1.print(total);
				output1.close();
	
			panel1.setVisible(false);
			menulist.setVisible(false);
			option.setVisible(false);
			OrderSuccess success=new OrderSuccess(frame);
			success.tellJokes();
			}catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	public class  Yes6 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Scanner input = null;
			int fishStore[]=new int[12];
			int total=0;
			File fishfile=new File("Files/"+ restart +"store.txt");
			try {
				input = new Scanner(fishfile);
				int i=0;
				while(input.hasNext()) {
					fishStore[i]=input.nextInt();
					i++;
					}
				input.close();
	
				fishStore[11]=fishStore[11]-1;

				File file1=new File("Files/spendmoney.txt");
				Scanner input1=new Scanner(file1);
				total=input1.nextInt();
				total=total+fishStore[10];
				input1.close();
	
				i=0;
				PrintWriter output=new PrintWriter("Files/"+ restart +"store.txt"); 
		
				while(i<=10){
					output.print(fishStore[i]); 
					output.print(" "); 
					output.println(fishStore[i+1]); 
					i=i+2;
				}
				output.close();
		
				PrintWriter output1=new PrintWriter("Files/spendmoney.txt");
				output1.print(total);
				output1.close();
	
			panel1.setVisible(false);
			menulist.setVisible(false);
			option.setVisible(false);
			OrderSuccess success=new OrderSuccess(frame);
			success.tellJokes();
			}catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	public class  No implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			panel1.setVisible(false);
			menulist.setVisible(false);
			option.setVisible(false);
			Homepage now = new Homepage(frame);
			now.buildHome();
		
		}
		
	}
}
				

		

