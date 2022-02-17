package se.hiq.andersson.lucas.tele2monty;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MontySimTest {
    private final int RUNS = 1000000;

    @Test
    public void shouldRunSim() {
        MontySim sim = new MontySim();
        MontySimResult res = sim.run(RUNS, false);
        assertEquals(50, res.getWinRate());
        System.out.printf("> runs: %s, %s%n", RUNS, res);
    }

    @Test
    public void shouldRunStickySim() {
        MontySim sim = new MontySim();
        MontySimResult res = sim.run(RUNS, true);
        sim.run(RUNS, true);
        assertEquals(33, res.getWinRate());
        System.out.printf("> runs: %s, %s%n", RUNS, res);
    }
}
