
/****** Checkfullitem class identifies Noun,verb,Adjective,Adverb,Verbal participle,Relative participle and Postposition from Standalone words, case markers, tense marker,Endpattern search,startpattern search and isequal search had been done using morphological and heuristic rules **************

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

/*************** This class identifies Noun,verb,Adjective,Adverb,Verbal participle,Relative participle and Postposition from Standalone words, case markers, tense marker,Endpattern search,startpattern search and isequal search had been done using morphological and heuristic rules***********/

public class Checkfullitem
{

/**************** default constructor *****************************************************/

	Checkfullitem()
	{
	}

/***************  Checkfull method identifies Noun,verb,Adjective,Adverb,Verbal participle,Relative participle and Postposition from Standalone words, case markers, tense marker,Endpattern search,startpattern search and isequal search,had been done using morphological and heuristic rules*******************/

	public void checkfull()
    {
		System.out.println(" Calling checkfull");
/************** check FirstToken in pronoun *************************************************/

	  if(Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.nan)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.nam)
	       ||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.nangal)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.nee)
           ||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.neever)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.neengal)
           ||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.avan)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.aval)
           ||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.athu)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.avai)
           ||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.avaigal)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.avargal)
           ||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.un)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.evan)
		   ||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.evai)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.evargal)
		   ||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.en)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.engal)
		   ||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.nm)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.thm)
		   ||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.em)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.evaigal)
		   ||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.thn)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.yathu)
		   ||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.yavan)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.yavar)
		   ||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.tham)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.aanku)
		   ||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.aanru))
	  {
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+" ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+" ");
				Tagger.count1   ++;
			}
		}

/************** check FirstToken in verb *************************************************/

		else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.ellai)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.ellai)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aathu)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aavital)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aathirkal)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aatha)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.ungal)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.vendum)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.vendam)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.kudum)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.thondrum)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.kutathu)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.ellai1)//||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aammal1)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aathu1)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aathirkal1)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aatha1)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.ungal1)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.vendum1)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.vendam1)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.kudum1)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.thondrum1)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.kutathu1))
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<V>"+" ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<V>"+" ");
				Tagger.count1   ++;
			}
		}

/************** check FirstToken in postposition *************************************************/

		else if(Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.mathiri)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.oty)//||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.kurithu)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.kondu)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.cutri)//||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.thavirthu)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.thandi)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.patri)//||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.parthu)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.vithu)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.noki)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.thavira)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.oliya)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.pola)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.vita)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.vitu)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.pol)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.pol))
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<PP>"+" ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<PP>"+" ");
				Tagger.count1   ++;
			}
		}

/************** check FirstToken in postposition *************************************************/

		else if(Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.appol)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.uul)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.kilakku)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.kil)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.tharkku)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.pin)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.piraku)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.mun)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.mal)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.markku)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.vatakku)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.athir)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.kurukku)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.vali)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.vali)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.etai)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.natu)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.natuvil)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.etayal)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.munthi)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.pinthi))
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<PP>"+" ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<PP>"+" ");
				Tagger.count1   ++;
			}
		}

/************** check FirstToken in postposition *************************************************/

		else if(Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.mulam)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.varai)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.andai)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.aruku)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.aatan)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.kitta)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.kilza)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.pakkam))
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<PP>"+" ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<PP>"+" ");
				Tagger.count1   ++;
			}
		}

/************** check FirstToken in noun (ie "ai") *************************************************/

		else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.ai))
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+" ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+" ");
				Tagger.count1   ++;
			}
		}

/************** check FirstToken in Adverb *************************************************/

		else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.yanru)//||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aanku)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.enku)//||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aanru)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.netru)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.entru)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.yanku)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aammal)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aammal1))
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<ADV>"+" ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<ADV>"+" ");
				Tagger.count1   ++;
			}
		}

