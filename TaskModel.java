package com.uttara.tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskModel {

	public boolean checkIfCategoryExists(String catName)
	{
		File f = new File(catName+".tasks");
		return f.exists();
	}

	public String addTask(TaskBean bean,String category) {
	
		Logger.getInstance().log("TaskModel->addTask() bean = "+bean);
		
		String msg = bean.validate();
		if(!msg.equals(Constants.SUCCESS))
			return msg;
		else
		{
			
			BufferedWriter bw = null;
			try
			{
				bw = new BufferedWriter(new FileWriter(category+".tasks",true));
				bw.write(bean.getName()+":"+bean.getDesc()+":"+bean.getStartDate()+":"+bean.getEndDate()+":"+bean.getStatus()+":"+bean.getPriority()+":"+bean.getTags()+":"+new Date());
				bw.newLine();
				
				return Constants.SUCCESS;
			}
			catch(IOException e)
			{
				
				e.printStackTrace();
				return "Oops something bad happened! msg = "+e.getMessage();
			}
			finally
			{
				if(bw!=null)
					try {
						bw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
	}

	public List<TaskBean> getTasks(String catName) {
		
		/*
		 * open file based on category name
		 * read 1 line at a time. split it and create 1 bean obj
		 * add bean obj to list
		 * return list.
		 */
		if(catName == null || catName.trim().equals(""))
			throw new IllegalArgumentException("category name is empty!!");
		
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader(catName+".tasks"));
			String line;
			TaskBean bean=null;
			List<TaskBean> tasks = new ArrayList<TaskBean>();
			
			while((line = br.readLine())!=null)
			{
				bean = new TaskBean();
				String[] sa = line.split(":");
				bean.setName(sa[0]);
				bean.setDesc(sa[1]);
				bean.setStartDate(sa[2]);
				bean.setEndDate(sa[3]);
				bean.setStatus(sa[4]);
				bean.setPriority(Integer.parseInt(sa[5]));
				bean.setTags(sa[6]);
				
				tasks.add(bean);
			}
			
			return tasks;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
	}

	public String deleteTask(String taskName, String catName) {
		
		/*
		 * open the file
		 * read one line at a time to a list except the line
		 * that represents/contains taskname
		 * loop the list, overwrite the contents of the file!
		 */
		BufferedReader br = null;
		BufferedWriter bw = null;
		try
		{
			br = new BufferedReader(new FileReader(catName+".tasks"));
			String line;
			List<String> data = new ArrayList<String>();
			while((line = br.readLine())!=null)
			{
				if(!taskName.equals(line.split(":")[0]))
					data.add(line);
			}
			br.close();
			bw = new BufferedWriter(new FileWriter(catName+".tasks"));
			
			for(String str : data)
			{
				bw.write(str);
				bw.newLine();
			}
			bw.close();
			
			return Constants.SUCCESS;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return "Oops something bad happened msg = "+e.getMessage();
		}
		
	}
	
}







