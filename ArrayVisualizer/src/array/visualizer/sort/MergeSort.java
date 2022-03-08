package array.visualizer.sort;

import array.visualizer.ArrayController;
import array.visualizer.ArrayVisualizer;
import static array.visualizer.utils.Swaps.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeSort implements Sort{
    static void merge(final ArrayController ac, int min, int max, int mid){
        try {
            int i = min;
            while(i <= mid){
                if(ac.array[i] > ac.array[mid+1]){
                    ac.comps++;
                    swap(ac, i, mid + 1, 1.5);
                    push(ac, mid+1, max);
                }
                i++;
            }
        } catch (Exception e){
            Logger.getLogger(ArrayVisualizer.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    static void push(final ArrayController ac, int s, int e){
        for(int i = s; i < e; i++){
            if(ac.array[i] > ac.array[i+1]){
                ac.comps++;
                swap(ac, i, i+1, 0.0175);
            }
        }
    }

    public static void mergeSort(final ArrayController ac, int min, int max){
        if(max-min==0){

        } else if(max - min == 1){
            if(ac.array[min] > ac.array[max]){
                swap(ac, min, max);
            }
        } else {
            int mid = ((int)Math.floor((min+max)/2));
            mergeSort(ac, min, mid);
            mergeSort(ac, mid+1, max);
            merge(ac, min, max, mid); 
        }
    }

    @Override
    public String name(){
        return "Merge Sort";
    }

    @Override
    public void sort(ArrayController ac){
        mergeSort(ac, 0, ac.length-1);
    }
}
