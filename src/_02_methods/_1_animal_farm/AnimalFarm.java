//    Copyright (c) The League of Amazing Programmers 2013-2020
//    Level 0

package _02_methods._1_animal_farm;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AnimalFarm {
	
	/***********  SOUND ***************
	 * Some computers are unable to play sounds. 
	 * If you cannot play sound on this computer, set canPlaySounds to false.
	 * If you are not sure, ask your teacher 
	 * *****************/
	boolean canPlaySounds = true;

	
	public static void main(String[] args) {
		new AnimalFarm().animals();
	}
	
	void animals() {
		String prompt =  "Which Animal? Or enter e to exit";
		
		JFrame frame = new JFrame("");
		frame.setSize(0, 0);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		Boolean play = true;
		while (play) {
			String animal = JOptionPane.showInputDialog(null, prompt);
			if (animal.equals("cow")) {
				moo();
			} else if (animal.equals("duck")) {
				quack();
			} else if (animal.equals("dog")) {
				woof();
			} else if (animal.equals("cat")) {
				meow();
			} else if (animal.equals("llama")) {
				llamaScream();
			} else if (animal.equals("e")) {
				play = false;
			}
		}

	
		/* 1. Ask the user which animal they want, then see and hear 
		 *    the animal they chose using one of the methods below.
		*/			 
			
		/* 2. Make it so that the user can keep entering new animals. */

	}

	void moo() {
		playNoise(mooFile);
		showImage(cowIcon);
	}

	void quack() {
		playNoise(quackFile);
		showImage(duckIcon);
	}

	void woof() {
		playNoise(woofFile);
		showImage(dogIcon);
	}
	
	void meow() {
		playNoise(meowFile);
		showImage(catIcon);
	}
	
	void llamaScream() {
		playNoise(llamaFile);
		showImage(llamaIcon);
	}
	


	

	/* Ignore this stuff */
	String path = "src/_02_methods/_1_animal_farm/";
	String quackFile = "quack.wav";
	String mooFile = "moo.wav";
	String woofFile = "woof.wav";
	String meowFile = "meow.wav";
	String llamaFile = "llama.wav";
	ImageIcon llamaIcon;
	ImageIcon catIcon;
	ImageIcon dogIcon;
	ImageIcon duckIcon;
	ImageIcon cowIcon;
	
	private void showImage (ImageIcon icon) {
			JOptionPane.showMessageDialog(null, "", "You chose", 0, icon);
	}
	
	private void playNoise(String soundFile) {
		if (canPlaySounds) {	
			File sound = new File(path+soundFile);
			if (sound.exists()) {
				new Thread(() -> {
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
					Thread.sleep(clip.getMicrosecondLength()/1000);
				}
				catch (Exception e) {
					System.out.println("Could not play this sound");
				}}).start();
	 		}
			else {
				System.out.println("File does not exist");
			}
		}
	}
	public AnimalFarm() {
		try {
			llamaIcon = new ImageIcon(path+"llama.jpg");
			cowIcon = new ImageIcon(path+"cow.jpg");
			dogIcon = new ImageIcon(path+"dog.jpg");
			catIcon = new ImageIcon(path+"cat.jpg");
			duckIcon = new ImageIcon(path+"duck.jpg");

		} catch (Exception e) {
					
		}
	}
}