/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entities.GroupInfo;
import java.util.concurrent.Callable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Nikolaj
 */
public class ScrapingCallable implements Callable<GroupInfo> {

    private String url;

    public ScrapingCallable(String url) {
        this.url = url;
    }

    @Override
    public GroupInfo call() throws Exception {
        Document doc = Jsoup.connect(url).get();

        return new GroupInfo(
                doc.select("#authors").text(),
                doc.select("#class").text(),
                doc.select("#group").text().replace("Group:", "")
        );
    }

}
