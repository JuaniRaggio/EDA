package P1_1C_2025.EJ2;

public class Laberinto {

    public static boolean existeCamino(int[][] laberinto, int filaInicio, int columnaInicio, int filaFin, int columnaFin) {
        // Validate input coordinates are within bounds
        if (!esValido(laberinto, filaInicio, columnaInicio) || !esValido(laberinto, filaFin, columnaFin)) {
            return false;
        }

        // Check if start or end positions are walls
        if (laberinto[filaInicio][columnaInicio] == 1 || laberinto[filaFin][columnaFin] == 1) {
            return false;
        }

        return buscarCamino(laberinto, filaInicio, columnaInicio, filaFin, columnaFin);
    }

    private static boolean buscarCamino(int[][] laberinto, int filaActual, int columnaActual, int filaFin, int columnaFin) {
        // Found the end
        if (filaActual == filaFin && columnaActual == columnaFin) {
            return true;
        }

        // Mark current cell as visited
        int valorOriginal = laberinto[filaActual][columnaActual];
        laberinto[filaActual][columnaActual] = -1;

        // Try all four directions: up, right, down, left
        int[][] direcciones = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] dir : direcciones) {
            int nuevaFila = filaActual + dir[0];
            int nuevaColumna = columnaActual + dir[1];

            if (esValido(laberinto, nuevaFila, nuevaColumna) &&
                laberinto[nuevaFila][nuevaColumna] == 0 &&
                buscarCamino(laberinto, nuevaFila, nuevaColumna, filaFin, columnaFin)) {
                return true;
            }
        }

        // If no path is found, restore the original value (for visualization purposes)
        laberinto[filaActual][columnaActual] = valorOriginal;
        return false;
    }

    private static boolean esValido(int[][] laberinto, int fila, int columna) {
        return fila >= 0 && fila < laberinto.length &&
               columna >= 0 && columna < laberinto[0].length;
    }

    public static void main(String[] args) {
        int[][] laberinto = {
                {0, 0, 1, 0},
                {1, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 1}
        };

        boolean existe = existeCamino(laberinto, 0, 0, 3, 0);
        if (existe) {
            System.out.println("Existe un camino en el laberinto.");
        } else {
            System.out.println("No existe un camino en el laberinto.");
        }
        System.out.println("Caminos recorridos:");
        imprimirLaberinto(laberinto);

        int[][] laberintoSinSalida = {
                {0, 0, 1, 0},
                {1, 0, 1, 1},
                {0, 0, 0, 0},
                {0, 1, 1, 1}
        };
        boolean existeSinSalida = existeCamino(laberintoSinSalida, 0, 0, 0, 3);
        if (existeSinSalida) {
            System.out.println("Existe un camino en el laberinto sin salida (¡error!).");
        } else {
            System.out.println("No existe un camino en el laberinto sin salida.");
        }
        System.out.println("Caminos recorridos:");
        imprimirLaberinto(laberintoSinSalida);
    }

    public static void imprimirLaberinto(int[][] laberinto) {
        for (int[] fila : laberinto) {
            for (int celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
    }
}
