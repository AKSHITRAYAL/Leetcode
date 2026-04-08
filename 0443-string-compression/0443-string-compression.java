class Solution {
    public int compress(char[] chars) {
        int write = 0, read = 0, n = chars.length;

        while (read < n) {
            char curr = chars[read];
            int count = 0;

            while (read < n && chars[read] == curr) {
                read++;
                count++;
            }

            chars[write++] = curr;

            if (count > 1) {
                int start = write;
                while (count > 0) {
                    chars[write++] = (char) ('0' + count % 10);
                    count /= 10;
                }
                reverse(chars, start, write - 1);
            }
        }
        return write;
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
