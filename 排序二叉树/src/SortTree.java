import javax.print.attribute.standard.NumberOfDocuments;

public class SortTree {
    public Node root;
    public Node nodeparent;

    public SortTree() {
    }

    public SortTree(int data) {
        root = new Node(data);
    }

    /*
    找到元素位置
     */
    public Node search(int data, Node node) {
        Node target = node;
         nodeparent =null;
        if (node != null) {
            if (data == node.data) {
                return node;
            } else if (data < node.data) {
                if (node.lchild != null){
                    nodeparent=target;
                    target = search(data, node.lchild);
                }

            } else {
                if (node.rchild != null){
                    nodeparent=target;
                    target = search(data, node.rchild);
                }

            }

        }
        return target;
    }

    /*
    增
     */
    public void addele(int data) {
        addele(data, root);
    }

    public void addele(int data, Node treenode) {
        Node newnode = new Node(data);
        Node target = search(data, treenode);
        if (target.data == data) {
            System.out.println("重复输入");
        } else if (data > target.data) {
            target.rchild = newnode;
        } else {
            target.lchild = newnode;
        }
    }
    /*
    删
     */
    public Node searchdel(Node node){
        Node target=node;
        if (node.rchild != null) {
            for(target = node.rchild;target.lchild!=null;target=target.lchild){}
        } else{
            for(target=node.lchild;target.rchild!=null;target=target.rchild){}
        }
        return target;
    }
    public Node delsearchpar(Node node){
        Node target=node;
        if (node.rchild != null) {
            if(node.rchild.lchild==null){}
            else
                for(target = node.rchild;target.lchild.lchild!=null;target=target.lchild){}

        } else{
            if(node.lchild.rchild==null){}
            else
                for(target=node.lchild;target.rchild.rchild!=null;target=target.rchild){}
        }
        return target;
    }
    public void delele(int data){
        delele(data,root);
    }
    public void delele(int data,Node treenode){

        Node target=searchele(data,treenode);
        if(target==null){
            return;
        }
        if(target.rchild!=null||target.lchild!=null){
            Node delele=searchdel(target);
            Node delparent=delsearchpar(target);
            target.data=delele.data;
            if(delparent.lchild==delele){
                delparent.lchild=null;
            }
            else if(delparent.rchild==delele){
                delparent.rchild=null;
            }
        }
        else {
            if(nodeparent!=null){
                if(nodeparent.lchild==target){
                    nodeparent.lchild=null;
                }
                if (nodeparent.rchild==target){
                    nodeparent.rchild=null;
                }
                System.out.println("删除成功");
            }
            else{
                System.out.println("已为根节点不能再删了");
            }

        }


    }
    /*
    改
     */
    public void modele(int datap,int datal){
        modele(datap,datal,root);
    }
    public void modele(int datap,int datal,Node treenode){
        Node node=search(datap,treenode);
        if(node.lchild==null&&node.rchild==null){
            node.data=datal;
        }
        else{
            delele(datap);
            addele(datal);
        }
    }
    /*
    查
     */
    public Node searchele(int data) {
        Node target=searchele(data,root);
        if(target!=null){
            System.out.println("找到该元素\n该元素的值为" + target.data);
            return searchele(data, root);
        }
        return null;
    }

    public Node searchele(int data, Node treenode) {
        Node target;
        if (search(data, treenode).data == data) {
            target = search(data, treenode);
            return target;
        } else {
            System.out.println("未找到该元素");
            return null;
        }
    }
    /*
    遍历
     */
    public void traverse(){
        traverse(root);
        System.out.println();
    }
    public void traverse(Node root) {
        if (root != null) {
            traverse(root.lchild);
            System.out.print(root.data + " ");
            traverse(root.rchild);
        }
    }
}


class Node {
    public int data;
    public Node lchild, rchild;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
        lchild = null;
        rchild = null;
    }
}
