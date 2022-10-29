import java.util.Scanner;

public class Solution {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Digite 1 o 2 Respectivamente...");
        System.out.println("1. Generar array aleatoriamente (1).\n2. Digitar array manualmente (2).");
        // Se ofrece dos opciones al usuario para ejecutar el programa
        int eleccion = sc.nextInt();
        System.out.println();
        if (eleccion == 1) {
            // Si digita 1, se ejecuta el generador aleatorio de casos de prueba para el
            // problema y los guarda dentro del array nums
            int[] nums = new int[100];
            for (int i = 0; i < nums.length; i++)
                nums[i] = (int) (Math.random() * 100) + 1;
            // Como es generado aleatoriamente, se debe ordenar de menor a mayor, se utilizó
            // ordenamiento por seleccion para ello
            ordenarPorSeleccion(nums);
            // ordenarParcialmente(nums);

            // Al ordenarlos, se pasa a procesar el array para su posterior análisis y
            // obtención de información
            procesarResultado(nums);
        } else {
            // Si no elije la opción 1, el usuario debe llenar el array manualmente.
            System.out.println("Digite la longitud del array a procesar.");
            // Aqui el usuario digita la longitud del array
            int n = sc.nextInt();
            // Aqui el usuario pasa a llenar el array manualmente digitando n números
            // ordenados
            System.out.println("Por favor, digite los " + n + " elementos.");
            int[] nums = llenarArray(n);
            // Como se encuentran ordenados, se pasa a procesar el array para su posterior
            // análisis y obtención de información
            procesarResultado(nums);
        }
    }

    // Este es el método que se encarga de procesar el array ordenado para la
    // obtención de información
    private static void procesarResultado(int[] nums) {
        // Imprime el estado inicial del array incluyendo los números repetidos
        imprimirArray(nums);
        // Se llama al método removeDuplicates para eliminar elementos duplicados y se
        // retorna la longitud nueva del array
        int j = removeDuplicates(nums);
        // Como en java no es posible eliminar espacios dentro de un array, el resultado
        // se pasa a un nuevo array con longitud j
        int[] resultado = duplicarArray(nums, j);
        System.out.println("\nElementos repetidos eliminados.");
        System.out.println("La longitud del array ahora es de " + (j) + " elementos.\n");
        // Imprime el array ordenado con su información y sin elementos repetidos
        imprimirArray(resultado);
    }

    // Este es el método que ordena por selección el array que se obtiene mediante
    // el generador de casos de prueba
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

    // Este es el método que llena el array que es manualmente digitado por el
    // usuario usando n como longitud del array
    private static int[] llenarArray(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println();
        return nums;
    }

    // Este es el método que remueve elementos duplicados, el mismo que se subió a
    // la plataforma LeetCode
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

    // Este es el método que crea un nuevo array con longitud j para guardar el
    // resultado final del array ordenado sin elementos repetidos
    private static int[] duplicarArray(int[] nums, int j) {
        int[] resultado = new int[j];
        for (int i = 0; i < resultado.length; i++) {
            resultado[i] = nums[i];
        }
        return resultado;
    }

    // Este es el método que se encarga de imprimir el array, tiene un condicional
    // para mayor estética en la impresión y lectura de datos
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

    /*
     * INFORMACIÓN SOBRE CASOS BORDES
     * • Si el array se desea completamente desordenado, se comenta la línea 20 del
     * programa.
     *
     * • Si el array se desea con elementos negativos, se deben digitar manualmente
     * o en la línea 17 asignarle negativo al 100 y cambiar el 1 por el digito
     * máximo que se desea).
     *
     * • Si el array se desea ordenado de mayor a menor, en la línea 63 se cambia el
     * > (mayor que) del condicional por un < (menor que).
     *
     * • Si el array se desea parcialmente ordenado, se descomenta el algoritmo de
     * la línea 135 y la línea de código 21
     */

    // private static void ordenarParcialmente(int[] nums) {
    // for (int i = 0, j = nums.length / 2; j < nums.length; j++, i++) {
    // int aux = nums[i];
    // nums[i] = nums[j];
    // nums[j] = aux;
    // }
    // }
}