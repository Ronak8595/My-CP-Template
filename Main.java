import java.io.*;
import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;

public class Main {
    static FastReader in;
    static PrintWriter out;
    static final int MOD = (int) 1e9 + 7;
    static final int MAXN = (int) 1e5 + 5;
    static final long INF = (long) 1e18;
    static final Random rnd = new Random();

    // Direction arrays for grid-based navigation
    static final int[] DX4 = {-1, 0, 1, 0}; 
    static final int[] DY4 = {0, 1, 0, -1};
    static final int[] DX8 = {-1, -1, -1, 0, 1, 1, 1, 0};
    static final int[] DY8 = {-1, 0, 1, 1, 1, 0, -1, -1};
    static final boolean[] primes = sieve(MAXN);

    // Computes GCD of two numbers
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Computes LCM of two numbers
    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    // Computes modular exponentiation (base^exp % mod)
    static long powMod(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    // Computes modular inverse using Fermat's Little Theorem
    static long modInverse(long a, int mod) {
        return powMod(a, mod - 2, mod);
    }

    // Computes GCD, x, y for ax + by = gcd(a, b)
    static long[] extendedGCD(long a, long b) {
        if (b == 0) return new long[]{a, 1, 0};
        long[] vals = extendedGCD(b, a % b);
        long g = vals[0], x = vals[2], y = vals[1] - (a / b) * vals[2];
        return new long[]{g, x, y};
    }

    // Computes modular inverse using Extended GCD
    static long modInverseEGCD(long a, int mod) {
        long[] gcdResult = extendedGCD(a, mod);
        if (gcdResult[0] != 1) throw new ArithmeticException("Modular inverse does not exist");
        return (gcdResult[1] % mod + mod) % mod;
    }

    // Constructs a boolean array marking primes up to n
    static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    // Binary Lifting for LCA
    static class BinaryLifting {
        int n, LOG;
        int[][] up; 
        int[] depth;

        BinaryLifting(int size) {
            n = size;
            LOG = (int) (Math.log(n) / Math.log(2)) + 1;
            up = new int[n][LOG];
            depth = new int[n];
        }

        void dfs(int v, int parent, List<List<Integer>> adj) {
            up[v][0] = parent;
            for (int i = 1; i < LOG; i++) {
                up[v][i] = up[up[v][i - 1]][i - 1];
            }
            for (int u : adj.get(v)) {
                if (u != parent) {
                    depth[u] = depth[v] + 1;
                    dfs(u, v, adj);
                }
            }
        }

        int lift(int v, int steps) {
            for (int i = 0; i < LOG; i++) {
                if ((steps & (1 << i)) != 0) {
                    v = up[v][i];
                }
            }
            return v;
        }

        int lca(int u, int v) {
            if (depth[u] < depth[v]) {
                v = lift(v, depth[v] - depth[u]);
            } else if (depth[u] > depth[v]) {
                u = lift(u, depth[u] - depth[v]);
            }
            if (u == v) return u;

            for (int i = LOG - 1; i >= 0; i--) {
                if (up[u][i] != up[v][i]) {
                    u = up[u][i];
                    v = up[v][i];
                }
            }
            return up[u][0];
        }
    }

    // Union-Find data structure for disjoint-set operations
    static class UnionFind {
        int[] parent, rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        // Finds the root of a node with path compression
        int find(int x) {
            if (x != parent[x]) parent[x] = find(parent[x]);
            return parent[x];
        }

        // Unites two sets if they are not already connected
        void union(int x, int y) {
            int xr = find(x), yr = find(y);
            if (xr != yr) {
                if (rank[xr] < rank[yr]) parent[xr] = yr;
                else if (rank[xr] > rank[yr]) parent[yr] = xr;
                else {
                    parent[yr] = xr;
                    rank[xr]++;
                }
            }
        }
    }

    // Binary Indexed Tree (BIT) for prefix sum queries
    static class BIT {
        int[] bit;
        int n;

        BIT(int size) {
            n = size;
            bit = new int[n + 1];
        }

        // Updates BIT with value at index
        void update(int index, int value) {
            while (index <= n) {
                bit[index] += value;
                index += index & -index;
            }
        }

        // Returns prefix sum up to index
        int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += bit[index];
                index -= index & -index;
            }
            return sum;
        }

        // Returns range sum between left and right
        int rangeQuery(int left, int right) {
            return query(right) - query(left - 1);
        }
    }

    // Represents a key-value pair
    static class Pair {
        long key, value;

        Pair(long key, long value) {
            this.key = key;
            this.value = value;
        }
    }

    // Represents a triplet of values
    static class Tuple {
        long a, b, c;

        Tuple(long a, long b, long c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    // Fast I/O for competitive programming
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
    
    public static void main(String[] args) {
        in = new FastReader();
        out = new PrintWriter(System.out);
        int t = in.nextInt(); 
        while (t-- > 0) solve();
        out.close();
    }

    static void solve() {
        int n = in.nextInt();
        
    }
}
