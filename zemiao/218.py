from heapq import heappush, heappop

class Solution:
    def getSkyline(self, buildings):
        '''NOTE
         1. breaks up left/right walls, and sort all walls from left to right
         2. use a heapq to update alive buildings and get the latest highest contour
         3. invalidate dropped building in a heap is hard, so do it lazily by only invalidating latest highest.
         '''
        if not buildings:
            return []

        walls=[]
        for i in range(len(buildings)):
            b=buildings[i]
            if b[2]==0:
                continue
            walls.append((b[0], b[2],  i))   # left wall
            walls.append((b[1], -b[2], i))   # right wall
        walls=sorted(walls)                  # sort by walls' coordinates
        
        ans=[]
        h=[]
        invalid=set()
        highest=0                           # last highest skyline
        for i in range(len(walls)):         
            w=walls[i]
            if w[1] >0:                     # if left wall, heappush and therefore may update h[0][0]
                heappush(h,(-w[1], w[2]))    
            else :                          # if right wall
                invalid.add(w[2])           # lazy building remove, only when it is highest
                while h and (h[0][1] in invalid):
                    heappop(h)
										
            # when mutiple walls have the same coordinate, wait until all are processed        
            if i+1<len(walls) and w[0] == walls[i+1][0]:       
                continue
								
            if not h:        
                ans.append([w[0], 0])
                highest=0
            elif highest != h[0][0]:
                # new added left wall became the new heap top, so it's higher than old highest
                # OR
                # new removed right wall removed old heap top, so second highest is exposed
                # EITHER WAY, h[0][0] is the new latest highest
                ans.append([w[0], -h[0][0]])
                highest=h[0][0]
                
        return(ans)