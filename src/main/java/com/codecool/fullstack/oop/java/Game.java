package com.codecool.fullstack.oop.java;
import com.codecool.fullstack.oop.java.Board.*;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    private Board board;
    private boolean gameIsRunning;

    public Game() throws InterruptedException {
        menu();
    }

    public void menu() throws InterruptedException {
        System.out.println("♟♟♟ ZAGRAJMY W WARCABY ♟♟♟");
        TimeUnit.SECONDS.sleep(2);
    }

    public void pressEnterKey() {
        System.out.println("Wciśnij \"ENTER\" by zagrać❗❗❗ ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        clearScreen();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J"); //puste znaki
        System.out.flush();
    }

    public void start() {
        int player = 1;
        pressEnterKey();
        this.board = new Board();
        clearScreen();
        this.gameIsRunning = true;
        while (gameIsRunning) {
            playRound();
            board.movePawn();
            player = player == 1 ? 2 : 1;
        }
    }

    private void playRound() {
        clearScreen();
        System.out.println("White moves first...");
        Board.printBoard(board.getBoard());

    }
    //app run
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        game.start();
    }

}