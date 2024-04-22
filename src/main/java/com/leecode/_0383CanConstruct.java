package com.leecode;

import java.util.HashMap;
import java.util.Map;

public class _0383CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;
        char[] ransomNoteChars = ransomNote.toCharArray();
        char[] magazineChars = magazine.toCharArray();
        Map<Character, Integer> ransomMap = new HashMap<Character, Integer>();
        for (char magazineChar : magazineChars) {
            ransomMap.put(magazineChar, ransomMap.getOrDefault(magazineChar, 0) + 1);
        }
        for (char ransomNoteChar : ransomNoteChars) {
            Integer count = ransomMap.get(ransomNoteChar);
            if (count == null || count <= 0) return false;
            ransomMap.put(ransomNoteChar, count - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _0383CanConstruct().canConstruct("aa", "aab"));
    }
}
