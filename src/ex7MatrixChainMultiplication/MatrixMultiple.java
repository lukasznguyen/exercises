package ex7MatrixChainMultiplication;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrixMultiple {

    Map<String, Integer> minCals;

    public MatrixMultiple(){
        minCals = new HashMap<>();
    }

    public String getHash(List<Integer> listNumbers) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(listNumbers.toString().getBytes());
        BigInteger no = new BigInteger(1, messageDigest);
        String hashtext = no.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }

    public Integer getMinCal(List<Integer> dimensions) throws NoSuchAlgorithmException {
        String hashOfList = getHash(dimensions);

        if (minCals.containsKey(hashOfList)) {
            return minCals.get(hashOfList);
        }

        if (dimensions.size() == 2) {
            return 0;
        }

        if (dimensions.size() == 3) {
            int result = dimensions.get(0)*dimensions.get(1)*dimensions.get(2);
            minCals.put(hashOfList, result);
            return result;
        }

        int n = dimensions.size() - 1;
        int minCal = dimensions.get(0) * dimensions.get(1) * dimensions.get(n) + getMinCal(dimensions.subList(1, n + 1));

        /*
        ((d0, d1)x(d1, d2)) x {(d2, d3) x .. (dn-1, dn)}
        (d0, d2) (d2, ..., dn)
        */
        
        List<Integer> tmp = new ArrayList<>();
        tmp.add(dimensions.get(0));
        tmp.addAll(dimensions.subList(2, n + 1));

        int minCal1 = dimensions.get(0) * dimensions.get(1) * dimensions.get(2) + getMinCal(tmp);

        minCals.put(hashOfList, Math.min(minCal, minCal1));
        return minCals.get(hashOfList);
    }


}
