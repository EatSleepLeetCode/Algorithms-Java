
public class ShortestWordDistanceIII 
{
	 public int shortestWordDistance(String[] words, String word1, String word2) 
	 {
	     int latestPosWord1 = -1;
	     int latestPosWord2 = -1;
	     
	     int minDistance = Integer.MAX_VALUE;
	     
	     for (int i = 0; i < words.length; i++)
	     {
	         if (words[i].equals(word1))
	         {
	             latestPosWord1 = i;
	         }
	         else if (words[i].equals(word2))
	         {
	             latestPosWord2 = i;
	         }
	         
	         if (latestPosWord1 != -1 && latestPosWord2 != -1 && latestPosWord1 != latestPosWord2)
	         {
	             minDistance = Math.min(minDistance, Math.abs(latestPosWord1 - latestPosWord2));
	         }
	         
	         if (word1.equals(word2))
	         {
	             latestPosWord2 = latestPosWord1;
	         }
	     }
	     return minDistance;
	 }
}
