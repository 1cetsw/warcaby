package com.codecool.fullstack.oop.java;

import java.util.*;

public class Board {
    private Pawn[][] board;
    private Scanner scanner;
    private int X;
    private Game game;


    Board() {
        //board size
        scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe pomiedzy 10-20 :");
        String input = scanner.nextLine();
        X = Integer.parseInt(input);

        //sprawdz czy wartosc prowadzona jest ok
        while (X < 10 || X > 20) {
            System.out.println(("Zła warotsc , Podaj wartosc z zakresu 10-20: "));
            input = scanner.nextLine();
            X = Integer.parseInt(input);
        }
        //ustaw pionki
        board = setPawns(new Pawn[X][X], X);
    }

    private Pawn[][] setPawns(Pawn[][] board, int X) {

        return setWhitePawns(setBlackPawns(board, X), X);
    }

    private Pawn[][] setWhitePawns(Pawn[][] board, int X) {
        int whitePieces = X * 2;
        for (int row = board.length - 1; row >= 0; row--) {
            if ((row - 1) % 2 == 0) {
                for (int i = 0; i < board[row].length; i += 2) {
                    if (whitePieces > 0) {
                        board[row][i] = new Pawn("white", row, i);
                        whitePieces--;
                    }
                }
            } else {
                for (int i = 1; i < board[row].length; i += 2) {
                    if (whitePieces > 0) {
                        board[row][i] = new Pawn("white", row, i);
                        whitePieces--;
                    }
                }
            }
        }
        return board;
    }

    private Pawn[][] setBlackPawns(Pawn[][] board, int n) {
        int blackPieces = n * 2;
        for (int row = 0; row < board.length; row++) {
            if ((row + 1) % 2 == 0) {
                for (int i = 0; i < board[row].length; i += 2) {
                    if (blackPieces > 0) {
                        board[row][i] = new Pawn("black", row, i);
                        blackPieces--;
                    }
                }
            } else {
                for (int i = 1; i < board[row].length; i += 2) {
                    if (blackPieces > 0) {
                        board[row][i] = new Pawn("black", row, i);
                        blackPieces--;
                    }
                }
            }
        }
        return board;
    }

    private void setWhite(Pawn[][] board, int X) {
        int pieces = X * 2;
    }

    public void setBoard(Pawn[][] board) {
        this.board = board;
    }

    public Pawn[][] getBoard() {
        return board;
    }

    public static void printBoard(Pawn[][] board) {
        int whitePawnCode = (int) 0x26AA;  // 0x26AA⚪0x26AB⚫

        String puck = Character.toString((char) whitePawnCode);
        char[] abc = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        StringBuilder displayBoard = new StringBuilder("    ");
        for (int row = 0; row < board.length; row++) {
            if (row < 9) {
                displayBoard.append(row + 1).append("  ");
            } else {
                displayBoard.append(row + 1).append(" ");
            }
        }
        displayBoard.append("\n");
        for (int row = 0; row < board.length; row++) {
            displayBoard.append(abc[row]).append("  ");
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == null) {
                    if ((row + col) % 2 == 0) {
                        displayBoard.append("\u001b[47;1m" + "   " + "\u001b[0m"); //białe pole
                    } else {
                        displayBoard.append("   ");
                    }
                } else {
                    switch (board[row][col].toString()) {
                        case "black":
                            displayBoard.append("\u001b[33m" + " ").append(puck).append(" ").append("\u001b[0m"); //czarne pole
                            break;
                        case "white":
                            displayBoard.append(" ").append(puck).append(" ");
                            break;
                    }
                }
            }
            displayBoard.append("\n");

        }
        System.out.println(displayBoard);
    }


    public void movePawn() {
    }
}
