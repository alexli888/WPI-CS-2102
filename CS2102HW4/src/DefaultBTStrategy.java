/**
 * A Strategy for adding integers in breadth first order
 */
public class DefaultBTStrategy implements IBinTreeStrategy
{
    @Override
    public NodeBT addInt(int i, IBinTree left, int data, IBinTree right) {
        int sizeLeft = new SizeVisitor(left).getSize();          //Use a visitor to get the size of the left subtree
        int sizeRight = new SizeVisitor(right).getSize();        //Use a visitor to get the size of the right subtree
        int depth = Math.max(new DepthVisitor(left).getMaxDepth(), new DepthVisitor(right).getMaxDepth()); //get the biggest depth

        boolean leftSubtreeFull = sizeLeft >= Math.pow(2,depth) - 1; //Is the left subtree full to that depth?
        boolean rightSubtreeFull = sizeRight >= Math.pow(2,depth) - 1; //is the right subtree full to that depth?

        if(leftSubtreeFull && ! rightSubtreeFull){
            return new NodeBT(data, left, right.addInt(i), this); //add i to the right subtree
        }
        else{ //If either the left subtree has space or both trees are full
            return new NodeBT(data, left.addInt(i), right, this); //add i to the left subtree
        }
    }

    @Override
    public NodeBT addInt(int i) {
        return new NodeBT(i, new EmptyBT(this), new EmptyBT(this), this);
    }
}
