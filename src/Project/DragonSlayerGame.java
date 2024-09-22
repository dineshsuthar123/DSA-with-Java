package Project;

import java.util.Random;
import java.util.Scanner;

public class DragonSlayerGame {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static int playerHealth = 100;
    static int dragonHealth = 150;
    static int playerAttackPower = 25;
    static int dragonAttackPower = 30;
    static int numHealthPotions = 3;
    static int healthPotionHealAmount = 30;

    public static void main(String[] args) {
        System.out.println("Welcome to Dragon Slayer!");
        System.out.println("You are a brave knight on a quest to slay the evil dragon.");
        System.out.println("Your journey begins now...\n");

        while (true) {
            System.out.println("-----------------------------------");
            System.out.println("Your Health: " + playerHealth);
            System.out.println("Dragon's Health: " + dragonHealth);
            System.out.println("Health Potions: " + numHealthPotions);
            System.out.println("-----------------------------------");

            System.out.println("What would you like to do?");
            System.out.println("1. Attack the dragon");
            System.out.println("2. Drink a health potion");
            System.out.println("3. Run away");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                attackDragon();
            } else if (input.equals("2")) {
                drinkHealthPotion();
            } else if (input.equals("3")) {
                runAway();
                break;
            } else {
                System.out.println("Invalid command, please choose again.");
            }

            if (dragonHealth <= 0) {
                System.out.println("Congratulations! You have slain the dragon!");
                break;
            } else if (playerHealth <= 0) {
                System.out.println("You have been defeated by the dragon...");
                break;
            }
        }

        System.out.println("Game Over");
    }

    public static void attackDragon() {
        int damageDealt = random.nextInt(playerAttackPower);
        int damageTaken = random.nextInt(dragonAttackPower);

        dragonHealth -= damageDealt;
        playerHealth -= damageTaken;

        System.out.println("You strike the dragon for " + damageDealt + " damage.");
        System.out.println("The dragon retaliates and hits you for " + damageTaken + " damage.");
    }

    public static void drinkHealthPotion() {
        if (numHealthPotions > 0) {
            playerHealth += healthPotionHealAmount;
            numHealthPotions--;
            System.out.println("You drink a health potion, healing yourself for " + healthPotionHealAmount + ".");
            System.out.println("You now have " + playerHealth + " HP.");
            System.out.println("You have " + numHealthPotions + " health potions left.");
        } else {
            System.out.println("You have no health potions left!");
        }
    }

    public static void runAway() {
        System.out.println("You run away from the dragon, saving your life.");
        System.out.println("Live to fight another day!");
    }
}

