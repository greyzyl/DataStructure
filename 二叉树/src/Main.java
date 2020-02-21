import java.util.Scanner;
import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        String str="12#43####";
        temp temp=new temp(str);
        Bitree mytree=new Bitree(temp);
        mytree.ltraverse1();
        System.out.println();
        mytree.ltraverse2(mytree);
        mytree.levelIterator(mytree);
    }
}
