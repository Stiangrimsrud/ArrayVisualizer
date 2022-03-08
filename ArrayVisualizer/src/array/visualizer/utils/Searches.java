package array.visualizer.utils;

import array.visualizer.ArrayController;
import static array.visualizer.ArrayVisualizer.*;

public class Searches{
    public static void linearSearch(final ArrayController ac, int find) throws Exception {
        for(int i = 0; i < ac.length; i++){
            ac.aa++;
            ac.comps++;
            if(ac.array[i]==find)
                break;
            ac.marked.set(0, i);
            sleep(5);
        }
        sleep(1000);
    }

    public static binarySearch(final ArrayController ac, int find) throws Exception {
        int at = ac.length/2;
        int change = ac.length/4;

        while(ac.array[at] != find && change > 0){
            ac.marked.set(0, ac.array[at]);
            ac.comps+=2;
            ac.aa++;
            Thread.sleep(1000);
            if(ac.array[at] < find)
                at += change;
            else 
                at -= change;
            change /= 2;
        }
        sleep(1000);
    }
}