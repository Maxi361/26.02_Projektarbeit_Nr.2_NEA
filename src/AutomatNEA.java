public class AutomatNEA {
  
  private Zustand startzustand;
  private List<Zustand> aktiveZustaende;
  private List<Zustand> EndZustaende;
  private List<Zustand> speicher;




  String parseStrg;
  boolean ok = true;
  char zeichen;

  // Konstruktor

  public AutomatNEA (String s) {
    parseStrg = s;
  }

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
       Q1 q1 = new Q1();
        liste.append(q1);
      return liste;
    }
    public List<Zustand> gibFolgezustaendeB() {
      List<Zustand> speicher = new List();
      Q1 q1 = new Q1();
      Q2 q2 = new Q2();

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
      Q2 q2 = new Q2();

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
      Q1 q1 = new Q1();
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
  

  
  public void pruefeWort(String pWort) {
    aktiveZustaende = new List<>();
    speicher = new List<>();

    zeichen = cutFirst();
    Q0 q0 = new Q0();
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
    }

  }

  public boolean akzeptiert() {
    for(aktiveZustaende.toFirst();aktiveZustaende.hasAccess()==true;aktiveZustaende.next()) {
    if (aktiveZustaende.getContent()
    }

    return false;
  }
  
}
