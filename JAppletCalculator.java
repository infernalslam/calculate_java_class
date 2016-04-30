import java.awt.*;
import javax.swing.*;
public class JAppletCalculator extends JApplet{
public JAppletCalculator(){
		Calculator calculator = new Calculator();
		getContentPane().setLayout(new FlowLayout());
		add ( calculator );
}
public void init(){
		JAppletCalculator window = new JAppletCalculator();
 }
}