import java.io.*;

public class ProjAnw
{
    public static void main(String[] args)
    {
        try
        {
            Projekt[] profolge = null;
            FileReader fr1 = new FileReader("PROJEKT1.TXT");
            BufferedReader br1 = new BufferedReader(fr1);

            String ecsv;
            ecsv = br1.readLine();

            while(ecsv != null)
            {
                Projekt p = new Projekt("Default", 0, 0);
                if(p.csv2Projekt(ecsv) < 0)
                {
                    System.out.println("Projekt: " + ecsv + " ist fehlerhaft. CRT " + p.crt);
                }else
                {
                    p.csv2Projekt(ecsv);
                    System.out.println("Projekt " + p.proAus() + " ist erfolgreich mit CRT " + p.crt + " erstellt worden");
                    profolge = anhaenge(profolge, p);
                }
                ecsv = br1.readLine();
            }

            FileWriter fw1 = new FileWriter("PROJEKT3.TXT");
            PrintWriter pw1 = new PrintWriter(fw1);

            System.out.println("\nKorrekte Projekte sind: \n");
            for(int i = 0; i < profolge.length; i++)
            {
                System.out.println("Projekt " + i + " : " + profolge[i].proAus());
                pw1.println(profolge[i].proAus());
            }

            fr1.close();
            br1.close();
            fw1.close();
            pw1.close();

        } catch(IOException ex)
        {
            System.out.println("IO-Fehler");
        }
    }

    public static Projekt[] anhaenge(Projekt[] profolge, Projekt p)
    {
        Projekt[] neu = null;
        if(profolge != null)
        {
            neu = new Projekt[profolge.length + 1];
            for (int i = 0; i < profolge.length; i++)
            {
                neu[i] = profolge[i];
            }
            neu[profolge.length] = p;
        } else
        {
            neu = new Projekt[1];
            neu[0] = p;
        }
        return neu;
    }
}
