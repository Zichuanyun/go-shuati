class Solution(object):
    def minSwapsCouples(self, row):
        """
        :type row: List[int]
        :rtype: int
        """
        seat,sit = {},{}
        for i in range(len(row)):
            seat[row[i]] = i
            sit[i] = row[i]
            
        for i in range(len(row)/2):
            p = row[2*i]
            partner = p+1 if p%2==0 else p-1
            if row[2*i+1]==partner:
                # Lovers go home together
                del seat[row[2*i]], seat[row[2*i+1]]
        
        ans = 0
        while len(seat) > 0:
            ans += 1
            p, sp = seat.items()[0]
            partner = p+1 if p%2==0 else p-1
            side = sp+1 if sp%2==0 else sp-1
            pside = sit[side]
            # move partner to p's side
            seat[pside], seat[partner] = seat[partner], seat[pside]
            sit[seat[partner]] = partner
            sit[seat[pside]] = pside
            del seat[p], seat[partner]
            _sp = seat[pside]
            _partner = pside+1 if pside%2==0 else pside-1
            _side = _sp+1 if _sp%2==0 else _sp-1
            if seat[_partner] == _side:
                del seat[pside], seat[_partner]
            
        return ans