package HashMaps;
import java.util.*;

class IntroToHash{
    public static void main(String[] args) {
        HashMap<String, Integer> hash = new HashMap<>();
        hash.put("dinesh", 80);
        hash.put("dinesh1", 85);
        hash.put("Dinesh", 90);

        System.out.println(hash.getOrDefault("Dinesh", 95));
    }
}