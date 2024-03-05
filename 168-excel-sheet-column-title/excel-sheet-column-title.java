public class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder title = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--; // Adjust for zero-based indexing
            int remainder = columnNumber % 26;
            char letter = (char) ('A' + remainder);
            title.insert(0, letter); // Prepend the character
            columnNumber /= 26;
        }
        return title.toString();
    }
}