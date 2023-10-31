package _01_random._6_lottery_numbers;

import javax.swing.*;
import java.util.Random;

public class LottoryNumbers {
	public static void main(String[] args) {
		Random sixNums = new Random();
		
		String winner = "";
		
		for (int x = 0; x < 6; x ++) {
			int y = sixNums.nextInt(48);
			winner += String.valueOf(y) + "  ";
		}
		
		JFrame frame = new JFrame("Lottery Numbers");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		JLabel lbl = new JLabel();
		lbl.setText(winner);
		
		JPanel pnl = new JPanel();
		
		pnl.add(lbl);
		
		frame.add(pnl);
		
	
//		JOptionPane.showMessageDialog(null, "Hello");
	}
}
