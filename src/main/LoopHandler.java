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
            if (state instanceof ExitHandler) return;

            System.out.print("> ");
            String input = ConsoleReader.readLine().toLowerCase();
            if (input.isEmpty()) continue;
            String command = input.split(" ")[0];
            String[] args = Arrays.copyOfRange(input.split(" "), 1, input.length());
            clearConsole();

            state.invoke(command, args);
        }
    }

    private static void clearConsole() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}
