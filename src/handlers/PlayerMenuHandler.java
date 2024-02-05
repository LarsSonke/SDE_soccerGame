package handlers;

import main.LoopHandler;
import main.Player;

public class PlayerMenuHandler implements HandlerState {
    public PlayerMenuHandler()
    {
        menu();
    }

    public void invoke(String methodName, String[] args)
    {
        switch (methodName) {
            case "exit" -> exit();
            case "dribbling" -> upgradeDribbling(args);
            case "shooting" -> upgradeShooting(args);
            case "passing" -> upgradePassing(args);
            case "menu" -> menu();
            case "reset" -> reset();
            case "points" -> points();
            case "stats" -> stats();
            case "help" -> menu();
            case "back" -> goBack();
            default -> cantFindCommand(methodName, args);
        }
    }

    private void upgradeDribbling(String[] args){
        if (args[0] == null) return;

        int upgradePoints = Integer.parseInt(args[0]);
        if (!Player.getInstance().canAffordUpgrade(upgradePoints)) return;
        Player.getInstance().statistics.addDribbling(upgradePoints);

        System.out.printf(
            """
                You have successfully upgraded your dribbling to %d
                Your leftover amount of points is: %d
            
            """,
            Player.getInstance().statistics.getDribbling(),
            Player.getInstance().pointsLeftOver()
        );
    }

    private void upgradeShooting(String[] args){
        if (args[0] == null) return;

        int upgradePoints = Integer.parseInt(args[0]);
        if (!Player.getInstance().canAffordUpgrade(upgradePoints)) return;
        Player.getInstance().statistics.addShooting(upgradePoints);

        System.out.printf(
            """
                You have successfully upgraded your shooting to %d
                Your leftover amount of points is: %d
            
            """,
            Player.getInstance().statistics.getShooting(),
            Player.getInstance().pointsLeftOver()
        );
    }

    private void upgradePassing(String[] args){
        if (args[0] == null) return;

        int upgradePoints = Integer.parseInt(args[0]);
        if (!Player.getInstance().canAffordUpgrade(upgradePoints)) return;
        Player.getInstance().statistics.addPassing(upgradePoints);

        System.out.printf(
            """
                You have successfully upgraded your passing to %d
                Your leftover amount of points is: %d
            
            """,
            Player.getInstance().statistics.getPassing(),
            Player.getInstance().pointsLeftOver()
        );
    }

    private void reset()
    {
        Player.getInstance().statistics.reset();
        System.out.println("You have successfully reset your points\n");
        points();
    }

    private void points()
    {
        System.out.printf(
            """
                You have %d points left
                You have used %d points
                For a total of %d points
            """,
            Player.getInstance().pointsLeftOver(),
            Player.getInstance().statistics.pointsUsed(),
            Player.getInstance().level.getSkillPoints()
        );
    }

    private void stats()
    {
        System.out.printf(
                """
                    Passing:   %d
                    Dribbling: %d
                    Shooting:  %d
                    
                """,
                Player.getInstance().statistics.getPassing(),
                Player.getInstance().statistics.getDribbling(),
                Player.getInstance().statistics.getShooting()
        );
    }

    private void menu()
    {
        System.out.println("""
            -------------------------------
                  Player Builder Menu
            -------------------------------
            
            menu: get this menu.
            back: go back to main menu.
            points: display information about points and points used.
            stats: display your current stats.
            dribbling []: upgrade your dribbling to x points.
            passing []: upgrade your passing to x points.
            shooting []: upgrade your shooting to x points.
            reset: reset your statistics to default.
        """);
    }

    private void goBack()
    {
        LoopHandler.instance.changeState(new MenuHandler());
    }

    private void exit()
    {
        System.out.println("Goodbye!");
        LoopHandler.instance.changeState(new ExitHandler());
    }
}
