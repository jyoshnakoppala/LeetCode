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
        return build(grid, 0, 0, grid.length);
    }
    private Node build(int[][] grid, int r, int c, int n)
    {
        boolean allsame=true;
        int first=grid[r][c];
        for(int i=r;i<r+n;i++)
        {
            for(int j=c;j<c+n;j++)
            {
                if(grid[i][j]!=first)
                {
                    allsame=false;
                    break;
                }
            }
            if (!allsame) break;
        }
        if(allsame) return new Node(first==1, true);
        int half=n/2;
        Node topLeft = build(grid, r, c, half);
        Node topRight = build(grid, r, c + half, half);
        Node bottomLeft = build(grid, r + half, c, half);
        Node bottomRight = build(grid, r + half, c + half, half);

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}