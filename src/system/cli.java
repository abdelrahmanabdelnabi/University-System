package system;

import java.util.*;
public class cli {
	static University u = new University();
	static Scanner reader = new Scanner(System.in);	
	public static void main(String args[]){
		String[][] usage = {
				{"q"	,""	,"quit"},
				{"a[?]"	,""	,"Add entity."},
				{"f[?]"	,""	,"Find"},
				{"d[?]"	,""	,"delete"},
				{"?"	,""	,"Show this help"},
				};
		while(true){
			Print.printcursor("");
			String nxt = reader.nextLine();
			char[] input = nxt.toCharArray();
			switch (input[0]){
			case 'q':
				if (input[1]=='\0'){
					reader.close();
					return;
				}
				Print.help("q quit");
				break;
			case '?':
				Print.usage(usage);
				break;
			case 'a':
				addentity(input);
				break;
			case 'f':
				find(input);
				break;
			case 'd':
				delentity(input);
				break;
			default:
				Print.error("Unknown command");
				Print.help("see ? for help");
				
			}
		}
	}
	static void addentity(char [] input){
		String[][] usage = {
				{"a?"	,""		,"show this help"},
				{"ac"	,"name"	,"add course"},
				{"as"	,"name"	,"add student"},
				{"ad"	,"name"	,"add departement"},
				{"ap"	,"name"	,"add professor"},
				};
		if (input.length == 1){
			Print.help("see a? for help");
			return;
		}
		switch (input[1]){
		case 'c':{
			String name = new String(input,2,input.length-2).trim() ;
			u.addcourse(name);
			Print.done("Course added");
			Print.help("edit/view student data via fc "+name);
			break;
		}
		case 's':{
			String name = new String(input,2,input.length-2).trim() ;
			u.addstudent(name);
			Print.done("Student added");
			Print.help("edit/view student data via fs "+name);
			break;
		}
		case 'd':{
			String name = new String(input,2,input.length-2).trim() ;
			u.adddep(name);
			Print.done("Course added");
			Print.help("edit/view departement data via fd "+name);
			break;
		}
		case 'p':{
			String name = new String(input,2,input.length-2).trim() ;
			u.addprof(name);
			Print.done("Professor added");
			Print.help("edit/view professor data via fp "+name);
			break;
		}
		case '?':
			Print.usage(usage);
			break;
		default:
			Print.error("Unknown command");
			Print.help("see a? for help");
			
		}
		
	}
	static void delentity(char [] input){
		String[][] usage = {
				{"d?"	,""				,"show this help"},
				{"dc"	,"[name|id]"	,"delete course"},
				{"ds"	,"[name|id]"	,"delete student"},
				{"dd"	,"[name|id]"	,"delete departement"},
				{"dp"	,"[name|id]"	,"delete professor"},
				};
		if (input.length == 1){
			Print.help("see d? for help");
			return;
		}
		
		switch (input[1]){
		case 'c':{
			boolean deleted;
			try{
				deleted = u.delcourse(Integer.parseInt(new String(input,2,input.length-2).trim()));
			}catch(java.lang.NumberFormatException e){
				deleted  = u.delcourse(new String(input,2,input.length-2).trim());
			}
			if(deleted)
				Print.done("Course deleted");
			else
				Print.error("course not found");
			break;
		}
		case 's':{
			boolean deleted;
			try{
				deleted = u.delstudent(Integer.parseInt(new String(input,2,input.length-2).trim()));
			}catch(java.lang.NumberFormatException e){
				deleted  = u.delstudent(new String(input,2,input.length-2).trim());
			}
			if(deleted)
				Print.done("Student deleted");
			else
				Print.error("Student not found");
			break;
		}
		case 'd':{
			boolean deleted;
			try{
				deleted = u.deldep(Integer.parseInt(new String(input,2,input.length-2).trim()));
			}catch(java.lang.NumberFormatException e){
				deleted  = u.deldep(new String(input,2,input.length-2).trim());
			}
			if(deleted)
				Print.done("Departement deleted");
			else
				Print.error("Departement not found");
			break;
		}
		case 'p':{
			boolean deleted;
			try{
				deleted = u.delprof(Integer.parseInt(new String(input,2,input.length-2).trim()));
			}catch(java.lang.NumberFormatException e){
				deleted  = u.delprof(new String(input,2,input.length-2).trim());
			}
			if(deleted)
				Print.done("Professor deleted");
			else
				Print.error("Professor not found");
			break;		}
		case '?':
			Print.usage(usage);
			break;
		default:
			Print.error("Unknown command");
			Print.help("see a? for help");
			
		}
}
	static void find(char [] input){
		String[][] usage = {
				{"f?"	,""				,"show this help"},
				{"fc"	,"[name|id]"	,"find course"},
				{"fs"	,"[name|id]"	,"find student"},
				{"fd"	,"[name|id]"	,"add departement"},
				{"fp"	,"[name|id]"	,"add professor"},
				};
		if (input.length == 1){
			Print.help("see f? for help");
			return;
		}
		switch (input[1]){
		case 's':{
			Student s;
			try{
				s = u.findstudent(Integer.parseInt(new String(input,2,input.length-2).trim()));
			}catch(java.lang.NumberFormatException e){
				s  = u.findstudent(new String(input,2,input.length-2).trim());
			}
			if(s == null){
				Print.error("Student not found");
				return;
			}
			student_cli(s);
			break;
		}
		case 'c':{
			Course c;
			try{
				c = u.findcourse(Integer.parseInt(new String(input,2,input.length-2).trim()));
			}catch(java.lang.NumberFormatException e){
				c  = u.findcourse(new String(input,2,input.length-2).trim());
			}
			if(c == null){
				Print.error("Course not found");
				return;
			}
			course_cli(c);
			break;
		}
		case 'd':{
			Departement d;
			try{
				d = u.finddep(Integer.parseInt(new String(input,2,input.length-2).trim()));
			}catch(java.lang.NumberFormatException e){
				d  = u.finddep(new String(input,2,input.length-2).trim());
			}
			if(d == null){
				Print.error("departement not found");
				return;
			}
			dep_cli(d);
			break;
		}
		case 'p':{
			Professor p;
			try{
				p = u.findprof(Integer.parseInt(new String(input,2,input.length-2).trim()));
			}catch(java.lang.NumberFormatException e){
				p  = u.findprof(new String(input,2,input.length-2).trim());
			}
			if(p == null){
				Print.error("professor not found");
				return;
			}
			prof_cli(p);
			break;
		}
		case '?':
			Print.usage(usage);
			break;
		default:
			Print.error("Unknown command");
			Print.help("see f? for help");
			
		}
	}
	static void student_cli(Student s){
		Print.entry("Name: ",s.getName());
		Print.entry("Student ID" ,String.valueOf(s.id));
		Print.entry("GPA", String.valueOf(s.getGpa()));
		Print.entry("Professors: ",String.valueOf(s.pid.size())+"Professor");
		Print.entry("Courses: ",String.valueOf(s.cid.size())+"Professor");
		Print.entry("Departements: ",String.valueOf(s.did.size())+"Dep.");
		Print.entry("Age: ",String.valueOf(s.getAge()));
		Print.entry("Address", s.getAddress());
		String[][] usage = {
				{"n"	,"name"			,"edit name"},
				{"p"	,"gpa"			,"edit gpa"},
				{"a"	,"address"		,"edit address"},
				{"g"	,"age"	,		"editage"},
				{"c+"	,"id"	,"add course"},
				{"c-"	,"id"	,"delete course"},
				{"c*"	,""				,"View courses"},
				{"d+"	,"id"	,"add departement"},
				{"d-"	,"id"	,"delete departement"},
				{"d*"	,""				,"view departement"},
				{"b"	,""				,"back"},
				{"?"	,""				,"show this help"},
		};
		while(true){
			Print.printcursor(s.getName());
			String nxt = reader.nextLine();
			char[] input = nxt.toCharArray();
			switch (input[0]){
			case 'n':{
				s.setName(new String(input,1,input.length-1).trim());
			}break;
			case 'p':{
				s.setGpa(Float.valueOf(new String(input,1,input.length-1).trim()));
			}break;
			case 'a':{
				s.setAddress(new String(input,1,input.length-1).trim());
			}break;
			case'g':{
				s.setAge(Integer.valueOf(new String(input,1,input.length-1).trim()));
			}break;
			case 'c':{
				switch(input[1]){
				case '+':{
					s.addcid(Integer.valueOf(new String(input,2,input.length-2).trim()));
				}break;
				case '-':{
					s.deletecid(Integer.valueOf(new String(input,2,input.length-2).trim()));
				}break;
				case '*':{
					for (Integer i:s.cid)
						Print.info(i.toString()+": "+u.findcourse(i.intValue()).getName());
				}
			}}break;
			case 'd':{
				switch(input[1]){
				case '+':{
					s.adddid(Integer.valueOf(new String(input,2,input.length-2).trim()));
				}break;
				case '-':{
					s.deletedid(Integer.valueOf(new String(input,2,input.length-2).trim()));
				}break;
				case '*':{
					for (Integer i:s.did)
						Print.info(i.toString()+": "+u.finddep(i.intValue()).getName());
				}
			}
			}break;
			case 'b':
				return;
			case '?':
				Print.usage(usage);
				break;
			default:
				Print.error("Unknown command");
				Print.help("see ? for help");
			
			}
		}
	}
	static void prof_cli (Professor p){
		Print.entry("Name: ",p.getName());
		Print.entry("professor ID" ,String.valueOf(p.id));
		Print.entry("Students: ",String.valueOf(p.sid.size())+" Student");
		Print.entry("Courses: ",String.valueOf(p.cid.size())+" Course");
		Print.entry("Departements: ",String.valueOf(p.did.size())+" Dep.");
		Print.entry("Age: ",String.valueOf(p.getAge()));
		Print.entry("Address: ", p.getAddress());
		String[][] usage = {
				{"n"	,"name"			,"edit name"},
				{"a"	,"address"		,"edit address"},
				{"g"	,"age"	,		"editage"},
				{"c+"	,"id"	,"add course"},
				{"c-"	,"id"	,"delete course"},
				{"c*"	,""				,"View courses"},
				{"d+"	,"id"	,"add departement"},
				{"d-"	,"id"	,"delete departement"},
				{"d*"	,""				,"view departement"},
				{"b"	,""				,"back"},
				{"?"	,""				,"show this help"},
		};
		while(true){
			Print.printcursor(p.getName());
			String nxt = reader.nextLine();
			char[] input = nxt.toCharArray();
			switch (input[0]){
			case'n':{
				p.setName(new String(input,1,input.length-1).trim());
				}break;
			case 'a':{
				p.setAddress(new String(input,1,input.length-1).trim());
			}break;
			case'g':{
				p.setAge(Integer.valueOf(new String(input,1,input.length-1).trim()));
			}break;
			case 'c':{
				switch(input[1]){
				case '+':{
					p.addcid(Integer.valueOf(new String(input,2,input.length-2).trim()));
				}break;
				case '-':{
					p.deletecid(Integer.valueOf(new String(input,2,input.length-2).trim()));
				}break;
				case '*':{
					for (Integer i:p.cid)
						Print.info(i.toString()+": "+u.findcourse(i.intValue()).getName());
				}
			}}break;
			case 'd':{
				switch(input[1]){
				case '+':{
					p.adddid(Integer.valueOf(new String(input,2,input.length-2).trim()));
				}break;
				case '-':{
					p.deletedid(Integer.valueOf(new String(input,2,input.length-2).trim()));
				}break;
				case '*':{
					for (Integer i:p.did)
						Print.info(i.toString()+": "+u.finddep(i.intValue()).getName());
				}
			}
			}break;
			case 'b':
				return;
			case '?':
				Print.usage(usage);
				break;
			default:
				Print.error("Unknown command");
				Print.help("see ? for help");
			}
		}
	}
	static void dep_cli (Departement d){
		Print.entry("Name: ",d.getName());
		Print.entry("Departement ID: " ,String.valueOf(d.id));
		Print.entry("Students: ",String.valueOf(d.sid.size())+"Student");
		Print.entry("Professors: ",String.valueOf(d.pid.size())+"Professor");
		Print.entry("Courses: ",String.valueOf(d.cid.size())+"Course.");
	}
	static void course_cli (Course c){

		Print.entry("Name: ",c.getName());
		Print.entry("Course ID: " ,String.valueOf(c.id));
		Print.entry("Students: ",String.valueOf(c.sid.size())+"Student");
		Print.entry("Professors: ",String.valueOf(c.pid.size())+"Professor");
		Print.entry("Departements: ",String.valueOf(c.did.size())+"Dep.");
	}
}
