package entidades;

public enum EstadoCivil {
    CASADO("Casado"),
    SOLTERO("Soltero"),
    VIUDO("Viudo"),
    DIVORCIADO("Divorciado"),
    OTRO("Otro");
    
    private final String label;

    private EstadoCivil(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }    
}
