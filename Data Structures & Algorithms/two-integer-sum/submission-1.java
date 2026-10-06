class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int missingValue = target - value;

            boolean missingValueExists = (map.get(missingValue) != null);

            if (missingValueExists) {
                int[] result = {map.get(missingValue), i};
                return result;
            }
            else {
                map.put(value, i);
            }
        }
        return null;
    }
}
