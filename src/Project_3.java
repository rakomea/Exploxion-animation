
import javax.swing.JFrame;

public class Project_3{
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Project 3");
		frame.setSize(1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI my_gui = new GUI();
		frame.add(my_gui);  
		frame.setVisible(true);
	}
}