#! /bin/python

f1=1
f2=1
f3=  2
index = 2
while len(str(f3))!=1000:
    index+=1
    f3 = f1 + f2
    f1=f2
    f2=f3

    
print index
