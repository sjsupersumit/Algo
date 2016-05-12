#!/usr/bin/python
p=set()

for a in range(1,1000):
    for b in range(1,100000):
        c = a*b
        ta=a
        tb=b
        tc=c
        l = []

        while ta!=0:
            r = ta%10
            ta=ta/10
            l.append(r)
        
        while tb!=0:
            r = tb%10
            tb=tb/10
            l.append(r)
        
        while tc!=0:
            r = tc%10
            tc= tc/10
            l.append(r)

        l.sort()
        if l == [1,2,3,4,5,6,7,8,9]:
            print "%d * %d = %d" %(a,b,c)
            p.add(c)

print "set is %s" %(p)
sum=0

for x in p:
    sum+=x
print sum

            

            
