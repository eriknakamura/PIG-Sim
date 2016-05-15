import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by erikn on 5/14/16.
 */
public class pigSim {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.println("Simulator for risk game, and algorithms creation tool. Made by Erik Nakamura");
        System.out.println("When 'ok' is entered the machine will compare the following two algorithms: \n Algorithm one: Allow dice to roll until there is a sum of six, then skip. \n Algorithm two: Allow dice to roll until a four points value is rolled.");
        String okDemoSim = scan.nextLine();
        boolean startDemoSim = false;
        if(okDemoSim.equalsIgnoreCase("ok")){
            System.out.println("How many trials of each?");
            String trialAmount = scan.nextLine();
            int trialAmountInt = Integer.parseInt(trialAmount);
            System.out.println("How many turns of each trial?");
            String turnAmount = scan.nextLine();
            int turnAmountInt = Integer.parseInt(turnAmount);
            ArrayList<Integer> trialResults = new ArrayList<>();
            trialResults = demoTrials(trialAmountInt, turnAmountInt);
            System.out.println("Total points for " + trialAmount + " trials of Algorithm one: " + trialResults.get(0));
            System.out.println("Total points for " + trialAmount + " trials of Algorithm two: " + trialResults.get(1));


        }
    }

    public static ArrayList demoTrials(int trialNum, int turnNum){
        ArrayList<Integer> scores = new ArrayList<>();
        int numberOfTrials = trialNum;
        int numberOfTurns = turnNum;
        int totalPointsOne = 0;
        int totalPintsTwo = 0;
        for(int i=0;i<numberOfTrials; i++){
            totalPointsOne += demoAlgoOne(turnNum);
            totalPintsTwo += demoAlgoTwo(turnNum);
        }
        scores.add(totalPointsOne);
        scores.add(totalPintsTwo);
        return scores;
    }

    public static int rollDice(){
        int diceResult =(int)(Math.random()*6+1);
        int result = 0;
        if(diceResult == 1 || diceResult == 2){
            result = 0;
        }
        else if(diceResult == 3 || diceResult == 4){
            result = 1;
        }
        else if(diceResult == 5 || diceResult == 6){
            result = 4;
        }
        return result;
    }

    public static int demoAlgoOne(int turnCount){
        int turns = turnCount;
        int totPoints = 0;
        for(int i=0;i<turns;i++){
            int points = 0;
           do{
               int result = rollDice();
               if(result != 0){
                   points += result;
               }
               else{
                   points = 0;
                   break;
               }
           }while(points<7);
            totPoints += points;
        }
        return totPoints;
    }

    public static int demoAlgoTwo(int turnCount){
        int turns = turnCount;
        int totPoints = 0;
        for(int i=0;i<turns;i++){
            int points = 0;
            do{
                int result = rollDice();
                if(result != 0 && result != 4){
                    points += result;
                }
                else if(result == 0){
                    points = 0;
                    break;
                }
                else if(result == 4){
                    points += result;
                    break;
                }
            }while(true);
            totPoints += points;
        }
        return totPoints;
    }
