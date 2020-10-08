public class Airplane {
    public static final int NUM_SEATS = 10;
    private boolean[] seats = new boolean[NUM_SEATS];

    public Airplane() {
        for (int i = 0; i<this.seats.length; i++) {
            this.seats[i] = false;
        }
    }

    public void setSeat(int numSeat) {
        if (!this.seats[numSeat-1]){
            this.seats[numSeat-1] = true;
        } else if (this.seats[numSeat-1]) {
            System.out.println("Assento já reservado! Escolha outro.");
        }
    }

    public boolean[] getSeats() {
        return this.seats;
    }
}