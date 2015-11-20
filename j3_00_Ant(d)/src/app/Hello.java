package app;

import javax.swing.JFrame;

public class Hello extends JFrame{
	public Hello(){
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
 

	public static void main(String[] args) {
		new Hello();

	}

}
