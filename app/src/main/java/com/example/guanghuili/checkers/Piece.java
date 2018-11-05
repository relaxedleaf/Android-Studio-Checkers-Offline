package com.example.guanghuili.checkers;

public abstract class Piece implements Cloneable {
    int moveDistance,row, column;
    int[][] moveDirection = new int[3][3];
    boolean isBlack;


    public Piece(Boolean isBlack, int row, int column, int moveDistance){
        this.moveDistance = moveDistance;
        this.row = row;
        this.column = column;
        this.isBlack = isBlack;
    }
//    public setDirections(int[][] x){
//        for(int i = 0; i < 3; i++){
//            for(int j = 0; j < 3; j++){
//                moveDirection[i][j] = x[i][j];
//            }
//        }
//    }
    public boolean isBlack(){
        return isBlack;
    }

    public Piece getcopy() throws CloneNotSupportedException
    {
        return (Piece) this.clone();
    }
}
