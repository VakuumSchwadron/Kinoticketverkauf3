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
     * Addiert den Geldbetrag mit dem übergebenen Summanden.
     * 
     * @param summand Geldbetrag, der hinzuaddiert werden soll
     * @return Die Summe aus dem Geldbetrag und dem übergebenen Geldbetrag.
     * 
     *  @require summand != null
     */
    public Geldbetrag addiere(Geldbetrag summand)
    {
        assert summand != null : "Vorbedingung verletzt: null";
    	
    	return new Geldbetrag(_betrag + summand.getBetrag());
    }

    /**
     * Subtrahiert den übergebenen Subtrahend vom Geldbetrag. 
     * 
     * @param subtrahend Geldbetrag, der abgezogen werden soll
     * @return Die Differenz aus dem Geldbetrag und dem übergebenen Geldbetrag.
     * 
     *  @require subtrahend != null
     */
    public Geldbetrag subtrahiere(Geldbetrag subtrahend)
    {
    	assert subtrahend != null : "Vorbedingung verletzt: null";
    	
    	return new Geldbetrag(_betrag - subtrahend.getBetrag());
    }

    /**
     * Multipliziert den Geldbetrag mit dem angegebenen Faktor.
     * 
     * @param i Faktor, mit dem der Geldbetrag multipliziert wird
     * 
     * @return Produkt aus dem Geldbetrag und dem übergebenen Faktor
     */
    public Geldbetrag multipliziereMit(int i)
    {
        return new Geldbetrag(i * _betrag);
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
    public static Geldbetrag umwandlungStringZuGeldbetrag(String s) throws Exception //wie macht man das noch mal mit den Exceptions?
    {
    	assert s != null : "Vorbedingung verletzt: null";

    	String[] komponenten = s.split(",", 2); //der String wird maximal in zwei Strings aufgeteilt und zwar beim ersten Komma

        if(komponenten[0].equals(""))
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
