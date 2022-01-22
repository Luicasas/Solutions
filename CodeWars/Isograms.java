class Solution {
    public boolean isIsogram(String str) {
        LinkedHashSet<Character> treeSet = new LinkedHashSet<>();
        char[] chars = str.toLowerCase().toCharArray();
        for (char character : chars) {
            treeSet.add(character);
        }
        String result = treeSet.toString();
        System.out.println(result);
        System.out.println(Arrays.toString(chars));
        return result.equals(Arrays.toString(chars));
    }
}
