/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/

//BFS Solution
class EmployeeImportance
{
    public int getImportance(List<Employee> employees, int id) 
    {
        int result = 0;
        Map<Integer, List<Integer>> adjMap = new HashMap<Integer, List<Integer>>();
        Map<Integer, Integer> impMap = new HashMap<Integer, Integer>();

        for (Employee emp : employees)
        {
            adjMap.put(emp.id, new ArrayList<Integer>(emp.subordinates));
            impMap.put(emp.id, emp.importance);
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(id);
        
        while (!queue.isEmpty())
        {
            int curr = queue.poll();
            result += impMap.get(curr);
         
            if (adjMap.containsKey(curr))
            {
                for (int sub : adjMap.get(curr))
                {
                    queue.offer(sub);
                }
            }
        }
        return result;
    }    
}

//DFS Solution
class EmployeeImportance1
{
    int result = 0;
    Map<Integer, List<Integer>> adjMap = new HashMap<Integer, List<Integer>>();
    Map<Integer, Integer> impMap = new HashMap<Integer, Integer>();
    
    public int getImportance(List<Employee> employees, int id) 
    {
        for (Employee emp : employees)
        {
            adjMap.put(emp.id, new ArrayList<Integer>(emp.subordinates));
            impMap.put(emp.id, emp.importance);
        }
        
        dfs(id);
        
        return result;
    }
    
    void dfs(int id)
    {
        result += impMap.get(id);
        
        if (adjMap.containsKey(id))
        {
            for (int sub : adjMap.get(id))
            {
                dfs(sub);
            }
        }
    }
}
