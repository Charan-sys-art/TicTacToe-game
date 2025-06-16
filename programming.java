package tap;

import java .util.Scanner;
import java .util.Random;
class NEWGAME  
{
	static char[][] board;
	public NEWGAME()
	{
		board = new char [3][3];
		initBoard();
	}
	void initBoard()
	{
		for(int i=0; i<board.length; i++)
		{
			for(int j=0; j<board[i].length;j++)
			{
				board[i][j] = ' ';
			}
		}
	}
	static void dispBoard()
		{
			System.out.println("-------------");
			for(int i=0; i<board.length; i++)
			{
				System.out.print("| ");
				for(int j=0; j<board[i].length;j++)
				{
					System.out.print(board[i][j] +" | ");
				}
				System.out.println();
				System.out.println("-------------");
			} 
	}
	
	static void placemark(int row, int column, char mark)
	{
		if(row >=0 && row <=2 && column >=0 && column <=2)
		{
			board[row][column]=mark;
		}
		else
		{
			System.out.println("invalid position");
		}
	}
	
		static boolean checkcolwin()
		{
			for(int j=0; j<=2; j++)
			{
				if(board[0][j] != ' ' &&board[0][j]==board [1][j] && board [1][j]==board[2][j] )
				{
					return true;
				}
			}
			return false;
	}
		
		static boolean checkrowwin()
		{
			for(int i=0; i<=2 ; i++)
			{
				if( board[i][0] != ' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2])
				{
					return true;
				}
			}
			return false;
	}
		 
		static boolean checkdiogwin()
		 {
			 if(board[0][0] != ' ' && board[0][0] == board[1][1] && board [1][1]== board [2][2] || board[0][2] != ' ' && board[0][2] == board[1][1] && board [1][1]== board [2][0])
			 {
				 return true;
			 }
			 else
			 {
				 return false;
			 }
	}
		 
}
 abstract class player
{
	String name;
	char mark;
	
	abstract void makemove();
	boolean isvalidmove(int row, int column)
	{
		if(row >= 0 && row <=2 && column >= 0 && column <= 2)
		{
			if(NEWGAME.board[row][column] == ' ')
			{  
				return true;
			}
		}
			return false;
	}
	
}

class humanplayer extends player
{
	
	
	public humanplayer(String name, char mark ) {
		this.name = name;
		this.mark = mark;
	}
	void makemove()
	{
		
		 Scanner scan =new Scanner(System.in);
		 int row;
		 int column;
		 do
		 {
			 System.out.println("Enter the row and column");
			  row = scan.nextInt();
			 column = scan.nextInt();
		 
		 }while(!isvalidmove(row, column));
		 
		 
		 NEWGAME.placemark(row, column, mark);
	}

	
	
	static class AIplayer extends player
	{
		
		public AIplayer(String name, char mark ) {
			this.name = name;
			this.mark = mark;
		}
		void makemove()
		{
			 Scanner scan =new Scanner(System.in);
			 int row;
			 int column;
			 do
			 {
				Random r =new Random();
			row= r.nextInt(3);
			column= r.nextInt(3);
			 }while(!isvalidmove(row, column));
			 
			 
			 NEWGAME.placemark(row, column, mark);
		}
	}
public class programming {
	public static void main(String[] args) {
		NEWGAME t = new NEWGAME();
		humanplayer p1 = new humanplayer("eliz", 'X');
		AIplayer p2 = new AIplayer("groga", 'O');
		player cp;
		cp = p1;
		
		while (true)
		{
			System.out.println(cp.name + " turn");
			cp.makemove();
			NEWGAME.dispBoard();
			
			if(NEWGAME.checkcolwin() || NEWGAME.checkrowwin() || NEWGAME.checkdiogwin())
			{
				System.out.println(cp.name + " has won");
				break;
			}
			else
			{
				if(cp == p1)
				{
				
					cp = p2;
				}
				else
				{
					cp = p1;
				}
			}
		}

	}
		
	}
}
