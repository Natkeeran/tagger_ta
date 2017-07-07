/******  Check adverb class contains checknp1 and removekctp methods.
It identifies Adverb and VerbalParticle from
Standalone words and Endpattern search and also identify Noun and Adjective using morphological and heuristic rules**************

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

/******** This class contains checknp1 and removekctp method
it identifes Adverb and VerbalParticle from
Standalone words and Endpattern search and also identify Noun and Adjective using morphological and heuristic rules ***************/

public class Checkadverb
{
	//Checknounphase1 class used to check checknounphase using morphological and heuristic rules
	Checknounphrase1 checknp1=new Checknounphrase1();

	//Removekkccttpp class is used to remove clitic 'kk' 'cc' 'tt' 'p'
	Removekkccttpp removekctp=new Removekkccttpp();

/********************************Default constructor ***********************/

	Checkadverb()
	{
	}

/****************This method used to tag adverb words. check the first token
	 in endswith operation after that check Second token in endswith operation*********/

	public void checkadv()
   	{
		System.out.println(" Calling checkadv");
	  if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aka)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.pondra)
	  ||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.pola)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.pol))
	  {
	      /********** using standalone adjective words***********************/

	      if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.avan)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aval)
	        ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.atu)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.avar)
	        ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.avargal)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.avai)
	        ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.avaigal))
	      {
	   	       		    if(Tagger.token==true)
			       	    {
								Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<ADJ>" +"");
								Tagger.count1   ++;
								Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"");
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

									//Removekctp class  used to  Remove 'k' 'c' 't' 'p'  method
									removekctp.removekctp();
								}
								Tagger.token=false;
			       	    }
			       	    else
						{
							Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<ADJ>"+" ");
							Tagger.count1   ++;
							Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+" ");
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

								//Removekctp class  used to  Remove 'k' 'c' 't' 'p'  method
								removekctp.removekctp();
						    }
						}
	      }
		  else
		  {
				//checknp1 class used to check checknounphase using morphological and heuristic rules
				checknp1.checknp1();
		  }
	  }

/************* First token "ai" ending check after check second token "kumm" ending define VerbalParticiple***********/

	  else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.ai))
	  {
	      /********using kumm ends check Vp**************/

	      if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.kumm))
	      {
	   	       		    if(Tagger.token==true)
			       	    {
								Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+" ");
								Tagger.count1   ++;
								Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<VP>"+" ");
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

									//Removekctp class  used to  Remove 'k' 'c' 't' 'p'  method
									removekctp.removekctp();
								}
								Tagger.token=false;
			       	    }
			       	    else
						{
							Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+" ");
							Tagger.count1   ++;
							Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<VP>"+" ");
							Tagger.count1   ++;
							Tagger.SecondToken=Tagger.ThirdToken;
							if(Tagger.stringtoken.hasMoreTokens())
							{
								(Tagger.count)++;
								Tagger.nexttoken=Tagger.stringtoken.nextToken();
								Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								if(Tagger.stringtoken.hasMoreTokens());
								else
								{
									Tagger.FirstToken=Tagger.SecondToken;

									//Removekctp class  used to  Remove 'k' 'c' 't' 'p'  method
								 	removekctp.removekctp();
									Tagger.FirstToken=Tagger.ThirdToken;

									//Removekctp class  used to  Remove 'k' 'c' 't' 'p'  method
									removekctp.removekctp();
								}
							}
							else
							{
								Tagger.FirstToken=Tagger.ThirdToken;

								//Removekctp class  used to  Remove 'k' 'c' 't' 'p'  method
								removekctp.removekctp();
						    }
						}
	      }
		  else
		  {
			  	//checknp1 class used to check noun phrase using morphological and heuristic rules
		    	checknp1.checknp1();
		  }
	  }
