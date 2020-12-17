package src.model.utils;

public enum TypeCategory {
    PAYAMENT("Pagamento"), 
    REVENUE("Recebimento");

    private String type;

    private TypeCategory(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
