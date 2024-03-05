class Solution {
    public void reverseString(char[] s) {
        // Iterate from the beginning (i) and end (j) of the array towards the middle.
        for (int i = 0, j = s.length - 1; i < s.length / 2; i++, j--) {
            // Use a temporary variable (temp) to store the character at index i.
            char temp = s[i];

            // Replace the character at index i with the character at index j.
            s[i] = s[j];

            // Replace the character at index j with the character in the temporary variable (temp).
            s[j] = temp;
        } 
        // At this point, the character array 's' contains the reversed string.
    }
}