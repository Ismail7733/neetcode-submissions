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

            List<String> value = map.get(countList);

            if (value == null) {
                List<String> tempList = new ArrayList<>();
                tempList.add(s);
                map.put(countList, tempList);
            }
            else {
                value.add(s);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (List<Integer> key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;

    }
}