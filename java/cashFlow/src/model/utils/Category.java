package src.model.utils;

public class Category {
    private int id;
    private TypeCategory type;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeCategory getType() {
        return type;
    }

    public void setType(TypeCategory type) {
        this.type = type;
    }
    public void setType(String type) {
        final String PAGAMENTO = "Pagamento";
        final String RECEBIMENTO = "Recebimento";

        if (type.equals(PAGAMENTO)) {
            setType(TypeCategory.PAYAMENT);
        } else if (type.equals(RECEBIMENTO)) {
            setType(TypeCategory.REVENUE);
        } else {
            System.err.printf("\n[ERRO] tipo inexistente para categoria - tipo: %s", type);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Category category = (Category) obj;
        return this.id == category.id;
    }


    
}
