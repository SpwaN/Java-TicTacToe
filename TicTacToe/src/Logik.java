
public class Logik {
	public int alternate = 0;
	int likaTest = 0;

	public boolean kollaVinst() {
		/**
		 * Reference: the button array is arranged like this as the board 0 | 1 | 2 3 |
		 * 4 | 5 6 | 7 | 8
		 * https://medium.com/byte-tales/the-classic-tic-tac-toe-game-in-python-3-1427c68b8874
		 */
		// horizontal win check
		if (kollaNärliggande(0, 1) && kollaNärliggande(1, 2)) // no need to put " == true" because the default check i
																//  for true
			return true;
		else if (kollaNärliggande(3, 4) && kollaNärliggande(4, 5))
			return true;
		else if (kollaNärliggande(6, 7) && kollaNärliggande(7, 8))
			return true;

		// vertical win check
		else if (kollaNärliggande(0, 3) && kollaNärliggande(3, 6))
			return true;
		else if (kollaNärliggande(1, 4) && kollaNärliggande(4, 7))
			return true;
		else if (kollaNärliggande(2, 5) && kollaNärliggande(5, 8))
			return true;

		// diagonal win check
		else if (kollaNärliggande(0, 4) && kollaNärliggande(4, 8))
			return true;
		else if (kollaNärliggande(2, 4) && kollaNärliggande(4, 6))
			return true;
		else
			return false;
	}

	public boolean kollaNärliggande(int a, int b) {
		if (GameScreen.button[a].getText().equals(GameScreen.button[b].getText()) == true
				&& !GameScreen.button[a].getText().equals("   ")) {
			return true;
		} else {
			likaTest++;
			System.out.println(Integer.toString(likaTest));
			return false;
		}
	}
	
	public void AndraTur() {
		alternate++;
	}
	
	public void Reset() {
		alternate = 0;
		likaTest = 0;
	}
}
