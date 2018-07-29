from collections import defaultdict

class Solution(object):
    def accountsMerge(self, accounts):
        """
        :type accounts: List[List[str]]
        :rtype: List[List[str]]
        """        
        parent, rank = {}, {}
        def find(mail):
          if mail not in parent:
            parent[mail] = mail
            rank[mail] = 1
            
          while mail!=parent[mail]:
            mail = parent[mail]
          return mail
        
        def union(mail1, mail2):
          mail1, mail2 = find(mail1), find(mail2)
          if mail1 == mail2:
            return
          
          if rank[mail1] < rank[mail2]:
            mail1, mail2 = mail2, mail1
          if rank[mail1] == rank[mail2]:
            rank[mail1] += 1
          parent[mail2] = mail1
        
        mapName = {}
        mailSet = set()

        def insert(ac):
          name = ac[0]
          maxRank = -1
          maxRankMail = ac[1]
          for m in ac[1:]:
            mailSet.add(m)
            parent_m = find(m)
            if rank[parent_m] > maxRank:
              maxRank = rank[parent_m]
              maxRankMail = parent_m
              
          mapName[maxRankMail] = name

          # Union all with the max ranked mail.
          for m in ac[1:]:
            union(maxRankMail, m)
        
        for ac in accounts:
          insert(ac)
          
        resMap = defaultdict(set)
        for m in mailSet:
          resMap[find(m)].add(m)
        return [[mapName[m]]+sorted(resMap[m]) for m in resMap]
        