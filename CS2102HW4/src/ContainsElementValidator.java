/**
 The ContainsElementValidator class implements the IValidator interface and provides functionality to check if a specific
 element is contained within a binary tree. The class keeps track of whether or not the element is found in the tree.
 */
public class ContainsElementValidator implements IValidator {
    /**
     The element to search for in the binary tree
     */
    private int element;
    /**
     A flag indicating whether the element was found during traversal
     */
    private boolean containsElement;

    /**
     Constructs a ContainsElementValidator with the specified element to search for
     @param element the element to search for in the binary tree
     */
    public ContainsElementValidator(int element) {
        this.element = element;
        this.containsElement = false; // unshadow
    }
    

    /**
     * Produces an accumulated answer for the validator about whether the validator found the tree to be valid
     * after being traversed
     *
     * @return true if the tree passed the validator, false otherwise.
     */
    @Override
    public boolean isValid() {
        return containsElement;
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
        if (data == element) {
            containsElement = true;
            return false;
        }
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
