package edu.kh.member.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.kh.member.dto.Member;

public class MemberDaoImpl implements MemberDao{
	private final String FILE_PATH = "membership_servlet.dat";

	private List<Member> memberList = null;
	
	private ObjectOutputStream oos = null;
	private ObjectInputStream ois = null;
	
	public MemberDaoImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File(FILE_PATH);
		
		if(!file.exists()) {
			memberList = new ArrayList<Member>();
			memberList.add(new Member("짱구", "01033334444", 0, 0));
			memberList.add(new Member("맹구", "01055556666", 0, 0));
			memberList.add(new Member("훈이", "01077778888", 0, 0));
		} else {
			try {
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				memberList = (ArrayList<Member>)ois.readObject();
			} finally {
				if(ois != null) ois.close();
			}
		}
	}
	
	@Override
	public void saveFile() throws IOException {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(memberList);
		} finally {
			oos.close();
		}
	}
	
	@Override
	public boolean addMember(Member member) throws IOException {
		memberList.add(member);
		saveFile();
		return true;
	}
	
	@Override
	public Member getMember(int index) {
		return memberList.get(index);
	}
	
	@Override
	public List<Member> getMemberList() {
		return memberList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
