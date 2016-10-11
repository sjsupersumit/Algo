#!/usr/bin/python
import itertools
a, f = 0, [2,3,5,7,11,13,17]
for b in list(itertools.permutations([0,1,2,3,4,5,6,7,8,9])):
        for e in [1,2,3,4,5,6,7]:
                    if (100*b[e] + 10*b[e+1] + b[e+2]) % f[e-1] != 0:
                                    break
                                        if e == 7:
                                                        a += int(''.join(map(str, b)))
                                                        print(a)
