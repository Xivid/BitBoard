package ch.n1b.reversi.board;

import reversi.Coordinates;
import reversi.GameBoard;
import reversi.OutOfBoundsException;

import java.util.Vector;

/** <font face="Courier New"> <pre>
 * ________________________________________   
 * _____  __ )_  __ \__    |__  __ \__  __ \  
 * ____  __  |  / / /_  /| |_  /_/ /_  / / /  
 * ___  /_/ // /_/ /_  ___ |  _, _/_  /_/ /   
 * __/_____/ \____/ /_/  |_/_/ |_| /_____/     
 * </pre> </font>    
 * This is a new implementation of GameBoard. It's about 3x faster...
 *
 * Made for Informatik 2 D-ITET, Reversi / Othello Tournament
 * 
 * @author Thomas Richner
 * @version 0.8 now with Bitboards!
 * @license (C) by Thomas Richner
 */

public class BitBoard implements Cloneable {
	public class OutOfRange extends Throwable{private static final long serialVersionUID = 1L;}
	final int
		GREEN = 2,
		RED   = 1,
		EMPTY = 0;
	int ENEMY = 1, PLAYER = 2;
	 /*
	{0,0,0,0,0,0,0,0,   0x00
	 0,0,0,0,0,0,0,0,   0x00
	 0,0,0,0,0,0,0,0,   0x00
	 0,0,0,R,R,0,0,0,   0x18
	 0,0,0,G,G,0,0,0,   0x18
	 0,0,0,0,0,0,0,0,   0x00
	 0,0,0,0,0,0,0,0,   0x00
	 0,0,0,0,0,0,0,0};  0x00
	 */
	
	/*
	 *    A  B  C  D  E  F  G  H
	 * 1| 56 57 58 59 60 61 62 63
	 * 2| 48 49 50 51 52 53 54 55
	 * 3| 40 41 42 43 44 45 46 47
	 * 4| 32 33 34 35 36 37 38 39
	 * 5| 24 25 26 27 28 29 30 31
	 * 6| 16 17 18 19 20 21 22 23
	 * 7| 08 09 10 11 12 13 14 15
	 * 8| 00 01 02 03 04 05 06 07
	 * 
	 */

	//Red's Board as bitfield
	private long RB = Bitfields.BIT35 | Bitfields.BIT36;
	//Green's Board as bitfield
	private long GB = Bitfields.BIT27 | Bitfields.BIT28;

	/**
	 * Initializes a new Board with the reversi 
	 * start-constellation
	 */
	public BitBoard(){}
	/**
	 * Initializes a new Board as a Copy of another board
	 * @param bd given Board
	 */
	public BitBoard(BitBoard bd){
		this.RB = bd.RB;
		this.GB = bd.GB;
	}

	public BitBoard(GameBoard gb){
		readBoard(gb);
	}

	public void readBoard(GameBoard gb){
		int occupation;
		for(int y = 0;y<8;y++){
			for(int x = 0;x<8;x++){
				try {
					occupation = gb.getOccupation(new Coordinates(y+1,x+1));
					if(occupation==RED)   RB |= Bitfields.xyToBit(x, y);
					else
					if(occupation==GREEN) GB |= Bitfields.xyToBit(x, y);
				} catch (OutOfBoundsException e) {
					System.out.println("Error while copying the GameBoard");
					System.out.println("at y: " + y + "  x: " + x);
				}
			}
		}
		
	}
	
	
//======================bit CheckMove
	
