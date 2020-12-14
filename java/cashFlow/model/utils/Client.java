package model.utils;

public class Client {
    private String name;

    public Client() {
	}

    public Client(String name) {
        setName(name);
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
}
