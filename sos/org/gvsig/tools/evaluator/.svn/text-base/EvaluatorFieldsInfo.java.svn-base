package org.gvsig.tools.evaluator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class EvaluatorFieldsInfo {
	private Map fields = new HashMap();
	private String[] names = null;

	public String[] getFieldNames() {
		if (names == null) {
			Set namesSet = fields.keySet();
            names = (String[]) namesSet.toArray(new String[namesSet.size()]);
		}
		return names;
	}

	public EvaluatorFieldValue[] getFieldValues(String name) {
        List values = (List) this.fields.get(name);
        return values == null ? null : (EvaluatorFieldValue[]) values
            .toArray(new EvaluatorFieldValue[values.size()]);
	}

	public void addFieldValue(String name) {
		EvaluatorFieldValue field = new EvaluatorFieldValue(name);
		this.addFieldValue(field);
	}

	public void addMatchFieldValue(String name, Object value) {
		EvaluatorFieldValue field = new EvaluatorFieldValueMatch(name, value);
		this.addFieldValue(field);
	}

	public void addRangeFieldValue(String name, Object value1, Object value2) {
		EvaluatorFieldValue field = new EvaluatorFieldValueRange(name, value1,
				value2);
		this.addFieldValue(field);
	}

	public void addNearestFieldValue(String name, int count, Object value) {
		EvaluatorFieldValue field = new EvaluatorFieldValueNearest(name, count,
				value);
		this.addFieldValue(field);
	}

	public void addNearestFieldValue(String name, int count, Object tolerance,Object value) {
		EvaluatorFieldValue field = new EvaluatorFieldValueNearest(name, count,
				tolerance,
				value);
		this.addFieldValue(field);
	}

	private void addFieldValue(EvaluatorFieldValue field) {
		List list = (List) this.fields.get(field.getFieldName());
		if (list == null) {
			this.names = null;
			list = new ArrayList();
			this.fields.put(field.getFieldName(), list);
		}
		list.add(field);
	}
}