	/*  << 7  << 8   << 9   >>> 9  >>> 8  >>> 7
	 * X O O  O X O  O O X  O O O  O O O  O O O
	 * O X O  O X O  O X O  O X O  O X O  O X O
	 * O O O  O O O  O O O  X O O  O X O  O O X
	 *  
	 */
	/**
	 * Checks if the move at x/y is valid
	 * @param x x-Coordinate
	 * @param y y-Coordinate
	 * @param player the player which wants to move there
	 * @return true if the move is valid, else false
	 */
	public boolean checkMove(int x, int y, int player){
		if(!isEmpty(x,y)) return false;

		long EB, PB;
		if(player==GameBoard.GREEN){
			PB = GB;
			EB = RB;
		}else{
			PB = RB;
			EB = GB;
		}
	    //Followers:
		
		//left up
		long CURPOS = Bitfields.xyToBit(x, y);
		long POS = CURPOS;
		//follow diag left-up
		POS = Bitfields.shiftNW(POS);
		if((POS & EB)>0){
			POS = Bitfields.shiftNW(POS);
			while((POS & EB) >0){
				POS = Bitfields.shiftNW(POS);
			}
			if((POS & PB)>0) return true;
		}
		//follow up
		POS = CURPOS;
		POS = Bitfields.shiftN(POS);
		if((POS & EB)>0){
			POS = Bitfields.shiftN(POS);
			while((POS & EB) >0){
				POS = Bitfields.shiftN(POS);
			}
			if((POS & PB)>0) return true;
		}
		
		//follow up-right
		POS = CURPOS;
		POS = Bitfields.shiftNO(POS);
		if((POS & EB)>0){
			POS = Bitfields.shiftNO(POS);
			while((POS & EB) >0){
				POS = Bitfields.shiftNO(POS);
			}
			if((POS & PB)>0) return true;
		}
		
		//follow right
		POS = CURPOS;
		POS = Bitfields.shiftO(POS);
		if((POS & EB)>0){
			POS = Bitfields.shiftO(POS);
			while((POS & EB) >0){
				POS = Bitfields.shiftO(POS);
			}
			if((POS & PB)>0) return true;
		}
		
		//follow down-right
		POS = CURPOS;
		POS = Bitfields.shiftSO(POS);
		if((POS & EB)>0){
			POS = Bitfields.shiftSO(POS);
			while((POS & EB) >0){
				POS = Bitfields.shiftSO(POS);
			}
			if((POS & PB)>0) return true;
		}
		
		//follow down
		POS = CURPOS;
		POS = Bitfields.shiftS(POS);
		if((POS & EB)>0){
			POS = Bitfields.shiftS(POS);
			while((POS & EB) >0){
				POS = Bitfields.shiftS(POS);
			}
			if((POS & PB)>0) return true;
		}
		
		//follow down-left
		POS = CURPOS;
		POS = Bitfields.shiftSW(POS);
		if((POS & EB)>0){
			POS = Bitfields.shiftSW(POS);
			while((POS & EB) >0){
				POS = Bitfields.shiftSW(POS);
			}
			if((POS & PB)>0) return true;
		}
		
		//follow left
		POS = CURPOS;
		POS = Bitfields.shiftW(POS);
		if((POS & EB)>0){
			POS = Bitfields.shiftW(POS);
			while((POS & EB) >0){
				POS = Bitfields.shiftW(POS);
			}
			if((POS & PB)>0) return true;
		}
	
		return false;
	}
	/**
	 * Evaluates all valid moves on the board
	 * @param player Who wants tho move?
	 * @return Vector with all valid Coordinates
	 */
	public Vector<Coordinates> checkMoves(int player){
		Vector<Coordinates> moves = new Vector<Coordinates>(20);
		for(int y=0;y<8;y++){
			for(int x=0;x<8;x++){
				if(checkMove(x,y,player)){
					moves.add(new Coordinates(y+1,x+1));
				}
			}
		}
		return moves;
	}

	/**
	 * Evaluates all valid moves on the board an sorts them,
	 * 'good' ones come first
	 * @param player Who wants tho move?
	 * @return Vector with all valid Coordinates
	 */
	
