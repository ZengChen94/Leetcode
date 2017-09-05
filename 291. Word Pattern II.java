/*
     * 291.Word Pattern II
     * 2016-3-13 by Mingyang
     * 这道题目有一定的难度，又是一个backtracking boolean的题目，不过这里多了一个参数Hashmap
     * 1.长度标准：无
     * 2.可选的范围：从j开始，也就是从str未match的第一个字符开始的一系列的substring
     * 3.往前走一步：改变map，将两个对应的东西分别放入map
     * 4.后退一步：把map刚刚加入的值去掉
     * 5.特别的case：刚好搜完和一个搜完了另一个没搜完，一个return true。另一个return false
     * 我们要backtracking所有的可能的string的组合, 对于每个组合, 我们都需要添加到hashmap中, 
     */
public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
		HashMap map = new HashMap();
		return dfs(pattern, 0, str, 0, map);
	}
    private boolean dfs(String pattern, int i, String str, int j, HashMap map){
		if(i == pattern.length() && j == str.length()){// 如果刚好搜完. 返回true
			return true;
		}
		if(i == pattern.length() || j == str.length()){// 如果一个完了, 另一个没完, 返回false
			return false;
		}
		char c = pattern.charAt(i); //initialize new value
		for(int k = j; k < str.length(); k++){
			if(map.get(c) == map.get(str.substring(j, k+1))){//如果map中的i对应的值(可以是null) 和 substring对应的值相同(也可以是null)
				Integer val = (Integer)map.get(c);
				if(val == null){//如果是null
					map.put(pattern.charAt(i), i);
				 //把pattern的<char,integer>放map中
					map.put(str.substring(j, k+1), i);
				 //把string的<string,integer>放map中
				}
				if(dfs(pattern, i+1, str, k+1, map)){//dfs
					return true;
				}
				if(val == null){// backtracking
					map.remove(pattern.charAt(i));
					map.remove(str.substring(j, k+1));
				}
			}
		}
		return false;
	//注意不要忘了，不能继续走下去拿到合适的match一定要return false
	}
}