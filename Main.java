import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        byte[][] field = inputData();
        byte[][] field2 = new byte[field.length][field[0].length];

        field2=searchForTheEntryPointToTheMatrix(field,field2);
        field2=searchForPossiblePlotsOfLand(field, field2);
        field2=searchForUnaccountedLandPlots(field, field2);
        field2=replaceAll1to2(field2);


        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field2[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public static byte[][] replaceAll1to2 (byte field2[][]){
        for (int i = 0; i < field2.length; i++) {
            for (int j = 0; j < field2[0].length; j++) {
                if (field2[i][j]==1)
                    field2[i][j]=2;
            }
        }
        return field2;
    }
    public static byte[][] searchForTheEntryPointToTheMatrix (byte[][] field, byte field2[][]){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == 1 && field2[i][j]!=2) {
                    field2[i][j] = field[i][j];
                    return field2;
                }
            }
        }
        return field2;
    }
    public static byte[][] searchForUnaccountedLandPlots (byte field[][], byte field2[][] ){
        for (int i = field.length - 1; i >= 0; i--) {
            for (int j = field[0].length - 1; j >= 0; j--) {
                if (field2[i][j] == 0 && field[i][j] == 1) {
                    for (int a = Math.max(0, i - 1); a < Math.min(field.length, i + 2); a++) {
                        for (int b = Math.max(0, j - 1); b < Math.min(field[0].length, j + 2); b++) {
                            if (field2[a][b]==1) {
                                field2[i][j] = 1;
                                break;
                            }
                        }
                        if (field2[i][j]==1)
                            break;
                    }
                }
            }
        }
        return field2;
    }
    public static byte[][] searchForPossiblePlotsOfLand (byte field[][], byte field2[][]){
        boolean test=false; int temp=0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field2[i][j] == 1) {
                    for (int a = Math.max(0, i - 1); a < Math.min(field.length, i + 2); a++) {
                        for (int b = Math.max(0, j - 1); b < Math.min(field[0].length, j + 2); b++) {
                            if (field[a][b]==1 && field2[a][b] != 1) {
                                field2[a][b] = 1;
                                if (a<i)
                                    test=true;
                                    temp=j;
                            }
                        }
                    }

                }

                if (test && j==field[0].length-1) {
                    i = i + 1;
                    j=temp;
                    test = false;
                }
                if (test && i>0) {
                    i = i - 1;
                }
            }
        }
        return field2;
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

