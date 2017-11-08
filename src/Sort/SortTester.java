package Sort;

import java.util.Random;

public class SortTester {

    public static void main(String args[]) {
        Sorts test = new Sorts();
        Random random = new Random();

        //Checking all array sizes of varying n

        int sizeN[] = {10, 100, 1000, 10000, 100000, 1000000, 2000000};
        int mergeWins[] = new int[7];
        int quickWins[] = new int[7];
        long mergeTimes[] = new long[7];
        long quickTimes[] = new long[7];
        for(int i = 0; i < sizeN.length; i++) {
            long mergeAverage = 0, quickAverage = 0;
            System.out.println("Sorting arrays of size n=" + sizeN[i] + "...");

            //Starting Trials
            for(int trial = 0; trial < 20; trial++) {
                int randArray []= new int[sizeN[i]];

                for(int j = 0; j < sizeN[i]; j++) {
                    randArray[j] = random.nextInt(1000000);
                }

                int mergeArray[] = randArray.clone();
                int quickArray[] = randArray.clone();

                //mergeSort
                long estimatedTimeM = System.nanoTime();
                Sorts.mergeSort(mergeArray);
                estimatedTimeM = System.nanoTime() - estimatedTimeM;
                mergeAverage += estimatedTimeM;

                //quickSort
                long estimatedTimeQ = System.nanoTime();
                Sorts.quickSort(quickArray);
                estimatedTimeQ = System.nanoTime() - estimatedTimeQ;
                quickAverage += estimatedTimeQ;

                //Calculate wins
                if(estimatedTimeM < estimatedTimeQ) {
                    mergeWins[i]++;
                }
                if(estimatedTimeQ < estimatedTimeM) {
                    quickWins[i]++;
                }
            }

            mergeTimes[i] = mergeAverage/20;
            quickTimes[i] = quickAverage/20;

        }
        //Experiment #1 output
        System.out.println("\nExperiment #1");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|n\t\t\t|nTrials\t|#mergeSort Wins\t|#quickSort Wins\t|");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|10\t\t\t|20\t\t\t|" + mergeWins[0] + "\t\t\t\t\t|" + quickWins[0] + "\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|100\t\t|20\t\t\t|" + mergeWins[1] + "\t\t\t\t\t|" + quickWins[1] + "\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|1000\t\t|20\t\t\t|" + mergeWins[2] + "\t\t\t\t\t|" + quickWins[2] + "\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|10000\t\t|20\t\t\t|" + mergeWins[3] + "\t\t\t\t\t|" + quickWins[3] + "\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|100000\t\t|20\t\t\t|" + mergeWins[4] + "\t\t\t\t\t|" + quickWins[4] + "\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|1000000\t|20\t\t\t|" + mergeWins[5] + "\t\t\t\t\t|" + quickWins[5] + "\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|2000000\t|20\t\t\t|" + mergeWins[6] + "\t\t\t\t\t|" + quickWins[6] + "\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------");

        //Experiment #2 output
        System.out.println("\nExperiment #2");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|n\t\t\t|mergeSort mean\t|mergeSort mean\t\t|quickSort mean\t|quicksort mean\t\t|");
        System.out.println("|\t\t\t|nanoseconds\t|/(n*log2n)\t\t\t|nanoseconds\t|/(n*log2n)\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|10\t\t\t|"+mergeTimes[0]+"\t\t\t|" + mergeTimes[0]/(sizeN[0]*(Math.log(sizeN[0])/Math.log(2))) + "\t|" + quickTimes[0] + "\t\t\t|" + quickTimes[0]/(sizeN[0]*(Math.log(sizeN[0])/Math.log(2))) + "\t|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|100\t\t|"+mergeTimes[1]+"\t\t\t|" + mergeTimes[1]/(sizeN[1]*(Math.log(sizeN[1])/Math.log(2))) + "\t|" + quickTimes[1] + "\t\t\t|" + quickTimes[1]/(sizeN[1]*(Math.log(sizeN[1])/Math.log(2))) + "\t|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|1000\t\t|"+mergeTimes[2]+"\t\t\t|" + mergeTimes[2]/(sizeN[2]*(Math.log(sizeN[2])/Math.log(2))) + "\t|" + quickTimes[2] + "\t\t\t|" + quickTimes[2]/(sizeN[2]*(Math.log(sizeN[2])/Math.log(2))) + "\t|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|10000\t\t|"+mergeTimes[3]+"\t\t\t|" + mergeTimes[3]/(sizeN[3]*(Math.log(sizeN[3])/Math.log(2))) + "\t|" + quickTimes[3] + "\t\t\t|" + quickTimes[3]/(sizeN[3]*(Math.log(sizeN[3])/Math.log(2))) + "\t|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|100000\t\t|"+mergeTimes[4]+"\t\t|" + mergeTimes[4]/(sizeN[4]*(Math.log(sizeN[4])/Math.log(2))) + "\t|" + quickTimes[4] + "\t\t\t|" + quickTimes[4]/(sizeN[4]*(Math.log(sizeN[4])/Math.log(2))) + "\t|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|1000000\t|"+mergeTimes[5]+"\t\t|" + mergeTimes[5]/(sizeN[5]*(Math.log(sizeN[5])/Math.log(2))) + "\t|" + quickTimes[5] + "\t\t|" + quickTimes[5]/(sizeN[5]*(Math.log(sizeN[5])/Math.log(2))) + "\t|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|2000000\t|"+mergeTimes[6]+"\t\t|" + mergeTimes[6]/(sizeN[6]*(Math.log(sizeN[6])/Math.log(2))) + "\t|" + quickTimes[6] + "\t\t|" + quickTimes[6]/(sizeN[6]*(Math.log(sizeN[6])/Math.log(2))) + "\t|");
        System.out.println("-----------------------------------------------------------------------------------------");

    }

}
