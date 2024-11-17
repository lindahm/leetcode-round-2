package org.example.medium;

import java.util.*;

/**
 * 355
 * */
public class Twitter {

    private int timestamp;

    private class Tweet {
        int id;
        int timestamp;

        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }

        public int id() {
            return id;
        }

        public int timestamp() {
            return timestamp;
        }
    }

    Map<Integer, Deque<Tweet>> tweetsByUser = new HashMap<>();
    Map<Integer, Set<Integer>> followeesByUser = new HashMap<>();

    public Twitter() {
    }

    private int nextTimestamp() {
        timestamp++;
        return timestamp;
    }

    // Time Complexity O(n)
    public void postTweet(int userId, int tweetId) {
        tweetsByUser.computeIfAbsent(userId, user -> new ArrayDeque<>()).push(new Tweet(tweetId, nextTimestamp()));
        // First tweet ever => make sure she follows himself so he can see her own tweets.
        follow(userId, userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!followeesByUser.containsKey(userId)) {
            return new ArrayList<>(0);
        }
        // Min heap so we can remove the oldest tweets first, i.e they will have
        // a smaller ID number
        PriorityQueue<Tweet> mostRecent10Tweets = new PriorityQueue<>(Comparator.comparingInt(Tweet::timestamp));

        for (Integer followee : followeesByUser.get(userId)) {
            int counter = 1;
            for (Tweet tweet : tweetsByUser.get(followee)) {
                if (counter > 10) {
                    break;
                }
                mostRecent10Tweets.add(tweet);
                if (mostRecent10Tweets.size() > 10) {
                    // remove the oldest tweet & keep the most recent ones
                    mostRecent10Tweets.poll();
                }
                counter++;
            }
        }

        Integer[] newsFeed = new Integer[mostRecent10Tweets.size()];
        // Like heap sort, we continuously poll the min from the heap and add it
        // to the end of the list so we create a sorted list in decreasing order
        // so its is sorted by them most recent first.
        for (int i = Math.min(mostRecent10Tweets.size(), 10) - 1; i >= 0; i--) {
            newsFeed[i] = mostRecent10Tweets.poll().id;
        }

        return List.of(newsFeed);
    }

    // Time Complexity O(n)
    public void follow(int followerId, int followeeId) {
        followeesByUser.computeIfAbsent(followerId, followees -> new HashSet<>()).add(followeeId);
        tweetsByUser.computeIfAbsent(followeeId, tweets -> new ArrayDeque<>());
    }

    // Time Complexity O(n)
    public void unfollow(int followerId, int followeeId) {
        if (followeesByUser.containsKey(followerId)) {
            followeesByUser.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
