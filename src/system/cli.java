package system;

import java.util.*;
public class cli {
	static University u = new University();
	public static void main(String args[]){
		String[][] usage = {
				{"q"	,""	,"quit"},
				{"a[?]"	,""	,"Add entity."},
				{"e[?]"	,""	,"Edit data"},
				{"f[?]"	,""	,"Find"},
				{"d[?]"	,""	,"delete"},
				{"?"	,""	,"Show this help"},
				};
		Scanner reader = new Scanner(System.in);
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
			case 'e':
				edit(input);
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
			String name = new String(input,2,input.length-3).trim() ;
			u.addcourse(name);
			Print.done("Course added");
			//TODO print help to edit content
			break;
		}
		case 's':{
			String name = new String(input,2,input.length-3).trim() ;
			u.addstudent(name);
			Print.done("Course added");
			//TODO print help to edit content
			break;
		}
		case 'd':{
			String name = new String(input,2,input.length-3).trim() ;
			u.adddep(name);
			Print.done("Course added");
			//TODO print help to edit content
			break;
		}
		case 'p':{
			String name = new String(input,2,input.length-3).trim() ;
			u.addprof(name);
			Print.done("Professor added");
			//TODO print help to edit content
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
				deleted = u.delcourse(Integer.parseInt(new String(input,2,input.length-3).trim()));
			}catch(java.lang.NumberFormatException e){
				deleted  = u.delcourse(new String(input,2,input.length-3).trim());
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
				deleted = u.delstudent(Integer.parseInt(new String(input,2,input.length-3).trim()));
			}catch(java.lang.NumberFormatException e){
				deleted  = u.delstudent(new String(input,2,input.length-3).trim());
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
				deleted = u.deldep(Integer.parseInt(new String(input,2,input.length-3).trim()));
			}catch(java.lang.NumberFormatException e){
				deleted  = u.deldep(new String(input,2,input.length-3).trim());
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
				deleted = u.delprof(Integer.parseInt(new String(input,2,input.length-3).trim()));
			}catch(java.lang.NumberFormatException e){
				deleted  = u.delprof(new String(input,2,input.length-3).trim());
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
	static void edit(char [] input){
			//TODO
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
			Object s;
			try{
				s = u.findstudent(Integer.parseInt(new String(input,2,input.length-3).trim()));
			}catch(java.lang.NumberFormatException e){
				s  = u.findstudent(new String(input,2,input.length-3).trim());
			}
			if(s == null){
				Print.error("Student not found");
				return;
			}
			//TODO print data
			break;
		}
		case 'c':{
			Object c;
			try{
				c = u.findcourse(Integer.parseInt(new String(input,2,input.length-3).trim()));
			}catch(java.lang.NumberFormatException e){
				c  = u.findcourse(new String(input,2,input.length-3).trim());
			}
			if(c == null){
				Print.error("Course not found");
				return;
			}
			//TODO print data
			break;
		}
		case 'd':{
			Object d;
			try{
				d = u.finddep(Integer.parseInt(new String(input,2,input.length-3).trim()));
			}catch(java.lang.NumberFormatException e){
				d  = u.finddep(new String(input,2,input.length-3).trim());
			}
			if(d == null){
				Print.error("departement not found");
				return;
			}
			//TODO print data
			break;
		}
		case 'p':{
			Object p;
			try{
				p = u.findprof(Integer.parseInt(new String(input,2,input.length-3).trim()));
			}catch(java.lang.NumberFormatException e){
				p  = u.findprof(new String(input,2,input.length-3).trim());
			}
			if(p == null){
				Print.error("professor not found");
				return;
			}
			//TODO print data
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
}
