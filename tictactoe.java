import java.util.Scanner;

public class tictactoe{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        char[][] board={  {'1','2','3'},
                          {'4','5','6'},
                          {'7','8','9'}   
        };
        

        char player='x';
        for (int turn=0;turn<9;turn++){



        printboard(board);


System.out.println("player "+ player + ", enter position (1-9):");

        int position=sc.nextInt();

        if (position<1||position>9) {
            System.out.println("invalid position. choose (1-9)");
        turn--;
        continue;
        }

        int rows=(position-1)/3;
        int columns=(position-1)%3;

        

       //Avoids overwriting the same position
        if (board[rows][columns]=='x'||board[rows][columns]=='o') {
            System.out.println("position already taken");
            turn--;
            continue;
        }
        board[rows][columns]=player;//places x in the board

        if (checkWinner(board, player)) {
            printboard(board);
            System.out.println("player  "+ player + " wins!");
            break;
        }
        
        if (turn==8) {
            printboard(board);
            System.out.println("Match draw!!");
        }


//switch players
if (player=='x') {
    player='o';
}
else{player='x';}


    }
        printboard(board);

    }



    public static void printboard(char[][]board){
for(int i=0;i<3;i++){
    for(int j=0;j<3;j++){
        System.out.print("  " +board[i][j]+"  ");

        if (j<2) {
            System.out.print("|");
        }
    }
    System.out.println("\n");

    if (i<2) {
        System.out.println("----------------");
    }
}
    }

    public static boolean checkWinner(char[][]board,char player){

        // checks rows 
        for(int i=0;i<3;i++){
            if (board[i][0]==player&&
                board[i][1]==player&&
                board[i][2]==player ) {
                return true;
            }
        }
        // checks columns

        for(int j=0;j<3;j++){
            if (board[0][j]==player&&
                board[1][j]==player&&
                board[2][j]==player ) {
                return true;
            }
        }

        //checks  main diagonal
        if (board[0][0]==player&&
            board[1][1]==player&&
            board[2][2]==player) {
            return true;
        }

        // check other diagonal
        if (board[0][2]==player&&
            board[1][1]==player&&
            board[2][0]==player) {
            return true;
        }
        return false;
    }
}
