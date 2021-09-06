package interviews.questions.amazon.arithmetictree;

public class OperatorTreeNode extends ExpTreeNode{

    public OperatorTreeNode(String val,ExpTreeNode left,ExpTreeNode right){
        super(val,left,right);
        leaf = false;
    }
}
