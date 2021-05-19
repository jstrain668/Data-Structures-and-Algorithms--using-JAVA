package BigO.example;

import java.util.Arrays;
import org.apache.commons.lang3.time.StopWatch;

class FindingNemo {

    private final static String NEMO = "nemo";

    public static void main(String[] args) {

        String[] nemo = new String[] {"bird","blob","hiccup","magic","kirk","kop","Nemo","darla","bop"};
        String[] large = new String[10];
        StopWatch stopWatch = new StopWatch();
        fillArray(large);
        //printArray(large);

        stopWatch.start();
        findNemo(large);
        stopWatch.stop();

        System.out.println("Execution time in nano seconds for findNemo: "+stopWatch.getNanoTime());

        stopWatch.reset();
        stopWatch.start();
        findNemo(large);
        stopWatch.stop();
        System.out.println("Execution time in milli seconds for findNemo: "+stopWatch.getTime());

        stopWatch.reset();
        stopWatch.start();
        findNemoA(large);
        stopWatch.stop();

        System.out.println("Execution time in nano seconds for findNemo: "+stopWatch.getNanoTime());
    }

    private static void fillArray(String[] strArray){
        Arrays.fill(strArray, "Nemo");
    }

    private static void printArray(String[] strArray){
        for (String strElement : strArray){
            System.out.println(strElement);
        }
    }

    private static void findNemo(String[] strArray){

        for (String strElement : strArray){
            if (strElement.equalsIgnoreCase(NEMO))
                System.out.println("Nemo found");
        }
    }

    private static void findNemoA(String[] strArray){

        for (int i=0; i< strArray.length; i++){
            if (strArray[i].equalsIgnoreCase(NEMO))
                System.out.println("Nemo found");
        }

    }
}
