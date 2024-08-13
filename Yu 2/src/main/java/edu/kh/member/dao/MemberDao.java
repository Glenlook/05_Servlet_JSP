package edu.kh.member.dao;

import java.io.IOException;
import java.util.List;

import edu.kh.member.dto.Member;

public interface MemberDao {
	List<Member> getMemberList();
	
	boolean addMember(Member member) throws IOException;
	
	Member getMember(int index);
	
	void saveFile() throws IOException;
}
