package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import static org.junit.Assert.*;

import org.junit.Test;
 
public class GeldbetragTest
{
    @Test
    public void testeStringRepraesentation()
    {
        Geldbetrag betrag1 = new Geldbetrag(1000);
        Geldbetrag betrag2 = new Geldbetrag(-25486);
        Geldbetrag betrag3 = new Geldbetrag (0);
        Geldbetrag betrag4 = new Geldbetrag(-5); 
        
        assertEquals(betrag1.stringRepraesentation(), "10,00");
        assertEquals(betrag2.stringRepraesentation(), "-254,86");
        assertEquals(betrag3.stringRepraesentation(), "0,00");
        assertEquals(betrag4.stringRepraesentation(), "-0,05");
    }
    
    @Test
    public void testeAddiere()
    {
        Geldbetrag betrag1 = new Geldbetrag(730);
        Geldbetrag betrag2 = new Geldbetrag(-840);
        Geldbetrag betrag3 = new Geldbetrag(0);
        Geldbetrag betrag4 = new Geldbetrag(-4235);
        
        assertTrue(Geldbetrag.addiere(betrag1,betrag1).getBetrag() == 1460);
        assertTrue(Geldbetrag.addiere(betrag1,betrag2).getBetrag() == -110);
        assertTrue(Geldbetrag.addiere(betrag1,betrag3).getBetrag() == 730);
        assertTrue(Geldbetrag.addiere(betrag2,betrag4).getBetrag() == -5075);
        assertTrue(Geldbetrag.addiere(betrag3,betrag4).getBetrag() == -4235);
        
        
    }
    
    @Test
    public void testeSubtrahiere()
    {
        Geldbetrag betrag1 = new Geldbetrag(730);
        Geldbetrag betrag2 = new Geldbetrag(-840);
        Geldbetrag betrag3 = new Geldbetrag(0);
        Geldbetrag betrag4 = new Geldbetrag(4235);
        
        assertTrue(Geldbetrag.subtrahiere(betrag1,betrag1).getBetrag() == 0);
        assertTrue(Geldbetrag.subtrahiere(betrag1,betrag2).getBetrag() == 1570);
        assertTrue(Geldbetrag.subtrahiere(betrag1,betrag3).getBetrag() == 730);
        assertTrue(Geldbetrag.subtrahiere(betrag2,betrag4).getBetrag() == -5075);
        assertTrue(Geldbetrag.subtrahiere(betrag3,betrag4).getBetrag() == -4235);
        
    }
    
    @Test
    public void testeUmwandlungStringZuGeldbetrag() throws Exception
    {
        assertTrue(Geldbetrag.umwandlungStringZuGeldbetrag("22,50").equals(new Geldbetrag(2250)));
        assertTrue(Geldbetrag.umwandlungStringZuGeldbetrag("-55").equals(new Geldbetrag(-5500)));
        assertTrue(Geldbetrag.umwandlungStringZuGeldbetrag(",8").equals(new Geldbetrag(80)));
        assertTrue(Geldbetrag.umwandlungStringZuGeldbetrag("10,").equals(new Geldbetrag(1000)));
        assertTrue(Geldbetrag.umwandlungStringZuGeldbetrag("-0").equals(new Geldbetrag(0)));
        assertTrue(Geldbetrag.umwandlungStringZuGeldbetrag("-,").equals(new Geldbetrag(0)));
        assertTrue(Geldbetrag.umwandlungStringZuGeldbetrag("1000000").equals(new Geldbetrag(100000000)));
    }
    
    @Test
    public void testeMultipliziere()
    {
        Geldbetrag betrag1 = new Geldbetrag(730);
        Geldbetrag betrag2 = new Geldbetrag(-840);
        Geldbetrag betrag3 = new Geldbetrag(0);
        Geldbetrag betrag4 = new Geldbetrag(-4235);
        
        assertTrue(Geldbetrag.multipliziereMit(0, betrag1).equals(new Geldbetrag(0)));
        assertTrue(Geldbetrag.multipliziereMit(0,betrag3).equals(new Geldbetrag(0)));
        assertTrue(Geldbetrag.multipliziereMit(-1,betrag2).equals(new Geldbetrag(840)));
        assertTrue(Geldbetrag.multipliziereMit(1000000,betrag1).equals(new Geldbetrag(730000000)));
        assertTrue(Geldbetrag.multipliziereMit(10,betrag4).equals(new Geldbetrag(-42350)));
    }
    
    @Test
    public void testeUmwandlungIntegerZuGeldbetrag()
    {        
        assertTrue(Geldbetrag.umwandlungIntegerZuGeldbetrag(Integer.MAX_VALUE).equals(new Geldbetrag(Integer.MAX_VALUE)));
        assertTrue(Geldbetrag.umwandlungIntegerZuGeldbetrag(Integer.MIN_VALUE).equals(new Geldbetrag(Integer.MIN_VALUE)));
        assertTrue(Geldbetrag.umwandlungIntegerZuGeldbetrag(new Integer(1000)).equals(new Geldbetrag(1000)));
        
    }
    
    @Test
    public void testeUmwandlungIntZuGeldbetrag()
    {
        assertTrue(Geldbetrag.umwandlungIntZuGeldbetrag(10).equals(new Geldbetrag(10)));
        assertTrue(Geldbetrag.umwandlungIntZuGeldbetrag(11).equals(new Geldbetrag(11)));
        assertTrue(Geldbetrag.umwandlungIntZuGeldbetrag(-10).equals(new Geldbetrag(-10)));
        assertTrue(Geldbetrag.umwandlungIntZuGeldbetrag(0).equals(new Geldbetrag(0)));
    }
    
    @Test
    public void testEquals()
    {
        Geldbetrag betrag1 = new Geldbetrag(730);
        Geldbetrag betrag2 = new Geldbetrag(730);
        Geldbetrag betrag3 = new Geldbetrag(1460);
        Geldbetrag betrag4 = new Geldbetrag(-730);
        
        assertTrue(betrag1.equals(betrag1));
        assertTrue(betrag1.equals(betrag2));
        assertTrue(!betrag1.equals(betrag3));
        assertTrue(!betrag1.equals(betrag4));
    }
    
    @Test
    public void testHashCode()
    {
        Geldbetrag betrag1 = new Geldbetrag(730);
        Geldbetrag betrag2 = new Geldbetrag(730);
        Geldbetrag betrag3 = new Geldbetrag(1460);
        Geldbetrag betrag4 = new Geldbetrag(-730);
        
        assertTrue(betrag1.hashCode() == betrag1.hashCode());
        assertTrue(betrag1.hashCode() == betrag2.hashCode());
        assertFalse(betrag1.hashCode() == betrag3.hashCode());
        assertTrue(betrag1.hashCode() == betrag4.hashCode());
    }
}
