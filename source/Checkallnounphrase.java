/******  Checkallnounphrase class  contains  checkfull and removekctp method
it can identify Nounphrase from Standalone words, case markers, tense marker,Endpattern search and startpattern search and  it also identify Noun and verb using morphological and heuristic rules  **************

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

/**Checkallnounphrase class  contains the checkfull and removekctp method.It can identify Nounphrase from
Standalone words, case markers, tense marker,Endpattern search and startpattern search also identify Noun and verb, all are using morphological and hurestic rules **/
public class Checkallnounphrase
{
	//Removekkccttpp class is used to remove clitic 'kk' 'cc' 'tt' 'p'
	Removekkccttpp removekctp=new Removekkccttpp();

	//Checkfullitem class used to check all items (ie noun,verb,adverb,adjective,particle....)
	Checkfullitem checkfull=new Checkfullitem();

/*************************Default Constructor********************************/

	Checkallnounphrase()
	{
	}

/************** checkall method can identify Nounphrase from Standalone words, case markers, tense marker,Endpattern search and startpattern search also identify Noun and verb, all are using morphological and heuristic rules***********************************/

    public void checkall()
    {
			System.out.println(" Calling checkallnoun");
    	/***********************check third token in numbers**********************/

	    if(Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.a0)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.a1)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.a2)
    	  ||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.a3)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.a4)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.a5)
		  ||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.a6)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.a7)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.a8)
	      ||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.a9)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.a00)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.a01)
      	  ||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.a02)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.a03)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.a04)
	      ||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.a05)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.a06)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.a07)
      	  ||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.a08)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.a09)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.a00))
        {
		      if(Tagger.token==true)
     	      {
  	          		Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FourthToken)+"<N>"+"  ");
			        Tagger.count1   ++;
			     	Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
			   		Tagger.count1   ++;
			  		Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
			   		Tagger.count1   ++;
			        Tagger.FirstToken=Tagger.ThirdToken;
			  		Tagger.nexttoken=Tagger.stringtoken.nextToken();
			  		(Tagger.count)++;
			  		Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
			  		Tagger.nexttoken=Tagger.stringtoken.nextToken();
			  		(Tagger.count)++;
			  		Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
			  		Tagger.token=false;
	     	  }
              else
     	      {
     	   		    Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FirstToken)+"<N>"+"  ");
  			        Tagger.count1   ++;
		     		Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
		   			Tagger.count1   ++;
		  			Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
		   			Tagger.count1   ++;
		      		Tagger.FirstToken=Tagger.ThirdToken;
		  			Tagger.nexttoken=Tagger.stringtoken.nextToken();
		  			(Tagger.count)++;
		  			Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
		  			Tagger.nexttoken=Tagger.stringtoken.nextToken();
		  			(Tagger.count)++;
		  			Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
     	      }
      }

      /*********************************check third token in pronoun*****************************/

      else if(Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.nan)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.nam)
           ||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.nangal)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.nee)
           ||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.neever)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.neengal)
           ||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.avan)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.aval)
           ||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.athu)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.avai)
           ||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.avaigal)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.avargal)
           ||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.un)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.evan)
		   ||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.evai)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.evargal)
		   ||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.en)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.engal)
		   ||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.nm)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.thm)
		   ||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.em)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.evaigal)
		   ||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.thn)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.yathu)
		   ||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.yavan)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.yavar)
		   ||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.tham)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.avar))
	  {
		       if(Tagger.token==true)
			   {
			        Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FourthToken)+"<N>"+"  ");
					Tagger.count1   ++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
					Tagger.count1   ++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
					Tagger.count1   ++;
					Tagger.FirstToken=Tagger.ThirdToken;
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.token=false;
			   }
			   else
		 	   {
		 	   		Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FirstToken)+"<N>"+"  ");
			        Tagger.count1   ++;
			   		Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
					Tagger.count1   ++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
					Tagger.count1   ++;
			        Tagger.FirstToken=Tagger.ThirdToken;
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
			    	(Tagger.count)++;
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
		 	   }
	}

    /************************check third token in month************************************/

    else if(Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.vaikasi)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.aani)
	       ||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.aadi)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.aavani)
	       ||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.puratasi)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.aypasi)
	       ||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.margali)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.masi)
	       ||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.panguni)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.jan)
	       ||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.feb)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.mar)
	       ||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.apr)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.may)
	       ||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.jun)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.aug)
	       ||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.sep)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.oct)
	       ||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.nov)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.dec))
    {
			   if(Tagger.token==true)
			   {
			        Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FourthToken)+"<N>"+"  ");
					Tagger.count1   ++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
					Tagger.count1   ++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
					Tagger.count1   ++;
					Tagger.FirstToken=Tagger.ThirdToken;
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.token=false;
			    }
			    else
    	        {
    	        	Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FirstToken)+"<N>"+"  ");
					Tagger.count1   ++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
					Tagger.count1   ++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
					Tagger.count1   ++;
					Tagger.FirstToken=Tagger.ThirdToken;
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
    	        }

    }

    /**********************check third token in verbs using PNG marker***********************/

 	else if(Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.atu)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.ana)
         ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.kal)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.than))
    {
		  	if(Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.vayathu))
          	{
		  			if(Tagger.token==true)
		            {
			  	        Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FourthToken)+"<N>"+"  ");
						Tagger.count1   ++;
						Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+" ");
						Tagger.count1   ++;
						Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
						Tagger.count1   ++;
						Tagger.FirstToken=Tagger.ThirdToken;
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						(Tagger.count)++;
						Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						(Tagger.count)++;
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.token=false;
			     	}
			     	else
	   	      	    {
						Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FirstToken)+"<N>"+"  ");
						Tagger.count1   ++;
						Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
						Tagger.count1   ++;
						Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
						Tagger.count1   ++;
						Tagger.FirstToken=Tagger.ThirdToken;
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						(Tagger.count)++;
						Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						(Tagger.count)++;
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
	   	      	    }
	   	    }
			else
			{
	       	    Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.ThirdToken,0,(Tagger.ThirdToken.length-3));

				/*****************************check for tense marker********************/

     			if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.thh)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.ei)
		       	  ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.yh)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)
				  ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)
		       	  ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.p)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.v)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.pp)
		       	  ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.in)
		       	  ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nnt)
		       	  ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kindru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkindru)
		       	  ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkru))
		        {
		      	    if(Tagger.token==true)
		     	    {
							Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"  ");
							Tagger.count1   ++;
							Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<Unknown>"+" ");
							Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<V>"+" ");
							Tagger.count1   ++;
							Tagger.FirstToken=Tagger.ThirdToken;
							Tagger.nexttoken=Tagger.stringtoken.nextToken();
							(Tagger.count)++;
							Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
							Tagger.nexttoken=Tagger.stringtoken.nextToken();
							(Tagger.count)++;
							Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
							Tagger.token=false;
		     	    }
		     	    else
	   	      	    {

				   	      	Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"  ");
			          		Tagger.count1   ++;
							Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<Unknown>"+" ");
							Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<V>"+" ");
							Tagger.count1   ++;
							Tagger.FirstToken=Tagger.ThirdToken;
							Tagger.nexttoken=Tagger.stringtoken.nextToken();
							(Tagger.count)++;
							Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
							Tagger.nexttoken=Tagger.stringtoken.nextToken();
							(Tagger.count)++;
							Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
			        }
	   	       }
	   	       else
	   	       {
		          	if(Tagger.token==true)
		            {
			  	        Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FourthToken)+"<N>"+"  ");
						Tagger.count1   ++;
						Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
						Tagger.count1   ++;
						Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
						Tagger.count1   ++;
						Tagger.FirstToken=Tagger.ThirdToken;
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						(Tagger.count)++;
						Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						(Tagger.count)++;
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.token=false;
			     	}
			     	else
	   	      	    {
						Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FirstToken)+"<N>"+"  ");
						Tagger.count1   ++;
						Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
						Tagger.count1   ++;
						Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
						Tagger.count1   ++;
						Tagger.FirstToken=Tagger.ThirdToken;
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						(Tagger.count)++;
						Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						(Tagger.count)++;
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
	   	      	    }
	   	       }
			}
	}

	/****************check third token in verbs and ending fullstop using PNG marker****/

 	 else if (Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.atu1)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.ana1)
 	      ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.kal1)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.than1))
	 {
		  if(Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.vayathu1))
          {
		  			if(Tagger.token==true)
		            {
			  	        Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FourthToken)+"<N>"+"  ");
						Tagger.count1   ++;
						Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+" ");
						Tagger.count1   ++;
						Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
						Tagger.count1   ++;
						Tagger.FirstToken=Tagger.ThirdToken;
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						(Tagger.count)++;
						Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						(Tagger.count)++;
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.token=false;
			     	}
			     	else
	   	      	    {
						Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FirstToken)+"<N>"+"  ");
						Tagger.count1   ++;
						Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
						Tagger.count1   ++;
						Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
						Tagger.count1   ++;
						Tagger.FirstToken=Tagger.ThirdToken;
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						(Tagger.count)++;
						Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						(Tagger.count)++;
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
	   	      	    }
	   	}
		else
		{
	      Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.ThirdToken,0,(Tagger.ThirdToken.length-5));

		  /******************************check for tense marker********************************/

     	  if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.thh)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.ei)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.yh)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)
			||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.p)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.v)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.pp)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.in)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nnt)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kindru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkindru)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkru))
	      {
		      if(Tagger.token==true)
		      {
		            Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"  ");
		 	        Tagger.count1   ++;
		     		Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<Unknown>");
		  			Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<V>"+" ");
		   			Tagger.count1   ++;
			        Tagger.FirstToken=Tagger.ThirdToken;
		  			Tagger.nexttoken=Tagger.stringtoken.nextToken();
		  			(Tagger.count)++;
		  			Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
		  			Tagger.nexttoken=Tagger.stringtoken.nextToken();
		  			(Tagger.count)++;
		  			Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
		  			Tagger.token=false;
		      }
		      else
	   	   	  {
		   	      	Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"  ");
	          		Tagger.count1   ++;
         			Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<Unknown>");
         			Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<V>"+" ");
		       		Tagger.count1   ++;
    		        Tagger.FirstToken=Tagger.ThirdToken;
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
			  }
	   	  }
	   	  else
	   	  {
		   	  if(Tagger.token==true)
		      {
			        Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FourthToken)+"<N>"+"  ");
			        Tagger.count1   ++;
			   		Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
					Tagger.count1   ++;
			        Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
					Tagger.count1   ++;
					Tagger.FirstToken=Tagger.ThirdToken;
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.token=false;
			  }
			  else
	   	      {
			   	 	Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FirstToken)+"<N>"+"  ");
			       	Tagger.count1   ++;
			       	Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
					Tagger.count1   ++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
					Tagger.count1   ++;
			        Tagger.FirstToken=Tagger.ThirdToken;
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
	   	      }
	   	  }
		}
	}

	/**********************check third token in verbs using another set PNG marker*********/

 	else if(Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.aan)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.aall)
         ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.aay)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.aar)
         ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.eer)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.een)
         ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.oom))
    {
       	  Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.ThirdToken,0,(Tagger.ThirdToken.length-2));

		  /**********************************tense marker**************************/

 		  if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)/*||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.yh)*/||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.n)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.p)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.v)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.pp)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.in)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nnt)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kindru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkindru)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkru))
	      {
		      	if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"  ");
					Tagger.count1   ++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<Unknown>"+" ");
					Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<V>"+" ");
					Tagger.count1   ++;
					Tagger.FirstToken=Tagger.ThirdToken;
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.token=false;
				}
				else
				{

					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"  ");
					Tagger.count1   ++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<Unknown>"+" ");
					Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<V>"+" ");
					Tagger.count1   ++;
					Tagger.FirstToken=Tagger.ThirdToken;
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
				}
	   	  }
		  else
		  {
	      	if(Tagger.token==true)
			{
				Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FourthToken)+"<N>"+"  ");
				Tagger.count1   ++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
				Tagger.count1   ++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
				Tagger.count1   ++;
				Tagger.FirstToken=Tagger.ThirdToken;
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
				Tagger.token=false;
			}
			else
			{
				Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FirstToken)+"<N>"+"  ");
				Tagger.count1   ++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
				Tagger.count1   ++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
				Tagger.count1   ++;
				Tagger.FirstToken=Tagger.ThirdToken;
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
			}
    	}
	}

	/**************check third token in verbs with full stop ending using PNG marker***********/

 	else if(Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.aan1)
			||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.aall1)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.aay1)
			||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.aar1)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.eer1)
			||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.een1)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.oom1))
    {
	      Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.ThirdToken,0,(Tagger.ThirdToken.length-4));

		  /****************************tense marker***************************/

     	  if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)/*||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.yh)*/||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.n)
			||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)
			||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.p)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.v)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.pp)
			||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.in)
			||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nnt)
			||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kindru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkindru)
			||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkru))
		  {
		      	if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"  ");
					Tagger.count1   ++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<Unknown>"+" ");
					Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<V>"+" ");
					Tagger.count1   ++;
					Tagger.FirstToken=Tagger.ThirdToken;
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.token=false;
				}
				else
				{

					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"  ");
					Tagger.count1   ++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<Unknown>" +" ");
					Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<V>"+"  ");
					Tagger.count1   ++;
					Tagger.FirstToken=Tagger.ThirdToken;
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
				}
			}
			else
			{
				if(Tagger.token==true)
				{
					Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FourthToken)+"<N>"+"  ");
					Tagger.count1   ++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
					Tagger.count1   ++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
					Tagger.count1   ++;
					Tagger.FirstToken=Tagger.ThirdToken;
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.token=false;
			    }
				else
				{
					Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FirstToken)+"<N>"+"  ");
					Tagger.count1   ++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
					Tagger.count1   ++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
					Tagger.count1   ++;
					Tagger.FirstToken=Tagger.ThirdToken;
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					(Tagger.count)++;
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
				}
			}
	}

    /**********************check third token in nouns using ai ending*********************/

    else if(Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.ai))
	{
	   	 if(Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.ellai)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.ellai1)
	   	   ||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.ellai))
	   	 {
	   	  	if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"  ");
				Tagger.count1   ++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<Unknown>"+" ");
				Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<V>"+" ");
				Tagger.count1   ++;
				System.out.println("count1   " +Tagger.count1   );
				Tagger.FirstToken=Tagger.ThirdToken;
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
				System.out.println("count" + Tagger.count);
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
				System.out.println("count" + Tagger.count);
				Tagger.token=false;
			}
			else
			{

				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"  ");
				Tagger.count1   ++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<Unknown>"+" ");
				Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<V>"+" ");
				Tagger.count1   ++;
				Tagger.FirstToken=Tagger.ThirdToken;
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
			}
		}
		else
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FourthToken)+"<N>"+"  ");
				Tagger.count1   ++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
				Tagger.count1   ++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
				Tagger.count1   ++;
				Tagger.FirstToken=Tagger.ThirdToken;
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
				Tagger.token=false;
			}
			else
			{
				Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FirstToken)+"<N>"+"  ");
				Tagger.count1   ++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
				Tagger.count1   ++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
				Tagger.count1   ++;
				Tagger.FirstToken=Tagger.ThirdToken;
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
			}
		}
	}

    /****************check third token in nouns using case marker************************/

    else if(Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.kku)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.ukku)
    	 ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.akku)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.erkku))
    {
       	 if(Tagger.token==true)
		{
			Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FourthToken)+"<N>"+"  ");
			Tagger.count1   ++;
			Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
			Tagger.count1   ++;
			Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
			Tagger.count1   ++;
			Tagger.FirstToken=Tagger.ThirdToken;
			Tagger.nexttoken=Tagger.stringtoken.nextToken();
			(Tagger.count)++;
			Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
			Tagger.nexttoken=Tagger.stringtoken.nextToken();
			(Tagger.count)++;
			Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
			Tagger.token=false;
		}
		else
		{
			Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FirstToken)+"<N>"+"  ");
			Tagger.count1   ++;
			Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
			Tagger.count1   ++;
			Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
			Tagger.count1   ++;
			Tagger.FirstToken=Tagger.ThirdToken;
			Tagger.nexttoken=Tagger.stringtoken.nextToken();
			(Tagger.count)++;
			Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
			Tagger.nexttoken=Tagger.stringtoken.nextToken();
			(Tagger.count)++;
			Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
		}
	}
