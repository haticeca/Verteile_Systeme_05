package sockets.server;
import java.util.regex.Pattern;

import sockets.commands.ADD;
import sockets.commands.HelloWorld;
import sockets.commands.MUL;
import sockets.commands.SUB;

import java.util.regex.Matcher;

public class Protocol {
//extends Command {
	
	private ADD a = new ADD();
	private SUB s = new SUB();
	private MUL m = new MUL();
	private HelloWorld hw = new HelloWorld();
	
	public Protocol(){}
	
	public Protocol(ADD plus, SUB minus, MUL mal, HelloWorld hello){
		this.a= plus;
		this.s = minus;
		this.m = mal;
		this.hw = hello;
	}
	
	public String process(String msg) {
		
	
		String[] varArray = null;
	
		Pattern pattern = Pattern.compile("([-+*])\s+(\\d+)\s+(\\d+)");
		Matcher matcher = pattern.matcher(msg);
		if(msg.matches("hello")) {
			return this.hw.process(varArray); 
		} else if(msg.matches("([+])\s+(\\d+)\s+(\\d+)")) {
			varArray = msg.split(" ");
			return this.a.process(varArray);	
		} else if(msg.matches("([-])\s+(\\d+)\s+(\\d+)")) {
			varArray = msg.split(" ");
			return this.s.process(varArray);
		} else if(msg.matches("([*])\s+(\\d+)\s+(\\d+)")) {
			varArray = msg.split(" ");
			return this.m.process(varArray);
		} else {
			return null;
		}
		
	}	

}
