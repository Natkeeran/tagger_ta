/******  Checknounphase2 class  contains checkall and removekctp method
 it identifies Nounphrase from Standalone words, case markers, tense marker,Endpattern search and startpattern search also identify Noun,postposition,adverb,adjective and verb using morphological and heuristic rules

 Author 		:Dhinakaran .T
 Client 		:RCILTS
 Modify Date    :25.09.2002
 Anna University
 Copyright (c) 200
 ************************/

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.System;
import java.io.*;
import java.sql.*;

/******  Checknounphase2 class  contains checkall and removekctp method
 it identifies Nounphrase from Standalone words, case markers, tense marker,Endpattern search and startpattern search identifies Noun,postposition,adverb,adjective and verb using morphological and heuristic rules  **/
public class Checknounphrase2
{
	//Checkallnounphrase class used to check all noun phrases
	Checkallnounphrase checkall=new Checkallnounphrase();

	//Checkfullitem class used to check all items (ie noun,verb,adverb,adjective,particle....)
	//Checkfullitem checkfull=new Checkfullitem();

	//Removekkccttpp class is used to remove clitic 'kk' 'cc' 'tt' 'p'
	Removekkccttpp removekctp=new Removekkccttpp();

/*********************************** Default Constructor********************************/

	Checknounphrase2()
	{
	}

/***************************checknp2 method can identify Nounphrase from Standalone words, case markers, tense marker,Endpattern search and startpattern search also identify Noun,postposition,adverb,adjective and verb, all are using morphological and heuristic rules**********/

