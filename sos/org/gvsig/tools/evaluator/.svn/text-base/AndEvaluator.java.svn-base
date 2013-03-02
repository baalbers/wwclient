/* gvSIG. Geographic Information System of the Valencian Government
 *
 * Copyright (C) 2007-2008 Infrastructures and Transports Department
 * of the Valencian Government (CIT)
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 *
 */
package org.gvsig.tools.evaluator;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * This evaluator is a set of evaluators that are applied used the and
 * operator. It means that the evaluate method only returns <code>true</code>
 * if all the evaluators return <code>true</code>.  
 * </p>
 * <p>
 * A condition to use this type of evaluators is that the evaluate method
 * of all the single evaluators has to return a boolean value.
 * </p>
 * 
 * @author gvSIG Team
 * @version $Id$
 * 
 */
public class AndEvaluator extends AbstractEvaluator{
    private List evaluators = new ArrayList();    

    public AndEvaluator(Evaluator evaluator) {
        super();         
        addEvaluator(evaluator);    
    }

    public Object evaluate(EvaluatorData data) throws EvaluatorException {
        for (int i=0 ; i<evaluators.size() ; i++){
            Evaluator evaluator = (Evaluator)evaluators.get(i);
            if (!((Boolean)evaluator.evaluate(data)).booleanValue()){
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public String getName() {       
        return "a set of evaluators";
    }

    public void addEvaluator(Evaluator evaluator){
        if (evaluator != null){
            evaluators.add(evaluator);
        }
    }

    public String getSQL() {       
        if (evaluators.size() > 0){
            StringBuffer stringBuffer = new StringBuffer(((Evaluator)evaluators.get(0)).getSQL());
            for (int i=1 ; i<evaluators.size() ; i++){
                stringBuffer.append(" and " + ((Evaluator)evaluators.get(i)).getSQL());
            }
            return stringBuffer.toString();
        }else{
            return "";
        }
    }   
}
