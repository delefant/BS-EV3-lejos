public class LinienZaehler {

  public static void main(String[] args) {
    AutonomerTWR roboter = new AutonomerTWR();
    int linien = roboter.countLines();
    System.out.println(linien);
  }
}
