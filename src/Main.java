package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Integer> findZeroSumElements(int[] arr) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        result.add(arr[i]);
                        result.add(arr[j]);
                        result.add(arr[k]);
                        return result;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = {-4, 1, 3, -2, -1};
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        List<Integer> result = findZeroSumElements(arr);

        if (result.isEmpty()) {
            System.out.println("No Elements found");
        } else {
            System.out.println("Elements whose sum is zero: " + result);
        }
    }
}
