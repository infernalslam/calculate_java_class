import java.awt.*;
import javax.swing.*;
public class JFrameCalculator extends JFrame {
public JFrameCalculator(){
	super("Hw #8-1 : Calculator");
	Calculator calculator = new Calculator();
	getContentPane().setLayout(new FlowLayout());
	add ( calculator );
	setSize( 400, 350);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	setVisible( true );
}
public static void main(String []agrs){
JFrameCalculator window = new JFrameCalculator();
 }
}