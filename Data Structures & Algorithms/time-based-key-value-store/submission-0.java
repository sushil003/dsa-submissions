class TimeMap {
    record Pair(int t, String v){};
    Map<String,List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    public void set(String key, String value, int t) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(t,value));
    }
    public String get(String key, int t) {
        var list = map.get(key);
        if(list == null) return "";
        int l =0;
        int r = list.size()-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(list.get(mid).t() <= t){
                l = mid + 1;
            }else {
                r = mid -1;
            }
        }
        return r >= 0 ? list.get(r).v() : "";
    }
}
