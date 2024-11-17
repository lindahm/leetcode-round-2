import org.example.medium.Twitter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.TextWritingException;

public class TwitterTest {

    @Test
    void test() {
        Twitter twitter = new Twitter();

        twitter.postTweet(1, 5);
        System.out.println("--- News Feed ---");
        twitter.getNewsFeed(1).forEach(System.out::println);

        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println("--- News Feed ---");
        twitter.getNewsFeed(1).forEach(System.out::println);

        twitter.unfollow(1, 2);
        System.out.println("--- News Feed ---");
        twitter.getNewsFeed(1).forEach(System.out::println);
    }

    @Test
    void test2() {
        Twitter t = new Twitter();

        t.postTweet(1, 5);
        t.postTweet(1, 3);
        t.postTweet(1, 101);
        t.postTweet(1, 13);
        t.postTweet(1,10);
        t.postTweet(1, 2);
        t.postTweet(1, 94);
        t.postTweet(1, 505);
        t.postTweet(1, 333);
        t.postTweet(1, 22);
        t.postTweet(1, 11);
        System.out.println("--- News Feed ---");
        t.getNewsFeed(1).forEach(System.out::println);
    }
}
