import org.example.CommonPrefix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeneralTest {


    @Test
    void test() {
        CommonPrefix common = new CommonPrefix();
        String result = common.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        Assertions.assertEquals(result, "fl");
    }
}
