class Base7
{
    public String convertToBase7(int num) 
    {
        StringBuilder sb = new StringBuilder();
        boolean isNegative = false;
        
        if (num == 0) return "0";
        
        if (num < 0)
        {
            num *= -1;
            isNegative = true;
        }
        
        while (num != 0)
        {
            sb.append(num % 7);
            num = num / 7;
        }
        return (isNegative ? "-" : "") + sb.reverse().toString();
    }
}