/************** check FirstToken in Adjective *************************************************/

		else if(Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.palya)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.puthiya)
				||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.alakya)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.parya)
				||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.chirya)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.natiya)
				||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.inniya)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.puthiyathu)
				||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.alakyathu)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.paryathu)
				||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.chiryathu)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.natiyathu)
				||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.inniyathu)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.palyathu)
				||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.oonki)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.oonkiya)
				||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.oonkiyathu)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.pala)
				||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.cila)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.puthu)
				||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.uyartha)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.thalntha)
				||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.yaliya)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.perum)
				||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.peru)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.chinna)
				||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.chiru)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.miga))
			{
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<ADJ>"+" ");
					Tagger.token=false;
					Tagger.count1   ++;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<ADJ>"+" ");
					Tagger.count1   ++;
				}
			}

/************** check FirstToken in verb using PNG marker *****************************************/

		else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.eerkal)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aarkal))
		{
			Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.FirstToken,0,(Tagger.FirstToken.length-5));
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
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<V>"+" ");
					Tagger.token=false;
					Tagger.count1   ++;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<V>"+" ");
					Tagger.count1   ++;
				}
			}
			else
			{
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+" ");
					Tagger.token=false;
					Tagger.count1   ++;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+" ");
					Tagger.count1   ++;
				}
			}
		}

/************** check FirstToken in verb using PNG marker ******************************************/

		else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.eerkal1)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aarkal1))
		{
			Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.FirstToken,0,(Tagger.FirstToken.length-7));
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
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<V>"+" ");
					Tagger.token=false;
					Tagger.count1   ++;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<V>"+"   ");
					Tagger.count1   ++;
				}
			}
			else
			{
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
					Tagger.token=false;
					Tagger.count1   ++;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
					Tagger.count1   ++;
				}
			}
		}

/************** check FirstToken in verb using case marker **************************************/

		else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.atu)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.ana)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.kal)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.than))
			{
			  if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.vayathu))
		      {
             		if(Tagger.token==true)
					{
						Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
						Tagger.token=false;
						Tagger.count1   ++;
					}
					else
					{
						Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
						Tagger.count1   ++;
					}
		     }
			 else
			 {
				Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.FirstToken,0,(Tagger.FirstToken.length-3));
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
						Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<V>"+"   ");
						Tagger.token=false;
						Tagger.count1   ++;
					}
					else
					{
						Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<V>"+"   ");
						Tagger.count1   ++;
					}
				}
				else
				{
					if(Tagger.token==true)
					{
						Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
						Tagger.token=false;
						Tagger.count1   ++;
					}
					else
					{
						Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
						Tagger.count1   ++;
					}
				}
			 }
		}

/************** check FirstToken in verb using case marker***********************************/

		else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.atu1)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.ana1)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.kal1)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.than1))
		{
			if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.vayathu1))
		    {
             		if(Tagger.token==true)
					{
						Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
						Tagger.token=false;
						Tagger.count1   ++;
					}
					else
					{
						Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
						Tagger.count1   ++;
					}
		    }
			Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.FirstToken,0,(Tagger.FirstToken.length-5));
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
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<V>"+"   ");
					Tagger.token=false;
					Tagger.count1   ++;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<V>"+"   ");
					Tagger.count1   ++;
				}
			}
			else
			{
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
					Tagger.token=false;
					Tagger.count1   ++;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
					Tagger.count1   ++;
				}
			}
		}

/************** check FirstToken in verb using case marker ***************************************

		else if(Tagger.bytemeth.isequal1(Tagger.FirstToken,Tagger.kindru)||Tagger.bytemeth.isequal1(Tagger.FirstToken,Tagger.kru)
			||Tagger.bytemeth.isequal1(Tagger.FirstToken,Tagger.kkindru)||Tagger.bytemeth.isequal1(Tagger.FirstToken,Tagger.kkru))
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<V>"+"   ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<V>"+"   ");
				Tagger.count1   ++;
			}
		}

/************** check  FirstToken in verb using PNG marker ***************************************/

		else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aan)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.oom)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.eer)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aay)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aal)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aar)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.een))
		{
		   if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aanaal))
		   {
             		if(Tagger.token==true)
					{
						Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
						Tagger.token=false;
						Tagger.count1   ++;
					}
					else
					{
						Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
						Tagger.count1   ++;
					}
		  }
		  else
		  {
			Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.FirstToken,0,(Tagger.FirstToken.length-2));
			if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.yh)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.n)
				||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)
				||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.p)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.v)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.pp)
				||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.in)
				||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nnt)
				||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kindru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkindru)
				||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkru))
			{
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<V>"+"   ");
					Tagger.token=false;
					Tagger.count1   ++;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<V>"+"   ");
					Tagger.count1   ++;
				}
			}
			else
			{
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
					Tagger.token=false;
					Tagger.count1   ++;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
					Tagger.count1   ++;
				}
			}
		  }
		}

