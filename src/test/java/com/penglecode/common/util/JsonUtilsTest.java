package com.penglecode.common.util;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;

public class JsonUtilsTest {

	private List<Address> addresses;
	
	private Person father;
	
	private Person mather;
	
	private Person me;
	
	@Before
	public void setUp(){
		Address addr1 = new Address(1L, "南京市白下区中山南路1号");
		Address addr2 = new Address(1L, "南京市白下区长江路1号");
		addresses = Arrays.asList(addr1, addr2);
		
		father = new Person(1L, "1234567890", null, 45, '男', 75.8, DateTimeUtils.parse("1968-08-12", "yyyy-MM-dd"));
		father.setAddresses(addresses);
		mather = new Person(2L, "1234567891", "My Mather", 42, '女', 60.5, DateTimeUtils.parse("1971-05-23", "yyyy-MM-dd"));
		mather.setAddresses(addresses);
		
		Map<String,Person> parents = new HashMap<String,Person>();
		parents.put("father", father);
		parents.put("mather", mather);
		me = new Person(12L, "12345678901", "jackson", 25, '男', 65.0, DateTimeUtils.parse("1989-12-28", "yyyy-MM-dd"));
		me.setAddresses(addresses);
		me.setParents(parents);
	}
	
	@Test
	public void testObject2Json(){
		String json = null;
		System.out.println("-------------------addresses---------------");
		json = JsonUtils.object2Json(addresses);
		System.out.println(json);
		System.out.println("-------------------father------------------");
		json = JsonUtils.object2Json(father);
		System.out.println(json);
		System.out.println("-------------------mather------------------");
		json = JsonUtils.object2Json(mather);
		System.out.println(json);
		
		System.out.println("---------------------me--------------------");
		json = JsonUtils.object2Json(me);
		System.out.println(json);
	}
	
	@Test
	@SuppressWarnings("rawtypes")
	public void testJson2Object1(){
		List addressList = null;
		String json = null;
		System.out.println("-------------------addresses---------------");
		json = JsonUtils.object2Json(addresses);
		
		addressList = JsonUtils.json2Object(json, List.class); //此处fastjson默认将json数组中的元素转换成com.alibaba.fastjson.JSONObject对象
		for(Object addr : addressList){
			System.out.println(addr.getClass() + " : " + addr);
		}
		
		addressList = JsonUtils.json2Object(json, new TypeReference<List<Map<String,Object>>>(){}); //将json数组中的元素转换成指定类型Map<String,Object>
		for(Object addr : addressList){
			System.out.println(addr.getClass() + " : " + addr);
		}
		
		addressList = JsonUtils.json2Object(json, new TypeReference<List<Address>>(){}); //将json数组中的元素转换成指定类型Address
		for(Object addr : addressList){
			System.out.println(addr.getClass() + " : " + JsonUtils.object2Json(addr));
		}
	}
	
	@Test
	public void testJson2Object2(){
		Object object = null;
		String json = null;
		System.out.println("-------------------father---------------");
		json = JsonUtils.object2Json(father);
		
		object = JsonUtils.json2Object(json, Map.class); //将json转换成指定类型Map<String,Object>(注意其属性addresses是com.alibaba.fastjson.JSONArray[com.alibaba.fastjson.JSONObject])
		System.out.println(object.getClass() + " : " + object);
		
		object = JsonUtils.json2Object(json, Person.class); //将json转换成指定类型Person
		System.out.println(object.getClass() + " : " + JsonUtils.object2Json(object));
	}
	
	@Test
	public void testJson2Object3(){
		Object object = null;
		String json = null;
		System.out.println("-------------------me---------------");
		json = JsonUtils.object2Json(me);
		
		object = JsonUtils.json2Object(json, Person.class); //将json转换成指定类型Person
		String json2 = JsonUtils.object2Json(object);
		System.out.println(object.getClass() + " : " + json2);
		System.out.println(json.equals(json2));
	}
	
}

class Person {
	
	private Long id;
	
	private String idcard;
	
	private String name;
	
	private int age;
	
	private char sex;
	
	private double weight;
	
	@JSONField(name="birthDay", format="yyyy-MM-dd")
	private Date birthday;
	
	private List<Address> addresses;
	
	private Map<String,Person> parents;

	public Person() {
		super();
	}

	public Person(Long id, String idcard, String name, int age, char sex,
			double weight, Date birthday) {
		super();
		this.id = id;
		this.idcard = idcard;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.weight = weight;
		this.birthday = birthday;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Map<String, Person> getParents() {
		return parents;
	}

	public void setParents(Map<String, Person> parents) {
		this.parents = parents;
	}
	
}

class Address {
	
	private Long id;
	
	private String address;

	public Address() {
		super();
	}

	public Address(Long id, String address) {
		super();
		this.id = id;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
