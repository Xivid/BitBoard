package ch.n1b.reversi.board;

/**
 * Utils to handle 8x8 Bitfields
 * <font face="Courier New"><pre>
 *    A  B  C  D  E  F  G  H  
 * 1| 56 57 58 59 60 61 62 63 
 * 2| 48 49 50 51 52 53 54 55  
 * 3| 40 41 42 43 44 45 46 47  
 * 4| 32 33 34 35 36 37 38 39  
 * 5| 24 25 26 27 28 29 30 31  
 * 6| 16 17 18 19 20 21 22 23  
 * 7| 08 09 10 11 12 13 14 15  
 * 8| 00 01 02 03 04 05 06 07  
 * </pre> </font> 
 */

public class Bitfields {
	
	final static long BIT00 = (1L);
	final static long BIT01 = (1L << 1);
	final static long BIT02 = (1L << 2);
	final static long BIT03 = (1L << 3);
	final static long BIT04 = (1L << 4);
	final static long BIT05 = (1L << 5);
	final static long BIT06 = (1L << 6);
	final static long BIT07 = (1L << 7);
	
	final static long BIT08 = (1L << 8);
	final static long BIT09 = (1L << 9);
	final static long BIT10 = (1L << 10);
	final static long BIT11 = (1L << 11);
	final static long BIT12 = (1L << 12);
	final static long BIT13 = (1L << 13);
	final static long BIT14 = (1L << 14);
	final static long BIT15 = (1L << 15);
	
	final static long BIT16 = (1L << 16);
	final static long BIT17 = (1L << 17);
	final static long BIT18 = (1L << 18);
	final static long BIT19 = (1L << 19);
	final static long BIT20 = (1L << 20);
	final static long BIT21 = (1L << 21);
	final static long BIT22 = (1L << 22);
	final static long BIT23 = (1L << 23);
	
	final static long BIT24 = (1L << 24);
	final static long BIT25 = (1L << 25);
	final static long BIT26 = (1L << 26);
	final static long BIT27 = (1L << 27);
	final static long BIT28 = (1L << 28);
	final static long BIT29 = (1L << 29);
	final static long BIT30 = (1L << 30);
	final static long BIT31 = (1L << 31);	
	
	final static long BIT32 = (1L << 32);
	final static long BIT33 = (1L << 33);
	final static long BIT34 = (1L << 34);
	final static long BIT35 = (1L << 35);
	final static long BIT36 = (1L << 36);
	final static long BIT37 = (1L << 37);
	final static long BIT38 = (1L << 38);
	final static long BIT39 = (1L << 39);	
	
	final static long BIT40 = (1L << 40);
	final static long BIT41 = (1L << 41);
	final static long BIT42 = (1L << 42);
	final static long BIT43 = (1L << 43);
	final static long BIT44 = (1L << 44);
	final static long BIT45 = (1L << 45);
	final static long BIT46 = (1L << 46);
	final static long BIT47 = (1L << 47);	
	
	final static long BIT48 = (1L << 48);
	final static long BIT49 = (1L << 49);
	final static long BIT50 = (1L << 50);
	final static long BIT51 = (1L << 51);
	final static long BIT52 = (1L << 52);
	final static long BIT53 = (1L << 53);
	final static long BIT54 = (1L << 54);
	final static long BIT55 = (1L << 55);
	
	final static long BIT56 = (1L << 56);
	final static long BIT57 = (1L << 57);
	final static long BIT58 = (1L << 58);
	final static long BIT59 = (1L << 59);
	final static long BIT60 = (1L << 60);
	final static long BIT61 = (1L << 61);
	final static long BIT62 = (1L << 62);
	final static long BIT63 = (1L << 63);	
	
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
	final public static long A1 = BIT56;
	final public static long A2 = BIT48;
	final public static long A3 = BIT40;
	final public static long A4 = BIT32;
	final public static long A5 = BIT24;
	final public static long A6 = BIT16;
	final public static long A7 = BIT08;
	final public static long A8 = BIT00;
	
	final public static long B1 = BIT57;
	final public static long B2 = BIT49;
	final public static long B3 = BIT41;
	final public static long B4 = BIT33;
	final public static long B5 = BIT25;
	final public static long B6 = BIT17;
	final public static long B7 = BIT09;
	final public static long B8 = BIT01;
	
	final public static long C1 = BIT58;
	final public static long C2 = BIT50;
	final public static long C3 = BIT42;
	final public static long C4 = BIT34;
	final public static long C5 = BIT26;
	final public static long C6 = BIT18;
	final public static long C7 = BIT10;
	final public static long C8 = BIT02;
	
	final public static long D1 = BIT59;
	final public static long D2 = BIT51;
	final public static long D3 = BIT43;
	final public static long D4 = BIT35;
	final public static long D5 = BIT27;
	final public static long D6 = BIT19;
	final public static long D7 = BIT11;
	final public static long D8 = BIT03;
	
