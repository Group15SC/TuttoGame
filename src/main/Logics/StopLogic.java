package main.Logics;

import java.util.ArrayList;

public class StopLogic extends Logic {

    public StopLogic(RollDices dice) {
        super(dice);
    }

    @Override
    public ArrayList<Integer> GetValidDices(){
        ArrayList<Integer> ValidDices = new ArrayList<>();
        return ValidDices;
    }

}