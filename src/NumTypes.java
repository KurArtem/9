public enum NumTypes {
    SIMPLE("simple"),
    PRE_COMPOSITE("pre-composite"),
    COMPOSITE_DEC("composite-decimal"),
    COMPOSITE("composite");

    private final String name;

    public String getName() {
        return this.name;
    }

    NumTypes(String name) {
        this.name = name;
    }
}
