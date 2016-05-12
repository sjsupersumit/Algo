#!/usr/bin/python

d="0"
for i in xrange(1,1000000+1):
    d+=str(i)

print int(d[1]) * int( d[10]) *int( d[100]) *int(d[1000]) * int(d[10000]) *int( d[100000]) *int(d[1000000])
