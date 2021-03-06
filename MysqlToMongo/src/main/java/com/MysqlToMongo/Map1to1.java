package com.MysqlToMongo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
/**
 * Maps the entries just 1 to 1 to the MongoDB. There is no resolution about
 * keys.
 *
 * @author Abhishek
 *
 */
public class Map1to1 {

@SuppressWarnings("static-access")
public static void main(String[] args) throws UnknownHostException, MongoException {
	
	MongoClient mongo = new MongoClient( "localhost" , 27017 );
	@SuppressWarnings("deprecation")
	DB db = mongo.getDB("tpch");
	File folder = new File("C:\\Abhishek\\tpc-h data");
	FilenameFilter filter = new FilenameFilter() {
		@Override
		public boolean accept(File arg0, String arg1) {
		return arg1.endsWith(".tbl");
		}
	};
	// read all resources files
	for (String fileName : folder.list(filter)) {
		File toRead = new File(folder, fileName);
		String collName;
		List<String> keys;
		if (fileName.startsWith("customer")) {
			keys = new Constants().MAP_CUSTOMER_1TO1;
			collName = "customer";
		} else if (fileName.startsWith("lineitem")) {
			keys = new Constants().MAP_LINEITEM_1TO1;
			collName = "lineitem";
		} else if (fileName.startsWith("nation")) {
			keys = new Constants().MAP_NATION_1TO1;
			collName = "nation";
		} else if (fileName.startsWith("order")) {
			keys = new Constants().MAP_ORDERS_1TO1;
			collName = "orders";
		} else if (fileName.startsWith("part.")) {
			keys = new Constants().MAP_PART_1TO1;
			collName = "part";
		} else if (fileName.startsWith("partsupp")) {
			keys = new Constants().MAP_PARTSUPP_1TO1;
			collName = "partsupp";
		} else if (fileName.startsWith("region")) {
			keys = new Constants().MAP_REGION_1TO1;
			collName = "region";
		} else if (fileName.startsWith("supplier")) {
			keys = new Constants().MAP_SUPPLIER_1TO1;
			collName = "supplier";
		} else {
			System.out.println("unmappable file " + fileName);
			System.out.println("process stopped");
			break;
		}
	try {
	DBCollection collection = db.getCollection(collName);
	collection.drop();
	Scanner scanner = new Scanner(toRead);
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			DBObject mongoEntry = new BasicDBObject();
			String[] elements = line.split("\\|");
			for (int i = 0; i < elements.length; i++) {
			mongoEntry.put(keys.get(i),
			CastHelper.autoCast(elements[i]));
			}
			collection.insert(mongoEntry);
		}
		scanner.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		}
	}
	mongo.close();
	}
}
