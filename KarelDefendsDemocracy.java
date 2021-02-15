package week1;
import stanford.karel.*;

public class KarelDefendsDemocracy extends SuperKarel {

	public void run() {
		while (frontIsClear()) {
			move();
			processRectangle();
			move();
		}
				
	}
	
	public void processRectangle() {
		turnLeft();
		moveToWall();
		turnAround();
		int numberBeepers = 0;
		int numberRows = 0;
		boolean turnRight = true;
		do {
			numberRows++;
			if (beepersPresent()) {
				numberBeepers++;
			}
			move();
		} while (frontIsClear());
		
		if ((numberBeepers != 0) && (numberBeepers < numberRows)) {
			pickAllBeepers();
			turnRight = false;
		} 
			
	    returnInitialPoint(turnRight, numberRows);
			
	}
	
	public void pickAllBeepers() {
		turnAround();
		while (beepersPresent()) {
			pickBeeper();
		}
		while (frontIsClear()){
			move();
			while (beepersPresent()) {
				pickBeeper();
			}
		} 
	}
	
	public void returnInitialPoint(boolean turnRight, int numberRows) {
		turnAround();
		int initialPoint = numberRows / 2;
		for (int i = 0; i<initialPoint; i++) { 
				move();
		}		
		if (turnRight) {
			turnRight();
		} else {
			turnLeft();
		}
	}
	
	public void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}
	
	public void turnAround() {
		turnLeft();
		turnLeft();
		
	}
	
	public void moveToWall() {
		while (frontIsClear()) {
			move();
		}
	}
}
