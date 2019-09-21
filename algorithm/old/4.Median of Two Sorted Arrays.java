class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] A, B;
        int m, n;
        int i, j;
        int low, high;
        double maxLeft, minRight, ans;
        
        if (len1 <= len2) {
            A = nums1;
            m = len1;
            B = nums2;
            n = len2;
        } else {
            A = nums2;
            m = len2;
            B = nums1;
            n = len1;
        }
        
        // Search i using binsearch method
        low = 0;
        high = m;
        do {
            i = (low + high) / 2;
            j = (m + n + 1) / 2 - i;
            
            if (i > 0 && A[i-1] > B[j]) {
                high = i - 1;
            } else if (i < m && B[j-1] > A[i]) {
                low = i + 1;
            } else { // found
                break;
            }
        } while (low <= high);

        // Give answer
        if (i == 0) {
            maxLeft = B[j-1];
        } else if (j == 0) {
            maxLeft = A[i-1];
        } else {
            maxLeft = Math.max(A[i-1], B[j-1]);
        }

        if ((m + n) % 2 == 1) { // m+n is odd
            return maxLeft;
        } // else: m+n is even
        
        if (i == m) {
            minRight = B[j];
        } else if (j == n) {
            minRight = A[i];
        } else {
            minRight = Math.min(A[i], B[j]);
        }

        return (maxLeft + minRight) / 2;
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static String doubleToString(double input) {
        return new DecimalFormat("0.00000").format(input);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums1 = stringToIntegerArray(line);
            line = in.readLine();
            int[] nums2 = stringToIntegerArray(line);
            
            double ret = new Solution().findMedianSortedArrays(nums1, nums2);
            
            String out = doubleToString(ret);
            
            System.out.print(out);
        }
    }
}