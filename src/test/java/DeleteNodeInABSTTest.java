import org.example.TreeNode;
import org.example.medium.DeleteNodeInABST;
import org.example.medium.DeleteNodeInABSTRecursive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DeleteNodeInABSTTest {


    @Test
    void name() {

        TreeNode n40 = new TreeNode(40);
        TreeNode n30 = new TreeNode(30, null, n40);
        TreeNode n80 = new TreeNode(80);
        TreeNode n60 = new TreeNode(60);
        TreeNode n70 = new TreeNode(70, n60, n80);
        TreeNode root = new TreeNode(50, n30, n70);
        TreeNode result = new DeleteNodeInABST().deleteNode(root, 50);
        Integer[] expected = new Integer[]{60, 30, 40, 70, 80};
        List<TreeNode> actual = collectValues(expected, result);

        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i], actual.get(i).val);
        }


    }

    private List<TreeNode> collectValues(Integer[] expected, TreeNode actual) {
        List<TreeNode> actualValues = new ArrayList<>(expected.length);
        if (actual != null) {
            actualValues.add(actual);
            actualValues.addAll(collectValues(expected, actual.left));
            actualValues.addAll(collectValues(expected, actual.right));
        }
        return actualValues;
    }

    @Test
    void t2() {
        TreeNode n2 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, n2, n4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n6 = new TreeNode(6, null, n7);
        TreeNode root = new TreeNode(5, n3, n6);

        TreeNode r2 = new DeleteNodeInABSTRecursive().deleteNode(root, 3);
    }
}
