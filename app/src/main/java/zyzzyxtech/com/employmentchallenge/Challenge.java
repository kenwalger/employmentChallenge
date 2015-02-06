package zyzzyxtech.com.employmentchallenge;


/**
 * Created by Ken on 1/9/2015.
 */
public class Challenge {

    final static int SM_HASH = ConstantValues.SMALL_HASH_VALUE;
    final static int LG_HASH = ConstantValues.LARGE_HASH_VALUE;
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
        String deHashed = "";

        deHashed = deHash(ConstantValues.TARGET_HASH, deHashed);

        return deHashed;
    }
    
    /* 
    *   hash() provided by Trello.com to create their challenge hash was 
    *   mathematically created by the hash formula: 
    *      h = (7 * 37 + letter.indexOf(the_string_passed_to_hash))
    */
    
    private static long hash (String s) {

        long h =SM_HASH;
        for(int i = 0; i < s.length(); i++) {
            h = (h * LG_HASH + letters.indexOf(s.charAt(i)));
        }
        System.out.println("\n");
        return h;
    }
        
    public static String deHash(long hash, String challengeString) {
        int len = letters.length();
        for(int i = 0; i < len; i++) {
            if ((hash - i) % LG_HASH == 0) {
                hash = (hash - i) / LG_HASH;
                if(hash == 0) {
                    return challengeString;
                }
                challengeString = letters.charAt(i) + challengeString;
                return deHash(hash, challengeString);
            }
        }
        return challengeString;
    }
}
