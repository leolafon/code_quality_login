package cli;

public class Main {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Missing parameters");
            return;
        }

        System.out.println("Hello World");
    }
}