/****************check FirstToken in verbs with fullstop using PNG marker**************************/

		else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aan1)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.oom1)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.eer1)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aay1)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aal1)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aar1)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.een1))
		{
			Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.FirstToken,0,(Tagger.FirstToken.length-4));
			if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.yh)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.n)
				||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)
				||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.p)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.v)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.pp)
				||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.in)
				||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nnt)
				||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kindru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkindru)
				||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkru))
			{
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<V>"+"   ");
					Tagger.token=false;
					Tagger.count1   ++;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<V>"+"   ");
					Tagger.count1   ++;
				}
			}
			else
			{
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
					Tagger.token=false;
					Tagger.count1   ++;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
					Tagger.count1   ++;
				}
			}
		}

/**************check FirstToken in Demonstrate pronoun using case marker***********/

		else if(Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.entha)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.antha)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.yantha))
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
				Tagger.count1   ++;
			}
		}

/***********************check FirstToken in adjectives***********************/

		else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aana)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.oru)
		     ||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.yalla))
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<ADJ>"+"   ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<ADJ>"+"   ");
				Tagger.count1   ++;
			}
		}

/*****************************check FirstToken in numbers*****************************

		else if( Tagger.bytemeth.isequal1(Tagger.FirstToken,Tagger.a0)||Tagger.bytemeth.isequal1(Tagger.FirstToken,Tagger.a1)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a2)
			||Tagger.bytemeth.isequal1(Tagger.FirstToken,Tagger.a3)||Tagger.bytemeth.isequal1(Tagger.FirstToken,Tagger.a4)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a5)
			||Tagger.bytemeth.isequal1(Tagger.FirstToken,Tagger.a6)||Tagger.bytemeth.isequal1(Tagger.FirstToken,Tagger.a7)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a8)
			||Tagger.bytemeth.isequal1(Tagger.FirstToken,Tagger.a9)||Tagger.bytemeth.isequal1(Tagger.FirstToken,Tagger.a00)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a01)
			||Tagger.bytemeth.isequal1(Tagger.FirstToken,Tagger.a02)||Tagger.bytemeth.isequal1(Tagger.FirstToken,Tagger.a03)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a04)
			||Tagger.bytemeth.isequal1(Tagger.FirstToken,Tagger.a05)||Tagger.bytemeth.isequal1(Tagger.FirstToken,Tagger.a06)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a07)
			||Tagger.bytemeth.isequal1(Tagger.FirstToken,Tagger.a08)||Tagger.bytemeth.isequal1(Tagger.FirstToken,Tagger.a09)/*||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a00)*)
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
				Tagger.count1   ++;
			}
		}

/***************************check FirstToken in nouns using case marker******************/

		else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.il)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.ukku)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.akku)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.oor)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.an)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.al)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.itam)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.udya)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.utan)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.erkku)/*||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aal)*/||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.oodu)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.odu)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.kku)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.ppu)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.ar)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.in)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.ul)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.amm)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.cchi)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aall)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aall1)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.ar1)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.sss)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.ss)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.me)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.lee)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.mmpu)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.amm1))
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
				Tagger.count1   ++;
			}
		}

/**************************check FirstToken in numbers******************************/

		else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.three)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.muthal)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.eru)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.four)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.ten)//||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.six)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.seven)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.eight)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.nine)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.two)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.hunrd)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.lagsh)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.thosn)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.crore)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.one)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.three)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.five1)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.oor)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.kadaisi)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.hunrd1)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.six1)
			/*||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.six2)*/||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.six3)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.four1))
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<ADJ>"+"   ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<ADJ>"+"   ");
				Tagger.count1   ++;
			}
		}

