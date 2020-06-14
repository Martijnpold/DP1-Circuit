package com.mpolder.dp1.gate;

public class GateOutput {
    private boolean output;
    private int steps;

    private static final int STEP_NS = 15;

    public GateOutput(boolean output, int steps) {
        this.output = output;
        this.steps = steps;
    }

    /**
     * Calculate the time used to get an output
     *
     * @return Simulation time in ns
     */
    public int getDeltaTimeNs() {
        return steps * STEP_NS;
    }

    public boolean getOutput() {
        return output;
    }
}
