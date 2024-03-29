import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        byte[][] field = inputData();
        byte[][] field2 = new byte[field.length][field[0].length];
        int bestTotalPlotsForBuying = 0;
        double bestProcent = 0;
        while (true) {
<<<<<<< Updated upstream
            //[0] - totalGoodPlotsforByning, [1] - iMin, [2] - iMax, [3] - jMin, [4] - jMax
            int[] plotsCoordAndTotalPlotsForBuying = new int[5];
            boolean matrixHaveTheEntryPoints = false;
            plotsCoordAndTotalPlotsForBuying[1] = field.length - 1;
            plotsCoordAndTotalPlotsForBuying[3] = field[0].length - 1;
            matrixHaveTheEntryPoints = searchForTheEntryPointToTheMatrix(field, field2);
            if (matrixHaveTheEntryPoints == false)
                break;
            searchForPossiblePlotsOfLand(field, field2);
            searchForUnaccountedLandPlots(field, field2, plotsCoordAndTotalPlotsForBuying);
            int totalPlots = (plotsCoordAndTotalPlotsForBuying[2] - plotsCoordAndTotalPlotsForBuying[1] + 1) *
                    (plotsCoordAndTotalPlotsForBuying[4] - plotsCoordAndTotalPlotsForBuying[3] + 1);
            double procent = (plotsCoordAndTotalPlotsForBuying[0] * 100) / totalPlots;
            if (procent > bestProcent && totalPlots > 1) {
                bestTotalPlotsForBuying = totalPlots;
                bestProcent = procent;
            } else if (procent == bestProcent && bestTotalPlotsForBuying < totalPlots && totalPlots > 1)
                bestTotalPlotsForBuying = totalPlots;
            plotsCoordAndTotalPlotsForBuying[2] = 0;
            plotsCoordAndTotalPlotsForBuying[4] = 0;
            plotsCoordAndTotalPlotsForBuying[0] = 0;
            matrixHaveTheEntryPoints = false;
=======
            iMin=field.length-1;    jMin=field[0].length-1;
            field2 = searchForTheEntryPointToTheMatrix(field, field2);
            if (matrixHaveTheEntryPoints==false) break;
            field2 = searchForPossiblePlotsOfLand(field, field2);
            field2 = searchForUnaccountedLandPlots(field, field2);
            field2 = replaceAll1to2(field, field2);
            totalPlotsForBuying = (iMax - iMin + 1) * (jMax - jMin + 1);
            double procent = (totalGoodPlots * 100) / totalPlotsForBuying;
            if (procent > bestProcent && totalPlotsForBuying>1) {
                bestTotalPlotsForBuying = totalPlotsForBuying;
                bestProcent = procent;
            }
            if (procent == bestProcent && bestTotalPlotsForBuying<totalPlotsForBuying  && totalPlotsForBuying>1)
                bestTotalPlotsForBuying = totalPlotsForBuying;
            iMax=0; jMax=0; totalPlotsForBuying=0; totalGoodPlots=0; matrixHaveTheEntryPoints=false;
>>>>>>> Stashed changes
        }
        System.out.println(bestTotalPlotsForBuying);
    }

    public static boolean searchForTheEntryPointToTheMatrix(byte[][] field, byte field2[][]) {
        boolean matrixHaveTheEntryPoints = false;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == 1 && field2[i][j] != 2) {
                    field2[i][j] = field[i][j];
                    matrixHaveTheEntryPoints = true;
                    return matrixHaveTheEntryPoints;
                }
            }
        }
        return matrixHaveTheEntryPoints;
    }

    public static void searchForUnaccountedLandPlots(byte field[][],
                                                     byte field2[][],
                                                     int[] plotsCoordAndTotalBestPlotsForBuying) {
        for (int i = field.length - 1; i >= 0; i--) {
            for (int j = field[0].length - 1; j >= 0; j--) {
                if (field2[i][j] == 0 && field[i][j] == 1) {
                    for (int a = Math.max(0, i - 1); a < Math.min(field.length, i + 2); a++) {
                        for (int b = Math.max(0, j - 1); b < Math.min(field[0].length, j + 2); b++) {
                            if (field2[a][b] >= 1) {
                                field2[i][j] = 1;
                                break;
                            }
                        }
                        if (field2[i][j] == 1)
                            break;
                    }
                }
                if (field2[i][j] == 1) {
                    plotsCoordAndTotalBestPlotsForBuying[2] = Math.max(i, plotsCoordAndTotalBestPlotsForBuying[2]);
                    plotsCoordAndTotalBestPlotsForBuying[1] = Math.min(i, plotsCoordAndTotalBestPlotsForBuying[1]);
                    plotsCoordAndTotalBestPlotsForBuying[4] = Math.max(j, plotsCoordAndTotalBestPlotsForBuying[4]);
                    plotsCoordAndTotalBestPlotsForBuying[3] = Math.min(j, plotsCoordAndTotalBestPlotsForBuying[3]);
                    field2[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (i >= plotsCoordAndTotalBestPlotsForBuying[1] &&
                        i <= plotsCoordAndTotalBestPlotsForBuying[2] &&
                        j >= plotsCoordAndTotalBestPlotsForBuying[3] &&
                        j <= plotsCoordAndTotalBestPlotsForBuying[4] &&
                        field[i][j] == 1)
                    plotsCoordAndTotalBestPlotsForBuying[0]++;
            }
        }
    }

    public static void searchForPossiblePlotsOfLand(byte field[][], byte field2[][]) {
        boolean test = false;
        boolean test2 = false;
        int temp = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field2[i][j] == 1) {
                    for (int a = Math.max(0, i - 1); a < Math.min(field.length, i + 2); a++) {
                        for (int b = Math.max(0, j - 1); b < Math.min(field[0].length, j + 2); b++) {
                            if (field[a][b] == 1 && field2[a][b] == 0) {
                                field2[a][b] = 1;
                                if (a < i)
                                    test = test2 = true;
                                temp = j;
                            }
                        }
                    }
                }
                if (test && j == field[0].length - 1) {
                    i = i + 1;
                    j = temp;
                    test = false;
                }
                if (test2 && i > 0) {
                    i = i - 1;
                    test2 = false;
                }
            }
        }
    }

    public static byte[][] inputData() {
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

