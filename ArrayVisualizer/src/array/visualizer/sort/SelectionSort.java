package array.visualizer.sort;

import array.visualizer.ArrayController;
import static array.visualizer.ArrayVisualizer.*;
import static array.visualizer.utils.Swaps.*;

public class SelectionSort implements Sort {
    public static void selectionSort(final ArrayController ac){
        for(int i = 0; i < ac.length-1; i++){
            int lowestindex = i;
            for(int j = i +1; j < ac.length; j++){
                if(ac.array[j] < ac.array[lowestindex]){
                    lowestindex = j; 
                }
                sleep(0.01);
                ac.comps++;
            }
            swap(ac, i, lowestindex);
        }
    }

    @Override
    public String name(){
        return "Selection Sort";
    }

    @Override
    public void sort(ArrayController ac){
        selectionSort(ac);
    }
}