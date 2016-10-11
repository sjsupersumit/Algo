package spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by sumit.jha on 10/10/16.
 */
public class ABCPATH {

   static char[][] arr;
    static boolean[][] visited;



    public static void main(String args[]) throws Exception{

       Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);


        int r = in.nextInt();
        int c = in.nextInt();
        int t=0;
        while (r!=0 && c!=0){
            t++;
            arr = new char[r][c];
            visited = new boolean[r][c];
            int maxLen = 0;

            List<Point> startingPoint = new ArrayList<Point>();

            for(int i=0; i< r;i++) {
                String temp = in.readLine();
                for (int j = 0; j < c; j++) {

                    arr[i][j] = temp.charAt(j);

                    if (arr[i][j] == 'A') {
                        Point p = new Point(i, j, 1);
                        startingPoint.add(p);
                        visited[i][j] = true;
                    }
                }
            }


                //bfs

                if(startingPoint.isEmpty()){
                    out.printf("Case %d: %d\n", t,0);
                } else {

                    boolean flag = false;
                    for(Point p: startingPoint) {

                        Queue<Point> neibhours = new LinkedList<Point>();
                        neibhours.add(p);

                        while (!neibhours.isEmpty()) {

                            Point cuRPoint = neibhours.poll();
                            int x = cuRPoint.x;
                            int y = cuRPoint.y;

                            char currCharater = arr[x][y];
                            int asciiNum = currCharater + 1;
                            char nextCharReq = (char) asciiNum;

                            char up = isSafe(x - 1, y, r, c) ? arr[x - 1][y] : '#';
                            char down = isSafe(x + 1, y, r, c) ? arr[x + 1][y] : '#';
                            char left = isSafe(x, y - 1, r, c) ? arr[x][y - 1] : '#';
                            char right = isSafe(x, y + 1, r, c) ? arr[x][y + 1] : '#';
                            char upLeft = isSafe(x - 1, y - 1, r, c) ? arr[x - 1][y - 1] : '#';
                            char upRight = isSafe(x - 1, y + 1, r, c) ? arr[x - 1][y + 1] : '#';
                            char downRight = isSafe(x + 1, y + 1, r, c) ? arr[x + 1][y + 1] : '#';
                            char downLeft = isSafe(x + 1, y - 1, r, c) ? arr[x + 1][y - 1] : '#';

                            if (up == nextCharReq){
                                visited[x-1][y] = true;
                                neibhours.add(new Point(x - 1, y, cuRPoint.length+1));
                            }

                            if (down == nextCharReq) {
                                visited[x+1][y] = true;
                                neibhours.add(new Point(x + 1, y, cuRPoint.length+1));
                            }

                            if (left == nextCharReq) {
                                visited[x][y-1] = true;
                                neibhours.add(new Point(x, y - 1,cuRPoint.length+1));
                            }

                            if (right == nextCharReq) {
                                visited[x][y+1] = true;
                                neibhours.add(new Point(x, y + 1,cuRPoint.length+1));
                            }

                            if (upLeft == nextCharReq) {
                                visited[x-1][y-1] = true;
                                neibhours.add(new Point(x - 1, y - 1,cuRPoint.length+1));
                            }

                            if (upRight == nextCharReq){
                                visited[x-1][y+1] = true;
                                neibhours.add(new Point(x - 1, y + 1,cuRPoint.length+1));
                            }

                            if (downRight == nextCharReq) {
                                visited[x+1][y+1] = true;
                                neibhours.add(new Point(x + 1, y + 1,cuRPoint.length+1));
                            }
                            if (downLeft == nextCharReq) {
                                visited[x+1][y-1] = true;
                                neibhours.add(new Point(x + 1, y - 1,cuRPoint.length+1));
                            }


                            if(maxLen < cuRPoint.length){
                                maxLen = cuRPoint.length;
                                if(maxLen == 26){
                                    flag = true;
                                    break;
                                }
                            }


                        }
                        if(flag) break;

                    }

                    out.printf("Case %d: %d\n",t, maxLen);

                }


            r = in.nextInt();
            c = in.nextInt();
            }


        }







    static class Point{
        int x,y;
        int length;



        public Point(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }

    public static boolean isSafe(int x, int y , int r, int c){


        if( x < 0 || x >= r || y <0 | y >= c)
            return false;



        if(visited[x][y])
            return false;

        return true;
    }
}