	final public static long E1 = BIT60;
	final public static long E2 = BIT52;
	final public static long E3 = BIT44;
	final public static long E4 = BIT36;
	final public static long E5 = BIT28;
	final public static long E6 = BIT20;
	final public static long E7 = BIT12;
	final public static long E8 = BIT04;
	
	final public static long F1 = BIT61;
	final public static long F2 = BIT53;
	final public static long F3 = BIT45;
	final public static long F4 = BIT37;
	final public static long F5 = BIT29;
	final public static long F6 = BIT21;
	final public static long F7 = BIT13;
	final public static long F8 = BIT05;
	
	final public static long G1 = BIT62;
	final public static long G2 = BIT54;
	final public static long G3 = BIT46;
	final public static long G4 = BIT38;
	final public static long G5 = BIT30;
	final public static long G6 = BIT22;
	final public static long G7 = BIT14;
	final public static long G8 = BIT06;
	
	final public static long H1 = BIT63;
	final public static long H2 = BIT55;
	final public static long H3 = BIT47;
	final public static long H4 = BIT39;
	final public static long H5 = BIT31;
	final public static long H6 = BIT23;
	final public static long H7 = BIT15;
	final public static long H8 = BIT07;
	
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
	/**
	 * BIT[nbr] represents a 8x8 Bitfield where the nbr bit is set.
	 */
	final public static long[] BIT = 	  { BIT00,BIT01,BIT02,BIT03,BIT04,BIT05,BIT06,BIT07,
											BIT08,BIT09,BIT10,BIT11,BIT12,BIT13,BIT14,BIT15,
											BIT16,BIT17,BIT18,BIT19,BIT20,BIT21,BIT22,BIT23,
											BIT24,BIT25,BIT26,BIT27,BIT28,BIT29,BIT30,BIT31,
											BIT32,BIT33,BIT34,BIT35,BIT36,BIT37,BIT38,BIT39,
											BIT40,BIT41,BIT42,BIT43,BIT44,BIT45,BIT46,BIT47,
											BIT48,BIT49,BIT50,BIT51,BIT52,BIT53,BIT54,BIT55,
											BIT56,BIT57,BIT58,BIT59,BIT60,BIT61,BIT62,BIT63 };
	/**
	 * FIELD[x][y] represents a 8x8 Bitfield where the x  / y bit is set.
	 */
	final public static long[][] FIELD =  {{A1, A2, A3, A4, A5, A6, A7, A8},
										   {B1, B2, B3, B4, B5, B6, B7, B8},
										   {C1, C2, C3, C4, C5, C6, C7, C8},
										   {D1, D2, D3, D4, D5, D6, D7, D8},
										   {E1, E2, E3, E4, E5, E6, E7, E8},
										   {F1, F2, F3, F4, F5, F6, F7, F8},
										   {G1, G2, G3, G4, G5, G6, G7, G8},
										   {H1, H2, H3, H4, H5, H6, H7, H8}};
	
	final static long DIAG_A1    = A1 | B2 | C3 | D4 | E5 | F6 | G7 | H8 ;	
	final static long DIAG_A8    = A8 | B7 | C6 | D5 | E4 | F3 | G2 | H1 ;
	
	final static long HORIZONTAL = A1 | B1 | C1 | D1 | E1 | F1 | G1 | H1 ;
	final static long VERTICAL   = A1 | A2 | A3 | A4 | A5 | A6 | A7 | A8 ;
	
	/*
	 * Masks for all borders
	 *   L      R      U      D
	 * X O O  O O X  X X X  O O O
	 * X O O  O O X  O O O  O O O
	 * X O O  O O X  O O O  X X X
	 */
	final static long BORDER_L  = A1 | A2 | A3 | A4 | A5 | A6 | A7 | A8 ;
	final static long BORDER_R  = H1 | H2 | H3 | H4 | H5 | H6 | H7 | H8 ;
	final static long BORDER_U  = A1 | B1 | C1 | D1 | E1 | F1 | G1 | H1 ;
	final static long BORDER_D  = A8 | B8 | C8 | D8 | E8 | F8 | G8 | H8 ;
	
	/*
	 * important masks in reversi
	 * 
	 * X O O O X  O O O O O  O X O X O
	 * O O O O O  O X O X O  X O O O X
	 * O O O O O  O O O O O  O O O O O
	 * O O O O O  O X O X O  X O O O X
	 * X O O O X  O O O O O  O X O X O
	 * 
	 */
	final public static long CORNERS  = A1 | H1 | H8 | A8 ;
	final public static long X_FIELDS = B2 | G2 | G7 | B7 ;
	final public static long C_FIELDS = B1 | A2 | G1 | H2 | A7 | B8 | H7 | G8 ;
	
