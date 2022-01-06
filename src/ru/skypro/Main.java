package ru.skypro;

import java.util.Arrays;
import java.util.Locale;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {

    public static void main(String[] args) {
        System.out.println(DuplicateEncoder.encode("Hello"));
        System.out.println(findUniq(new double[]{1, 1, 4, 1, 1, 1}));
        System.out.println(createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }


    public class DuplicateEncoder {
        static String encode(String word) {
            String lowerCaseWord = word.toLowerCase();
            char[] chars = lowerCaseWord.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (lowerCaseWord.lastIndexOf(chars[i]) == lowerCaseWord.indexOf(chars[i])) {
                    sb.append("(");
                } else
                    sb.append(")");
            }
            return sb.toString();
        }
    }

    public static int rowSumOddNumbers(int n) {
        return n * n * n;
    }

    private static double findUniq(double arr[]) {
        final double x = arr[arr[0] == arr[1] ? 0 : 2];
        for (double y : arr)
            if (y != x)
                return y;
        throw new RuntimeException("no unique number found");
    }

    private static double findUniq1(double arr[]) { // more understandable solution
        Arrays.sort(arr);
        return arr[0] == arr[1] ? arr[arr.length - 1] : arr[0];
    }

//    private static double findUniq2(final double [] array) {
//        return Arrays.stream(array).boxed()
//                .collect(groupingBy(identity(), counting()))
//                .entrySet().stream()
//                .filter(e -> e.getValue() == 1)
//                .findFirst()
//                .map(Entry::getKey)
//                .orElse(0.0);
//    }

    public static String createPhoneNumber(int[] numbers) {
        var format = "(xxx) xxx-xxxx";
        for (var i = 0; i < numbers.length; i++) {
            format = format.replaceFirst("x", String.valueOf(numbers[i]));
        }
        return format;
    }

//    public static String createPhoneNumber(int[] numbers) {
//        String phoneNumber = new String("(xxx) xxx-xxxx");
//
//        for (int i : numbers) {
//            phoneNumber = phoneNumber.replaceFirst("x", Integer.toString(i));
//        }
//
//        return phoneNumber;
//    }
//}

    public static boolean isPrime(int num) { //Define a function that takes one integer argument
        // and returns logical value true or false depending on if the integer is a prime.
        if (num < 2) return false;
        double sqrt = Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        } return true;
    }

}

