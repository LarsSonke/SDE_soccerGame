package handlers;

import main.LoopHandler;

public class MenuHandler implements HandlerState {
    public MenuHandler()
    {
        menu();
    }

    public void invoke(String methodName, String[] args)
    {
        switch (methodName) {
            case "select" -> goToSelectMenu();
            case "exit" -> exit();
            case "player" -> goToPlayerMenu();
            case "help" -> menu();
            default -> cantFindCommand(methodName, args);
        }
    }

    private void goToPlayerMenu()
    {
        LoopHandler.instance.changeState(new PlayerMenuHandler());
    }

    private void goToSelectMenu()
    {
        LoopHandler.instance.changeState(new GameSelectHandler());
    }

    private void menu()
    {
        System.out.println("""
        -------------------------------------------
            Welcome TO STRIKAH DAH
            
            In this game you will be a striker trying to score a goal.
            
            If you type:
            player: you can edit your player
            select: select the game difficulty
            exit: you will quit the game
        -------------------------------------------
        """);
    }

    private void exit()
    {
        System.out.println("Goodbye!");
        LoopHandler.instance.changeState(new ExitHandler());
    }
}