    public void checknp2()
    {
				System.out.println(" Calling checknp2");
/******* check SecondToken for month using isequal pattern search*********************************/

        if(Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.vaikasi)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.puratasi)
       	  ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.aani)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.aypasi)
       	  ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.aadi)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.margali)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.aavani)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.masi)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.panguni)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.jan)
       	  ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.feb)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.mar)
       	  ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.apr)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.may)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.jun)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.sep)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.aug)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.oct)
       	  ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.nov)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.dec))
        {
          		if(Tagger.token==true)
        	    {
         	              Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
			          	  Tagger.count1++;
			         	  Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
			         	  Tagger.count1++;
			              Tagger.FirstToken=Tagger.SecondToken;
			              Tagger.SecondToken=Tagger.ThirdToken;
			              if(Tagger.stringtoken.hasMoreTokens())
			              {
				              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
				                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								 Tagger.count++;
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
		        	 Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
		          	 Tagger.count1++;
	         		 Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
		         	 Tagger.count1++;
		             Tagger.FirstToken=Tagger.SecondToken;
		             Tagger.SecondToken=Tagger.ThirdToken;
		             if(Tagger.stringtoken.hasMoreTokens())
		             {
			              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
			                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
							 Tagger.count++;
		             }
		             else
		             {
		              	 Tagger.FirstToken=Tagger.ThirdToken;

		              	 //removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
		              	 removekctp.removekctp();
		             }
        	    }
        }

/***************check SecondToken in common word using isequal pattern search**************/

        else if(Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.nan)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.nam)
           ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.nangal)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.nee)
           ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.neever)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.neengal)
           ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.avan)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.aval)
           ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.athu)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.avai)
           ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.avaigal)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.avargal)
           ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.un)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.evan)
		   ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.evai)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.evargal)
		   ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.en)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.engal)
		   ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.nm)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.thm)
		   ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.em)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.evaigal)
		   ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.thn)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.yathu)
		   ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.yavan)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.yavar)
		   ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.tham)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.aanku)
		   ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.aanru))
	  {
          		if(Tagger.token==true)
        	    {
         	              Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
			          	  Tagger.count1++;
			         	  Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
			         	  Tagger.count1++;
			              Tagger.FirstToken=Tagger.SecondToken;
			              Tagger.SecondToken=Tagger.ThirdToken;
			              if(Tagger.stringtoken.hasMoreTokens())
			              {
				              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
				                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								 Tagger.count++;
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
		        	  Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
		          	  Tagger.count1++;
		         	  Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
		         	  Tagger.count1++;
		              Tagger.FirstToken=Tagger.SecondToken;
		              Tagger.SecondToken=Tagger.ThirdToken;
		              if(Tagger.stringtoken.hasMoreTokens())
		              {
		              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
		                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						 Tagger.count++;
		              }
		              else
		              {
		              	 Tagger.FirstToken=Tagger.ThirdToken;

		              	 //removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
		              	  removekctp.removekctp();
		             	}
        	    }
        }

/************* check SecondToken in Adverb using end pattern search ***************************/
        else if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.yanru)//||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aanku)
       	  ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.enku)//||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aanru)
       	  ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.netru)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.entru)
          ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.yanku)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aammal)
		  ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aammal1))
        {
        	    if(Tagger.token==true)
        	    {
         	          Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
			          Tagger.count1++;
			          Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<ADV>"+"   ");
			          Tagger.count1++;
			          Tagger.FirstToken=Tagger.SecondToken;
			          Tagger.SecondToken=Tagger.ThirdToken;
			          if(Tagger.stringtoken.hasMoreTokens())
			          {
				             	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
				                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								 Tagger.count++;
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
		        	    Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
		          		Tagger.count1++;
	         			Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<ADV>"+"   ");
	         			Tagger.count1++;
		                Tagger.FirstToken=Tagger.SecondToken;
		                Tagger.SecondToken=Tagger.ThirdToken;
		                if(Tagger.stringtoken.hasMoreTokens())
		                {
		              	  Tagger.nexttoken=Tagger.stringtoken.nextToken();
		                  Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						  Tagger.count++;
		                }
		                else
		                {
		              	   Tagger.FirstToken=Tagger.ThirdToken;

		              	   //removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
		              	   removekctp.removekctp();
		             	}
        	    }
        }

/********check SecondToken in postpositions using isequal pattern search************/

        else if(Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.mathiri)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.oty)
       	  /*||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.kurithu)*/||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.kondu)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.cutri)//||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.thavirthu)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.thandi)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.patri)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.vithu)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.noki)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.thavira)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.oliya)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.pola)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.vita)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.vitu)//||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.parthu)
		  ||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.pol)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.pol))
       {
           	  if(Tagger.token==true)
        	    {
             	          Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
			          	  Tagger.count1++;
			         	  Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<PP>"+"   ");
			         	  Tagger.count1++;
			              Tagger.FirstToken=Tagger.SecondToken;
			              Tagger.SecondToken=Tagger.ThirdToken;
			              if(Tagger.stringtoken.hasMoreTokens())
			              {
				              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
				                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								 Tagger.count++;
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
			       	     Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
			          	 Tagger.count1++;
			      		 Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<PP>"+"   ");
			         	 Tagger.count1++;
			             Tagger.FirstToken=Tagger.SecondToken;
			             Tagger.SecondToken=Tagger.ThirdToken;
			             if(Tagger.stringtoken.hasMoreTokens())
			             {
			               Tagger.nexttoken=Tagger.stringtoken.nextToken();
			               Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						   Tagger.count++;
			             }
			             else
			             {
			              	Tagger.FirstToken=	Tagger.ThirdToken;

			              	//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
			              	removekctp.removekctp();
			             }
       	       }
       }

/**********check SecondToken in postpositions using isequal pattern search***************/

       else if(Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.mun)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.mal)
       	  ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.markku)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.vatakku)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.athir)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.kurukku)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.vali)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.etai)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.etayal)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.natu)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.natuvil)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.pinthi)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.munthi)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.uul)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.appol)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.kilakku)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.kil)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.tharkku)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.pin)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.piraku)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.valiyal))
       {
           	  if(Tagger.token==true)
        	  {
         	          Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
    	          	  Tagger.count1++;
			          Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<PP>"+"   ");
			          Tagger.count1++;
			          Tagger.FirstToken=Tagger.SecondToken;
			          Tagger.SecondToken=Tagger.ThirdToken;
			          if(Tagger.stringtoken.hasMoreTokens())
			          {
				              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
				                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								 Tagger.count++;
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
			       	     Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
			          	 Tagger.count1++;
			      		 Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<PP>"+"   ");
			         	 Tagger.count1++;
			             Tagger.FirstToken=Tagger.SecondToken;
			             Tagger.SecondToken=Tagger.ThirdToken;
			             if(Tagger.stringtoken.hasMoreTokens())
			             {
			               Tagger.nexttoken=Tagger.stringtoken.nextToken();
			               Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						   Tagger.count++;
			             }
			             else
			             {
			              	Tagger.FirstToken=	Tagger.ThirdToken;

			              	//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
			              	removekctp.removekctp();
			             }
       	       }
       }

/*************check SecondToken in postpositions using isequal pattern search***************/

       else if(Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.mulam)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.varai)
       	  ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.andai)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.aruku)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.aatan)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.kitta)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.kilza)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.pakkam)
          /*||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.padi)*/||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.illamal)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.allamal))
       {
           	    if(Tagger.token==true)
        	    {
            	          Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
			          	  Tagger.count1++;
			         	  Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<PP>"+"   ");
			         	  Tagger.count1++;
			              Tagger.FirstToken=Tagger.SecondToken;
			              Tagger.SecondToken=Tagger.ThirdToken;
			              if(Tagger.stringtoken.hasMoreTokens())
			              {
				              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
				                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								 Tagger.count++;
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
			       	     Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
			          	 Tagger.count1++;
			      		 Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<PP>"+"   ");
			         	 Tagger.count1++;
			             Tagger.FirstToken=Tagger.SecondToken;
			             Tagger.SecondToken=Tagger.ThirdToken;
			             if(Tagger.stringtoken.hasMoreTokens())
			             {
			               Tagger.nexttoken=Tagger.stringtoken.nextToken();
			               Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						   Tagger.count++;
			             }
			             else
			             {
			              	Tagger.FirstToken=	Tagger.ThirdToken;

			              	//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
			              	removekctp.removekctp();
			             }
       	      }
       }

/**********check SecondToken in standalone verb using end pattern search*********/

       else if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.ellai)||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.ellai)
     	    ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aathu)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aavital)
     	    ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aathirkal)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aatha)
     	    ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.ungal)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.vendum)
     	    ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.vendam)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.thondrum)
     	    ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.kudum)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.kutathu))
  	   {
  	   	        if(Tagger.token==true)
        	    {
            	          Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
			          	  Tagger.count1++;
			         	  Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+"   ");
			         	  Tagger.count1++;
			              Tagger.FirstToken=Tagger.SecondToken;
			              Tagger.SecondToken=Tagger.ThirdToken;
			              if(Tagger.stringtoken.hasMoreTokens())
			              {
				              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
				                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								 Tagger.count++;
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
			       	     Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
			          	 Tagger.count1++;
			      		 Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+"   ");
			         	 Tagger.count1++;
			             Tagger.FirstToken=Tagger.SecondToken;
			             Tagger.SecondToken=Tagger.ThirdToken;
			             if(Tagger.stringtoken.hasMoreTokens())
			             {
			               Tagger.nexttoken=Tagger.stringtoken.nextToken();
			               Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						   Tagger.count++;
			             }
			             else
			             {
			              	Tagger.FirstToken=	Tagger.ThirdToken;

			              	//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
			              	removekctp.removekctp();
			             }
       	      }
       }

