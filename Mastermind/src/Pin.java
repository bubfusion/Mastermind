import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Pin {
	private int color;
	private Circle visual;
	private boolean isClickable;
	
	public Pin(Circle v) {
		visual = v;
		isClickable = false;
		color = 0;
		visual.setFill(Color.WHITE);
	}
	public Pin() {
		color = 0;
		
	}
	public int getColor() {
		return color;
	}
	public void updateColor() {
		switch(color) {
		case 1:
			visual.setFill(Color.BLUE);
			break;
		case 2:
			visual.setFill(Color.RED);
			break;
		case 3:
			visual.setFill(Color.GREEN);
			break;
		case 4:
			visual.setFill(Color.YELLOW);
			break;
		case 5:
			visual.setFill(Color.PURPLE);
			break;
		case 6:
			visual.setFill(Color.BLACK);
			break;
		default:
			visual.setFill(Color.WHITE);
		}
	}
	
	public String getColorName() {
		switch(color) {
		case 1:
			return "Blue";
		case 2:
			return "Red";
		case 3:
			return "Green";
		case 4:
			return "Yellow";
		case 5:
			return "Purple";
		case 6:
			return "Black";
		default:
			return "Empty";
		}
	}
	
	public void clickable(){
		isClickable = true;
	}
	public void notClickable() {
		isClickable = false;
	}
	public void setColor(int i) {
		color = i;
	}

	public void onClick() {
		if(isClickable == true) {
			if(color == 6) {
				color = 1;
			}
			else {
				color++;
			}
			switch(color) {
			case 1:
				visual.setFill(Color.BLUE);
				break;
			case 2:
				visual.setFill(Color.RED);
				break;
			case 3:
				visual.setFill(Color.GREEN);
				break;
			case 4:
				visual.setFill(Color.YELLOW);
				break;
			case 5:
				visual.setFill(Color.PURPLE);
				break;
			case 6:
				visual.setFill(Color.BLACK);
				break;
			default:
				visual.setFill(Color.WHITE);
			}
		}	
	}
}
