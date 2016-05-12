#! /bin/python
prime = {}
limit = int( 1e6)

for i in range(1,limit):
    prime[i] = True

prime[0] = prime[1] = False

for i in range(2,limit):
    if prime[i]:
        j=i
        while j*i < limit:
            prime[i*j] = False
            j+=1

cnt=0
s=0
max=0
for i in range (2,1000):
    if prime[i]:
        cnt+=1
        s+=i

        if prime[s] and s>max:
            max=s

print cnt
print max
