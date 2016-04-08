package system;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Member {
	int id;
	List<Integer> cid = new ArrayList<Integer>();
	List<Integer> sid = new ArrayList<Integer>();
	List<Integer> did = new ArrayList<Integer>();	
	Professor(String name) {
		super(name);
		id=ID.PID++;
	}
	int getId(){
		return id;
	}


	void addcid(int i){
		Integer id = new Integer(i);
		cid.add(id);
	}
	void addsid(int i){
		Integer id = new Integer(i);
		sid.add(id);
	}
	void adddid(int i){
		Integer id = new Integer(i);
		did.add(id);
	}

	void deletecid(int i){
		Integer id =new Integer(i);
		cid.remove(id);
	}
	void deletesid(int i){
		Integer id =new Integer(i);
		sid.remove(id);
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
	int[] getcid(){
		int[] ret = new int[cid.size()];
		for(int i = 0;i < ret.length;i++)
		    ret[i] = cid.get(i);
		  return ret;
	}
	int[] getdid(){
		int[] ret = new int[did.size()];
		for(int i = 0;i < ret.length;i++)
		    ret[i] = did.get(i);
		  return ret;
	}

}