	public Vector<Coordinates> sortedMoves(int player){
		Vector<Coordinates> moves = new Vector<Coordinates>(20);

		// using loop unrolling for speed and easier sorting

		//Ecken testen, am vielversprechendsten
		if(checkMove(0,0,player)) moves.add(new Coordinates(1,1));
		if(checkMove(0,7,player)) moves.add(new Coordinates(8,1));
		if(checkMove(7,0,player)) moves.add(new Coordinates(1,8));
		if(checkMove(8,8,player)) moves.add(new Coordinates(8,8));
		
		/*
		 *    A  B  C  D  E  F  G  H
		 * 1| 56 57 58 59 60 61 62 63
		 * 2| 48 49 50 51 52 53 54 55
		 * 3| 40 41 42 43 44 45 46 47
		 * 4| 32 33 34 35 36 37 38 39
		 * 5| 24 25 26 27 28 29 30 31
		 * 6| 16 17 18 19 20 21 22 23
		 * 7| 08 09 10 11 12 13 14 15
		 * 8| 00 01 02 03 04 05 06 07
		 * 
		 */
		
		//Kanten testen
		for(int x=2;x<6;x++){
			if(checkMove(x,0,player)) moves.add(new Coordinates(1,x+1));
			if(checkMove(x,7,player)) moves.add(new Coordinates(8,x+1));
		}
		for(int y=2;y<6;y++){
			if(checkMove(0,y,player)) moves.add(new Coordinates(y+1,1));
			if(checkMove(7,y,player)) moves.add(new Coordinates(y+1,8));
		}
		
		for(int x=2;x<6;x++){
			for(int y=2;y<6;y++){
				if(checkMove(x,y,player)) moves.add(new Coordinates(y+1,x+1));
			}
		}
		
		for(int i=0;i<4;i++){
			if(checkMove(1,2+i,player)) moves.add(new Coordinates(3+i,2));
			if(checkMove(2+i,1,player)) moves.add(new Coordinates(2,3+i));
			if(checkMove(6,2+i,player)) moves.add(new Coordinates(3+i,7));
			if(checkMove(2+i,6,player)) moves.add(new Coordinates(7,3+i));
		}

		//C-Felder
		if(checkMove(0,1,player)) moves.add(new Coordinates(2,1));
		if(checkMove(1,0,player)) moves.add(new Coordinates(1,2));
		if(checkMove(7,6,player)) moves.add(new Coordinates(7,8));
		if(checkMove(6,7,player)) moves.add(new Coordinates(8,7));
		if(checkMove(0,6,player)) moves.add(new Coordinates(7,1));
		if(checkMove(1,7,player)) moves.add(new Coordinates(8,2));
		if(checkMove(6,0,player)) moves.add(new Coordinates(1,7));
		if(checkMove(7,1,player)) moves.add(new Coordinates(2,8));
		
		//X-Felder
		if(checkMove(1,1,player)) moves.add(new Coordinates(2,2));
		if(checkMove(1,6,player)) moves.add(new Coordinates(7,2));
		if(checkMove(6,1,player)) moves.add(new Coordinates(2,7));
		if(checkMove(6,6,player)) moves.add(new Coordinates(7,7));
		
		return moves;
	}

	
	
	//---------------Make Move -------------------------
	/**
	 * sets a stone for 'player' at the x/y position and
	 * flips the other stones
	 * @param x x-Coordinate
	 * @param y y-Coordinate
	 * @param player the player which sets the stone
	 */
	public void makeMove(int x, int y, int player){
		long SET = Bitfields.xyToBit(x, y);
		long TMPSET;
		
		long EB, PB;
		if(player==GREEN){
			PB = GB;
			EB = RB;
		}else{
			PB = RB;
			EB = GB;
		}
	    //Followers:
		
		//left up
		long CURPOS = Bitfields.xyToBit(x, y);
		long POS = CURPOS;
		//follow diag left-up
		POS = Bitfields.shiftNW(POS);
		if((POS & EB)>0){
			TMPSET = POS;
			POS = Bitfields.shiftNW(POS);
			while((POS & EB) >0){
				TMPSET |= POS;
				POS = Bitfields.shiftNW(POS);
			}
			if((POS & PB)>0) SET |=TMPSET;
		}
		//follow up
		POS = CURPOS;
		POS = Bitfields.shiftN(POS);
		if((POS & EB)>0){
			TMPSET = POS;
			POS = Bitfields.shiftN(POS);
			while((POS & EB) >0){
				TMPSET |= POS;
				POS = Bitfields.shiftN(POS);
			}
			if((POS & PB)>0) SET |=TMPSET;
		}
		
		//follow up-right
		POS = CURPOS;
		POS = Bitfields.shiftNO(POS);
		if((POS & EB)>0){
			TMPSET = POS;
			POS = Bitfields.shiftNO(POS);
			while((POS & EB) >0){
				TMPSET |= POS;
				POS = Bitfields.shiftNO(POS);
			}
			if((POS & PB)>0) SET |=TMPSET;
		}
		
		//follow right
		POS = CURPOS;
		POS = Bitfields.shiftO(POS);
		if((POS & EB)>0){
			TMPSET = POS;
			POS = Bitfields.shiftO(POS);
			while((POS & EB) >0){
				TMPSET |= POS;
				POS = Bitfields.shiftO(POS);
			}
			if((POS & PB)>0) SET |=TMPSET;
		}
		
		//follow down-right
		POS = CURPOS;
		POS = Bitfields.shiftSO(POS);
		if((POS & EB)>0){
			TMPSET = POS;
			POS = Bitfields.shiftSO(POS);
			while((POS & EB) >0){
				TMPSET |= POS;
				POS = Bitfields.shiftSO(POS);
			}
			if((POS & PB)>0) SET |=TMPSET;
		}
		
		//follow down
		POS = CURPOS;
		POS = Bitfields.shiftS(POS);
		if((POS & EB)>0){
			TMPSET = POS;
			POS = Bitfields.shiftS(POS);
			while((POS & EB) >0){
				TMPSET |= POS;
				POS = Bitfields.shiftS(POS);
			}
			if((POS & PB)>0) SET |=TMPSET;
		}
		
		//follow down-left
		POS = CURPOS;
		POS = Bitfields.shiftSW(POS);
		if((POS & EB)>0){
			TMPSET = POS;
			POS = Bitfields.shiftSW(POS);
			while((POS & EB) >0){
				TMPSET |= POS;
				POS = Bitfields.shiftSW(POS);
			}
			if((POS & PB)>0) SET |=TMPSET;
		}
		
		//follow left
		POS = CURPOS;
		POS = Bitfields.shiftW(POS);
		if((POS & EB)>0){
			TMPSET = POS;
			POS = Bitfields.shiftW(POS);
			while((POS & EB) >0){
				TMPSET |= POS;
				POS = Bitfields.shiftW(POS);
			}
			if((POS & PB)>0) SET |=TMPSET;
		}
		//set the move
		if(player==GREEN){
			GB |=SET;
			RB &= ~SET;
		}else{
			RB |=SET;
			GB &= ~SET;
		} 
	}
	
