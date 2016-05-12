#!/usr/bin/python

from math import factorial
s=0
fact={}
for i in range(0,10):
    fact[i] = factorial(i)


for i in range(10,100000):
    ti=i
    f=0
    while ti!=0:
        r = ti%10;
        ti=ti/10;
        f+= fact[r]
    if f == i:
        print i
        s+= i
print "sum %d" %(s)

