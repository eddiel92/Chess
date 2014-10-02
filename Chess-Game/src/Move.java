public class Move {
	//receives 4 by 1 integer array and moves piece from start to end position
	public static Chessboard.Chessmen[][] movePiece(int[] a, Chessboard.Chessmen[][] chessboard) {
		Chessboard.Chessmen piece_to_move=chessboard[a[0]][a[1]];
		chessboard[a[0]][a[1]]=Chessboard.Chessmen.EMPTY;
		chessboard[a[2]][a[3]]= piece_to_move;
		return chessboard;
	}
	
	//move up method returns string with possible positions stopping if there is a unit of the same color or opposite color
	public static String moveUp(int[] a, int b, Chessboard.Chessmen[][] chessboard) {
		//a is the initial position of the piece to be moved
		//b is the number of spaces it can move
		String container = "";
		for (int i=1; i<=b; i++) {
			String color_of_current_square = Validation.checkColor(a[0], a[1]+i, chessboard);
			if (color_of_current_square != "NONE") {
				break;
			}
			container += a[0];
			container += a[1]+i;	
		}
		return container;
		
	}

	//eat diagonal-right-up returns string with possible positions stopping once it hits a unit of opposite color 
	public static String eatDiagonalRightUp(int[] a, int b, Chessboard.Chessmen[][] chessboard) {
		//a is the initial position of the piece to be moved
		//b is the number of spaces it can move
		String color_of_piece_to_move = Validation.checkColor(a[0], a[1], chessboard);
		String container = "";
		for (int i=1; i<=b;) {
			String color_of_current_square = Validation.checkColor(a[0]+i, a[1]+i, chessboard);
			if (color_of_current_square == color_of_piece_to_move || color_of_current_square == "NONE") {
				break;
			} else { 
				container += a[0]+i;
				container += a[1]+i;
				break;
			}
		}
		return container;
	}
	
	//eat diagonal-left-up returns string with possible positions stopping once it hits a unit of opposite color
	public static String eatDiagonalLeftUp(int[] a, int b, Chessboard.Chessmen[][] chessboard) {
		String color_of_piece_to_move = Validation.checkColor(a[0], a[1], chessboard);
		String container = "";
		for (int i=1; i<=b;) {
			String color_of_current_square = Validation.checkColor(a[0]-i, a[1]+i, chessboard);
			if (color_of_current_square == color_of_piece_to_move || color_of_current_square == "NONE") {
				break;
			} else { 
				container += a[0]-i;
				container += a[1]+i;
				break;
			}
		}
		return container;
	}

	//move down method returns string with possible positions stopping if there is a unit of the same color or opposite color
	public static String moveDown(int[] a, int b, Chessboard.Chessmen[][] chessboard) {
		//a is the initial position of the piece to be moved
		//b is the number of spaces it can move
		String container = "";
		for (int i=1; i<=b; i++) {
			String color_of_current_square = Validation.checkColor(a[0], a[1]-i, chessboard);
			if (color_of_current_square != "NONE") {
				break;
			}
			container += a[0];
			container += a[1]-i;	
		}
		return container;
		
	}
	
	//eat diagonal-right-down returns string with possible positions stopping once it hits a unit of opposite color 
	public static String eatDiagonalRightDown(int[] a, int b, Chessboard.Chessmen[][] chessboard) {
		//a is the initial position of the piece to be moved
		//b is the number of spaces it can move
		String color_of_piece_to_move = Validation.checkColor(a[0], a[1], chessboard);
		String container = "";
		for (int i=1; i<=b;) {
			String color_of_current_square = Validation.checkColor(a[0]+i, a[1]-i, chessboard);
			if (color_of_current_square == color_of_piece_to_move || color_of_current_square == "NONE") {
				break;
			} else { 
				container += a[0]+i;
				container += a[1]-i;
				break;
			}
		}
		return container;
	}

	//eat diagonal-left-down returns string with possible positions stopping once it hits a unit of opposite color 
	public static String eatDiagonalLeftDown(int[] a, int b, Chessboard.Chessmen[][] chessboard) {
		//a is the initial position of the piece to be moved
		//b is the number of spaces it can move
		String color_of_piece_to_move = Validation.checkColor(a[0], a[1], chessboard);
		String container = "";
		for (int i=1; i<=b;) {
			String color_of_current_square = Validation.checkColor(a[0]-i, a[1]-i, chessboard);
			if (color_of_current_square == color_of_piece_to_move || color_of_current_square == "NONE") {
				break;
			} else { 
				container += a[0]-i;
				container += a[1]-i;
				break;
			}
		}
		return container;
	}
	
	
	//eatAndMoveUp returns string with possible positions stopping once it hits a unit of opposite color
	public static String eatAndMoveUp(int[] a, int b, Chessboard.Chessmen[][] chessboard) {
		//a is the initial position of the piece to be moved
		//b is the number of spaces it can move
		String color_of_piece_to_move = Validation.checkColor(a[0], a[1], chessboard);
		String container = "";
		for (int i=1; i<=Math.min(7-a[1], b); i++) {
			String color_of_current_square = Validation.checkColor(a[0], a[1]+i, chessboard);
			if (color_of_current_square == color_of_piece_to_move) {
				break;
			} else if (color_of_current_square != color_of_piece_to_move &&
					color_of_current_square != "NONE") {
				container += a[0];
				container += a[1]+i;
				break;
			}
			container += a[0];
			container += a[1]+i;	
		}
		return container;
	}
	
	//eatAndMoveDiagonalRightUp returns string with possible positions stopping once it hits a unit of opposite color
	public static String eatAndMoveDiagonalRightUp(int[] a, int b, Chessboard.Chessmen[][] chessboard) {
		//a is the initial position of the piece to be moved
		//b is the number of spaces it can move
		String color_of_piece_to_move = Validation.checkColor(a[0], a[1], chessboard);
		String container = "";
		for (int i=1; i<=Math.min(7-a[1], Math.min(7-a[0],b)); i++) {
			String color_of_current_square = Validation.checkColor(a[0]+i, a[1]+i, chessboard);
			if (color_of_current_square == color_of_piece_to_move) {
				break;
			} else if (color_of_current_square != color_of_piece_to_move &&
					color_of_current_square != "NONE") {
				container += a[0]+i;
				container += a[1]+i;
				break;
			}
			container += a[0]+i;
			container += a[1]+i;	
		}
		return container;
	}

	//eatAndMoveRight returns string with possible positions stopping once it hits a unit of opposite color
	public static String eatAndMoveRight(int[] a, int b, Chessboard.Chessmen[][] chessboard) {
		//a is the initial position of the piece to be moved
		//b is the number of spaces it can move
		String color_of_piece_to_move = Validation.checkColor(a[0], a[1], chessboard);
		String container = "";
		for (int i=1; i<=Math.min(7-a[0],b); i++) {
			String color_of_current_square = Validation.checkColor(a[0]+i, a[1], chessboard);
			if (color_of_current_square == color_of_piece_to_move) {
				break;
			} else if (color_of_current_square != color_of_piece_to_move &&
					color_of_current_square != "NONE") {
				container += a[0]+i;
				container += a[1];
				break;
			}
			container += a[0]+i;
			container += a[1];	
		}
		return container;
	}

	//eatAndMoveDiagonalRightDown returns string with possible positions stopping once it hits a unit of opposite color
	public static String eatAndMoveDiagonalRightDown(int[] a, int b, Chessboard.Chessmen[][] chessboard) {
		//a is the initial position of the piece to be moved
		//b is the number of spaces it can move
		String color_of_piece_to_move = Validation.checkColor(a[0], a[1], chessboard);
		String container = "";
		for (int i=1; i<=Math.min(a[1],Math.min(7-a[0], b)); i++) {
			String color_of_current_square = Validation.checkColor(a[0]+i, a[1]-i, chessboard);
			if (color_of_current_square == color_of_piece_to_move) {
				break;
			} else if (color_of_current_square != color_of_piece_to_move &&
					color_of_current_square != "NONE") {
				container += a[0]+i;
				container += a[1]-i;
				break;
			}
			container += a[0]+i;
			container += a[1]-i;	
		}
		return container;
	}

	//eatAndMoveDown returns string with possible positions stopping once it hits a unit of opposite color
	public static String eatAndMoveDown(int[] a, int b, Chessboard.Chessmen[][] chessboard) {
		//a is the initial position of the piece to be moved
		//b is the number of spaces it can move
		String color_of_piece_to_move = Validation.checkColor(a[0], a[1], chessboard);
		String container = "";
		for (int i=1; i<=Math.min(a[1], b); i++) {
			String color_of_current_square = Validation.checkColor(a[0], a[1]-i, chessboard);
			if (color_of_current_square == color_of_piece_to_move) {
				break;
			} else if (color_of_current_square != color_of_piece_to_move &&
					color_of_current_square != "NONE") {
				container += a[0];
				container += a[1]-i;
				break;
			}
			container += a[0];
			container += a[1]-i;	
		}
		return container;
	}

	//eatAndMoveDiagonalLeftDown returns string with possible positions stopping once it hits a unit of opposite color
	public static String eatAndMoveDiagonalLeftDown(int[] a, int b, Chessboard.Chessmen[][] chessboard) {
		//a is the initial position of the piece to be moved
		//b is the number of spaces it can move
		String color_of_piece_to_move = Validation.checkColor(a[0], a[1], chessboard);
		String container = "";
		for (int i=1; i<=Math.min(a[0], Math.min(a[1], b)); i++) {
			String color_of_current_square = Validation.checkColor(a[0]-i, a[1]-i, chessboard);
			if (color_of_current_square == color_of_piece_to_move) {
				break;
			} else if (color_of_current_square != color_of_piece_to_move &&
					color_of_current_square != "NONE") {
				container += a[0]-i;
				container += a[1]-i;
				break;
			}
			container += a[0]-i;
			container += a[1]-i;	
		}
		return container;
	}

	//eatAndMoveLeft returns string with possible positions stopping once it hits a unit of opposite color
	public static String eatAndMoveLeft(int[] a, int b, Chessboard.Chessmen[][] chessboard) {
		//a is the initial position of the piece to be moved
		//b is the number of spaces it can move
		String color_of_piece_to_move = Validation.checkColor(a[0], a[1], chessboard);
		String container = "";
		for (int i=1; i<=Math.min(a[0], b); i++) {
			String color_of_current_square = Validation.checkColor(a[0]-i, a[1], chessboard);
			if (color_of_current_square == color_of_piece_to_move) {
				break;
			} else if (color_of_current_square != color_of_piece_to_move &&
					color_of_current_square != "NONE") {
				container += a[0]-i;
				container += a[1];
				break;
			}
			container += a[0]-i;
			container += a[1];	
		}
		return container;
	}

	//eatAndMoveDiagonalLeftUp returns string with possible positions stopping once it hits a unit of opposite color
	public static String eatAndMoveDiagonalLeftUp(int[] a, int b, Chessboard.Chessmen[][] chessboard) {
		//a is the initial position of the piece to be moved
		//b is the number of spaces it can move
		String color_of_piece_to_move = Validation.checkColor(a[0], a[1], chessboard);
		String container = "";
		for (int i=1; i<=Math.min(a[0], Math.min(7-a[1], b)); i++) {
			String color_of_current_square = Validation.checkColor(a[0]-i, a[1]+i, chessboard);
			if (color_of_current_square == color_of_piece_to_move) {
				break;
			} else if (color_of_current_square != color_of_piece_to_move &&
					color_of_current_square != "NONE") {
				container += a[0]-i;
				container += a[1]+i;
				break;
			}
			container += a[0]-i;
			container += a[1]+i;	
		}
		return container;
	}
	
	public static String horseLMove(int[] a, Chessboard.Chessmen[][] chessboard) {
		String color_of_piece_to_move = Validation.checkColor(a[0], a[1], chessboard);
		String initialString = "";
		initialString += shapeChecker(a[0]+1,a[1]-2);
		initialString += shapeChecker(a[0]+2,a[1]-1);
		initialString += shapeChecker(a[0]+2,a[1]+1);
		initialString += shapeChecker(a[0]+1,a[1]+2);
		initialString += shapeChecker(a[0]-1,a[1]+2);
		initialString += shapeChecker(a[0]-2,a[1]+1);
		initialString += shapeChecker(a[0]-2,a[1]-1);
		initialString += shapeChecker(a[0]-1,a[1]-2);
		
		String container="";
		for (int i=0; i<initialString.length(); i+=2) {
			String color_of_current_square = Validation.checkColor(Character.getNumericValue(initialString.charAt(i)), Character.getNumericValue(initialString.charAt(i+1)), chessboard);
			if (color_of_current_square == color_of_piece_to_move) {
				continue;
			}
			container += Character.getNumericValue(initialString.charAt(i));
			container += Character.getNumericValue(initialString.charAt(i+1));
		}
		return container;
	}
	
	public static String shapeChecker(int a, int b) {
		String c="";
		if (a<0 || a>7) {
			return c;
		} else if (b<0 || b>7) {
			return c;
		}
		c += a;
		c += b;
		return c;
	}
	
}
	
