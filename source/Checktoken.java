/****** Checktoken class  contains  removeall and checkfull methods
 String tokenizer is used to parse the file in to single token and process is done using above mentioned method **************

 Author 		:Dhinakaran .T
 Client 		:RCILTS
 Modify Date    :25.09.2002
 Anna University
 Copyright (c) 2002
 ************************/

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.System;
import java.io.*;
import java.sql.*;

/***Checktoken class  contains removeall and checkfull method
 String tokenizer is used to parse the file in to single token and process is done using above mentioned method ****/

public class Checktoken
{
	//Removekctp class  used to  Remove 'k' 'c' 't' 'p'
	Removekctp removeall=new Removekctp();

	//Checkfullitem class used to check all items (ie noun,verb,adverb,adjective,particle....)
	Checkfullitem checkfull=new Checkfullitem();

/*****************************************Default constructor******************************/

	Checktoken()
	{	}

/******************checktoken method  used to  parse the file using  delimiters
* @param string -java.lang.string

**************/

	public byte checktoken(String string)
 	{
/*****************using String Tokenizer to parse the String *********/
			System.out.println(" Calling checktoken");
   	   Tagger.stringtoken =new StringTokenizer(string,":'\f' '\n' '\n\n\n' ' ' ; < > \" ( ) /  , '  ' - ! ? _ '\t' ");
       while(Tagger.stringtoken.hasMoreTokens())
       {
      	  try
     	  {
      		(Tagger.count)++;
            Tagger.nexttoken =Tagger.stringtoken.nextToken();
            if(Tagger.count==1)
            {

/***************** to convert string into bytes**************************/

            Tagger.FirstToken=tabconvert2.convert(Tagger.nexttoken);
			if (Tagger.stringtoken.hasMoreTokens())
   		  	{
            	 Tagger.count++;
            	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
           		 Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
	       		 if (Tagger.stringtoken.hasMoreTokens())
          	     {
           			 Tagger.count++;
           			 Tagger.nexttoken=Tagger.stringtoken.nextToken();
           			 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);

           			 //removeall method  used to  Remove 'k' 'c' 't' 'p'
                     removeall.removeall();
            	 }
            	 else
                 {
               	 	Tagger.FirstToken=Tagger.FirstToken;

               	 	//removeall method  used to  Remove 'k' 'c' 't' 'p'
               	    removeall.removeall();
               		Tagger.FirstToken=Tagger.SecondToken;

               		//removeall method  used to  Remove 'k' 'c' 't' 'p'
                    removeall.removeall();
           		 }
            }
            else
            {
			  //checkfull method used to check all items (ie noun,verb,adverb,adjective,particle....)
              checkfull.checkfull();
           	}
	     }
         else if(Tagger.count>3)
       	 {
       		  if(Tagger.stringtoken.hasMoreTokens())
        	  {
        			 Tagger.FirstToken=Tagger.SecondToken;
            		 Tagger.SecondToken=Tagger.ThirdToken;
            		 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);

            		 //removeall method  used to  Remove 'k' 'c' 't' 'p'
         		 	 removeall.removeall();
        	  }
        	  else
         	  {
        	 	   Tagger.FirstToken=Tagger.SecondToken;

        	 	   //checkfull method used to check all items (ie noun,verb,adverb,adjective,particle....)
    			   checkfull.checkfull();
    			   Tagger.FirstToken=Tagger.ThirdToken;

    			   //checkfull method used to check all items (ie noun,verb,adverb,adjective,particle....)
                   checkfull.checkfull();
         	       Tagger.FirstToken=tabconvert2.convert(Tagger.nexttoken);

         	       //checkfull method used to check all items (ie noun,verb,adverb,adjective,particle....)
				   checkfull.checkfull();
         	  }
         }
  		 }
         catch(Exception e)
         {
         // Tagger.textarea.setText(tabconvert2.revert(Tagger.FirstToken)+"  "+"<unknown>"+"\n");
         }
  }
  return(0);
 }
}