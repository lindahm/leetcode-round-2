import org.example.medium.LetterCombinationOfAPhoneNumber;
import org.junit.jupiter.api.Test;

public class LetterCombinationOfPhoneNumberTest {
    @Test
    void test() {
        LetterCombinationOfAPhoneNumber generator = new LetterCombinationOfAPhoneNumber();
        generator.letterCombinations("52").forEach(System.out::println);
    }
}
