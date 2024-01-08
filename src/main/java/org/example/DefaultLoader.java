package org.example;

import org.example.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DefaultLoader {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rows, cols;
        System.out.println("Please enter the number of rows in Board");
        rows = scanner.nextInt();
        System.out.println("Please enter the number of cols in Board");
        cols = scanner.nextInt();

        Dice dice = new NormalDice();

        Board board = new Board(10, 10, dice);

        System.out.println("Enter Number of players: ");
        int numberOfPlayers = scanner.nextInt();
        List<Player> players = new ArrayList<>();
        int temp = numberOfPlayers;
        while(temp > 0) {
            System.out.println("Enter player name:");
            temp--;
            String playerName = scanner.next();
            players.add(new Player(playerName));
        }
        boolean seleectSpecialElements = true;
        while(seleectSpecialElements) {
            System.out.println("Do you wanna enter special elements?");
            System.out.println("1. Snake");
            System.out.println("2. Ladder");
            System.out.println("3. Exit");
            int option = scanner.nextInt();

            switch (option) {
                case 1 :
                    System.out.println("Enter the origin Snake");
                    int fromPointSnake = scanner.nextInt();
                    System.out.println("Enter the dest Snake");
                    int toPointSnake = scanner.nextInt();
                    board.addSpecialEntity(new Snake(toPointSnake, fromPointSnake));
                    break;

                case 2:
                    System.out.println("Enter the origin Ladder");
                    int fromPointLadder = scanner.nextInt();
                    System.out.println("Enter the dest Ladder");
                    int toPointLadder = scanner.nextInt();
                    board.addSpecialEntity(new Ladder(toPointLadder, fromPointLadder));
                    break;

                case 3:
                    seleectSpecialElements = false;
                    break;

            }
        }

        System.out.println("Let the games begin");

        while(numberOfPlayers>1) {
            for(Player player: players) {
                if (player.getIsPlaying()) {

                    board.moveToNextPosition(player);
                    if(player.getIsPlaying() == false) {
                        numberOfPlayers--;
                    }
                }
            }
        }

    }
}