/******  Checkallnounphase class  contain the checknp2 and checkstop method
 it can identify Nounphrase from Standalone words, case markers, tense marker,Endpattern search and startpattern search also identify Noun and verb, all are using morphological and heuristic rules  **************

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

/******  Checkallnounphrase class  contain the checknp2 and checkstop method
 it can identify Nounphrase from Standalone words, case markers, tense marker,Endpattern search and startpattern search also identifies Noun and verb, all are using morphological and heuristic rules  **************/
public class Checknounphrase1
{
	//Checkfullitem class used to check all items (ie noun,verb,adverb,adjective,particle....)
	//Checkfullitem checkfull=new Checkfullitem();

	//Checknounphrase2 class used to check check noun phrase using morphological and heuristic rules
	Checknounphrase2 checknp2=new Checknounphrase2();

	//Checkfullstop class used to check fullstop and analyse the verb token
	Checkfullstop checkstop=new Checkfullstop();

/*********************Default Constructor***********************************/

	Checknounphrase1()
	{
	}

/**********************checknp1 method identifies Noun phrase from Standalone words, case markers, tense marker,Endpattern search and startpattern search also identify Noun and verb using morphological and heuristic rules ****************************/

    public void checknp1()
	{

/***************************check FirstToken in numerals and roman letters*********************/
			System.out.println(" Calling checknp1");
       if(Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a0)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a1)
        	||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a2)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a3)
        	||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a4)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a5)
            ||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a6)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a7)
            ||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a8)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a9)
            ||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a00)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a01)
            ||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a02)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a03)
            ||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a04)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a05)
            ||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a06)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a07)
            ||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a08)||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a09)
            ||Tagger.bytemeth.startswith(Tagger.FirstToken,Tagger.a00))
       {
		   		//checknp2 method used to check check noun phrase using morphological and heuristic rules
          		checknp2.checknp2();
       }

/******************************last else part******************************/

       else
	   {
		    //checkstop method used to check fullstop and analyse the verb token
   		    checkstop.checkstop();
       }
	  }
}