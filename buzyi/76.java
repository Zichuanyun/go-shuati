class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> freqT = new HashMap<>();
        
        for(int i=0; i< t.length(); i++){
           freqT.put(t.charAt(i),freqT.getOrDefault(t.charAt(i),0)+1);
        }
        
         Map<Character,Integer> freqS = new HashMap<>();
        int start = 0;
        String result = "";
        int count = 0;
        
        for(int  i=0; i< s.length(); i++){
            char cI = s.charAt(i);
            
            if(freqT.containsKey(cI)){
               freqS.put(cI,freqS.getOrDefault(cI,0)+1);
                
               if(freqT.get(cI) >= freqS.get(cI)){
                   count++;
               }
               
              if(count == t.length()){
                  char cS = s.charAt(start);
                  while(!(freqT.containsKey(cS)
                          && freqT.get(cS).equals(freqS.get(cS)))){
                      if(freqT.containsKey(cS)){
                      freqS.put(cS,freqS.get(cS)-1);
                      }
                      start++;
                      cS = s.charAt(start);
                  }
                  if(result.equals("")||result.length() > i-start+1){
                      result = s.substring(start,i+1);
                  }
              }
            }
        }
        return result;
    }
}
