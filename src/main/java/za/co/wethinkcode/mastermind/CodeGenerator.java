package za.co.wethinkcode.mastermind;

import java.util.ArrayList;
import java.util.Random;

public class CodeGenerator {
    private final Random random;

    public CodeGenerator(){
        this.random = new Random();
    }

    public CodeGenerator(Random random){
        this.random = random;
    }

    /**
     * Generates a random 4 digit code, using this.random, where each digit is in the range 1 to 8 only.
     * Duplicated digits are allowed.
     * @return the generated 4-digit code
     */
    public String generateCode(){
        //TODO: implement using this.random

        ArrayList<String> genCode = new ArrayList<>();

        while(genCode.size() < 4){
            
            String stringValues = String.valueOf(1 + random.nextInt(8));
            if(stringValues.equalsIgnoreCase("0")){
                continue;
            }
            genCode.add(stringValues);
        }
        System.out.print("4-digit Code has been set. Digits in range 1 to 8. You have 12 turns to break it.\n");
        return String.join("", genCode);
    }
}
