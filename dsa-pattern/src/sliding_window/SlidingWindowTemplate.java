package sliding_window;

/**
 * Creator : the-wolverine-coder-UjjwalKumar
 **/
public class SlidingWindowTemplate {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int n = arr.length;

        // Check if k is valid
        if (k > n || k <= 0) {
            System.out.println("Invalid window size");
            return;
        }

        // Array to store the maximums of each window
        int[] maxInWindows = new int[n - k + 1];
        int maxIndex = 0;

        // Find the maximum for the first window
        int currentMax = arr[0];
        for (int i = 1; i < k; i++) {
            if (arr[i] > currentMax) {
                currentMax = arr[i];
            }
        }
        maxInWindows[maxIndex++] = currentMax;

        // Slide the window across the array
        for (int i = k; i < n; i++) {
            // If the element going out is the current maximum, we need to find the new maximum
            if (arr[i - k] == currentMax) {
                currentMax = arr[i - k + 1];
                for (int j = i - k + 2; j <= i; j++) {
                    if (arr[j] > currentMax) {
                        currentMax = arr[j];
                    }
                }
            } else if (arr[i] > currentMax) {
                // If the new element is greater than the current maximum, update it
                currentMax = arr[i];
            }
            maxInWindows[maxIndex++] = currentMax;
        }

        // Print the maximums of each window
        for (int max : maxInWindows) {
            System.out.print(max + " ");
        }
    }
}
