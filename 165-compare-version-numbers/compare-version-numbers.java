class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\."); 
        String[] v2 = version2.split("\\."); 
        int i = 0 , j = 0;
        while(i < v1.length && j < v2.length){
            int p = 0, q = 0;
            while(p < v1[i].length()){
                if(v1[i].charAt(p) == '0'){
                    v1[i] = v1[i].substring(1);
                } else {
                    break; // Exit the loop when non-zero digit is found
                }
            }
        
            while(q < v2[j].length()){
                if(v2[j].charAt(q) == '0'){
                    v2[j] = v2[j].substring(1);
                } else {
                    break; // Exit the loop when non-zero digit is found
                }
            }
            // Check if revision strings are empty before parsing
            int n1 = v1[i].isEmpty() ? 0 : Integer.parseInt(v1[i]);
            int n2 = v2[j].isEmpty() ? 0 : Integer.parseInt(v2[j]);
            if(n1 > n2){
                return 1;
            }
            else if(n1 < n2) return -1;
            else {
                i++;
                j++;
            }
        
        }
        // If one version has more parts, check if they are all zeros
        while (i < v1.length) {
            if (!v1[i].isEmpty() && Integer.parseInt(v1[i]) > 0) return 1;
            i++;
        }
        while (j < v2.length) {
            if (!v2[j].isEmpty() && Integer.parseInt(v2[j]) > 0) return -1;
            j++;
        }
        return 0;
    }
}
