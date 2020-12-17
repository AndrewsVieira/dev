package src.model;

import src.model.utils.Client;

public class RevenueRecord extends FinancialRecord {
    private Client client;

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public Object getClientOrProvider() {
        if (client != null) {
            return client;
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("##Recebimento##\nid: %d\nData: %s\nValor: %.2f\nCliente: %s\nDescrição: %s\n", getId(),
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
        RevenueRecord thisObj = (RevenueRecord) obj;
        return this.getId() == thisObj.getId();
    }
}
