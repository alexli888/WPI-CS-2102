/**
 * A validator that checks whether each node in a binary tree has a value that is larger than all the nodes in its subtree.
 */
public class BiggerThanRestValidator implements IValidator{
    /**
     The largest value seen so far during the traversal of the binary tree.
     It is initialized to the minimum possible integer value.
     */
    private int largest;

    /**
     A boolean value representing whether every node in the binary tree satisfies the "bigger than rest" condition.
     It is initialized to true initially.
     */
    private boolean biggerSoFar;

    /**
     * Constructs a new BiggerThanRestValidator.
     * Initializes the largest value seen so far to be the minimum possible integer value,
     * and the validity flag to be true initially.
     */
    public BiggerThanRestValidator() {
        this.largest = Integer.MIN_VALUE;
        this.biggerSoFar = true;
    }

    /**
     * Produces an accumulated answer for the validator about whether the validator found the tree to be valid
     * after being traversed.
     *
     * @return true if the tree passed the validator, false otherwise.
     */
    @Override
    public boolean isValid() {
        return biggerSoFar;
    }

    /**
     * A callback function for when the current traversal reaches a NodeBT.
     * Checks whether the data in the current node is larger than all the nodes in its subtree.
     *
     * @param data  the data in the current node
     * @param left  the left subtree of the current node
     * @param right the right subtree of the current node
     * @return true when the traversal should continue; false if it should stop early (short-circuiting)
     */
    @Override
    public boolean visit(int data, IBinTree left, IBinTree right) {
        if (data <= largest) {
            biggerSoFar = false;
            return false; // short-circuit, no need to continue traversal
        } else {
            largest = data;
            return true; // continue traversal
        }
    }

    /**
     * A callback function for when the current traversal reaches an EmptyBT.
     * Since an empty subtree vacuously satisfies the "bigger than rest" condition,
     * the traversal should stop early and report that the tree is valid so far.
     *
     * @return false to stop the traversal (short-circuiting)
     */
    @Override
    public boolean visit() {
        return true;
    }

}
