class Solution {
    public boolean isIsogram(String str) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        char[] chars = str.toLowerCase().toCharArray();
        for (char character : chars) {
            set.add(character);
        }
        String result = set.toString();
        System.out.println(result);
        System.out.println(Arrays.toString(chars));
        return result.equals(Arrays.toString(chars));
    }
}
