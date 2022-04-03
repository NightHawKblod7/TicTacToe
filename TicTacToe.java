import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import static java.lang.System.*;
public class TicTacToe {
	public static ArrayList<Integer> pPos = new ArrayList<Integer>();
	public static ArrayList<Integer> cPos = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char [][] board = {{' ', '|', ' ', '|', ' '}, 
				{'-', '+', '-', '+', '-'}, 
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'}, 
				{' ', '|', ' ', '|', ' '}};
		
		printBoard(board);
		
		out.println("Welcome to TicTacToe! What is your name?\nEnter Your name Here: ");
		String name = sc.next();
		
		
		while(true) {
			Scanner sc2 = new Scanner(System.in);
			out.println("Please enter where you would like to place your X/O (Places: 1-9): ");
			int p = sc2.nextInt();
			while (pPos.contains(p) || cPos.contains(p)) {
				out.println("Position Taken :D Enter a correct position!");
				p = sc2.nextInt();
			}
			
			place(board, p, "Player");
			String fRes = wCheck(name);
			if(fRes.length() > 0) {
				out.println(fRes);
				break;
			}
			
			Random r = new Random();
			int cP = r.nextInt(9) + 1;
			while (pPos.contains(cP) || cPos.contains(cP)) 
				cP = r.nextInt(9) + 1;
			place(board, cP, "CPU");
			
			printBoard(board);
			fRes = wCheck(name);
			if(fRes.length() > 0) {
				out.println(fRes);
				break;
			}

		}
		

	
	
	}
	public static String wCheck(String name) {
		
		List top = Arrays.asList(1, 2, 3);
		List mid = Arrays.asList(4, 5, 6);
		List bot = Arrays.asList(7, 8, 9);
		List lef = Arrays.asList(1, 4, 7);
		List midC = Arrays.asList(2, 5, 8);
		List rig = Arrays.asList(3, 6, 9);
		List c1 = Arrays.asList(1, 5, 9);
		List c2 = Arrays.asList(7, 5, 3);
		
		List<List> cond = new ArrayList<List>();
		cond.add(top);
		cond.add(mid);
		cond.add(bot);
		cond.add(lef);
		cond.add(midC);
		cond.add(rig);
		cond.add(c1);
		cond.add(c2);
		
		for(List l: cond) {
			if(pPos.containsAll(l)) 
				return name + ", Congratulations, You Win!!!";
			else if(cPos.containsAll(l))
				return name + "Sorry, but you lost :(((  Better Luck Next Time !";
			else if(pPos.size() + cPos.size() == 9)
				return "TIE BABY!!!";
		}
		return "";
	}
	
	public static void place(char [][] board, int p, String u) {
		
		char sym = 'X';
		if(u.equals("CPU")) {
			sym='O';
			cPos.add(p);
		}
		else if(u.equals("Player")) {
			sym = 'X';
			pPos.add(p);
		}
		
		if(p == 1)
			board[0][0] = sym;
		else if(p==2)
			board[0][2] = sym;
		else if(p==3)
			board[0][4] = sym;
		else if(p==4)
			board[2][0] = sym;
		else if(p==5)
			board[2][2] = sym;
		else if(p==6)
			board[2][4] = sym;
		else if(p==7)
			board[4][0] = sym;
		else if(p==8)
			board[4][2] = sym;
		else if(p==9)
			board[4][4] = sym;
	}
	
	public static void printBoard(char [][] board) {
		for(char [] r: board) {
			for(char c : r) {
				out.print(c);
			}
			out.println();
		}
	}

}
