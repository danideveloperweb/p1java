import java.util.Arrays;

public class AppEAC5P1 {

    public static final int NUM_BENZINERES = 15;
    public static final int[] INDEX_BENZINERES_ORDENADES_SP = {13,11,9,12,8,4,5,10,3,2,0,7,1,6,14};
    public static final int[] INDEX_BENZINERES_ORDENADES_DI = {8,14,6,5,10,12,1,2,0,7,11,13,3,4,9};

    public static void main(String[] args) {
        AppEAC5P1 prg = new AppEAC5P1();
        prg.inici();
    }

    private void inici() {

        String[][] dadesBenzineres = new String[NUM_BENZINERES][3];
        for (int i=0;i<NUM_BENZINERES;i++) {
            dadesBenzineres[i][UtilsBenzineres.ID_BENZINERA]="";
            dadesBenzineres[i][UtilsBenzineres.CODI_POSTAL]="";
            dadesBenzineres[i][UtilsBenzineres.PROPIETARI]="";
            }

        float[][] preusBenzina = new float[NUM_BENZINERES][2];
        for (int i=0;i<NUM_BENZINERES;i++) {
         	preusBenzina[i][UtilsBenzineres.PREU_SP]=0f;
        	preusBenzina[i][UtilsBenzineres.PREU_DI]=0f;
            }

        System.out.println("\n\tPrimer, fem servir les funcions ja generades a l'EAC anterior\n");

        int res;
        res = UtilsBenzineres.enregistrarBenzinera("B0001", "08800", "GALP", 1.56f, 1.44f, dadesBenzineres, preusBenzina);
        if (res>=0) UtilsES.mostrarIngresOK("B0001", res);
        res = UtilsBenzineres.enregistrarBenzinera("B0002", "08800", "REPSOL", 1.58f, 1.33f, dadesBenzineres, preusBenzina);
        res = UtilsBenzineres.enregistrarBenzinera("B0003", "08800", "CEPSA", 1.55f, 1.42f, dadesBenzineres, preusBenzina);
        res = UtilsBenzineres.enregistrarBenzinera("B0004", "08800", "BP", 1.54f, 1.48f, dadesBenzineres, preusBenzina);
        res = UtilsBenzineres.enregistrarBenzinera("B0005", "08800", "AVIA", 1.40f, 1.73f, dadesBenzineres, preusBenzina);
        res = UtilsBenzineres.enregistrarBenzinera("B0006", "08800", "PRETROCAT", 1.43f, 1.23f, dadesBenzineres, preusBenzina);
        res = UtilsBenzineres.enregistrarBenzinera("B0007", "08801", "PETRONOR", 1.60f, 1.14f, dadesBenzineres, preusBenzina);
        res = UtilsBenzineres.enregistrarBenzinera("B0008", "08800", "GALP", 1.57f, 1.45f, dadesBenzineres, preusBenzina);
        res = UtilsBenzineres.enregistrarBenzinera("B0009", "08801", "REPSOL", 1.37f, 1.12f, dadesBenzineres, preusBenzina);
        res = UtilsBenzineres.enregistrarBenzinera("B0010", "08801", "CEPSA", 1.24f, 1.76f, dadesBenzineres, preusBenzina);
        res = UtilsBenzineres.enregistrarBenzinera("B0011", "08801", "BP", 1.45f, 1.24f, dadesBenzineres, preusBenzina);
        res = UtilsBenzineres.enregistrarBenzinera("B0012", "08801", "AVIA", 1.12f, 1.46f, dadesBenzineres, preusBenzina);
        res = UtilsBenzineres.enregistrarBenzinera("B0013", "08801", "PRETROCAT", 1.32f, 1.31f, dadesBenzineres, preusBenzina);
        res = UtilsBenzineres.enregistrarBenzinera("B0005", "08802", "GALP", 1.76f, 1.12f, dadesBenzineres, preusBenzina);
        if (res == -2) UtilsES.mostrarError(UtilsES.MISSATGE_ERROR_COLISIO + " B0005");
        res = UtilsBenzineres.enregistrarBenzinera("B0014", "08801", "PETRONOR", 1.11f, 1.47f, dadesBenzineres, preusBenzina);
        res = UtilsBenzineres.enregistrarBenzinera("B0015", "08802", "GALP", 1.78f, 1.13f, dadesBenzineres, preusBenzina);
        res = UtilsBenzineres.enregistrarBenzinera("B0016", "08802", "GALP", 1.76f, 1.12f, dadesBenzineres, preusBenzina);
        if (res == -3) UtilsES.mostrarError(UtilsES.MISSATGE_ERROR_NOESPAI);

        System.out.println("\n\tA continuació imprimim la taula de benzineres\n");
        UtilsES.mostrarLlistatBenzineres(dadesBenzineres, preusBenzina);

        System.out.println("\n\tA continuació provem el sistema d'ordenació per preus\n");
        int[] indexPreusDieselOrdenats = UtilsBenzineres.indexBenzineresPerPreuCombustible(preusBenzina,UtilsBenzineres.PREU_DI);
        if (Arrays.equals(indexPreusDieselOrdenats,INDEX_BENZINERES_ORDENADES_DI)) System.out.println("Benzineres ordenades correctament pel preu Diesel");
        else System.out.println("Benzineres NO ordenades correctament per Diesel");

        int[] indexPreusSPOrdenats = UtilsBenzineres.indexBenzineresPerPreuCombustible(preusBenzina,UtilsBenzineres.PREU_SP);
        if (Arrays.equals(indexPreusSPOrdenats,INDEX_BENZINERES_ORDENADES_SP)) System.out.println("Benzineres ordenades correctament pel preu Benzina sense plom");
        else System.out.println("Benzineres NO ordenades correctament per Benzina sense plom");


    }
}
