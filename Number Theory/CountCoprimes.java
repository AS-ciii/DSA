class Solution {
    // Computes the Möbius function up to 'n'
    // mu[i] = 1 if i is a product of even number of distinct primes
    // mu[i] = -1 if i is a product of odd number of distinct primes
    // mu[i] = 0 if i has any squared prime factor (i.e., not square-free)
    void computeMobius(int n, int[] mu) {
        int[] is_prime = new int[n + 1];
        Arrays.fill(is_prime, 1); // Assume all numbers are prime initially
        mu[0] = 0;
        mu[1] = 1; // Base case: mu[1] is always 1

        for (int i = 2; i <= n; ++i) {
            if (is_prime[i] == 1) {
                // i is prime
                for (int j = i; j <= n; j += i) {
                    mu[j] *= -1; // Flip sign for every multiple of prime i
                    is_prime[j] = 0; // Mark multiples as non-prime
                }
                // Set mu[j] = 0 for numbers divisible by i^2 (not square-free)
                for (int j = i * i; j <= n; j += i * i) {
                    mu[j] = 0;
                }
            }
        }
    }

    // Builds frequency array: freq[x] stores how many times x occurs in arr[]
    void buildFre(int[] arr, int[] freq) {
        for (int x : arr) {
            freq[x]++;
        }
    }

    // For each integer k, compute how many numbers in arr are divisible by k
    // d[k] will store the count of elements in arr that are divisible by k
    void computeDivCnt(int maxVal, int[] freq, int[] d) {
        for (int k = 1; k <= maxVal; ++k) {
            for (int j = k; j <= maxVal; j += k) {
                d[k] += freq[j];
            }
        }
    }

    // Main logic to count coprime pairs using Möbius function and Inclusion-Exclusion
    int cntCoprime(int[] arr) {
        // Step 1: Find maximum value in arr for array sizing
        int maxVal = Arrays.stream(arr).max().getAsInt();

        // Step 2: Initialize arrays
        int[] freq = new int[maxVal + 1]; // Frequency of each number
        int[] d = new int[maxVal + 1];    // Count of numbers divisible by each i
        int[] mu = new int[maxVal + 1];   // Möbius function values
        Arrays.fill(mu, 1);               // Default to 1 for all

        // Step 3: Build helper arrays
        buildFre(arr, freq);              // Fill frequency array
        computeDivCnt(maxVal, freq, d);   // Count divisible values for each integer
        computeMobius(maxVal, mu);        // Calculate Möbius function values

        // Step 4: Use Inclusion-Exclusion with Möbius to count coprime pairs
        int result = 0;
        for (int k = 1; k <= maxVal; ++k) {
            if (mu[k] == 0 || d[k] < 2) continue; // Skip if not square-free or not enough values

            // Count the number of unordered pairs (i, j) where both arr[i] and arr[j] are divisible by k
            int pairs = (int)((long)d[k] * (d[k] - 1) / 2);

            // Inclusion-Exclusion: add or subtract pairs based on Möbius value
            result += mu[k] * pairs;
        }

        return result; // Total number of coprime pairs
    }
}

