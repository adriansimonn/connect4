import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board b = new Board();
        Scanner s = new Scanner(System.in);

        System.out.println("                                      -===  Connect 4  ===-                                      ");
        System.out.println("    -= There are 7 columns to choose from (1 being the leftmost and 7 being the rightmost) -=    ");
        System.out.println("                     -= One player plays as X, while the other plays as O =-                     ");
        System.out.println("-= The first player to connect 4 of their pieces horizontally, vertically, or diagonally wins! =-");
        System.out.println("                               -= Press ENTER to begin the game! =-                              ");

        String init = s.nextLine();
        b.printBoard();

        while (b.scanBoard()) {
            b.addX(s.nextInt() - 1);
            b.printBoard();

            if (!b.scanBoard()) {
                break;
            }

            b.addO(s.nextInt() - 1);
            b.printBoard();
        }
    }
}