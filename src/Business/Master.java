package Business;

import java.util.HashMap;
import java.util.Random;

/**
 * Class created to manage the Master objects.
 */
public class Master extends Trial {
    private final String masterName;
    private final int numCredits;
    private final int chanceToPass;


    /**
     * Constructor for the master
     *
     * @param name:         name.
     * @param type:         type of trial.
     * @param masterName:   name of the master.
     * @param numCredits:   number of credits.
     * @param chanceToPass: chance to pass the trial.
     */
    public Master(String name, int type, String masterName, int numCredits, int chanceToPass) {
        super(name, type);
        this.masterName = masterName;
        this.numCredits = numCredits;
        this.chanceToPass = chanceToPass;
    }

    @Override
    public HashMap<String, String> getDetails() {
        HashMap<String, String> map = new HashMap<>();

        map.put("Trial", super.name);
        map.put("Master", this.masterName);
        map.put("ECTS", String.valueOf(this.numCredits));
        map.put("% chance", String.valueOf(this.chanceToPass));

        return map;
    }

    @Override
    public String[] getArrayDescription() {
        return new String[]{name, masterName, String.valueOf(numCredits), String.valueOf(chanceToPass)};
    }

    /**
     * Method created to execute the master trial.
     */
    @Override
    public String executeTrial(Player p) {
        Random rand = new Random();
        int creditsPassed = 0;
        String message = "\t";

        for (int i = 0; i < this.numCredits; i++) {
            //Check if the random number between zero and 100 is in the chance to pass range.
            if (rand.nextInt(100) < this.chanceToPass) {
                creditsPassed++;
            }
        }

        p.setPi(getPoints(creditsPassed >= this.numCredits / 2, p));
        message = message.concat(p.getName() + " passed " + creditsPassed + "/" + this.numCredits);

        if (creditsPassed >= this.numCredits/2) {
            message = message.concat(" Congrats! ");
        } else {
            message = message.concat(" Sorry... ");
        }
        message = message.concat("PI count: " + p.getPi());

        return message;
    }

    /**
     * Method created to return the points won or lost by the player.
     *
     * @return true for win, false for loose.
     */
    private int getPoints(boolean result, Player p) {
        if (p.getTitle() == 0 && result) {
            p.evolutePlayer();
        } else if (result) {
            return 3;
        } else {
            return -3;
        }

        return 0;
    }
}