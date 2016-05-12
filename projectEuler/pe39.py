#!/usr/bin/python
from math import sqrt
"""Generate all triplets less than 1000"""

d = {}
for x in range (1,1000):
    for y in range(x+1,1000):
        zz = x*x + y*y
        z =int( sqrt(zz))
        val=x+y+z
        if val<=1000 and z*z == zz:
            if d.has_key(val):
                d[val]=d[val]+1
            else:
                d[val] = 1

max_sum=0
max_key=0
for k in d.keys():
    if d[k] > max_key:
        max_sum = k
        max_key = d[k]

print max_sum

     
            

            
