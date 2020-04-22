package com.tj.ex5_lib;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class BookLib implements ILendable{
	private String bookNo;       // å��ȣ
	private String bookTitle;    // å����
	private String writer;       // ����
	private String borrower;     // ������
	private Date   checkOutDate; // ������
	private byte   state; // ������(1)or���Ⱑ��(0)
	public BookLib() { }
	// Book b = new Book("450-01��","java","�ſ��");
	public BookLib(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		state = STATE_NORMAL;
	}
	
	@Override
	public void checkOut(String borrower) throws Exception {
		if(state!=STATE_NORMAL){
			throw new Exception(bookTitle+"�� ���� �Ұ��ؿ�");
		}
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED;
		System.out.println("\""+bookTitle+"\"��(��) �ڴ���ڵǾ����ϴ�");
		System.out.println("[������] "+borrower);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��(E)");
		System.out.println("[������]"+sdf.format(checkOutDate));
	}
	@Override
	public void checkIn() throws Exception {
		if(state!=STATE_BORROWED){
			throw new Exception(bookTitle+"�� ���� ���� �ƴϿ���");
		}
		Date now = new Date();
		long diff = now.getTime() - checkOutDate.getTime();
		long day = diff / (24*60*60*1000);
		if(day >14){
			System.out.println("��ü�� ���� 100�� �ΰ��մϴ�");
			day = day - 14;
			System.out.println("���ž� �� ��ü��� " + (day*100)+"��");
			Scanner sc = new Scanner(System.in);
			System.out.print("��ü�Ḧ ���̳���(Y/N)? ");
			if(sc.next().equalsIgnoreCase("n")) {
				System.out.println("��ü�Ḧ ���ž� �ݳ�ó���� �˴ϴ�");
				return;
			}
		}
		this.borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\""+bookTitle+"\"��(��) �ڹݳ��ڵǾ����ϴ�");
	}
	@Override
	public String toString() {
		String temp = bookNo+" \""+bookTitle+"\" "+writer+"�� ";
		if(state == STATE_NORMAL) {
			temp += "���Ⱑ��";
		}else if(state==STATE_BORROWED) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E");
			temp += "������("+sdf.format(checkOutDate)+")";
		}else {
			temp += " �̻��ϴ�. ���ܻ�Ȳ";
		}
		return temp;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public byte getState() {
		return state;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
}