/**
 The CorrectNumberElementsValidator class is an implementation of the IValidator interface,
 which is used to validate if a binary tree has the correct number of elements.
 */
public class CorrectNumberElementsValidator implements IValidator {

    // an integer representing the number of nodes that have been visited before the current node during the traversal.
    private int beforeNum;
    // an integer representing the number of nodes that have been visited after the current node during the traversal.
    private int afterNum;
    // an integer representing the expected number of nodes in the binary tree.
    private int num;

    /**
     * Constructor for the CorrectNumberElementsValidator class
     *
     * @param num the expected number of elements in the binary tree
     */
    public CorrectNumberElementsValidator(int num) {
        this.num = num;
        this.beforeNum = 0;
        this.afterNum = 0;
    }

    /**
     * Produces an accumulated answer for the validator about whether the validator found the tree to be valid
     * after being traversed
     *
     * @return true if the tree passed the validator, false otherwise.
     */
    @Override
    public boolean isValid() {
        return this.num == this.beforeNum + this.afterNum;
    }

    /**
     * A callback function for when the current traversal reaches a NodeBT
     *
     * @param data  the data in the current node
     * @param left  the left subtree of the current node
     * @param right the right subtree of the current node
     * @return true when the traversal should continue; false if it should stop early (short-circuiting)
     */
    @Override
    public boolean visit(int data, IBinTree left, IBinTree right) {
        this.beforeNum++;
        return true;
    }

    /**
     * A callback function for when the current traversal reaches an EmptyBT
     *
     * @return true when the traversal should continue (backtracking); false if it should stop early (short-circuiting)
     */
    @Override
    public boolean visit() {
        return true;
    }
}
