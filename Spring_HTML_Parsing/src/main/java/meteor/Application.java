package meteor;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.meteor.module.Scheduler;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) throws IOException {
        
    	Scheduler scheduler = new Scheduler();
    	
    	while(true) {
	    	Document doc = Jsoup.connect("http://ivp.co.kr/tree/index.php?vpname=today").get();
	        Elements news_tablElement = doc.select("table");
	        
	        for(Element element : news_tablElement) {
	        	scheduler.run( "html\n" + element.html() );
	        	scheduler.run( "text\n" + element.text() );
	        }
	        

			try {
				Thread.sleep(1000*60*60*12);//12시간
				//Thread.sleep(1000*5);
				//Thread.sleep(1000*10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//5초
	        
    	}
    	
    	
    	
    	//new Thread(scheduler).start();
    	
    	/*
    	Document doc = Jsoup.connect("http://ivp.co.kr/tree/index.php?vpname=today").get();
        Elements news_tablElement = doc.select("table");
        
        System.out.println("doc : " + doc);
        System.out.println("news_tablElement : " + news_tablElement);
        
        System.out.println("--------------------------");
        
        for(Element element : news_tablElement) {
        	System.out.println("text : " + element.text() );
        	System.out.println("html : " + element.html() );
        }
         
    	SpringApplication.run(Application.class, args);
       */
    }
}
