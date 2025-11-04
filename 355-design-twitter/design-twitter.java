class Tweet implements Comparable<Tweet>{
    int time;
    int tweetid;
    Tweet(int time, int tweetid)
    {
        this.time=time;
        this.tweetid=tweetid;
    }
    public int compareTo(Tweet that)
    {
       return that.time-this.time;
    }
}
class User{
    int userid;
    HashSet<Integer> followers;
    List<Tweet> tweets;
    User(int userid)
    {
        this.userid=userid;
        followers=new HashSet<>();
        tweets=new LinkedList<>();
    }
    public void addTweet(Tweet t)
    {
        tweets.add(0, t);
    }
    public void addFollower(int followerid)
    {
        followers.add(followerid);
    }
    public void removeFollower(int followerid)
    {
        followers.remove(followerid);
    }

}
class Twitter {
    HashMap<Integer, User> usermap;
    int timecounter;
    public Twitter() {
        usermap=new HashMap<>();
        timecounter=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        timecounter++;
        if(!usermap.containsKey(userId)) usermap.put(userId, new User(userId));
        User user=usermap.get(userId);
        user.addTweet(new Tweet(timecounter, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!usermap.containsKey(userId)) return new ArrayList<>();
        PriorityQueue<Tweet> pq=new PriorityQueue<>();
        User user=usermap.get(userId);
        
        for(int followerid:user.followers)
        {
            int count=0;
            if(usermap.containsKey(followerid))
            {
                for(Tweet tweet:usermap.get(followerid).tweets)
                {
                    pq.offer(tweet);
                    count++;
                    if(count>10)
                    break;
                }
            }
        }
        int count=0;
        for(Tweet tweet:user.tweets)
        {
            pq.offer(tweet);
            count++;
            if (count > 10) {
                break;
            }
        }
        int index=0;
        List<Integer> res=new ArrayList<>();
        while(!pq.isEmpty() && index<10)
        {
            Tweet tweet=pq.poll();
            res.add(tweet.tweetid);
            index++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!usermap.containsKey(followerId)) {
            usermap.put(followerId, new User(followerId));
        }
        if (!usermap.containsKey(followeeId)) {
            usermap.put(followeeId, new User(followeeId));
        }
        User user=usermap.get(followerId);
        user.addFollower(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!usermap.containsKey(followerId) || !usermap.containsKey(followeeId)) {
            return;
        }
        User user = usermap.get(followerId);
        user.removeFollower(followeeId);
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