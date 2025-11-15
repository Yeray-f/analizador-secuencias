import java.util.Scanner;

public class Parcial{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numero;

        do {
            System.out.print("Ingrese para N valores (5 a 50): ");
            numero = scanner.nextInt();
        } while (numero < 5 || numero > 50);

        int[] arreglo = leerArreglo(numero);

        System.out.println("------ RESULTADOS ------");

        System.out.println("El arreglo ingresado es:");
        System.out.println(java.util.Arrays.toString(arreglo));

        System.out.println("La cantidad de números primos es: " + contarPrimos(arreglo));

        int max = maximo(arreglo);
        System.out.println("Máximo del arreglo es: " + max);

        int[] indices = indicesDeMaximo(arreglo);
        System.out.println("Los indices del máximo son:");
        System.out.println(java.util.Arrays.toString(indices));

        System.out.println("¿Es capicúa?: " + esCapicua(arreglo));
    }

    public static int[] leerArreglo(int n) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[n];

        System.out.println("Ingrese los " + n + " números, seguidos dejando un espacio (1 2 3 etc):");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        return a;
    }

    public static boolean esPrimo(int x) {
        if (x <= 1) return false;

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int contarPrimos(int[] a) {
        int cont = 0;
        for (int i = 0; i < a.length; i++) {
            if (esPrimo(a[i])) {
                cont++;
            }
        }
        return cont;
    }

    public static int maximo(int[] a) {
        int max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static int[] indicesDeMaximo(int[] a) {
        int max = maximo(a);

        int conteo = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == max) {
                conteo++;
            }
        }

        int[] indices = new int[conteo];

        int pos = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == max) {
                indices[pos] = i;
                pos++;
            }
        }

        return indices;
    }

    public static boolean esCapicua(int[] a) {
        int i = 0;
        int j = a.length - 1;

        while (i < j) {
            if (a[i] != a[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
