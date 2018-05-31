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
import org.apache.commons.net.whois.WhoisClient;

public class WhoIsQuery {
    private String url;
    private StringBuilder reply;
    private WhoisClient client;


    public StringBuilder getReply() {
        return reply;
    }

    public WhoIsQuery(String url, String server) {
        System.out.println("server is "+server);
        this.url = url;
        try{
            if(!server.isEmpty()) client.connect(server);
            else
            {
                System.err.println("Server string is empty");
                throw new Exception();
            }
            String buffer = client.query(this.url);
            this.reply.append(buffer);
            client.disconnect();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}


