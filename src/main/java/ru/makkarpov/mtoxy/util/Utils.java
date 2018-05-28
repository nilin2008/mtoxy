package ru.makkarpov.mtoxy.util;

import java.net.InetSocketAddress;

public class Utils {
    public static InetSocketAddress parseAddress(String s) {
        String[] parts = s.split(":", 2);
        return new InetSocketAddress(parts[0], Integer.parseInt(parts[1]));
    }

    public static InetSocketAddress parseAddress(String s, int defaultPort) {
        String[] parts = s.split(":", 2);
        if (parts.length == 1) {
            return new InetSocketAddress(parts[0], defaultPort);
        } else {
            return new InetSocketAddress(parts[0], Integer.parseInt(parts[1]));
        }
    }

    public static int littleEndianToInt(byte[] buf, int idx) {
        return ((buf[idx + 3] & 0xFF) << 24) | ((buf[idx + 2] & 0xFF) << 16) | ((buf[idx + 1] & 0xFF) << 8) |
                (buf[idx] & 0xFF);
    }

    public static void intToLittleEndian(int i, byte[] buf, int idx) {
        buf[idx + 3] = (byte) (i >> 24);
        buf[idx + 2] = (byte) (i >> 16);
        buf[idx + 1] = (byte) (i >> 8);
        buf[idx] = (byte) i;
    }

    public static void reverse(byte[] x) {
        for(int i = 0; i < x.length / 2; i++) {
            byte temp = x[i];
            x[i] = x[x.length - i - 1];
            x[x.length - i - 1] = temp;
        }
    }
}