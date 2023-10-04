import java.util.*;
private static class Pair<A, B> {
        A first;
        B second;
        //Pair<Integer, Integer> x = new Pair<Integer, Integer>(1, 2);
        public Pair(A first, B second)
        {
            this.first = first;
            this.second = second;
        }
    }
}
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
public class Main {
    public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int t = scn.nextInt();
      while(t-- > 0){
        
      }
      scn.close();
  }
}