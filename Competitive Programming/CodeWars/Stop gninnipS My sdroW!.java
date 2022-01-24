class Solution {
    public String spinWords(String sentence) {
        StringTokenizer st = new StringTokenizer(sentence);
        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        while (st.hasMoreTokens()) {
            arrayList.add(st.nextToken());
        }

        for (int i = 0; i < arrayList.size(); i++) {
            String word = arrayList.get(i);
            if (word.length() >= 5) {
                StringBuilder stringBuilder = new StringBuilder(word);
                if (i != arrayList.size() - 1) {
                    result.append(stringBuilder.reverse()).append(" ");
                } else {
                    result.append(stringBuilder.reverse());
                }
            } else {
                if (i != arrayList.size() - 1) {
                    result.append(word).append(" ");
                } else {
                    result.append(word);
                }
            }
        }
      
      return result.toString();
    }
}
