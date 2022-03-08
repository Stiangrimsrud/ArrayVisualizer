package array.visualizer.sort;

import array.visualizer.ArrayController;
import static array.visualizer.utils.Swaps.*;


public class CocktailShaker implements Sort {
    public static void cocktailShakerSort(final ArrayController ac){
        int i = 0; 

        while(i < ac.length/2){
            for(int j = i; j < ac.length-i-1; j++){
                ac.comps++;
                if(ac.array[j] > ac.array[j+1])
                    swap(ac, j, j+1, 0.022);
            }
            for(int j = ac.length-i-1; j > i; j--){
                ac.comps++;
                if(ac.array[j] < ac.array[j-1])
                    swap(ac, j, j-1, 0.022);
            }
            i++;
        }
    }

    @Override
    public String name(){
        return "Cocktail Shaker Sort";
    }

    @Override
    public void sort(ArrayController ac){
        cocktailShakerSort(ac);
    }
}