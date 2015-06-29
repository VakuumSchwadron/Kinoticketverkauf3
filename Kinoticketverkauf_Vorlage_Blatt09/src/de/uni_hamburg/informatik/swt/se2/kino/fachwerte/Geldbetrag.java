package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;


public final class Geldbetrag
{
    //TODO Grenzen vom long aufpassen
    private final long _betrag;

    /**
     * 
     * @param euro
     * @param cent
     * 
     * 
     */
    public Geldbetrag(long betrag)
    {
        _betrag = betrag;
    }

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

    public long getBetrag()
    {
        return _betrag;
    }

    public Geldbetrag addiere(Geldbetrag summand)
    {
        return new Geldbetrag(_betrag + summand.getBetrag());
    }

    public Geldbetrag subtrahiere(Geldbetrag subtrahend)
    {
        return new Geldbetrag(_betrag - subtrahend.getBetrag());
    }

    /**
     * 
     * @param i
     * @return
     * 
     */
    public Geldbetrag multipliziereMit(int i)
    {
        return new Geldbetrag(i * _betrag);
    }

    /**
     * 
     * @param s
     * @return
     * @throws Exception
     * @require s != null
     */
    public static Geldbetrag umwandlungStringZuGeldbetrag(String s) throws Exception //wie macht man das noch mal mit den Exceptions?
    {
        String[] komponenten = s.split(",", 2); //der String wird maximal in zwei Strings aufgeteilt und zwar beim ersten Komma

        if (komponenten.length == 1)
        {
            return new Geldbetrag(Long.parseLong(komponenten[0]) * 100);
        }

        return new Geldbetrag(Long.parseLong(komponenten[0]) * 100
                + Long.parseLong(komponenten[1]));

    }

    public static Geldbetrag umwandlungIntZuGeldbetrag(int betrag)
    {
        return new Geldbetrag(betrag);
    }
    
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
