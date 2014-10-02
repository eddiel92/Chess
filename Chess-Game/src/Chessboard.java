
public class Chessboard{
	
	//defines the enum method Chessmen
	public enum Chessmen {
		WHITE_KING,
		WHITE_QUEEN,
		WHITE_ROOK, 
		WHITE_BISHOP, 
		WHITE_KNIGHT, 
		WHITE_PAWN, 
		BLACK_KING, 
		BLACK_QUEEN, 
		BLACK_ROOK, 
		BLACK_BISHOP, 
		BLACK_KNIGHT, 
		BLACK_PAWN, 
		EMPTY
	}
	
	//initializes the board returns the chess board
	public static Chessmen[][] populateBoard(){
		Chessmen[][] chessboard = new Chessmen[8][8];
		//variable x runs along the x-axis
		//variable y runs along the y-axis
		for(int y=0; y<=7; y++){
			for (int x=0; x<=7; x++) {
				if (y>=2 && y <=5)
					 chessboard[x][y] = Chessmen.EMPTY;
			} 
		}
			chessboard[0][0] = Chessmen.WHITE_ROOK;
			chessboard[7][0] = Chessmen.WHITE_ROOK;
			chessboard[1][0] = Chessmen.WHITE_KNIGHT;
			chessboard[6][0] = Chessmen.WHITE_KNIGHT;
			chessboard[2][0] = Chessmen.WHITE_BISHOP;
			chessboard[5][0] = Chessmen.WHITE_BISHOP;
			chessboard[4][0] = Chessmen.WHITE_KING;
			chessboard[3][0] = Chessmen.WHITE_QUEEN;
			
			chessboard[0][1]= Chessmen.WHITE_PAWN;
			chessboard[1][1]= Chessmen.WHITE_PAWN;
			chessboard[2][1]= Chessmen.WHITE_PAWN;
			chessboard[3][1]= Chessmen.WHITE_PAWN;
			chessboard[4][1]= Chessmen.WHITE_PAWN;
			chessboard[5][1]= Chessmen.WHITE_PAWN;
			chessboard[6][1]= Chessmen.WHITE_PAWN;
			chessboard[7][1]= Chessmen.WHITE_PAWN;
			
			chessboard[0][7] = Chessmen.BLACK_ROOK;
			chessboard[7][7] = Chessmen.BLACK_ROOK;
			chessboard[1][7] = Chessmen.BLACK_KNIGHT;
			chessboard[6][7] = Chessmen.BLACK_KNIGHT;
			chessboard[2][7] = Chessmen.BLACK_BISHOP;
			chessboard[5][7] = Chessmen.BLACK_BISHOP;
			chessboard[4][7] = Chessmen.BLACK_KING;
			chessboard[3][7] = Chessmen.BLACK_QUEEN;
			
			chessboard[0][6]= Chessmen.BLACK_PAWN;
			chessboard[1][6]= Chessmen.BLACK_PAWN;
			chessboard[2][6]= Chessmen.BLACK_PAWN;
			chessboard[3][6]= Chessmen.BLACK_PAWN;
			chessboard[4][6]= Chessmen.BLACK_PAWN;
			chessboard[5][6]= Chessmen.BLACK_PAWN;
			chessboard[6][6]= Chessmen.BLACK_PAWN;
			chessboard[7][6]= Chessmen.BLACK_PAWN;

		return chessboard;
		
	}
	
	//prints the board 
	public static void printBoard(Chessmen[][] chessboard) {
		//variable x runs along the x-axis
		//variable y runs along the y-axis
		System.out.println("\ta\tb\tc\td\te\tf\tg\th");
		for(int y=7; y>=0; y--){
			System.out.print(y+1 + ". ");
			for (int x=0; x<=7; x++) {
				if(chessboard[x][y] == Chessmen.WHITE_ROOK){
					System.out.print("\t\u2656");
				}
				else if(chessboard[x][y] == Chessmen.WHITE_KNIGHT){
					System.out.print("\t\u2658");
				}
				else if(chessboard[x][y] == Chessmen.WHITE_BISHOP){
					System.out.print("\t\u2657");
				}
				else if(chessboard[x][y] == Chessmen.WHITE_QUEEN){
					System.out.print("\t\u2655");
				}
				else if(chessboard[x][y] == Chessmen.WHITE_KING){
					System.out.print("\t\u2654");
				}
				else if(chessboard[x][y] == Chessmen.WHITE_PAWN){
					System.out.print("\t\u2659");
				}
				else if(chessboard[x][y] == Chessmen.BLACK_ROOK){
					System.out.print("\t\u265C");
				}
				else if(chessboard[x][y] == Chessmen.BLACK_KNIGHT){
					System.out.print("\t\u265E");
				}
				else if(chessboard[x][y] == Chessmen.BLACK_BISHOP){
					System.out.print("\t\u265D");
				}
				else if(chessboard[x][y] == Chessmen.BLACK_QUEEN){
					System.out.print("\t\u265B");
				}
				else if(chessboard[x][y] == Chessmen.BLACK_KING){
					System.out.print("\t\u265A");
				}
				else if(chessboard[x][y] == Chessmen.BLACK_PAWN){
					System.out.print("\t\u265F");
				}
				else if(chessboard[x][y] == Chessmen.EMPTY){
					System.out.print("\t");
				};
			}
		System.out.println("");
		}
	}
}