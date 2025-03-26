package org.griddynamics.tasks;


import java.util.Stack;

public class Task2 {

    //Testing methods
    public static void main(String[] args){
        String stringToRevers = "I'm going to go to school today morning.";

        System.out.println("Test 1: ");
        System.out.println(reverseString1(stringToRevers));
        System.out.println("Test 2: ");
        System.out.println(reverseString2(stringToRevers));
        System.out.println("Test 3: ");
        System.out.println(reverseString3(stringToRevers));
    }

    //First method use StringBuilder reverse method
    public static String reverseString1(String string) {
        StringBuilder reversed = new StringBuilder(string);
        return reversed.reverse().toString();
    }

    //Second method use for loop to reverse string
    public static String reverseString2(String string) {
        StringBuilder reversed = new StringBuilder();
        for(int i = string.length()-1; i>=0; i--) {
            reversed.append(string.charAt(i));
        }
        return reversed.toString();
    }

    //Third method use stack for reversing. (LIFO)
    public static String reverseString3(String string) {
        Stack<Character> toReverse= new Stack<>();

        for(char c : string.toCharArray()) {
            toReverse.push(c);
        }
        StringBuilder reversed = new StringBuilder();

        while (!toReverse.isEmpty()){
            reversed.append(toReverse.pop());
        }

        return reversed.toString();
    }
}
