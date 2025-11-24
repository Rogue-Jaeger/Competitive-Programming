// https://leetcode.com/problems/design-task-manager/

// This code is as per editorial..
// You dont need anything else apart from a pq and map to manage
// lazy deletion.
// Was using HashMap for storing edits and HashSet to store removals earlier.
// The old execTop() logic can be found in earlier submissions.

class Task {
    int userId, taskId, priority;
    public Task() {}
    public Task(int userId, int taskId, int priority) {
        this.userId = userId;
        this.taskId = taskId;
        this.priority = priority;
    }
}

class TaskManager {
    PriorityQueue<Task> pq = new PriorityQueue<Task> (
        (a, b) -> {
            if (a.priority != b.priority) return b.priority - a.priority;
            return b.taskId - a.taskId;
        });

    HashMap<Integer, Task> tasksMap = new HashMap();

    public TaskManager(List<List<Integer>> tasks) {
        Task t;
        for (List<Integer> task: tasks) {
            t = new Task(task.get(0), task.get(1), task.get(2));
            pq.add(t);
            tasksMap.put(t.taskId, t);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task t = new Task(userId, taskId, priority);
        pq.add(t);
        tasksMap.put(taskId, t);
    }
    
    public void edit(int taskId, int newPriority) {
        Task t = new Task(tasksMap.get(taskId).userId, taskId, newPriority);
        pq.add(t);
        tasksMap.put(taskId, t);
    }
    
    public void rmv(int taskId) {
        tasksMap.remove(taskId);
    }
    
    public int execTop() {
        int userId = -1;

        Task task, currTask;
        while (!pq.isEmpty()) {
            task = pq.poll();
            currTask = tasksMap.get(task.taskId);
            if (currTask != null && currTask.priority == task.priority && currTask.userId == task.userId) {
                userId = task.userId;
                tasksMap.remove(task.taskId); // IMPP: Forgot this..
                break;
            }
        }
        
        return userId;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */