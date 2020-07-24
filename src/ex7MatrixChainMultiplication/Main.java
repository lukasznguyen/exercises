package ex7MatrixChainMultiplication;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Main {
    // (1x2 2x3) 3x1 1x4
    // 1x3 3x1 1x4
    // 1x1 1x4
    // 1x4              s: 1*2*3+1*3*1+1*1*4 = 6+3+4 = 13

    // 1x2 (2x3 3x1 1x4)
    // 1x2 (2x1 1x4)
    // 1x2 2x4
    // 1x4              s: 2*3*1+2*1*4+1*2*4 = 6+8+8 = 22

    public static void main(String[] args) {
        List<Integer> input = List.of(1, 2, 3, 1, 4);
        MatrixMultiple matrixMultiple = new MatrixMultiple();
        try {
            System.out.println("Minimum number of steps: "+matrixMultiple.getMinCal(input));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

}
