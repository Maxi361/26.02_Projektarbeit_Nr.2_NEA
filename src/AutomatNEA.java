public class AutomatNEA {
  
  private Zustand startzustand;
  private List<Zustand> aktiveZustaende;
  private List<Zustand> EndZustaende;
  private List<Zustand> speicher;
  Q1 q0 = new Q1();

  Q1 q1 = new Q1();
  Q2 q2 = new Q2();





  String parseStrg;
  boolean ok = true;
  char zeichen;

  // Konstruktor



  char cutFirst () {
    if (parseStrg.length() == 0)
      return '$';
    else {
      char first =parseStrg.charAt(0);
      parseStrg=parseStrg.substring (1);
      return first;
    }
  }



  public class Q0 extends Zustand {

    public Q0() {
      super();
    }
    
    public List<Zustand> gibFolgezustaendeA() {
      List<Zustand> liste = new List();
       //Q1 q1 = new Q1();
        liste.append(q1);
      return liste;
    }
    public List<Zustand> gibFolgezustaendeB() {
      List<Zustand> speicher = new List();
      //Q1 q1 = new Q1();
      //Q2 q2 = new Q2();

      speicher.append(q1);
      speicher.append(q2);
      return speicher;
    }
    public boolean istEndzustand() {
      return false;
    }
    
  }
  
  public class Q1 extends Zustand {
  
    public Q1() {
      super();
    }
    public List<Zustand> gibFolgezustaendeA() {

      return null;
    }
    public List<Zustand> gibFolgezustaendeB() {
      List<Zustand> speicher = new List();
      //Q2 q2 = new Q2();

      speicher.append(q2);
      return speicher;
    }


    public boolean istEndzustand() {
      return false;
    }
    
  }

  public class Q2 extends Zustand {
  
    public Q2() {
      super();
    }

    public List<Zustand> gibFolgezustaendeA() {
      List<Zustand> speicher = new List();
      //Q1 q1 = new Q1();
      speicher.append(q1);
      return speicher;
    }
    public List<Zustand> gibFolgezustaendeB() {

      return null;
    }
    
    public boolean istEndzustand() {
      return false;
    }
    
  }
  

  
  public void pruefeWort(String s){
    parseStrg = s;
    aktiveZustaende = new List<>();
    speicher = new List<>();

    zeichen = cutFirst();
    aktiveZustaende.append(q0);
    aktiveZustaende.toFirst();
    while (zeichen != '$') {
      for(aktiveZustaende.toFirst();aktiveZustaende.hasAccess()==true;aktiveZustaende.next()) {

        if (zeichen == 'a') {
          aktiveZustaende.getContent().gibFolgezustaendeA();

        }
        if (zeichen == 'b') {
          aktiveZustaende.getContent().gibFolgezustaendeB();
        }


      }

      aktiveZustaende = speicher;
      zeichen = cutFirst();
      for(speicher.toFirst();speicher.hasAccess()==true;speicher.next()) {
        speicher.remove();
      }
    }
    System.out.println(this.akzeptiert());

  }

  public String akzeptiert() {
    for(aktiveZustaende.toFirst();aktiveZustaende.hasAccess()==true;aktiveZustaende.next()) {
    if (aktiveZustaende.getContent()==q0 || aktiveZustaende.getContent()==q1);
    return "ja";
    }
      return "nein";
  }
  
}
