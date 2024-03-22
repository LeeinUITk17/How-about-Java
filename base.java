import java.util.Calendar;
import java.util.Random;
import javax.swing.JOptionPane;
import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Thread;

public class base extends Thread {
    public base(String str) {
        super(str);
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " Thread is running");
    }

    public static void main(String[] args) {
        base t1 = new base("Thread 1");
        base t2 = new base("Thread 2");
        t1.start();
        t2.start();

    }

    // cau 1
    static double area(int radius) {
        return Math.PI * pow(radius, 2);
    }

    static double perimeter(int radius) {
        return 2 * Math.PI * radius;
    }

    static void cau1() {
        int radius = Integer.parseInt(JOptionPane.showInputDialog("enter radius"));
        JOptionPane.showMessageDialog(null, "Area:" + area(radius) + "\nPerimeter:" + perimeter(radius));
    }

    // cau 2
    static void cau2() {
        int a = Integer.parseInt(JOptionPane.showInputDialog("enter a"));
        int b = Integer.parseInt(JOptionPane.showInputDialog("enter b"));
        String result = String.format("%.3f", (double) a / b);
        JOptionPane.showMessageDialog(null, a + "/" + b + "=" + result);
    }

    // cau 7
    static boolean primeNumber(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static void cau7() {
        int n = Integer.parseInt(JOptionPane.showInputDialog("enter n"));
        if (primeNumber(n)) {
            JOptionPane.showMessageDialog(null, n + " is a prime number");
        } else {
            JOptionPane.showMessageDialog(null, n + " is not a prime number");
        }
    }

    // cau 10
    static int greatestCommonDivisor(int a, int b) {
        if (a == 0 || b == 0) return a + b;
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    static void cau10() {
        int a = Integer.parseInt(JOptionPane.showInputDialog("enter a"));
        int b = Integer.parseInt(JOptionPane.showInputDialog("enter b"));
        JOptionPane.showMessageDialog(null, "Greatest common divisor of " + a + " and " + b + " is " + greatestCommonDivisor(a, b));
    }

    // cau 15
    static double celsiusToFahrenheit(double celsius) {
        return (double) (celsius * 1.8 + 32);
    }

    static double meterToinch(double meter) {
        return (double) (meter * 39.3701);
    }

    static void cau15() {
        double celsius = Double.parseDouble(JOptionPane.showInputDialog("enter celsius"));
        double meter = Double.parseDouble(JOptionPane.showInputDialog("enter meter"));
        JOptionPane.showMessageDialog(null, "fahrenhiet:" + celsiusToFahrenheit(celsius) + "\nInch:" + meterToinch(meter));
    }

    // cau 17
    static int maxinTwoDimetionalArray(int[][] arr) {
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }

    static List<Integer> primeNumberTwoDimetionalArray(int[][] arr) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (primeNumber(arr[i][j])) {
                    primeNumbers.add(arr[i][j]);
                    arr[i][j] = 0;
                }
            }
        }
        return primeNumbers;
    }

    static int[][] sortTwoDimensionalArray(int[][] arr) {
        int[] flat = Arrays.stream(arr)
                .flatMapToInt(Arrays::stream)
                .toArray();
        Arrays.sort(flat);
        int[][] sorted = new int[arr.length][];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            sorted[i] = new int[arr[i].length];
            for (int j = 0; j < arr[i].length; j++) {
                sorted[i][j] = flat[k++];
            }
        }

        return sorted;
    }

    static void cau17() {
        int row = Integer.parseInt(JOptionPane.showInputDialog("enter row"));
        int col = Integer.parseInt(JOptionPane.showInputDialog("enter col"));
        int arr[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(JOptionPane.showInputDialog("enter arr[" + i + "]" + "[" + j + "]"));
            }
        }
        int max = maxinTwoDimetionalArray(arr);
        int sorted[][] = sortTwoDimensionalArray(arr);
        List<Integer> primeNumbers = primeNumberTwoDimetionalArray(arr);
        JOptionPane.showMessageDialog(null, "max of arr is " + max);
        JOptionPane.showMessageDialog(null, "prime numbers of arr is " + primeNumbers);
        JOptionPane.showMessageDialog(null, "sorted arr is " + Arrays.deepToString(sorted));
    }
}
