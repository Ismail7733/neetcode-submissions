class Solution {

    public String encode(List<String> strs) {
        String result = new String();

        for (String s : strs) {
            result = result + "#" + s.length() + "#" + s;
        }
        return result;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            // Find the length of the string

            // First the first '#'
            i++;
            int start = i;
            int lengthCount = 0;

            while (str.charAt(i) != '#') {
                i++;
                lengthCount++;
            }

            String sLength = new String();
            for (int k = start; k < i; k++) {
                sLength = sLength + str.charAt(k);
                
            }

            // Move to the second '#'
            i++;
            
            int iLength = Integer.parseInt(sLength);

            String s = new String();

            for (int j = i; j < iLength + i; j++) {
                s = s + str.charAt(j);
            }
            result.add(s);
            i = i + iLength;
        }
        return result;
    }
}
