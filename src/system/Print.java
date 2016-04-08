package system;

public class Print {
	static boolean useColor=true;
	static String Color_RESET 		= "\u001b[0m";
	static String Color_BLACK		= "\u001b[30m";
	static String Color_BGBLACK 	= "\u001b[40m";
	static String Color_RED			= "\u001b[31m";
	static String Color_BGRED		= "\u001b[41m";
	static String Color_WHITE		= "\u001b[37m";
	static String Color_BGWHITE		= "\u001b[47m";
	static String Color_GREEN		= "\u001b[32m";
	static String Color_BGGREEN		= "\u001b[42m";
	static String Color_MAGENTA		= "\u001b[35m";
	static String Color_BGMAGENTA	= "\u001b[45m";
	static String Color_YELLOW		= "\u001b[33m";
	static String Color_BGYELLOW	= "\u001b[43m";
	static String Color_CYAN		= "\u001b[36m";
	static String Color_BGCYAN		= "\u001b[46m";
	static String Color_BLUE		= "\u001b[34m";
	static String Color_BGBLUE		= "\u001b[44m";
	static String Color_GRAY		= "\u001b[38m";
	static String Color_BGGRAY		= "\u001b[48m";
	/* bold colors */
	static String Color_BBLACK		= "\u001b[1;30m";
	static String Color_BRED		= "\u001b[1;31m";
	static String Color_BBGRED		= "\u001b[1;41m";
	static String Color_BWHITE		= "\u001b[1;37m";
	static String Color_BGREEN		= "\u001b[1;32m";
	static String Color_BMAGENTA	= "\u001b[1;35m";
	static String Color_BYELLOW		= "\u001b[1;33m";
	static String Color_BCYAN		= "\u001b[1;36m";
	static String Color_BBLUE		= "\u001b[1;34m";
	static String Color_BGRAY		= "\u001b[1;38m";
	static void usage (String [][]s){
		int j=0;
		//TODO add usage
		int i;
		for(i=j;i<s.length;i++){
			System.out.print("| "+s[i][0]+"\t"+Print.Color_GREEN+s[i][1]+"\t");
			Print.help(s[i][2]);
		}
	}
	static void done(String s){
		System.out.println(Print.Color_GREEN+"[+] "+Print.Color_RESET+s);
	}
	static void error(String s){
		System.out.println(Print.Color_RED+"[x] "+Print.Color_RESET+s);
	}
	static void help(String s){
			System.out.println(Print.Color_YELLOW+s+Print.Color_RESET);
	}
	static void printcursor(String s){
		System.out.print(Print.Color_BBLUE+s+Print.Color_BLUE+" > "+Print.Color_RESET);
	}
}