/******** check first token in standalone words mekka,ondrum for endpattren search
after check second token atu kal,ana than for endpattern search define   Verbal participle and Verb****/

	  else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.mekka)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.ondrum))
	  {
			  if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.atu)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.ana)
		          ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.kal)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.than))
		      {
					if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.vayathu))
		            {
             		    	checknp1.checknp1();
		            }
					else
					{
			       	    Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.SecondToken,0,(Tagger.SecondToken.length-3));

						/*********************check tense marker****************/

		     			if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.thh)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.ei)
				       	  ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.yh)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)
				       	  ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.p)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.v)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.pp)
				       	  ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.in)
				       	  ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nnt)
				       	  ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kindru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkindru)
				       	  ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkru))
				        {
								if(Tagger.token==true)
					       	    {
										Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<VP>"+" ");
										Tagger.count1   ++;
										Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+" ");
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

											//Removekctp class  used to  Remove 'k' 'c' 't' 'p'  method
											removekctp.removekctp();
										}
										Tagger.token=false;
					       	    }
					       	    else
								{
									Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<VP>"+" ");
									Tagger.count1   ++;
									Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+" ");
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

										//Removekctp class  used to  Remove 'k' 'c' 't' 'p'  method
										removekctp.removekctp();
								    }
								}
				        }
					}
		     }

	         /****************check first token in verbs using PNG marker
			 After that check second token in standalone words for endpattern search********************/

		 	 else if (Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.atu1)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.ana1)
		 	      ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.kal1)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.than1))
			 {
				if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.vayathu1))
		        {
             		    	checknp1.checknp1();
		        }
				else
				{
			      Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.SecondToken,0,(Tagger.SecondToken.length-5));
		     	  if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.thh)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.ei)
			       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.yh)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)
			       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.p)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.v)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.pp)
			       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.in)
			       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nnt)
			       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kindru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkindru)
			       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkru))
			      {
					  		    if(Tagger.token==true)
					            {
										Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<VP>"+" ");
										Tagger.count1   ++;
										Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+" ");
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

											//Removekctp class  used to  Remove 'k' 'c' 't' 'p'  method
											removekctp.removekctp();
										}
										Tagger.token=false;
					       	    }
					       	    else
								{
									Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<VP>"+" ");
									Tagger.count1   ++;
									Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+" ");
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

										//Removekctp class  used to  Remove 'k' 'c' 't' 'p'  method
										removekctp.removekctp();
								    }
								}
				        }
				}
			}

			 /****************check first token in verbs using another set PNG marker
			 After that check second token in tense marker for endpattern search********************/

		 	else if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aan)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aall)
		         ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aay)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aar)
		         ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.eer)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.een)
		         ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.oom))
		    {
		       	  Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.SecondToken,0,(Tagger.SecondToken.length-2));
		 		  if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)/*||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.yh)*/||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.ei)
			       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)
			       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.p)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.v)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.pp)
			       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.in)
			       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nnt)
			       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kindru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkindru)
			       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkru))
			      {
				         	  if(Tagger.token==true)
					          {
										Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<VP>"+" ");
										Tagger.count1   ++;
										Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+" ");
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

											//Removekctp class  used to  Remove 'k' 'c' 't' 'p'  method
											removekctp.removekctp();
										}
										Tagger.token=false;
					       	    }
					       	    else
								{
									Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<VP>"+" ");
									Tagger.count1   ++;
									Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+" ");
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

										//Removekctp class  used to  Remove 'k' 'c' 't' 'p'  method
										removekctp.removekctp();
								    }
								}
				        }
			}

			/****************check first token in verbs using  PNG marker with ending fullstop sentence
			 After that check second token in tense marker for endpattern search********************/


		 	else if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aan1)
					||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aall1)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aay1)
					||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aar1)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.eer1)
					||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.een1)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.oom1))
		    {
			      Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.SecondToken,0,(Tagger.SecondToken.length-4));
		     	  if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)/*||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.yh)*/||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.ei)
					||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)
					||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.p)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.v)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.pp)
					||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.in)
					||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nnt)
					||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kindru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkindru)
					||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkru))
				  {
				  				if(Tagger.token==true)
					            {
										Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<VP>"+" ");
										Tagger.count1   ++;
										Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+" ");
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

											//Removekctp class  used to  Remove 'k' 'c' 't' 'p'  method
											removekctp.removekctp();
										}
										Tagger.token=false;
					       	    }
					       	    else
								{
									Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<VP>"+" ");
									Tagger.count1   ++;
									Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+" ");
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

										//Removekctp class  used to  Remove 'k' 'c' 't' 'p'  method
										removekctp.removekctp();
								    }
								}
				        }
			}

		    /***************check second token in verbs using standalone words****************/

		    else if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.ellai)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.ellai1)
		   	   ||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.ellai))
		    {
	   	  	  					if(Tagger.token==true)
					            {
										Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<VP>"+" ");
										Tagger.count1   ++;
										Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+" ");
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

											//Removekctp class  used to  Remove 'k' 'c' 't' 'p'  method
											removekctp.removekctp();
										}
										Tagger.token=false;
					       	    }
					       	    else
								{
									Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<VP>"+" ");
									Tagger.count1   ++;
									Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+" ");
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

										//Removekctp class  used to  Remove 'k' 'c' 't' 'p'  method
										removekctp.removekctp();
								    }
								}
			}

			/*************last else  in Verbal participle part*****************/

			else
			{
				//checknp1 class used to check checknounphase using morphological and heuristic rules
			  	checknp1.checknp1();
			}
	}

/*******************************last in main else part************************/

	else
	{
		//checknp1 class used to check checknounphrase using morphological and heuristic rules
		checknp1.checknp1();
    }
   	}
}
