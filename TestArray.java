import java.util.*;

public class TestArray {
    public static void main(String[] args) {
        int a[][] = new int[3][3];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the element ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("Ente the element Are ------------------- ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(a[i][j] + " ");
            }

            System.out.println();
        }
    }
}
