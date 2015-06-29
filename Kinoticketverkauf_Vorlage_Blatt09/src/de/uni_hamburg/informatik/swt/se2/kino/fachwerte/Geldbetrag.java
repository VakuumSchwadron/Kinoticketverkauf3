package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

/**
 * Ein Geldbetrag in Euro von der Form 'EE,CC'.
 * 
 *  
 * @author VakuumSchwadron
 * @version SoSe 2015
 */
public final class Geldbetrag
{
   //Der Geldbetrag wird intern als Eurocent in einem Long gespeichert.
	private final long _betrag; //TODO Grenzen vom long aufpassen

    /**
     * Initialisiert ein Exemplar von Geldbetrag
     * 
     * @param betrag Der Geldbetrag in Eurocent
     */
	public Geldbetrag(long betrag)
    {
        _betrag = betrag;
    }

	/**
	 * Liefert einen String, in dem der Geldbetrag in der Form "EE,CC" steht.
	 * @return Der Geldbetrag in String-Repraesentation ("EE,CC")
	 */
    public String stringRepraesentation()
    {
        String euro = Long.toString(Math.abs(_betrag / 100));
        String cent = Long.toString(Math.abs(_betrag % 100));

        if (Math.abs((_betrag % 100)) < 10)
        {
            cent = "0" + cent;
        }
        if(_betrag < 0)
        {
            return "-" + euro + "," + cent;
        }
        return euro + "," + cent;
    }

    /**
     * Liefert den Long, in dem der Geldbetrag in Eurocent gespeichert ist.
     * 
     * @return Geldbetrag in Eurocent
     */
    public long getBetrag()
    {
        return _betrag;
    }

    /**
     * Addiert die uebergebenen Geldbetraege.
     * 
     * @param summand1 Erster Summand
     * @param summand2 Zweiter Summand
     * @return Die Summe aus den beiden Geldbetraegen
     * 
     *  @require summand1 != null
     *  @require summand2 != null
     */
    public static Geldbetrag addiere(Geldbetrag summand1, Geldbetrag summand2)
    {
        assert summand1 != null : "Vorbedingung verletzt: null";
        assert summand2 != null : "Vorbedingung verletzt: null";
    	
    	return new Geldbetrag(summand1.getBetrag() + summand2.getBetrag());
    }

    /**
     * Subtrahiert den übergebenen Subtrahend vom Minuenden. 
     * 
     * @param subtrahend Geldbetrag, der abgezogen werden soll
     * @param minuend Geldbetrag, von dem abgezogen werden soll
     * @return Die Differenz aus den übergebenen Geldbetraegen.
     * 
     *  @require subtrahend != null
     *  @require minuend != null
     */
    public static Geldbetrag subtrahiere(Geldbetrag minuend, Geldbetrag subtrahend)
    {
    	assert subtrahend != null : "Vorbedingung verletzt: null";
    	assert minuend != null : "Vorbedingung verletzt: null";
    	
    	return new Geldbetrag(minuend.getBetrag() - subtrahend.getBetrag());
    }

    /**
     * Multipliziert den Geldbetrag mit dem angegebenen Faktor.
     * 
     * @param i Faktor, mit dem der Geldbetrag multipliziert wird
     * @param betrag Der Geldbetrag, der multipliziert wreden soll
     * 
     * @return Produkt aus dem Geldbetrag und dem übergebenen Faktor
     */
    public static Geldbetrag multipliziereMit(int i, Geldbetrag betrag)
    {
        return new Geldbetrag(i * betrag.getBetrag());
    }

    /**
     * Ein übergebener String wird in einen Geldbetrag konvertiert.
     * Dies ist nur dann möglich, wenn der String die Form "EE,CC", "EE" bzw ",CC" erfüllt. 
     * 
     * @param s String, der in einen Geldbetrag umgewandelt werden sollen
     * @return Geldbetrag, der im String als Text geschrieben wurde
     * @throws Exception Der String erfüllt nicht die Form "EE,CC", "EE" bzw ",CC"
     * 
     * @require s != null
     */
    public static Geldbetrag umwandlungStringZuGeldbetrag(String s) throws GameOfThrowsException 
    {
    	assert s != null : "Vorbedingung verletzt: null";

    	String[] komponenten = s.split(",", 2); //der String wird maximal in zwei Strings aufgeteilt und zwar beim ersten Komma

        try
        {
            if(komponenten[0].equals("")||komponenten[0].equals("-"))
        
        {
        	komponenten[0] = "0";
        }
        if (komponenten.length == 1 || komponenten[1].equals(""))
        {
            return new Geldbetrag(Long.parseLong(komponenten[0]) * 100);
        }
        if(komponenten[1].length() > 2)
        		{
        	throw new Exception();
        		}
        if(komponenten[1].length()==1)
        {
            return new Geldbetrag(Long.parseLong(komponenten[0]) * 100
                    + Long.parseLong(komponenten[1])*10);
        }
        }
        catch(Exception e)
        {
            throw new GameOfThrowsException();
        }

        return new Geldbetrag(Long.parseLong(komponenten[0]) * 100
                + Long.parseLong(komponenten[1]));
    }

    /**
     * Ein übergebener int, der den Geldbetrag in Eurocent angibt, wird in einen Geldbetrag konvertiert.
     * 
     * @param betrag Geldbetrag in Eurocent, der in einen Geldbetrag umgewandelt werden sollen
     * @return Geldbetrag, der im int in Eurocent angegeben wurde
     * 
     */
    public static Geldbetrag umwandlungIntZuGeldbetrag(int betrag)
    {
        return new Geldbetrag(betrag);
    }
    
    /**
    * Ein übergebener Integer, der den Geldbetrag in Eurocent angibt, wird in einen Geldbetrag konvertiert.
    * 
    * @param betrag Geldbetrag in Eurocent, der in einen Geldbetrag umgewandelt werden sollen
    * @return Geldbetrag, der im int in Eurocent angegeben wurde
    * 
    */
    public static Geldbetrag umwandlungIntegerZuGeldbetrag(Integer betrag)
    {
        return new Geldbetrag(betrag.intValue());
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Geldbetrag)
        {
            Geldbetrag geldbetrag = (Geldbetrag) o;
            return _betrag == geldbetrag.getBetrag();
        }
        
        return false;
    }
    
    @Override
    public int hashCode()
    {
    	int hash =  (int) Math.abs(_betrag);
        return hash;
    }
    
}
