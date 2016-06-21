public class Main {
/*
*                6
*          4             10
*      3        5      8
* 0                  7
* sum: 6, 19, 20, 17, 9 (corner case)
*/
    public static void main(String[] args) {
        BST six = new BST();
        six.setValue(5);

        BST four = new BST();
        four.setValue(4);

        BST three = new BST();
        three.setValue(3);

        BST five = new BST();
        five.setValue(5);

        BST zero = new BST();
        zero.setValue(1);

        BST ten = new BST();
        ten.setValue(10);

        BST eight = new BST();
        eight.setValue(8);

        BST seven = new BST();
        seven.setValue(7);

        six.setLeftNode(four);
        six.setRightNode(ten);
        six.setParent(null);

        four.setLeftNode(three);
        four.setRightNode(five);
        four.setParent(six);

        three.setLeftNode(zero);
        three.setRightNode(null);
        three.setParent(four);

        zero.setLeftNode(null);
        zero.setRightNode(null);
        zero.setParent(three);

        five.setParent(four);
        five.setLeftNode(null);
        five.setRightNode(null);

        ten.setLeftNode(eight);
        ten.setRightNode(null);
        ten.setParent(six);

        eight.setLeftNode(seven);
        eight.setRightNode(null);
        eight.setParent(ten);

        seven.setRightNode(null);
        seven.setLeftNode(null);
        seven.setParent(eight);

        String ans = findSumInNodes(six, 10);
        System.out.println(ans);
    }

    public static String findSumInNodes(BST root, int sum) {

        // find if the sum is possible with the current BST
        BST maxNode = getMaxNode(root);
        BST secondMaxNode;
        if (maxNode.getRightNode() != null) {
            secondMaxNode = getMaxNode(maxNode.getRightNode());
        } else  if (maxNode.getLeftNode() != null){
            secondMaxNode = getMaxNode(maxNode.getLeftNode());
        } else {
            secondMaxNode = maxNode.getParent();
        }

        int maxSumPossible = maxNode.getValue() + secondMaxNode.getValue();

        if (sum >  maxSumPossible) {
            return "Not Present";
        }

        if (sum == maxSumPossible) {
            return maxNode.getValue() + " + " + secondMaxNode.getValue();
        }

        // find the leaf element to start which
        boolean parseLeft = false;
        BST leftMostLeaf = root;
        BST current = root;

        // Check the right subtree
        if (sum > root.getValue()) {
            current = root.getRightNode();
            leftMostLeaf = getLeftMostLeaf(current);
        }

        // Check left subtree
        if (sum <= root.getValue() || sum <= leftMostLeaf.getValue()) {
            current = root.getLeftNode();
            leftMostLeaf = getLeftMostLeaf(current);
            parseLeft = true;
        }

        // if sum is less than the min element in the tree then its not possible to construct
        if (sum < leftMostLeaf.getValue()) {
            return "Not Present";
        }

        // if you are in the right subtree or haven't parsed left
        current = leftMostLeaf;
        while (current.getValue() < sum || !parseLeft)  {
            if (current.getValue() >= sum && !parseLeft && current != root) {
                parseLeft = true;
                current = getLeftMostLeaf(root);
            }

            int remainder = sum - current.getValue();
            // Search for the remainder


            if (!isElementPresent(remainder, root)) {
                if (current.getRightNode() != null) {
                    current = current.getRightNode();
                } else if (current.getParent() != null) {
                    current = current.getParent();
                }
            } else {
                return current.getValue() + " + " + remainder;
            }

        }
        return "Not Present";

    }

    private static boolean isElementPresent(int value, BST root) {
        BST current = root;
        while (current != null) {
            if (current.getValue() == value) {
                return true;
            } else if (value <= current.getValue()) {
                current = current.getLeftNode();
            } else {
                current = current.getRightNode();
            }
        }
        return false;
    }

    public static BST getLeftMostLeaf (BST current) {
        while (!current.isLeaf()) {
            if (current.getLeftNode() != null) {
                current = current.getLeftNode();
            } else  {
                current = current.getRightNode();
            }
        }
        return current;
    }

    public static BST getMaxNode (BST current) {
        while (!current.isLeaf()) {
            if (current.getRightNode() != null) {
                current = current.getRightNode();
            } else  {
                return current;
            }
        }
        return current;
    }

}

