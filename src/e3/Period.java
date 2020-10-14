package e3;

public enum Period {
    AM("AM"),
    PM("PM");

    private final String abreviatura;

    Period(String abreviatura) {
        this.abreviatura = abreviatura;
    }

        @Override
        public String toString() {
            return abreviatura;
        }

}
