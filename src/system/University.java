package system;
import java.util.*;
public class University {
	List <Student> student = new ArrayList<Student>();
	List <Course> course = new ArrayList<Course>();
	List <Departement> dep = new ArrayList<Departement>();
	List <Professor> prof = new ArrayList<Professor>();
	public void addstudent(String name){
		Student S = new Student(name);
		student.add(S);
		//TODO sort
	}
	public void addcourse(String name){
		Course  c = new Course(name);
		course.add(c);
		//TODO sort
	}
	public void adddep(String name){
		Departement  d = new Departement(name);
		dep.add(d);
		//TODO sort
	}
	public void addprof(String name){
		Professor  p = new Professor(name);
		prof.add(p);
		//TODO sort
	}
	public boolean delcourse(int id){
		if(id> course.size())
			return false;
		for(Integer i:course.get(id).sid)
			student.get(i.intValue()).cid.remove(i);
		for(Integer i:course.get(id).did)
			dep.get(i.intValue()).cid.remove(i);
		for(Integer i:course.get(id).pid)
			prof.get(i.intValue()).cid.remove(i);
		course.remove(id);
		return true;
	}
	public boolean delcourse(String name){
		for(Course c:course)
			if(c.getName().equals(name))
				return delcourse(c.getId());
		return false;
	}
	public boolean delstudent(int id){
		if(id>student.size())
			return false;
		for(Integer i:student.get(id).cid)
			course.get(i.intValue()).sid.remove(i);
		for(Integer i:student.get(id).did)
			dep.get(i.intValue()).sid.remove(i);
		for(Integer i:student.get(id).pid)
			prof.get(i.intValue()).sid.remove(i);
		student.remove(id);
		return true;
	}
	public boolean delstudent(String name){
		for(Student s:student)
			if(s.getName().equals(name))
				return delstudent(s.getId());
		return false;
	}
	public boolean deldep(int id){
		if(id>dep.size())
			return false;
		for(Integer i:dep.get(id).cid)
			course.get(i.intValue()).did.remove(i);
		for(Integer i:dep.get(id).sid)
			student.get(i.intValue()).did.remove(i);
		for(Integer i:dep.get(id).pid)
			prof.get(i.intValue()).did.remove(i);
		dep.remove(id);
		return true;
	}
	public boolean deldep(String name){
		for(Departement d:dep)
			if(d.getName().equals(name))
				return deldep(d.getId());
		return false;
	}
	public boolean delprof(int id){
		if(id>prof.size())
			return false;
		for(Integer i:prof.get(id).cid)
			course.get(i.intValue()).pid.remove(i);
		for(Integer i:prof.get(id).sid)
			student.get(i.intValue()).pid.remove(i);
		for(Integer i:prof.get(id).did)
			dep.get(i.intValue()).pid.remove(i);
		prof.remove(id);
		return true;
	}
	public boolean delprof(String name){
		for(Professor p:prof)
			if(p.getName().equals(name))
				return delprof(p.getId());
		return false;
	}
	
}
