

public class VirtualChess {

	
	public static void main(String[] args) {
		Chessboard.Chessmen[][] chessboard = Chessboard.populateBoard();
		Chessboard.printBoard(chessboard);
		int i=0;
		for(;;) {
			if (i%2==0) {
				System.out.println("White's turn");
			} else {
				System.out.println("Black's turn");
			}
		selectAndMovePiece(chessboard,i);
		Chessboard.printBoard(chessboard);
		i++;
		}
	}

	//inquires for a move and returns the chess board
	public static Chessboard.Chessmen[][] selectAndMovePiece(Chessboard.Chessmen[][] chessboard, int i) {
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
				chessboard = Move.movePiece(co_ordinate_array,chessboard);
				break;
			}
		}
		return chessboard;
	}
}
