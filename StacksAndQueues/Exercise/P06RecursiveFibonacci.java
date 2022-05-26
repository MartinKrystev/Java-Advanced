package com.company.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> fibonacci = new ArrayDeque<>();
        System.out.println(getFibonacciNumber(fibonacci, n));
    }

    private static long getFibonacciNumber(ArrayDeque<Long> fibonacci, Long n) {
        if (n < 2) {
            return 1L;
        } else {
            fibonacci.offer(0L);
            fibonacci.offer(1L);
            for (int i = 0; i < n; i++) {
                long sum = fibonacci.poll() + fibonacci.peek();
                fibonacci.offer(sum);
            }
        }
        fibonacci.poll();
        return fibonacci.peek();
    }
}
