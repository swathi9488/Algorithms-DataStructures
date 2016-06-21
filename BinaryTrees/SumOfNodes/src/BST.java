/**
 * Created by swathi on 1/18/16.
 */
public class BST {
    private BST leftNode;
    private BST rightNode;
    private int value;
    private BST parent;

    public BST getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BST leftNode) {
        this.leftNode = leftNode;
    }

    public BST getRightNode() {
        return rightNode;
    }

    public void setRightNode(BST rightNode) {
        this.rightNode = rightNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isLeaf () {
        return (this.getLeftNode() == null) && (this.getRightNode() == null);
    }

    public BST getParent() {
        return parent;
    }

    public void setParent(BST parent) {
        this.parent = parent;
    }
}
