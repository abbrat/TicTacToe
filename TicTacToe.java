package Tic_Tac;
import java.util.*;
public class TicTacToe {
     static ArrayList<Integer> playerpos=new ArrayList<Integer>();
     static ArrayList<Integer> cpupos=new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         char [][] gameBoard= {  {' ' , '|' ,' ','|',' '},
        		 {'-' , '+' ,'-','+','-'},
        		 {' ' , '|' ,' ','|',' '},
        		 {'-' , '+' ,'-','+','-'},
        		 {' ' , '|' ,' ','|',' '},};
         
         printGameBoard(gameBoard);
        
         while(true)
         {
         Scanner sc=new Scanner(System.in);
         System.out.println("Enter the Marking position");
         int pos=sc.nextInt();
         while(playerpos.contains(pos)|| cpupos.contains(pos))
         {
        	 System.out.println("position already occpied !!! \n Enter New");
        	 pos=sc.nextInt();
         }
         marker(gameBoard,pos,"player");
         String res=new String(WinnerCheck());
         if(res.length()>0)
	     {
	         System.out.println(res); 
	         break;
         }
         Random cpu=new Random();
         int Cpupos=cpu.nextInt(9)+1;
         
         while(playerpos.contains(Cpupos)|| cpupos.contains(Cpupos))
         {
        	 Cpupos=cpu.nextInt(9)+1;
         }
         marker(gameBoard,Cpupos,"Cpu");
         
         printGameBoard(gameBoard);
         res=new String(WinnerCheck());
	         if(res.length()>0)
		     {
		         System.out.println(res); 
		         break;
	         }
         }
	}
   public static void printGameBoard(char [][] gameBoard)
   {
	   for(char [] row:gameBoard)
       {
      	 for(char c:row)
      	 {
      		 System.out.print(c);
      	 }
      	 System.out.println();
       }
   }
   public static void marker(char [][]gameBoard,int pos,String user)
   {
	   char mark=' ';
	   if(user.equals("player"))
	   {
		   mark='X';
		   playerpos.add(pos);
	   }
	   else
	   {
		   mark='O';
		   cpupos.add(pos);
	   }
	   
	   switch(pos)
	   {
	   case 1:
		   gameBoard[0][0]=mark;
	       break;
	   case 2:
	       gameBoard[0][2]=mark;
	       break;
	   case 3:
	       gameBoard[0][4]=mark;
	       break;
	   case 4:
	       gameBoard[2][0]=mark;
	       break;
	   case 5:
	       gameBoard[2][2]=mark;
	       break;
	   case 6:
	       gameBoard[2][4]=mark;
	       break;
	   case 7:
	       gameBoard[4][0]=mark;
	       break;
	   case 8:
	       gameBoard[4][2]=mark;
	       break;
	   case 9:
	       gameBoard[4][4]=mark;
	       break;
	   }
   }
   public static String WinnerCheck() {
	
	   List toprow=Arrays.asList(1,2,3);
	   List midrow=Arrays.asList(4,5,6);
	   List botrow=Arrays.asList(7,8,9);
	   
	   List fcol=Arrays.asList(1,4,7);
	   List midcol=Arrays.asList(2,5,8);
	   List lcol=Arrays.asList(3,6,9);
	   
	   List dig1=Arrays.asList(1,5,9);
	   List dig2=Arrays.asList(7,5,3);
	   
	   
	   List<List> winning=new ArrayList<List>();
	   winning.add(toprow);
	   winning.add(midrow);
	   winning.add(botrow);
	   winning.add(fcol);
	   winning.add(midcol);
	   winning.add(lcol);
	   winning.add(dig1);
	   winning.add(dig2);
	   
	   for(List l:winning)
	   {
		   if(playerpos.containsAll(l))
		   {
			   return "Winner Winner Chiken Dinner";
		   }else if(cpupos.containsAll(l)) {
			   return "Better luck Next Time ";
		   }else if(playerpos.size()+cpupos.size()==9)
		   {
			   return "No Results";
		   }
	   }
	   return "";
   }
}
