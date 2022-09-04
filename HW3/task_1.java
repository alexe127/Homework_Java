// 7. На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
// Для упрощения для начала можно решить задачу на 4 ферзя, ответом является первая получившаяся комбинация 
// (список всех возможных комбинаций возвращать не надо).

public class task_1 {
    public static void main(String[] args) {
        int line = 8;
        int col = 8;
        String[][] chessBoard = createBoard(line,col);
        for(int i = 0; i < line; i++){
            for(int j = 0; j < col; j++){
                checkSolution(chessBoard,j);
                System.out.print(chessBoard[i][j] + "  ");
            }
            System.out.println();
        }
    }


    public static String[][] createBoard(int lines, int columns){
        String[][] createdBoard = new String[lines][columns];
        for(int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                createdBoard[i][j] = "O";
            }
        }
        return createdBoard;
    }
    public static boolean checkSolution(String[][] array, int col){
        if(col >= array.length){
            return true;
        }
        for (int i = 0; i < array.length; i++) {
            if(checkPos(array, i, col)){
                array[i][col] = "F";
                if(checkSolution(array, col +1)){
                    return true;
                }
                array[i][col]="O";
            }
        }
        return false;
    }

    public static boolean checkPos(String[][] array, int line, int col){
        for (int i = 0; i < col; i++){
            if(array[line][i] == "F"){
                return false;
            }
        }
        for (int i = line - 1, j = col - 1; i >= 0 && j >= 0 ; i--, j --) {
            if(array[i][j] == "F"){
                return false;
            }
        }
        for (int i = line + 1, j = col - 1; i < array.length && j >= 0 ; i++, j --) {
            if(array[i][j] == "F"){
                return false;
            }
        }
        return true;
    }


}