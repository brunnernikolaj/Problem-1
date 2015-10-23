
package util;

import entities.GroupInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nikolaj
 */
public class WebScraper {
    
    public List<GroupInfo> scrapeData() throws IOException, InterruptedException, ExecutionException{
        ExecutorService exec = Executors.newCachedThreadPool();
        List<ScrapingCallable> tasks = new ArrayList<>();
        
        for (String url : urls) {
            tasks.add(new ScrapingCallable(url));
        }
        
        List<Future<GroupInfo>> list = exec.invokeAll(tasks);
        exec.shutdown();
        exec.awaitTermination(15, TimeUnit.SECONDS);
        
        List<GroupInfo> groupsData = new ArrayList<>();
        
        for (Future<GroupInfo> future : list){
            groupsData.add(future.get());
        }
        
        return groupsData;
    }
    
     public List<String> urls = new ArrayList<String>() {
    {
      //Class A
      add("http://cphbusinessjb.cloudapp.net/CA2/");
      add("http://ca2-ebski.rhcloud.com/CA2New/");
      add("http://ca2-chrislind.rhcloud.com/CA2Final/");
      add("http://ca2-pernille.rhcloud.com/NYCA2/");
      add("https://ca2-jonasrafn.rhcloud.com:8443/company.jsp");
      add("http://ca2javathehutt-smcphbusiness.rhcloud.com/ca2/index.jsp");

      //Class B
      add("https://ca2-ssteinaa.rhcloud.com/CA2/");
      add("http://tomcat-nharbo.rhcloud.com/CA2/");
      add("https://ca2-cphol24.rhcloud.com/3.semCa.2/");
      add("https://ca2-ksw.rhcloud.com/DeGuleSider/");
      add("http://ca2-ab207.rhcloud.com/CA2/index.html");
      add("http://ca2-sindt.rhcloud.com/CA2/index.jsp");
      add("http://ca2gruppe8-tocvfan.rhcloud.com/");
      add("https://ca-ichti.rhcloud.com/CA2/");

      //Class COS
      add("https://ca2-9fitteen.rhcloud.com:8443/CA2/");
      add("https://cagroup04-coolnerds.rhcloud.com/CA_v1/index.html");
      add("http://catwo-2ndsemester.rhcloud.com/CA2/");
    }
  };
}
