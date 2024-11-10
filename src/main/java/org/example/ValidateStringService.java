package org.example;

import java.util.HashMap;
import java.util.Map;

public class ValidateStringService {
    public String isValid(String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
        }

        Map<Integer, Integer> frequencies = new HashMap<>();

        for(int frequency : charCount.values()) {
            frequencies.put(frequency, frequencies.getOrDefault(frequency, 0) + 1);
        }

        if (frequencies.size() == 1) {
            return "YES";
        }

        if (frequencies.size() == 2) {
            int freq1 = (int) frequencies.keySet().toArray()[0];
            int freq2 = (int) frequencies.keySet().toArray()[1];
            int count1 = frequencies.get(freq1);
            int count2 = frequencies.get(freq2);

            if(freq1 > freq2) {
                if(count1 == 1 && freq1 - freq2 == 1) {
                    return "YES";
                }

                if(freq2 == 1 && count2 == 1) {
                    return "YES";
                }
            } else {
                if(count2 == 1 && freq2 - freq1 == 1) {
                    return "YES";
                }

                if(freq1 == 1 && count1 == 1) {
                    return "YES";
                }
            }

            return "NO";
        }

        return "NO";
    }
}
