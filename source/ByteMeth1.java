/********* Bytemethod1 class is as similar as String class
Byte operations  such as comparison of two bytes, adding two bytes,end pattern search using byte and start pattern search  are carried out.
*******/
public class ByteMeth1
{

/********Bytemethod1 class is as similar as String class
Byte operations such as comparison two bytes, adding two bytes, end pattern search using byte and start pattern search are carried out.
* @param java.lang.String()
*******/
	public static void main(String a[])
 	{
		ByteMeth1 t= new ByteMeth1();
		/*byte[] b={3,4};
		byte tha[]={20,1};//using tabconverter initilaise the variable "tha"
		byte[]  c={2,3,4};

		if(t.endswith(b,c))
		System.out.println("true");
		else System.out.println("false");*/

	}

/************ isequal1 function check to bytes in specify location*********

	public boolean isequal1(byte[] b,byte[] c)
	{
		int a=0,d=0;int pflag=0;
		a=c.length;
		d=b.length;
		try
		{
		    for(int i=0;i<=d-a;i++)
		    {
			   int ti=i;
			   for(int j=0;j<=a;j++)
		       {
		  			if(b[ti]==c[j])
			    	{
					     ti++;
					     pflag++;
				   		//continue;
				    }
				    else
				    {
				    	 pflag=0;
				     	 break;
				    }
			    }

				/*if(pflag==a)
				{
				System.out.println(" Match Found");
				return true;
				}*/ /*
			}
			if(pflag<a)
			{
				//System.out.println("false" +pflag);
				return false;
			}
			else
			{
				System.out.println("true" +pflag);
				return true;
			}
		}
  		catch(Exception pe)
  		{
		//System.out.println(pe);
		return true;
   		}
	}*/

/*********************To check and compare two bytes
* @param b -java.lang.byte
* @param c -java.lang.byte
****************/

	public boolean isequal(byte[] b,byte[] c)
  	{
	  if(b.length != c.length)
    		return false;
      for(int i=0;i<b.length;i++)
      {
			if(b[i]==c[i]);
			else
				return false;
      }
	  return true;
  	}

/*******************It merges two byte arrays into one byte array
* @param b -byte array that has to be added with c
* @param c -byte array to which b is added
* @return Returns byte array
*********************/

	public byte[] addarray(byte b[],byte[] c)
	{
   		byte a[]= new byte[b.length+c.length];
        for(int i=0;i<b.length;i++)
        a[i]=b[i];
        for(int i=0;i<c.length;i++)
        a[b.length+i]=c[i];
        return a;
  	}

/*************** To find out sub array
Returns a new byte that is a subarray of this byte.
The subarray begins at the specified beginIndex and extends to the character at index endIndex - 1.
Thus the length of the subarray is endIndex-beginIndex.
* @param b -java.lang.byte
* @param c -java.lang.int
* @param d -java.lang.int

**********/

	public byte[] subarray(byte[] b,int c,int d)
    {
     	byte[] a=new byte[d-c];
     	for(int i=c;i<d;i++)
       	a[i-c]=b[i];
   		return a;
  	}

/******** It checks the first given  array starts
with the second or not
*  @param b-first array checks with the second one
*  @param c-second array checks whether it is the starting of first one
*  @return Returns true if first starts with second otherwise false
*********************/

	public boolean startswith(byte[] b,byte[] c)
  	{
    	 int len1=0,len2=0;
    	 if(b.length>c.length)
         {
         	len1=b.length;
         	len2=c.length;
         }
     	 else
         {
        	len1=c.length;
         	len2=b.length;
         }
    	 for(int i=0;i<len2;i++)
      	 if(b[i]==c[i]);
      	 else return false;
         return true;
 	}

/***** It checks the first given  array is ending with second or not
* @param b - First array checks with the second one
* @param c - second array checks whether it is the ending of first one

 * @return if the first array ends with second,it returns true or false.

*********************/

	public boolean endswith(byte[] b,byte[] c)
  	{
  		int len1=0,len2=0;
     	if(b.length<c.length)
        return false;
     	if(b.length>=c.length)
        {
        	 len1=b.length;
         	len2=c.length;
        }
     	else
        {
        	len1=c.length;
        	len2=b.length;
        }
		for(int i=len1-1,j=len2-1;j!=-1 && i!=-1;j--,i--)
	    if(b[i]==c[j]);
	    else return false;
        return true;
 }
}