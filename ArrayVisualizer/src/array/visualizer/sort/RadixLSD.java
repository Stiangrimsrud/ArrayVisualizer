package array.visualizer.sort;

import array.visualizer.ArrayController;

import static array.visualizer.ArrayVisualizer.*;
import static array.visualizer.utils.Analysis.*;
import static array.visualizer.utils.Transcriptions.*;
import java.util.ArrayList;


public class RadixLSD implements Sort{
    private final int radix; 

    public RadixLSD(int radix){
        this.radix = radix;
    }

    public static void radixLSDsort_(final ArrayController ac, int radix){
        clearmarked();
        int highestpower = analyse(ac, radix);
        ArrayList<Integer>[] registers = new ArrayList[radix];

        for(int i = 0; i < radix; i++){
            registers[i] = new ArrayList<Integer>();
        }

        for(int p = 0; p <= highestpower; p++){
            for(int i = 0; i < ac.length; i++){
                ac.marked.set(1, i);
                sleep(1);
                registers[getDigit(ac.array[i], p, radix)].add(ac.array[i]);
            }
            transcribe(registers, ac);
        }
    }

    public static void radixLSDsort(final ArrayController ac, int radix) {
        clearmarked();
        int highestpower = analyse(ac, radix);
        ArrayList<Integer>[] registers = new ArrayList[radix];

        for (int i = 0; i < radix; i++) {
            registers[i] = new ArrayList<Integer>();
        }

        for (int p = 0; p <= highestpower; p++) {
            for (int i = 0; i < ac.length; i++) {
                ac.aa++;
                ac.marked.set(1, i);
                if(i % 2 == 0){
                    sleep(1);
                }
                registers[getDigit(ac.array[i], p, radix)].add(ac.array[i]);
            }
            fancyTranscribe(ac, registers);
        }
    }

    public static void radixLSDsortnd(final ArrayController ac, int radix, int min, int max){
        clearmarked();
        int highestpower = analyse(ac, radix);
        ArrayList<Integer>[] registers = new ArrayList[radix];

        for(int i = 0; i < radix; i++){
            registers[i] = new ArrayList<Integer>();
        }
        for(int p = 0; p <= highestpower; p++){
            for(int i = min; i < max; i++){
                registers[getDigit(ac.array[i], p, radix)].add(ac.array[i]);                
            }
            transcribend(ac, registers, min);
        }
    }

    @Override
    public String name(){
        return "Radix LSD SOrt (Base " + radix + ")";
    }

    @Override
    public void sort(ArrayController ac){
        radixLSDsort(ac, radix);
    }

}