class Solution {
    public int subarrayRanges(int[] arr) {
        int n = arr.length;
        long res = 0; // Use long to prevent overflow during intermediate summation

        // These arrays store the number of elements to the left/right that are
        // strictly (or non-strictly) smaller/larger than the current element.
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        Stack<Integer> stack = new Stack<>();

        // 1. Previous Smaller Element (Left Min)
        // Find how far to the left we can go before hitting a smaller element.
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            leftMin[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        // 2. Next Smaller Element (Right Min)
        // Find how far to the right we can go before hitting a smaller element.
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            rightMin[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        stack.clear();

        // 3. Previous Greater Element (Left Max)
        // Find how far to the left we can go before hitting a larger element.
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            leftMax[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        // 4. Next Greater Element (Right Max)
        // Find how far to the right we can go before hitting a larger element.
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            rightMax[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        // 5. Calculate Total Contribution
        for (int i = 0; i < n; i++) {
            long countMax = (long) leftMax[i] * rightMax[i];
            long countMin = (long) leftMin[i] * rightMin[i];

            // Add contribution of arr[i] as max, subtract contribution as min
            res += (countMax - countMin) * arr[i];
        }

        // The problem guarantees the result fits in a 32-bit integer, so we cast back.
        return (int) res;
    }
}
