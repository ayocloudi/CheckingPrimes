import java.util.Scanner;

public class CheckingPrimes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // This while loop will ensure the program keeps prompting the user for options until they decide to exit
        while (true) {
            System.out.println("1. Check if a number is prime");
            System.out.println("2. List prime numbers in a range");
            System.out.print("Choose an option (1 or 2, anything else to exit): ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter a number: ");
                int num = scanner.nextInt();
                if (isPrime(num)) {
                    System.out.println(num + " is a prime number.");
                } else {
                    System.out.println(num + " is not a prime number.");
                }
            } else if (choice == 2) {
                System.out.print("Enter the start of the range: ");
                int start = scanner.nextInt();
                System.out.print("Enter the end of the range: ");
                int end = scanner.nextInt();
                listPrimesInRange(start, end);
            } else {
                break; // Exit the loop if the choice is not 1 or 2
            }
        }
        scanner.close();
    }

    // This method checks if a given number is prime
    //using private because it is only accessible within the same class
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false; // Numbers less than or equal to 1 are not prime numbers
        }
        // Start from 2 and check if 'n' is divisible by any number up to the square root of 'n'
        // This reduces the number of checks we have to make
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; // 'n' is divisible by some other number, so it's not prime
            }
        }
        return true; // 'n' is not divisible by any number other than 1 and itself, so it's prime
    }

    // This method lists all prime numbers in a specified range
    private static void listPrimesInRange(int start, int end) {
        System.out.print("Prime numbers in the range [" + start + ", " + end + "]: ");
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}