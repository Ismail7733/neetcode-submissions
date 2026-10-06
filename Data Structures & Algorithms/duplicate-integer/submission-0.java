class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> set = new HashMap<>();

        for (int i : nums) {
            Integer value = set.get(i);

            boolean duplicate = !(value == null);

            if (duplicate) {
                return true;
            }
            else {
                set.put(i, 1);
            }
        }
        return false;
    }
}