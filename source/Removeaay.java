/****** Check Removeaay class contains checkvp method
It is used to Remove all clitics eeey,eey,oo,aaa,eiumm from Endpattern search**************

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

/********* This class is used to remove all clitics eeey,eey,oo,aaa,eiumm *****************/

public class Removeaay
{
	//Checkverbphrase class used to check the verbphrase using casemarker,heuristic rules
    Checkverbphrase checkvp=new Checkverbphrase();

/********* Default Constructor ******************************************************************/

	public Removeaay()
	{
	}

/********* Removeeey Method can be used to Remove all clitics eeey,eey,oo,aaa,eiumm from Endpattern search *************/

    public void removeeey()
    {
		System.out.println(" Calling removeeey");
/********* Remove eey,ooo,aaa from FirstToken**********************************************************/

      if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.eey)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aaa)
    	||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.oo))
   	  {
          if(Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.udana)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.yalla)
		  ||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.kila))
		  {
		  	   /****** call checkvp method in checkverb class*****/
		       checkvp.checkvp();
		  }
		  else
		  {
	   	  	  Tagger.FourthToken=Tagger.FirstToken;
	   	      Tagger.sublength=Tagger.bytemeth.subarray(Tagger.FirstToken,Tagger.FirstToken.length-1,Tagger.FirstToken.length);
	          Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.FirstToken,0,(Tagger.FirstToken.length-1));
	          Tagger.FirstToken=Tagger.specifylength;
	          Tagger.token=true;
			  /****** call checkvp method in checkverb class*****/
	          checkvp.checkvp();
		  }
   	  }

/********** Remove  eiumm ,vvum from FirstToken****************************************************/

   	  else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.eiumm)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.vvumm))
   	  {
   	  	  Tagger.FourthToken=Tagger.FirstToken;
       	  Tagger.sublength=Tagger.bytemeth.subarray(Tagger.FirstToken,Tagger.FirstToken.length-3,Tagger.FirstToken.length);
          Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.FirstToken,0,(Tagger.FirstToken.length-3));
          Tagger.FirstToken=Tagger.specifylength;
          Tagger.token=true;
		  /****** call checkvp method in checkverb class*****/
          checkvp.checkvp();
   	  }

/********** Remove umm from FirstToken*************************************************************/

      else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.umm))
   	  {
   	  	if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.meendum)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.perum)
		 ||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.vendum)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.ondrum))
   	  	{
			/****** call checkvp method in checkverb class*****/
   	  		checkvp.checkvp();
   	  	}
		else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.rumm)
		||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.thumm)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.pumm))
		{
   	  	    Tagger.FourthToken=Tagger.FirstToken;
   	  	    Tagger.sublength=Tagger.bytemeth.subarray(Tagger.FirstToken,Tagger.FirstToken.length-1,Tagger.FirstToken.length);
	        Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.FirstToken,0,(Tagger.FirstToken.length-1));
	        Tagger.FirstToken=Tagger.specifylength;
	        Tagger.token=true;
			/****** call checkvp method in checkverb class*****/
	        checkvp.checkvp();
   	  	}
   	  	else
   	  	{
   	  	    Tagger.FourthToken=Tagger.FirstToken;
   	  	    Tagger.sublength=Tagger.bytemeth.subarray(Tagger.FirstToken,Tagger.FirstToken.length-2,Tagger.FirstToken.length);
	        Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.FirstToken,0,(Tagger.FirstToken.length-2));
	        Tagger.FirstToken=Tagger.specifylength;
	        Tagger.token=true;
			/****** call checkvp method in checkverb class*****/
	        checkvp.checkvp();
   	  	}
   	  }

/************** Remove cuda from FirstToken********************************************************/

   	  else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.cuda))
   	  {
   	  	  Tagger.FourthToken=Tagger.FirstToken;
       	  System.out.println(tabconvert2.revert(Tagger.FourthToken));
       	  Tagger.sublength=Tagger.bytemeth.subarray(Tagger.FirstToken,Tagger.FirstToken.length-4,Tagger.FirstToken.length);
          Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.FirstToken,0,(Tagger.FirstToken.length-4));
          Tagger.FirstToken=Tagger.specifylength;
          Tagger.token=true;
		  /****** call checkvp method in checkverb class*****/
          checkvp.checkvp();
   	  }

/************** Remove avathu from FirstToken****************************************************/

   	  else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.avathu))
   	  {
   	  	  Tagger.FourthToken=Tagger.FirstToken;
       	  System.out.println(tabconvert2.revert(Tagger.FourthToken));
       	  Tagger.sublength=Tagger.bytemeth.subarray(Tagger.FirstToken,Tagger.FirstToken.length-5,Tagger.FirstToken.length);
          Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.FirstToken,0,(Tagger.FirstToken.length-5));
          Tagger.FirstToken=Tagger.specifylength;
          Tagger.token=true;
		  /****** call checkvp method in checkverb class*****/
          checkvp.checkvp();
   	  }

/************ last else part ******************************************************/
   	  else
   		{
    	  /****** call checkvp method in checkverb class*****/
   	      checkvp.checkvp();
   	  }
   	}
}