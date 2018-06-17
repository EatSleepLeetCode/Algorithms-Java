
public class VerifyPreorderSerializationOfBinaryTree 
{
    public boolean isValidSerialization(String preorder) 
    {
        String[] arr = preorder.split(",");        
        int degree = -1;            // root has no indegree, for compensate init with -1
        
        for (String str : arr)
        {
            degree++;               // all nodes have 1 indegree (root compensated)
            
            if (degree > 0)
                return false;
            
            if (!str.equals("#"))   //all nodes except leaf nodes have outdegree 2
                degree -= 2;            
        }
        
        return degree == 0;
    }
}
