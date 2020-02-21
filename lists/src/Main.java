public class Main {
    public static void main(String[] args){
        String s = "(((a,b),(c,d)),(e,(f,g),h),(z,u))";
        mylists o = null;
        o=o.createlists(o,s);
        System.out.println(o.depth(o));
        o.pr();



}

}