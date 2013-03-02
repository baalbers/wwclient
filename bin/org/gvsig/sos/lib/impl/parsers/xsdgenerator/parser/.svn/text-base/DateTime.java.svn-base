package org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class DateTime {
	
	private static DateParser parser = new DateParser();

	public static int DATE = Calendar.DATE;
	public static int YEAR = Calendar.YEAR;
	public static int MONTH = Calendar.MONTH;
	public static int HOUR_OF_DAY = Calendar.HOUR_OF_DAY;
	public static int MINUTE = Calendar.MINUTE;
	public static int SECOND = Calendar.SECOND;
	public static int MILLISECOND = Calendar.MILLISECOND;
	Calendar calendar = Calendar.getInstance();
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
	
	/*public DateTime(long millis)
	{
		calendar.clear();
		calendar.setTimeInMillis(millis);
	}
	
	
	public DateTime(int year, int month, int day, int hour, int minute, int second, int millis)
	{
		calendar.clear();
		calendar.set(year,month,day,hour,minute,second);
		calendar.set(Calendar.MILLISECOND, millis);
	}
	
	public DateTime(int year, int month, int day, int hour, int minute,int second)
	{
		calendar.clear();
		calendar.set(year,month,day,hour,minute,second);
		calendar.set(Calendar.MILLISECOND, 0);
	}
	
	
	public DateTime(Date date)
	{
		calendar.clear();
		calendar.setTime(date);
	}*/
	
	public DateTime(Calendar calendar)
	{
		this.calendar = calendar;
	}
	
	public DateTime(String timeString) throws ParseException
	{
		this.calendar = parser.format(timeString);
	}
	
	public boolean isBefore(DateTime dateTime)
	{
		return calendar.before(dateTime.getCalendar());
	}
	
	public boolean isAfter(DateTime dateTime)
	{
		return calendar.after(dateTime.getCalendar());
	}
	
	public Date toDate()
	{
		return calendar.getTime();
	}
	
	public Calendar getCalendar()
	{
		return calendar;
	}
	
	public int getYears()
	{
		return calendar.get(Calendar.YEAR);
	}
	
	public void setYears(int years)
	{
		calendar.set(Calendar.YEAR, years);
	}
	
	public int getMonths()
	{
		return calendar.get(Calendar.MONTH);
	}
	
	public void setMonths(int months)
	{
		calendar.set(Calendar.MONTH,months);
	}
	
	public int getDays()
	{
		return calendar.get(Calendar.DATE);
	}
	
	public void setDays(int days)
	{
		calendar.set(Calendar.DATE, days);
	}
	
	public int getHours()
	{
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	
	public void setHours(int hours)
	{
		calendar.set(Calendar.HOUR_OF_DAY, hours);
	}
	
	public int getMinutes()
	{
		return calendar.get(Calendar.MINUTE);
	}
	
	public void setMinutes(int minutes)
	{
		calendar.set(Calendar.MINUTE, minutes);
	}
	
	public int getSeconds()
	{
		return calendar.get(Calendar.SECOND);
	}
	
	public void setSeconds(int seconds)
	{
		calendar.set(Calendar.SECOND, seconds);
	}
	
	public boolean isSet(int field)
	{
		return calendar.isSet(field);
	}
	
	@Override
	public String toString()
	{
		return formatter.format(calendar.getTime());
	}
	
	
	private static final class DateParser {
		private DateAnalizer analizer = null;
		private Component component = null;
		private static String PARSE_ERROR = "Cadena no reconocida";
		public DateParser()
		{
		}
		
		public Calendar format(String line) throws ParseException
		{

			analizer = new DateAnalizer(line);
			component = analizer.getNextComponent();
			AbstractAST arbol = analizaString();
			return arbol.evalua();
		}
		
		private AbstractAST analizaString() throws ParseException
		{
			AbstractAST arbol = analizaFactor();
			if(component.cat.equals(Component.GUION))
			{ 
				component = analizer.getNextComponent();
				if(component.cat.equals(Component.ENTERO))
				{
					AbstractAST meses = analizaFactor();
					if(component.cat.equals(Component.GUION))
					{
						//Hay dias
						component = analizer.getNextComponent();
						AbstractAST dias = analizaFactor();
						if(component.cat.equals(Component.T))
						{
							component = analizer.getNextComponent();
							AbstractAST horas = analizaHorasMinSec(null);
							if(component.cat.equals(Component.EOF))
							{
								return new NodoDateTime(arbol,meses,dias,horas);
							}else
							{
								throw new ParseException(PARSE_ERROR, 0);
							}
							
						}else if(component.cat.equals(Component.EOF))
						{
							return new NodoDateTime(arbol,meses,dias,null);
						}else
						{
							throw new ParseException(PARSE_ERROR, 0);
						}
					}else if(component.cat.equals(Component.EOF))
					{
						//Solo año y mes
						return new NodoDateTime(arbol, meses, null, null);
					}else
					{
						throw new ParseException(PARSE_ERROR, 0);
					}
				}
				//Fechas
			}else if(component.cat.equals(Component.DP))
			{
				return analizaHorasMinSec(arbol);
			}else if(component.cat.equals(Component.EOF))
			{
				return new NodoDateTime(arbol,null,null,null);
			}
			
			return arbol;
		}
		
		private AbstractAST analizaHorasMinSec(AbstractAST anyo) throws ParseException
		{
			AbstractAST anyos;
			if(anyo == null)
				anyos = analizaFactor();
			else
				anyos = anyo;
			if(component.cat.equals(Component.DP))
			{
				//minutos
				component = analizer.getNextComponent();
				AbstractAST minutos = analizaFactor();
				if(component.cat.equals(Component.DP))
				{//segundos
					component = analizer.getNextComponent();
					AbstractAST segundos = analizaFactor();
					if(component.cat.equals(Component.PUNTO))
					{//milisegundos
						component = analizer.getNextComponent();
						AbstractAST millis = analizaFactor();
						if(component.cat.equals(Component.Z))
						{
							component = analizer.getNextComponent();
							if(component.cat.equals(Component.EOF))
								return new NodoTime(anyos,minutos,segundos,millis,new NodoTimeZone("+",new NodoEntero("0"),new NodoEntero("0")));
							else
								throw new ParseException(PARSE_ERROR,0);
						}else if(component.cat.equals(Component.OPAD))
						{
							AbstractAST Timezone = analizaZonaHoraria();
							return new NodoTime(anyos,minutos,segundos,millis,Timezone);
						}else if(component.cat.equals(Component.EOF))
							return new NodoTime(anyos,minutos,segundos,millis,null);
					}else if(component.cat.equals(Component.Z))
					{
						component = analizer.getNextComponent();
						return new NodoTime(anyos,minutos,segundos,null,new NodoTimeZone("+",new NodoEntero("0"),new NodoEntero("0")));
					}
					else if(component.cat.equals(Component.OPAD))
					{
						AbstractAST Timezone = analizaZonaHoraria();
						return new NodoTime(anyos,minutos,segundos,null,Timezone);
					}
					else if(component.cat.equals(Component.EOF))
					{
						return new NodoTime(anyos,minutos,segundos,null,null);
					}else
					{
						throw new ParseException(PARSE_ERROR, 0);
					}
				}else
				{
					throw new ParseException(PARSE_ERROR, 0);
				}
			}else
			{
				throw new ParseException(PARSE_ERROR, 0);
			}
			return null;
		}
		
		private AbstractAST analizaFactor() throws ParseException
		{
			if(component.cat.equals(Component.ENTERO))
			{
				NodoEntero entero = new NodoEntero(component.lexema);
				component = analizer.getNextComponent();
				return entero;
			}else
			{
				throw new ParseException(PARSE_ERROR,0);
			}
		}
		
		private AbstractAST analizaZonaHoraria() throws ParseException
		{
			String operador = component.lexema;
			component = analizer.getNextComponent();
			
			AbstractAST zoneHour = analizaFactor();
			if(component.cat.equals(Component.DP))
			{
				component = analizer.getNextComponent();
				AbstractAST zoneMinutes = analizaFactor();
				return new NodoTimeZone(operador,zoneHour,zoneMinutes);
			}else
			{
				throw new ParseException(PARSE_ERROR, 0);
			}
		}
		
	}
	
	private static abstract class AbstractAST {
		public Calendar evalua(){ return null;}
		public int devuelve(){ return 0;}
		public TimeZone zone() {return null;}
	}
	
	private static class NodoDateTime extends AbstractAST
	{
		private AbstractAST years;
		private AbstractAST months;
		private AbstractAST days;
	
		
		private AbstractAST datehour;
		
		
		public NodoDateTime(AbstractAST years, AbstractAST months, AbstractAST days, AbstractAST datehour)
		{
			this.years = years;
			this.months = months;
			this.days = days;
			this.datehour = datehour;
		}

		@Override
		public Calendar evalua() {
			Calendar calendar = Calendar.getInstance();
			calendar.clear();
			calendar.set(Calendar.YEAR, years.devuelve());
			if(months != null)
				calendar.set(Calendar.MONTH, months.devuelve()-1);
			if(days != null)
				calendar.set(Calendar.DATE, days.devuelve());
			if(datehour != null)
			{
				Calendar cal = datehour.evalua();
				calendar.setTimeZone(cal.getTimeZone());
				calendar.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY));
				calendar.set(Calendar.MINUTE, cal.get(Calendar.MINUTE));
				calendar.set(Calendar.SECOND, cal.get(Calendar.SECOND));
				calendar.set(Calendar.MILLISECOND, cal.get(Calendar.MILLISECOND));
			}
				
			return calendar;
		}
	}

	private static class NodoEntero extends AbstractAST
	{
		public int entero;
		
		public NodoEntero(String lexema)
		{
			entero = Integer.parseInt(lexema);
		}
		
		public int devuelve()
		{
			return entero;
		}

	}
	
	private static class NodoTime extends AbstractAST{
		private AbstractAST hours;
		private AbstractAST minutes;
		private AbstractAST seconds;
		private AbstractAST millis;
		private AbstractAST timezone;
		
		public NodoTime(AbstractAST hours, AbstractAST minutes, AbstractAST seconds
				, AbstractAST millis, AbstractAST timezone)
		{
			this.hours = hours;
			this.minutes = minutes;
			this.seconds = seconds;
			this.millis = millis;
			this.timezone = timezone;
		}

		@Override
		public Calendar evalua() {
			Calendar calendar = Calendar.getInstance();
			calendar.clear();
			if(timezone != null)
				calendar.setTimeZone(timezone.zone());
			calendar.set(Calendar.HOUR_OF_DAY,hours.devuelve());
			calendar.set(Calendar.MINUTE,minutes.devuelve());
			calendar.set(Calendar.SECOND,seconds.devuelve());
			if(millis != null)
				calendar.set(Calendar.MILLISECOND, millis.devuelve());
			return calendar;
		}

	}
	
	private static class NodoTimeZone extends AbstractAST{
		private String operator = null;
		private AbstractAST hours = null;
		private AbstractAST minutes = null;
		private static String ZONE = "GMT";
		public NodoTimeZone(String operator, AbstractAST hours, AbstractAST minutes)
		{
			this.operator = operator;
			this.hours = hours;
			this.minutes = minutes;
		}
		
		public TimeZone zone()
		{
			int hour = hours.devuelve();
			int minute = minutes.devuelve();
			String zone = ZONE + operator;
			zone += hour < 10 ? "0" : "";
			zone += Integer.toString(hour) + ":";
			zone += minute < 10 ? "0" : "";
			zone += Integer.toString(minute);
			return TimeZone.getTimeZone(zone);
		}
	}

	private static class DateAnalizer {
		private String date = "";
		private int pos = 0;
		public DateAnalizer(String date)
		{
			this.date = date;
		}
		
		public Component getNextComponent()
		{
			//int i = 0;
			int estado = 0;
			char c;
			while(true)
			{
				if(pos < date.length())
					c = date.charAt(pos);
				else
					c = ' ';
				
				if(Character.isDigit(c))
					estado = 1;
				else if(c == '-')
					estado = 2;
				else if(c == ':')
					estado = 3;
				else if(c == ' ')
					estado = 4;
				else if(c == 'T')
					estado = 5;
				else if(c == '+' || c == '-')
					estado = 6;
				else if(c == 'Z')
					estado = 7;
				else if(c == '.')
					estado = 8;
				
				if(estado == 1)
				{	//Digito
					ArrayList<Character> lexema = new ArrayList<Character>();
					lexema.add(c);
					nextPos();
					if(isStringEnd())
					{
						return new Component(Component.ENTERO, new String(transformArray(lexema)));
					}
					c = getNextChar();
					while(Character.isDigit(c))
					{
						lexema.add(c);
						nextPos();
						if(isStringEnd())
						{
							return new Component(Component.ENTERO, new String(transformArray(lexema)));
						}
						c = getNextChar();
					}
					return new Component(Component.ENTERO, new String(transformArray(lexema)));
				}
				else if(estado == 2)
				{
					//GUION
					nextPos();
					return new Component(Component.GUION,"-");
				}
				else if(estado == 3)
				{	//Dos puntos
					nextPos();
					return new Component(Component.DP,":");
				}else if(estado == 4)
					return new Component(Component.EOF,"");
				else if(estado == 5)
				{
					nextPos();
					return new Component(Component.T,"T");
				}else if(estado == 6)
				{
					char [] lexema = new char[1];
					lexema[0] = c;
					nextPos();
					return new Component(Component.OPAD,new String(lexema));
				}else if(estado == 7)
				{
					nextPos();
					return new Component(Component.Z,"Z");
				}else if(estado == 8)
				{
					nextPos();
					return new Component(Component.PUNTO,".");
				}
				
			}
			
		}
		
		private char getNextChar()
		{
			return this.date.charAt(pos);
		}
		
		private void nextPos()
		{
			pos++;
		}
		
		private boolean isStringEnd()
		{
			return pos == date.length();
		}
		
		private char [] transformArray(List<Character> array)
		{
			Object [] arrayChar = array.toArray();
			char[] result = new char[arrayChar.length];
			for(int i = 0; i < result.length; i++)
			{
				result[i] = ((Character)arrayChar[i]).charValue();
			}
			return result;
		}
	}

	private static class Component {
		public static String ENTERO = "ENTERO";
		public static String DP = "DP";
		public static String GUION = "GUION";
		public static String EOF = "EOF";
		public static String T = "T";
		public static String Z = "Z";
		public static String PUNTO = "PUNTO";
		public static String OPAD = "OPAD";
		
		public String lexema = "";
		public String cat = "";
		
		public Component(String categoria, String lexema)
		{
			this.lexema = lexema;
			this.cat = categoria;
		}

		/*public String getLexema() {
			return lexema;
		}

		public void setLexema(String lexema) {
			this.lexema = lexema;
		}

		public String getCat() {
			return cat;
		}

		public void setCat(String cat) {
			this.cat = cat;
		}*/
	}
}


