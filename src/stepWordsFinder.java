import java.util.*;

public class stepWordsFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputWord = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        // Read dictionary words
        List<String> dictionary = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dictionary.add(scanner.nextLine());
        }

        // Find and print step words
        List<String> stepWords = findStepWords(inputWord, dictionary);
        for (String word : stepWords) {
            System.out.println(word);
        }
    }
    public static List<String> findStepWords(String inputWord, List<String> dictionary) {
        List<String> validStepWords = new ArrayList<>();

        // Count character frequencies of the input word
        Map<Character, Integer> inputFreq = getCharFrequency(inputWord);
        int inputWordLength = inputWord.length();

        for (String dictWord : dictionary) {
            // A potential step word must have a length exactly one greater than the input word
            if (dictWord.length() != inputWordLength + 1) {
                continue;
            }

            // Count character frequencies of the dictionary word
            Map<Character, Integer> dictFreq = getCharFrequency(dictWord);

            // Check if the dictionary word is a valid step word
            if (isStepWord(inputFreq, dictFreq)) {
                validStepWords.add(dictWord);
            }
        }

        // Sort the result in lexicographical order
        Collections.sort(validStepWords);

        return validStepWords;
    }
    private static boolean isStepWord(Map<Character, Integer> inputFreq, Map<Character, Integer> dictFreq) {
        int addedChars = 0;

        // Iterate through the characters in the dictionary word
        for (Map.Entry<Character, Integer> entry : dictFreq.entrySet()) {
            char c = entry.getKey();
            int dictCount = entry.getValue();
            int inputCount = inputFreq.getOrDefault(c, 0);

            // The dictionary word's count for a character must be greater than or equal to the input word's count
            if (dictCount < inputCount) {
                return false;
            }

            // The difference in character counts contributes to the "added" character count
            addedChars += (dictCount - inputCount);
        }

        // A valid step word has exactly one added character
        return addedChars == 1;
    }
    private static Map<Character, Integer> getCharFrequency(String word) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }
}
