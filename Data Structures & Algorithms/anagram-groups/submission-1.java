class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            if (!result.containsKey(sortedWord)) {
                result.put(sortedWord, new ArrayList<>());
            }
            result.get(sortedWord).add(str);

        }

        return new ArrayList<>(result.values());

    }
}
