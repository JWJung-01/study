package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj11502 {

    static List<Integer> intList = new ArrayList<>();

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        for(int i=0; i<input; i++){
            int number = scanner.nextInt();
            answer(number);
        }


    }

    static void addPrime() {
        for (int i = 2; i < 1000; i++) {
            if (primeCheck(i)) {
                intList.add(i);
            }
        }
    }

    static boolean primeCheck(int i) {
        if (i == 1) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        for (int p = 2; p < (int) Math.sqrt(i) + 1; p++) {
            if (i % p == 0) {
                return false;
            }
        }
        return true;
    }


    static void answer(int k) {
        addPrime();
        int size = intList.size();
        int max = 1000;
        int save = 0;
        outerLoop:
        for (int p = 0; p < size; p++) {
            int a = intList.get(p);
            for (int q = 0; q < size; q++) {
                int b = intList.get(q);
                for (int w = 0; w < size; w++) {
                    int c = intList.get(w);
                    if (a + b + c > max) {
                        break;
                    }
                    if (a + b + c == k) {
                        System.out.println(intList.get(p) + " " + intList.get(q) + " " + intList.get(w));
                        save = 1;
                        break outerLoop;
                    }
                }
            }
        }
        if(save==0){
            System.out.println(0);
        }
    }

}


