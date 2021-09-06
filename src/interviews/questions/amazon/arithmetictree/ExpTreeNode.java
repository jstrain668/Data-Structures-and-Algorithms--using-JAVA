package interviews.questions.amazon.arithmetictree;

public class ExpTreeNode {

    String val;
    ExpTreeNode left;
    ExpTreeNode right;
    boolean leaf;

    public ExpTreeNode(String val){
        this.val = val;
    }

    public ExpTreeNode(String val,ExpTreeNode left,ExpTreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int evaluate() {
        if (leaf) {
            return Integer.valueOf(val);
        }

        int l = left.evaluate();
        int r = right.evaluate();

        switch (val) {
            case "+":
                return l+r;
            case "-":
                return r-l;
            case "*":
                return l*r;
            case "/":
                return r/l;
        }
        return -1;
    }
}
