package demo;

import controllerUnit.Controller;
import controllerUnit.ControllerRicartDemo;
import controllerUnit.LogWriter;
import controllerUnit.OutputWriter;

public class Host2 {
	public static void main(String[] args){
		
		String currentDir = System.getProperty("user.dir");
		System.out.println(currentDir);
		String configfile=currentDir+"/config.txt";  //linux
		int nodeId = 1;
		String prefixName = configfile.substring(0, configfile.length()-4)+"-" + String.valueOf(nodeId);
		LogWriter.getSingle().open(prefixName+".log");
		LogWriter.getSingle().clear();		
		OutputWriter.getSingle().open(prefixName+".out");
		OutputWriter.getSingle().clear();
		ControllerRicartDemo controller2 = new ControllerRicartDemo(1,"tcp",configfile);
		controller2.start();
	}

}
