import org.example.medium.LetterCombinationOfAPhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class LetterCombinationOfPhoneNumberTest {

    @Test
    void nonEmptyInput_shouldReturnAllCombination() {
        final String[] expected = new String[]{"ja", "jb", "jc", "ka", "kb", "kc", "la", "lb", "lc"};

        List<String> result = new LetterCombinationOfAPhoneNumber().letterCombinations("52");
        result.sort(Comparator.naturalOrder());

        for (int i = 0; i < result.size(); i++) {
            Assertions.assertEquals(expected[i], result.get(i));
        }
    }

    @Test
    void emptyInput_shouldReturnEmptyList() {
        List<String> result = new LetterCombinationOfAPhoneNumber().letterCombinations("");
        Assertions.assertTrue(result.isEmpty());
    }
}
