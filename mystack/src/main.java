public class main {
    public static void main(String[] args){
        mystack mylist=new mystack(6);
        for(int i=0;i<=6;i++){
            mylist.add(i);
        }
        for(int i=0;i<=6;i++){
            mylist.pop();
        }
    }
}
