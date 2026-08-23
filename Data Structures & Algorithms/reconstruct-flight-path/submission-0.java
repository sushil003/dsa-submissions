class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> route = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<String>()).offer(ticket.get(1));
        }
        visit("JFK");
        return route;
    }

    private void visit(String airport) {
        while (map.containsKey(airport) && !map.get(airport).isEmpty()) {
            visit(map.get(airport).poll());
        }
        route.add(0, airport);
    }
}