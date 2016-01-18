package com.shop.view;

/**
 * Created by RSzczygielski on 18.01.16.
 */
public abstract class BaseManager {
    public void addCommand(Commands command, String descriptor) {
        throw new UnsupportedOperationException();
    }

    public void showCommandNumberAndDescriptor() {
        throw new UnsupportedOperationException();
    }

    public void executeCommand(String commandIndex) {
        throw new UnsupportedOperationException();
    }
}
