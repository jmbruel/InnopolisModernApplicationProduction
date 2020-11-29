import junit.textui.TestRunner;
import junit.framework.TestSuite;
import junit.framework.TestCase;
import java.io.*;

public class JourSuivantAvecLibDateTest extends TestCase {
  static String programmeATester = "JourSuivantAvecLibDate" ;  // <1>
  Process executionProgrammeATester ;                          // <2>
  BufferedReader ecranProgrammeATester ;                       // <3>
  BufferedWriter clavierProgrammeATester ;                     // <4>

  String finDeLigne = System.getProperty("line.separator") ;   // <5>

  public static void main(String[] args) {
    if ( args.length > 0 ) { programmeATester = args[0] ; }
    System.out.println("Tests du programme : " + programmeATester);
    junit.textui.TestRunner.run(new TestSuite(JourSuivantAvecLibDateTest.class)); // <6>
  }
  
  protected void setUp() throws IOException {  // <7>
    executionProgrammeATester = Runtime.getRuntime().exec("java -cp . "+programmeATester); // <8>
    ecranProgrammeATester = new BufferedReader(new  InputStreamReader( executionProgrammeATester.getInputStream() )); // <9>
    clavierProgrammeATester  = new BufferedWriter(new OutputStreamWriter( executionProgrammeATester.getOutputStream() )); // <10>
  }

  // Saisies valides
  public void test_31_1_2013() throws IOException {
    assertEquals("Affiche : 'Saisir une date : jour mois annee ? '","Saisir une date : jour mois annee ? ",ecranProgrammeATester.readLine()); // <11>
    clavierProgrammeATester.write("31 1 2013"+finDeLigne); // <12>
    clavierProgrammeATester.flush();                       // <13>
    assertEquals("Affiche : 'Le lendemain du 31/1/2013'","Le lendemain du 31/1/2013",ecranProgrammeATester.readLine()); 
    assertEquals("Affiche : 'sera le 1/2/2013.'","sera le 1/2/2013.",ecranProgrammeATester.readLine()); // <14>
  }

  public void test_28_2_2013() throws IOException {
    String messageSaisie = "Saisir une date : jour mois annee ? " ;
    String[] ligneJeuDEssai = {"28 2 2013","Le lendemain du 28/2/2013","sera le 1/3/2013."} ;
    
    assertEquals("Affiche : "+messageSaisie,messageSaisie,ecranProgrammeATester.readLine());
    clavierProgrammeATester.write(ligneJeuDEssai[0]+finDeLigne); clavierProgrammeATester.flush();
    assertEquals("Affiche : "+ligneJeuDEssai[1],ligneJeuDEssai[1],ecranProgrammeATester.readLine());
    assertEquals("Affiche : "+ligneJeuDEssai[2],ligneJeuDEssai[2],ecranProgrammeATester.readLine());
  }

  protected void assertsPourSaisieValide(String messageSaisie,String saisie,String affichage1,String affichage2) throws IOException {
     assertEquals("Affiche : "+messageSaisie,messageSaisie,ecranProgrammeATester.readLine());
     clavierProgrammeATester.write(saisie+finDeLigne); clavierProgrammeATester.flush();
     assertEquals("Affiche : "+affichage1,affichage1,ecranProgrammeATester.readLine());
     assertEquals("Affiche : "+affichage2,affichage2,ecranProgrammeATester.readLine());
  }
  public void test_31_3_2013() throws IOException {
    String messageSaisie = "Saisir une date : jour mois annee ? " ;
    String[] ligneJeuDEssai = {"31 3 2013","Le lendemain du 31/3/2013","sera le 1/4/2013."} ;
    assertsPourSaisieValide(messageSaisie,ligneJeuDEssai[0],ligneJeuDEssai[1],ligneJeuDEssai[2]);
  }
  
  // Saisies invalides
  protected void assertsPourSaisieInvalide(String messageSaisie,String saisie,String affichage) throws IOException {
     assertEquals("Affiche : "+messageSaisie,messageSaisie,ecranProgrammeATester.readLine());
     clavierProgrammeATester.write(saisie+finDeLigne); clavierProgrammeATester.flush();
     assertEquals("Affiche : "+affichage,affichage,ecranProgrammeATester.readLine());
  }

  public void test_1_1_1581() throws IOException {
    String messageSaisie = "Saisir une date : jour mois annee ? " ;
    String[] ligneJeuDEssai = {"1 1 1581","La date du 1/1/1581 n'est pas une date valide."} ;
    assertsPourSaisieInvalide(messageSaisie,ligneJeuDEssai[0],ligneJeuDEssai[1]);
  }

  public void test_32_1_2013() throws IOException {
    String messageSaisie = "Saisir une date : jour mois annee ? " ;
    String[] ligneJeuDEssai = {"32 1 2013","La date du 32/1/2013 n'est pas une date valide."} ;
    assertsPourSaisieInvalide(messageSaisie,ligneJeuDEssai[0],ligneJeuDEssai[1]);
  }

} // fin class
