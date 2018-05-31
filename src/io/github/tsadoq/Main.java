package io.github.tsadoq;
import io.github.tsadoq.WhoisBot.WhoIsQuery.WhoIsQuery;
import io.github.tsadoq.WhoisBot.WhoIsQuery.WhoisServerList;

public class Main {

    public static void main(String[] args) {
        WhoisServerList db = new WhoisServerList();
        WhoIsQuery query = new WhoIsQuery("polito.it",db.getServer("polito.it"));
        System.out.println(query.getReply());

    }
}
