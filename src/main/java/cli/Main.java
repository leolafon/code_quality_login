package cli;

public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: City -j nombreJours");
            return;
        }

        int j = 0;
        String  city = args[0];
        if (args.length > 2 && args[1].equals("-j")) {
            j = Integer.parseInt(args[2]);
            if (j > 5) {
                j = 5;
            }
        }

        System.out.println("Ville : " + city + ", nb jours : " + j);

    }
}
