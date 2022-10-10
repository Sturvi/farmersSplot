import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte n = scanner.nextByte();
        byte m = scanner.nextByte();
        byte[][] field = new byte[m][n];
        byte[][] field2 = new byte[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                field[i][j] = scanner.nextByte();
            }
        }
        for (int i = 0; i < m; i++) {
            boolean test = false;
            for (int j = 0; j < n; j++) {
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
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (field2[i][j] == 1) {
                    if (itemp == true) {
                        if (i<(m-1)?(field[i + 1][j] == 1):false) {
                            field2[i + 1][j] = 1;
                            if (i == m - 2)
                                jtemp1 = false;
                        }
                        if ((j>0&&i<m-1)?(field[i + 1][j - 1] == 1):false) {
                            field2[i + 1][j - 1] = 1;
                            if (i == m - 2)
                                jtemp1 = false;
                        }
                    }
                    if (itemp == true && jtemp == true) {
                        if ((i<m-1&&j<n-1)?(field[i + 1][j + 1] == 1):false) {
                            field2[i + 1][j + 1] = 1;
                            if (j == n - 2)
                                jtemp1 = false;
                            if (i == m - 2)
                                jtemp1 = false;
                        }
                    }

                    if (jtemp == true) {

                        if (j<n-1?(field[i][j + 1] == 1):false) {
                            field2[i][j + 1] = 1;
                            if (j == n - 2)
                                jtemp1 = false;
                        }
                        if ((i>0?(field[i - 1][j + 1] == 1):false) && (i>0?(field2[i - 1][j + 1] != 1):false)) {
                            field2[i - 1][j + 1] = 1;
                            if (j == n - 2)
                                jtemp1 = false;
                            else
                                i = i-2;
                        }
                    }
                    itemp=itemp1;
                    jtemp=jtemp1;


                }
            }

        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(field2[i][j]);
            }
            System.out.println("");
        }
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

