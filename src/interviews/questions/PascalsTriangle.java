package interviews.questions;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        //First row is always 1
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for(int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            //First element in a row is always one
            row.add(1);

            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            //Last element in a row is always one
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }

    public void printPascalsTriangle(List<List<Integer>> output){

        for (int i = 0; i < output.size(); i++) {
            for (int j = 0; j < output.get(i).size(); j++) {
                System.out.print(output.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        PascalsTriangle pt = new PascalsTriangle();
        int n = 6;
        System.out.println("Number of rows in Pascals triangle to print: "+n);
        pt.printPascalsTriangle(pt.generate(n));
    }

}
