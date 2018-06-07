
public class UncompressStringMatch 
{
	boolean isMatch(String pattern, String str)
	{
		char[] pArr = pattern.toCharArray();
		char[] sArr = str.toCharArray();
		int pLen = pArr.length;
		int sLen = sArr.length;
		int sIndex = 0;
		int pIndex = 0;
		
		while(pIndex < pLen && sIndex < sLen)
		{
			int num = 0;
			
			if(isDigit(pArr, pIndex))
			{
				num = pArr[pIndex] - '0';
				pIndex++;
				
				while(pIndex < pLen && isDigit(pArr, pIndex))
				{
					num = num * 10 + pArr[pIndex] - '0';
					pIndex++;
				}			
				
				sIndex = sIndex + num;				
			}
			else
			{
				if(pArr[pIndex] != sArr[sIndex])
					return false;
				pIndex++;
				sIndex++;
			}			
		}
		
		return sIndex == sLen && pIndex == pLen;
	}
	
	boolean isDigit(char[] arr, int index)
	{
		char ch = arr[index];
		return (ch >= 48 && ch <= 57);
	}
	
	public static void main(String[] args) 
	{
		UncompressStringMatch obj = new UncompressStringMatch();
		System.out.println(obj.isMatch("a2", "abc"));				//true
		System.out.println(obj.isMatch("ab", "ab"));				//true
		System.out.println(obj.isMatch("abc", "ab"));				//false
		System.out.println(obj.isMatch("abc", "abcd"));				//false
		System.out.println(obj.isMatch("a2", "ab"));				//false
		System.out.println(obj.isMatch("a5q", "abcserq"));			//true
		System.out.println(obj.isMatch("a11q", "abcseribcserq"));	//true
		System.out.println(obj.isMatch("a11q", "abcseribcserqa"));	//false
	}
}
