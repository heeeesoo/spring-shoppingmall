package com.example.shoppingmall.java;

public class NullPointerExceptionEx {
    public static void main(String[] args) {
        String str = null;
        String[] strings = null;

        try {
            System.out.println(str.charAt(0));
        } catch (Exception e) {
            System.out.println("error - " + e);
        }
    }
}
