public class DepthVisitor implements IVisitor {
    private int minDepth;
    private int maxDepth;
    public int getMinDepth(){
        return minDepth;
    }
    public int getMaxDepth(){
        return maxDepth;
    }
    public DepthVisitor(IBinTree b){
        b.accept(this);
    }
    @Override
    public boolean visit(int data, IBinTree left, IBinTree right) {
        DepthVisitor dLeft = new DepthVisitor(left);
        DepthVisitor dRight = new DepthVisitor(right);
        minDepth = 1 + Math.min(dLeft.getMinDepth(), dRight.getMinDepth());
        maxDepth = 1 + Math.max(dLeft.getMaxDepth(), dRight.getMaxDepth());
        return false;
    }

    @Override
    public boolean visit() {
        minDepth = 0;
        maxDepth = 0;
        return false;
    }

}
