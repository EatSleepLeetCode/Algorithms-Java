class StudentAttendanceRecordI
{
    public boolean checkRecord(String s) 
    {
        boolean absent = false;
        int n = s.length();
        
        for (int i = 0; i < n; i++)
        {
            if (s.charAt(i) == 'A')
            {
                if (absent) return false;
                absent = true;                
            }
           else if (s.charAt(i) == 'L')
           {
               if ( i > 1 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 1) == s.charAt(i - 2)) return false;
           }            
        }
        return true;
    }
}
