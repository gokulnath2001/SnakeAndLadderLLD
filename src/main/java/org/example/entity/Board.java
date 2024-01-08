package org.example.entity;

import java.util.ArrayList;
import java.util.Collections;

public class Board {

    private int numberOfRows;

    private int numberOfColumns;

    private int sizeOfBoard;

    private Dice dice;
    private ArrayList<SpecialEnity> squareOfBoard;


    public Board(int numberOfRows, int numberOfColumns, Dice dice) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.sizeOfBoard = numberOfColumns*numberOfColumns;
        this.squareOfBoard =
                new ArrayList<>(Collections.nCopies(this.sizeOfBoard+1, null));
        System.out.println(this.squareOfBoard.size());
        this.dice = dice;
    }

    public void addSpecialEntity(SpecialEnity specialEnity){
        squareOfBoard.set(specialEnity.fromPosition(), specialEnity);
    }

    public void moveToNextPosition(Player player){

        int curPositon = player.getPlayerPosition();
        int newPosition = dice.nextPosition() + curPositon;
        if(!isValidMove(newPosition)){
            System.out.println("Invalid Move -_- player " + player.getName() );
            return;
        }
        if(newPosition == 100) {
            player.setIsPlaying(Boolean.FALSE);
            System.out.println("Player " + player.getName() + " Won");
            player.setPlayerPosition(100);
            return;
        }
        if(squareOfBoard.get(newPosition) == null) {
            player.setPlayerPosition(newPosition);
        }
        else{
            newPosition = squareOfBoard.get(newPosition).toPosition();
            player.setPlayerPosition(newPosition);
        }

        System.out.println("Player " + player.getName() + " Moved from " + curPositon + " to " + newPosition);




    }

    public Boolean isValidMove(int position) {
        return position <= this.sizeOfBoard;
    }
}
