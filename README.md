# Competitive Programming Template

This template includes common algorithms and utility functions useful in competitive programming. It is designed to be a starting point for coding contests and practice sessions.

## Table of Contents

- [Pair Class](#pair-class)
- [Exponentiation Function](#exponentiation-function)
- [Binomial Coefficient](#binomial-coefficient)
- [Least Common Multiple](#least-common-multiple)
- [Greatest Common Divisor](#greatest-common-divisor)
- [Sieve of Eratosthenes](#sieve-of-eratosthenes)
- [Input Helper Functions](#input-helper-functions)
- [Main Function](#main-function)

## Pair Class

This is a generic class for storing pairs of elements.

```java
private static class Pair<A, B> 
{
    A first;
    B second;

    public Pair(A first, B second)
    {
        this.first = first;
        this.second = second;
    }
}
```

## Exponentiation Function

This function calculates x raised to the power y modulo p.

```java
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
```

## Binomial Coefficient

This function calculates the binomial coefficient nCk modulo MOD.

```java
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
```

## Least Common Multiple

This function calculates the least common multiple of two integers, a and b.

```java
private static long lcm(long a, long b)
    {
        return (a / gcd(a, b)) * b;
    }
```

## Greatest Common Divisor

This function calculates the greatest common divisor of two integers, a and b.

```java
private static long gcd(long a, long b)
    {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
```

## Sieve of Eratosthenes

This function prints prime numbers less than or equal to n.

```java
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
```

## Input Helper Functions

These functions help in setting the elements of an array from standard input.

```java
private static void setArray(int [] arr, int n)
    {
        Scanner scn = new Scanner(System.in);
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
    }
````

## Main Function

The main function reads input, processes it, and produces output

```java
public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int t = scn.nextInt();
      while(t-- > 0){
        
      }
      scn.close();
    }
```
