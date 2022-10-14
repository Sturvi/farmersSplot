import java.util.Scanner;

public class Main {

    public static int totalPlotsForBuying=0, totalGoodPlots=0;
    public static int iMin, iMax=0, jMin, jMax=0;
    public static boolean matrixHaveTheEntryPoints=false;

    public static void main(String[] args) {
        byte[][] field = inputData();
        byte[][] field2 = new byte[field.length][field[0].length];
        int bestTotalPlotsForBuying=0;
        double bestProcent=0;


        while (true) {
            iMin=field.length-1;    jMin=field[0].length-1;
            field2 = searchForTheEntryPointToTheMatrix(field, field2);
            if (matrixHaveTheEntryPoints==false) break;
            field2 = searchForPossiblePlotsOfLand(field, field2);
            field2 = searchForUnaccountedLandPlots(field, field2);
            field2 = replaceAll1to2(field, field2);
            totalPlotsForBuying = (iMax - iMin + 1) * (jMax - jMin + 1);
            double procent = (totalGoodPlots * 100) / totalPlotsForBuying;
            if (procent > bestProcent) {
                bestTotalPlotsForBuying = totalPlotsForBuying;
                bestProcent = procent;
            }
            if (procent == bestProcent && bestTotalPlotsForBuying<totalPlotsForBuying)
                bestTotalPlotsForBuying = totalPlotsForBuying;
            iMin=0; iMax=0; jMin=0; jMax=0; totalPlotsForBuying=0; totalGoodPlots=0; matrixHaveTheEntryPoints=false;
        }
        System.out.println(bestTotalPlotsForBuying);
    }

    public static byte[][] replaceAll1to2 (byte field[][], byte field2[][]){
        for (int i = 0; i < field2.length; i++) {
            for (int j = 0; j < field2[0].length; j++) {
                if (field2[i][j]==1)    field2[i][j]=2;

                if (i>=iMin && i<=iMax && j>=jMin && j<=jMax)
                    if (field[i][j]==1) totalGoodPlots++;
            }
        }
        return field2;
    }
    public static byte[][] searchForTheEntryPointToTheMatrix (byte[][] field, byte field2[][]){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == 1 && field2[i][j]!=2) {
                    field2[i][j] = field[i][j];
                    matrixHaveTheEntryPoints=true;
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
                if (field2[i][j]==1 && field[i][j]!=2) {
                    iMax = Math.max(i, iMax);
                    iMin = Math.min(i, iMin);
                    jMax = Math.max(j, jMax);
                    jMin = Math.min(j, jMin);
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
        byte[][] field = new byte[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                field[i][j] = scanner.nextByte();
            }
        }
        return field;
    }
}

