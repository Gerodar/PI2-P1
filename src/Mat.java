import java.io.*;

public class Mat
{
    public double[][] a;

    Mat()
    {

    }

    public void ausgabe()
    {
        for(int i = 0; i < a.length; i++)
        {
            System.out.println("\nZeile " + i);
            for(int j = 0; j < a[i].length; j++)
            {
                System.out.print("(" + a[i][j] + ") ");
            }
        }
    }

    public void ausgabe(String dsx) throws IOException
    {
        FileWriter fw1 = new FileWriter("dsx.txt");
        PrintWriter pw1 = new PrintWriter(fw1);
        String aus = null;

        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < a[i].length; j++)
            {
                if(aus == null)
                {
                    aus = a[i][j] + ";";
                } else
                {
                    aus = aus + a[i][j] + ";";
                }
            }
            if(!(aus == null) && aus.length() > 0)
            {
                aus = aus.substring(0, aus.length() - 1);
            }
            pw1.println(aus);
            aus = null;
        }

        fw1.close();
        pw1.close();
    }
}
