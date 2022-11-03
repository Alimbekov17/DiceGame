import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class DiceGame4level {
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
        int userPenalty = 0;
        int computerPenalty = 0;

        int a = 2;
        for (int i = 0; i < 3; i++) {
            int userResult;
            int computerResult = 0;
            System.out.print("Predict amount of points (2...12): ");
            int usersPoints = scanner.nextInt();
            userPredicted[i] = usersPoints;
            System.out.print("Do you want to cheat? (Y/N): ");
            String cheatWord = scanner.next();
            if (Objects.equals(cheatWord, "Y")){
                int cheatNum = random.nextInt(1,a+1);
                if (cheatNum == 1){
                    System.out.println("You cheated successfully.");
                    double userDice1 = Math.floor((float)usersPoints/2);
                    double userDice2 = Math.ceil((float)usersPoints/2);
                    System.out.println("User rolls the dice...");
                    rollTheDice(userDice1, userDice2);
                    int userDicePoints = (int) (userDice1 + userDice2);
                    userDice[i] = userDicePoints;
                    userResult = userDicePoints-Math.abs(userDicePoints-usersPoints)*2;
                    userResults[i] = userResult;
                    System.out.printf("Result is %d-abs(%d - %d) * 2: %d points",
                            userDicePoints, userDicePoints, usersPoints, userResult);

                } else {
                    System.out.println("Users cheat unsuccessful!");
                    userPenalty += 10;
                    int userDice1 = random.nextInt(1,6);
                    int userDice2 = random.nextInt(1,6);
                    System.out.println("User rolls the dice...");
                    rollTheDice(userDice1, userDice2);
                    int userDicePoints = userDice1 + userDice2;
                    userDice[i] = userDicePoints;
                    userResult = userDicePoints-Math.abs(userDicePoints-usersPoints)*2;
                    userResults[i] = userResult;
                    System.out.printf("Result is %d-abs(%d - %d) * 2: %d points",
                            userDicePoints, userDicePoints, usersPoints, userResult);
                }
                System.out.println();
                System.out.println();
            } else {
                int userDice1 = random.nextInt(1,6);
                int userDice2 = random.nextInt(1,6);
                System.out.println("User rolls the dice...");
                rollTheDice(userDice1, userDice2);
                int userDicePoints = userDice1 + userDice2;
                userDice[i] = userDicePoints;
                userResult = userDicePoints-Math.abs(userDicePoints-usersPoints)*2;
                userResults[i] = userResult;
                System.out.printf("Result is %d-abs(%d - %d) * 2: %d points",
                        userDicePoints, userDicePoints, usersPoints, userResult);
                System.out.println();
                System.out.println();
            }

            int computerPoints = random.nextInt(2,12);
            computerPredicted[i] = computerPoints;
            System.out.printf("Computer predicted %d points.", computerPoints);
            System.out.println();
            int compCheatNum = random.nextInt(1, a+1);
            int compRandomNum = random.nextInt(1,5);
            if (i == 0){
                if (compRandomNum == 1){
                    if (compCheatNum == 1){
                        System.out.println("Computer cheated successfully!");
                        double computerDice1 = Math.floor((float)computerPoints/2);
                        double computerDice2 = Math.ceil((float)computerPoints/2);
                        rollTheDice(computerDice1,computerDice2);
                        int computerDicePoints = (int) (computerDice1 + computerDice2);
                        computerDice[i] = computerDicePoints;
                        computerResult = computerDicePoints-Math.abs(computerDicePoints-computerPoints)*2;
                        computerResults[i] = computerResult;
                        System.out.printf("Result is %d-abs(%d - %d) * 2: %d points",
                                computerDicePoints, computerDicePoints, computerPoints, computerResult);
                    } else {
                        System.out.println("Computers cheat unsuccessful!");
                        computerPenalty += 10;
                        int computerDice1 = random.nextInt(1,6);
                        int computerDice2 = random.nextInt(1,6);
                        System.out.println("Computer rolls the dice...");
                        rollTheDice(computerDice1, computerDice2);
                        int computerDicePoints = computerDice1 + computerDice2;
                        computerDice[i] = computerPoints;
                        computerResult = computerDicePoints-Math.abs(computerDicePoints-computerPoints)*2;
                        computerResults[i] = computerResult;
                        System.out.printf("Result is %d-abs(%d - %d) * 2: %d points",
                                computerDicePoints, computerDicePoints, computerPoints, computerResult);
                    }
                } else {
                    System.out.println("Computer rolls the dice...");
                    int computerDice1 = random.nextInt(1,6);
                    int computerDice2 = random.nextInt(1,6);
                    rollTheDice(computerDice1,computerDice2);
                    int computerDicePoints = computerDice1 + computerDice2;
                    computerDice[i] = computerDicePoints;
                    computerResult = computerDicePoints-Math.abs(computerDicePoints-computerPoints)*2;
                    computerResults[i] = computerResult;
                    System.out.printf("Result is %d-abs(%d - %d) * 2: %d points",
                            computerDicePoints, computerDicePoints, computerPoints, computerResult);
                }
            } else {
                if (userResult-computerResult>5){
                    if (userResult-computerResult>15){
                        if (compRandomNum == 1 || compRandomNum == 2 || compRandomNum == 3){
                            if (compCheatNum == 1){
                                System.out.println("Computer cheated successfully!");
                                double computerDice1 = Math.floor((float)computerPoints/2);
                                double computerDice2 = Math.ceil((float)computerPoints/2);
                                rollTheDice(computerDice1,computerDice2);
                                int computerDicePoints = (int) (computerDice1 + computerDice2);
                                computerDice[i] = computerDicePoints;
                                computerResult = computerDicePoints-Math.abs(computerDicePoints-computerPoints)*2;
                                computerResults[i] = computerResult;
                                System.out.printf("Result is %d-abs(%d - %d) * 2: %d points",
                                        computerDicePoints, computerDicePoints, computerPoints, computerResult);
                            } else {
                                System.out.println("Computers cheat unsuccessful!");
                                computerPenalty += 10;
                                int computerDice1 = random.nextInt(1,6);
                                int computerDice2 = random.nextInt(1,6);
                                System.out.println("Computer rolls the dice...");
                                rollTheDice(computerDice1, computerDice2);
                                int computerDicePoints = computerDice1 + computerDice2;
                                computerDice[i] = computerPoints;
                                computerResult = computerDicePoints-Math.abs(computerDicePoints-computerPoints)*2;
                                computerResults[i] = computerResult;
                                System.out.printf("Result is %d-abs(%d - %d) * 2: %d points",
                                        computerDicePoints, computerDicePoints, computerPoints, computerResult);
                            }
                        } else {
                            System.out.println("Computer rolls the dice...");
                            int computerDice1 = random.nextInt(1,6);
                            int computerDice2 = random.nextInt(1,6);
                            rollTheDice(computerDice1,computerDice2);
                            int computerDicePoints = computerDice1 + computerDice2;
                            computerDice[i] = computerDicePoints;
                            computerResult = computerDicePoints-Math.abs(computerDicePoints-computerPoints)*2;
                            computerResults[i] = computerResult;
                            System.out.printf("Result is %d-abs(%d - %d) * 2: %d points",
                                    computerDicePoints, computerDicePoints, computerPoints, computerResult);
                        }
                    } else {
                        if (compRandomNum == 1 || compRandomNum == 2){
                            if (compCheatNum == 1){
                                System.out.println("Computer cheated successfully!");
                                double computerDice1 = Math.floor((float)computerPoints/2);
                                double computerDice2 = Math.ceil((float)computerPoints/2);
                                rollTheDice(computerDice1,computerDice2);
                                int computerDicePoints = (int) (computerDice1 + computerDice2);
                                computerDice[i] = computerDicePoints;
                                computerResult = computerDicePoints-Math.abs(computerDicePoints-computerPoints)*2;
                                computerResults[i] = computerResult;
                                System.out.printf("Result is %d-abs(%d - %d) * 2: %d points",
                                        computerDicePoints, computerDicePoints, computerPoints, computerResult);
                            } else {
                                System.out.println("Computers cheat unsuccessful!");
                                computerPenalty += 10;
                                int computerDice1 = random.nextInt(1,6);
                                int computerDice2 = random.nextInt(1,6);
                                System.out.println("Computer rolls the dice...");
                                rollTheDice(computerDice1, computerDice2);
                                int computerDicePoints = computerDice1 + computerDice2;
                                computerDice[i] = computerPoints;
                                computerResult = computerDicePoints-Math.abs(computerDicePoints-computerPoints)*2;
                                computerResults[i] = computerResult;
                                System.out.printf("Result is %d-abs(%d - %d) * 2: %d points",
                                        computerDicePoints, computerDicePoints, computerPoints, computerResult);
                            }
                        } else {
                            System.out.println("Computer rolls the dice...");
                            int computerDice1 = random.nextInt(1,6);
                            int computerDice2 = random.nextInt(1,6);
                            rollTheDice(computerDice1,computerDice2);
                            int computerDicePoints = computerDice1 + computerDice2;
                            computerDice[i] = computerDicePoints;
                            computerResult = computerDicePoints-Math.abs(computerDicePoints-computerPoints)*2;
                            computerResults[i] = computerResult;
                            System.out.printf("Result is %d-abs(%d - %d) * 2: %d points",
                                    computerDicePoints, computerDicePoints, computerPoints, computerResult);
                        }
                    }
                } else {
                    if (compRandomNum == 1){
                        if (compCheatNum == 1){
                            System.out.println("Computer cheated successfully!");
                            double computerDice1 = Math.floor((float)computerPoints/2);
                            double computerDice2 = Math.ceil((float)computerPoints/2);
                            rollTheDice(computerDice1,computerDice2);
                            int computerDicePoints = (int) (computerDice1 + computerDice2);
                            computerDice[i] = computerDicePoints;
                            computerResult = computerDicePoints-Math.abs(computerDicePoints-computerPoints)*2;
                            computerResults[i] = computerResult;
                            System.out.printf("Result is %d-abs(%d - %d) * 2: %d points",
                                    computerDicePoints, computerDicePoints, computerPoints, computerResult);
                        } else {
                            System.out.println("Computers cheat unsuccessful!");
                            computerPenalty += 10;
                            int computerDice1 = random.nextInt(1,6);
                            int computerDice2 = random.nextInt(1,6);
                            System.out.println("Computer rolls the dice...");
                            rollTheDice(computerDice1, computerDice2);
                            int computerDicePoints = computerDice1 + computerDice2;
                            computerDice[i] = computerPoints;
                            computerResult = computerDicePoints-Math.abs(computerDicePoints-computerPoints)*2;
                            computerResults[i] = computerResult;
                            System.out.printf("Result is %d-abs(%d - %d) * 2: %d points",
                                    computerDicePoints, computerDicePoints, computerPoints, computerResult);
                        }
                    } else {
                        System.out.println("Computer rolls the dice...");
                        int computerDice1 = random.nextInt(1,6);
                        int computerDice2 = random.nextInt(1,6);
                        rollTheDice(computerDice1,computerDice2);
                        int computerDicePoints = computerDice1 + computerDice2;
                        computerDice[i] = computerDicePoints;
                        computerResult = computerDicePoints-Math.abs(computerDicePoints-computerPoints)*2;
                        computerResults[i] = computerResult;
                        System.out.printf("Result is %d-abs(%d - %d) * 2: %d points",
                                computerDicePoints, computerDicePoints, computerPoints, computerResult);
                    }
                }
            }
            System.out.println();
            System.out.println();


            result(userResult, computerResult);
            a+=2;

        }
        int userFinalPoints = (userResults[0] + userResults[1] + userResults[2]) - userPenalty;
        int computerFinalPoints = (computerResults[0] + computerResults[1] + computerResults[2]) - computerPenalty;
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
            int pointDif = userResult - computerResult;
            System.out.println("--------- Current score ----------");
            System.out.println("User:          " + userResult + " points");
            System.out.println("Computer:      " + computerResult + " points");
            System.out.println();
            System.out.println("User is ahead by " + Math.abs(pointDif) + " points!");
            System.out.println("----------------------------------");
            System.out.println();
        } else if(Math.abs(computerResult)>Math.abs(userResult)){
            int pointDif = computerResult - userResult;
            System.out.println("--------- Current score ----------");
            System.out.println("User:          " + userResult + " points");
            System.out.println("Computer:      " + computerResult + " points");
            System.out.println();
            System.out.println("Computer is ahead by " + Math.abs(pointDif) + " points!");
            System.out.println("----------------------------------");
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
    public static void rollTheDice(double dice1, double dice2){
        printDice((int) dice1);
        printDice((int) dice2);
        System.out.println();
        System.out.println("On the dice fell " + (int)(dice1+dice2) + " points.");

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
