package com.company;

import java.util.*;

/**
 * Created by swathi on 6/25/16.
 */
public class HangmanGame {
    private static final List<String> WORD_DICTIONIARY = new ArrayList<>(
            Arrays.asList("beach", "panorama", "malayalam", "india", "rainbow"));
    private static final char INVALID_INPUT = '$';
    private String curWord;
    private boolean[] isGuessValid;
    private int cluesLeft;
    private List<String> bodyParts;

    public HangmanGame() {
        Random random = new Random();
        int randomIdx = random.nextInt(WORD_DICTIONIARY.size());
        curWord = WORD_DICTIONIARY.get(randomIdx);
        isGuessValid = new boolean[curWord.length()];
        cluesLeft = 6;
        bodyParts = new ArrayList<>(Arrays.asList("head", "torso", "left hand", "right hand", "left leg", "right leg"));
        printInit();
    }

    public void playAGame() {
        while (cluesLeft != 0) {
            char currentGuess = getUserGuess();
            boolean isGuessValid = isGuessValid(currentGuess);
            if (!isGuessValid) {
                cluesLeft--;
                showHangMan();
                printGuess(currentGuess);
            } else {
                printGuess(currentGuess);
                boolean isGameOver = isGameOver();
                if (isGameOver) {
                    declareVictory();
                    break;
                }
            }
        }

        if (cluesLeft == 0) {
            declareLoss();
        }
    }

    private void printInit() {
        System.out.println("Welcome to Hangman!");
        System.out.println("Your Word:");
        for (int i = 0; i < isGuessValid.length; i++) {
            System.out.print("_" + "\t");
        }
        System.out.println();
        System.out.println("You have 6 turns to guess the word");
    }

    private char getUserGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your current guess:");
        String guess = scanner.nextLine();
        if (guess.length() != 1) {
            return INVALID_INPUT;
        }
        return guess.charAt(0);
    }

    private boolean isGuessValid(char guessedChar) {
        if (curWord.contains(String.valueOf(guessedChar))) {
            return true;
        }

        return false;
    }

    private void printGuess(char guessedChar) {
        for (int i = 0; i < curWord.length(); i++) {
            if (curWord.charAt(i) == guessedChar || isGuessValid[i]) {
                isGuessValid[i] = true;
                System.out.print(curWord.charAt(i) + "\t");
            } else {
                System.out.print("_" + "\t");
            }
        }
        System.out.println();
    }

    private boolean isGameOver() {
        for (int i = 0; i < isGuessValid.length; i++) {
            if (!isGuessValid[i]) {
                return false;
            }
        }

        return true;
    }

    private void declareLoss() {
        System.out.println("Sorry you lost!! :(");
    }

    private void declareVictory() {
        System.out.println("Good Job!! You saved the HangMan");
    }

    private void showHangMan() {
        String bodyPart = bodyParts.remove(0);
        System.out.println("The " + bodyPart + " is hung");
        System.out.println("You have " + cluesLeft + " turns left");
    }

}
