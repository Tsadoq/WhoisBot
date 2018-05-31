//              .                       The information contained on current file (the "Service") is for general information purposes only.
//              |\                      
//              | \
//              |  \                    In no event shall be liable for any special, direct, indirect, consequential, or incidental damages  
//              |  |                    or any damages whatsoever, whether in an action of contract, negligence or other tort, arising out of
//              |  |)                   or in connection with the use of the Service or the contents of the Service. reserves the right to make 
//              |  | )                  additions, deletions, or modification to the contents on the Service at any time without prior notice.
//              |  |_)
//             /|  / /
//            /_| /_/|                  © by Matteo Villosio. All rights reserved
//            | | | ||
//            | | | ||
//            | | | ||\                 Informations and contacts @ tsadoq.github.io
//           /| | | || \
//          / | | | ||  \
//         /  | | | ||   \
//        /   | | | ||    \
//       /    | | | ||     \
//      /     | | | ||      \
//      \  ___| | | ||___   /
//       --   | | | ||\  ---
//           /| | | |\  \
//          / \_/ \_/ \___|
//         /  |     |  \
//         \__|     |__/


package io.github.tsadoq.WhoisBot.WhoIsQuery;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class WhoisServerList {
    private HashMap<String,String> list = new HashMap<>();

    public WhoisServerList() {

        URL pageWhoisServerList = null;

        try {
            pageWhoisServerList = new URL("https://raw.githubusercontent.com/Tsadoq/Whois-Server-List/master/whoislist.txt");
        } catch (MalformedURLException e) {
            System.err.println("Error in the Url");
        }

        InputStream in = null;
        try {
            in = pageWhoisServerList.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(in);

        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(",");
            list.put(line[0],line[1]);
        }

        System.out.println("HashMap has been filled.");
    }

    public String getServer(String url){
        String[] split = url.split("\\.");
        return list.get(split[split.length-1]);

    }

}
