package main;

import handlers.*;
import main.ConsoleReader;

import java.util.Arrays;
import java.util.Map;


public class LoopHandler {
    public static LoopHandler instance = null;
    private HandlerState state;

    public LoopHandler() {
        instance = this;
        changeState(new MenuHandler());
        System.out.println();
    }

    public void changeState(HandlerState state) {
        this.state = state;
    }

    public void loop() {
        while (true) {
            String input = ConsoleReader.readLine().toLowerCase();
            if (input.isEmpty()) continue;
            String command = input.split(" ")[0];
            String[] args = Arrays.copyOfRange(input.split(" "), 1, input.length());
            System.out.print("\033[2J\033[1;1H");

            state.invoke(command, args);

            if (state instanceof ExitHandler) return;
        }
    }
}
