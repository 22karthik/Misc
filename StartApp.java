package com.uttara.tasks;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StartApp {

	public static void main(String[] args) {
		//user facing code!!
		//View logic + controlling logic
		
		int ch1=0 , ch2=0;
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		String catName;
		String taskName;
		String desc, tags;
		String sstdt, sendDt;
		int priority;
		
		try
		{
			
				TaskModel model = new TaskModel();
				
				while(ch1!=6)
				{
					System.out.println("");
					System.out.println("Press 1 to create category");
				System.out.println("Press 2 to load category");
				System.out.println("Press 3 to search");
				System.out.println("Press 4 to list");
				System.out.println("Press 5 to export");
				System.out.println("Press 6 to exit");
				System.out.println("");
				ch1 = sc1.nextInt();

				switch(ch1)
				{
					case 1:
							System.out.println("Enter category name");
							catName = sc2.nextLine();
							Logger.getInstance().log("catName = "+catName);
							//input validate!
							while(!TaskUtil.validateName(catName))
							{
								System.out.println("Enter valid name buddy!");
								catName = sc2.nextLine();
								
							}
							System.out.println("valid category name is "+catName);
							
							//check if category name has already been taken!
							
							if(model.checkIfCategoryExists(catName))
								System.out.println("Category name is a duplicate, you duplicate! Enter a unique category name!");
							else
							{
								while(ch2!=6)
								{
									System.out.println("Press 1 to add task");
									System.out.println("Press 2 to list tasks");
									System.out.println("Press 3 to delete task");
									System.out.println("Press 4 to update");
									System.out.println("Press 5 to search");
									System.out.println("Press 6 to go back");
									
									ch2 = sc1.nextInt();
									
									switch(ch2)
									{
									
										case 3:
												System.out
														.println("Enter task name");
												taskName = sc2.nextLine();
												
												String msg = model.deleteTask(taskName,catName);
												if(msg.equals(Constants.SUCCESS))
												{
													System.out
															.println("Task name "+taskName+" has been successfully deleted from category "+catName);
												}
												else
													System.out
															.println("Oops something bad happened!! msg = "+msg);
												break;
											
											
										case 2:
												List<TaskBean> tasks = model.getTasks(catName);
												if(tasks==null)
													System.out
															.println("Listing is not working...check log for failure details!!");
												else
												{
													Collections.sort(tasks);
													for(TaskBean bean : tasks)
													{
														System.out
																.println("Name : "+bean.getName()+" Desc : "+bean.getDesc()+" Start Date : "+bean.getStartDate()+" End Date : "+bean.getEndDate()+" Status : "+bean.getStatus()+" Priority : " +bean.getPriority()+" Tags : "+bean.getTags() );
													}
												}
												break;
										case 1:
												System.out.println("adding...");
												System.out.println("Enter task name");
												taskName = sc2.nextLine();
												System.out.println("Enter task desc");
												desc = sc2.nextLine();
												System.out.println("Enter start date (dd/mm/yyyy)");
												sstdt = sc2.nextLine();
												System.out.println("Enter end date(dd/mm/yyyy)");
												sendDt = sc2.nextLine();
												System.out.println("Enter priority(1..10)");
												priority = sc1.nextInt();
												System.out.println("Enter tags(comma separated)");
												tags = sc2.nextLine();
													
												// create a bean obj and store user inputs in it
												// pass bean to model to add the task
												TaskBean bean = new TaskBean(taskName,desc,sstdt,sendDt,tags,priority);
												
												msg = model.addTask(bean,catName);
												
												if(msg.equals(Constants.SUCCESS))
												{
													System.out
															.println("Task "+taskName+" has been added successfully to category "+catName+"!");
													
												}
												else
													System.out
															.println("Task did not get added successfully! msg = "+msg);
												
												break;
										case 6:
												System.out.println("going back...");
												break;
										default:
												System.out.println("Option not yet supported!!");
												break;
									
									
									}
									
									
								}
									
								
								
							}
							
							break;
					case 2:
							System.out.println("loading...");
							break;
					case 3:
							System.out.println("searching...");
							break;
					case 4:
							System.out.println("listing...");
							break;
					case 5:
							System.out.println("exporting...");
							break;
					case 6:
							System.out.println("tata bye bye. miss you...");
							break;
					default:
							System.out.println("Oye, enter 1-6 only, varna darna!");
							break;
				
				}
				
				
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Oops something bad happened "+e.getMessage());
		}
		catch(Error e)
		{
			e.printStackTrace();
			System.out.println("Oops something very bad happened that I and you possibly cannot control..."+e.getMessage());
		}

			
	}

}






