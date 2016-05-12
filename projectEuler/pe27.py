#! /bin/python

prime = {}
limit = int( 1e7)

for i in range(1,limit):
    prime[i] = True

prime[0] = prime[1] = False

for i in range(2,limit):
    if prime[i]:
        j=i
        while j*i < limit:
            prime[i*j] = False
            j+=1

max_cnt=0;
a1=-1
b1=-1

for a in range(-999,1000):
    for b in range(-999,1000):
        cnt = 0
        n=0
        f = n*n  + a*n + b
        while prime.has_key(f) and  prime[f]:
            cnt+=1
            n+=1
            f = n*n + a*n + b

        if cnt > max_cnt :
            max_cnt = cnt
            a1=a
            b1=b


print a1*b1


