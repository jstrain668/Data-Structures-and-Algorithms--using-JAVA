package interviews.questions.amazon;

import java.sql.SQLOutput;

public class LocalMin2DArray {

    public static void main(String[] args) {
        LocalMin2DArray localMin2DArray = new LocalMin2DArray();

        int[][] m = {{4, 5, 20, 31, 1}
                    ,{7, 31, 11, 8, 7}
                    ,{20, 29, 13, 19, 33}
                    ,{6, 16, 17, 27, 39}
                    ,{32, 37, 24, 26, 41}};

        int value = localMin2DArray.findLocalMinimum(m);
        System.out.println("value: "+value);
        //localMin2DArray.findLocalMin(m);
    }

    public int findLocalMin(int matrix[][]){

        if(matrix.length < 1 || matrix[0].length < 1) {
            System.out.println("Empty array passed in");
            return -1; //empty
        }

        for (int row=0; row < matrix.length; row++){
            for (int col=0; col < matrix[row].length; col++){

                if (row == 0){
                    System.out.print(matrix[row][col]+", ");
                }
            }
        }
        System.out.println();
        return -1;

    }

    private int findLocalMinimum(int m[][]){
        return find(m, m.length/2, m.length/2); //O(n)
    }

    private int find(int m[][], int a, int b){
        if( (b == 0 || m[a][b-1] > m[a][b]) && (b == m.length-1 || m[a][b+1] > m[a][b]) &&
                (a == 0 || m[a-1][b] > m[a][b]) && (a == m.length-1 || m[a+1][b] > m[a][b]))
            return m[a][b];
        else if(b > 0 && m[a][b-1] < m[a][b])
            return find(m, a, b-1);
        else if(b < m.length-1 && m[a][b+1] < m[a][b])
            return find(m, a, b+1);
        else if(a > 0 && m[a-1][b] < m[a][b])
            return find(m, a-1, b);
        else
            return find(m, a+1, b);
    }
}
