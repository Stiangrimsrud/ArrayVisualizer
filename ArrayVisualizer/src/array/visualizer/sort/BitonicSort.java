package array.visualizer.sort;

import array.visualizer.ArrayController;

public class BitonicSort implements Sort {

    public static void bitonicSort(final ArraController ac){
        bitonicMerge(ac, 0, ac.length, true);
    }

    public static void bitonicMerge(final ArrayController ac, int start, int end, boolean dir){
        int mid = (start+end)/2;
        if(start == mid){
            return;
        }
        bitonicMerge(ac, start, mid, dir);
        bitonicMerge(ac, mid, end, dir);

        int low = start;
        int high = end;

        if(dir){
            for(int i = 0; i < end - start; i++);
        }
    }

    @Override
    public String name(){
        return "Bitomic Sort";
    }

    @Override
    public void sort(ArrayController ac){
        bitonicSort(ac);
    }
}