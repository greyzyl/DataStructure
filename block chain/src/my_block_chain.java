class myblock{
    public int[] data;
    public int len;
    public myblock next;
    public myblock(){
        data= new int[]{1,2,3,4,5};
    }
    public myblock(int num){
        data=new int[num];
        for(int i=0;i<num;i++){
            data[i]=i;
        }
    }
    public int getLen(){
        len=data.length;
        return len;
    }
}
public class my_block_chain {
    public myblock head=null;
    public myblock newblock;
    public myblock headblock=new myblock(1);
    public void addblock(){
        newblock=new myblock();
        if(head==null){
            head=headblock;
            return;
        }
        myblock target=head;
        while(target.next!=null){
            target=target.next;
        }
        target.next=newblock;
    }
    public  void traverse(){
        myblock target=head.next;
        while(target!=null){
            for (int i=0;i<target.data.length;i++){
                System.out.print(target.data[i]);
            }
            System.out.println();
            target=target.next;
        }
    }
    public void find(int data){
        int row=1,line;
        myblock target=head.next;
        while(target!=null){
            line=1;
            for (int i=0;i<target.data.length;i++){
                if(target.data[i]==data){
                    System.out.println("该元素的行数为"+row+"  列数为"+line);
                }
                line++;
            }
            row++;
            target=target.next;
        }
    }
    public void modify(int datap,int datal){
        myblock target=head.next;
        while(target!=null){
            for (int i=0;i<target.data.length;i++){
                if(target.data[i]==datap){
                    target.data[i]=datal;
                }
            }
            target=target.next;
        }
    }
    public void delete(int data){
        int delnum;
        myblock target=head;
        myblock front=null;
        while(target!=null){
            delnum=0;
            for (int i=0;i<target.data.length;i++){
                if(target.data[i]==data){
                    for( int j=i;j<target.data.length-1;j++) {
                      target.data[j]=target.data[j+1];
                    }
                    target.data[target.data.length-1]=-99;
                    delnum++;
                    i--;
                }
            }
            if(delnum!=0) {
                myblock newtarget = new myblock(target.data.length - delnum);
                for (int i = 0; i < newtarget.data.length; i++) {
                    newtarget.data[i] = target.data[i];
                }
                front.next=newtarget;
                newtarget.next=target.next;
                front=front.next;
                target=target.next;
            }
            else {
                front = target;
                target = target.next;
            }
        }
    }
}
