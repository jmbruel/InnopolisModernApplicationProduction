import junit.textui.TestRunner;
import junit.framework.TestSuite;
import junit.framework.TestCase;

public class MatriceEntierPreconditionsTest extends TestCase {
  static int totalAssertions = 0;
  static int bilanAssertions = 0;

  /*
   Préconditions du type Pile
  */
  public void test_precondition1() {
    MatriceEntier m ;
    boolean exception = false ;
    try { m = new MatriceEntier(0,1) ; } 
    catch (Exception e) { exception = true ; };
    
    totalAssertions++ ;
    assertTrue("new MatriceEntier(0,1) leve une exception", exception);
    bilanAssertions++ ;
    
    exception = false ;
    try { m = new MatriceEntier(1,0) ; } 
    catch (Exception e) { exception = true ; };
    
    totalAssertions++ ;
    assertTrue("new MatriceEntier(1,0) leve une exception", exception);
    bilanAssertions++ ;
    
    exception = false ;
    try { m = new MatriceEntier(0,0) ; } 
    catch (Exception e) { exception = true ; };
    
    totalAssertions++ ;
    assertTrue("new MatriceEntier(0,0) leve une exception", exception);
    bilanAssertions++ ;
  }

  public void test_precondition2() throws Exception {
    MatriceEntier m = new MatriceEntier(2,3);
    boolean exception = false ;
    try { m.getElement(-1,1) ; } 
    catch (Exception e) { exception = true ; };
    
    totalAssertions++ ;
    assertTrue("getElement(-1,1) leve une exception", exception);
    bilanAssertions++ ;
    
    exception = false ;
    try { m.getElement(2,2) ; } 
    catch (Exception e) { exception = true ; };
    
    totalAssertions++ ;
    assertTrue("getElement(2,2) leve une exception", exception);
    bilanAssertions++ ;
    
    exception = false ;
    try { m.getElement(1,-1) ; } 
    catch (Exception e) { exception = true ; };
    
    totalAssertions++ ;
    assertTrue("getElement(1,-1) leve une exception", exception);
    bilanAssertions++ ;
    
    exception = false ;
    try { m.getElement(1,3) ; } 
    catch (Exception e) { exception = true ; };
    
    totalAssertions++ ;
    assertTrue("getElement(1,3) leve une exception", exception);
    bilanAssertions++ ;
  }

  public void test_precondition3() throws Exception {
    MatriceEntier m = new MatriceEntier(2,3);
    boolean exception = false ;
    try { m.setElement(-1,1,99) ; } 
    catch (Exception e) { exception = true ; };
    
    totalAssertions++ ;
    assertTrue("setElement(-1,1,99) leve une exception", exception);
    bilanAssertions++ ;
    
    exception = false ;
    try { m.setElement(2,2,99) ; } 
    catch (Exception e) { exception = true ; };
    
    totalAssertions++ ;
    assertTrue("setElement(2,2,99) leve une exception", exception);
    bilanAssertions++ ;
    
    exception = false ;
    try { m.setElement(1,-1,99) ; } 
    catch (Exception e) { exception = true ; };
    
    totalAssertions++ ;
    assertTrue("setElement(1,-1,99) leve une exception", exception);
    bilanAssertions++ ;
    
    exception = false ;
    try { m.setElement(1,3,99) ; } 
    catch (Exception e) { exception = true ; };
    
    totalAssertions++ ;
    assertTrue("setElement(1,3,99) leve une exception", exception);
    bilanAssertions++ ;
  }

  public void test_precondition4() throws Exception {
    MatriceEntier m = new MatriceEntier(2,3);
    boolean exception = false ;
    try { m.somLigne(-1) ; } 
    catch (Exception e) { exception = true ; };
    
    totalAssertions++ ;
    assertTrue("somLigne(-1) leve une exception", exception);
    bilanAssertions++ ;
    
    exception = false ;
    try { m.somLigne(2) ; } 
    catch (Exception e) { exception = true ; };
    
    totalAssertions++ ;
    assertTrue("somLigne(2) leve une exception", exception);
    bilanAssertions++ ;
  }

  public void test_precondition5() throws Exception {
    MatriceEntier m = new MatriceEntier(2,3);
    boolean exception = false ;
    try { m.somColonne(-1) ; } 
    catch (Exception e) { exception = true ; };
    
    totalAssertions++ ;
    assertTrue("somColonne(-1) leve une exception", exception);
    bilanAssertions++ ;
    
    exception = false ;
    try { m.somColonne(3) ; } 
    catch (Exception e) { exception = true ; };
    
    totalAssertions++ ;
    assertTrue("somColonne(3) leve une exception", exception);
    bilanAssertions++ ;
  }

  public void test_precondition6() throws Exception {
    MatriceEntier m = new MatriceEntier(2,3);
    boolean exception = false ;
    try { m.setPremiereDiagonale(99) ; } 
    catch (Exception e) { exception = true ; };
    
    totalAssertions++ ;
    assertTrue("setPremiereDiagonale(99) leve une exception", exception);
    bilanAssertions++ ;
  }

  public void test_precondition7() throws Exception {
    MatriceEntier m = new MatriceEntier(2,3);
    boolean exception = false ;
    try { m.setSecondeDiagonale(99) ; } 
    catch (Exception e) { exception = true ; };
    
    totalAssertions++ ;
    assertTrue("setSecondeDiagonale(99) leve une exception", exception);
    bilanAssertions++ ;
  }

  public void test_precondition8() throws Exception {
    MatriceEntier m = new MatriceEntier(2,3);
    boolean exception = false ;
    try { m.estDiagonale() ; } 
    catch (Exception e) { exception = true ; };
    
    totalAssertions++ ;
    assertTrue("estDiagonale() leve une exception", exception);
    bilanAssertions++ ;
  }
  
  /*
   main() de la classe de Test
  */
  public static void main(String[] args) {
    junit.textui.TestRunner.run(new TestSuite(MatriceEntierPreconditionsTest.class));
    if (bilanAssertions == totalAssertions) { System.out.print("Bravo !"); }
    else  { System.out.print("OUPS !"); }
    System.out.println(" "+bilanAssertions+"/"+totalAssertions+" assertions verifiees");
  } // fin main

} // fin MatriceEntierPreconditionsTest
