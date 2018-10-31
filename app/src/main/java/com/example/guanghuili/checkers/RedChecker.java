package com.example.guanghuili.checkers;

import java.util.ArrayList;

public class RedChecker extends Checker {
    public RedChecker(int row, int column){
        super(row,column);
    }

    @Override
    public ArrayList<int[]> getMove(Checker[][] checkerList){

        ArrayList <int[]> possibleMove = new ArrayList<>();

        if(isCrownStatus() == false){//the red checker has not received the crown
            if(getColumn() == 0) {
                if (!(checkerList[getRow() + 1][getColumn() + 1] instanceof RedChecker)) { //if the redChecker is at column 0 and there is not one redChecker at lower right
                    possibleMove.add(new int[]{getRow() + 1, getColumn() + 1});
                }
            }
            else if (getColumn() == 7){
                if(!(checkerList[getRow() + 1][getColumn() - 1] instanceof RedChecker)) {//if the redChecker is at column 7 and there is not one redChecker at lower left
                    possibleMove.add(new int[]{getRow() + 1, getColumn() - 1});
                }
            }
            else{
                if (!(checkerList[getRow() + 1][getColumn() + 1] instanceof RedChecker) && !(checkerList[getRow() + 1][getColumn() - 1] instanceof RedChecker)){
                    possibleMove.add(new int []{getRow() + 1, getColumn() + 1});
                    possibleMove.add(new int []{getRow() + 1, getColumn() - 1});
                }
                if (!(checkerList[getRow() + 1][getColumn() + 1] instanceof RedChecker) && (checkerList[getRow() + 1][getColumn() - 1] instanceof RedChecker)){
                    possibleMove.add(new int []{getRow() + 1, getColumn() + 1});
                }
                if ((checkerList[getRow() + 1][getColumn() + 1] instanceof RedChecker) && !(checkerList[getRow() + 1][getColumn() - 1] instanceof RedChecker)){
                    possibleMove.add(new int []{getRow() + 1, getColumn() - 1});
                }
            }
        }
        else{//the red checker received the crown

        }

        return possibleMove;
    }
}


