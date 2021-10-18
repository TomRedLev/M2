package com.example.gunbattle;

public class GunShot {
        private long t0;
        private float gravity;
        private float v0;
        private float angle;
        private float x0;

        public GunShot(long t0, float gravity, float v0, float angle, float x0) {
            this.t0 = t0;
            this.gravity = gravity;
            this.v0 = v0;
            this.angle = angle;
            this.x0 = x0;
        }

        public int[] computePosition(long t) {
            int[] array = new int[2];
            long deltaT = (long) ((t - t0) / 1000f); // seconds since the launch
            array[1] = (int) - (-0.5f * gravity * deltaT * deltaT + v0 * Math.sin(angle) * deltaT) / 10;
            array[0] = (int) (v0 * Math.cos(angle) * deltaT + x0);
            System.out.println(array[0] + " " + array[1]);
            return array;
        }
}
