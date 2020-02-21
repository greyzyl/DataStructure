public class Main {
    public static void main(String[] args) {
        String[] datas={"5","29","7","8","14","23","3","11"};
        int[] weights={5,29,7,8,14,23,3,11};
        Nodes nodes=new Nodes(datas,weights);

        Huffman mytree=new Huffman(nodes);
        mytree.haffmancoding(mytree.root,mytree.data.leafnum);
    }
}
