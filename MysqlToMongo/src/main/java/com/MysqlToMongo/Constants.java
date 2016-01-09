package com.MysqlToMongo;

import java.util.Arrays;
import java.util.List;


/**
 * @author Abhishek
 *
 */
public class Constants {

	public static final List<String> MAP_CUSTOMER_1TO1 = Arrays.asList("custkey,name,address,nationkey,phone,acctbal,mktsegment,comment".split(","));
	public final List<String> MAP_LINEITEM_1TO1 = Arrays.asList("orderkey,partkey,suppkey,linenumber,quantity,extendedprice,discount,tax,returnflag,linestatus,shipdate,commitdate,receiptdate,shipinstruct,shipmode,comment".split(","));
	public final List<String> MAP_NATION_1TO1 = Arrays.asList("nationkey,name,regionkey,comment".split(","));
	public final List<String> MAP_ORDERS_1TO1 = Arrays.asList("orderkey,custkey,orderstatus,totalprice,orderdate,orderpriority,clerk,shippriority,comment".split(","));
	public final List<String> MAP_PART_1TO1 = Arrays.asList("partkey,name,mfgr,brand,type,size,container,retailprice,comment".split(","));
	public final List<String> MAP_PARTSUPP_1TO1 = Arrays.asList("partkey,suppkey,availqty,supplycost,comment".split(","));
	public final List<String> MAP_REGION_1TO1 = Arrays.asList("regionkey,name,comment".split(","));
	public final List<String> MAP_SUPPLIER_1TO1 = Arrays.asList("suppkey,name,address,nationkey,phone,acctbal,comment".split(","));
	
	public static void main (String args[]) {
		for (String s : MAP_CUSTOMER_1TO1) {
			System.out.println(s);
		}
	}
	
}
