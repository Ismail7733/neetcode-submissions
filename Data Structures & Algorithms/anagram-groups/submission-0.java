class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];

            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a'] = count[s.charAt(i) - 'a'] + 1;
            }

            List<Integer> countList = new ArrayList<>();

            for (int i = 0; i < count.length; i++) {
                countList.add(count[i]);
            }

            boolean found = false;

            for (List<Integer> key : map.keySet()) {

                if (found == true) {
                    break;
                }
                
                boolean valid = true;

                for (int i = 0; i < key.size(); i++) {
                    if (key.get(i) != countList.get(i)) {
                        valid = false;
                        break;
                    }
                }

                if (valid == true) {
                    found = true;
                    map.get(key).add(s);
                }
            }

            if (found == false) {
                List<String> tempList = new ArrayList<>();
                tempList.add(s);
                map.put(countList, tempList);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (List<Integer> key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;

    }
}