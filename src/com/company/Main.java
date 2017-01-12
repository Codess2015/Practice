package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //isPower(4);

        //ArrayList<Integer> a =
        reverse(3);
    }

    // Find two prime numbers that will sum to the given number. Hence, p1 + p2 = a, find p1
    // and p2. If more than one combination of p1 and p2 exist, return the smallest p1.
    private static ArrayList<Integer> primesum(int a) {
        if (a < 3) {
            return null;
        }

        boolean[] arr = new boolean[a-3];
        int x = ((a)/2) - 1;

        for (int i=0; i <= x; i++) {
            if (!arr[i]) {
                int currNum = i + 2;
                int nextNum = currNum+currNum;
                while (nextNum <= (a-2)) {
                    arr[nextNum-2] = true;
                    nextNum += currNum;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i< arr.length; i++) {
            if (!arr[i]) {
                int n1 = i+2;
                if (!arr[a-n1-2]) {
                    int n2 = a-n1;
                    list.add(n1);
                    list.add(n2);
                    return list;
                }
            }

        }

        return null;
    }

    // Find if a can be presented as a power p^b, where p > 1 and b > 1
    private static boolean isPower(int a) {

        if (a < 0) {
            return false;
        }

        int power = 2;
        double powerRoot = Math.pow(a, (1.0/power));
        while (powerRoot >= 2) {
            if ((int) Math.round(Math.pow(Math.round(powerRoot), power)) == a) {
                return true;
            }
            power += 1;
            powerRoot = Math.pow(a, (1.0/power));
        }
        return false;
    }

    // print all the diagnols of a N*N matrics starting with 0,0.
    private static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (a.size() == 0){
            return result;
        }

        int n = a.size();

        for (int i = 0; i < n; i++) {
            int x = 0;
            ArrayList<Integer> curr = new ArrayList<>();
            for (int j=i; j>=0; j--) {
                curr.add(a.get(x).get(j));
            }
            result.add(curr);
        }

        for (int i=1; i < n; i++) {
            int y=n-1;
            ArrayList<Integer> curr = new ArrayList<>();
            for(int j=i; j < n; j++) {
                curr.add(a.get(j).get(y));
            }

            result.add(curr);
        }

        return result;
    }

    // reverse a 32 bit integer. Since java doesn't have unsigned int, use long.
    public static long reverse(long a) {
        long mask = 1;
        long mask2 = (long) 1 << 31;
        long result = 0;

        for(int i=0; i<32; i++){
            if((mask & a) > 0) {
                result = result | mask2;
            }
            mask = mask << 1;
            mask2 = mask2 >> 1;
        }

        return result;
    }
}
