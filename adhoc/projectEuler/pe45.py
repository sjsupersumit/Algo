#!/usr/bin/python
from math import sqrt

def isTriangle(n):
    x = (-1 + sqrt(1+8*n))/2
    if int(x) == x:
        return True
    return False

def isPentagon(n):
    x = (1 + sqrt(1+24*n))/6
    if int(x) == x:
        return True
    return False

def isHexagonal(n):
    x =( (1 + sqrt(1+8*n))/4)
    if int(x) ==x:
        return True
    return False

i = 285
success =False
while not success:
    i+=1
    n = (i *( i+1))/2
    """All Hexagonal nums are triangle nums"""
    if (isHexagonal(n) and isPentagon(n)):
        success=True
        print n
    


