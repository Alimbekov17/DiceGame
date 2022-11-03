import java.util.Random;
import java.util.Scanner;

public class DiceGame2level {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("---           Start game          ---");
        System.out.println();
        System.out.println();

        System.out.print("Predict amount of points (2...12): ");
        int usersPoints = scanner.nextInt();
        int userDice1 = random.nextInt(1,6);
        int userDice2 = random.nextInt(1,6);
        System.out.println("User rolls the dice...");
        rollTheDice(userDice1, userDice2);
        int userDicePoints = userDice1 + userDice2;
        int userResult = userDicePoints-Math.abs(userDicePoints-usersPoints)*2;
        System.out.printf("Result is %d-abs(%d - %d) * 2: %d points", userDicePoints, userDicePoints, usersPoints, userResult);
        System.out.println();
        System.out.println();

        int computerPoints = random.nextInt(2,12);
        System.out.printf("Computer predicted %d points.", computerPoints);
        System.out.println();
        System.out.println("Computer rolls the dice...");
        int computerDice1 = random.nextInt(1,6);
        int computerDice2 = random.nextInt(1,6);
        rollTheDice(computerDice1,computerDice2);
        int computerDicePoints = computerDice1 + computerDice2;
        int computerResult = computerDicePoints-Math.abs(computerDicePoints-computerPoints)*2;
        System.out.printf("Result is %d-abs(%d - %d) * 2: %d points", computerDicePoints, computerDicePoints, computerPoints, computerResult);
        System.out.println();
        System.out.println();

        result(userResult, computerResult);

    }

    public static void result(int userResult, int computerResult){
        if (Math.abs(userResult)>Math.abs(computerResult)){
            int pointDif = userResult - computerResult;
            System.out.println("Users win " + Math.abs(pointDif) + " points more.");
            System.out.println("Congratulations!");
        } else if(Math.abs(computerResult)>Math.abs(userResult)){
            int pointDif = computerResult - userResult;
            System.out.println("Computers win " + Math.abs(pointDif) + " points more.");
            System.out.println("Congratulations!");
        } else {
            System.out.println("Draw!");
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
