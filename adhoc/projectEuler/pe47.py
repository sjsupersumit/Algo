#! /bin/python
def contDistinctFactor(n):
    cnt=0
    while n!=1:
        for p in range(2,n/2):
            print p
            if n %p == 0:
                cnt+=1
                while n%p ==0:
                    n=n/p
    return cnt


count = 0
i=640
print contDistinctFactor(101)
while count < 4:
    print i
    if contDistinctFactor(i) == 4:
        count+=1
    else:
       count=0
    i+=1
    

print i-4






