/******  Check Removeaay class contains remove method
it is  used to Remove 'k' 'c' 't' 'p'  from Endpattern search method **************

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

public class Removekctp
{
	/**Check Removeaay class contains remove method
	it can be used to Remove 'k' 'c' 't' 'p'  from Endpattern search method**/
	Removeaay remove = new Removeaay();

/****************************Default constructor*****************************************/

	Removekctp()
	{ }

/**************This method can be used to Remove 'k' 'c' 't' 'p'  from Endpattern search method **************/

	public void removeall()
    {
		System.out.println(" Calling removeall");
/************************************remove kk*********************************/

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

         	  	//Removeaay class  used to Remove all clitics eeey,eey,oo,aaa,eiumm
         	 	 remove.removeeey();
   	         }
   	         else
   	     	 {
            	Tagger.FirstToken=Tagger.specifylength;
				remove.removeeey();
   	     	 }
   	      }
   	      else
   	       remove.removeeey();
   	 }

/****************************************remove cc from Second token*********************************/

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
         	 	  remove.removeeey();
   	          }
   	          else
   	     	  {
             	Tagger.FirstToken=	Tagger.specifylength;
             	//Removeaay class  used to Remove all clitics eeey,eey,oo,aaa,eiumm
              	remove.removeeey();
   	     	  }
   	      }
   	      else
   	     	  remove.removeeey();
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
         	  	//Removeaay class  used to Remove all clitics eeey,eey,oo,aaa,eiumm
         	 	remove.removeeey();
   	          }
   	          else
   	     	  {
             	Tagger.FirstToken=Tagger.specifylength;
             	//Removeaay class  used to Remove all clitics eeey,eey,oo,aaa,eiumm
             	remove.removeeey();
   	     	  }
   	     }
   	     else
   	     	 remove.removeeey();
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
         	  	  //Removeaay class  used to Remove all clitics eeey,eey,oo,aaa,eiumm
         	 	  remove.removeeey();
   	         }
   	         else
   	     	 {
            	Tagger.FirstToken=Tagger.specifylength;
            	//Removeaay class  used to Remove all clitics eeey,eey,oo,aaa,eiumm
            	remove.removeeey();
   	     	 }
   	     }
   	     else
   	     remove.removeeey();
   	 }

/*********************************last else part*********************************/

     else
     {
        //Removeaay class  used to Remove all clitics eeey,eey,oo,aaa,eiumm
        remove.removeeey();

     }
	  }
	}