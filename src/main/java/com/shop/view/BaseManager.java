package com.shop.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RSzczygielski on 18.01.16.
 */
public abstract class BaseManager {
    private List<Commands> listOfCommands = new ArrayList<>();
    private Map<Integer, String> numbersAndDescriptorOfCommands = new HashMap<>();

    public void addCommand(Commands command, String descriptor) {
        listOfCommands.add(command);
        Integer numberOfCommand = listOfCommands.size();
        numbersAndDescriptorOfCommands.put(numberOfCommand, descriptor);
    }

    public void showCommandNumberAndDescriptor() {
        throw new UnsupportedOperationException();
    }

    public void executeCommand(String commandIndex) {
        Integer index = new Integer(commandIndex);
        Commands command = listOfCommands.get(index - 1);

        command.execute();
    }

    public Map<Integer, String> getCommandDescriptions() {
        return numbersAndDescriptorOfCommands;
    }
}
