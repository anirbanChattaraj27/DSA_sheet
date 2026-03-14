
import java.util.*;

// Pair class to store a word and its transformation step count
class Pair {

    String first;
    int second;

    Pair(String _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}

class O26_Word_Ladder_I {

    // Method to find the shortest transformation sequence from startWord to targetWord
    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 1)); // Add the startWord with step count 1

        Set<String> st = new HashSet<>(); // Store words for quick lookup
        int len = wordList.length;

        for (int i = 0; i < len; i++) {
            st.add(wordList[i]); // Add all words to the set
        }

        st.remove(startWord); // Remove the startWord from the set

        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();

            // If we reach the target word, return the number of steps
            if (word.equals(targetWord)) {
                return steps;
            }

            // Try changing each character of the word 
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    // If the transformed word exists in the set
                    if (st.contains(replacedWord)) {
                        st.remove(replacedWord); // Remove to avoid cycles
                        q.add(new Pair(replacedWord, steps + 1)); // Add the new word with incremented steps
                    }
                }
            }
        }
        return 0; // If no transformation is possible
    }

    // Main method to test the wordLadderLength function
    public static void main(String[] args) {
        O26_Word_Ladder_I obj = new O26_Word_Ladder_I();

        String startWord = "hit";
        String targetWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        int result = obj.wordLadderLength(startWord, targetWord, wordList);

        System.out.println("Shortest transformation sequence length: " + result);
    }
}
