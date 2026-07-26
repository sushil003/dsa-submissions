class Twitter {
    private static class Tweet {
        int id, time;
        Tweet next;

        Tweet(int id, int time, Tweet next) {
            this.id = id;
            this.time = time;
            this.next = next;
        }
    }

    private int time;
    private final Map<Integer, Tweet> tweets = new HashMap<>();
    private final Map<Integer, Set<Integer>> follows = new HashMap<>();

    public void postTweet(int userId, int tweetId) {
        tweets.put(userId, new Tweet(tweetId, time++, tweets.get(userId)));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> heap = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));

        addTweet(heap, userId);

        for (int followee : follows.getOrDefault(userId, Collections.emptySet())) {
            addTweet(heap, followee);
        }

        List<Integer> feed = new ArrayList<>(10);

        while (!heap.isEmpty() && feed.size() < 10) {
            Tweet tweet = heap.poll();
            feed.add(tweet.id);

            if (tweet.next != null) {
                heap.offer(tweet.next);
            }
        }

        return feed;
    }

    private void addTweet(PriorityQueue<Tweet> heap, int userId) {
        Tweet tweet = tweets.get(userId);
        if (tweet != null)
            heap.offer(tweet);
    }

    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            follows.computeIfAbsent(followerId, id -> new HashSet<>()).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = follows.get(followerId);
        if (followees != null)
            followees.remove(followeeId);
    }
}