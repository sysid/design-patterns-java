package sysid.state;

interface State {
    /**
     * @param context reference back to the context (pattern characteristics vs. strategy pattern)
     * @param name    name to print
     */
    void writeName(StateContext context, String name);
}

