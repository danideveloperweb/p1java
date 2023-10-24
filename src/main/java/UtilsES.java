import java.util.Scanner;

public class UtilsES {
    // Constants per a missatges d'error i separadors
    public static final String MISSATGE_ERROR_NOESPAI = "Espai insuficient";
    public static final String MISSATGE_ERROR_COLISIO = "Id benzinera existent:";
    private static final String MISSATGE_SEPARADOR = "----------------------------------------";
    public static final String MISSATGE_ERROR_HEADER = "ERROR";

    // Funció per mostrar el menú principal
    public static void mostrarMenu() {
        System.out.println(MISSATGE_SEPARADOR);
        System.out.println("GESTIO BENZINERES");
        System.out.println(MISSATGE_SEPARADOR);
        System.out.println("1. Registrar benzinera");
        System.out.println("2. Mostrar benzineras");
        System.out.println("3. Salir");
        System.out.print("Escull una opció: ");
    }

    // Funció per mostrar missatges d'error
    public static void mostrarError(String textError) {
        System.out.println(MISSATGE_ERROR_HEADER);
        System.out.println(MISSATGE_SEPARADOR);
        System.out.println(textError);
        System.out.println(MISSATGE_SEPARADOR);
    }

    // Funció per mostrar un missatge quan s'ha inserit correctament una benzinera
    public static void mostrarIngresOK(String idBenzinera, int pos) {
        System.out.println("Dades benzinera correctament introduida " + idBenzinera + " a 1a posició " + pos);
    }

    // Funció per mostrar el llistat de benzineraes i preus
    public static void mostrarLlistatBenzineres(String[][] dadesBenzineres, float[][] preusBenzina) {
        System.out.println(MISSATGE_SEPARADOR);
        System.out.println("LLISTAT DE BENZINERES");
        System.out.println(MISSATGE_SEPARADOR);
        System.out.println("IDBENZINERA CODIPOSTAL NOM PROPIETARI PREUS/P PREU DIESEL");
        System.out.println(MISSATGE_SEPARADOR);
        for (int i = 0; i < dadesBenzineres.length; i++) {
            if (!dadesBenzineres[i][0].equals("")) {
                System.out.printf("%s %s %s %.2f %.2f%n",
                        dadesBenzineres[i][0], dadesBenzineres[i][1], dadesBenzineres[i][2],
                        preusBenzina[i][0], preusBenzina[i][1]);
            }
        }
    }

    // Funció per demanar un String a l'usuari
    public static String demanarString(String missatge, String missatgeError) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(missatge);
        String input = scanner.nextLine();
        while (input.isEmpty()) {
            System.out.println(missatgeError);
            input = scanner.nextLine();
        }
        return input;
    }

    // Funció per demanar un float a l'usuari
    public static float demanarFloat(String missatge, String missatgeError) {
        Scanner scanner = new Scanner(System.in);
        float valor = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println(missatge);
                valor = Float.parseFloat(scanner.nextLine().replace(",", "."));
                valid = true;
            } catch (NumberFormatException e) {
                mostrarError("No s'ha introduit un número de coma flotant");
            }
        }
        return valor;
    }

    // Funció per demanar un enter a l'usuari
    public static int demanarEnter(String missatge, String missatgeError) {
        Scanner scanner = new Scanner(System.in);
        int valor = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println(missatge);
                valor = Integer.parseInt(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                mostrarError("No s'ha introduit un número enter");
            }
        }
        return valor;
    }
}
