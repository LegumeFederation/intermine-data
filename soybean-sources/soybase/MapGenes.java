import java.io.BufferedReader;
import java.io.FileReader;

import java.util.HashMap;

/**
 * Map the v1 gene IDs to v2 gene IDs in the first file using the tab-delimited map in the second file.
 */

public class MapGenes {

    public static void main(String[] args) {

        if (args.length<2) {
            System.err.println("Usage: MapGenes <genes file> <map file>");
            System.exit(1);
        }

        try {
            
            String line;

            // build the map
            HashMap<String,String> map = new HashMap<String,String>();
            BufferedReader mapReader = new BufferedReader(new FileReader(args[1]));
            while ((line=mapReader.readLine())!=null) {
                String[] parts = line.split("\t");
                map.put(parts[1], parts[0]);
            }
                
            // go through the genes file
            BufferedReader geneReader = new BufferedReader(new FileReader(args[0]));
            while ((line=geneReader.readLine())!=null) {
                String[] parts = line.split("\t");
                String v2name = map.get(parts[0]);
                if (v2name!=null) {
                    System.out.print(v2name);
                    for (int i=1; i<parts.length; i++) System.out.print("\t"+parts[i]);
                    System.out.println("");
                }
            }

        } catch (Exception ex) {
            
            System.err.println(ex.getMessage());
            System.exit(1);

        }

    }

}
