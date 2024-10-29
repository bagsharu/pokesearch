package bagsharu.pokesearch.main;

public class MainMenu {

    private static String entryText = "--------------------------------\n"+
                                "Welcome to PokéSearch:\n"+
                                "What operation would you like to do?" +
                                "\n1- Search and Pokemon's Info" +
                                "\n2- List all searched Pokemon" +
                                "\n0- Leave" +
                               "\n--------------------------------";

    public static void printMenu() {

        System.out.println(entryText);
    }


}