/**********check SecondToken in standalone  with fullstop verb using end pattern search***********/

       else if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.ellai1)//||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aammal1)
     	    ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aathu1)//||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aavital)
     	    ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aathirkal1)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aatha1)
     	    ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.ungal1)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.vendum1)
     	    ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.vendam1)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.thondrum1)
     	    ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.kudum1)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.kutathu1))
  	   {
  	   	        if(Tagger.token==true)
        	    {
            	          Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
			          	  Tagger.count1++;
			         	  Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+"   ");
			         	  Tagger.count1++;
			              Tagger.FirstToken=Tagger.SecondToken;
			              Tagger.SecondToken=Tagger.ThirdToken;
			              if(Tagger.stringtoken.hasMoreTokens())
			              {
				              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
				                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								 Tagger.count++;
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
			       	     Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
			          	 Tagger.count1++;
			      		 Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+"   ");
			         	 Tagger.count1++;
			             Tagger.FirstToken=Tagger.SecondToken;
			             Tagger.SecondToken=Tagger.ThirdToken;
			             if(Tagger.stringtoken.hasMoreTokens())
			             {
			               Tagger.nexttoken=Tagger.stringtoken.nextToken();
			               Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						   Tagger.count++;
			             }
			             else
			             {
			              	Tagger.FirstToken=	Tagger.ThirdToken;

			              	//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
			              	removekctp.removekctp();
			             }
       	      }
       }

