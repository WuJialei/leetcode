import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 */

// @lc code=start
class Twitter {

    public class Message{
        int userId;
        int tweetId;
        public Message(int a, int b) {
            userId = a;
            tweetId = b;
        }
    }

    HashMap<Integer, List<Integer>> map;
    List<Message> mess;


    /** Initialize your data structure here. */
    public Twitter() {
        map = new HashMap<Integer, List<Integer>>();
        mess = new ArrayList<Message>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        mess.add(new Message(userId, tweetId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<Integer>();
        int cnt = 0;
        int index = mess.size() - 1;
        if (!map.containsKey(userId)) {
            map.put(userId, new ArrayList<Integer>());
            map.get(userId).add(userId);
        }
        while (cnt < 10 && index >= 0) {
            if (map.get(userId).contains(mess.get(index).userId)) {
                ans.add(mess.get(index).tweetId);
                ++cnt;
            }
            --index;
        }
        return ans;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)) {
            map.put(followerId, new ArrayList<Integer>());
            map.get(followerId).add(followerId);
        }
        if (!map.containsKey(followeeId)) {
            map.put(followeeId, new ArrayList<Integer>());
            map.get(followeeId).add(followeeId);
        }
        map.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (map.containsKey(followerId)) {
            for (int i = 0; i < map.get(followerId).size(); ++i) {
                if (map.get(followerId).get(i) == followeeId) {
                    map.get(followerId).remove(i);
                    break;
                }
            }
        } else {
            map.put(followerId, new ArrayList<Integer>());
            map.get(followerId).add(followerId);
        }
        /*
        if (!map.containsKey(followeeId)) {
            map.put(followeeId, new ArrayList<Integer>());
            map.get(followeeId).add(followeeId);
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
// @lc code=end

