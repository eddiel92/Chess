import java.util.Scanner;


public class Validation {
	//asks for string checks if input string is valid and if not reasks for input, if input is valid it returns the string
	public static String stringChecker() {
		System.out.println("Enter a move i.e. 'e7 to e5'");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String choose = sc.nextLine();
		String[] split;
		for(;;) {
			if (choose.length()<8) {
			System.out.println("Enter a move i.e. 'e7 to e5'");
			choose = sc.nextLine();
			}
			else {
				break;
			}
		}
		split = choose.split("\\s+");
			for(;;) {
				 if ((split[0].startsWith("a") ||
						 split[0].startsWith("b") ||
						 split[0].startsWith("c") ||
						 split[0].startsWith("d") ||
						 split[0].startsWith("e") ||
						 split[0].startsWith("f") ||
						 split[0].startsWith("g") ||
						 split[0].startsWith("h")) &&
						 
						 (split[0].startsWith("1", 1) ||
								 split[0].startsWith("2", 1) ||
								 split[0].startsWith("3", 1) ||
								 split[0].startsWith("4", 1) ||
								 split[0].startsWith("5", 1) ||
								 split[0].startsWith("6", 1) ||
								 split[0].startsWith("7", 1) ||
								 split[0].startsWith("8", 1)) &&
								 
								 (split[2].startsWith("a") ||
										 split[2].startsWith("b") ||
										 split[2].startsWith("c") ||
										 split[2].startsWith("d") ||
										 split[2].startsWith("e") ||
										 split[2].startsWith("f") ||
										 split[2].startsWith("g") ||
										 split[2].startsWith("h")) &&
										 
										 (split[2].startsWith("1", 1) ||
												 split[2].startsWith("2", 1) ||
												 split[2].startsWith("3", 1) ||
												 split[2].startsWith("4", 1) ||
												 split[2].startsWith("5", 1) ||
												 split[2].startsWith("6", 1) ||
												 split[2].startsWith("7", 1) ||
												 split[2].startsWith("8", 1))
								
						 ) {
					 		return choose;
				 } else {
					System.out.println("Please enter a valid move: ");
					choose = sc.nextLine();
					split = choose.split("\\s+");
					continue;
				 }
			}		
			
		}

	//validates the identity of a moved piece and returns whether or not the command can be executed 
	public static boolean validateMove(int colorInt, int[] a, Chessboard.Chessmen[][] chessboard) {
		Chessboard.Chessmen piece_to_move=chessboard[a[0]][a[1]];
		String color_of_piece=checkColor(a[0],a[1], chessboard);
		String colorTurn;
		if (colorInt == 0) {
			colorTurn = "WHITE";
		} else {
			colorTurn = "BLACK";
		}
		
		if(!color_of_piece.equals(colorTurn)) {
			return false;
		}
		
		int final_x=a[2];
		int final_y=a[3];
		//parse final_x and final_y into a string
		String final_xy_string=String.valueOf(final_x)+String.valueOf(final_y);
		
		if (piece_to_move == Chessboard.Chessmen.WHITE_PAWN ) {
			String position_string=Move.moveUp(a,1,chessboard);
			if (a[1]==1) {
				position_string+=Move.moveUp(a,2,chessboard);
			}
			if (a[0] != 7) {
			position_string += Move.eatDiagonalRightUp(a, 1, chessboard);
			}
			if (a[0] != 0) {
				position_string += Move.eatDiagonalLeftUp(a, 1, chessboard);
			}
			String[] position_array = position_string.split("(?<=\\G..)");
			for (int i=1; i<=position_array.length; i++) {
				if(final_xy_string.equals(position_array[i-1])) {
					return true;
				}
			}
			return false;
		} 
		
		if (piece_to_move == Chessboard.Chessmen.WHITE_ROOK || piece_to_move == Chessboard.Chessmen.BLACK_ROOK ) {
			String position_string=Move.eatAndMoveUp(a,8, chessboard);
			position_string += Move.eatAndMoveRight(a,8, chessboard);
			position_string += Move.eatAndMoveDown(a,8, chessboard);
			position_string += Move.eatAndMoveLeft(a,8, chessboard);
			String[] position_array = position_string.split("(?<=\\G..)");
			for (int i=1; i<=position_array.length; i++) {
				if(final_xy_string.equals(position_array[i-1])) {
					return true;
				}
			}
			return false;
		} 
		
		if (piece_to_move == Chessboard.Chessmen.WHITE_BISHOP || piece_to_move == Chessboard.Chessmen.BLACK_BISHOP) {
			String position_string=Move.eatAndMoveDiagonalRightUp(a, 8, chessboard);
			position_string+=Move.eatAndMoveDiagonalLeftUp(a, 8, chessboard);
			position_string+=Move.eatAndMoveDiagonalRightDown(a, 8, chessboard);
			position_string+=Move.eatAndMoveDiagonalLeftDown(a, 8, chessboard);
			String[] position_array = position_string.split("(?<=\\G..)");
			for (int i=1; i<=position_array.length; i++) {
				if(final_xy_string.equals(position_array[i-1])) {
					return true;
				}
			}
			return false;
		} 
		
		if (piece_to_move == Chessboard.Chessmen.WHITE_QUEEN || piece_to_move == Chessboard.Chessmen.BLACK_QUEEN) {
			String position_string=Move.eatAndMoveDiagonalRightUp(a, 8, chessboard);
			position_string+=Move.eatAndMoveDiagonalLeftUp(a, 8, chessboard);
			position_string+=Move.eatAndMoveDiagonalRightDown(a, 8, chessboard);
			position_string+=Move.eatAndMoveDiagonalLeftDown(a, 8, chessboard);
			position_string+=Move.eatAndMoveUp(a,8, chessboard);
			position_string += Move.eatAndMoveRight(a,8, chessboard);
			position_string += Move.eatAndMoveDown(a,8, chessboard);
			position_string += Move.eatAndMoveLeft(a,8, chessboard);
			String[] position_array = position_string.split("(?<=\\G..)");
			for (int i=1; i<=position_array.length; i++) {
				if(final_xy_string.equals(position_array[i-1])) {
					return true;
				}
			}
			return false;
		} 
		
		if (piece_to_move == Chessboard.Chessmen.WHITE_KING || piece_to_move == Chessboard.Chessmen.BLACK_KING) {
			String position_string=Move.eatAndMoveDiagonalRightUp(a, 1, chessboard);
			position_string+=Move.eatAndMoveDiagonalLeftUp(a, 1, chessboard);
			position_string+=Move.eatAndMoveDiagonalRightDown(a, 1, chessboard);
			position_string+=Move.eatAndMoveDiagonalLeftDown(a, 1, chessboard);
			position_string+=Move.eatAndMoveUp(a,1, chessboard);
			position_string += Move.eatAndMoveRight(a,1, chessboard);
			position_string += Move.eatAndMoveDown(a,1, chessboard);
			position_string += Move.eatAndMoveLeft(a,1, chessboard);
			String[] position_array = position_string.split("(?<=\\G..)");
			for (int i=1; i<=position_array.length; i++) {
				if(final_xy_string.equals(position_array[i-1])) {
					return true;
				}
			}
			return false;
		} 
		
		if (piece_to_move == Chessboard.Chessmen.WHITE_KNIGHT || piece_to_move == Chessboard.Chessmen.BLACK_KNIGHT ) {
			String position_string = Move.horseLMove(a, chessboard);
			String[] position_array = position_string.split("(?<=\\G..)");
			for (int i=1; i<=position_array.length; i++) {
				if(final_xy_string.equals(position_array[i-1])) {
					return true;
				}
			}
			return false;
		}
		
		if (piece_to_move == Chessboard.Chessmen.BLACK_PAWN ) {
			String position_string=Move.moveDown(a,1,chessboard);
			if (a[1]==6) {
				position_string+=Move.moveDown(a,2,chessboard);
			}
			if(a[0]!=7) {
				position_string += Move.eatDiagonalRightDown(a, 1, chessboard);
			}
			if(a[0]!=0) {
				position_string += Move.eatDiagonalLeftDown (a, 1, chessboard);
			}
			String[] position_array = position_string.split("(?<=\\G..)");
			for (int i=1; i<=position_array.length; i++) {
				if(final_xy_string.equals(position_array[i-1])) {
					return true;
				}
			}
			return false;
		}
		
		else {
		return true;
		}
	}
	
