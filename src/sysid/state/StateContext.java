package sysid.state;

public class StateContext {

    // Composition:
    private State state;

    StateContext() {
        state = new LowerCaseState();
    }

    /**
     * Set the current state.
     * Normally only called by classes implementing the State interface
     * @param newState the new state of the system
     */
    public void setState(State newState) {
        state = newState;
    }

    /**
     * Delegate state relevant behaviour to State
     * communicate only via the interface
     * @param name name
     */
    public void writeName(String name) {
        state.writeName(this, name);
    }
}
