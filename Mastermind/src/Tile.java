import java.util.Random;

import javafx.scene.layout.VBox;

public class Tile {

	private Pin p1;
	private Pin p2;
	private Pin p3;
	private Pin p4;
	private VBox container;
	public static boolean difficulty;
	
	public Tile(Pin p1, Pin p2, Pin p3, Pin p4, VBox container) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.container = container;
		this.container.setOpacity(0);
	}
	public void updatePinColor() {
		p1.updateColor();
		p2.updateColor();
		p3.updateColor();
		p4.updateColor();
	}
	public String toString() {
		String returnedString = String.format("%s, %s, %s, %s", p1.getColorName(), p2.getColorName(), p3.getColorName(), p4.getColorName());
		return returnedString;
	}
	
	public void answerGen() {
		int[] numArr;
		if(difficulty == false) {
			numArr = noRepeatBoard();
		}
		else {
			numArr = repeatingBoard();
		}
		p1.setColor(numArr[0]);
		p2.setColor(numArr[1]);
		p3.setColor(numArr[2]);
		p4.setColor(numArr[3]);
	}
	
	private int[] noRepeatBoard(){
		boolean isTaken = false;
		int[] generatedArray = new int[4];
		Random rand = new Random();
		
		for (int i = 0; i < 4;) {
			int tempNum = rand.nextInt(6) + 1;
			for (int j = 0; j < 4; j++) {
				if (generatedArray[j] == tempNum) {
					isTaken = true;
				}
			}
			if (isTaken == false) {
				generatedArray[i] = tempNum;
				i++;
			} else {
				isTaken = false;
			}
		}
		return generatedArray;
	}
	public void setOpacity(double i) {
		container.setOpacity(i);
	}
	
	private int[] repeatingBoard(){
		int[] generatedArray = new int[4];
		Random rand = new Random();
		
		for (int i = 0; i < 4; i++) {
			generatedArray[i] = rand.nextInt(6) + 1;
		}
		return generatedArray;
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Tile)) {
			return false;
		}
		else {
			if(o.toString().equals(this.toString())) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	public int getPinsColor(int i) {
		switch(i) {
		case 1:
			return p1.getColor();
		case 2:
			return p2.getColor();
		case 3:
			return p3.getColor();
		case 4:
			return p4.getColor();
		default:
			return -1;
		}
	}
	public void activatePins() {
		p1.clickable();
		p2.clickable();
		p3.clickable();
		p4.clickable();
	}
	public void deactivatePins() {
		p1.notClickable();
		p2.notClickable();
		p3.notClickable();
		p4.notClickable();
	}
}
