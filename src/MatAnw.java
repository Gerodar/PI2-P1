import java.io.*;

public class MatAnw
{
    public static void main(String[] args)
    {
        try
        {
        FileReader fr1 = new FileReader("MATA.TXT");
        BufferedReader br1 = new BufferedReader(fr1);
        Mat mat;

        mat = einMat(br1);
        if(mat != null)
        {
            mat.ausgabe();
            mat.ausgabe("dsx");
        }

        } catch (IOException ex)
        {
            System.out.println("IO-Fehler");
        }
    }

    public static Mat einMat(BufferedReader br1) throws IOException
    {
        String csv = null;
        String[] ecsv = null;
        Mat mat = new Mat();
        String delim = ";";
        int laenge = 0;

        mat.a = null;

        try
        {
            csv = br1.readLine();
            if (csv != null)
            {
                laenge = csv.split(delim).length;
            }

            while (csv != null)
            {
                mat.a = zeileAnhaengen(mat, csv, laenge);
                csv = br1.readLine();
            }

            return mat;
        } catch (NumberFormatException ex)
        {
            System.out.println("Es gab einen Fehler beim Umwandeln einer Zahl");
            System.out.println("Der Fehler trat beim Erfassen des CSV " + csv + " auf");
            return null;
        }
    }

    public static double[][] zeileAnhaengen(Mat mat, String csv, int laenge) throws NumberFormatException
    {
        String[] ecsv;
        String delim = ";";
        double[][] b;
        if(mat.a == null)
        {
            b = new double[1][laenge];
        } else
        {
            b = new double[mat.a.length + 1][laenge];
            for (int i = 0; i < mat.a.length; i++)
            {
                for (int j = 0; j < mat.a[i].length; j++)
                {
                    b[i][j] = mat.a[i][j];
                }
            }
        }

            ecsv = csv.split(delim);
            for (int j = 0; j < b[0].length; j++)
            {
                try
                {
                    b[b.length - 1][j] = Double.parseDouble(ecsv[j]);
                } catch(ArrayIndexOutOfBoundsException ex)
                {
                    b[b.length - 1][j] = 0;
                }
            }
        return b;
    }

}
