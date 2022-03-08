package array.visualizer.utils;

import array.visualizer.ArrayController; 
import static array.visualizer.ArrayVisualizer.*;

public class Swaps {
    public static void swap(final ArrayController ac, int i, int j){
        ac.marked.set(1, i);
        ac.marked.set(2, j);
        ac.aa++;
        int temp = ac.array[i];
        ac.array[i] = ac.array[j];
        ac.array[j] = temp;
    }

    public static void swap(final ArrayController ac, int i, int j, double pause) {
        ac.marked.set(1, i);
        ac.marked.set(2, j);
        ac.aa+=2;
        sleep(pause);
        int temp = ac.array[i];
        ac.array[i] = ac.array[j];
        ac.array[j] = temp;
    }

    public static void swapnm(final ArrayController ac, int i, int j, double pause){
        sleep(pause);
        ac.aa+=2;
        int temp = ac.array[i];
        ac.array[i] = ac.array[j];
        ac.array[j] = temp;
    }

    public static void swapUpTo(final ArrayController ac, int pos, int to, double pause){
        if(to - pos > 0)
            for(int i = pos; i < to; i++)
                swap(ac, i, i+1, pause);
        else 
            for(int i = pos; i > to; i--)
                swap(ac, i, i-1, pause);
    }

    public static void swapUpToNM(final ArrayController ac, int pos, int to, double pause){
        if(to-pos > 0)
            for(int i = pos; i < to; i++)
                swapnm(ac, i, i+1, pause);
        else    
            for(int i = pos; i > to; i--)
                swapnm(ac, i, i-1, pause);
    }

    public static void swapUp(final ArrayController ac, int pos, double pause){
        for(int i = pos; i < ac.length; i++)
            swap(ac, i, i+1, pause);
    }
}
