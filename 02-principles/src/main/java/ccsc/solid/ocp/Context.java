package ccsc.solid.ocp;

public class Context {
	
	//using the OpenClosedPrinciple: open for extension and closed (existing classes) for modification
	//using DependencyInversionPrinciple: programming against an interface (Task.java) (the abstraction) not against the implementation (TaskA.java, TaskB.java) (in case that might change)
		
    private Task task;
    
    public Context(Task task) {
    	this.task = task;
    }
    
    public Task getTask() {
		return task;
	}

	public String executeTheTasks() {
		return task.doSomething();
    }
    
    public static void main(String[] args) {
    	Context contextA = new Context(new TaskA());
    	System.out.println(contextA.executeTheTasks());
    	
    	Context contextB = new Context(new TaskB());
    	System.out.println(contextB.executeTheTasks());
	}
}
