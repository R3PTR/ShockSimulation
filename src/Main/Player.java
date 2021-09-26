package Main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Player {
    int dice0;
    int dice1;
    int dice2;
    boolean dice0PutOut;
    boolean dice1PutOut;
    boolean dice2PutOut;
    int maxRollsLeft;
    Random random;
    int winningCombination;
    int level;

    public Player() {
        random = new Random();
        setDice0(rollDice());
        setDice1(rollDice());
        setDice2(rollDice());
        setMaxRollsLeft(2);
        checkOnes();
        checkDoubleSix();
    }

    private void checkDoubleSix() {
        int amount = countSixes();
        if (amount == 2){
            if(!isDice0PutOut()){
                setDice0(1);
                setDice0PutOut(true);
            } else if (!isDice1PutOut()){
                setDice1(1);
                setDice1PutOut(true);
            }
        }
        if (amount == 3) {
            setDice0(1);
            setDice0PutOut(true);
            setDice1(1);
            setDice1PutOut(true);
        }
    }

    private int countSixes() {
            int amount = 0;
            if(getDice0() == 6){
                amount++;
            }
            if(getDice1() == 6){
                amount++;
            }
            if(getDice2() == 6){
                amount++;
            }
            return amount;
    }

    private void checkOnes() {
        setDice0PutOut(getDice0()==1);
        setDice1PutOut(getDice1()==1);
        setDice2PutOut(getDice2()==1);
    }

    private int rollDice(){
        return random.nextInt(6)+1;
    }

    public void makeTurn(){
        while(getMaxRollsLeft() > 0){
            //System.out.println(getMaxRollsLeft());
            rollDices();
            checkOnes();
            checkDoubleSix();
            setMaxRollsLeft(getMaxRollsLeft()-1);
        }
        calculateOutcome();
    }

    public int getWinningCombination() {
        return winningCombination;
    }

    public void setWinningCombination(int winningCombination) {
        this.winningCombination = winningCombination;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private void calculateOutcome() {
        if (countOnes()==3){
            setWinningCombination(WinningCombinations.SHOCKOUT);
            setLevel(Level.ONE);
        } else if (getDice0() == getDice1() && getDice1() == getDice2()){
            setWinningCombination(WinningCombinations.GENERAL);
            setLevel(getDice0());
        } else if (countOnes() == 2){
            setWinningCombination(WinningCombinations.SHOCK);
            setLevel(getDice0() + getDice1() + getDice2() - 2);
        } else {
            Integer[] dices = {getDice0(), getDice1(), getDice2()};
            Arrays.sort(dices);
            if (getDice0()+1 == getDice1() && getDice1()+1 == getDice2()){
                setWinningCombination(WinningCombinations.STRAIGHT);
                setLevel(dices[0]);
            } else {
                Arrays.sort(dices, Collections.reverseOrder());
                setWinningCombination(WinningCombinations.SCRAP);
                setLevel(Integer.parseInt("" + dices[0] + dices[1] + dices[2]));
            }
        }
    }

    private int countOnes(){
        int amount = 0;
        if (isDice0PutOut()){
            amount++;
        }
        if (isDice1PutOut()){
            amount++;
        }
        if (isDice2PutOut()){
            amount++;
        }
        return amount;
    }


    public void rollDices() {
        if (!isDice0PutOut()){
            setDice0(rollDice());
        }
        if (!isDice1PutOut()){
            setDice1(rollDice());
        }
        if (!isDice2PutOut()){
            setDice2(rollDice());
        }
    }

    public int getMaxRollsLeft() {
        return maxRollsLeft;
    }

    public void setMaxRollsLeft(int maxRollsLeft) {
        this.maxRollsLeft = maxRollsLeft;
    }

    public boolean isDice0PutOut() {
        return dice0PutOut;
    }

    public void setDice0PutOut(boolean dice0PutOut) {
        this.dice0PutOut = dice0PutOut;
    }

    public boolean isDice1PutOut() {
        return dice1PutOut;
    }

    public void setDice1PutOut(boolean dice1PutOut) {
        this.dice1PutOut = dice1PutOut;
    }

    public boolean isDice2PutOut() {
        return dice2PutOut;
    }

    public void setDice2PutOut(boolean dice2PutOut) {
        this.dice2PutOut = dice2PutOut;
    }

    public int getDice0() {
        return dice0;
    }

    public void setDice0(int dice0) {
        this.dice0 = dice0;
    }

    public int getDice1() {
        return dice1;
    }

    public void setDice1(int dice1) {
        this.dice1 = dice1;
    }

    public int getDice2() {
        return dice2;
    }

    public void setDice2(int dice2) {
        this.dice2 = dice2;
    }
}
