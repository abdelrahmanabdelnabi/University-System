package system;
import java.util.*;
public class Course {
	int id;
	String Name;
	List<Integer> sid = new ArrayList<Integer>();
	List<Integer> pid = new ArrayList<Integer>();
	List<Integer> did = new ArrayList<Integer>();
	Course(String Name){
		this.Name=Name;
		id = ID.CID++;
	}
	int getId(){
		return id;
	}

	String getName(){
		return Name;
	}
	void setName(String Name){
		this.Name=Name;
	}	

	void addsid(int i){
		Integer id = new Integer(i);
		sid.add(id);
	}
	void addpid(int i){
		Integer id = new Integer(i);
		pid.add(id);
	}
	void adddid(int i){
		Integer id = new Integer(i);
		did.add(id);
	}

	void deletesid(int i){
		Integer id =new Integer(i);
		sid.remove(id);
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
	int[] getdid(){
		int[] ret = new int[did.size()];
		for(int i = 0;i < ret.length;i++)
		    ret[i] = did.get(i);
		  return ret;
	}
}
