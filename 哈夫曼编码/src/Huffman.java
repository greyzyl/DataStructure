import java.util.Stack;


public class Huffman {
    public Node root;public Nodes data;

    public Huffman(){}
    public Huffman(Nodes nodes){
        data=nodes;
        root=createtree(nodes);

    }
    /*
    找出未使用过的node当中weight最小的
     */
    public temp select(Nodes roots){
        int i=0;
        Nodes nodes=roots;
        while (nodes.huffmannode[i].flag == 1) {
            i++;
        }//找出第一个为使用过的node，初始化
        Node minnode1 = nodes.huffmannode[i];
        i++;
        while (nodes.huffmannode[i]!=null) {
            if (nodes.huffmannode[i].flag == 1) {
                i++;
                continue;
            }
            if (nodes.huffmannode[i].weight < minnode1.weight) {
                minnode1 = nodes.huffmannode[i];
            }

            i++;
        }
        minnode1.flag=1;
        temp temp=new temp(i,minnode1);
        return temp;
    }

    public Node createtree(Nodes roots) {
        Nodes nodes=roots;
        Node parentnode=null;
        int i=2;//为当前不为空的的最后一个node的位置
        while (i<=nodes.huffmannode.length-3) {//数组从0开始-1，倒数第一个始终为0所以-1，倒数第二个变化时跳出循环-1
           temp temp1= select(roots);
           temp1.minnode.flag=1;
            /*
            找出次小权重
             */

            temp temp2=select(roots);
            temp2.minnode.flag=1;
            Node minnode1=temp1.minnode;
            Node minnode2=temp2.minnode;
            i=temp2.i;
            parentnode = new Node("", (minnode1.weight + minnode2.weight));
            parentnode.lchild = minnode1;
            parentnode.rchild = minnode2;
            parentnode.flag=0;
            minnode1.parent = minnode2.parent = parentnode;
            nodes.huffmannode[i]=parentnode;//最后一个node放入新的parentnode
        }
        return parentnode;
    }
    /*
    从每一个叶子节点开始网上找，左为0右为1，放入栈中倒序输出
     */
    public void haffmancoding(Node root,int num){
        for(int i=0;i<num;i++){
            Stack<Integer> stack=new Stack<Integer>();
            for(Node f=data.huffmannode[i];f.parent!=null;f=f.parent){
                if(f.parent.lchild==f){
                    stack.push(0);
                }
                if(f.parent.rchild==f){
                    stack.push(1);
                }
            }
            System.out.print(data.huffmannode[i].data+"的哈夫曼码为:");
            while (!stack.isEmpty()){
                System.out.print(stack.pop());
            }
            System.out.println();
        }
    }


}
class Node{
    public int weight,flag;
    public String data;
    public Node lchild,rchild,parent;
    public Node(){}
    public Node(String data, int weight){
        this.data=data;
        this.weight=weight;
        flag=0;
        lchild=null;rchild=null;parent=null;
    }
}
class Nodes{
    public Node[] huffmannode;
    public int leafnum;
    public Nodes(){}
    public Nodes(String[] data, int[] weights){
        int i=data.length,j=weights.length;
        if(i!=j){
            System.out.println("输入错误");
            System.exit(0);
        }
        leafnum=i;
        huffmannode= new Node[2 * i];
        for (int n=0;n<i;n++){
            Node node=new Node(data[n],weights[n]);
            huffmannode[n]=node;
        }
    }
}
class  temp{//作用类似引用&
    public Node minnode;

    public int i;
    public temp(int i,Node node){
        this.i=i;
        this.minnode=node;
    }
}
