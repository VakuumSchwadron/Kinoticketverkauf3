package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

public class GameOfThrowsException extends Exception
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameOfThrowsException(String s)
	{
		switch (s.length())
		{
			case 1: System.out.print("Idiot! Betraege gibt man mit EE,CC an. Das weiss man doch!! \n");
			break;
			case 2: System.out.print("Hallo!? Hörst Du überhaupt zu!? \n");
			break;
			case 3: System.out.print("Hör bitte auf, mich zu missbrauchen! =( \n");
			break;
			case 4: System.out.print("Besuche www.reddit.com/r/botsrights für mehr Informationen! \n");
			break;
			case 5: System.out.print("Ahhhhhhhhhhhhhhh!!!! HILFE!!!!!!!! \n");
			break;
			default: System.out.print("HODOR! \n");
			break;
			
		}
	}
}
