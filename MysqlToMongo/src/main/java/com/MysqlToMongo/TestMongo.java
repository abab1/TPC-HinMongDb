package com.MysqlToMongo;

import java.net.UnknownHostException;
import java.text.DecimalFormat;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class TestMongo {
	
	public static void main (String args[]) throws UnknownHostException {
		MongoClient mongo = new MongoClient();
		MongoDatabase db =  mongo.getDatabase("recommended4U");
		MongoCollection<Document> collection1 = db.getCollection("Ratings");
		MongoCollection<Document> collection2 = db.getCollection("products1");
		
		String historyTags[] = "Teixeira".split(" ");
		String regex = "";
		for (String tags : historyTags) {
			regex += "[\\w,\\d, ]*" + tags+ "[\\w,\\d, ]*";
		}
		
		Double d = 2.63333333;
		DecimalFormat df = new DecimalFormat("#.#");
		String s = df.format(d);
		System.out.println(s);
		
		/*FindIterable<Document> iterable2 = collection1.find(Filters.eq("asin", "B007J4FD5M"));
		Document prod = iterable2.first();
		System.out.println(prod);*/
		
		/*FindIterable<Document> iterable = collection1.find(Filters.regex("title", regex, "ix")).sort(new BasicDBObject("score_2", -1)).limit(28);
		for (Document document : iterable) {
			String asin = (String) document.getString("asin");
			Double score = (Double) document.get("score_2");
			System.out.println(score);
			FindIterable<Document> iterable2 = collection2.find(Filters.eq("asin", asin));
			Document prod = iterable2.first();
			String title = (String) prod.get("title");
			System.out.println(title);
		}*/

		
		//FindIterable<Document> iterable = collection.find(Filters.regex("title", regex, "ix"));
		/*FindIterable<Document> iterable1 = collection1.find();
		for (Document document : iterable1) {
			String asin = (String) document.getString("asin");
			FindIterable<Document> iterable2 = collection2.find(Filters.eq("asin", asin));
			Document prod = iterable2.first();
			String title = (String) prod.get("title");
			collection1.updateOne(document, new Document("$set", new Document("title", title)));
			
		}*/
		
		/*for (int i=1; i<historyTags.length;i++) {
			iterable = iterable.filter(Filters.regex("title",historyTags[i], "ix"));
		}*/
		
		System.out.println("fetching");
		
		////iterable.limit(5);
		
		//for (Document document : iterable) {
			//System.out.println(document);
		//}

		//FindIterable<Document> iterable = collection.find(eq("userId", "abhi.007.happy@gmail.com"));
		//Document user = iterable.first();
		/*if (user != null) {
			String str = (String) user.get("recentHistory");
			if (!str.equals("")) {
				System.out.println("Not Null"+str);
			} else 
			{
				System.out.println("Null");
			}
			//str = str + ",Foundation";
			//collection.updateOne(new Document("userId","abhi.007.happy@gmail.com"), new Document("$set", new Document("recentHistory", str)));
			//collection.updateOne(user, new Document("$set", new Document("dasdas", user.get("recentHistory")+",Skin")));
			//System.out.println("Not Null");	
		} else {
			System.out.println("Null");
		}*/
		
		
		
		
		
		mongo.close();
	}

}
