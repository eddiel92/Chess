import java.util.Scanner;


public class VirtualChess {

	
	public static void main(String[] args) {
		Chessboard.Chessmen[][] chessboard = Chessboard.populateBoard();
		Chessboard.printBoard(chessboard);
		int i=0;
		boolean[][] castle_array = new boolean[2][3];
		for (int a=1; a<=2; a++) {
			for (int b=1; b<=3; b++) {
				castle_array[a-1][b-1] = true;
			}
		}
		for(;;) {
			if (i%2==0) {
				System.out.println("White's turn");
			} else {
				System.out.println("Black's turn");
			}
		castle_array = Validation.castleChecker(castle_array, chessboard);
		selectAndMovePiece(chessboard,i,castle_array);
		Chessboard.printBoard(chessboard);
		i++;
		}
	}

	//inquires for a move and returns the chess board
	public static Chessboard.Chessmen[][] selectAndMovePiece(Chessboard.Chessmen[][] chessboard, int i, boolean[][] castle_array) {
		String input = Validation.stringChecker();
		int[] co_ordinate_array=Conversion.stringToIntArray(input);
		int j=i%2;
		
		for(;;) {
			if(Validation.validateMove(j, co_ordinate_array, chessboard)==false) {
				Chessboard.printBoard(chessboard);
				input = Validation.stringChecker();
				co_ordinate_array=Conversion.stringToIntArray(input);
				continue;
			} else {
				//checks for left white rook castle
				if(input.equals("a1 to d1")
					&& j==0
					&& castle_array[1][0] == true
					&& castle_array[1][1] == true
					&& chessboard[0][0] == Chessboard.Chessmen.WHITE_ROOK
					&& chessboard[4][0] == Chessboard.Chessmen.WHITE_KING
					&& chessboard[3][0] == Chessboard.Chessmen.EMPTY
					&& chessboard[1][0] == Chessboard.Chessmen.EMPTY
					&& chessboard[2][0] == Chessboard.Chessmen.EMPTY) 
					{
					System.out.println("Do you want to castle? Please type 'yes' or 'no'?");
					for(;;) {
						@SuppressWarnings("resource")
						Scanner sc = new Scanner(System.in);
						String choose = sc.nextLine();
						if (choose.equals("yes")) {
							chessboard[2][0] = Chessboard.Chessmen.WHITE_KING;
							chessboard[1][0] = Chessboard.Chessmen.EMPTY;
							chessboard[0][0] = Chessboard.Chessmen.EMPTY;
							chessboard[3][0] = Chessboard.Chessmen.WHITE_ROOK;
							break;
						} else if (choose.equals("no")) {
							chessboard[3][0] = Chessboard.Chessmen.WHITE_ROOK;
							chessboard[0][0] = Chessboard.Chessmen.EMPTY;
							break;
						} else {
							System.out.println("Please enter something valid");
							continue;
						}
					}
					break;
				} 
				//checks for right white rook castle
				if (input.equals("h1 to f1")
						&& j==0
						&& castle_array[1][2] == true
						&& castle_array[1][1] == true
						&& chessboard[7][0] == Chessboard.Chessmen.WHITE_ROOK
						&& chessboard[4][0] == Chessboard.Chessmen.WHITE_KING
						&& chessboard[6][0] == Chessboard.Chessmen.EMPTY
						&& chessboard[5][0] == Chessboard.Chessmen.EMPTY) {
					System.out.println("Do you want to castle? Please type 'yes' or 'no'?");
					for(;;) {
						@SuppressWarnings("resource")
						Scanner sc = new Scanner(System.in);
						String choose = sc.nextLine();
						if (choose.equals("yes")) {
							chessboard[5][0] = Chessboard.Chessmen.WHITE_ROOK;
							chessboard[6][0] = Chessboard.Chessmen.WHITE_KING;
							chessboard[4][0] = Chessboard.Chessmen.EMPTY;
							break;
						} else if (choose.equals("no")) {
							chessboard[5][0] = Chessboard.Chessmen.WHITE_ROOK;
							chessboard[7][0] = Chessboard.Chessmen.EMPTY;
							break;
						} else {
							System.out.println("Please enter something valid");
							continue;
						}
					}
				}
				//checks for left black rook castle
				if(input.equals("a8 to d8")
					&& j==1
					&& castle_array[0][0] == true
					&& castle_array[0][1] == true
					&& chessboard[0][7] == Chessboard.Chessmen.BLACK_ROOK
					&& chessboard[4][7] == Chessboard.Chessmen.BLACK_KING
					&& chessboard[1][7] == Chessboard.Chessmen.EMPTY
					&& chessboard[2][7] == Chessboard.Chessmen.EMPTY
					&& chessboard[3][7] == Chessboard.Chessmen.EMPTY) 
					{
					System.out.println("Do you want to castle? Please type 'yes' or 'no'?");
					for(;;) {
						@SuppressWarnings("resource")
						Scanner sc = new Scanner(System.in);
						String choose = sc.nextLine();
						if (choose.equals("yes")) {
							chessboard[3][7] = Chessboard.Chessmen.BLACK_ROOK;
							chessboard[2][7] = Chessboard.Chessmen.BLACK_KING;
							chessboard[1][7] = Chessboard.Chessmen.EMPTY;
							chessboard[0][7] = Chessboard.Chessmen.EMPTY;
							chessboard[4][7] = Chessboard.Chessmen.EMPTY;
							break;
						} else if (choose.equals("no")) {
							chessboard[3][7] = Chessboard.Chessmen.BLACK_ROOK;
							chessboard[0][7] = Chessboard.Chessmen.EMPTY;
							break;
						} else {
							System.out.println("Please enter something valid");
							continue;
						}
					}
					break;
				} 
				//checks for right black rook castle
				if(input.equals("h8 to f8")
					&& j==1
					&& castle_array[0][2] == true
					&& castle_array[0][1] == true
					&& chessboard[7][7] == Chessboard.Chessmen.BLACK_ROOK
					&& chessboard[4][7] == Chessboard.Chessmen.BLACK_KING
					&& chessboard[5][7] == Chessboard.Chessmen.EMPTY
					&& chessboard[6][7] == Chessboard.Chessmen.EMPTY) 
					{
					System.out.println("Do you want to castle? Please type 'yes' or 'no'?");
					for(;;) {
						@SuppressWarnings("resource")
						Scanner sc = new Scanner(System.in);
						String choose = sc.nextLine();
						if (choose.equals("yes")) {
							chessboard[5][7] = Chessboard.Chessmen.BLACK_ROOK;
							chessboard[6][7] = Chessboard.Chessmen.BLACK_KING;
							chessboard[7][7] = Chessboard.Chessmen.EMPTY;
							chessboard[4][7] = Chessboard.Chessmen.EMPTY;
							break;
						} else if (choose.equals("no")) {
							chessboard[5][7] = Chessboard.Chessmen.BLACK_ROOK;
							chessboard[7][7] = Chessboard.Chessmen.EMPTY;
							break;
						} else {
							System.out.println("Please enter something valid");
							continue;
						}
					}
					break;
				} 
				else {
				chessboard = Move.movePiece(co_ordinate_array,chessboard);
				break;
				}
			}
		}
		return chessboard;
	}
}