	//---------------Shifters-----------------------
	/*   NW     N      NO     SW     S      SO
	 *   << 7  << 8   << 9   >>> 9  >>> 8  >>> 7
	 * X O O  O X O  O O X  O O O  O O O  O O O
	 * O X O  O X O  O X O  O X O  O X O  O X O
	 * O O O  O O O  O O O  X O O  O X O  O O X
	*/
	/**
	 * Shifts a (long) as 8x8 Bitfield one to the left
	 * @param BITFIELD a (long) to shift
	 */
	final public static long shiftW(long BITFIELD){
		BITFIELD >>>= 1;
		BITFIELD &= ~BORDER_R;
		return BITFIELD;
	}
	/**
	 * Shifts a (long) as 8x8 Bitfield one to the right
	 * @param BITFIELD a (long) to shift
	 */
	final public static long shiftO(long BITFIELD){
		BITFIELD <<= 1;
		BITFIELD &= ~BORDER_L;
		return BITFIELD;
	}
	/**
	 * Shifts a (long) as 8x8 Bitfield one up
	 * @param BITFIELD a (long) to shift
	 */
	final public static long shiftN(long BITFIELD){
		BITFIELD <<= 8;
		return BITFIELD;
	}
	/**
	 * Shifts a (long) as 8x8 Bitfield one down
	 * @param BITFIELD a (long) to shift
	 */
	final public static long shiftS(long BITFIELD){
		BITFIELD >>>= 8;
		return BITFIELD;
	}
	/**
	 * Shifts a (long) as 8x8 Bitfield one diagnol left-up
	 * @param BITFIELD a (long) to shift
	 */
	final public static long shiftNW(long BITFIELD){
		BITFIELD <<= 7;
		BITFIELD &= ~BORDER_R;
		return BITFIELD;
	}
	/**
	 * Shifts a (long) as 8x8 Bitfield one diagnol right-up
	 * @param BITFIELD a (long) to shift
	 */
	final public static long shiftNO(long BITFIELD){
		BITFIELD <<= 9;
		BITFIELD &= ~BORDER_L;
		return BITFIELD;
	}
	/**
	 * Shifts a (long) as 8x8 Bitfield one diagnol right-down
	 * @param BITFIELD a (long) to shift
	 */
	final public static long shiftSO(long BITFIELD){
		BITFIELD >>>= 7;
		BITFIELD &= ~BORDER_L;
		return BITFIELD;
	}
	/**
	 * Shifts a (long) as 8x8 Bitfield one diagnol left-down
	 * @param BITFIELD a (long) to shift
	 */
	final public static long shiftSW(long BITFIELD){
		BITFIELD >>>= 9;
		BITFIELD &= ~BORDER_R;
		return BITFIELD;
	}
	
	//---------------/Shifters-----------------------
	
	
	//---------------helpers-------------------------
	/**
	 * Returns a Bitfield on which only the
	 * given Bit ist set
	 * @param x x-Coordinate 
	 * @param y y-Coordinate 
	 */
	final public static long xyToBit(int x, int y){
		if(x>7||y>7||x<0||y<0) return 0;
		return FIELD[x][y];
	}
	/**
	 * Looks if the bit at the given Coordinates is set
	 * @param x x-Coordinate
	 * @param y y-Coordinate
	 * @param BITFIELD bitfield
	 * @return true if set, else false
	 */
	final public static boolean isSet(int x, int y, long BITFIELD){
		//             xyToBit
		if(x>7||y>7||x<0||y<0) return false;
		return (FIELD[x][y] & BITFIELD) > 0;
	}
	/**
	 * Looks if the given bit is set.
	 * If BIT has several bits set, it looks if
	 * at least one is set on BITFIELD
	 * @param BIT the bit
	 * @param BITFIELD the bitfield to test
	 * @return true if set, else false
	 */
	final public static boolean isSet(long BIT, long BITFIELD){
		return (BIT & BITFIELD)>0;
	}
	
	final public static int numberOfSet(long BITFIELD){
		int nbr = 0;
		for(int i=0;i<64;i++){
			if((BITFIELD & 1L) == 1L) nbr++;
			
			BITFIELD >>>= 1;
		}
		return nbr;
	}
	

	//---Print functions--------------------------------------
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
	/**
	 * Prints a (long) as 8x8 Bitfield
	 * @param BITFIELD a (long) to print as 8x8 BITFIELD
	 */
	final public static void printBitfield(long BITFIELD){
		System.out.println("-BITFIELD --------------------");
		int start = 56,end = 64;
		//first row
		while(start>=0){
			for(int i=start;i<end;i++){
				if((BITFIELD & BIT[i])>0) System.out.print(" X");
				else System.out.print(" O");
			}
			System.out.print('\n');
			start -=8; end -=8;
		}
		System.out.println("------------------------------");
	}
	/**
	 * Gives back a String representation of a 8x8 Bitfield
	 * @param BITFIELD Bitfield to represent
	 * @return a String containing the representation
	 */
	final public static String toString(long BITFIELD){
		StringBuffer str = new StringBuffer();
		str.append("-BITFIELD --------------------\n");
		int start = 56,end = 64;
		//first row
		while(start>=0){
			for(int i=start;i<end;i++){
				if((BITFIELD & BIT[i])>0) str.append(" X");
				else str.append(" O");
			}
			str.append('\n');
			start -=8; end -=8;
		}
		str.append("------------------------------\n");
		return str.toString();
	}
}