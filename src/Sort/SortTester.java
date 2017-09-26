package Sort;

import java.util.Random;

public class SortTester {

    public static void main(String args[]) {
        Sorts test = new Sorts();
        Random random = new Random();

        //Checking all array sizes of varying n

        int sizeN[] = {10, 100, 1000, 10000, 100000, 1000000, 2000000};
        for(int i = 0; i < sizeN.length; i++) {
            int mergeWins = 0;
            int quickWins = 0;
            long mergeTimes[] = new long[20];
            long quickTimes[] = new long[20];
            System.out.println("For arrays of size n=" + sizeN[i] + ":");

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
                mergeTimes[trial] = estimatedTimeM;

                //quickSort
                long estimatedTimeQ = System.nanoTime();
                Sorts.quickSort(quickArray);
                estimatedTimeQ = System.nanoTime() - estimatedTimeQ;
                quickTimes[trial] = estimatedTimeQ;

                //Calculate wins
                if(estimatedTimeM < estimatedTimeQ) {
                    mergeWins+=1;
                }
                if(estimatedTimeQ < estimatedTimeM) {
                    quickWins+=1;
                }
            }
            int mergeAverage = 0, quickAverage = 0;
            for(int a = 0; a < 20; a++) {
                mergeAverage += mergeTimes[a];
                quickAverage += quickTimes[a];
            }
            mergeAverage = mergeAverage/20;
            quickAverage = quickAverage/20;

            //Experiment #1 output
            System.out.println("\tExperiment #1");
            System.out.println("\t\tmergeSort wins: " + mergeWins);
            System.out.println("\t\tquickSort wins: " + quickWins);

            //Experiment #2 output
            System.out.println("\tExperiment #2");
            System.out.println("\t\tmergeSort average time: " + mergeAverage);
            System.out.println("\t\tquickSort average time: " + quickAverage);
            System.out.println("\n");
        }

    }

}
