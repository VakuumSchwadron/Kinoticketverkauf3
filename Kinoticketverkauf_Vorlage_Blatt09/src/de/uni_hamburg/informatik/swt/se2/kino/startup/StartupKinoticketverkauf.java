package de.uni_hamburg.informatik.swt.se2.kino.startup;

import javax.swing.SwingUtilities;

import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.Datum;
import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.FSK;
import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.Geldbetrag;
import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.Uhrzeit;
import de.uni_hamburg.informatik.swt.se2.kino.materialien.Film;
import de.uni_hamburg.informatik.swt.se2.kino.materialien.Kino;
import de.uni_hamburg.informatik.swt.se2.kino.materialien.Kinosaal;
import de.uni_hamburg.informatik.swt.se2.kino.materialien.Vorstellung;
import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.kasse.KassenWerkzeug;

/**
 * Startet die Anwendung.
 * 
 * @author SE2-Team
 * @version SoSe 2015
 */
public class StartupKinoticketverkauf
{
    /**
     * Die Main-Methode prüft, ob Assertions aktiviert sind und startet das
     * KassenWerkzeug mit einem Default-Kino.
     * 
     * @param args Aufrufparameter werden ignoriert.
     */
    public static void main(String[] args)
    {
        if (!assertsEnabled())
        {
            throw new IllegalStateException(
                    "Asserts müssen aktiviert sein: Window > Preferences > Java > Installed JREs -> ausgewaehlte JRE markieren und auf Edit klicken > im erscheinenden Dialog bei Default VM Arguments -ea eingeben");
        }

        final Kino kino = erzeugeKinoMitBeispieldaten();
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new KassenWerkzeug(kino);
            }
        });
    }

    /**
     * Erzeugt ein Kino mit einigen Vorstellungen.
     */
    private static Kino erzeugeKinoMitBeispieldaten()
    {
        final Kinosaal[] saele = { new Kinosaal("Saal 1", 20, 25),
                new Kinosaal("Saal 2", 16, 20), new Kinosaal("Saal 3", 10, 16) };

        // Filme: Top-5 Deutschland laut kino.de in der Kalenderwoche 20, 2011.
        Film[] filme = {
                new Film("Pirates of the Caribbean - Fremde Gezeiten", 136,
                        FSK.FSK12, true),
                new Film("Fast & Furious Five", 130, FSK.FSK12, true),
                new Film("Rio", 96, FSK.FSK0, false),
                new Film("Wasser für die Elefanten", 120, FSK.FSK12, false),
                new Film("Thor", 115, FSK.FSK12, false) };

        Uhrzeit nachmittag = Uhrzeit.get(17, 30);
        Uhrzeit abend = Uhrzeit.get(20, 0);
        Uhrzeit spaet = Uhrzeit.get(22, 30);
        Uhrzeit nacht = Uhrzeit.get(1, 0);

        Datum d1 = Datum.heute();
        Datum d2 = d1.naechsterTag();
        Datum d3 = d2.naechsterTag();
        
        Geldbetrag g1 = new Geldbetrag(500);
        Geldbetrag g2 = new Geldbetrag(700);
        Geldbetrag g3 = new Geldbetrag(800);
        Geldbetrag g4 = new Geldbetrag(900);
        Geldbetrag g5 = new Geldbetrag(1000);

        final Vorstellung[] vorstellungen = {
                // Heute
                new Vorstellung(saele[0], filme[2], nachmittag, abend, d1,
                        g1),
                new Vorstellung(saele[0], filme[0], abend, spaet, d1,
                        g2),
                new Vorstellung(saele[0], filme[0], spaet, nacht, d1,
                        g2),

                new Vorstellung(saele[1], filme[3], nachmittag, abend, d1,
                        g4),
                new Vorstellung(saele[1], filme[1], spaet, nacht, d1,
                        g3),

                new Vorstellung(saele[2], filme[3], abend, spaet, d1,
                        g5),
                new Vorstellung(saele[2], filme[4], spaet, nacht, d1,
                        g4),

                // Morgen
                new Vorstellung(saele[0], filme[0], abend, spaet, d2,
                        g1),
                new Vorstellung(saele[0], filme[0], spaet, nacht, d2,
                        g2),

                new Vorstellung(saele[1], filme[2], nachmittag, abend, d2,
                        g4),
                new Vorstellung(saele[1], filme[4], abend, nacht, d2,
                        g3),

                new Vorstellung(saele[2], filme[3], nachmittag, abend, d2,
                        g5),
                new Vorstellung(saele[2], filme[1], spaet, nacht, d2,
                        g4),

                // Übermorgen
                new Vorstellung(saele[0], filme[1], abend, spaet, d3,
                        g1),
                new Vorstellung(saele[0], filme[1], spaet, nacht, d3,
                        g2),

                new Vorstellung(saele[1], filme[2], nachmittag, abend, d3,
                        g4),
                new Vorstellung(saele[1], filme[0], abend, nacht, d3,
                        g3),

                new Vorstellung(saele[2], filme[3], abend, spaet, d3,
                        g5),
                new Vorstellung(saele[2], filme[4], spaet, nacht, d3,
                        g4) };

        return new Kino(saele, vorstellungen);
    }

    /**
     * 
     * @return true, wenn asserts enabled sind, ansonsten false.
     */
    private static boolean assertsEnabled()
    {
        boolean assertsEnabled = false;
        assert assertsEnabled = true;
        return assertsEnabled;

    }
}