/****************check SecondToken in nouns using end pattern search************************/

       else if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.ai))
	    {
   	      	  if(Tagger.token==true)
        	  {
         	              Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
			          	  Tagger.count1++;
			         	  Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
			         	  Tagger.count1++;
			         	  System.out.println("count1   " +Tagger.count1   );
			              Tagger.FirstToken=Tagger.SecondToken;
			              Tagger.SecondToken=Tagger.ThirdToken;
			              if(Tagger.stringtoken.hasMoreTokens())
			              {
				              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
				                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								 Tagger.count++;
				                 System.out.println("count   " +Tagger.count   );
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
					     	Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
				         	Tagger.count1++;
				           	Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
				         	Tagger.count1++;
				         	System.out.println("count1   " +Tagger.count1   );
				            Tagger.FirstToken=Tagger.SecondToken;
				            Tagger.SecondToken=Tagger.ThirdToken;
				            if(Tagger.stringtoken.hasMoreTokens())
				            {
				               Tagger.nexttoken=Tagger.stringtoken.nextToken();
				               Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
							   Tagger.count++;
				               System.out.println("count   " +Tagger.count   );
				            }
				            else
				            {
				             	 Tagger.FirstToken=Tagger.ThirdToken;

				             	 //removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
				             	 removekctp.removekctp();
				            }
	     	  }
    }
/*****check SecondToken in verbs using case marker end pattern search*****************/

    else if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.eerkal)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aarkal))	  {
	      Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.SecondToken,0,(Tagger.SecondToken.length-5));

		  /*****************************tense marker**********************************/

	      if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.yh)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.n)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.p)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.v)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.pp)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.in)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nnt)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kindru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkindru)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkru))
	      {
		    		  if(Tagger.token==true)
                	  {
         	              Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
			          	  Tagger.count1++;
			         	  Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+"   ");
			         	  Tagger.count1++;
			              Tagger.FirstToken=Tagger.SecondToken;
			              Tagger.SecondToken=Tagger.ThirdToken;
			              if(Tagger.stringtoken.hasMoreTokens())
			              {
				              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
				                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								 Tagger.count++;
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
				 		 Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
		          		 Tagger.count1++;
		      			 Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+"   ");
		      			 Tagger.count1++;
				         Tagger.FirstToken=Tagger.SecondToken;
		                 Tagger.SecondToken=Tagger.ThirdToken;
		                 if(Tagger.stringtoken.hasMoreTokens())
		                 {
		              	    Tagger.nexttoken=Tagger.stringtoken.nextToken();
		                 	Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
							Tagger.count++;
		                 }
		               	 else
		                 {
		              	 	Tagger.FirstToken=Tagger.ThirdToken;

		              	 	//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
		              	 	removekctp.removekctp();
    		             }
		        }
           }
           else
           {
	           	if(Tagger.token==true)
        	    {
         	              Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
			          	  Tagger.count1++;
			         	  Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
			         	  Tagger.count1++;
			              Tagger.FirstToken=Tagger.SecondToken;
			              Tagger.SecondToken=Tagger.ThirdToken;
			              if(Tagger.stringtoken.hasMoreTokens())
			              {
				              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
				                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								 Tagger.count++;
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
		           	    Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
			          	Tagger.count1++;
			     		Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
			       		Tagger.FirstToken=Tagger.SecondToken;
			            Tagger.SecondToken=Tagger.ThirdToken;
			            if(Tagger.stringtoken.hasMoreTokens())
			            {
			               Tagger.nexttoken=Tagger.stringtoken.nextToken();
			               Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						   Tagger.count++;
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
/***********check SecondToken in verbs using case marker with fullstop end pattern search**************/

    else if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.eerkal1)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aarkal1))	  {
	      Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.SecondToken,0,(Tagger.SecondToken.length-7));

		  /*************************************tense marker***********************/

	      if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.yh)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.n)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.p)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.v)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.pp)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.in)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nnt)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kindru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkindru)
	       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkru))
	      {
		    		  if(Tagger.token==true)
                	  {
         	              Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
			          	  Tagger.count1++;
			         	  Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+"   ");
			         	  Tagger.count1++;
			              Tagger.FirstToken=Tagger.SecondToken;
			              Tagger.SecondToken=Tagger.ThirdToken;
			              if(Tagger.stringtoken.hasMoreTokens())
			              {
				              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
				                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								 Tagger.count++;
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
				 		 Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
		          		 Tagger.count1++;
		      			 Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+"   ");
		      			 Tagger.count1++;
				         Tagger.FirstToken=Tagger.SecondToken;
		                 Tagger.SecondToken=Tagger.ThirdToken;
		                 if(Tagger.stringtoken.hasMoreTokens())
		                 {
		              	    Tagger.nexttoken=Tagger.stringtoken.nextToken();
		                 	Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
							Tagger.count++;
		                 }
		               	 else
		                 {
		              	 	Tagger.FirstToken=Tagger.ThirdToken;

		              	 	//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
		              	 	removekctp.removekctp();
    		             }
		        }
           }
           else
           {
	           	if(Tagger.token==true)
        	    {
         	              Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
			          	  Tagger.count1++;
			         	  Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
			         	  Tagger.count1++;
			              Tagger.FirstToken=Tagger.SecondToken;
			              Tagger.SecondToken=Tagger.ThirdToken;
			              if(Tagger.stringtoken.hasMoreTokens())
			              {
				              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
				                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								 Tagger.count++;
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
		           	    Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
			          	Tagger.count1++;
			     		Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
			       		Tagger.FirstToken=Tagger.SecondToken;
			            Tagger.SecondToken=Tagger.ThirdToken;
			            if(Tagger.stringtoken.hasMoreTokens())
			            {
			               Tagger.nexttoken=Tagger.stringtoken.nextToken();
			               Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						   Tagger.count++;
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
/***********check SecondToken in verbs using case marker end pattern search********************/

    else if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.atu)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.ana)
         ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.kal)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.than))
    {

	   if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.vayathu))
       {
		 //checkall method used to check all noun phases
	 	 checkall.checkall();
       }
	   else
	   {
		  Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.SecondToken,0,(Tagger.SecondToken.length-3));

		  /************************************tense marker***************************/

	      if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.thh)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.ei)
		   	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)
		   	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.p)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.v)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.pp)
		   	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.in)
		   	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nnt)
		   	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kindru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkindru)
		   	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkru))
		  {
		    	 if(Tagger.token==true)
        		 {
         	         	  Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
			          	  Tagger.count1++;
			         	  Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+"   ");
			         	  Tagger.count1++;
			              Tagger.FirstToken=Tagger.SecondToken;
			              Tagger.SecondToken=Tagger.ThirdToken;
			              if(Tagger.stringtoken.hasMoreTokens())
			              {
				              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
				                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								 Tagger.count++;
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
				    	 Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
		          		 Tagger.count1++;
		      			 Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+"   ");
		      			 Tagger.count1++;
				         Tagger.FirstToken=Tagger.SecondToken;
		                 Tagger.SecondToken=Tagger.ThirdToken;
		                 if(Tagger.stringtoken.hasMoreTokens())
		                 {
		              	 	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
			                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
							 Tagger.count++;
		                 }
		                 else
		                 {
		              	 	Tagger.FirstToken=Tagger.ThirdToken;

		              	 	//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
		              	    removekctp.removekctp();
		                 }
		    	}
           }
           else
           {
	           	if(Tagger.token==true)
        	    {
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.count++;
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
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
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
    }
/*********check SecondToken in verbs using case marker with fullstop end pattern search******************/

    else if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.atu1)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.ana1)
         ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.kal1)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.than1))
    {

	   if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.vayathu1))
       {
		 //checkall method used to check all noun phases
	 	 checkall.checkall();
       }
	   else
	   {
		  Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.SecondToken,0,(Tagger.SecondToken.length-5));

		  /****************************************tense marker**********************/

	      if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.thh)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.ei)
		   	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)
		   	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.p)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.v)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.pp)
		   	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.in)
		   	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nnt)
		   	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kindru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkindru)
		   	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkru))
		  {
		    	 if(Tagger.token==true)
        		 {
         	         	  Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
			          	  Tagger.count1++;
			         	  Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+"   ");
			         	  Tagger.count1++;
			              Tagger.FirstToken=Tagger.SecondToken;
			              Tagger.SecondToken=Tagger.ThirdToken;
			              if(Tagger.stringtoken.hasMoreTokens())
			              {
				              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
				                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								 Tagger.count++;
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
				    	 Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
		          		 Tagger.count1++;
		      			 Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+"   ");
		      			 Tagger.count1++;
				         Tagger.FirstToken=Tagger.SecondToken;
		                 Tagger.SecondToken=Tagger.ThirdToken;
		                 if(Tagger.stringtoken.hasMoreTokens())
		                 {
		              	 	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
			                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
							 Tagger.count++;
		                 }
		                 else
		                 {
		              	 	Tagger.FirstToken=Tagger.ThirdToken;

		              	 	//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
		              	    removekctp.removekctp();
		                 }
		    	}
           }
           else
           {
	           	if(Tagger.token==true)
        	    {
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.count++;
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
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
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
    }

/******check SecondToken in verbs using 'eiumm' end pattern search************************/

    else if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.eiumm))
   	{
		      Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.SecondToken,0,(Tagger.SecondToken.length-3));

			  /***************************************tense marker********************/

		      if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.ei)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kk)
		       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)
		       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.p)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.v)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.pp)
		       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.in)
		       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nnt)
		       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kindru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkindru)
		       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkru))
		      {
		           if(Tagger.token==true)
        	     {
         	          	  Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
			          	  Tagger.count1++;
			         	  Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+"   ");
			         	  Tagger.count1++;
			              Tagger.FirstToken=Tagger.SecondToken;
			              Tagger.SecondToken=Tagger.ThirdToken;
			              if(Tagger.stringtoken.hasMoreTokens())
			              {
				              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
				                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								 Tagger.count++;
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
				   	 Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
		        	 Tagger.count1++;
		      		 Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+"   ");
		      		 Tagger.count1++;
				     Tagger.FirstToken=Tagger.SecondToken;
		             Tagger.SecondToken=Tagger.ThirdToken;
		             if(Tagger.stringtoken.hasMoreTokens())
		             {
		              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
		                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						 Tagger.count++;
		               }
		               else
		               {
		              	 Tagger.FirstToken=Tagger.ThirdToken;

		              	 //removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
		              	 removekctp.removekctp();
		               }
		    		   }
           }
           else
           {
	           	if(Tagger.token==true)
        	    {
         	              Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
			          	  Tagger.count1++;
			         	  Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
			         	  Tagger.count1++;
			              Tagger.FirstToken=Tagger.SecondToken;
			              Tagger.SecondToken=Tagger.ThirdToken;
			              if(Tagger.stringtoken.hasMoreTokens())
			              {
				              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
				                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								 Tagger.count++;
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
		          	  Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
			          Tagger.count1++;
			     	  Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
			       	  Tagger.FirstToken=Tagger.SecondToken;
			          Tagger.SecondToken=Tagger.ThirdToken;
			          if(Tagger.stringtoken.hasMoreTokens())
			          {
			               Tagger.nexttoken=Tagger.stringtoken.nextToken();
			               Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						   Tagger.count++;
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
/********check SecondToken in verbs using PNG marker end pattern search******************/

    else if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.een)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.oom)
		 ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.eer)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aan)
		 ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aal)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aar)
		 ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aay))
    {
			Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.SecondToken,0,(Tagger.SecondToken.length-2));

			/*********************************************tense marker*****************/

			if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.yh)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.n)
		       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)
		       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.p)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.v)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.pp)
		       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.in)
		       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nnt)
		       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kindru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkindru)
		       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkru))
		    {
		         if(Tagger.token==true)
        	     {
         	              Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
			          	  Tagger.count1++;
			         	  Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+"   ");
			         	  Tagger.count1++;
			              Tagger.FirstToken=Tagger.SecondToken;
			              Tagger.SecondToken=Tagger.ThirdToken;
			              if(Tagger.stringtoken.hasMoreTokens())
			              {
				              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
				                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								 Tagger.count++;
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
				    		Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
		          		 	Tagger.count1++;
		      				Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+"   ");
		      				Tagger.count1++;
				        	Tagger.FirstToken=Tagger.SecondToken;
			                Tagger.SecondToken=Tagger.ThirdToken;
  			                if(Tagger.stringtoken.hasMoreTokens())
	   		                {
				              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
				                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								 Tagger.count++;
				             }
				             else
				             {
				              	 Tagger.FirstToken=Tagger.ThirdToken;

				              	 //removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
				              	 removekctp.removekctp();
				             }
		    		   }
           }
           else
           {
	           	if(Tagger.token==true)
        	    {
						Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
						Tagger.count1++;
						Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
						Tagger.count1++;
						Tagger.FirstToken=Tagger.SecondToken;
						Tagger.SecondToken=Tagger.ThirdToken;
						if(Tagger.stringtoken.hasMoreTokens())
						{
							Tagger.nexttoken=Tagger.stringtoken.nextToken();
							Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
							Tagger.count++;
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
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
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
/****check SecondToken in verbs using PNG marker end pattern search************************/

    else if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.een1)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.oom1)
		 ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.eer1)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aan1)
		 ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aal1)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aar1)
		 ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aay1))
    {
			Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.SecondToken,0,(Tagger.SecondToken.length-4));

			/*********************************************tense marker*****************/

			if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.yh)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.n)
		       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)
		       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.p)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.v)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.pp)
		       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.in)
		       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nnt)
		       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kindru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkindru)
		       	||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkru))
		    {
		         if(Tagger.token==true)
        	     {
         	              Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
			          	  Tagger.count1++;
			         	  Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+"   ");
			         	  Tagger.count1++;
			              Tagger.FirstToken=Tagger.SecondToken;
			              Tagger.SecondToken=Tagger.ThirdToken;
			              if(Tagger.stringtoken.hasMoreTokens())
			              {
				              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
				                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								 Tagger.count++;
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
				    		Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
		          		 	Tagger.count1++;
		      				Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+"   ");
		      				Tagger.count1++;
				        	Tagger.FirstToken=Tagger.SecondToken;
			                Tagger.SecondToken=Tagger.ThirdToken;
  			                if(Tagger.stringtoken.hasMoreTokens())
	   		                {
				              	 Tagger.nexttoken=Tagger.stringtoken.nextToken();
				                 Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
								 Tagger.count++;
				             }
				             else
				             {
				              	 Tagger.FirstToken=Tagger.ThirdToken;

				              	 //removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
				              	 removekctp.removekctp();
				             }
		    		   }
           }
           else
           {
	           	if(Tagger.token==true)
        	    {
						Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
						Tagger.count1++;
						Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
						Tagger.count1++;
						Tagger.FirstToken=Tagger.SecondToken;
						Tagger.SecondToken=Tagger.ThirdToken;
						if(Tagger.stringtoken.hasMoreTokens())
						{
							Tagger.nexttoken=Tagger.stringtoken.nextToken();
							Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
							Tagger.count++;
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
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
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

/**********check SecondToken in nouns using week end pattern search************************/

	  else if(Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.thingal)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.shani)
       	  ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.chavvai)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.nayaru)
       	  ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.puthan)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.varam)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.viyazhan)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.matham)
          ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.velli)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.aandu))
      {
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
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
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
					}
					else
					{
						Tagger.FirstToken=Tagger.ThirdToken;

						//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
						removekctp.removekctp();
					}
        	    }
      }
