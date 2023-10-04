import java.util.*;
private static class Pair<A, B> 
{
        A first;
        B second;
        //Pair<Integer, Integer> x = new Pair<Integer, Integer>(1, 2);
        public Pair(A first, B second)
        {
            this.first = first;
            this.second = second;
        }
}
public class Main {
    // Function to find x ^ n using p as mod
    private static long power(long x, long y, long p)
    {
        long res = 1;
        x = x % p;
    
        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % p;
    
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }
    // function to find nCk using MOD as mod
    private static long binomialCoeff(long n,long k,long MOD)
    {
        long res = 1;
        if (k > n - k)
            k = n - k;
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
            res %= MOD;
        }
        return res;
    }
    private static long lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }
    private static long gcd(long a, long b)
    {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    // Function to print prime numbers less than or equal to n
    private void sieveOfEratosthenes(int n)
    {
            boolean prime[] = new boolean[n + 1];
            for(int i = 0; i <= n; i++)
                prime[i] = true;
    
            for(int p = 2; p * p <= n; p++){
                if(prime[p] == true){
                    for(int i = p * p; i <= n; i += p)
                        prime[i] = false;
                }
            }
            for(int i = 2; i <= n; i++){
                if(prime[i] == true)
                    System.out.print(i + " ");
            }
    }
    private static void setArray(int [] arr, int n)
    {
        Scanner scn = new Scanner(System.in);
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
    }
    public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int t = scn.nextInt();
      while(t-- > 0){
        
      }
      scn.close();
  }
}