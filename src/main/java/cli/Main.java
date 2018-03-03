package cli;

public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: City -j nbDays");
            return;
        }

        int nbDays = 0;
        String  city = args[0];
        if (args.length > 2 && args[1].equals("-j")) {
            nbDays = Integer.parseInt(args[2]);
            if (nbDays > 5) {
                nbDays = 5;
            }
        }

        Cli params = new Cli(city, nbDays);

        System.out.println("City : " + params.getCity() + ", number of days : " + params.getNbDays());
    }
}