/********check SecondToken in nouns using numerals and letters starting search************************/

      else if(Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.a0)||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.a1)
       	  ||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.a2)||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.a3)
       	  ||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.a4)||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.a5)
          ||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.a6)||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.a7)
          ||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.a8)||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.a9)
          ||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.a00)||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.a01)
          ||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.a02)||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.a03)
          ||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.a04)||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.a05)
          ||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.a06)||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.a07)
          ||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.a08)||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.a09)
          ||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.a00))
      {
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
				Tagger.count1++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
				Tagger.count1++;
				Tagger.FirstToken=Tagger.SecondToken;
				Tagger.SecondToken=Tagger.ThirdToken;
				if(Tagger.stringtoken.hasMoreTokens())
				{
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.count++;
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
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
				Tagger.count1++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
				Tagger.count1++;
				Tagger.FirstToken=Tagger.SecondToken;
				Tagger.SecondToken=Tagger.ThirdToken;
				if(Tagger.stringtoken.hasMoreTokens())
				{
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.count++;
				}
				else
				{
					Tagger.FirstToken=Tagger.ThirdToken;

					//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
					removekctp.removekctp();
				}
			}
      }

/********check SecondToken in nouns using numbers end pattern search************************/

      else if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.oor)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.ten)
			||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.eru)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.four)
			||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.five)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.six)
			||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.seven)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.eight)
			||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.nine)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.two)
			||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.hunrd)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.lagsh)
			||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.thosn)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.crore)
			||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.one)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.three)
			||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.ten)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.muthal)
			||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.kadaisi)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.hunrd1)
			||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.four1)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.six1)
			||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.six3))
	  {
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<ADJ>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
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
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<ADJ>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
					}
					else
					{
						Tagger.FirstToken=Tagger.ThirdToken;

						//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
						removekctp.removekctp();
					}
				}
     }