/*	//check in nouns using case marker
    else if(Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.en)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.nm)
    	 ||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.thn)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.un))
    {
    	System.out.println("ukku in ck all");
       	if(Tagger.token==true)
		{
			Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FourthToken)+"<PN>"+"  ");
			Tagger.count1   ++;
			Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
			Tagger.count1   ++;
			Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>");
			Tagger.count1   ++;
			System.out.println("count1   " +Tagger.count1   );
			Tagger.FirstToken=Tagger.ThirdToken;
			Tagger.nexttoken=Tagger.stringtoken.nextToken();
			(Tagger.count)++;
			Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
			System.out.println("count" + Tagger.count);
			Tagger.nexttoken=Tagger.stringtoken.nextToken();
			(Tagger.count)++;
			Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
			System.out.println("count" + Tagger.count);
			Tagger.token=false;
		}
		else
		{
			Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FirstToken)+"<PN>"+"  ");
			Tagger.count1   ++;
			Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
			Tagger.count1   ++;
			Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>");
			Tagger.count1   ++;
			System.out.println("count1   " +Tagger.count1   );
			Tagger.FirstToken=Tagger.ThirdToken;
			Tagger.nexttoken=Tagger.stringtoken.nextToken();
			(Tagger.count)++;
			Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
			System.out.println("count" + Tagger.count);
			Tagger.nexttoken=Tagger.stringtoken.nextToken();
			(Tagger.count)++;
			Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
			System.out.println("count" + Tagger.count);
		}
	}*/

    /**************************check third token in nouns using case marker***********************/

    else if(Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.in)|| Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.ppu)
		 ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.itam)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.oor)
		 ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.udya)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.utan)
		 ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.ul)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.il)
		 ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.aal)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.oodu)
		 ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.odu)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.ar)
		 ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.an)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.al)
		 ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.amm)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.cchi)
		 ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.aall)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.aall1)
		 ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.ar1)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.sss)
		 ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.ss)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.me)
		 ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.lee)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.mmpu)
		 ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.amm1))
	{
 	    if(Tagger.token==true)
		{
			Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FourthToken)+"<N>"+"  ");
			Tagger.count1   ++;
			Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
			Tagger.count1   ++;
			Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
			Tagger.count1   ++;
			Tagger.FirstToken=Tagger.ThirdToken;
			Tagger.nexttoken=Tagger.stringtoken.nextToken();
			(Tagger.count)++;
			Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
			Tagger.nexttoken=Tagger.stringtoken.nextToken();
			(Tagger.count)++;
			Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
			Tagger.token=false;
		}
		else
		{
			Tagger.textarea.append("["+tabconvert2.revert(Tagger.FirstToken)+"<N>"+"  ");
			Tagger.count1   ++;
			Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+" ");
			Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  "+"]"+"<NP>"+" ");
			Tagger.count1   ++;
			Tagger.count1   ++;
			Tagger.FirstToken=Tagger.ThirdToken;
			Tagger.nexttoken=Tagger.stringtoken.nextToken();
			(Tagger.count)++;
			Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
			Tagger.nexttoken=Tagger.stringtoken.nextToken();
			(Tagger.count)++;
			Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
		}
	}

	/***********************check third token in numbers**************************/

	else if(Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.three)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.muthal)/*||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.eru)*/
		||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.four)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.ten)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.six)
		||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.seven)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.eight)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.nine)
		||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.two)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.hunrd)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.lagsh)
		||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.thosn)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.crore)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.one)
		||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.three)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.five)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.oor)
		||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.kadaisi)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.hunrd1)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.four1)
		||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.six1)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.six3))
    {
		  if(Tagger.token==true)
		  {
				Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FourthToken)+"<N>"+"  ");
				Tagger.count1   ++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
				Tagger.count1   ++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
				Tagger.count1   ++;
				Tagger.FirstToken=Tagger.ThirdToken;
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
				Tagger.token=false;
		  }
		  else
		  {
				Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FirstToken)+"<N>"+"  ");
				Tagger.count1   ++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
				Tagger.count1   ++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
				Tagger.count1   ++;
				Tagger.FirstToken=Tagger.ThirdToken;
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
		  }
    }

    /*****************************check third token in numbers*****************************/

		else if(Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.three)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.muthal)/*||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.eru)*/
			||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.four)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.ten)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.six)
			||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.seven)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.eight)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.nine)
			||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.two)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.hunrd)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.lagsh)
			||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.thosn)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.crore)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.one)
			||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.three)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.five)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.oor)
			||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.kadaisi)||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.hunrd1))
    {
		  if(Tagger.token==true)
		  {
				Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FourthToken)+"<N>"+"  ");
				Tagger.count1   ++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
				Tagger.count1   ++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
				Tagger.count1   ++;
				Tagger.FirstToken=Tagger.ThirdToken;
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
				Tagger.token=false;
		  }
			else
		  {
				Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FirstToken)+"<N>"+"  ");
				Tagger.count1   ++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
				Tagger.count1   ++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
				Tagger.count1   ++;
				Tagger.FirstToken=Tagger.ThirdToken;
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
		  }
    }

    /***************************check third token in nouns using case marker*********************/

    else if(Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.ilunthu)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.edamiruthu)
     	 ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.ukkaka))
  	{
 		if(Tagger.token==true)
		{
			Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FourthToken)+"<N>"+"  ");
			Tagger.count1   ++;
			Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
			Tagger.count1   ++;
			Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  ]"+"<NP>"+" ");
			Tagger.count1   ++;
			Tagger.FirstToken=Tagger.ThirdToken;
			Tagger.nexttoken=Tagger.stringtoken.nextToken();
			(Tagger.count)++;
			Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
			Tagger.nexttoken=Tagger.stringtoken.nextToken();
			(Tagger.count)++;
			Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
			Tagger.token=false;
		}
		else
		{
			Tagger.textarea.append("["+tabconvert2.revert(Tagger.FirstToken)+"<N>"+"  ");
			Tagger.count1   ++;
			Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+" ");
			Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<N>"+"  "+"]"+"<NP>"+" ");
			Tagger.count1   ++;
			Tagger.count1   ++;
			Tagger.FirstToken=Tagger.ThirdToken;
			Tagger.nexttoken=Tagger.stringtoken.nextToken();
			(Tagger.count)++;
			Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
			Tagger.nexttoken=Tagger.stringtoken.nextToken();
			(Tagger.count)++;
			Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
		}
	}

