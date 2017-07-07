/******  Check Removeaay class contains checkfull method
It is used to Remove clitic 'kk' 'cc' 'tt' 'p' from Endpattern search method **************

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

/***Check Removeaay class contains checkfull method
it is used to Remove clitic 'kk' 'cc' 'tt' 'p' from Endpattern search method ***/

public class Removekkccttpp
{
	//Checkfullitem class used to check all items (ie noun,verb,adverb,adjective,particle....)
	Checkfullitem checkfull=new Checkfullitem();

/******************************Default constructor************************************/

	Removekkccttpp()
	{ }

/**************This method can be used to Remove clitic 'kk' 'cc' 'tt' 'p' from Endpattern search method******/

	public void removekctp()
  {
  System.out.println(" Calling removekctp");
/*********************************remove kk from Second token*********************************/

   	 if(Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.kk))
   	 {
   	     if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.kk))
   	     {
   	     	 Tagger.FourthToken=Tagger.FirstToken;
         	 Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.FirstToken,0,(Tagger.FirstToken.length-1));
			 Tagger.token=true;
         	 if(Tagger.specifylength==null)
   	     	 {
         	  	  Tagger.FirstToken=Tagger.FourthToken;
         	  	  //checkfull method used to check all items (ie noun,verb,adverb,adjective,particle....)
         	 	  checkfull.checkfull();
   	         }
   	         else
   	     	 {
	            Tagger.FirstToken=Tagger.specifylength;
	            //checkfull method used to check all items (ie noun,verb,adverb,adjective,particle....)
    	        checkfull.checkfull();
   	     	 }
   	      }
   	      else
   	       checkfull.checkfull();
   	 }

/*********************************remove cc from Second token*********************************/

	 else if(Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.cc))
   	 {
   	     if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.cc))
   	     {
   	     	  Tagger.FourthToken=Tagger.FirstToken;
         	  Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.FirstToken,0,(Tagger.FirstToken.length-1));
			  Tagger.token=true;
         	  if(Tagger.specifylength==null)
   	     	  {
         	  	Tagger.FirstToken=Tagger.FourthToken;
         	  	//checkfull method used to check all items (ie noun,verb,adverb,adjective,particle....)
         	 	checkfull.checkfull();
   	          }
   	          else
   	     	  {
             	Tagger.FirstToken=	Tagger.specifylength;
             	//checkfull method used to check all items (ie noun,verb,adverb,adjective,particle....)
             	checkfull.checkfull();
   	     	  }
   	      }
   	      else
   	     	  checkfull.checkfull();
   	 }

/*********************************remove p from Second token*********************************/

   	 else if(Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.p))
   	 {
   	     if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.p))
   	     {
   	  	      Tagger.FourthToken=Tagger.FirstToken;
         	  Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.FirstToken,0,(Tagger.FirstToken.length-1));
			  Tagger.token=true;
         	  if(Tagger.specifylength==null)
   	     	  {
         	  	  Tagger.FirstToken=Tagger.FourthToken;
         	  	  //checkfull method used to check all items (ie noun,verb,adverb,adjective,particle....)
         	 	  checkfull.checkfull();
   	          }
   	          else
   	     	  {
             	Tagger.FirstToken=Tagger.specifylength;
             	//checkfull method used to check all items (ie noun,verb,adverb,adjective,particle....)
             	checkfull.checkfull();
   	     	  }
   	     }
   	     else
   	     	 checkfull.checkfull();
   	 }

/*********************************remove t1 from Second token*********************************/

     else if(Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.t1))
   	 {
   	     if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.t1))
   	     {
   	     	 Tagger.FourthToken=Tagger.FirstToken;
         	 Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.FirstToken,0,(Tagger.FirstToken.length-1));
			 Tagger.token=true;
         	 if(Tagger.specifylength==null)
   	     	 {
         	  	Tagger.FirstToken=Tagger.FourthToken;
         	  	//checkfull method used to check all items (ie noun,verb,adverb,adjective,particle....)
         	 	checkfull.checkfull();
   	       	 }
   	         else
   	     	 {
            	Tagger.FirstToken=Tagger.specifylength;
            	//checkfull method used to check all items (ie noun,verb,adverb,adjective,particle....)
            	checkfull.checkfull();
   	     	 }
   	     }
   	     else
   	     checkfull.checkfull();
   	 }

/*********************************last else part*********************************/

     else
     {
		 //checkfull method used to check all items (ie noun,verb,adverb,adjective,particle....)
        checkfull.checkfull();
     }
	}
}