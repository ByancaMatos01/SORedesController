package View;

import javax.swing.JOptionPane;

import Controller.RedesController;



public class Main {

	public static void main(String[] args) {
		 RedesController Cont=new RedesController();
		int op = 0;
		
		while(op != 9) {
		
			op = Integer.parseInt(JOptionPane.showInputDialog("1 - ip\n2 - ping\n9 - finalizar"));
		
			if(op == 1) Cont.readProcess();
			if(op == 2) Cont.ping();
		}
	}			
	}



