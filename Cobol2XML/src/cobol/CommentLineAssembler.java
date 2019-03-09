/*
 * @(#)CommentLineAssembler.java	 0.0.1
 *
 * Copyright (c) 2019 Julian M. Bass
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 */
 
package cobol;

import parse.*;
import parse.tokens.*;
public class CommentLineAssembler extends Assembler {
/**
 * Pop a string, and set the target DataDivision to this
 * string.
 *
 * @param   Assembly   the assembly to work on
 */
public void workOn(Assembly a) {
	//System.out.println("commentLineAssembler");
	//String delimiter = defaultDelimiter();
	//System.out.println("tokenString: " + a.remainder(defaultDelimiter()) );
	Cobol c = new Cobol();
	Token t = (Token) a.pop(); // hopefully the token following the comment
	
	if(t.sval() != null) {
		c.setCommentLine(t.sval().trim()+ defaultDelimiter() + a.remainder(defaultDelimiter()));
		a.setTarget(c); }
	}

public String defaultDelimiter() {
	String delimiter = " ";
	return delimiter; 
	}

}