/******************last else part********************/

    else
    {
        if(Tagger.token==true)
		{
			Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"  ");
			Tagger.count1   ++;
			Tagger.FourthToken=Tagger.SecondToken;
			//Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+" "+"<Unknown>");

			//checkfull method is used to check all items (ie noun,verb,adverb,adjective,particle....)
			checkfull.checkfull();
			if(Tagger.stringtoken.hasMoreTokens())
			{
				Tagger.FirstToken=Tagger.SecondToken;
				Tagger.SecondToken=Tagger.ThirdToken;
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
				if(Tagger.stringtoken.hasMoreTokens());
			}
			else
			{
				//Removekctp method  used to  Remove 'k' 'c' 't' 'p'  method
				removekctp.removekctp();
				Tagger.FirstToken=Tagger.SecondToken;

				//Removekctp method  used to  Remove 'k' 'c' 't' 'p'  method
				removekctp.removekctp();
				Tagger.FirstToken=Tagger.ThirdToken;

				//Removekctp method  used to  Remove 'k' 'c' 't' 'p'  method
				removekctp.removekctp();
			}
			Tagger.token=false;
		}
		else
		{
			Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"  ");
			Tagger.count1   ++;
			Tagger.FirstToken=Tagger.SecondToken;
			//Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+" "+"<Unknown>");

			//checkfull method is used to check all items (ie noun,verb,adverb,adjective,particle....)
			checkfull.checkfull();
			if(Tagger.stringtoken.hasMoreTokens())
			{
				Tagger.FirstToken=Tagger.SecondToken;
				Tagger.SecondToken=Tagger.ThirdToken;
				Tagger.nexttoken=Tagger.stringtoken.nextToken();
				(Tagger.count)++;
				Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
				if(Tagger.stringtoken.hasMoreTokens());
			}
			else
			{
				//removekctp.removekctp();
				//Tagger.FirstToken=Tagger.SecondToken;
				//removekctp.removekctp();
				Tagger.FirstToken=Tagger.ThirdToken;

				//Removekctp method  used to  Remove 'k' 'c' 't' 'p'  method
				removekctp.removekctp();
			}
		}
    }

  }
}