
import java.util.*;

class O27_Word_Ladder_II {

    // Method to find all shortest transformation sequences from startWord to targetWord
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        Set<String> st = new HashSet<>(); // HashSet for quick lookup
        int len = wordList.length;

        for (int i = 0; i < len; i++) {
            st.add(wordList[i]); // Add words to the set
        }

        Queue<ArrayList<String>> q = new LinkedList<>(); // Queue for BFS
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        q.add(ls);

        ArrayList<String> usedOnLevel = new ArrayList<>(); // Track words used at a level
        usedOnLevel.add(startWord);

        int level = 0;
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            ArrayList<String> vec = q.peek();
            q.remove();

            // Clear words used in the previous level
            if (vec.size() > level) {
                level++;
                for (String it : usedOnLevel) {
                    st.remove(it);
                }
            }

            String word = vec.get(vec.size() - 1);

            // If we reached the target word, add sequence to answer
            if (word.equals(targetWord)) {
                if (ans.isEmpty() || ans.get(0).size() == vec.size()) {
                    ans.add(new ArrayList<>(vec));
                }
            }

            // Try changing each character in the word
            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = c;
                    String replacedWord = new String(replacedCharArray);

                    // If the transformed word exists in the set
                    if (st.contains(replacedWord)) {
                        vec.add(replacedWord);
                        ArrayList<String> temp = new ArrayList<>(vec); // Copy list
                        q.add(temp);
                        usedOnLevel.add(replacedWord); // Mark as used on this level
                        vec.remove(vec.size() - 1); // Backtrack
                    }
                }
            }
        }
        return ans; // Return all shortest sequences
    }

    // Main method to test the findSequences function
    public static void main(String[] args) {
        O27_Word_Ladder_II obj = new O27_Word_Ladder_II();

        String startWord = "hit";
        String targetWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        ArrayList<ArrayList<String>> result = obj.findSequences(startWord, targetWord, wordList);

        System.out.println("All shortest transformation sequences: ");
        for (ArrayList<String> sequence : result) {
            System.out.println(sequence);
        }
    }
}
