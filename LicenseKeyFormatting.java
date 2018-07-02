class LicenseKeyFormatting
{
    public String licenseKeyFormatting(String S, int K) 
    {
        int n = S.length();
        StringBuilder sb = new StringBuilder();
        
        for (int i = n - 1; i >= 0; i--)
        {
            if (S.charAt(i) != '-')
            {
                sb.append(sb.length() % (K + 1) == K ? "-" : "").append(S.charAt(i));
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
}
