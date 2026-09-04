package edu.eci.arsw.math;
public class PiThread extends Thread {
    private int from;
    private int count;

    private byte [] bytes;

    public PiThread (int from, int count) {
        this.from = from;
        this.count = count;
    }

    public int getFrom() {
        return from;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run () {
        this.bytes = PiDigits.getDigits(this.from, this.count);
    }
}
