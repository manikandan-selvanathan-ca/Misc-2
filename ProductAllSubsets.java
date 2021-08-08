
public class ProductAllSubsets {

    // Each number added with one which will be multiply with current sum.
    //TC: O(N) Where N is number of elements in the given array.
    //SC: O(1) Not using any extra space.
    public int productAllSubsetsOptimal(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int result = 1;
        for (int i = 0; i < arr.length; i++) {
            result = result * (arr[i] + 1);
        }
        return result - 1;
    }


    //Finding all subsets
    //TC: O(2^N) where N is number of elements in the given array.
    //SC: O(2^N) where N is number of elements in the given array. Recursive call stack.
    public int productAllSubsetsRecursive(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        return helper(arr, 0, 1) -1;
    }

    private int helper(int[] array, int index, int product) {
        // base
        if (index > array.length)
            return product;

        int result = product;
        // logic
        for (int i = index; i < array.length; i++) {
            System.out.println("The current element: "+array[i]);
            result += helper(array, i + 1, product * array[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        ProductAllSubsets productAllSubsets = new ProductAllSubsets();
        int result = productAllSubsets.productAllSubsetsRecursive(new int[] { 1, 2, 3, 4 });
        System.out.println("The result: " + result);
    }
}
