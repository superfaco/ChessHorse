import java.util.Scanner;

public class ChessHorseMain {

    static int[][] board;
    static int m, n;
    static int[] moveX = {2, 2, 1, -1, -2, -2, -1, 1};
    static int[] moveY = {1, -1, -2, -2, -1, 1, 2, 2};
    static int totalMoves = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        board = new int[m][n];

        System.out.println("--------------------------------------------------");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                moveHorse(i, j);
                if(totalMoves == m * n){
                    printBoard();
                    System.out.println("--------------------------------------------------");
                    resetBoard();
                }
            }
        }
    }

    private static void resetBoard(){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = 0;
            }
        }
        totalMoves = 0;
    }

    private static void printBoard(){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(board[i][j] + (j < n - 1? "|" : ""));
            }
            System.out.println();
        }
    }

    private static void moveHorse(int x, int y){
        totalMoves++;
        board[x][y] = totalMoves;
        if(totalMoves < m * n){
            for(int i = 0; i < 8; i++){
                if(isValidMove(x + moveX[i], y + moveY[i])){
                    moveHorse(x + moveX[i], y + moveY[i]);
                }
            }
        }
        if(totalMoves < m * n){
            totalMoves--;
            board[x][y] = 0;
        }
    }

    private static boolean isValidMove(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 0;
    }
}
