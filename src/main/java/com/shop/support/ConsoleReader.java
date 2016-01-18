package com.shop.support;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by RSzczygielski on 2016-01-18.
 */
public class ConsoleReader {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readDate() {
        String dateFromUser = null;
        try {
            dateFromUser = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dateFromUser;
    }
}
