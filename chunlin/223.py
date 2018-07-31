class Solution(object):
    def computeArea(self, A, B, C, D, E, F, G, H):
        """
        :type A: int
        :type B: int
        :type C: int
        :type D: int
        :type E: int
        :type F: int
        :type G: int
        :type H: int
        :rtype: int
        """
        x_axis = list(set([A, C, E, G]))
        y_axis = list(set([B, D, F, H]))
        x_axis.sort()
        y_axis.sort()
        point_idx = set()
        xa_idx = x_axis.index(A)
        yb_idx = y_axis.index(B)
        xc_idx = x_axis.index(C)
        yd_idx = y_axis.index(D)
        for i in range(xa_idx, xc_idx):
            for j in range(yb_idx, yd_idx):
                point_idx.add((i, j))
        xe_idx = x_axis.index(E)
        yf_idx = y_axis.index(F)
        xg_idx = x_axis.index(G)
        yh_idx = y_axis.index(H)
        for i in range(xe_idx, xg_idx):
            for j in range(yf_idx, yh_idx):
                point_idx.add((i, j))
        res = 0
        for (x, y) in point_idx:
            res += (x_axis[x + 1] - x_axis[x]) * (y_axis[y + 1] - y_axis[y])
            
        return res
