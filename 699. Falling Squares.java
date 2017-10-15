class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        LinkedList<int[]> segments = new LinkedList<int[]>();//left, right, tall
        LinkedList<Integer> result = new LinkedList<Integer>();
        for (int i = 0; i < positions.length; i++) {
            int left = positions[i][0];
            int right = positions[i][0]+positions[i][1]-1;
            int tall = positions[i][1];
            if (segments.size() == 0) {
                segments.add(new int[]{left, right, tall});
                result.add(tall);
            }
            else {
                int max = tall;
                for (int j = 0; j < segments.size();) {
					int tmpLeft = segments.get(j)[0];
					int tmpRight = segments.get(j)[1];
					int tmpTall = segments.get(j)[2];
                    if (right < tmpLeft || left > tmpRight) {
                        j++;
                        continue;
                    }
                    if (right >= tmpRight && left <= tmpLeft) {
						max = Math.max(tall+tmpTall, max);
                        segments.remove(j);
                    }
                    else if (right < tmpRight && left > tmpLeft) {
						max = Math.max(tall+tmpTall, max);
                        segments.remove(j);
                        segments.add(j, new int[]{tmpLeft, left-1, tmpTall});
                        segments.add(j, new int[]{right+1, tmpRight, tmpTall});
                        j += 2;
                    }
                    else if (right < tmpRight) {
						max = Math.max(tall+tmpTall, max);
                        segments.remove(j);
                        segments.add(j, new int[]{right+1, tmpRight, tmpTall});
                        j += 1;
                    }
                    else if (left > tmpLeft) {
						max = Math.max(tall+tmpTall, max);
                        segments.remove(j);
                        segments.add(j, new int[]{tmpLeft, left-1, tmpTall});
                        j += 1;
                    }
                }
                segments.add(new int[]{left, right, max});
                result.add(Math.max(result.get(result.size()-1), max));
            }
        }
        return result;
    }
}