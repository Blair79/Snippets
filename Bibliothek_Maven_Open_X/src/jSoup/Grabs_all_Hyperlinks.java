package jSoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Grabs_all_Hyperlinks {

	public static void main(String[] args) {

		Document doc;
		try {

			// It’s recommended to specify a “userAgent” in Jsoup, to avoid HTTP
			// 403 error messages.
			// need http protocol
			doc = Jsoup.connect("http://google.com").userAgent("Mozilla").get();

			// get page title
			String title = doc.title();
			System.out.println("title : " + title);

			// get all links
			Elements links = doc.select("a[href]");
			for (Element link : links) {

				// get the value from href attribute
				System.out.println("\nlink : " + link.attr("href"));
				System.out.println("text : " + link.text());

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}