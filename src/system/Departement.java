package system;

import java.util.ArrayList;
import java.util.List;

public class Departement {
	String Name;
	int id;
	List<Integer> cid = new ArrayList<Integer>();
	List<Integer> pid = new ArrayList<Integer>();
	List<Integer> sid = new ArrayList<Integer>();
	int getId(){
		return id;
	}

	Departement(String name){
		this.Name=name;
		id = ID.DID++;
	}
	void setName(String Name){
		this.Name= Name;
	}
	String getName(){
		return Name;
	}

	void addcid(int i){
		Integer id = new Integer(i);
		cid.add(id);
	}
	void addpid(int i){
		Integer id = new Integer(i);
		pid.add(id);
	}
	void addsid(int i){
		Integer id = new Integer(i);
		sid.add(id);
	}

	void deletecid(int i){
		Integer id =new Integer(i);
		cid.remove(id);
	}
	void deletepid(int i){
		Integer id =new Integer(i);
		pid.remove(id);
	}
	void deletesid(int i){
		Integer id =new Integer(i);
		sid.remove(id);
	}

	int[] getsid(){
		  int[] ret = new int[sid.size()];
		  for(int i = 0;i < ret.length;i++)
		    ret[i] = sid.get(i);
		  return ret;
		}
	int[] getpid(){
		int[] ret = new int[pid.size()];
		for(int i = 0;i < ret.length;i++)
		    ret[i] = pid.get(i);
		  return ret;
	}
	int[] getcid(){
		int[] ret = new int[cid.size()];
		for(int i = 0;i < ret.length;i++)
		    ret[i] = cid.get(i);
		  return ret;
	}
}
