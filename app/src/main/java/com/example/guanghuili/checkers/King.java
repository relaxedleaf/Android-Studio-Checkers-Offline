package com.example.guanghuili.checkers;

//import Piece;

public class King extends Piece {
    int row, column;

    public King(Boolean isBlack, int row, int column){
        super(isBlack,row,column,1);
        this.row = row;
        this.column = column;

    }
    public int[][] getDirections(){
        int[][] x = {{1,1,1},{1,0,1},{1,1,1}};
        return x;
    }

    //*************************************************************************
    //This method will let us check if the king is in danger(Checked)
    //*************************************************************************
    public boolean isChecked(Piece board[][]){
        //Check up
        for(int i=row+1;i<8;i++)
        {
            if(board[i][column]==null)
                continue;
            else if(board[i][column].isBlack()==this.isBlack())
                break;
            else
            {
                if ((board[i][column] instanceof Rook) || (board[i][column] instanceof Queen))
                    return true;
                else
                    break;
            }
        }

        //Check down
        for(int i=row-1;i>=0;i--)
        {
            if(board[i][column]==null)
                continue;
            else if(board[i][column].isBlack()==this.isBlack())
                break;
            else
            {
                if ((board[i][column] instanceof Rook) || (board[i][column] instanceof Queen))
                    return true;
                else
                    break;
            }
        }
        //check right
        for(int i=column+1;i<8;i++)
        {
            if(board[row][i]==null)
                continue;
            else if(board[row][i].isBlack()==this.isBlack())
                break;
            else
            {
                if ((board[row][i] instanceof Rook) || (board[row][i] instanceof Queen))
                    return true;
                else
                    break;
            }
        }
        //check left
        for(int i=column-1;i>=0;i--)
        {
            if(board[row][i]==null)
                continue;
            else if(board[row][i].isBlack()==this.isBlack())
                break;
            else
            {
                if ((board[row][i] instanceof Rook) || (board[row][i] instanceof Queen))
                    return true;
                else
                    break;
            }
        }


        //*************************************************************************
        //still needs to check diagonal, knights, kings, and pawns
        //*************************************************************************

        //Check right-down
        int tempColumn = column+1;
        int tempRow = row-1;
        while(tempColumn<8&&tempRow>=0)
        {
            if(board[tempColumn][tempRow]==null)
            {
                tempColumn++;
                tempRow--;
            }
            else if(board[tempColumn][tempRow].isBlack()==this.isBlack())
                break;
            else
            {
                if (board[tempColumn][tempRow] instanceof Bishop || board[tempColumn][tempRow] instanceof Queen)
                    return true;
                else
                    break;
            }
        }

        //check left-up
        tempColumn=column-1;
        tempRow=row+1;
        while(tempColumn>=0&&tempRow<8)
        {
            if(board[tempColumn][tempRow]==null)
            {
                tempColumn--;
                tempRow++;
            }
            else if(board[tempColumn][tempRow].isBlack()==this.isBlack())
                break;
            else
            {
                if (board[tempColumn][tempRow] instanceof Bishop || board[tempColumn][tempRow] instanceof Queen)
                    return true;
                else
                    break;
            }
        }

        //check left-down
        tempColumn=column-1;
        tempRow=row-1;
        while(tempColumn>=0&&tempRow>=0)
        {
            if(board[tempColumn][tempRow]==null)
            {
                tempColumn--;
                tempRow--;
            }
            else if(board[tempColumn][tempRow].isBlack()==this.isBlack())
                break;
            else
            {
                if (board[tempColumn][tempRow] instanceof Bishop || board[tempColumn][tempRow] instanceof Queen)
                    return true;
                else
                    break;
            }
        }

        //check right-up
        tempColumn=column+1;
        tempRow=row+1;
        while(tempColumn<8&&tempRow<8)
        {
            if(board[tempColumn][tempRow]==null)
            {
                tempColumn++;
                tempRow++;
            }
            else if(board[tempColumn][tempRow].isBlack()==this.isBlack())
                break;
            else
            {
                if (board[tempColumn][tempRow] instanceof Bishop || board[tempColumn][tempRow] instanceof Queen)
                    return true;
                else
                    break;
            }
        }

        //*************************************************************************
        //still needs to check knights, kings, and pawns
        //*************************************************************************

        //Check for King

        for(int i = column - 1; i <= column + 1; i++){
            for(int j = row - 1; j <= row + 1; j++){
                if(i < 0 || i > 8 || j < 0 || j > 8){
                    continue;
                }
                if(board[i][j] instanceof King){
                    if(board[i][j].isBlack() == this.isBlack()){
                        continue;
                    }
                    else{
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
