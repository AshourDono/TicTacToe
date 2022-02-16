/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientHandler;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ahmed
 */
public class GameHandler {
    
    private char[][] board;
    private int nextMove; //0 => player X, 1 => player O
    private int movesCount;
    private final char playerX = 'X';
    private final char playerO = 'O';
    private int winner;
    private static int mode;
    private static BtnPosition moveOfNextPlayer;
     
    //get position of cell
    public static class BtnPosition{ 
        public int row = -1;
        public int col = -1;
        
        public BtnPosition(){}
        
        public BtnPosition(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    
      //init of game
    public GameHandler() {
        this.board = new char[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};
        movesCount = 0;
    }
    
    
    //to draw on grid 
    public void setBoard(char[][] loadedBoard){
        this.board = loadedBoard;
    }
    //board=>grid 9 squares
    public char[][] getBoard(){
        return board;
    }
    
      //get Move Of Next Player
    public static BtnPosition getMoveOfNextPlayer(){
        return GameHandler.moveOfNextPlayer;
    }
     //set Move Of Next Player
    public static void setMoveOfNextPlayer(BtnPosition move){
        moveOfNextPlayer = move;
    }
    
    //set count of move
    public void setMovesCount(int moves){
        movesCount = moves;
    }
    
    //return count of move
    public int getMovesCount(){
        return movesCount;
    }
    
    
    //set next move 
    public void setNextMove(int nextMove){
        this.nextMove = nextMove;
    }
   
        //get next move 
    public int getNextMove(){
        return nextMove;
    }
    
    //play (give val of cell and return count of moves)
    public void setBtn1(char value){
        board[0][0] = value;
    }
    
    public void setBtn2(char value){
        board[0][1] = value;
    }
    
    public void setBtn3(char value){
        board[0][2] = value;
    }
    
    public void setBtn4(char value){
        board[1][0] = value;
    }
    
    public void setBtn5(char value){
        board[1][1] = value;
    }
    
    public void setBtn6(char value){
        board[1][2] = value;
    }
    
    public void setBtn7(char value){
        board[2][0] = value;
    }
    
    public void setBtn8(char value){
        board[2][1] = value;
    }
    
    public void setBtn9(char value){
        board[2][2] = value;
    }
    
    
    //winner pattern
    public boolean checkRows(){
        boolean result = false;
        for(int i = 0; i < 3; i++){
            if(board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2]){
                    result = true;
                    if(board[i][0] == playerX){
                        winner = 0;
                    }
                    else{
                        winner = 1;
                    }
            }
        }
        return result;
    }
    
    public boolean checkCols(){
        boolean result = false;
        for(int i = 0; i < 3; i++){
            if(board[0][i] != ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i]){
                    result = true;
                    if(board[0][i] == playerX){
                        winner = 0;
                    }
                    else{
                        winner = 1;
                    }
            }
        }   
        return result;
    }
    
    public boolean checkDiagonals(){
        boolean result =false;
        if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]){
                result = true;
                if(board[0][0] == playerX){
                    winner = 0;
                }
                else{
                    winner = 1;
                }
        }
        if(board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]){
         
                result = true;
                if(board[0][2] == playerX){
                    winner = 0;
                }
                else{
                    winner = 1;
                }
        }
        return result;
    }
    
        //return num of empty cells
    public int getNumberOfMoves(){
        int count = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == ' '){
                    count++;
                }
            }
        }
        return count;
    }
    
    //check num of moves => return boolean
    public boolean checkNumberOfMoves(){
        boolean result = false;
        movesCount= 9 - getNumberOfMoves();
        if(movesCount == 9){
//if(!checkMovesOnBoard()){
            result = true;
        }
        return result;
    }
    
    //check winner 
    public int checkWin(){
        boolean resultRows;
        boolean resultCols;
        boolean resultDiagonals;
        boolean resultMoves = false;
        int win = 0; //0 game still going, 1 player won, 2 number of moves reached(draw)
        resultRows = checkRows();
        resultCols = checkCols();
        resultDiagonals = checkDiagonals();
        
        if(resultCols || resultRows || resultDiagonals){
            win = 1;//return winner (player1 or 2 or cp)
        }
        else{
            resultMoves = checkNumberOfMoves();//game finish or not
        }
        if(resultMoves == true){
            win = 2;//draw neutral
        }
        return win;
    }
    
     public void clearBoard(){
     
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = ' ';
            }
        }
        
    }
    
     
    //return if there is empty move or not
    public boolean checkMovesOnBoard(){
        boolean move = false;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == ' '){
                    move = true;
                    break;
                }
            }
        }
        return move;
    }
    
    //return position of empty cells
    public ArrayList getAvailableMoves(){
        ArrayList<BtnPosition> availableMoves = new ArrayList();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == ' '){
                    BtnPosition c = new BtnPosition(i, j);
                    availableMoves.add(c);
                }
            }
        }
        return availableMoves;
    }
    
    
      //get rand cell
    public BtnPosition getRandomBtn(){
        ArrayList<BtnPosition> availableMoves = getAvailableMoves();
        int length = availableMoves.size();
        Random random = new Random();
        int rand = random.nextInt(length);
        return availableMoves.get(rand);
    }
    
      public static char [][] convertToTwoDimension(char [] arr){
        char[][] twoDimensionArr = new char[3][3];
        int index=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                twoDimensionArr[i][j] = arr[index];
                index++;
            }
        }
        return twoDimensionArr;
    }
}
