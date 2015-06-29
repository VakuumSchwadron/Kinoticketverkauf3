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
        //TODO Evtl soll da 00,00 stehen...?
        assertEquals(betrag4.stringRepraesentation(), "-0,05");
    }
    
    @Test
    public void testeAddiere()
    {
        Geldbetrag betrag1 = new Geldbetrag(730);
        Geldbetrag betrag2 = new Geldbetrag(-840);
        Geldbetrag betrag3 = new Geldbetrag(0);
        Geldbetrag betrag4 = new Geldbetrag(-4235);
        
        assertTrue(betrag1.addiere(betrag2).getBetrag() == -110);
        assertTrue(betrag1.addiere(betrag3).getBetrag() == 730);
        assertTrue(betrag2.addiere(betrag4).getBetrag() == -5075);
        assertTrue(betrag3.addiere(betrag4).getBetrag() == -4235);
        
    }
    
    @Test
    public void testeSubtrahiere()
    {
        Geldbetrag betrag1 = new Geldbetrag(730);
        Geldbetrag betrag2 = new Geldbetrag(-840);
        Geldbetrag betrag3 = new Geldbetrag(0);
        Geldbetrag betrag4 = new Geldbetrag(4235);
        
        assertTrue(betrag1.subtrahiere(betrag2).getBetrag() == 1570);
        assertTrue(betrag1.subtrahiere(betrag3).getBetrag() == 730);
        assertTrue(betrag2.subtrahiere(betrag4).getBetrag() == -5075);
        assertTrue(betrag3.subtrahiere(betrag4).getBetrag() == -4235);
        
    }
    
    @Test
    public void testeUmwandlungStringZuGeldbetrag() throws Exception
    {
        assertTrue(Geldbetrag.umwandlungStringZuGeldbetrag("22,50").equals(new Geldbetrag(2250)));
        assertTrue(Geldbetrag.umwandlungStringZuGeldbetrag("-55").equals(new Geldbetrag(-5500)));
    }

}
