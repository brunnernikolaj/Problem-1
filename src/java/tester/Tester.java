/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entities.GroupInfo;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import util.WebScraper;

/**
 *
 * @author Nikolaj
 */
public class Tester {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        WebScraper scraper = new WebScraper();
        
        List<GroupInfo> groups = scraper.scrapeData();
        
        for (GroupInfo info : groups){
            System.out.println(info);
            System.out.println("");
        }
    }
}
