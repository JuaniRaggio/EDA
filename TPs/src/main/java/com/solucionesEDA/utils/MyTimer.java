package com.solucionesEDA.utils;

public class MyTimer {
    private long startTime;
    private long endTime;
    private boolean isRunning;

    public MyTimer() {
        this.startTime = 0;
        this.endTime = 0;
        this.isRunning = false;
    }

    public void start() {
        this.startTime = System.nanoTime();
        this.isRunning = true;
        this.endTime = 0;
    }

    public void stop() {
        if (!isRunning) {
            throw new IllegalStateException("Timer is not running");
        }
        this.endTime = System.nanoTime();
        this.isRunning = false;
    }

    public long getElapsedTimeNanos() {
        if (isRunning) {
            return System.nanoTime() - startTime;
        } else {
            if (endTime == 0) {
                throw new IllegalStateException("Timer has not been stopped");
            }
            return endTime - startTime;
        }
    }

    public double getElapsedTimeMicros() {
        return getElapsedTimeNanos() / 1000.0;
    }

    public double getElapsedTimeMillis() {
        return getElapsedTimeNanos() / 1_000_000.0;
    }

    public double getElapsedTimeSeconds() {
        return getElapsedTimeNanos() / 1_000_000_000.0;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void reset() {
        this.startTime = 0;
        this.endTime = 0;
        this.isRunning = false;
    }

    public void restart() {
        reset();
        start();
    }

    public static long measureNanos(Runnable task) {
        MyTimer timer = new MyTimer();
        timer.start();
        task.run();
        timer.stop();
        return timer.getElapsedTimeNanos();
    }

    public static double measureMillis(Runnable task) {
        MyTimer timer = new MyTimer();
        timer.start();
        task.run();
        timer.stop();
        return timer.getElapsedTimeMillis();
    }

    public static double measureSeconds(Runnable task) {
        MyTimer timer = new MyTimer();
        timer.start();
        task.run();
        timer.stop();
        return timer.getElapsedTimeSeconds();
    }

    public static String formatTime(long nanos) {
        if (nanos < 1_000) {
            return nanos + " ns";
        } else if (nanos < 1_000_000) {
            return String.format("%.3f μs", nanos / 1_000.0);
        } else if (nanos < 1_000_000_000) {
            return String.format("%.3f ms", nanos / 1_000_000.0);
        } else {
            return String.format("%.3f s", nanos / 1_000_000_000.0);
        }
    }

    @Override
    public String toString() {
        if (isRunning) {
            return "Timer is running, elapsed: " + formatTime(getElapsedTimeNanos());
        } else if (endTime == 0) {
            return "Timer not started";
        } else {
            return "Elapsed time: " + formatTime(getElapsedTimeNanos());
        }
    }

    public static class IntervalTimer {
        private MyTimer timer;
        private long lastMark;

        public IntervalTimer() {
            this.timer = new MyTimer();
            this.lastMark = 0;
        }

        public void start() {
            timer.start();
            lastMark = timer.startTime;
        }

        public long getIntervalNanos() {
            if (!timer.isRunning) {
                throw new IllegalStateException("Timer is not running");
            }
            long currentTime = System.nanoTime();
            long interval = currentTime - lastMark;
            lastMark = currentTime;
            return interval;
        }

        public double getIntervalMillis() {
            return getIntervalNanos() / 1_000_000.0;
        }

        public double getIntervalSeconds() {
            return getIntervalNanos() / 1_000_000_000.0;
        }

        public long getTotalNanos() {
            return timer.getElapsedTimeNanos();
        }

        public double getTotalMillis() {
            return timer.getElapsedTimeMillis();
        }

        public double getTotalSeconds() {
            return timer.getElapsedTimeSeconds();
        }

        public void stop() {
            timer.stop();
        }

        public boolean isRunning() {
            return timer.isRunning();
        }

        public void reset() {
            timer.reset();
            lastMark = 0;
        }
    }

    public static class PerformanceProfiler {
        private final MyTimer timer;
        private final String operationName;

        private PerformanceProfiler(String operationName) {
            this.operationName = operationName;
            this.timer = new MyTimer();
        }

        public static PerformanceProfiler start(String operationName) {
            PerformanceProfiler profiler = new PerformanceProfiler(operationName);
            profiler.timer.start();
            return profiler;
        }

        public void stop() {
            timer.stop();
        }

        public String getReport() {
            return String.format("%s completed in %s", operationName, timer.toString());
        }

        public void printReport() {
            System.out.println(getReport());
        }

        public long getElapsedNanos() {
            return timer.getElapsedTimeNanos();
        }

        public double getElapsedMillis() {
            return timer.getElapsedTimeMillis();
        }
    }

    public static class BenchmarkRunner {
        public static void compareAlgorithms(String description, Runnable... algorithms) {
            System.out.println("Benchmark: " + description);
            System.out.println("=" + "=".repeat(description.length() + 10));

            for (int i = 0; i < algorithms.length; i++) {
                long time = measureNanos(algorithms[i]);
                System.out.printf("Algorithm %d: %s%n", i + 1, formatTime(time));
            }
            System.out.println();
        }

        public static void warmupAndMeasure(String description, Runnable algorithm, int warmupRuns, int measureRuns) {
            System.out.println("Warming up with " + warmupRuns + " runs...");
            for (int i = 0; i < warmupRuns; i++) {
                algorithm.run();
            }

            System.out.println("Measuring " + description + " with " + measureRuns + " runs:");
            long totalTime = 0;
            long minTime = Long.MAX_VALUE;
            long maxTime = Long.MIN_VALUE;

            for (int i = 0; i < measureRuns; i++) {
                long time = measureNanos(algorithm);
                totalTime += time;
                minTime = Math.min(minTime, time);
                maxTime = Math.max(maxTime, time);
            }

            double averageTime = (double) totalTime / measureRuns;
            System.out.printf("Average: %s%n", formatTime((long) averageTime));
            System.out.printf("Min: %s%n", formatTime(minTime));
            System.out.printf("Max: %s%n", formatTime(maxTime));
            System.out.println();
        }
    }
}