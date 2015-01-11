package zyzzyxtech.com.trellochallenge;


import android.content.Context;

import zyzzyxtech.com.trellochallenge.ConstantValues;

/**
 * Created by Ken on 1/9/2015.
 */
public class Challenge {

    final static int BASE_HASH = ConstantValues.HASH_1;
    final static int HASH = ConstantValues.HASH_2;
    final static String letters = ConstantValues.LETTERS;   // Given as the character set for the challenge



    public static void main(String[] args) {
        try {
            Challenge trelloChallenge = new Challenge();
            trelloChallenge.display();
        }
        catch (Exception e) {
            e.printStackTrace ();
        }
    }
    public String display() {

//       Testing in Java Console
        // 
//        String str = "leepadg";
//        long givenDehash = 680131659347L;
//        String deHashed = "";
//        long i = Challenge.hash(str);

//        if (i == givenDehash) {
//            System.out.println("Hashing method works!\n");
//        }
//
//        // Test of sample hashing
//
//        System.out.println("String to hash: " + str);
//        System.out.println("Hash value: " + i);
//        deHashed = Challenge.deHash(i, deHashed);
//        System.out.println("DeHashed value: " + deHashed + "\n\n");
//
//
//
//        // Test of other string
//
//        str = "lollipop";
//        deHashed = "";
//        i = Challenge.hash(str);
//
//        // Test of sample hashing
//
//        System.out.println("String to hash: " + str);
//        System.out.println("Hash value: " + i);
//        deHashed = Challenge.deHash(i, deHashed);
//        System.out.println("DeHashed value: " + deHashed);
//        deHashed = "";
//
//        // Challenge Hash - time for the true test!!
        
        String deHashed = "";

        deHashed = Challenge.deHash(ConstantValues.TARGET_HASH, deHashed);

        return deHashed;
    }
    private static long hash (String s) {

        // Hashing method given at Trello.com as following pseudo-code:
//        Int64 hash (String s) {
//            Int64 h = 7
//            String letters = "acdegilmnoprstuw"
//            for(Int32 i = 0; i < s.length; i++) {
//                h = (h * 37 + letters.indexOf(s[i]))
//            }
//            return h
//        }

        // In Java...

        long h = Challenge.BASE_HASH;
        for(int i = 0; i < s.length(); i++) {
            h = (h * Challenge.HASH + Challenge.letters.indexOf(s.charAt(i)));
        }
        System.out.println("\n");
        return h;
    }
    public static String deHash(long hash, String stack) {
        int len = Challenge.letters.length();
        for(int i = 0; i < len; i++) {
            if ((hash - i) % HASH == 0) {
                hash = (hash - i) / HASH;
                if(hash == 0) {
                    return stack;
                }
                stack = Challenge.letters.charAt(i) + stack;
                return Challenge.deHash(hash, stack);
            }
        }
        return stack;
    }
}
