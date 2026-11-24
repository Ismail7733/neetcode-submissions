class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            Integer count = map.get(nums[i]);

            if (count == null) {
                map.put(value, 1);
            }
            else {
                map.put(value, count + 1);
            }
        }

        List<List<Integer>> bucketSort = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            bucketSort.add(new ArrayList<Integer>());
        }

        for (int key : map.keySet()) {
            Integer count = map.get(key);
            bucketSort.get(count-1).add(key);
        }

        int collected = 0;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (collected == k) {
                break;
            }

            List<Integer> bucket = bucketSort.get(i);
            while(!(bucket.isEmpty()) && collected < k) {
                result[collected] = bucket.getLast();
                bucket.removeLast();
                collected++;
            }
        }

        return result;
    }
}