	/**
	 * sets a stone for 'player' at the x/y position and
	 * flips the other stones
	 * @param coord the Coordinates you want to move
	 * @param player the player which sets the stone
	 */	
	public void makeMove(Coordinates coord, int player){
		int x = coord.getCol()-1;
		int y = coord.getRow()-1;
		long SET = Bitfields.xyToBit(x, y);
		long TMPSET;
		
		long EB, PB;
		if(player==GREEN){
			PB = GB;
			EB = RB;
		}else{
			PB = RB;
			EB = GB;
		}
	    //Followers:
		
		//left up
		long CURPOS = Bitfields.xyToBit(x, y);
		long POS = CURPOS;
		//follow diag left-up
		POS = Bitfields.shiftNW(POS);
		if((POS & EB)>0){
			TMPSET = POS;
			POS = Bitfields.shiftNW(POS);
			while((POS & EB) >0){
				TMPSET |= POS;
				POS = Bitfields.shiftNW(POS);
			}
			if((POS & PB)>0) SET |=TMPSET;
		}
		//follow up
		POS = CURPOS;
		POS = Bitfields.shiftN(POS);
		if((POS & EB)>0){
			TMPSET = POS;
			POS = Bitfields.shiftN(POS);
			while((POS & EB) >0){
				TMPSET |= POS;
				POS = Bitfields.shiftN(POS);
			}
			if((POS & PB)>0) SET |=TMPSET;
		}
		
		//follow up-right
		POS = CURPOS;
		POS = Bitfields.shiftNO(POS);
		if((POS & EB)>0){
			TMPSET = POS;
			POS = Bitfields.shiftNO(POS);
			while((POS & EB) >0){
				TMPSET |= POS;
				POS = Bitfields.shiftNO(POS);
			}
			if((POS & PB)>0) SET |=TMPSET;
		}
		
		//follow right
		POS = CURPOS;
		POS = Bitfields.shiftO(POS);
		if((POS & EB)>0){
			TMPSET = POS;
			POS = Bitfields.shiftO(POS);
			while((POS & EB) >0){
				TMPSET |= POS;
				POS = Bitfields.shiftO(POS);
			}
			if((POS & PB)>0) SET |=TMPSET;
		}
		
		//follow down-right
		POS = CURPOS;
		POS = Bitfields.shiftSO(POS);
		if((POS & EB)>0){
			TMPSET = POS;
			POS = Bitfields.shiftSO(POS);
			while((POS & EB) >0){
				TMPSET |= POS;
				POS = Bitfields.shiftSO(POS);
			}
			if((POS & PB)>0) SET |=TMPSET;
		}
		
		//follow down
		POS = CURPOS;
		POS = Bitfields.shiftS(POS);
		if((POS & EB)>0){
			TMPSET = POS;
			POS = Bitfields.shiftS(POS);
			while((POS & EB) >0){
				TMPSET |= POS;
				POS = Bitfields.shiftS(POS);
			}
			if((POS & PB)>0) SET |=TMPSET;
		}
		
		//follow down-left
		POS = CURPOS;
		POS = Bitfields.shiftSW(POS);
		if((POS & EB)>0){
			TMPSET = POS;
			POS = Bitfields.shiftSW(POS);
			while((POS & EB) >0){
				TMPSET |= POS;
				POS = Bitfields.shiftSW(POS);
			}
			if((POS & PB)>0) SET |=TMPSET;
		}
		
		//follow left
		POS = CURPOS;
		POS = Bitfields.shiftW(POS);
		if((POS & EB)>0){
			TMPSET = POS;
			POS = Bitfields.shiftW(POS);
			while((POS & EB) >0){
				TMPSET |= POS;
				POS = Bitfields.shiftW(POS);
			}
			if((POS & PB)>0) SET |=TMPSET;
		}
		//set the move
		if(player==GREEN){
			GB |=SET;
			RB &= ~SET;
		}else{
			RB |=SET;
			GB &= ~SET;
		} 
	}
	
