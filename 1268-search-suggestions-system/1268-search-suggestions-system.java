class Solution {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);

        List<List<String>> ans = new ArrayList<>();

        String prefix = "";

        for (char ch : searchWord.toCharArray()) {

            prefix += ch;

            List<String> list = new ArrayList<>();

            int idx = lowerBound(products, prefix);

            for (int i = idx; i < products.length && list.size() < 3; i++) {

                if (products[i].startsWith(prefix)) {
                    list.add(products[i]);
                } else {
                    break;
                }
            }

            ans.add(list);
        }

        return ans;
    }

    private int lowerBound(String[] products, String target) {

        int left = 0;
        int right = products.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (products[mid].compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}