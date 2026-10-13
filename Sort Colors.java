class Solution {
    public void sortColors(int[] a) {
        int low = 0, mid = 0, high = a.length - 1;

        while (mid <= high) {
            if (a[mid] == 0) {
                int t = a[low];
                a[low++] = a[mid];
                a[mid++] = t;
            } else if (a[mid] == 2) {
                int t = a[mid];
                a[mid] = a[high];
                a[high--] = t;
            } else {
                mid++;
            }
        }
    }
}
