class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> accountToName = new HashMap<>(), parent = new HashMap<>();
        for(List<String> entry : accounts) {
            String name = entry.get(0);
            for(int i = 1; i < entry.size(); ++i) {
                if(!accountToName.containsKey(entry.get(i))) {                    
                    accountToName.put(entry.get(i), name);
                    parent.put(entry.get(i), entry.get(i));
                }                
                union(parent, entry.get(1), entry.get(i));
            }
        }
        Map<String, List<String>> map = new HashMap<>();
        for(String account : parent.keySet()) {
            String p = find(parent, account);
            if(!map.containsKey(p)) {
                map.put(p, new ArrayList<>());
            }
            List<String> list = map.get(p);
            list.add(account);
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> list : map.values()) {
            Collections.sort(list);
            list.add(0, accountToName.get(list.get(0)));
            res.add(list);
        }
        return res;
    }
    
    private void union(Map<String, String> parent, String account1, String account2) {
        String ancestor1 = find(parent, account1);
        String ancestor2 = find(parent, account2);
        if(!ancestor1.equals(ancestor2)) {
            parent.put(ancestor2, ancestor1);
        }
    }
    
    private String find(Map<String, String> parent, String account) {
        while(account != parent.get(account)) {
            parent.put(account, parent.get(parent.get(account)));
            account = parent.get(parent.get(account));
        }
        return account;
    }
}
