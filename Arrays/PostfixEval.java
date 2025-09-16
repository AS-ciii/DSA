class Solution {
    public int evaluatePostfix(String[] arr) {
        // code here
    
        Stack<Integer> stack = new Stack<>();

        for (String token : arr) {
            if (isOperator(token)) {
                int b = stack.pop(); 
                int a = stack.pop();
                int result = applyOperator(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") 
            || s.equals("/") || s.equals("^");
    }

    private static int applyOperator(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return Math.floorDiv(a, b); 
            case "^": return (int)Math.pow(a, b);
        }
        throw new IllegalArgumentException("Invalid operator: " + op);
    }
}

