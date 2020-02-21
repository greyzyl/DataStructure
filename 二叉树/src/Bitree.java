import java.util.*;
import static java.lang.Math.*;
public class Bitree {
    public char data;
    public int level;
    public Bitree lchild,rchild;
    public Bitree(temp temp){
        Bitree mytree=createtree(this,temp);
        this.data=mytree.data;
        this.rchild=mytree.rchild;
        this.lchild=mytree.lchild;
        this.setLevel();
    }
    public Bitree(char ch){
        data=ch;
    }
     Scanner sc=new Scanner(System.in);
    /*
    建树
     */
    public  Bitree createtree(Bitree newnode,temp tem){
        char ch;
        ch=tem.string.charAt(0);
        if (ch == '#') {
            newnode=null;
            tem.string=tem.string.substring(1);
        }
        else{
            newnode=new Bitree(ch);
            tem.string=tem.string.substring(1);
            newnode.lchild=createtree(newnode.lchild,tem);
            newnode.rchild=createtree(newnode.rchild,tem);
        }
        return newnode;
    }
    /*
    先根序
     */
    public void ftraverse1(){
        if(this!=null){
            System.out.println(data);
            if (this.lchild!=null)
                this.lchild.ftraverse1();
            if (this.rchild!=null)
                this.rchild.ftraverse1();
        }
    }

    public void ftraverse2(Bitree root){
        Stack<Bitree> vector=new Stack<Bitree>();
        Bitree bitree=root;
        vector.push(bitree);
        while (!vector.isEmpty()&&bitree!=null){
            Bitree pop=vector.pop();
            System.out.print(pop.data+"  ");
            if(pop.rchild!=null){
                vector.push(pop.rchild);
            }
            if(pop.lchild!=null){
                vector.push(pop.lchild);
            }
//            if(pop.lchild!=null&&pop.rchild!=null){
//                vector.push(pop.rchild);
//                vector.push(pop.lchild);
//            }
//            else if(pop.rchild==null&&pop.lchild!=null){
//                vector.push(pop.lchild);
//            }else if(pop.lchild==null&&pop.rchild!=null){
//                vector.push(pop.rchild);
//            }
//            else{}

        }
        System.out.println();
    }
    /*
    后根序
     */
    public void ltraverse1(){
        if(this!=null){

            if (this.lchild!=null)
                this.lchild.ltraverse1();
            if (this.rchild!=null)
                this.rchild.ltraverse1();
            System.out.print(data);
        }
    }
    public void ltraverse2(Bitree root) {
        Stack<Bitree> stack = new Stack<Bitree>();
        Bitree thisnode = root, lastnode = null;
        while (thisnode != null) {
            stack.push(thisnode);
            thisnode = thisnode.lchild;
        }
        while (!stack.isEmpty()) {
            Bitree node = stack.pop();
            if (node.rchild!=null&&node.rchild!=lastnode) {
                stack.push(node);
                node=node.rchild;
                while (node != null) {
                    stack.push(node);
                    node = node.lchild;
                }

            }
            else {
                System.out.print(node.data);
                lastnode=node;
            }
        }
        System.out.println();
    }
    /*
    中根序
     */
    public void mtraverse1(){
        if(this!=null){
            if (this.lchild!=null)
                this.lchild.mtraverse1();
            System.out.println(data);
            if (this.rchild!=null)
                this.rchild.mtraverse1();
        }
    }
    public void mtraverse2(Bitree root){
        Stack<Bitree> vector=new Stack<Bitree>();
        Bitree bitree=root;
        while (bitree!=null||!vector.isEmpty()){
            while (bitree!=null){
                vector.push(bitree);
                bitree=bitree.lchild;
            }
            if(!vector.isEmpty()){
                Bitree tree=vector.pop();
                System.out.print(tree.data+"  ");
                if(tree.rchild!=null){
                    bitree=tree.rchild;
                }
            }
        }
        System.out.println();
    }

    public void inOrderByStack(Bitree root) {
        System.out.println("中序非递归遍历:");
        // 创建栈,和先序遍历类似，直接入栈直到没有最左左子树可以 入栈
        Deque<Bitree> stack = new LinkedList<>();
        Bitree bitree = root;
        //添加暂时完毕，开始pop元素
        while(bitree!=null || stack.size()>0 ){

            while(bitree!=null){
                stack.push(bitree);
                bitree = bitree.lchild;
            }
            //一边pop并且一边进行判断，右结点不会null的，右子树，继续按照添加方法，将最左结点全部添加进去
            if(stack.size()>0){
                Bitree pop = stack.pop();
                System.out.print(pop.data+"  ");
                if(pop.rchild!=null){
                    bitree = pop.rchild;
                }
            }
        }
        System.out.println();
    }

    /*
    设置元素层级
     */
    public void setLevel(){
        setLevel1(this);
        setLevel2(this);
    }
    private void setLevel1(Bitree bitree){
        bitree.level=getdepth();
    }
    private void setLevel2(Bitree bitree){
        if(bitree!=null){
            if(bitree.lchild!=null)
                bitree.lchild.level=bitree.level-1;setLevel2(bitree.lchild);
            if(bitree.rchild!=null)
                bitree.rchild.level=bitree.level-1;setLevel2(bitree.rchild);
        }
    }
    /*
    求深度=
     */
    public int getdepth(){
        return getdepth(this);
    }
    public int getdepth(Bitree bitree){
        if(bitree==null){
            return 0;
        }
        else
        {
            int max;
            if(bitree.getdepth(bitree.rchild)>=bitree.getdepth(bitree.lchild))
                max=bitree.getdepth(bitree.rchild);//要用已经实例化的对象
            else
                max=bitree.getdepth(bitree.lchild);
            return max+1;
        }
    }
    /*
    层次遍历
     */
    public void levelIterator(Bitree root){
        if (root == null){
            return;
        }
        Queue<Bitree> queue = new LinkedList<Bitree>();
        Bitree current = null;
        queue.offer(root); // 根节点入队
        int i=1;
        int frontlevel=getdepth();
        while (!queue.isEmpty()){ // 只要队列中有元素，就可以一直执行，非常巧妙的利用了队列的特性

            current = queue.poll(); // 出队队头元素
            if(current.level<frontlevel){
                System.out.println();
                frontlevel=current.level;
            }
            System.out.print("-->" + current.data);

            // 左子树不为空，入队
            if (current.lchild != null)
                queue.offer(current.lchild);
            // 右子树不为空，入队
            if (current.rchild != null)
                queue.offer(current.rchild);


        }
    }
}
/*
解决值传递，差不多是指针
 */
class temp{
    public String string;
    temp(String string){
        this.string=string;
    }
}
