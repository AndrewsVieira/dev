package src.model;

import src.model.utils.Provider;

public class PayamentRecord extends FinancialRecord {
    private Provider provider;

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @Override
    public Object getClientOrProvider() {
        if (provider != null) {
            return provider;
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("##Pagamento##\nid: %d\nData: %s\nValor: %.2f\nFornecedor: %s\nDescrição: %s\n", getId(),
                getDate(), getValue(), getClientOrProvider(), getDescription());
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
        PayamentRecord thisObj = (PayamentRecord) obj;
        return this.getId() == thisObj.getId();
    }
}
