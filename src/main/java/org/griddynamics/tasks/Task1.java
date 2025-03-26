package org.griddynamics.tasks;

import java.util.Arrays;

public class Task1 {

    //Testing method isAscending
    public static void main(String[] args){
        int size = 4;
        int[] array1 = {1,3,5,12};
        int[] array2 = {1,3,42,2};
        int[] array3 = {};
        int[] array4 = {1,2,3};

        //Testing ascending array
        System.out.println(isAscending(size,array1));

        //Testing non-ascending array
        System.out.println(isAscending(size,array2));

        //Testing empty array
        System.out.println(isAscending(0,array3));

        //Testing a diffrent sizes
        //System.out.println(isAscending(size,array4));

    }

    /**
     * Method that check, if array is sorted in ASC order.
     * @param size - size of the array
     * @param array - array of ints
     * @return - true if array is in ASC order, otherwise false.
     */
    public static boolean isAscending(int size, int[] array){

        if(size == 0 || size==1){
            return false;
        }

        //If size is different then array size, throw illegal argument exception.
        if(size!=array.length){
            throw new IllegalArgumentException("Array have diffrent size than provided");
        }

        for(int i = 1; i<size; i++){
            //If next element is smaller than previous, the its not in ASC order.
            if(array[i]<array[i-1]){
                return false;
            }
        }
        return true;
    }
}

