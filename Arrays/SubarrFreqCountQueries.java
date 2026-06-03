class Solution {
    
    private int lowerBound(List<Integer> list, int target) {
        int low = 0, high = list.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {

        HashMap<Integer, List<Integer>> mp = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            mp.putIfAbsent(arr[i], new ArrayList<>());
            mp.get(arr[i]).add(i);
        }

        for (int[] q : queries) {
            int start = q[0];
            int end = q[1];
            int target = q[2];

            if (!mp.containsKey(target) || mp.get(target).get(0) > end) {
                res.add(0);
                continue;
            }

            List<Integer> indices = mp.get(target);

            int left = lowerBound(indices, start);
            int right = lowerBound(indices, end + 1);

            res.add(right - left);
        }

        return res;
    }
}
