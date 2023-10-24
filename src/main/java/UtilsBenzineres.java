import java.util.Arrays;

public class UtilsBenzineres {
    // Constants per a les columnes de les matrius
    public static final int ID_BENZINERA = 0;
    public static final int CODI_POSTAL = 1;
    public static final int PROPIETARI = 2;
    public static final int PREU_SP = 0;
    public static final int PREU_DI = 1;
    public static final int ERROR = -1;

    // Funció per registrar una benzinera
    public static int enregistrarBenzinera(String idBenzinera, String codiPostal, String NomPropietari, float preuSP, float preuDiesel, String[][] dadesBenzineres, float[][] preusBenzina) {
        // Cerca si la benzinera ja existeix
        int pos = cercaBenzinera(idBenzinera, dadesBenzineres);
        if (pos != ERROR) {
            return -2; // Id de benzinera existent
        }

        // Cerca una posició buida
        pos = cercaPosBuida(dadesBenzineres);
        if (pos == ERROR) {
            return -3; // Espai insuficient
        }

        // Omplir les dades
        dadesBenzineres[pos][ID_BENZINERA] = idBenzinera;
        dadesBenzineres[pos][CODI_POSTAL] = codiPostal;
        dadesBenzineres[pos][PROPIETARI] = NomPropietari;
        preusBenzina[pos][PREU_SP] = preuSP;
        preusBenzina[pos][PREU_DI] = preuDiesel;

        return pos;
    }

    // Funció per cercar una benzinera per ID
    private static int cercaBenzinera(String idBenzinera, String[][] dBenzineres) {
        for (int i = 0; i < dBenzineres.length; i++) {
            if (dBenzineres[i][ID_BENZINERA].equals(idBenzinera)) {
                return i;
            }
        }
        return ERROR;
    }

    // Funció per cercar una posició buida en la matriu
    private static int cercaPosBuida(String[][] dBenzineres) {
        for (int i = 0; i < dBenzineres.length; i++) {
            if (dBenzineres[i][ID_BENZINERA].equals("")) {
                return i;
            }
        }
        return ERROR;
    }

    // Funció per cercar el preu mínim d'un tipus de combustible
    private static int cercaPreuMinimCombustible(float[][] preusBenzina, int indexCombustible) {
        float minPreu = Float.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < preusBenzina.length; i++) {
            if (preusBenzina[i][indexCombustible] < minPreu) {
                minPreu = preusBenzina[i][indexCombustible];
                index = i;
            }
        }
        return index;
    }

    // Funció per copiar una matriu de floats
    public static float[][] copiaTaulaFloat(float[][] taulaOriginal) {
        float[][] copia = new float[taulaOriginal.length][];
        for (int i = 0; i < taulaOriginal.length; i++) {
            copia[i] = Arrays.copyOf(taulaOriginal[i], taulaOriginal[i].length);
        }
        return copia;
    }

    // Funció per copiar una matriu de strings
    public static String[][] copiaTaulaString(String[][] taulaOriginal) {
        String[][] copia = new String[taulaOriginal.length][];
        for (int i = 0; i < taulaOriginal.length; i++) {
            copia[i] = Arrays.copyOf(taulaOriginal[i], taulaOriginal[i].length);
        }
        return copia;
    }

    // Funció per obtenir els índexs de les benzineraes ordenats per preu d'un tipus de combustible
    public static int[] indexBenzineresPerPreuCombustible(float[][] preusBenzina, int indexCombustible) {
        int[] indexs = new int[preusBenzina.length];
        for (int i = 0; i < preusBenzina.length; i++) {
            indexs[i] = i;
        }

        // Ordenar els índexs segons el preu
        for (int i = 0; i < indexs.length - 1; i++) {
            for (int j = i + 1; j < indexs.length; j++) {
                if (preusBenzina[indexs[i]][indexCombustible] > preusBenzina[indexs[j]][indexCombustible]) {
                    int temp = indexs[i];
                    indexs[i] = indexs[j];
                    indexs[j] = temp;
                }
            }
        }
        return indexs;
    }
}
