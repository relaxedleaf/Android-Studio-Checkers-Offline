package com.example.guanghuili.checkers;

import java.util.ArrayList;

public class BlackChecker extends Checker {
    public BlackChecker(int row, int column){
            super(row,column);
    }

    @Override
    public ArrayList<int[]> getMove(Checker[][] checkerList){

        ArrayList <int[]> possibleMove = new ArrayList<>();

        if(isCrownStatus() == false){//the black checker has not received the crown
            if(getColumn() == 0) {
                if (!(checkerList[getRow() - 1][getColumn() + 1] instanceof BlackChecker)) { //if the blackChecker is at column 0 and there is not one blackChecker at upper right
                    possibleMove.add(new int[]{getRow() - 1, getColumn() + 1});
                }
            }
            else if (getColumn() == 7){
                if(!(checkerList[getRow() - 1][getColumn() - 1] instanceof BlackChecker)) {//if the blackChecker is at column 7 and there is not one blackChecker at upper left
                    possibleMove.add(new int[]{getRow() - 1, getColumn() - 1});
                }
            }
            else{//blackChecker in column 1-6
                //**********Encounter black checkers************
                if (!(checkerList[getRow() - 1][getColumn() - 1] instanceof BlackChecker) && !(checkerList[getRow() - 1][getColumn() + 1] instanceof BlackChecker)){//--means upper left, -+means upper right
                    possibleMove.add(new int []{getRow() - 1, getColumn() - 1});
                    possibleMove.add(new int []{getRow() - 1, getColumn() + 1});
                }
                if(!(checkerList[getRow() - 1][getColumn() - 1] instanceof BlackChecker) && (checkerList[getRow() - 1][getColumn() + 1] instanceof BlackChecker)){
                    possibleMove.add(new int []{getRow() - 1, getColumn() - 1});
                }

                if ((checkerList[getRow() - 1][getColumn() - 1] instanceof BlackChecker) && !(checkerList[getRow() - 1][getColumn() + 1] instanceof BlackChecker)){
                    possibleMove.add(new int []{getRow() - 1, getColumn() + 1});
                }
                //**********Encounter Red checkers**************
                //TODO implement a condition where when the blackChecker sees redCheckers

            }
        }
        else{//the black checker received the crown

        }

        return possibleMove;
    }
}