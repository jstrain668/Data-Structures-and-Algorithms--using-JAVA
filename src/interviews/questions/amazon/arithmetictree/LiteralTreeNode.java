package interviews.questions.amazon.arithmetictree;


//Numerical values are literal nodes which are also leaf notes in the arithmetic expression tree
public class LiteralTreeNode extends ExpTreeNode{

    public LiteralTreeNode(String val){
        super(val);
        left = null;
        right = null;
        leaf = true;
    }
}
