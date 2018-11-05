package com.example.guanghuili.checkers;

import android.util.Log;

import java.util.ArrayList;

public class RedChecker extends Checker {
    public RedChecker(int row, int column){
        super(row,column);
    }
    private static ArrayList <int[]> possibleMove;


    public RedChecker (Checker redChecker){
        super(redChecker);
    }

    @Override
    public ArrayList<int[]> getMove(Checker[][] checkerList){

        possibleMove = new ArrayList<>();

        recursiveSearch(getRow(), getColumn(), checkerList);
        Log.d("PossibleMoves",String.valueOf(possibleMove.size()));
        return possibleMove;
    }

    public static void recursiveSearch(int r, int c, Checker[][]checkerList){
        if(c == 0 && r < 7) {
            if (!(checkerList[r + 1][c + 1] instanceof RedChecker)) { //if the redChecker is at column 0 and there is not one redChecker at lower right
                if(checkerList[r + 1][c + 1] instanceof BlackChecker){
                    if(r + 2 <= 7) {
                        if (checkerList[r + 2][c + 2] == null) {
                            possibleMove.add(new int[]{r + 2, c + 2});
                            recursiveSearch(r + 2, c + 2, checkerList);
                        }
                    }
                }
                else{
                    possibleMove.add(new int[]{r + 1, c + 1});
                }
            }

        }
        else if(c > 0 && c < 7 && r < 7){
            if(!(checkerList[r + 1][c - 1] instanceof RedChecker)){//if the lower left is not a redChecker
                if(checkerList[r + 1][c - 1] instanceof BlackChecker){//if the lower left is a black checker
                    if ((r + 2 <= 7) && (c - 2 >= 0)) {
                        if (checkerList[r + 2][c - 2] == null) {//if the lower left of the lower left is not null
                            possibleMove.add(new int[]{r + 2, c - 2});//add the position to the possibleMove
                            recursiveSearch(r + 2, c - 2, checkerList);//start a new search
                        }
                    }

                }
                else{
                    possibleMove.add(new int[]{r + 1, c - 1});
                }

            }
            if(!(checkerList[r + 1][c + 1] instanceof RedChecker)){//if the lower right is not a redChecker
                if(checkerList[r + 1][c + 1] instanceof BlackChecker){//if the lower right is a black checker
                    if ((r + 2 <= 7) && (c + 2 <= 7)) {
                        if (checkerList[r + 2][c + 2] == null) {//if the lower right of the lower right is not null
                            possibleMove.add(new int[]{r + 2, c + 2});//add the position to the possibleMove
                            recursiveSearch(r + 2, c + 2, checkerList);//start a new search
                        }
                    }

                }
                else{
                    possibleMove.add(new int[]{r + 1, c + 1});
                }

            }
        }
        else{
            if(c == 7 && r < 7) {
                if (!(checkerList[r + 1][c - 1] instanceof RedChecker)) { //if the redChecker is at column 0 and there is not one redChecker at lower right
                    if (checkerList[r + 1][c - 1] instanceof BlackChecker) {
                        if (r + 2 <= 7) {
                            if (checkerList[r + 2][c - 2] == null) {
                                possibleMove.add(new int[]{r + 2, c - 2});
                                recursiveSearch(r + 2, c - 2, checkerList);
                            }
                        }
                    } else {
                        possibleMove.add(new int[]{r + 1, c - 1});
                    }
                }
            }
        }
    }
}


