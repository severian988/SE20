import math

a_sample=[2, 3, 5, 7, 11, 13,17,31,61,73]

def checkNum(num): 
    s,d=0,num-1
    assert(d>0)
    while(d%2==0):
        s += 1
        d //= 2
    assert(2**s*d == num-1)
    return [s,d]

def myPow(x,y,n):
    result = 1
    x=x%n
    while(y>0):
        if(y%2==1):
            result = (result*x)%n
        y = y//2
        x=(x**2)%n
    return result

def miillerTest(d, num, a):
    x = myPow(a, d, num)
    print(x)
    if (x == 1 or x == num-1):
        return True
    while(d != num-1):
        x = (x**2)%num
        d*=2
        if(x==1): return False
        if(x==num-1): return True
    return False

def isPrime(num):
    if num <= 1 or num==4: return False
    if num == 2: return True
    s,d=checkNum(num)
    for a in a_sample:
        if(a>=num):
            break
        if(miillerTest(d,num,a)==False):
            return False
    return True

if __name__ == "__main__":
    # for i in range(24):
    i = 49081
    tmp = (10**i-1)//9
    print(tmp)
    print(tmp,isPrime(tmp))
        

