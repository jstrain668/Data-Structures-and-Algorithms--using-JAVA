package interviews.questions.amazon;

import java.util.*;

//Reference: https://www.techiedelight.com/generate-list-of-possible-words-from-a-character-matrix/
//Reference: https://www.geeksforgeeks.org/boggle-set-2-using-trie/
//Reference: https://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/
//Reference: https://www.algotree.org/algorithms/trie_python_java/
//Reference: https://medium.com/@amogh.avadhani/how-to-build-a-trie-tree-in-java-9d144aaa0d01


//Question: Find all words on an 3x3 grid using rules.
///*
//* Given a 3x3 grid with letters. Find all valid words using rules. The Rules are:
//*     - No tiles can be used more than once
//*     - Words must be at least 3 letters long
//*     - Letters in the word must be adjacent to one another either horizontally, vertically or diagonally.
//* You can assume you have a dictionary you can use to lookup the words and whether they are valid. What does the
//  dictionary interface look like?
//* You can assume the input board is 3x3.
//*/
//public List<String> findWords(final char[][] board) {
//}


//Trie is an efficient information retrieval data structure. A Trie is a tree in which each node has many children.
// The value at each node consists of 2 things. 1) A character 2) A boolean to say whether this character represents
// the end of a word. Tries are also known as Prefix Trees.

public class BoggleUsingTrie {

    // Let the given dictionary be following
    static final List<String> WORD_DICTIONARY = new ArrayList<>(Arrays.asList("GEEKS", "FOR", "QUIZ", "GEE","GO"));
    //static final Set<String> WORD_DICTIONARY = new HashSet<>(Arrays.asList("GEEKS", "FOR", "QUIZ", "GEE","GO"));

    // Below arrays detail all eight possible movements from a cell
    // (top, right, bottom, left, and four diagonal moves)
    static int[] ROW = { -1, -1, -1,  0,  1, 0, 1, 1 };
    static int[] COL = { -1,  1,  0, -1, -1, 1, 0, 1 };

    // trie Node
    public class TrieNode {
        Map<Character, TrieNode> character = new HashMap<>();

        // leaf is true if the node represents
        // end of a word
        boolean leaf;

        // constructor
        public TrieNode()
        {
            leaf = false;
        }
    }

    // Iterative method to insert a string into a Trie
    public void insert(TrieNode root, String str)
    {
        // start from the root node
        TrieNode curr = root;

        for (char ch: str.toCharArray())
        {
            // create a new node if the path doesn't exist
            curr.character.putIfAbsent(ch, new TrieNode());

            // go to the next node
            curr = curr.character.get(ch);
        }

        curr.leaf = true;
    }


    public TrieNode createTrieNode(){
        return new TrieNode();
    }

    // The function returns false if (x, y) is not valid matrix coordinates
    // or cell (x, y) is already processed or doesn't lead to the solution
    public boolean isSafe(int x, int y, boolean[][] visited,
                                 char[][] board, char ch)
    {
        return (x >= 0 && x < visited.length) && (y >= 0 && y < visited[0].length) &&
                !visited[x][y] && (board[x][y] == ch);
    }

    // A recursive function to search valid words present in a boggle using trie
    public void searchBoggle(TrieNode root, char[][] board, int i, int j,
                                    boolean[][] visited, String path,
                                    Set<String> result)
    {
        // if a leaf node is encountered
        if (root.leaf) {
            // update result with the current word
            result.add(path);
        }

        // mark the current cell as processed
        visited[i][j] = true;

        // traverse all children of the current Trie node
        for (Map.Entry<Character,TrieNode> entry: root.character.entrySet())
        {
            // check for all eight possible movements from the current cell
            for (int k = 0; k < ROW.length; k++)
            {
                // skip if cell is invalid or entry is already processed
                // or doesn't lead to any path in the Trie
                if (isSafe(i + ROW[k], j + COL[k], visited, board, entry.getKey()))
                {
                    searchBoggle(entry.getValue(), board, i + ROW[k], j + COL[k],
                            visited, path + entry.getKey(), result);
                }
            }
        }

        // backtrack: mark the current cell as unprocessed
        visited[i][j] = false;
    }


    //Solution:
    //With a trie, we only look at the letters we have to. Using a trie data structure, the maximum amount of time the
    // algorithm takes to figure out whether a string is a potential word relates to the length of the potential word,
    // and not the size of the dictionary. Using O-notation, the trie is said to have O(N) complexity (worst case),
    // where N is the length of the word.
    //1.Create an Empty trie and insert all words of given dictionary into trie
    //2.After that we pick only those character in boggle[][] which are child of root of Trie
    //For example pick ‘G’ boggle[0][0], ‘Q’ boggle[2][0] (both are present in boggle board)
    //3.Search the word in a trie which starts with character that we picked in step 2
    //Time Complexity: O(w * l) for inserting words from dictionary into trie where w is the number of words and l is
    //average length of word plus O(n) for the number of TrieNodes for the TrieNode been processed for a potential word
    //match multipled by 8 for the 8 possible moves
    //Space complexity
    public Set<String> searchBoggle(char board[][])
    {
        // construct a set to store valid words constructed from the boggle
        Set<String> result = new HashSet<>();

        // base case
        if (board.length == 0 || board[0].length == 0) {
            return result;
        }

        // root Node of trie
        TrieNode root = new TrieNode();

        // `M × N` board
        int M = board.length;
        int N = board[0].length;
        // Mark all characters as not visited
        boolean[][] visited = new boolean[M][N];

        // insert all words of dictionary into trie
        for (String word : WORD_DICTIONARY){
            insert(root,word);
        }

        // consider each character in the matrix
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // current character
                char ch = board[i][j];

                // proceed only if the current character is a child of the Trie root
                if (root.character.containsKey(ch))
                {
                    searchBoggle(root.character.get(ch), board, i, j,
                            visited, Character.toString(ch), result);
                }
            }
        }
        return result;
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        BoggleUsingTrie boggle = new BoggleUsingTrie();


        char board[][] = { { 'G', 'I', 'Z' },
                           { 'U', 'E', 'K' },
                           { 'Q', 'S', 'E' } };

        Set<String> validWords = boggle.searchBoggle(board);
        System.out.println(validWords);
    }

}
