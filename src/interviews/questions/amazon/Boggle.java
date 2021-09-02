package interviews.questions.amazon;

//Reference: https://www.techiedelight.com/generate-list-of-possible-words-from-a-character-matrix/
//Reference: https://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/
//Reference: https://cs.stackexchange.com/questions/96626/whats-the-big-o-runtime-of-a-dfs-word-search-through-a-matrix
//Reference: https://www.educative.io/m/boggle
//Reference: https://ankurdave.com/dl/AnkurDaveExtendedEssay2009.pdf
//Reference: https://stackoverflow.com/questions/34347758/why-does-dfs-work-when-trying-to-find-all-valid-words-in-a-boggle-board


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

import org.apache.commons.lang3.time.StopWatch;

import java.util.*;


public class Boggle {

    // Let the given dictionary be following
    //static final List<String> DICTIONARY = Arrays.asList("STAR", "NOTE", "SAND", "STONE");
    static final List<String> DICTIONARY = new ArrayList<>(Arrays.asList("GEEKS", "FOR", "QUIZ", "GEE","GO"));
    //static final Set<String> WORD_DICTIONARY = new HashSet<>(Arrays.asList("STAR", "NOTE", "SAND", "STONE"));
    static final int DICTIONARY_SIZE = DICTIONARY.size();
    static final int WORD_MIN_SIZE = 3;
    // Below arrays detail all eight possible movements from a cell
    // (top, right, bottom, left, and four diagonal moves)
    static int[] row = { -1, -1, -1,  0,  1, 0, 1, 1 };
    static int[] col = { -1,  1,  0, -1, -1, 1, 0, 1 };

    // Method to check if it is safe to go to cell (x, y) from the current cell.
    // The function returns false if (x, y) is not valid matrix coordinates
    // or cell (x, y) is already processed.
    public boolean isSafe(int x, int y, boolean[][] processed) {
        return (x >= 0 && x < processed.length) && (y >= 0 && y < processed[0].length)
                && !processed[x][y];
    }

    // A recursive function to generate all possible words in a boggle
    public void searchBoggle(char[][] board, Set<String> wordSet,
                                    Set<String> result, boolean[][] processed,
                                    int i, int j, String path)
    {
        // mark the current node as processed
        processed[i][j] = true;

        // update the path with the current character and insert it into the set
        path += board[i][j];

        // check whether the path is present in the input set
        if (path.length() >= WORD_MIN_SIZE && wordSet.contains(path)) {
            result.add(path);
        }

        // check for all eight possible movements from the current cell
        for (int k = 0; k < row.length; k++)
        {
            // skip if a cell is invalid, or it is already processed
            if (isSafe(i + row[k], j + col[k], processed)) {
                searchBoggle(board, wordSet, result, processed, i + row[k],
                        j + col[k], path);
            }
        }

        // backtrack: mark the current node as unprocessed
        processed[i][j] = false;
    }

    //Solution: We can use Depth–first search (DFS) to solve this problem. The idea is to start from each character in
    // the matrix and explore all eight paths possible and recursively check if they lead to a solution or not. To make
    // sure that a word doesn't have multiple instances of the same cell, keep track of cells involved in the current
    // path in the matrix, and before exploring any cell, ignore the cell if it is already covered in the current path.
    // To find all possible movements from a cell, we can use an array to store the relative position of movement from
    // any cell. For example, if the current cell is (x, y), we can move to (x + row[k], y + col[k]) for 0 <= k <=7
    // using the following array:
    //int row[] = { -1, -1, -1, 0, 0, 1, 1, 1 }
    //int col[] = { -1, 0, 1, -1, 1, -1, 0, 1 }
    //So, from position (x, y), we can move to:
    //(x-1, y-1)
    //(x-1, y)
    //(x-1, y+1)
    //(x, y-1)
    //(x, y+1)
    //(x + 1, y-1)
    //(x + 1, y)
    //(x + 1, y + 1)

    //Time Complexity: It is O(M*N*8 to the power of d) where M is the number of rows and N the number of columns in the
    //board. 8 is the number of possible moves and d is the length of the longest word to be found
    //Space Complexity: O(w) for result HashSet where w is the number of words found

    // Method to search for a given set of words in a boggle
    public Set<String> searchBoggle(char[][] board)
    {
        Set<String> wordSet = new HashSet<>(DICTIONARY);
        // construct a set to store valid words constructed from the boggle
        Set<String> result = new HashSet<>();

        // base case
        if (board.length == 0) {
            return result;
        }

        // `M × N` board
        final int M = board.length;
        final int N = board[0].length;

        // construct a boolean matrix to store whether a cell is processed or not
        boolean[][] processed = new boolean[M][N];

        // generate all possible words in a boggle
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++) {
                // consider each character as a starting point and run DFS
                searchBoggle(board, wordSet, result, processed, i, j, "");
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Boggle boggle = new Boggle();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
     /*   char[][] board = {
                {'M', 'S', 'E'},
                {'R', 'A', 'T'},
                {'L', 'O', 'N'}
        }; */
        char board[][] = { { 'G', 'I', 'Z' },
                           { 'U', 'E', 'K' },
                           { 'Q', 'S', 'E' } };

        Set<String> validWords = boggle.searchBoggle(board);
        System.out.println(validWords);
        stopWatch.stop();
        System.out.println("Execution time in milli seconds for Boggle using Trie: "+stopWatch.getTime());
        stopWatch.reset();
    }
}
