import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

public class DishesCreater {

	JTextField field;
	JLabel please;
	JPanel menulist=new JPanel();
	JPanel option=new JPanel();
	JFrame frame;
	int choose;
	String choice;
	
	DishesCreater(JFrame frame,int choose){
		this.frame = frame;
		this.choose = choose;
		
		String n1 = "Fish";
		String n2 = "Meat";
		String n3 = "Rice";
		String n4 = "Noodle";
		String n5 = "Drink";
		String n= "";
		
		switch (choose){
		case 1:
			for (int i = 0; i < n1.length(); i++) {
	            n += n1.charAt(i);
	            System.out.println(n);
	        }
			break;
		case 2:
			for (int i = 0; i < n2.length(); i++) {
	            n += n2.charAt(i);
	            System.out.println(n);
	        }
			break;
		case 3:
			for (int i = 0; i < n3.length(); i++) {
	            n += n3.charAt(i);
	            System.out.println(n);
	        }
			break;
		case 4:
			for (int i = 0; i < n4.length(); i++) {
	            n += n4.charAt(i);
	            System.out.println(n);
	        }
			break;
		case 5:
			for (int i = 0; i < n5.length(); i++) {
	            n += n5.charAt(i);
	            System.out.println(n);
	        }
			break;
		default:
			System.out.println("ERROR");
			break;
		}
		this.choice = n;
		
	}
	
	public void buildDishesGUI(){
		
		String nMenu[]=new String[6];
		Scanner input = null;
		
		String n1 = "Fish";
		String n2 = "Meat";
		String n3 = "Rice";
		String n4 = "Noodle";
		String n5 = "Drink";
		String n= "";
		
		switch (choose){
		case 1:
			for (int i = 0; i < n1.length(); i++) {
	            n += n1.charAt(i);
	            System.out.println(n);
	        }
			break;
		case 2:
			for (int i = 0; i < n2.length(); i++) {
	            n += n2.charAt(i);
	            System.out.println(n);
	        }
			break;
		case 3:
			for (int i = 0; i < n3.length(); i++) {
	            n += n3.charAt(i);
	            System.out.println(n);
	        }
			break;
		case 4:
			for (int i = 0; i < n4.length(); i++) {
	            n += n4.charAt(i);
	            System.out.println(n);
	        }
			break;
		case 5:
			for (int i = 0; i < n5.length(); i++) {
	            n += n5.charAt(i);
	            System.out.println(n);
	        }
			break;
		default:
			System.out.println("ERROR");
			break;
		}//check the number of witch menu is opened
		
		File nfile=new File("Files/"+ n +"Dishes.txt");
		try {
			input = new Scanner(nfile);
			int i=0;
			while(input.hasNext()) {
				nMenu[i]=input.nextLine();
				i++;
				}//random produce the greeting word
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JButton a=new JButton(nMenu[0]);
		JButton b=new JButton(nMenu[1]);
		JButton c=new JButton(nMenu[2]);
		JButton d=new JButton(nMenu[3]);
		JButton e=new JButton(nMenu[4]);
		JButton f=new JButton(nMenu[5]);

		frame.getContentPane().setBackground(new Color(102,255,204));//make the background color to be clue
		
		please=new JLabel("Please select an option :");//make word in top frame
		frame.getContentPane().add(BorderLayout.NORTH,please);
		
		Font bigFont=new Font("serif",Font.BOLD,32);
		please.setFont(bigFont);//make the top word bigger

		menulist.add(a);
		menulist.add(b);
		menulist.add(c);
		menulist.add(d);
		menulist.add(e);
		menulist.add(f);

		GridLayout method=new GridLayout(2,3);//make select in center frame
		int w=menulist.getWidth();
		int h=menulist.getHeight();
		menulist.setLayout(method);
		
		a.setSize(w/2,h/2);
		a.setBackground(new Color(65,105,225));
		b.setSize(w/2,h/2);
		b.setBackground(new Color(218,165,32));
		c.setSize(w/2,h/2);
		c.setBackground(new Color(0,191,255));
		d.setSize(w/2,h/2);
		d.setBackground(new Color(255,250,179));
		e.setSize(w/2,h/2);
		e.setBackground(new Color(238,130,238));
		f.setSize(w/2,h/2);
		f.setBackground(new Color(90,243,195));
	
		a.setFont(bigFont);//make the option word bigger
		b.setFont(bigFont);
		c.setFont(bigFont);
		d.setFont(bigFont);
		e.setFont(bigFont);
		f.setFont(bigFont);
		
		frame.getContentPane().add(BorderLayout.CENTER,menulist);

		JLabel optionword=new JLabel("Option selected:",JLabel.RIGHT);//make option in bottom frame
		optionword.setFont(bigFont);
		field=new JTextField(5);
		field.addActionListener(new getnum());


		option.setBackground(new Color(135,206,235));
		option.add(optionword);
		option.add(field);
		frame.getContentPane().add(BorderLayout.SOUTH,option);
		
		frame.setSize(1000,500);
		frame.setVisible(true);
	}

	class getnum implements ActionListener{
		public void actionPerformed(ActionEvent event){
			String choose=field.getText();
			if(choose.equals("1")||choose.equals("2")||choose.equals("3")||choose.equals("4")||choose.equals("5")){
				int choiceS=Integer.parseInt(choose);
				System.out.println(choose);
				please.setVisible(false);
				ConfirmMenu con=new ConfirmMenu(frame,choiceS,choice,menulist,option,field);
				con.confirm();
			}else{
				please.setVisible(false);
				please=new JLabel("The choice is not available.Please select again :");
				frame.getContentPane().add(BorderLayout.NORTH,please);
				Font bigFont=new Font("serif",Font.BOLD,39);
				please.setFont(bigFont);
			}
		}
	}//come to next page

	
}
