// Forward declaration of the knows API.
bool knows(int a, int b);

class Solution {
public:
    int findCelebrity(int n) {
        int cand = 0;
        for(int i = 1; i < n; i++) {
            if(knows(cand, i)) cand = i;
        }
        for(int i = 0; i < cand; i++) if(knows(cand, i)) return -1;
        for(int i = 0; i < n; i++) {
            if(i == cand) continue;
            if(!knows(i, cand)) return -1;
        }
        return cand;
    }
};
