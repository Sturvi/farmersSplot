import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        byte[][] field = inputData();
        byte[][] field2 = new byte[field.length][field[0].length];
        boolean test = false;
        for (int i = 0; i < field.length; i++) {

            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == 1) {
                    field2[i][j] = field[i][j];
                    test = true;
                    break;
                }
            }
            if (test)
                break;
        }

        boolean itemp = true, jtemp = true;
        boolean itemp1 = true, jtemp1 = true;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field2[i][j] == 1) {
                    if (itemp == true) {
                        if (i < (field.length - 2) ? (field[i + 1][j] == 1) : false) {
                            field2[i + 1][j] = 1;
                            if (i == field.length - 2)
                                jtemp1 = false;
                        }
                        if ((j > 0 && i < field.length - 2) ? (field[i + 1][j - 1] == 1) : false) {
                            field2[i + 1][j - 1] = 1;
                            if (i == field.length - 2)
                                jtemp1 = false;
                        }
                    }
                    if (itemp == true && jtemp == true) {
                        if ((i < field.length - 2 && j < field[0].length - 2) ? (field[i + 1][j + 1] == 1) : false) {
                            field2[i + 1][j + 1] = 1;
                            if (j == field[0].length - 2)
                                jtemp1 = false;
                            if (i == field.length - 2)
                                jtemp1 = false;
                        }
                    }

                    if (jtemp == true) {

                        if (j < field[0].length - 2 ? (field[i][j + 1] == 1) : false) {
                            field2[i][j + 1] = 1;
                            if (j == field[0].length - 2)
                                jtemp1 = false;
                        }
                        if (((i > 0 && j < field[0].length - 2) ? (field[i - 1][j + 1] == 1) : false) &&
                                (i > 0 ? (field2[i - 1][j + 1] != 1) : false)) {
                            field2[i - 1][j + 1] = 1;
                            if (j == field[0].length - 2)
                                jtemp1 = false;
                            else
                                i = i - 1;
                        }
                    }
                    itemp = itemp1;
                    jtemp = jtemp1;


                }
            }

        }

        for (int i = field.length - 1; i >= 0; i--) {
            for (int j = field[0].length - 1; j >= 0; j--) {
                if (field2[i][j] == 0 && field[i][j] == 1) {
                    if ((i < (field.length - 2) ? (field2[i + 1][j] == 1) : false) ||
                            ((i < field.length - 2 && j < field[0].length - 2) ? (field2[i + 1][j + 1] == 1) : false) ||
                            (j < field[0].length - 2 ? (field2[i][j + 1] == 1) : false) ||
                            ((i > 0 && j < field[0].length - 2) ? (field2[i - 1][j + 1] == 1) : false) ||
                            ((i > 0) ? (field2[i - 1][j] == 1) : false) ||
                            ((i > 0 && j > 0) ? (field2[i - 1][j - 1] == 1) : false) ||
                            ((j > 0) ? (field2[i][j - 1] == 1) : false) ||
                            ((i < (field.length - 2) && j > 0) ? (field2[i + 1][j - 1] == 1) : false)
                    ) field2[i][j] = 1;
                }


            }

        }



    }

    public static  byte[][] inputData() {
        Scanner scanner = new Scanner(System.in);
        byte m = scanner.nextByte();
        byte n = scanner.nextByte();
        byte[][] field = new byte[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                field[i][j] = scanner.nextByte();
            }
        }
        return field;
    }
}

    /*public static byte[][](){
        Scanner scanner = new Scanner(System.in);
        byte n = scanner.nextByte();
        byte m = scanner.nextByte();
        byte [][] field = new byte[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                field[i][j]= scanner.nextByte();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(field[i][j]);
            }
        }
    }*/

/*
if ((i<(m-2)?(field2[i+1][j]==1):false) ||
        ((i<m-2 && j<n-2)?(field2[i+1][j+1]==1):false) ||
        (j<n-2?(field2[i][j+1]==1):false)  ||
        ((i>0 && j<n-2)?(field2[i-1][j+1]==1):false) ||
        ((i>0)?(field2[i-1][j]==1):false) ||
        ((i>0 && j>0)?(field2[i-1][j-1]==1):false) ||
        ((j>0)?(field2[i][j-1]==1):false) ||
        ((i<(m-2) && j>0)?(field2[i+1][j-1]==1):false)
        ) {
        field2[i][j]=1;
        }*/
