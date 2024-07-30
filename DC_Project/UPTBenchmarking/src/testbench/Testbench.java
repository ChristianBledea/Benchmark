package testbench;

import logging.ILogger;
import logging.ConsoleLogger;
import timing.ITimer;
import timing.Timer;
import bench.IBenchmark;
import bench.DummyBenchmark;

public class Testbench {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILogger logger = new ConsoleLogger();
        IBenchmark benchmark = new DummyBenchmark();

        benchmark.initialize(100000);
        timer.start();
        benchmark.run();
        logger.write("Time: " + timer.stop() + "ns");

        benchmark.clean();
        logger.close();
    }
}