/*****************************check FirstToken in numbers********************************/

		else if(Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.three)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.muthal)/*||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.eru)*/
			||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.four)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.ten)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.six)
			||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.seven)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.eight)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.nine)
			||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.two)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.hunrd)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.lagsh)
			||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.thosn)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.crore)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.one)
			||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.three)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.five)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.oor)
			||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.kadaisi)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.hunrd1)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.four1))
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<ADJ>"+"   ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<ADJ>"+"   ");
				Tagger.count1   ++;
			}
		}

/***************************check FirstToken in colors*********************************/

		else if(Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.yellow)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.black)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.paluppu)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.green)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.red1)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.red)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.blue)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.white)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.vilat)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.white1)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.orange)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.kavi)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.gray))
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<ADJ>"+"   ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<ADJ>"+"   ");
				Tagger.count1   ++;
			}
		}

/**********************check FirstToken in month***********************************/

		else if(Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.vaikasi)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.puratasi)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.aani)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.aypasi)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.aadi)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.margali)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.aavani)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.masi)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.panguni)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.jan)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.feb)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.mar)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.apr)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.may)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.jun)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.aug)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.sep)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.oct)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.nov)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.dec))
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
				Tagger.count1   ++;
			}
		}

/**********************************check FirstToken in week************************/

		else if(Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.thingal)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.shani)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.chavvai)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.nayaru)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.puthan)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.varam)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.viyazhan)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.matham)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.velli)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.aandu))
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
				Tagger.count1   ++;
			}
		}

/***********************check FirstToken in adverb************************************/

		else if(Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.appola)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.uula)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.kilakka)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.kila)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.tharkka)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.pina)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.piraka)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.muna)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.mala)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.markka)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.vatakka)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.athira)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.kurukka)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.valiya)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.udana)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.etaya)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.natuva))
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<ADV>"+"   ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<ADV>"+"   ");
				Tagger.count1   ++;
			}
		}

/****************************check FirstToken in adverb*****************************/

		else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.aka)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.pola)
		     ||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.pola))
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<ADV>"+"   ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<ADV>"+"   ");
				Tagger.count1   ++;
			}
		}

/*****************************check FirstToken in adverb**************************/

		else if(Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.adikadi)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.enimel)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.ennum)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.marupadium)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.meendum)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.meela)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.appothu)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.appoluthu)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.yavvalavu)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.eppothu)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.eppoluthu)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.evvalavu)
			||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.sumar)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.arakuraiya)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.arathala))
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<ADV>"+"   ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<ADV>"+"   ");
				Tagger.count1   ++;
			}
		}

/******************************check FirstToken in umm********************************/

		else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.eiumm))
		{
			Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.FirstToken,0,(Tagger.FirstToken.length-3));

			/**************************tense marker***************************/

			if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.ei)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kk)
			||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)
			||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.p)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.aal)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.pp)
			||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.in)
			||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rp)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nnt)
			||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kindru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kru)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkindru)
			||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkru))
			{
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<V>"+"   ");
					Tagger.token=false;
					Tagger.count1   ++;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<V>"+"   ");
					Tagger.count1   ++;
				}
			}
			else
			{
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
					Tagger.token=false;
					Tagger.count1   ++;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
					Tagger.count1   ++;
				}
			}
		}

/************************check FirstToken in nouns using case marker*********************/

		else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.ilunthu)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.edamiruthu)
			||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.ukkaka))
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
				Tagger.count1   ++;
			}
		}

