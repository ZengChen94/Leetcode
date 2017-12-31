class Solution(object):
    def pyramidTransition(self, bottom, allowed):
        """
        :type bottom: str
        :type allowed: List[str]
        :rtype: bool
        """
        hashmap = dict()
        for triplet in allowed:
            if triplet[:2] not in hashmap:
                hashmap[triplet[:2]] = []
            hashmap[triplet[:2]] += [triplet[2]]

        def dfs(bottom):
            if len(bottom) == 2 and bottom in hashmap:
                return True
            options = []
            for i in range(len(bottom) - 1):
                if bottom[i:i+2] in hashmap:
                    options.append(hashmap[bottom[i:i+2]])
                else:
                    return False
            for bot in itertools.product(*options):
                if dfs(''.join(bot)):
                    return True
            return False
        return dfs(bottom)
        