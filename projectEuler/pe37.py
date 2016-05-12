#!/bin/python

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

sum=0
for i in xrange(11,999999):
    j = str(i)
    len = len(j)
    flag=True
    for index in xrange(0,len-1):
        print index
        if not  prime[int(j[index:])] or not  prime[int(j[:-index])]:
            flag = False
            break

    if flag:
        print i
        sum+=i

            


