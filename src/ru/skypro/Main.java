package ru.skypro;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        System.out.println(DuplicateEncoder.encode("Hello"));
        System.out.println(findUniq(new double[]{1, 1, 4, 1, 1, 1}));
        System.out.println(createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
        //  order("is2 Thi1s T4est 3a");
        System.out.println(validatePin("1934"));
        System.out.println(camelCase("camelCase"));
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
        }
        return true;
    }

//    not solved
//    public static void order(String words) { //Your task is to sort a given string.
//        // Each word in the string will contain a single number.
//        // This number is the position the word should have in the result.
//        String[] split = words.split(" ");
//        Arrays.stream(split)
//                .filter(w -> w.replaceAll("\\D", "").length() > 0)
//                .collect(Collectors.toMap(w -> Integer.parseInt(w.replaceAll("\\D", "")), w -> w))
//                .forEach((k, v) -> System.out.print(v + " "));
//    }

    public static boolean validatePin(String pin) {
        //ATM machines allow 4 or 6 digit PIN codes and PIN codes cannot contain anything
        // but exactly 4 digits or exactly 6 digits.
        //If the function is passed a valid PIN string, return true, else return false.
        char[] chars = pin.toCharArray();
        if (chars.length != 4 && chars.length != 6) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }

    //    public static boolean validatePin(String pin) {
//    if (pin == null || (pin.length() != 4 && pin.length() != 6)) {
//        return false;
//    }
//
//    for (int i = 0; i < pin.length(); i++) {
//        if (!Character.isDigit(pin.charAt(i))) {
//            return false;
//        }
//    }
//    return true;

//    public static boolean validatePin(String pin) {
//        return pin.matches("\\d{4}|\\d{6}");
//    }

    public static String camelCase(String input) {
        //Complete the solution so that the function will break up camel casing, using a space between words.
        String out = "";
        for (int i=0; i<input.length(); i++) {
            String c = Character.toString(input.charAt(i));
            if (c.equals(c.toUpperCase())) {
                out+=" ";
            }
            out+=c;
        }
        return out;
    }
    //public static String camelCase(String input) {
    //        String result = "";
    //        String[] array = input.split("");
    //
    //        for (int i = 0; i < input.length(); i++) {
    //            if (array[i].equals(array[i].toUpperCase())) {
    //                result += " " + array[i];
    //            }else {
    //                result += array[i];
    //            }
    //        }
    //        return result;
    //    }

//    public static String camelCase(String input) {
//        return input.replaceAll("([A-Z])", " $1");
//    }
}

}

