package spoj;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Math.sqrt;

/**
 * Created by sumit.jha on 9/7/16.
 */
public class PIR {

    public static void main(String args[]) throws Exception {

        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);
        double U, V, W, u, v, w, a, b, c, d, X, Y, Z, x, y, z, volume;

        int t = in.nextInt();
        while (t-- != 0) {

            U = in.nextInt();
            V = in.nextInt();
            w = in.nextInt();
            W = in.nextInt();
            v = in.nextInt();
            u = in.nextInt();


            X = (w - U + v) * (U + v + w);
            x = (U - v + w) * (v - w + U);
            Y = (u - V + w) * (V + w + u);
            y = (V - w + u) * (w - u + V);
            Z = (v - W + u) * (W + u + v);
            z = (W - u + v) * (u - v + W);
            a = sqrt(x * Y * Z);
            b = sqrt(y * Z * X);
            c = sqrt(z * X * Y);
            d = sqrt(x * y * z);
            volume = (sqrt((-a + b + c + d) * (a - b + c + d) * (a + b - c + d) * (a + b + c - d)) / (192 * u * v * w));
            System.out.format("%.4f%n", volume);


        }
    }
}




