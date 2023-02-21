package com.example.mainapp.utility;

public class Helper {

        public static boolean isStringOnlyAlphabet(String str) {
            return ((str != null)
                    && (!str.equals(""))
                    && (str.matches("^[a-zA-Z]*$")));
        }
}
