class Solution {
    public int minInsAndDel(int[] a, int[] b) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < b.length; i++) {
            map.put(b[i], i);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int x : a) {
            if (map.containsKey(x)) {
                list.add(map.get(x));
            }
        }

        ArrayList<Integer> lis = new ArrayList<>();

        for (int x : list) {
            int idx = Collections.binarySearch(lis, x);

            if (idx < 0) {
                idx = -(idx + 1);
            }

            if (idx == lis.size()) {
                lis.add(x);
            } else {
                lis.set(idx, x);
            }
        }

        int common = lis.size();

        return (a.length - common) + (b.length - common);
    }
}
