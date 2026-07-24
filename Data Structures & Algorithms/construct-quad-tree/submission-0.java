/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/
class Solution {
    public Node construct(int[][] grid) {
        return helper(grid,0,0,grid.length);
    }
    private Node helper(int[][] grid,int x,int y,int len){
        if(len == 1) {
            return new Node(grid[x][y] != 0 , true);
        }
         Node topLeft = helper(grid,x,y,len/2);
         Node topRight = helper(grid,x,y+len/2,len/2);
         Node bottomLeft = helper(grid,x+len/2,y,len/2);
         Node bottomRight = helper(grid,x+len/2,y+len/2,len/2);
         Node result = new Node();
        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val 
           && topRight.val == bottomRight.val && bottomRight.val == bottomLeft.val && bottomLeft.val == topLeft.val) {
            result.val = topLeft.val;
            result.isLeaf = true;
        } else {
            result.topLeft = topLeft;
            result.topRight = topRight;
            result.bottomLeft = bottomLeft;
            result.bottomRight = bottomRight;
        }
        return result;
    }
}