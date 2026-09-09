class Node{
    int left,right,bookedCnt;
    Node leftNode,rightNode;
    Node(int bookedCnt,int left,int right){
        this.bookedCnt = bookedCnt;
        this.left = left;
        this.right = right;
    }
    Node(){}
}
class MyCalendar {
    Node root;
    public MyCalendar() {
        root = new Node(0,0,(int)1e9 - 1);
    }
    public boolean book(int startTime, int endTime) {
        boolean res = query(root,startTime,endTime - 1);
        if(res) root = updateTree(root,0,(int)1e9 - 1,startTime,endTime - 1);
        return res;
    }
    private boolean query(Node node,int left,int right){
        if(node == null) return true;
        if(node.left > right || node.right < left) return true;  
        if(node.bookedCnt == (node.right - node.left + 1)){return false;}
        if(node.left >= left && node.right <= right){
            return node.bookedCnt == 0;
        }
        return query(node.leftNode,left,right) && query(node.rightNode,left,right);
    }
    private Node updateTree(Node node,int l,int h,int left,int right){
        if(node == null) node = new Node(0,l,h);
        if(node.left > right || node.right < left) return node;
        if(node.left >= left && node.right <= right){
            node.bookedCnt = h - l + 1;
            return node;
        }
        int mid = (h - l) / 2 + l;
        node.leftNode = updateTree(node.leftNode,l,mid,left,right);
        node.rightNode = updateTree(node.rightNode,mid + 1,h,left,right);
        node.bookedCnt = node.leftNode.bookedCnt + node.rightNode.bookedCnt;
        return node;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */