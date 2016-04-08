package system;

import java.util.*;


public class Student extends Member {
	int id;
	List<Integer> cid = new ArrayList<Integer>();
	List<Integer> pid = new ArrayList<Integer>();
	List<Integer> did = new ArrayList<Integer>();	
	Student(String name) {
		super(name);
		id=ID.SID++;
	}
	int getId(){
		return id;
	}


	void addcid(int i){
		Integer id = new Integer(i);
		cid.add(id);
	}
	void addpid(int i){
		Integer id = new Integer(i);
		pid.add(id);
	}
	void adddid(int i){
		Integer id = new Integer(i);
		did.add(id);
	}

	void deletecid(int i){
		Integer id =new Integer(i);
		cid.remove(id);
	}
	void deletepid(int i){
		Integer id =new Integer(i);
		pid.remove(id);
	}
	void deletedid(int i){
		Integer id =new Integer(i);
		did.remove(id);
	}

	int[] getsid(){
		  int[] ret = new int[cid.size()];
		  for(int i = 0;i < ret.length;i++)
		    ret[i] = cid.get(i);
		  return ret;
		}
	int[] getpid(){
		int[] ret = new int[pid.size()];
		for(int i = 0;i < ret.length;i++)
		    ret[i] = pid.get(i);
		  return ret;
	}
	int[] getdid(){
		int[] ret = new int[did.size()];
		for(int i = 0;i < ret.length;i++)
		    ret[i] = did.get(i);
		  return ret;
	}
}
