import java.util.Scanner;

public class Solution {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Digite 1 o 2 Respectivamente...");
        System.out.println("1. Generar array aleatoriamente (1).\n2. Digitar array manualmente (2).");
        int eleccion = sc.nextInt();
        System.out.println();
        if (eleccion == 1) {
            int[] nums = new int[100];
            for (int i = 0; i < nums.length; i++)
                nums[i] = (int) (Math.random() * 100) + 1;
            ordenarPorSeleccion(nums);
            procesarResultado(nums);
        } else {
            System.out.println("Digite la longitud del array a procesar.");
            int n = sc.nextInt();

            System.out.println("Por favor, digite los " + n + " elementos.");
            int[] nums = llenarArray(n);
            procesarResultado(nums);
        }
    }

    private static void procesarResultado(int[] nums) {
        imprimirArray(nums);
        int j = removeDuplicates(nums);
        int[] resultado = duplicarArray(nums, j);
        System.out.println("\nElementos repetidos eliminados.");
        System.out.println("La longitud del array ahora es de " + (j) + " elementos.\n");
        imprimirArray(resultado);
    }

    private static void ordenarPorSeleccion(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int aux = nums[i];
                    nums[i] = nums[j];
                    nums[j] = aux;
                }
            }
        }
    }

    private static int[] llenarArray(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println();
        return nums;
    }

    private static int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = j; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    private static int[] duplicarArray(int[] nums, int j) {
        int[] resultado = new int[j];
        for (int i = 0; i < resultado.length; i++) {
            resultado[i] = nums[i];
        }
        return resultado;
    }

    private static void imprimirArray(int[] nums) {
        System.out.print("nums = [");
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1)
                System.out.print(nums[i]);
            else
                System.out.print(nums[i] + ", ");
        }
        System.out.println("]");
    }
}