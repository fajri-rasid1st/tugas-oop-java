package tugas3;

public class Main {
    private static java.util.Scanner sc = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        Player player1 = new Player("Helcurt", "Assasin", 25, 11000);
        Player player2 = new Player("Bane", "Fighter", 20, 13000);

        System.out.println("\nWelcome to mobile legend\n");
        System.out.print("Player 1 Status");
        player1.showStatus();
        System.out.print("\nPlayer 2 Status");
        player2.showStatus();

        int[] scores = new int[2];

        System.out.printf("\n%s's Score = %d || %s's Score = %d\n", player1.getName(), scores[0], player2.getName(),
                scores[1]);
        while (true) {
            System.out.println("\nPlayer 1 choose what you want to do :");
            mainMenu(player1);
            System.out.println("\nPlayer 2 choose what you want to do :");
            mainMenu(player2);
            System.out.println("\nType \"attack\" to fight");
            System.out.print("> ");
            String attack = sc.next();
            attacking(attack, player1, player2);
            System.out.print("\n");
            player1.setIndex(0);
            player2.setIndex(0);
            if (player1.getHp() <= 0 || player2.getHp() <= 0) {
                if (player1.getHp() <= 0 && player2.getHp() <= 0) {
                    System.out.println("Draw");
                } else if (player1.getHp() <= 0) {
                    scores[1]++;
                } else if (player2.getHp() <= 0) {
                    scores[0]++;
                }
                System.out.printf("\n%s's Score = %d || %s's Score = %d\n", player1.getName(), scores[0],
                        player2.getName(), scores[1]);
                System.out.println("\nContinue The Game ? (Yes / No)");
                System.out.print("> ");
                String stillplay = sc.next();
                if (stillplay.equalsIgnoreCase("yes")) {
                    player1 = new Player("Helcurt", "Assasin", 25, 11000);
                    player2 = new Player("Bane", "Fighter", 20, 13000);
                } else {
                    break;
                }
            }
        }
    }

    private static void mainMenu(Player player) {
        while (true) {
            System.out.println("\n1. Show status");
            System.out.println("2. Buy item");
            System.out.println("3. Show items");
            System.out.println("4. Regen");
            System.out.println("0. Back/Exit");
            System.out.println("*note : if an item is not used, it will automatically disappear after attacking");
            System.out.print("> ");
            int i = sc.nextInt();

            if (i == 0) {
                break;
            }
            if (i == 1) {
                player.showStatus();
            }
            if (i == 2) {
                player.buy();
            }
            if (i == 3) {
                player.showItems();
            }
            if (i == 4) {
                player.healing(player.getHp());
            }
        }
    }

    private static void attacking(String attack, Player p1, Player p2) {
        while (!attack.equalsIgnoreCase("attack")) {
            System.out.println("Type \"attack\" to fight");
            System.out.print("> ");
            String s = sc.next();
            if (s.equalsIgnoreCase("attack")) {
                break;
            }
        }
        p1.attack(p2);
        p2.attack(p1);
    }
}