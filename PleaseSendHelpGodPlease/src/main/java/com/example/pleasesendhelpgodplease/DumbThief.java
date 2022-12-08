package com.example.pleasesendhelpgodplease;

import java.io.FileNotFoundException;

/**frankly if it says check ++ a direction and you ask me what it does i will spit in your face
 * same goes for check ++ a direction ++ "colour"
 *
 */
public class DumbThief extends Thieves{
	private CharSequence tileColour;
	private int[] coords;
	//needed to handle wall follow
	private char dirFacing;
	private int velocity;


	/**
	 *
	 * @param coords - the coords that the DT is put on upon instantialisation
	 * @param dirFacing - the original direction facing
	 */
	public DumbThief(int[] coords, char dirFacing ) {
		this.dirFacing = dirFacing;
		this.coords = coords;
	}


	/**
	 * the main method that will be used to move the DT, providing continuous input( probably the clock )
	 */
	public void move () throws FileNotFoundException {
		//left is the same colour and back left is the wrong(turn)
		if(checkForward(dirFacing)) {
			turn90(dirFacing);
		}
		else if(checkLeft(dirFacing) && checkBackLeft(dirFacing)) {
			theOtherTurn90(dirFacing);
		}else {
			forward(dirFacing, coords);
		}
	}


	/**
	 *
	 * @param dirFacing - the bearing of the DT, allowing us to ascertain what left is relative to the DT
	 * @return true if the colour of the left tile is the same as the assigned colour of the DT
	 */
	public boolean checkLeft(char dirFacing) throws FileNotFoundException {
		Menu menu = new Menu();
		switch(dirFacing) {
			case 'N':
				return sameColourCheck(menu.getBoard().getTile(coords[0]-1, coords[1]).getColoursAsString());
			case 'E':
				return sameColourCheck(menu.getBoard().getTile(coords[0], coords[1]+1).getColoursAsString());
			case 'S':
				return sameColourCheck(menu.getBoard().getTile(coords[0]+1, coords[1]).getColoursAsString());
			case 'W':
				return sameColourCheck(menu.getBoard().getTile(coords[0], coords[1]-1).getColoursAsString());
		}
		return false;
	}



	/**
	 *
	 * @param dirFacing - the direction that we are checking in
	 * @return true if the colour of the forward tile is different to the assigned colour of the DT
	 */
	public boolean checkForward(char dirFacing) throws FileNotFoundException {
		Menu menu = new Menu();
		switch(dirFacing) {
			case 'N':
				return diffColourCheck(menu.getBoard().getTile(coords[0], coords[1]+1).getColoursAsString());
			case 'E':
				return diffColourCheck(menu.getBoard().getTile(coords[0]+1, coords[1]).getColoursAsString());
			case 'S':
				return diffColourCheck(menu.getBoard().getTile(coords[0], coords[1]-1).getColoursAsString());
			case 'W':
				return diffColourCheck(menu.getBoard().getTile(coords[0]-1, coords[1]).getColoursAsString());
		}
		return false;
	}


	/**
	 *
	 * @param dirFacing the direction the donny is facing
	 * @return true if the
	 */
	public boolean checkBackLeft(char dirFacing) throws FileNotFoundException {
		Menu menu = new Menu();
		switch(dirFacing) {
			case 'N':
				return diffColourCheck(menu.getBoard().getTile(coords[0]-1, coords[1]-1).getColoursAsString());
			case 'E':
				return diffColourCheck(menu.getBoard().getTile(coords[0]-1, coords[1]+1).getColoursAsString());
			case 'S':
				return diffColourCheck(menu.getBoard().getTile(coords[0]+1, coords[1]+1).getColoursAsString());
			case 'W':
				return diffColourCheck(menu.getBoard().getTile(coords[0]+1, coords[1]-1).getColoursAsString());
		}
		return false;
	}


	/**
	 * method to change the coordinates of the DT
	 * @param coords the current coords of the DT
	 */
	public void changeCoords(int[] coords) {
		switch(dirFacing) {
			case 'N':
				coords[1] += 1;
			case 'E':
				coords[0] += 1;
			case 'S':
				coords[1] -= 1;
			case 'W':
				coords[0] -= 1;		}
	}



	/**
	 *
	 * @param tileColours - the tile colour that the DT has been assigned
	 * @return true if the colour of the left tile is the same as the assigned colour of the DT
	 */
	public boolean sameColourCheck(String tileColours) {
		return(tileColours.contains(tileColour));
	}

	/**
	 * diffCheck because in order to turn they must be different colours
	 * @param tileColours - the colours of the tile on Board
	 * @return true if the colours are different
	 */
	public boolean diffColourCheck(String tileColours) {
		if (tileColours.contains(tileColour)) {
			return false;
		}else {
			return true;
		}

	}



	/**method to turn the donny clockwise
	 * changes the direction that the DT is facing by +90
	 * @param dirFacing
	 */
	public void turn90(char dirFacing) {
		switch(dirFacing) {
			case 'N':
				dirFacing = 'E';
			case 'E':
				dirFacing = 'S';
			case 'S':
				dirFacing = 'W';
			case 'W':
				dirFacing = 'N';
		}
	}


	/**method to turn donny counter-clockwise
	 * changes the direction that the DT is facing -90
	 * @param dirFacing
	 */
	public void theOtherTurn90(char dirFacing) {
		switch(dirFacing) {
			case 'N':
				dirFacing = 'W';
			case 'E':
				dirFacing = 'N';
			case 'S':
				dirFacing = 'E';
			case 'W':
				dirFacing = 'S';	}
	}
	
	/**
	 * method to move the DT around the boards
	 * @param dirFacing the direction we are moving
	 * @param coords the coords we are moving from 
	 */
	public void forward(char dirFacing, int[] coords){
		switch(dirFacing) {
			case ('N'):
				coords[1] += 1;
			case ('E'):
				coords[0] += 1;
			case ('S'):
				coords[1] -= 1;
			case ('W'):
				coords[0] -= 1;
		}
	}
		



}
