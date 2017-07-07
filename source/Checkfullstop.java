/******  Checkfullstop class contains checkfull and removekctp method
it identifies verb and noun in Endpattern search from stop word, using morphological and heuristic rules**************

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

/**Checkfullstop class contains checkfull and removekctp method
it identifies verb and noun in Endpattern search from stop word, using morphological and heuristic rules **/
public class Checkfullstop
{
	//Removekkccttpp class is used to remove clitic 'kk' 'cc' 'tt' 'p'
	Removekkccttpp removekctp=new Removekkccttpp();

	//Checkfullitem class used to check all items (ie noun,verb,adverb,adjective,particle....)
	Checkfullitem checkfull=new Checkfullitem();

   	/***********************Default constructor************************/

	Checkfullstop()
	{
	}

	/****checkstop method identifies verb and noun in Endpattern search from stop word, using morphological and heuristic rules**/

	public void checkstop()
   	{
		System.out.println(" Calling checkstop");
	 /********************** To check FirstToken for endpattern search **********************/
	  if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.stop))
	  {
	  	if (Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.kal1)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.amm1)
		  ||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aall1)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.atu1)
		  ||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.ar1))
		{
			//checkfull method is used to check all items (ie noun,verb,adverb,adjective,particle....)
			checkfull.checkfull();
		}
		else
		{

   		    if(Tagger.token==true)
       	    {
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<V>"+"   ");
					Tagger.count1   ++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
					Tagger.count1   ++;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						(Tagger.count)++;
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
					}
					else
					{
						Tagger.FirstToken=Tagger.ThirdToken;

						//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
						removekctp.removekctp();
					}
					Tagger.token=false;
       	    }
       	    else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<V>"+"   ");
				Tagger.count1   ++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
				Tagger.count1   ++;
				Tagger.SecondToken=Tagger.ThirdToken;
				if(Tagger.stringtoken.hasMoreTokens())
				{
					(Tagger.count)++;
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
				}
				else
				{
					Tagger.FirstToken=Tagger.ThirdToken;

					//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
					removekctp.removekctp();
			    }
			}
		}
	  }

	  /****************last else part**************/

	  else
	  {
		//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
	  	removekctp.removekctp();
	  }
	}
}
