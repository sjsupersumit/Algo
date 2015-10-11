/*
PROGRAM_NAME = friday
PROBLEM: Count frequency of days(sun, monday..sat) from 1 jan 1900 to specified year
INPUT: A single integer
OUTPUT: Frequency of all the days.
LANG: C++11
*/
#include <iostream>
#include <fstream>
#include <bits/stdc++.h>

using namespace std;


bool isLeap(int year) {
        if (year % 100 == 0) {
            return year % 400 == 0;
        } else {
            return year % 4 == 0;
        }
    }


int main() {
    ofstream fout ("friday.out");
    ifstream fin ("friday.in");
    int a, b,years;
    fin >> years;
    int freq[7] ;

    for(int i =0; i<7;i++)
    freq[i] = 0;

    int calendarDay = 0;
        int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int leapDays[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int end = 1900 + years;
        for (int year = 1900; year < end; year++) {
            for (int month = 0; month < 12; month++) {
                int day = (calendarDay + 12) % 7;
                freq[day]++;
                calendarDay += isLeap(year) ? leapDays[month] : days[month];
            }
        }






    for(int i =5; i<12;i++)
    {

    int j =i%7;
   fout<<freq[j];
   if(i!=11)
    fout<<" ";


    }
    fout<<"\n";
    return 0;
}
