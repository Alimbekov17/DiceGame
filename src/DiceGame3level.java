import java.util.Random;
import java.util.Scanner;

public class DiceGame3level {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("---           Start game          ---");
        System.out.println();
        System.out.println();

        int[] userPredicted = new int[3];
        int[] computerPredicted = new int[3];
        int[] userDice = new int[3];
        int[] computerDice = new int[3];
        int[] userResults = new int[3];
        int[] computerResults = new int[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Predict amount of points (2...12): ");
            int usersPoints = scanner.nextInt();
            userPredicted[i] = usersPoints;
            int userDice1 = random.nextInt(1,6);
            int userDice2 = random.nextInt(1,6);
            System.out.println("User rolls the dice...");
            rollTheDice(userDice1, userDice2);
            int userDicePoints = userDice1 + userDice2;
            userDice[i] = userDicePoints;
            int userResult = userDicePoints-Math.abs(userDicePoints-usersPoints)*2;
            userResults[i] = userResult;
            System.out.printf("Result is %d-abs(%d - %d) * 2: %d points", userDicePoints, userDicePoints, usersPoints, userResult);
            System.out.println();
            System.out.println();

            int computerPoints = random.nextInt(2,12);
            computerPredicted[i] = computerPoints;
            System.out.printf("Computer predicted %d points.", computerPoints);
            System.out.println();
            System.out.println("Computer rolls the dice...");
            int computerDice1 = random.nextInt(1,6);
            int computerDice2 = random.nextInt(1,6);
            rollTheDice(computerDice1,computerDice2);
            int computerDicePoints = computerDice1 + computerDice2;
            computerDice[i] = computerDicePoints;
            int computerResult = computerDicePoints-Math.abs(computerDicePoints-computerPoints)*2;
            computerResults[i] = computerResult;
            System.out.printf("Result is %d-abs(%d - %d) * 2: %d points", computerDicePoints, computerDicePoints, computerPoints, computerResult);
            System.out.println();
            System.out.println();

            result(userResult, computerResult);
        }
        int userFinalPoints = (userResults[0] + userResults[1] + userResults[2]);
        int computerFinalPoints = (computerResults[0] + computerResults[1] + computerResults[2]);
        System.out.printf("""
                  ------------ Finish game --------------
                  
                  
                  Round |           User |      Computer
                  ------+----------------+---------------
                        | Predicted:   %d | Predicted:  %d
                  - 1 - | Dice:        %d | Dice:       %d
                        | Result:     %d | Result:     %d
                 +------+----------------+---------------
                        | Predicted:   %d | Predicted:  %d
                  - 2 - | Dice:        %d | Dice:       %d
                        | Result:     %d | Result:     %d
                 +------+----------------+---------------
                        | Predicted:   %d | Predicted:  %d
                  - 3 - | Dice:        %d | Dice:       %d
                        | Result:     %d | Result:     %d
                 +------+----------------+---------------
                 Total  | Points:     %d | Points:     %d
                """, userPredicted[0],computerPredicted[0],userDice[0],computerDice[0],userResults[0],
                computerResults[0],userPredicted[1],computerPredicted[1],userDice[1],computerDice[1],userResults[1],
                computerResults[1],userPredicted[2],computerPredicted[2],userDice[2],computerDice[2],userResults[2],
                computerResults[2],userFinalPoints,computerFinalPoints);
        System.out.println();

        if (userFinalPoints>computerFinalPoints){
            System.out.println("Users win " + (userFinalPoints-computerFinalPoints) + " points more. Congratulations!");
        } else if (userFinalPoints<computerFinalPoints) {
            System.out.println("Computers win " + (computerFinalPoints - userFinalPoints) + " points more. Congratulations!");
        } else {
            System.out.println("Draw!");
        }
    }

    public static void result(int userResult, int computerResult){
        if (Math.abs(userResult)>Math.abs(computerResult)){
            int pointDif = Math.abs(userResult) - computerResult;
            System.out.println("--------- Current score ----------");
            System.out.println("User:          " + userResult + " points");
            System.out.println("Computer:      " + computerResult + " points");
            System.out.println();
            System.out.println("User is ahead by " + Math.abs(pointDif) + " points!");
            System.out.println("----------------------------------");
//            System.out.println("Users win " + Math.abs(pointDif) + " points more.");
//            System.out.println("Congratulations!");
            System.out.println();
        } else if(Math.abs(computerResult)>Math.abs(userResult)){
            int pointDif = Math.abs(computerResult) - userResult;
            System.out.println("--------- Current score ----------");
            System.out.println("User:          " + userResult + " points");
            System.out.println("Computer:      " + computerResult + " points");
            System.out.println();
            System.out.println("Computer is ahead by " + Math.abs(pointDif) + " points!");
            System.out.println("----------------------------------");
//            System.out.println("Computers win " + Math.abs(pointDif) + " points more.");
//            System.out.println("Congratulations!");
            System.out.println();
        } else {
            System.out.println("--------- Current score ----------");
            System.out.println("User:          " + userResult + " points");
            System.out.println("Computer:      " + computerResult + " points");
            System.out.println();
            System.out.println("Draw");
            System.out.println("----------------------------------");
            System.out.println();
        }
    }
    public static void rollTheDice(int dice1, int dice2){
        printDice(dice1);
        printDice(dice2);
        System.out.println();
        System.out.println("On the dice fell " + (dice1+dice2) + " points.");

    }
    public static void printDice(int diceSide){
        if (diceSide == 1) {
            System.out.println("+-------+\n|       |\n|   #   |\n|       |\n+-------+");

        } else if (diceSide == 2) {
            System.out.println("+-------+\n| #     |\n|       |\n|     # |\n+-------+");

        } else if (diceSide == 3) {
            System.out.println("+-------+\n| #     |\n|   #   |\n|     # |\n+-------+");

        } else if (diceSide == 4) {
            System.out.println("+-------+\n| #   # |\n|       |\n| #   # |\n+-------+");

        } else if (diceSide == 5) {
            System.out.println("+-------+\n| #   # |\n|   #   |\n| #   # |\n+-------+");

        } else if (diceSide == 6) {
            System.out.println("+-------+\n| #   # |\n| #   # |\n| #   # |\n+-------+");

        }
    }
}