/*******check SecondToken in nouns using numbers end pattern search************************/

	 else if(Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.oor)||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.ten)
		  /*||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.eru)*/||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.four)
		  ||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.five)||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.six)
		  ||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.seven)||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.eight)
		  ||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.nine)||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.two)
		  ||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.hunrd)||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.lagsh)
		  ||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.thosn)||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.crore)
		  ||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.one)||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.three)
		  ||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.ten)||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.muthal)
		  ||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.kadaisi)||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.hunrd1)
		  ||Tagger.bytemeth.startswith(Tagger.SecondToken,Tagger.four1))
	 {
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
				Tagger.count1++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<ADJ>"+"   ");
				Tagger.count1++;
				Tagger.FirstToken=Tagger.SecondToken;
				Tagger.SecondToken=Tagger.ThirdToken;
				if(Tagger.stringtoken.hasMoreTokens())
				{
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.count++;
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
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
				Tagger.count1++;
				Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<ADJ>"+"   ");
				Tagger.count1++;
				Tagger.FirstToken=Tagger.SecondToken;
				Tagger.SecondToken=Tagger.ThirdToken;
				if(Tagger.stringtoken.hasMoreTokens())
				{
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.count++;
				}
				else
				{
					Tagger.FirstToken=Tagger.ThirdToken;

					//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
					removekctp.removekctp();
				}
			}
     }
