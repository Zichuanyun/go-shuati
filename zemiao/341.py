# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger(object):
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """

class NestedIterator(object):

    def __init__(self, nestedList):
        """
        Initialize your data structure here.
        :type nestedList: List[NestedInteger]
        """
        self.stack = []
        self.outerList = nestedList
        self.outerIndex = 0
        self.currentList = None
        self.index = 0

    def next(self):
        """
        :rtype: int
        """
        res = 0
        if self.currentList.isInteger():
            res = self.currentList.getInteger()
        else:
            res = self.currentList.getList()[self.index].getInteger()
        self.index += 1
        return res

    def hasNext(self):
        """
        :rtype: bool
        """
        while not self.currentListHasNext():
            if self.outerIndex == len(self.outerList):
                return False
            self.currentList, self.index = self.outerList[self.outerIndex], 0
            self.outerIndex += 1
        return True
        
    def currentListHasNext(self):
        if not self.currentList:
            return False
        if self.currentList.isInteger():
            if self.index == 0:
                return True
            else:
                return self.moveToNextInCurrentList()
        else:
            currentNested = self.currentList.getList()
            if self.index == len(currentNested):
                return self.moveToNextInCurrentList()
            if not currentNested[self.index].isInteger():
                self.stack.append((self.currentList, self.index))
                self.currentList = currentNested[self.index]
                self.index = 0
                return self.currentListHasNext()
            return True
        
    def moveToNextInCurrentList(self):
        if not self.stack:
            return False
        self.currentList, self.index = self.stack.pop()
        self.index += 1
        return self.currentListHasNext()

# Your NestedIterator object will be instantiated and called as such:
# i, v = NestedIterator(nestedList), []
# while i.hasNext(): v.append(i.next())