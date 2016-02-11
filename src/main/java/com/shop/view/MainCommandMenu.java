package com.shop.view;

import java.util.Map;

/**
 * Created by RSzczygielski on 18.01.16.
 */
public class MainCommandMenu extends BaseManager {
    @Override
    public void showCommandNumberAndDescriptor() {
        for (Map.Entry<Integer, String> integerStringEntry : super.getCommandDescriptions().entrySet()) {
            System.out.println(integerStringEntry.getKey()
                    + ". "
                    + integerStringEntry.getValue());
        }
    }
}
