package ficherosyexcepciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class to ask input to user.
 * 
 * @author mfontana
 */
public class InputAsker {
    
    /**
     * Request String
     * 
     * @param message String will be show to user
     * @return the string entered by the user, different from ""
     */
    public static String askString(String message) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = "";
        do {
            try {
                System.out.println(message);
                answer = br.readLine();
                if (answer.equals("")) {
                    System.out.println("You must write something.");
                }
            } catch (IOException ex) {
                System.out.println("Error input / output.");
            } 
        } while (answer.equals(""));
        return answer; 
    }
    
    /**
     * Request String, it can only be optionA or optionB
     *
     * @param message to show a user
     * @param optionA first right option 
     * @param optionB second right option
     * @return String (optionA or optionB)
     */
    public static String askString(String message, String optionA, String optionB) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = "";
        do {
            answer = askString(message);
            if (!answer.equalsIgnoreCase(optionA) && !answer.equalsIgnoreCase(optionB)) {
                System.out.println("Wrong answer! Write " + optionA + " or " + optionB + " please");
            }
        } while (!answer.equalsIgnoreCase(optionA) && !answer.equalsIgnoreCase(optionB));
        return answer;
    }

    /**
     * Ask int to user
     *  
     * @param message
     * @return int
     */
    public static int askInt(String message) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        boolean error;
        do {
            try {
                System.out.println(message);
                num = Integer.parseInt(br.readLine());
                error = false;
            } catch (IOException ex) {
                System.out.println("Error input / output.");
                error = true;
            } catch (NumberFormatException ex) {
                System.out.println("Please, write integer number.");
                error = true;
            }
        } while (error);
        return num;
    }

}
