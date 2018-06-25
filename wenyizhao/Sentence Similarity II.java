class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        HashMap<String, String> roots = new HashMap<>();
        HashMap<String, Integer> size = new HashMap<>();
        
        //Construct union find graph
        for(String[] pair : pairs){
            String u = pair[0];
            String v = pair[1];
            
            //start from root it by itself, size equals 1
            if(!roots.containsKey(u)) roots.put(u, u);
            if(!roots.containsKey(v)) roots.put(v, v);
            if(!size.containsKey(u)) size.put(u, 1);
            if(!size.containsKey(v)) size.put(v, 1);
            String pU = find(roots, u);
            String pV = find(roots, v);
            
            //circle
            if(pU == pV){
                //do something
                continue;
            }
            
            //merge the smaller root to the bigger root
            if(size.get(pV)>size.get(pU)){
                String tmp = pV;
                pV= pU;
                pU = tmp;
            }
            roots.put(pV,pU);
            size.put(pU, size.get(pU)+ size.get(pV));
        }
        
        if(words1.length!=words2.length){
            return false;
        } else{
            for(int i = 0; i < words1.length; i ++){
                String word1 = words1[i];
                String word2 = words2[i];
                if(word1.equals(word2)) continue;
                else if (find(roots, word1).equals(find(roots, word2))) continue;
                else return false;
            }
            return true;
        }
    }
    private String find(HashMap<String, String> map, String str){
        while(!map.getOrDefault(str, str).equals(str)){
            map.put(map.get(str), map.get(map.get(str)));
            str = map.get(str);
        }
        return str;
    }
}
