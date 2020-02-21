public class Main {
    public static void main(String[] args) {
        int[] datas={10,5,15,9,7};
        SortTree mytree=new SortTree(datas[0]);
        mytree.modele(10,15);
        for(int i=1;i<datas.length;i++){
                mytree.addele(datas[i]);
        }
        mytree.traverse();
        mytree.searchele(10);
        mytree.delele(10);
        mytree.modele(15,10);
        int a=0;


    }
}
