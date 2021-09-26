package Main;

import java.util.ArrayList;

public class WinMechanics {

    int highestWinningCombination;
    int highestLevel;
    Player highestPlayer;
    int lowestWinningCombination;
    int lowestLevel;
    Player lowestPlayer;

    public int getHighestWinningCombination() {
        return highestWinningCombination;
    }

    public void setHighestWinningCombination(int highestWinningCombination) {
        this.highestWinningCombination = highestWinningCombination;
    }

    public int getHighestLevel() {
        return highestLevel;
    }

    public void setHighestLevel(int highestLevel) {
        this.highestLevel = highestLevel;
    }

    public Player getHighestPlayer() {
        return highestPlayer;
    }

    public void setHighestPlayer(Player highestPlayer) {
        this.highestPlayer = highestPlayer;
    }

    public int getLowestWinningCombination() {
        return lowestWinningCombination;
    }

    public void setLowestWinningCombination(int lowestWinningCombination) {
        this.lowestWinningCombination = lowestWinningCombination;
    }

    public int getLowestLevel() {
        return lowestLevel;
    }

    public void setLowestLevel(int lowestLevel) {
        this.lowestLevel = lowestLevel;
    }

    public Player getLowestPlayer() {
        return lowestPlayer;
    }

    public void setLowestPlayer(Player lowestPlayer) {
        this.lowestPlayer = lowestPlayer;
    }

    public  WinMechanics(){
        setHighestWinningCombination(0);
        setHighestLevel(0);
        setLowestWinningCombination(4);
        setLowestLevel(665);
    }

    public void checkWon(ArrayList<Player> players){
        for(Player p : players) {
            if(p.getWinningCombination() > getHighestWinningCombination()) {
                setHighestPlayer(p);
                setHighestWinningCombination(p.getWinningCombination());
                setHighestLevel(p.getLevel());
            } else if (p.getWinningCombination() == getHighestWinningCombination() && p.getLevel() > getHighestLevel()){
                setHighestPlayer(p);
                setHighestLevel(p.getLevel());
            }
            if(p.getWinningCombination() < getLowestWinningCombination()) {
                setLowestPlayer(p);
                setLowestWinningCombination(p.getWinningCombination());
                setLowestLevel(p.getLevel());
            } else if (p.getWinningCombination() == getLowestWinningCombination() && p.getLevel() < getLowestLevel()){
                setLowestPlayer(p);
                setLowestLevel(p.getLevel());
            }
        }
    }
}
