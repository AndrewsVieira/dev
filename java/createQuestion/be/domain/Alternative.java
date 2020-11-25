package be.domain;

public class Alternative {

  private String alternative;
  private boolean rightAlternative;

  public Alternative(String text, boolean isTrue) {
    this.alternative = text;
    this.rightAlternative = isTrue;
  }

  public void setAlternative(String alternative) {
    this.alternative = alternative;
  }

  public String getAlternative() {
    return this.alternative;
  }

  public void setRigthAlternative(boolean rigthAlternative) {
    this.rightAlternative = rigthAlternative;
  }

  public boolean getRigthAlternative() {
    return this.rightAlternative;
  }

  @Override
  public String toString() {
    return String.format("%s: '%s'\n",
        getClass().getName(), getAlternative());
  }
}
