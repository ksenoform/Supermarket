package com.shop.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RSzczygielski on 18.01.16.
 */
public class MainCommandMenu extends BaseManager {
    private List<Commands> listOfCommands = new ArrayList<>();
    private Map<Integer, String> numbersAndDescriptorOfCommands = new HashMap<>();

    @Override
    public void addCommand(Commands command, String descriptor) {
        listOfCommands.add(command);
        Integer numberOfCommand = listOfCommands.size();
        numbersAndDescriptorOfCommands.put(numberOfCommand, descriptor);
    }

    @Override
    public void showCommandNumberAndDescriptor() {
        for (Map.Entry<Integer, String> integerStringEntry : numbersAndDescriptorOfCommands.entrySet()) {
            System.out.println(integerStringEntry.getKey()
                    + ". "
                    + integerStringEntry.getValue());
        }
    }

    @Override
    public void executeCommand(String commandIndex) {
        Integer index = new Integer(commandIndex);
        Commands command = listOfCommands.get(index - 1);

        command.execute();
    }
}
