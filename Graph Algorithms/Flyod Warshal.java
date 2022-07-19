/*
The problem is to find the shortest distances between every pair of vertices in a given edge-weighted directed Graph. The Graph is represented as an adjacency matrix, and the matrix denotes the weight of the edges (if it exists) else -1.
Do it in-place.

*/
class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        int v=matrix.length;
        // Code here 
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==-1)
                matrix[i][j]=Integer.MAX_VALUE;
            }
        }
        
        for(int k=0;k<v;k++){
            for(int i=0;i<v;i++){
                for(int j=0;j<v;j++){
                    if(matrix[i][k]!=Integer.MAX_VALUE && matrix[k][j]!=Integer.MAX_VALUE)
                     matrix[i][j]=Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                    
                }
            }
        }
        for(int i=0;i<v;i++){
                for(int j=0;j<v;j++){
                    if(matrix[i][j]==Integer.MAX_VALUE)
                     matrix[i][j]=-1;
                    
                }
            }
    }
}
