package Projeto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Funcoes {

    public static HashMap<Double, Integer> valores = new HashMap<>();

    public static void ordenar(double[] array) {
        Arrays.sort(array);
    }

    public static double Media(double[] array) {
        return SomaElementos(array) / array.length;
    }

    public static double SomaElementos(double[] array) {
        double soma = 0;
        for (int aux = 0; aux < array.length; aux++) {
            soma += array[aux];
        }
        return soma;
    }

    public static double Mediana(double[] array) {
        Funcoes.ordenar(array);
        int parouimpar = array.length % 2;
        if (parouimpar == 1) {
            return array[((array.length + 1) / 2) - 1];
        } else {
            int medianapar = array.length / 2;
            return ((array[medianapar] + array[medianapar - 1]) / 2);
        }
    }

    public static double Variancia(double[] array) {
        double var = 0;
        double aux2 = 0;
        double aux1 = 1 / Double.valueOf(array.length - 1);
        for (int i = 0; i < array.length; i++) {
            aux2 += Math.pow((array[i] - Media(array)), 2);
        }
        var = aux2*aux1;
        return var;
    }

    public static double DP(double[] array) {
        double dp = 0;
        dp = Math.sqrt(Variancia(array));
        return dp;
    }

    public static double frequencias(double valor) {
        double x = 0;
        for (Map.Entry<Double, Integer> entry : valores.entrySet()) {
            if (valor == entry.getKey()) {
                x = entry.getValue();
            }
        }

        return x;
    }
    
    static int V = 0;

    public static double dados(int k) {

        double x = 0;
        for (Map.Entry<Double, Integer> entry : valores.entrySet()) {
            if(k == V){
                x = entry.getKey();
                V++;
            }
            V++;
        }
        V = 0;

        return x;
    }

    public static double Moda(double[] array) {

        int aux1 = 0;
        double x = 0;
        double aux3 = 0;
        double moda = 0;

        carregarMapa(array);

        for (Map.Entry<Double, Integer> entry : valores.entrySet()) {
            aux1 = entry.getValue();
            aux3 = entry.getKey();
            if (aux1 > x) {
                x = aux1;
                moda = aux3;
            }
        }
        /*if (moda == 0) {
            return (Double.valueOf("Arranjo Multimodal").doubleValue());
        } else {
            return moda;
        }*/
        return moda;
    }

    public static double CV(double[] array) {
        double cv = 0;
        cv = (DP(array) / Media(array))*100;
        return cv;
    }

    public static HashMap<Double, Integer> carregarMapa(double[] array) {
        for (int i = 0; i < array.length; i++) { //carregar hashmap
            Double n = array[i];
            valores.put(n, (valores.get(n) == null ? 0 : valores.get(n)) + 1);
        }
        return valores;
    }

}
