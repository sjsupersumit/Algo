#! /bin/python


def getDailgnolSum():
    n =1001 
    sum = 0
    s = n*n
    gap = n-1
    cnt=5;
    while gap>=0 and s >1:
        sum+= s
        print "Adding %d" %(s)
        s-= gap
        cnt -=1
        if cnt == 1:
            cnt=5
            gap= gap - 2;

    print sum+1


if __name__ == '__main__':
    getDailgnolSum()

