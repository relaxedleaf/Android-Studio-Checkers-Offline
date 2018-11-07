package com.example.guanghuili.checkers;

import android.util.Log;

import java.util.ArrayList;

public class BlackChecker extends Checker {
    private ArrayList <int[]> possibleMove;
    private ArrayList <int[]> killList;

    public BlackChecker(int row, int column){
        super(row,column);
    }

    public BlackChecker (Checker blackChecker){
        super(blackChecker);
    }


    @Override
    public ArrayList<int[]> getMove(Checker[][] checkerList){
        possibleMove = new ArrayList<>();
        killList = new ArrayList<>();

        recursiveSearch(getRow(), getColumn(), checkerList);
        return possibleMove;
    }

    public void recursiveSearch(int r, int c, Checker[][]checkerList){
        if(c == 0 && r > 0) {
            if (!(checkerList[r - 1][c + 1] instanceof BlackChecker)) {
                if(checkerList[r - 1][c + 1] instanceof RedChecker){
                    if(r - 2 >= 0) {
                        if (checkerList[r - 2][c + 2] == null) {
                            possibleMove.add(new int[]{r - 2, c + 2});
                            killList.add(new int[]{r - 1, c + 1});
                            //recursiveSearch(r - 2, c + 2, checkerList);
                        }
                    }
                }
                else{
                    possibleMove.add(new int[]{r - 1, c + 1});
                    killList.add(null);
                }
            }

        }
        else if(c > 0 && c < 7 && r > 0){
            if(!(checkerList[r - 1][c - 1] instanceof BlackChecker)){
                if(checkerList[r - 1][c - 1] instanceof RedChecker){
                    if ((r - 2 >= 0) && (c - 2 >= 0)) {
                        if (checkerList[r - 2][c - 2] == null) {
                            possibleMove.add(new int[]{r - 2, c - 2});
                            killList.add(new int[]{r - 1, c - 1});
                            //recursiveSearch(r - 2, c - 2, checkerList);
                        }
                    }

                }
                else{
                    possibleMove.add(new int[]{r - 1, c - 1});
                    killList.add(null);
                }

            }
            if(!(checkerList[r - 1][c + 1] instanceof BlackChecker)){
                if(checkerList[r - 1][c + 1] instanceof RedChecker){
                    if ((r - 2 >= 0) && (c + 2 <= 7)) {
                        if (checkerList[r - 2][c + 2] == null) {
                            possibleMove.add(new int[]{r - 2, c + 2});
                            killList.add(new int[]{r - 1, c + 1});
                            //recursiveSearch(r - 2, c + 2, checkerList);//start a new search
                        }
                    }

                }
                else{
                    possibleMove.add(new int[]{r - 1, c + 1});
                    killList.add(null);
                }

            }
        }
        else{
            if(c == 7 && r > 0) {
                if (!(checkerList[r - 1][c - 1] instanceof BlackChecker)) {
                    if (checkerList[r - 1][c - 1] instanceof RedChecker) {
                        if (r + 2 >= 0) {
                            if (checkerList[r - 2][c - 2] == null) {
                                possibleMove.add(new int[]{r - 2, c - 2});
                                killList.add(new int[]{r - 1, c - 1});
                                //recursiveSearch(r - 2, c - 2, checkerList);
                            }
                        }
                    } else {
                        possibleMove.add(new int[]{r - 1, c - 1});
                        killList.add(null);
                    }
                }
            }
        }
    }


    @Override
    public ArrayList<int[]> getMove2(Checker[][] checkerList){

        possibleMove = new ArrayList<>();

        recursiveSearch2(getRow(), getColumn(), checkerList);
        Log.d("PossibleMoves",String.valueOf(possibleMove.size()));
        return possibleMove;
    }


    public void recursiveSearch2(int r, int c, Checker[][]checkerList){
        if(c == 0 && r > 0) {
            if (!(checkerList[r - 1][c + 1] instanceof BlackChecker)) {
                if(checkerList[r - 1][c + 1] instanceof RedChecker){
                    if(r - 2 >= 0) {
                        if (checkerList[r - 2][c + 2] == null) {
                            possibleMove.add(new int[]{r - 2, c + 2});
                            //recursiveSearch(r - 2, c + 2, checkerList);
                        }
                    }
                }
            }

        }
        else if(c > 0 && c < 7 && r > 0){
            if(!(checkerList[r - 1][c - 1] instanceof BlackChecker)){
                if(checkerList[r - 1][c - 1] instanceof RedChecker){
                    if ((r - 2 >= 0) && (c - 2 >= 0)) {
                        if (checkerList[r - 2][c - 2] == null) {
                            possibleMove.add(new int[]{r - 2, c - 2});
                            //recursiveSearch(r - 2, c - 2, checkerList);
                        }
                    }

                }

            }
            if(!(checkerList[r - 1][c + 1] instanceof BlackChecker)){
                if(checkerList[r - 1][c + 1] instanceof RedChecker){
                    if ((r - 2 >= 0) && (c + 2 <= 7)) {
                        if (checkerList[r - 2][c + 2] == null) {
                            possibleMove.add(new int[]{r - 2, c + 2});
                            //recursiveSearch(r - 2, c + 2, checkerList);//start a new search
                        }
                    }

                }

            }
        }
        else{
            if(c == 7 && r > 0) {
                if (!(checkerList[r - 1][c - 1] instanceof BlackChecker)) {
                    if (checkerList[r - 1][c - 1] instanceof RedChecker) {
                        if (r + 2 >= 0) {
                            if (checkerList[r - 2][c - 2] == null) {
                                possibleMove.add(new int[]{r - 2, c - 2});
                                //recursiveSearch(r - 2, c - 2, checkerList);
                            }
                        }
                    }
                }
            }
        }
    }

    public ArrayList <int[]> getKillList(){
        return killList;
    }
}