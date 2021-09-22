import java.lang.Math;

class Lab1 {
    private static final int A_MIN = 4;
    private static final int A_MAX = 24;

    private static final float X_MIN = -7f;
    private static final float X_MAX = 14f;

    private static final int WIDTH = 11;
    private static final int HEIGHT = 19;

    public static void main(String[] args) {
        // Создать одномерный массив a типа long.
        // Заполнить его чётными числами от 4 до 24 включительно в порядке возрастания.

        long[] a = new long[WIDTH];
        for (int i = 0; i < a.length; i++) {
            a[i] = A_MIN + 2 * i;
        }

        // Создать одномерный массив x типа float.
        // Заполнить его 19-ю случайными числами в диапазоне от -7.0 до 14.0.

        float[] x = new float[HEIGHT];
        for (int i = 0; i < x.length; i++) {
            x[i] = (float) (Math.random() * (X_MAX - X_MIN) + X_MIN);
        }

        // Создать двумерный массив b размером 11x19.
        // Вычислить его элементы по следующей формуле (где x = x[j]):

        double[][] b = new double[WIDTH][HEIGHT];
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                switch ((int) a[i]) {
                    case 16:
                        b[i][j] = Math.exp(Math.pow(Math.log(Math.abs(x[j])), 1.0 / 3.0));
                        break;
                    case 10:
                    case 12:
                    case 14:
                    case 20:
                    case 24:
                        b[i][j] = Math.atan(Math.pow(Math.sin(x[j]), 2.0));
                        break;
                    default:
                        b[i][j] = Math.sin(Math.pow(Math.asin((x[j] + 3.5) / 21.0) / 2.0, 2.0));
                }
            }
        }

        // Вывод массива

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                System.out.printf("%.4f ", b[i][j]);
            }
            System.out.println();
        }
    }
}
