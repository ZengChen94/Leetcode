public class Solution {
    public String predictPartyVictory(String senate) {
        if (senate.length() == 1){
            if (senate.charAt(0) == 'R')
                return "Radiant";
            else
                return "Dire";
        }
        int index = 0;
        for (index = 0; index < senate.length(); index++) {
            if (senate.charAt(index) != 'R')
                break;
        }
        if (index == senate.length())
            return "Radiant";
        index = 0;
        for (index = 0; index < senate.length(); index++) {
            if (senate.charAt(index) != 'D')
                break;
        }
        if (index == senate.length())
            return "Dire";
        
        LinkedList<Integer> queue1 = new LinkedList<Integer>();
        LinkedList<Integer> queue2 = new LinkedList<Integer>();
        int banR = 0;
        int banD = 0;
        
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R'){
                if (banR == 0) {
                    queue1.add(i);
                    //if (queue2.isEmpty())
                        banD += 1;
                    //else
                    //    queue2.poll();
                }
                else
                    banR -= 1;
            }
            else {
                if (banD == 0) {
                    queue2.add(i);
                    //if (queue1.isEmpty())
                        banR += 1;
                    //else
                    //    queue1.poll();
                }
                else
                    banD -= 1;
            }
        }
        while (banR != 0) {
            if (queue1.isEmpty())
                break;
            else {
                queue1.poll();
                banR--;
            }
        }
        while (banD != 0) {
            if (queue2.isEmpty())
                break;
            else {
                queue2.poll();
                banD--;
            }
        }
        
        String senate2 = "";
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.peek() < queue2.peek()) {
                senate2 += "R";
                queue1.poll();
            }
            else {
                senate2 += "D";
                queue2.poll();
            }
        }
        while (!queue1.isEmpty()) {
            senate2 += "R";
            queue1.poll();
        }
        while (!queue2.isEmpty()) {
            senate2 += "D";
            queue2.poll();
        }
        
        return predictPartyVictory(senate2);
    }
}