/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int minTime(Node root, int target) {
        // code here
        // Step 1: Build parent map
        Map<Node, Node> parent = new HashMap<>();
        Node targetNode = buildParentMap(root, parent, target);

        // Step 2: BFS from target node
        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        q.add(targetNode);
        visited.add(targetNode);

        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean burned = false;

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                // spread to left
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.add(curr.left);
                    burned = true;
                }
                
                // spread to right
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.add(curr.right);
                    burned = true;
                }

                // spread to parent
                if (parent.containsKey(curr) && !visited.contains(parent.get(curr))) {
                    visited.add(parent.get(curr));
                    q.add(parent.get(curr));
                    burned = true;
                }
            }

            if (burned) time++;
        }

        return time;
    }
    
    // Helper to build parent map and find target node
    private Node buildParentMap(Node root, Map<Node, Node> parent, int target) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node targetNode = null;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.data == target) targetNode = curr;

            if (curr.left != null) {
                parent.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                parent.put(curr.right, curr);
                q.add(curr.right);
            }
        }
        return targetNode;
    }
}
