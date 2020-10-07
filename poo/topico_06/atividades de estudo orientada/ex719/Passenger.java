public class Passenger {
    private String boardingPass;
    private int numSeat;
    private int numClass;

    public Passenger(int numSeat, int numClass){
        this.numClass = numClass;
        this.numSeat = numSeat;

        Airplane airplane = new Airplane();
        airplane.setSeat(this.numSeat);
        this.setBoardingPass(this.numSeat, this.numClass);
    }

    public void setBoardingPass(int numSeat, int numClass) {
        this.numClass = numClass;
        this.numSeat = numSeat;

        if(this.numClass == 1) {
            this.boardingPass = "Assento: " + this.numSeat + "\n" + "First Class";
        } else if(this.numClass == 2) {
            this.boardingPass = "Assento: " + this.numSeat + "\n" + "Economy Class";
        }
    } 

    public String getBoardingPass() {
        return this.boardingPass;
    }
}
