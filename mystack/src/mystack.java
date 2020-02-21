class myNode{
    public int data;
    public myNode(){}
    public myNode(int data){
        this.data=data;
    }
}
public class mystack {
    public myNode[] mylist;
    int last=0;
    public mystack(){
        mylist=new myNode[5];
    }
    public mystack(int num){
        mylist=new myNode[num];
    }
    public void add(int data){

        if (last>=mylist.length-1){
            System.out.println("栈已满");
            return;
        }
        last++;
        myNode newNode=new myNode(data);
        mylist[last]=newNode;
    }
    public int pop(){
        int data=0;
        try {
            data=mylist[last].data;
        }
        catch (ArrayIndexOutOfBoundsException e1){
            System.out.println("超出栈");
            return 0;
        }
        catch (NullPointerException e2){
        }
        try {
            mylist[last].data=0;
        }
        catch (NullPointerException e3){
            System.out.println("栈已空");
            return 0;
        }
        last--;
        System.out.println(data);
        return data;
    }
    public int stacklen(){
        return last+1;
    }
}
