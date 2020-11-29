import junit.textui.TestRunner;
import junit.framework.TestSuite;
import junit.framework.TestCase;

public class MatriceEntierOpSupTest extends TestCase {
  static int totalAssertions = 0;
  static int bilanAssertions = 0;

  /*
   Opérations supplémentaires du type MatriceEntier
  */
  public void test_toString() throws Exception {
    MatriceEntier m = new MatriceEntier(3,3) ;
    m.setPremiereDiagonale(1).setSecondeDiagonale(2) ;
	  
    String ln = System.getProperty("line.separator") ;
    String attendu = "1 0 2 " + ln + "0 2 0 " + ln + "2 0 1 " + ln ;
    totalAssertions++ ;
    assertEquals("toString() == ", attendu, m.toString());
    bilanAssertions++ ;
  }
  
  public void test_toHTML() throws Exception {
    MatriceEntier m = new MatriceEntier(3,3) ;
    m.setPremiereDiagonale(1).setSecondeDiagonale(2) ;
	  
    String ln = System.getProperty("line.separator") ;
    String attendu = "<table border=\"1\">" + ln ;
    attendu += "<tr><td>1</td><td>0</td><td>2</td></tr>" + ln + "<tr><td>0</td><td>2</td><td>0</td></tr>" + ln + "<tr><td>2</td><td>0</td><td>1</td></tr>" + ln ;
    attendu += "</table>" + ln ;
    totalAssertions++ ;
    assertEquals("toHTML() == ", attendu, m.toHTML());
    bilanAssertions++ ;
  }
  
  /*
   main() de la classe de Test
  */
  public static void main(String[] args) {
    junit.textui.TestRunner.run(new TestSuite(MatriceEntierOpSupTest.class));
    if (bilanAssertions == totalAssertions) { System.out.print("Bravo !"); }
    else  { System.out.print("OUPS !"); }
    System.out.println(" "+bilanAssertions+"/"+totalAssertions+" assertions verifiees");
  } // fin main

} // fin PileTest
