class myNode{
    public int data;
    myNode(){}
    myNode(int data){
        this.data=data;
    }
}
public class myqueue {
    public myNode[] mylist;
    public int front=0,last=1;
    myqueue(){
        mylist=new myNode[5];
    }
    myqueue(int num){
        mylist=new myNode[num];
    }
    public void add(int data){
        myNode newNode=new myNode(data);
        mylist[last-1]=newNode;
        last=(last+1)%(mylist.length);
    }
    public int pop(){
        int data;
        data=mylist[front].data;
        mylist[front].data=0;
        front=(front+1)%(mylist.length);
        System.out.println(data);
        return data;
    }
    public int queuelen(){
        int len;
        len=(last-front+mylist.length-1)%mylist.length;
        System.out.println("队列长度为"+len);
        return len;
    }
}
