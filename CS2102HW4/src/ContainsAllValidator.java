/**
 The ContainsAllValidator class is an implementation of the IValidator interface,
 which is used to validate if a binary tree contains all the elements of another
 binary tree. It accepts two IBinTree objects, a container and elements, and checks
 if every element of the elements tree is present in the container tree.
 */
public class ContainsAllValidator implements IValidator {
    /**
     A boolean value representing whether the container binary tree contains all elements of the elements binary tree.
     */
    private boolean containsAll = true;
    /**
     A binary tree representing the container of the elements that we want to validate.
     */
    private final IBinTree container;
    /**
     A binary tree representing the elements that we want to validate.
     */
    private final IBinTree elements;
    /**
     Constructor for the ContainsAllValidator class
     @param container the binary tree that contains the elements to validate
     @param elements the binary tree that contains the elements to validate against
     */
    public ContainsAllValidator(IBinTree container, IBinTree elements) {
        this.container = container;
        this.elements = elements;
        this.elements.accept(this); // For every element
    }

    /**
     * Produces an accumulated answer for the validator about whether the validator found the tree to be valid
     * after being traversed
     *
     * @return true if the tree passed the validator, false otherwise.
     */
    @Override
    public boolean isValid() {
        return containsAll;
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

        ContainsElementValidator verifyAddPart = new ContainsElementValidator(data);
        container.accept(verifyAddPart);
        boolean containsAdded = verifyAddPart.isValid();
        if (!containsAdded){
            containsAll = false;
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