	//check color method returns the color of a piece given its coordinate position on the board
	public static String checkColor(int x_pos, int y_pos, Chessboard.Chessmen[][] chessboard) {
		Chessboard.Chessmen piece_to_move=chessboard[x_pos][y_pos];
		String color;
		if (piece_to_move==Chessboard.Chessmen.WHITE_ROOK ||
				piece_to_move==Chessboard.Chessmen.WHITE_QUEEN ||
				piece_to_move==Chessboard.Chessmen.WHITE_KING ||
				piece_to_move==Chessboard.Chessmen.WHITE_BISHOP ||
				piece_to_move==Chessboard.Chessmen.WHITE_PAWN ||
				piece_to_move==Chessboard.Chessmen.WHITE_KNIGHT) {
			 color = "WHITE";
		} 
		else if (piece_to_move==Chessboard.Chessmen.BLACK_ROOK ||
				piece_to_move==Chessboard.Chessmen.BLACK_QUEEN ||
				piece_to_move==Chessboard.Chessmen.BLACK_KING ||
				piece_to_move==Chessboard.Chessmen.BLACK_BISHOP ||
				piece_to_move==Chessboard.Chessmen.BLACK_PAWN ||
				piece_to_move==Chessboard.Chessmen.BLACK_KNIGHT)  {
			color = "BLACK";
		} else {
			color = "NONE";
		}
		return color;
	}

	//receives board and a Boolean array encoding whether or not the rooks and kings have been moved and returns the same boolean array
	public static boolean[][] castleChecker(boolean[][] castle_array, Chessboard.Chessmen[][] chessboard) {
		if (castle_array[0][0] == true) {
			if(chessboard[0][7] != Chessboard.Chessmen.BLACK_ROOK) {
				castle_array[0][0] = false;
			}
		}
		if (castle_array[0][1] == true) {
			if(chessboard[4][7] != Chessboard.Chessmen.BLACK_KING) {
				castle_array[0][1] = false;
			}
		}
		if (castle_array[0][2] == true) {
			if(chessboard[7][7] != Chessboard.Chessmen.BLACK_ROOK) {
				castle_array[0][2] = false;
			}
		}
		if (castle_array[1][0] == true) {
			if(chessboard[0][0] != Chessboard.Chessmen.WHITE_ROOK) {
				castle_array[1][0] = false;
			}
		}
		if (castle_array[1][1] == true) {
			if(chessboard[4][0] != Chessboard.Chessmen.WHITE_KING) {
				castle_array[1][1] = false;
			}
		}
		if (castle_array[1][2] == true) {
			if(chessboard[7][0] != Chessboard.Chessmen.WHITE_ROOK) {
				castle_array[1][2] = false;
			}
		}
		
		return castle_array;
		
	}
	
}
