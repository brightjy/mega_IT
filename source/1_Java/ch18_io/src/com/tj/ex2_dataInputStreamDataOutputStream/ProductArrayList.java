package com.tj.ex2_dataInputStreamDataOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
public class ProductArrayList {
	public static void main(String[] args) {
		ArrayList<Product> products = new ArrayList<Product>();
		InputStream     fis = null;
		DataInputStream dis = null;
		String name; int price; int ps;
		try {
			fis = new FileInputStream("txtFile/product.dat"); // �⺻��Ʈ�� ����
			dis = new DataInputStream(fis);                   // ������Ʈ�� ����
			while(true) {
				name = dis.readUTF(); // ���Ǹ�
				price = dis.readInt();//����
				ps = dis.readInt(); // ps
				// 1��Ʈ ������ ������� products�� �߰�
				products.add(new Product(name, price, ps));
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("product.dat ���� ������ arraylist�� ���� ��");
		} finally {
			try {
				if(dis!=null) dis.close();
				if(fis!=null) fis.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}// try - close
		}// try-catch-finally
		for(Product p : products) {
			System.out.println(p);
		}
		System.out.println("�̻� "+products.size()+"�� ����Էµ�");
	}//main
}//class



