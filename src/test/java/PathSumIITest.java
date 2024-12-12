import org.example.TreeNode;
import org.example.medium.PathSumII;
import org.junit.jupiter.api.Test;

public class PathSumIITest {
    @Test
    void name() {
        //[5,4,8,11,null,13,4,7,2,null,null,5,1]

        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n11 = new TreeNode(11,  n7, n2);
        TreeNode n4 = new TreeNode(4, n11, null);

        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n4bis = new TreeNode(4, n5, n1);
        TreeNode n13 = new TreeNode(13);
        TreeNode n8 = new TreeNode(8, n13, n4bis);

        TreeNode root = new TreeNode(5, n4, n8);

        new PathSumII().pathSum(root, 22);
    }
}
