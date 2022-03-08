package array.visualizer.sort;

import array.visualizer.ArrayController;
import array.visualizer.ArrayVisualizer;

import static array.visualizer.ArrayVisualizer.*;
import static array.visualizer.sort.InsertionSort.*;
import static array.visualizer.utils.Swaps.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WeaveMerge implements Sort {
    static void weaveMerge(final ArrayController ac, int min, int max, int mid){
        try {
            int i = 1; 
            int target = (mid-min);

            while(i <= target){
                swapUpTo(ac, mid+i, min+i*2-1, 0.01);
                i++;
                sleep(1);
            }
            insertionSort(ac, min, max+1, 0.15);
        } catch (Exception ex) {
            Logger.getLogger(ArrayVisualizer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void push(final ArrayController ac, int s, int e){
        for(int i= s; i < e; i++){
            if(ac.array[i] > ac.array[i+1]){
                ac.comps++;
                swap(ac, i, i+1);
            }
        }
    }

    public static void weaveMergeSort(final ArrayController ac, int min, int max){
        if(max - min == 0){

        } else if(max-min == 1){
            if(ac.array[min] > ac.array[max]){
                swap(ac, min, max);
            }
        } else {
            int mid = ((int)Math.floor((min+max)/2));
            weaveMergeSort(ac, min, mid);
            weaveMergeSort(ac, mid+1, max);
            weaveMerge(ac, min, max, mid);
        }
    }

    @Override
    public String name(){
        return "Merge+Insertion Sort";
    }

    @Override
    public void sort(ArrayController ac){
        weaveMergeSort(ac, 0, ac.length-1);
    }
}
