import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.*;

public class Calculator extends JPanel implements ActionListener {
	JButton b[]=new JButton[11];
	JButton eq, clear, plus, dif,divis, koon;
	JTextField number = new JTextField(15);
	JTextField result = new JTextField(10);
	int count=0;
	char oper=' ';
	double n[]=new double[2];
	String cmd="";
	public Calculator() {
	        setPreferredSize(new Dimension(200, 400));
		for(int i=0;i<b.length;i++){
			String num=(i<b.length-1)?""+(char)(i+48):".";
			b[i]=new JButton(num);
			b[i].addActionListener(this);
		}
		eq=new JButton("=");
		clear=new JButton("Clear");
		plus=new JButton("+");
		dif=new JButton("-");
		koon=new JButton("*");
		divis=new JButton("/");
		add(number);
		add(result);
		add(clear);
		add(b[7]);
		add(b[8]);
		add(b[9]);
		add(divis);
		add(b[4]);
		add(b[5]);
		add(b[6]);
		add(koon);
		add(b[1]);
		add(b[2]);
		add(b[3]);
		add(dif);
		add(b[10]);
		add(b[0]);
		add(eq);
		add(plus);
		
		eq.addActionListener(this);
		clear.addActionListener(this);
		plus.addActionListener(this);
		dif.addActionListener(this);
		koon.addActionListener(this);
		divis.addActionListener(this);
		
		result.setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
		char ch=e.getActionCommand().charAt(0);
		char pre=(cmd.length()>0)?cmd.charAt(cmd.length()-1):' ';
		boolean flag=true;
		if(!(pre>=48&&pre<=57)&&!(ch>=48&&ch<=57))
			flag=false;
		if(flag)		
			cmd += e.getActionCommand();
		number.setText(cmd);
		if(ch=='='){
			String num="";
			for(int i=0;i<cmd.length();i++){
				char ch1=cmd.charAt(i);
				if((ch1>=48&&ch1<=57)||ch1==46){
					num+=ch1;
				}
				else{
					n[count++]=Double.parseDouble(num);
					if(count>1){
						double sum=0;
						switch(oper){
							case '+':sum=n[0]+n[1];break;
							case '-':sum=n[0]-n[1];break;
							case '*':sum=n[0]*n[1];break;
							case '/':sum=n[0]/n[1];break;
						}
						n[(count=1)-1]=sum;
					}
					if(ch1=='/'||ch1=='+'||ch1=='-'||ch1=='*')
							oper=ch1;
					num="";
				}
				result.setText(""+n[0]);
				number.setText("");
			}
			num=cmd="";
		}
		if (e.getSource() == clear){	
			result.setText("");
			number.setText("");
			cmd="";
			n[1]=n[0]=count=0;	
		}
	}
}