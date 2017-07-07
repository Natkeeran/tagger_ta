/******  Checkverbphrase class contains checkadv method
it identifies VerbPhrase from
Standalone words and Endpattern search and also identify verb and Adverb,using morphological and heuristic rules **************

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


/**** Checkverbphrase class contains  checkadv method
it identify VerbPhrase from
Standalone words and Endpattern search and also identify verb and Adverb,using morphological and heuristic rules***/
public class Checkverbphrase
{
  //Check adverb class used to Check Adverb
  Checkadverb checkadv=new Checkadverb();

  //Removekkccttpp class is used to remove clitic 'kk' 'cc' 'tt' 'p'
  //Removekkccttpp removekctp=new Removekkccttpp();

  //Checkfullstop class used to check fullstop and analyse the verb token
  //Checkfullitem checkfull=new Checkfullitem();


/***********************************Default Constructor********************************/
	Checkverbphrase()
	{
	}
/***************checkvp method identify VerbPhrase from
Standalone words and Endpattern search and also identify verb and Adverb, using morphological and heuristic rules*****/
	public void checkvp()
    {
		System.out.println(" Calling checkvp");
	   try
   	   {

   	   	   /**********Using vendum,ellai,thondrum,vendam,kudum,kutathu**********/
   	       if(Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.vendum)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.thondrum)
	       	 ||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.kudum)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.kutathu)
         	 ||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.ellai)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.vendam)
             ||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.vendum1)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.thondrum1)
	       	 ||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.kudum1)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.kutathu1)
         	 ||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.ellai1)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.vendam1)
         	 ||Tagger.bytemeth.startswith(Tagger.ThirdToken,Tagger.ellai)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.ellai))
		   { // if1
              // for(int loop1=0; loop1<Tagger.str.length; loop1++)
          	   //{  // loop1
			        Tagger.token1=true;
                	/*if(Tagger.str[loop1].equals(tabconvert2.revert(Tagger.SecondToken)))
           	   	    {
					   for(int loop2=0; loop2<Tagger.str.length; loop2++)
		          	   {  // loop2
					        Tagger.token2=true;
		                	if(Tagger.str[loop1].equals(tabconvert2.revert(Tagger.FirstToken)))
		           	   	    {
		           	   	    	if(Tagger.token==true)
		                  	    {
									Tagger.token2=false;
		           	   	    	    Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FourthToken)+"<V>"+"   "+"  ");
							        Tagger.count1   ++;
							   		Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
									Tagger.count1   ++;
									Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<V>"+"   "+"  ]"+"<VPh>"+"   "+"\n");
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
									break;
							     }
							    else
								{
									Tagger.token2=false;
									Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FirstToken)+"<V>"+"  ");
									Tagger.count1   ++;
									Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
									Tagger.count1   ++;
									Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<V>"+"  ]"+"<VPh>"+"\n");
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
									break;
								}
		           	   	    }
		          	   }//loop 2
					   if(Tagger.token2==true)
       			       {
						    if(Tagger.token==true)
			        	    {
								      checkfull.checkfull();
			         	              Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>");
						          	  Tagger.count1++;
						         	  Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<V>");
						         	  Tagger.count1++;
									  System.out.println("count1   " +Tagger.count1   );
						         	  Tagger.token=false;
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
			        	    else
			        	    {
								 checkfull.checkfull();
					        	 Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>");
					          	 Tagger.count1++;
				         		 Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<V>");
					         	 Tagger.count1++;
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
       			       }
           	   	    } // 2nd if*/
			  // }//forloop1
			   if(Tagger.token1==true)
			   {
				    //checkadv  method used to Check Adverb
					checkadv.checkadv();
					//break;
				}
		 }//if1

         /********Using aatha,aammal,avital,aathu,ungal,aathirkal**********/
   	    /* else if(Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.aatha)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.aathu)
	         		||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.aammal)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.aavital)
         		  ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.ungal))
         { // if1
          	   System.out.println(" t3 aatha ok");
               for(int loop1=0; loop1<Tagger.str.length; loop1++)
          	   {  // loop1
                 	  if(Tagger.str[loop1].equals(tabconvert2.revert(Tagger.SecondToken)))
           	   	    {
           	   	    	    Tagger.token=true;
           	   	    	    Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FirstToken)+"<V>"+"  ");
									        Tagger.count1   ++;
									     		Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
									   			Tagger.count1   ++;
									  			Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<V>"+"  ]"+"<VP>"+"\n");
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
									  			break;
									   }
          	   }
			         if(Tagger.token==true);
			     	   else
         	     {
         	     	System.out.println("  else ven");
		 	   	      checknp.checknp();
         	     }

         }//if1*/

		 /********Using kindru,kru,kkindru,kkru **********/
         else if(Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.kindru)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.kru)
          	 	  ||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.kkindru)||Tagger.bytemeth.isequal(Tagger.ThirdToken,Tagger.kkru))
         { // if1
              // for(int loop1=0; loop1<Tagger.str.length; loop1++)
          	  // {  // loop1
			        //Tagger.token1=true;
                   // if(Tagger.str[loop1].equals(tabconvert2.revert(Tagger.SecondToken)))
           	   	    {  //if2
           	   	        if(Tagger.token==true)
                  	    {
							Tagger.token1=false;
							Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FourthToken)+"<V>"+"  ");
							Tagger.count1   ++;
							Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
							Tagger.count1   ++;
							Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<V>"+"  ]"+"<VPh>"+"\n");
							Tagger.count1   ++;
							Tagger.FirstToken=Tagger.ThirdToken;
							Tagger.nexttoken=Tagger.stringtoken.nextToken();
							(Tagger.count)++;
							Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
							Tagger.nexttoken=Tagger.stringtoken.nextToken();
							(Tagger.count)++;
							Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
							Tagger.token=false;
						//	break;
						}
						else
						{
							Tagger.token1=false;
							Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FirstToken)+"<V>"+"  ");
							Tagger.count1   ++;
							Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
							Tagger.count1   ++;
							Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<V>"+"  ]"+"<VPh>"+"  ");
							Tagger.count1   ++;
							Tagger.FirstToken=Tagger.ThirdToken;
							Tagger.nexttoken=Tagger.stringtoken.nextToken();
							(Tagger.count)++;
							Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
							Tagger.nexttoken=Tagger.stringtoken.nextToken();
							(Tagger.count)++;
							Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						//	break;
						}//if 2
           	   	    }
          	   //}
               //if(Tagger.token1==false);
			  // else
         	   //{
				    //checkadv  method used to Check Adverb
		 	        checkadv.checkadv();
         	  // }
		}//if1

        //using PNG marker
        /*else if(Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.een)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.oom)
	    		 	 ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.eer)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.aan)
					   ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.aar))
        {
        	System.out.println("tok   ="+tabconvert2.revert(Tagger.ThirdToken));
        	Tagger.sublength=Tagger.bytemeth.subarray(Tagger.ThirdToken,Tagger.ThirdToken.length-2,Tagger.ThirdToken.length);
		      Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.ThirdToken,0,(Tagger.ThirdToken.length-2));
     			if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.n)/*||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.yh)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)
		         ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)
		         ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.p)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.v))
			    {
			    	 // if1
          	   System.out.println(" t3 png ok");
               for(int loop1=0; loop1<Tagger.str.length; loop1++)
          	   {  // loop1
          	   	    if(Tagger.str[loop1].equals(tabconvert2.revert(Tagger.SecondToken)))
           	   	    {
           	   	    	    // if1
           	   	    	    Tagger.token=true;
					          	    Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FirstToken)+"<V>"+"  ");
									        Tagger.count1   ++;
									     		Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
									   			Tagger.count1   ++;
									  			Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<V>"+"  ]"+"<VP>"+"\n");
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
									  			break;
									   }
									   //	break;
          	   }
		           if(Tagger.token==true);
			     	   else
         	     {
         	     	System.out.println("  else png");
		 	   	      checknp.checknp();
         	     }
			    }//if1
   	      else
			   	{
				  	    System.out.println("  else tense in pngmarker");
				   	    checknp.checknp();
				  }
        }

        //Using PNG marker
        else if(Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.atu)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.ana)
        	   ||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.kal))
        {
        	Tagger.sublength=Tagger.bytemeth.subarray(Tagger.ThirdToken,Tagger.ThirdToken.length-3,Tagger.ThirdToken.length);
		      Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.ThirdToken,0,(Tagger.ThirdToken.length-3));
     			if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.n)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.yh)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)
		         ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)
		         ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.p)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.v))
			    {
			    	    // if1
          	   System.out.println(" t3  png1 ok");
               for(int loop1=0; loop1<Tagger.str.length; loop1++)
          	   {  // loop1
                 	  if(Tagger.str[loop1].equals(tabconvert2.revert(Tagger.SecondToken)))
           	   	    {
           	   	    	    Tagger.token=true;
  	   	    	   	   	    // if1
					          	    Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FirstToken)+"<V>"+"  ");
									        Tagger.count1   ++;
									     		Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
									   			Tagger.count1   ++;
									  			Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<V>"+"  ]"+"<VP>"+"\n");
									   			Tagger.count1   ++;
									        Tagger.FirstToken=Tagger.ThirdToken;
									  			Tagger.nexttoken=Tagger.stringtoken.nextToken();
									  			(Tagger.count)++;
									  			System.out.println("count1   " +Tagger.count1   );
									  			Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
									  			System.out.println("count" + Tagger.count);
									  			Tagger.nexttoken=Tagger.stringtoken.nextToken();
									  			(Tagger.count)++;
									  			Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
									  			System.out.println("count" + Tagger.count);
									  			break;
									   }
          	   }
		           if(Tagger.token==true);
			     	   else
         	     {
         	     	System.out.println("  else png1");
		 	   	      checknp.checknp();
         	     }
			    }//if1
			    else
			   	{
				  	    System.out.println("  else tense in png1 marker");
				   	    checknp.checknp();
				  }
        }

        //using PNG marker
        else if(Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.eerkal)||Tagger.bytemeth.endswith(Tagger.ThirdToken,Tagger.eerkal))
        {
        	Tagger.sublength=Tagger.bytemeth.subarray(Tagger.ThirdToken,Tagger.ThirdToken.length-5,Tagger.ThirdToken.length);
		      Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.ThirdToken,0,(Tagger.ThirdToken.length-5));
     			if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.n)/*||bytemeth.endswith(specifylength,nt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)
		         ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)
		         ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.p)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.v))
			    {
			    	    // if1
          	   System.out.println(" t3 earkal ok");
               for(int loop1=0; loop1<Tagger.str.length; loop1++)
          	   {  // loop1
                 	  if(Tagger.str[loop1].equals(tabconvert2.revert(Tagger.SecondToken)))
           	   	    {
           	   	    	    Tagger.token=true;
  	   	    	   	   	     // if1
					          	    Tagger.textarea.append("  [ "+tabconvert2.revert(Tagger.FirstToken)+"<V>"+"  ");
									        Tagger.count1   ++;
									     		Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"  ");
									   			Tagger.count1   ++;
									  			Tagger.textarea.append(tabconvert2.revert(Tagger.ThirdToken)+"<V>"+"  ]"+"<VP>"+"\n");
									   			Tagger.count1   ++;
									        Tagger.FirstToken=Tagger.ThirdToken;
									  			Tagger.nexttoken=Tagger.stringtoken.nextToken();
									  			(Tagger.count)++;
									  			System.out.println("count1   " +Tagger.count1   );
									  			Tagger.SecondToken=tabconvert2.convert(Tagger.nexttoken);
									  			System.out.println("count" + Tagger.count);
									  			Tagger.nexttoken=Tagger.stringtoken.nextToken();
									  			(Tagger.count)++;
									  			Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
									  			System.out.println("count" + Tagger.count);
									  			break;
									   }
          	   }
		           if(Tagger.token==true);
			     	   else
         	     {
         	     	System.out.println("  else eerkal");
		 	   	      checknp.checknp();
         	     }
			   }//if1
			   else
			   {
				  	    System.out.println("  else tense in eerkal");
				   	    checknp.checknp();
				 }
        }*/

        else
        {
				//checkadv  method used to Check Adverb
 	       	    checkadv.checkadv();
        }
    }// end of first try
		catch(Exception e)
		{
		}
  } //end of checkverb
 }// end of class