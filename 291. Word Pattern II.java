/*
     * 291.Word Pattern II
     * 2016-3-13 by Mingyang
     * �����Ŀ��һ�����Ѷȣ�����һ��backtracking boolean����Ŀ�������������һ������Hashmap
     * 1.���ȱ�׼����
     * 2.��ѡ�ķ�Χ����j��ʼ��Ҳ���Ǵ�strδmatch�ĵ�һ���ַ���ʼ��һϵ�е�substring
     * 3.��ǰ��һ�����ı�map����������Ӧ�Ķ����ֱ����map
     * 4.����һ������map�ոռ����ֵȥ��
     * 5.�ر��case���պ������һ����������һ��û���꣬һ��return true����һ��return false
     * ����Ҫbacktracking���еĿ��ܵ�string�����, ����ÿ�����, ���Ƕ���Ҫ��ӵ�hashmap��, 
     */
public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
		HashMap map = new HashMap();
		return dfs(pattern, 0, str, 0, map);
	}
    private boolean dfs(String pattern, int i, String str, int j, HashMap map){
		if(i == pattern.length() && j == str.length()){// ����պ�����. ����true
			return true;
		}
		if(i == pattern.length() || j == str.length()){// ���һ������, ��һ��û��, ����false
			return false;
		}
		char c = pattern.charAt(i); //initialize new value
		for(int k = j; k < str.length(); k++){
			if(map.get(c) == map.get(str.substring(j, k+1))){//���map�е�i��Ӧ��ֵ(������null) �� substring��Ӧ��ֵ��ͬ(Ҳ������null)
				Integer val = (Integer)map.get(c);
				if(val == null){//�����null
					map.put(pattern.charAt(i), i);
				 //��pattern��<char,integer>��map��
					map.put(str.substring(j, k+1), i);
				 //��string��<string,integer>��map��
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
	//ע�ⲻҪ���ˣ����ܼ�������ȥ�õ����ʵ�matchһ��Ҫreturn false
	}
}