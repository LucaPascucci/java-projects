package oop1314.lab08.pe.sol;


import java.io.*;

public class Controller implements ViewObserver{
	
	private ViewInterface view;
	private ModelInterface model;
	private String fileName;
	
	public Controller(){}
	
	public void setFileName(String fileName){
		this.fileName = fileName;
	}

	public void setView(ViewInterface view) {
		this.view = view;
		this.view.attachViewObserver(this);
	}

	public void setModel(ModelInterface model) {
		this.model = model;
	}

	@Override
	public void commandLoad(){
		try{
			FileInputStream fis = new FileInputStream(this.fileName);
			this.model.load(fis);
			fis.close();
			this.reSendAll();
			return;
		} catch (Exception e){
			this.view.commandFailed(e.getMessage());
		}
	}
	
	private void reSendAll(){
		this.view.clearData();
		java.util.Iterator<Person> it = this.view.wantsSorted() ? this.model.sortedIterator() : this.model.iterator();
		while (it.hasNext()){
			Person p = it.next();
			Object[] o = new Object[]{p.getName(),p.getSurname(),p.getCode(),p.getBirthYear(),p.isMale()};
			this.view.addData(o);
		}
	}
	
	@Override
	public void commandSave(){
		try{
			FileOutputStream fos = new FileOutputStream(this.fileName);
			this.model.save(fos);
			fos.close();
			return;
		} catch (Exception e){
			this.view.commandFailed(e.getMessage());
		}
	}
	@Override
	public void commandQuit(){
		System.exit(0);
	}
	
	@Override
	public void commandAdd(Object[] o){
		try{
			model.add((String)o[0], (String)o[1], (String)o[2], (Integer)o[3], (Boolean)o[4]);
			if (this.view.wantsSorted()){
				this.reSendAll();
			} else {
				this.view.addData(o);
			}
		} catch (Exception e){
			this.view.commandFailed(e.getMessage());
		}
	}
	
	@Override
	public void commandClear(){
		this.model.clear();
		this.view.clearData();
	}

	@Override
	public void commandResend() {
		reSendAll();
	}

	
	
}