	//---------------/Make Move -------------------------

//======================getter&setter=================================
	/**
	 * @return a clone of this 'Board'
	 */
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	/**
	 * copies the given Board constellation
	 * into this Board.
	 * @param bd given Board
	 */
	public void copy(BitBoard bd){
		this.RB = bd.RB;
		this.GB = bd.GB;
	}
	/**
	 * counts the stones of 'player'
	 * @param player Who's stones?
	 * @return number of stones belonging to 'player'
	 */
	public int countStones(int player){
		if(player==GREEN){
			return Bitfields.bitCount(GB);
		}else{
			return Bitfields.bitCount(RB);
		}
	}
	/**
	 * Returns the diffrence of stones between
	 * the players.
	 * @param player Who's stones?
	 * @return 'player's' stones - 'enemy' stones
	 */
	public int diffStones(int player){
		if(player == RED)
			return Bitfields.bitCount(RB)-Bitfields.bitCount(GB);
		
		return Bitfields.bitCount(GB) - Bitfields.bitCount(RB);
	}
	/**
	 * Gets you the Occupation of a Field.
	 * If the coordinates are out of range it returns EMPTY.
	 * @param x x-Component/column
	 * @param y y-Component/row
	 * @return GameBoard.GREEN, RED or EMPTY
	 */
	public int getOccupation(int x,int y){
		long BIT = Bitfields.xyToBit(x, y);
		if((BIT&RB)>0) return RED;
		if((BIT&GB)>0) return GREEN;
		
		return EMPTY;
	}


	/**
	 * prints the board as bitfield
	 */
	final public void printBit(){
		System.out.println("-Game Board --------------------");
		int start = 56,end = 64;
		//first row
		while(start>=0){
			for(int i=start;i<end;i++){
				if((RB & Bitfields.BIT[i])>0) System.out.print(" R");
				else 
					if((GB & Bitfields.BIT[i])>0) System.out.print(" G");
				else
					System.out.print(" O");
			}
			System.out.print('\n');
			start -=8; end -=8;
		}
		System.out.println("Red stones: " + Bitfields.bitCount(RB) + "  Green stones: " + Bitfields.bitCount(GB));
		System.out.println("--------------------------------");
	}
	/**
	 * Tests if the field is Empty
	 * @param x x-Coordinate
	 * @param y y-Coordinate
	 * @return true if the field is empty, else false
	 */
	final boolean isEmpty(int x, int y){
		return (Bitfields.xyToBit(x, y) & (RB | GB))==0;
	}
	/**
	 * looks if there are any empty fields left on the board
	 * @return true if there are empty fields left, else false
	 */
	public final boolean gameOver(){
		return Bitfields.bitCount(~(RB | GB)) == 0;
	}
	
	//-----------Board Getter--------------------
	/**
	 * getRB
	 * @return Red's Board
	 */
	public long getRB(){
		return RB;
	}
	/**
	 * getGB
	 * @return Green's Board
	 */
	public long getGB(){
		return GB;
	}

	
}
