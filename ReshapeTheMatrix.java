class ReshapeTheMatrix
{
    public int[][] matrixReshape1(int[][] nums, int rows, int cols) 
    {
        int[][] result = new int[rows][cols];
        int row = 0, col = 0;
        
        int numRows = nums.length;
        if (numRows == 0) return result;
        int numCols = nums[0].length;        
        if (rows * cols != numRows * numCols) return nums;
        
        Queue <Integer> queue = new LinkedList <Integer>();
        
        for (int i = 0; i < numRows; i++) 
        {
            for (int j = 0; j < numCols; j++) 
            {
                queue.offer(nums[i][j]);
            }
        }
        
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < cols; j++) 
            {
                result[i][j] = queue.poll();
            }
        }
        return result;
    }

    public int[][] matrixReshape2(int[][] nums, int rows, int cols)
    {
        int[][] result = new int[rows][cols];
        int row = 0, col = 0;
        
        int numRows = nums.length;
        if (numRows == 0) return result;
        int numCols = nums[0].length;        
        if (rows * cols != numRows * numCols) return nums;        
        
        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < numCols; j++)
            {
                result[row][col] = nums[i][j];
                col++;
                
                if (col == cols) 
                {
                    col = 0;
                    row++;
                }
            }
        }
        return result;
    }
    
    public int[][] matrixReshape(int[][] nums, int rows, int cols)
    {
        int[][] result = new int[rows][cols];
        int count = 0;
        
        int numRows = nums.length;
        if (numRows == 0) return result;
        int numCols = nums[0].length;        
        if (rows * cols != numRows * numCols) return nums;        
        
        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < numCols; j++)
            {
                result[count / cols][count % cols] = nums[i][j];
                count++;
            }
        }
        return result;        
    }
}
