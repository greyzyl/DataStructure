package 数学工具;
public class Quicksort {
    public static int[] datas;

    public Quicksort() {
    }

    public Quicksort(int[] datas) {
        this.datas = datas;
    }

    public static int findpivot(int l, int r) {
        int left = l, right = r;
        int pivot = left;
        left = left;
        while (left < right) {
            for (right = right; datas[right] >= datas[pivot] && left < right; right--) {
            }
            for (left = left; datas[left] <= datas[pivot] && left < right; left++) {
            }
            if (left < right) {
                int s = datas[left];
                datas[left] = datas[right];
                datas[right] = s;
            }
        }
        int c = datas[left];
        datas[left] = datas[pivot];
        datas[pivot] = c;
        pivot = left;
        return pivot;
    }

    public static int[] qsort(int[] datas, int left, int right) {
        Quicksort.datas = datas;
        if (left < right) {
            int pivot = findpivot(left, right);
            qsort(datas, left, pivot - 1);
            qsort(datas, pivot + 1, right);
        }
        return datas;

    }
    public static int[] quicksort(int[] datas){
        datas=qsort(datas,0,datas.length-1);
        return datas;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, 2, 8};
        System.out.println(arr.length);
        arr = Quicksort.quicksort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }
}

