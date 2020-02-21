public class Main {
    public static void main(String[] args){
        my_block_chain block_chain=new my_block_chain();
        block_chain.addblock();
        block_chain.addblock();
        block_chain.addblock();
        block_chain.traverse();
        block_chain.find(5);
        block_chain.modify(1,4);
        block_chain.traverse();
        block_chain.delete(4);
        block_chain.traverse();
    }
}
