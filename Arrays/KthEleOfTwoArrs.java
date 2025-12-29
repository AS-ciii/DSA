class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
              List<Integer> set = new ArrayList<>();
        for (int i=0;i<a.length;i++) {
            set.add(a[i]);
        }
        for (int i=0;i<b.length;i++) {
            set.add(b[i]);
        }


        Collections.sort(set);

        return set.get(k-1);
    }
}
