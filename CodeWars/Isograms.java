class Solution {
    public boolean isIsogram(String str) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        char[] chars = str.toLowerCase().toCharArray();
        
        for (char character : chars) {
            set.add(character);
        }
        
        String result = set.toString();
        
        return result.equals(Arrays.toString(chars));
    }
}