/***************check FirstToken in Relative Participle using case marker****************/

		else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.a))
		{
		 if(Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.aana)||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.pola)
		   ||Tagger.bytemeth.isequal(Tagger.FirstToken,Tagger.pondra)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.eya)
		   ||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.mekka))
		 {
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<ADJ>"+"   ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<ADJ>"+"   ");
				Tagger.count1   ++;
			}
		}
		else
		{
			Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.FirstToken,0,(Tagger.FirstToken.length-1));

			/**************************tense marker**************************/

			if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.ttt)
				||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)//||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkk)
				||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rr)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tttt))
			{
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<RP>"+"   ");
					Tagger.token=false;
					Tagger.count1   ++;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<RP>"+"   ");
					Tagger.count1   ++;
				}
			}
			/***************check kkk***************************/
			else if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kkk))
			{
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<V>"+"   ");
					Tagger.token=false;
					Tagger.count1   ++;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<V>"+"   ");
					Tagger.count1   ++;
				}
			}
			else
			{
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<Unknown>"+"   ");
					//Tagger.count1   ++;
					Tagger.token=false;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<Unknown>"+"   ");
					//Tagger.count1   ++;
				}
			}
		}
		}

/**********************check FirstToken in verbal participle***********/

		else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.e))
		{
		 if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.manaivi))
		 {
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
				Tagger.count1   ++;
			}
		 }
		 else
		 {
			Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.FirstToken,0,(Tagger.FirstToken.length-1));

			/******************************tense marker***************************/

			if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.nnk)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.kk)
			     ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.ttt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rr)
			     ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tttt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr)
				 ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tt))
			{
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<VP>"+"   ");
					Tagger.token=false;
					Tagger.count1   ++;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<VP>"+"   ");
					Tagger.count1   ++;
				}
			}
			else
			{
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<Unknown>"+"   ");
					//Tagger.count1   ++;
					Tagger.token=false;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<Unknown>"+"   ");
					//Tagger.count1   ++;
				}
			}
		 }
		}

/*********check FirstToken in Relative Participle using case marker***************/

		else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.u))
		{
		 if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.kasu)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.arivu))
		 {
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
				Tagger.count1   ++;
			}
		 }
		 else
		 {
			Tagger.specifylength=Tagger.bytemeth.subarray(Tagger.FirstToken,0,(Tagger.FirstToken.length-1));

			/****************************tense marker*****************************/

			if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.naattu)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.veettu)
			  ||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.naattu1))
    		{
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<ADJ>"+"   ");
					Tagger.token=false;
					Tagger.count1   ++;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<ADJ>"+"   ");
					Tagger.count1   ++;
				}
			}
			/****************check kandu*****************/
			else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.kandu))
			  //||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.paattu))
    		{
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<VP>"+"   ");
					Tagger.token=false;
					Tagger.count1   ++;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<VP>"+"   ");
					Tagger.count1   ++;
				}
			}
			/**********************check tense marker**************************/
			else if(Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.t1)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.th)
			     ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.ttt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.rr)
			     ||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tttt)||Tagger.bytemeth.endswith(Tagger.specifylength,Tagger.tr))
			{
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<VP>"+"   ");
					Tagger.token=false;
					Tagger.count1   ++;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<VP>"+"   ");
					Tagger.count1   ++;
				}
			}
			else
			{
				if(Tagger.token==true)
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<Unknown>"+"   ");
					//Tagger.count1   ++;
					Tagger.token=false;
				}
				else
				{
					Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<Unknown>"+"   ");
					//Tagger.count1   ++;
				}
			}
		 }
		}

/*****************check FirstToken in nouns common word*********************/

		else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.kasu)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.manaivi)
		     ||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.arivu)||Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.tamil))
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<N>"+"   ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<N>"+"   ");
				Tagger.count1   ++;
			}
		}

/*****************check FirstToken in verbal noun******************/

		else if(Tagger.bytemeth.endswith(Tagger.FirstToken,Tagger.thal))
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<VN>"+"   ");
				Tagger.token=false;
				Tagger.count1   ++;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<VN>"+"   ");
				Tagger.count1   ++;
			}
		}

/**********************last else part*****************************/

		else
		{
			if(Tagger.token==true)
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FourthToken)+"<Unknown>"+"   ");
				//Tagger.count1   ++;
				Tagger.token=false;
			}
			else
			{
				Tagger.textarea.append(tabconvert2.revert(Tagger.FirstToken)+"<Unknown>"+"   ");
				//Tagger.count1   ++;
			}
		}
	}
}