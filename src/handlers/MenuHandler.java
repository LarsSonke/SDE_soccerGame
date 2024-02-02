package handlers;

import main.LoopHandler;

public class MenuHandler implements HandlerState {
    public void invoke(String methodName, String[] args)
    {
        switch (methodName) {
            case "exit" -> exit();
            case "start" -> start();
        }
    }

    private void exit()
    {
        System.out.println("bye bye *mewing sounds*");
        LoopHandler.instance.changeState(new ExitHandler());
    }

    private void start()
    {
        System.out.println("LETS START THIS SHIT TUH TUH TUH");
//        LoopHandler.instance.changeState();
    }

}
