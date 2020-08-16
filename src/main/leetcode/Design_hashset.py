class MyHashSet(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 16
        self.current_size = 0
        self.hashfun = lambda x: x % self.size
        self.mymap = [None] * self.size


    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self.hashfun (key)
        if self.mymap[index] != None:
            if key not in self.mymap[index]:
                self.mymap[index].append(key)
                self.current_size += 1
        else:
            self.mymap.insert(index, [key])
            self.current_size += 1
        if self.current_size >= self.size -1:
            self.size *= 2
            self.rehash()

    def rehash(self):
        newmap = [None] * self.size
        for mylist in self.mymap:
            if mylist == None:
                continue
            for key in mylist:
                index = self.hashfun(key)
                if newmap[index] != None:
                    if key not in newmap[index]:
                        newmap[index].append(key)
                else:
                    newmap.insert(index,[key])
        self.mymap = newmap


    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self.hashfun (key)
        if self.mymap[index] != None and key in self.mymap[index]:
            self.mymap[index].remove(key)
            if len(self.mymap[index]) == 0:
                self.mymap[index] = None



    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        index = self.hashfun (key)
        if self.mymap[index] != None:
            return key in self.mymap[index]
        return False



# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
hashSet = MyHashSet();
hashSet.add(1);
hashSet.add(2);
hashSet.contains(1);
hashSet.contains(3);
hashSet.add(2);
hashSet.contains(2);
hashSet.remove(2);
hashSet.contains(2);