import java.util.Scanner;

public class Main {
    public static final int SIZE = 3;
    public static final char EMPTY = '-';
    public static final char CROSS = 'X';
    public static final char ZERO = '0';

    public static void main(String[] args) {
        char[][] field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = EMPTY;
            }
        }
        Scanner scanner = new Scanner(System.in);
        boolean isCrossTurn = true;

        while (true) {
            System.out.println("Ходят " + (isCrossTurn ? "крестики" : "нолики") + "!");
            printFiled(field);
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            int x = Integer.parseInt(parts[0]) - 1;
            int y = Integer.parseInt(parts[1]) - 1;

            if (field[x][y] != EMPTY) {
                continue;
            }
            field[x][y] = isCrossTurn ? CROSS : ZERO;

            if (isWin(field, isCrossTurn ? CROSS : ZERO)) {
                System.out.println("Выиграли " + (isCrossTurn ? "крестики" : "нолики") + "!");
                printFiled(field);
                break;
            } else {
                if (isCrossTurn) {
                    isCrossTurn = false;
                } else {
                    isCrossTurn = true;
                }
                //isCrossTurn = !isCrossTurn;
            }
        }
    }
    public static boolean isWin(char[][] field, char player) {
        if (field[0][0] == player && field[0][1] == player && field[0][2] == player) {
            return true;
        }
        if (field[1][0] == player && field[1][1] == player && field[1][2] == player) {
            return true;
        }
        if (field[2][0] == player && field[2][1] == player && field[2][2] == player) {
            return true;
        }

        if (field[0][0] == player && field[1][0] == player && field[2][0] == player) {
            return true;
        }
        if (field[0][1] == player && field[1][1] == player && field[2][1] == player) {
            return true;
        }
        if (field[0][2] == player && field[1][2] == player && field[2][2] == player) {
            return true;
        }

        if (field[0][0] == player && field[1][1] == player && field[2][2] == player) {
            return true;
        }
        if (field[0][2] == player && field[1][1] == player && field[2][0] == player) {
            return true;
        }

            return false;

    }

    public static void printFiled(char[][] field) {
        for (char[] row : field) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