/*********check SecondToken in nouns using case marker end pattern search************************/

     else if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.ukku)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.akku)
     	  ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.kku)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.erkku))
     {
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
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
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
					}
					else
					{
						Tagger.FirstToken=Tagger.ThirdToken;

						//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
						removekctp.removekctp();
					}
     	        }
       }

/************************************check in pronouns************************************
     else if(Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.en)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.un)
     	||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.thn)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.nm))
     {
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<PN>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
					Tagger.count1++;
					System.out.println("count1   " +Tagger.count1   );
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
						System.out.println("count   " +Tagger.count   );
					}
					else
					{
						Tagger.FirstToken=Tagger.ThirdToken;
						removekctp.removekctp();
					}
					Tagger.token=false;
				}
        	    else
     	        {
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<PN>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
					Tagger.count1++;
					System.out.println("count1   " +Tagger.count1   );
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
						System.out.println("count   " +Tagger.count   );
					}
					else
					{
						Tagger.FirstToken=Tagger.ThirdToken;
						removekctp.removekctp();
					}
     	        }
       }*/
/****check SecondToken in adverb using standalone words isequal pattern search************************/

       else if(Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.appola)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.uula)
       	    ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.kilakka)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.kila)
       		||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.tharkka)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.pina)
       		||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.piraka)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.muna)
        	||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.mala)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.markka)
        	||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.vatakka)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.athira)
           	||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.kurukka)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.valiya)
           	||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.etaya)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.natuva)
			||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.udana))
  	  {
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<ADV>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
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
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<ADV>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
					}
					else
					{
						Tagger.FirstToken=Tagger.ThirdToken;

						//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
						removekctp.removekctp();
					}
				}
      }
/*****check SecondToken in Demoanstrate pronoun using standalone words isequal pattern search************/

  	  else if(Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.entha)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.antha)
  	 	   ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.yantha))
      {
            	if(Tagger.token==true)
        	    {
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
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
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
					}
					else
					{
						Tagger.FirstToken=Tagger.ThirdToken;

						//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
						removekctp.removekctp();
					}
				}
      }
