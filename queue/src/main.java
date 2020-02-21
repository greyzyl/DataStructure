public class main {
    public static void main(String[] args){
        myqueue queue1=new myqueue(8);
        for(int i=0;i<=6;i++){
            queue1.add(i);
        }
        System.out.println("入队成功");
        queue1.queuelen();
        for(int i=0;i<=5;i++){
            queue1.pop();
        }
        queue1.queuelen();
        queue1.pop();
    }
}
