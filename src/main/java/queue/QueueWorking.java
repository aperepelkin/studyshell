package queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

import ru.itstep.studyshell.Console;


public class QueueWorking{

    
    private static Queue<Thread> queue;
    private static QueueWorking instance;
    
    
   
    
    
    private QueueWorking() {
	
    }

    public static synchronized QueueWorking getInstance() {
	if (instance == null) {
	    queue = new LinkedList<>();
	    instance = new QueueWorking();
	}
	return instance;
    }
    
   
    public static void add(Thread thread) {
	queue.add(thread);
    }
    
    public static void clear() {
	queue.clear();
    }
    
    
    public static boolean isEmpty() {
	return queue.isEmpty();
    }
    
    
    
    
    
    public static void processing() {
	
	
	for (Thread thread: queue) {
	    thread.start();
	    try {
		thread.join();
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		Console.print("Shit happens", "red", true);
	    }
	}
	
	clear();
    }
    
    
}
