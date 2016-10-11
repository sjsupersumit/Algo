#!/usr/bin/python

t=[0,1, 3, 6, 10, 15, 21, 28, 36, 45, 55]
for i in xrange(11,50):
    tn = (i*(i+1))/2
    t.append(tn)

lines = [line.rstrip('\n') for line in open('/Users/sumit.jha/Desktop/C++/p042_words.txt')][0].split(",")
cnt=0
i=0
for word in lines:
    sum = 0
    for c in word:
        if c.isalpha():
            sum+= (ord(c)-64)
    if sum in t:
        cnt+=1
print cnt