/***********check SecondToken in adjectives using standalone words end pattern search**************/

      else if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aana)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.oru)
	       ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.yalla)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.palya)
		    ||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.puthiya)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.yellow)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.black)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.paluppu)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.red1)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.red)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.blue)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.white)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.vilat)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.white1)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.orange)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.kavi)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.gray)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.green)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.alakya)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.parya)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.chirya)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.natiya)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.inniya)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.puthiyathu)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.alakyathu)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.paryathu)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.chiryathu)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.natiyathu)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.inniyathu)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.palyathu)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.oonki)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.oonkiya)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.oonkiyathu)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.pala)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.cila)/*||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.aay)*/
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.uyartha)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.thalntha)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.yaliya)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.miga)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.chinna)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.chiru)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.perum)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.peru))
	  {
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<ADJ>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
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
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<ADJ>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
					}
					else
					{
						Tagger.FirstToken=Tagger.ThirdToken;

						//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
						removekctp.removekctp();
					}
				}
     }
/*****************check SecondToken in adverb using end pattern search************/

     else if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aka)/*||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.pondra)
          ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.pola)*/)
	 {
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<ADV>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
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
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<ADV>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.count++;
					}
					else
					{
					Tagger.FirstToken=Tagger.ThirdToken;

					//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
					removekctp.removekctp();
					}
	   	        }
     }
/********check SecondToken in adverb using standalone words isequal pattern search******************/

     else if(Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.adikadi)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.enimel)
    	  ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.ennum)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.marupadium)
    	  ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.meendum)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.meela)
    	  ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.appothu)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.appoluthu)
    	  ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.eppothu)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.eppoluthu)
    	  ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.yavvalavu)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.evvalavu)
    	  ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.sumar)||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.arakuraiya)
    	  ||Tagger.bytemeth.isequal(Tagger.SecondToken,Tagger.arathala))
 	 {
 			    if(Tagger.token==true)
        	    {
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<ADV>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.count++;
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
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<ADV>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
					}
					else
					{
						Tagger.FirstToken=Tagger.ThirdToken;

						//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
						removekctp.removekctp();
					}
				}
    }
/**************check SecondToken in nouns using end pattern search************************/

    else if(Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.il)|| Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.ppu)
      	  ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.an)|| Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.itam)
      	  ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.udya)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.utan)
      	  ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.ul)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.in)
      	  ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.ar)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.al)
      	  ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.ilunthu)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.edamiruthu)
		  ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.amm)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.cchi)
		  ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aal)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aall1)
		  ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.aall)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.ar1)
		  ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.sss)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.ss)
		  ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.me)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.lee)
		  ||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.mmpu)||Tagger.bytemeth.endswith(Tagger.SecondToken,Tagger.amm1))
   	{
   			    if(Tagger.token==true)
        	    {
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
					Tagger.nexttoken=Tagger.stringtoken.nextToken();
					Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
					Tagger.count++;
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
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
					}
					else
					{
						Tagger.FirstToken=Tagger.ThirdToken;

						//removekctp method is used to remove clitic 'kk' 'cc' 'tt' 'p'
						removekctp.removekctp();
					}
   		        }
     }
/********check SecondToken in verb using tense marker end pattern search**********************

     else if(Tagger.bytemeth.isequal1(Tagger.SecondToken,Tagger.kindru)||Tagger.bytemeth.isequal1(Tagger.SecondToken,Tagger.kru)
     	  ||Tagger.bytemeth.isequal1(Tagger.SecondToken,Tagger.kkindru)||Tagger.bytemeth.isequal1(Tagger.SecondToken,Tagger.kkru))
     {
           	  if(Tagger.token==true)
        	  {
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
					}
					else
					{
						Tagger.FirstToken=Tagger.ThirdToken;
						removekctp.removekctp();
					}
					Tagger.token=false;
        	    }
        	    else
     	        {
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
					Tagger.count1++;
					Tagger.textarea.append(tabconvert2.revert(Tagger.SecondToken)+"<V>"+"   ");
					Tagger.count1++;
					Tagger.FirstToken=Tagger.SecondToken;
					Tagger.SecondToken=Tagger.ThirdToken;
					if(Tagger.stringtoken.hasMoreTokens())
					{
						Tagger.nexttoken=Tagger.stringtoken.nextToken();
						Tagger.ThirdToken=tabconvert2.convert(Tagger.nexttoken);
						Tagger.count++;
					}
					else
					{
						Tagger.FirstToken=Tagger.ThirdToken;
						removekctp.removekctp();
					}
     	        }
    }

/************************************last else part************************************/

    else
    {
		   //checkall method used to check all noun phases
           checkall.checkall();
    }
  }
 }