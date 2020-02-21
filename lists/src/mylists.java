
public class mylists {
    public static final int LISTS =1;
    public static final int ATOMS =0;
    public Object atom;
    public int tags;
    public mylists hp, tp;
    public static mylists createlists(mylists L,String s){
        System.out.println(s);
        mylists p=null,q=null;
        if (s.equals("()")){
            L=null;
        }
        else{
            L=new mylists();
            if(s.length()==1){L.tags= ATOMS;L.atom= s.charAt(0);}
            else{
                String sub=s.substring(1,s.length()-1);
                L.tags= LISTS;p=L;

                do {
                    Temp temp=new Temp(sub);
                    String hsub=serve(temp);
                    sub=temp.string;
                    p.hp =createlists(p.hp,hsub);
                    q=p;//??
                    if(!sub.isEmpty()){
                        p=new mylists();
                        p.tags=LISTS;
                        q.tp =p;
                    }
                }while (!sub.isEmpty());
                q.tp =null;
            }
        }
        return L;
    }
    public void pr(){
        System.out.print("(");
       pr(this);
       System.out.print(")");
    }
    private void pr(mylists L){
        mylists p = L;
        if (p.atom == null){
            for(;p!=null;p=p.tp){
                 if(p.hp.tags==ATOMS){
                    System.out.print(p.hp.atom);
                }
                else if (p.hp.tags==LISTS){
                    System.out.print("(");
                    pr(p.hp);
                    System.out.print(")");
                }
                if(p.tp!=null){
                    System.out.print(",");
                }
            }
        }
    }

    public static String serve(Temp t) {
        int k = 0, i = 0, n = t.string.length();
        String str = t.string;
        String hsub=null;
        char ch;
        do {
            ch = str.charAt(i);
            i++;
            if (ch == '(') {
                k++;
            } else if (ch == ')') {
                k--;
            }
        } while (i < n && (k != 0 || ch != ','));
        if (i < n) {
            hsub = str.substring(0, i - 1);
            str = str.substring(i);
        }else {
            hsub=str;
            str="";
        }
        t.string=str;
        return hsub;
    }
    public int depth(mylists L){
        int depth=0;
        if(L==null){
            return 1;
        }
        if(L.tags==ATOMS){
            return  0;
        }
        else {
                depth=Math.max(depth(L.hp)+1,depth(L.tp));return depth;
        }

    }
    public static int GetDeepth(mylists L){
        if(L == null) return 1;//空表
        if(L.tags == ATOMS) return 0;//原子
        int  max = 0;  mylists p = L;
        for(;p!=null;p=p.tp){//求同一层的光仪表元素的最大深度
            int tem = GetDeepth(p.hp);
            if(tem > max) max = tem;
        }

        return max+1;
    }
}

class Temp{
    public String string;
    Temp(String string){
        this.string=string;
    }
}
