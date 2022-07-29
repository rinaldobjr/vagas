package com.pasquali.vagas.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DataHora {

	public static Date dataHoje() {
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return data;
		// DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		// return dtf5.format(LocalDate.now());
	}

	public static String horaHoje() {
		Date dataHoraAtual = new Date();
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
		return hora;
	}

	public static void verData() {
		Calendar c = Calendar.getInstance();
		System.out.println("Data/Hora atual: " + c.getTime());
		System.out.println("Ano: " + c.get(Calendar.YEAR));
		System.out.println("Mês: " + c.get(Calendar.MONTH));
		System.out.println("Dia do Mês: " + c.get(Calendar.DAY_OF_MONTH));
	}

	public static void verificaData(Integer ano, Integer mes, Integer dia) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, ano);
		c.set(Calendar.MONTH, mes);
		c.set(Calendar.DAY_OF_MONTH, dia);

		System.out.println("Data/Hora atual: " + c.getTime());
		System.out.println("Ano: " + c.get(Calendar.YEAR));
		System.out.println("Mês: " + c.get(Calendar.MONTH));
		System.out.println("Dia do Mês: " + c.get(Calendar.DAY_OF_MONTH));
	}

	public static void boasVindas() {
		Calendar c1 = Calendar.getInstance();
		int hora = c1.get(Calendar.HOUR_OF_DAY);

		if (hora > 6 && hora < 12) {
			System.out.println("Bom Dia");
		} else if (hora > 12 && hora < 18) {
			System.out.println("Boa Tarde");
		} else {
			System.out.println("Boa Noite");
		}
	}

	public static void dataHoraFormatada() {
		Calendar c = Calendar.getInstance();
		c.set(2013, Calendar.FEBRUARY, 28);
		Date data = c.getTime();
		System.out.println("Data atual sem formatação: " + data);

		// Formata a data
		DateFormat formataData = DateFormat.getDateInstance();
		System.out.println("Data atual com formatação: " + formataData.format(data));

		// Formata Hora
		DateFormat hora = DateFormat.getTimeInstance();
		System.out.println("Hora formatada: " + hora.format(data));

		// Formata Data e Hora
		DateFormat dtHora = DateFormat.getDateTimeInstance();
		System.out.println(dtHora.format(data));

	}

	public static void dataFormatada() {
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();

		DateFormat f = DateFormat.getDateInstance(DateFormat.FULL); // Data COmpleta
		System.out.println("Data brasileira: " + f.format(data));

		f = DateFormat.getDateInstance(DateFormat.LONG);
		System.out.println("Data sem o dia descrito: " + f.format(data));

		f = DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println("Data resumida 1: " + f.format(data));

		f = DateFormat.getDateInstance(DateFormat.SHORT);
		System.out.println("Data resumida 2: " + f.format(data));
	}

	public static void dataParse() throws ParseException {
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		DateFormat f = DateFormat.getDateInstance();

		Date data2 = f.parse("12/01/1995");
		System.out.println(data2);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Data formatada: " + sdf.format(data));

		// Converte Objetos
		System.out.println("Data convertida: " + sdf.parse("02/08/1970"));
	}

	public static void dataInter() throws ParseException {
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();

		Locale brasil = new Locale("pt", "BR"); // Retorna do país e a língua
		Locale eua = Locale.US;
		Locale italia = Locale.ITALIAN;

		DateFormat f2 = DateFormat.getDateInstance(DateFormat.FULL, brasil);
		System.out.println("Data e hora brasileira: " + f2.format(data));

		DateFormat f3 = DateFormat.getDateInstance(DateFormat.FULL, eua);
		System.out.println("Data e hora americana: " + f3.format(data));

		DateFormat f4 = DateFormat.getDateInstance(DateFormat.FULL, italia);
		System.out.println("Data e hora italiana: " + f4.format(data));
	}

	public Date converteData(String data) {
		Date d = null;
		try {
			data = data.substring(6) + "-" + data.substring(3, 5) + "-" + data.substring(0, 2);
			// d = Date.valueOf(data);
			d = java.sql.Date.valueOf(data);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return d;
	}

	public int calcularIdade1(String dataNasc) {
		Calendar c = Calendar.getInstance();
		int anoAtual = Calendar.YEAR;
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy");
		int anoNasc = Integer.parseInt(formatador.format(dataNasc));
		return anoAtual - anoNasc;
	}

	public static int calculaIdade(String dataNasc, String pattern) {
		DateFormat sdf = new SimpleDateFormat(pattern);
		Date dataNascInput = null;
		try {
			dataNascInput = sdf.parse(dataNasc);
		} catch (Exception e) {
			System.out.println(e);
		}

		Calendar dateOfBirth = new GregorianCalendar();
		dateOfBirth.setTime(dataNascInput);
		// Cria um objeto calendar com a data atual
		Calendar today = Calendar.getInstance();
		// Obtém a idade baseado no ano
		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
		dateOfBirth.add(Calendar.YEAR, age);
		if (today.before(dateOfBirth)) {
			age--;
		}
		return age;
	}

	public static Date castToDate(Object x, int targetSqlType) throws Exception {
		if (x instanceof Date) {
			return (Date) x;
		}
		if (x instanceof java.util.Date) {
			return new Date(((java.util.Date) x).getTime());
		}
		if (x instanceof LocalDate) {
			return java.sql.Date.valueOf((LocalDate) x);
		}
		if (x instanceof LocalDateTime) {
			return java.sql.Date.valueOf(((LocalDateTime) x).toLocalDate());
		}
		try {
			if (x instanceof String) {
				return java.sql.Date.valueOf((String) x);
			}
		} catch (RuntimeException e) {
			throw invalidConversion(x, targetSqlType, e);
		}
		throw invalidConversion(x, targetSqlType);
	}

	private static Exception invalidConversion(Object x, int targetSqlType) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Exception invalidConversion(Object x, int targetSqlType, RuntimeException e) {
		// TODO Auto-generated method stub
		return null;
	}

//	public static String getSmartDate(String date) {
//		date = StringUtil.getTrimedString(date);
//		try {
//			return getSmartDate(java.sql.Date.valueOf(date));
//		} catch (Exception e) {
//		}
//		return date;
//	}

	public static Date intToDate(Integer input) {
		if (input == null) {
			return null;
		}
		return java.sql.Date.valueOf(LocalDate.ofEpochDay(input));
	}

	public static Long somandoData1(Integer dias) {
		return LocalDate.now().plusDays(dias).toEpochDay();
	}
//	LocalDate
//	.parse( "2020-01-18" )
//	.withMonth( 4 )
//	.toString();

	public static String somandoData(Integer dias) {
		return LocalDate.now().plusDays(dias).toString();
	}

	public static String subtraindoData(Integer dias) {
		return LocalDate.now().minusDays(dias).toString();
	}

	public static Date getDateWithoutTimeUsingFormat() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.parse(formatter.format(new Date()));
	}

	public static Date getDateWithoutTimeUsingCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	public Date addHoursToJavaUtilDate(Date date, int hours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		return calendar.getTime();
	}

	public static void datas() {
		// get "now" without any time zone or offset information
		LocalDateTime now = LocalDateTime.now();
		// extract the date part
		LocalDate today = now.toLocalDate();
		// extract the time-of-day part
		LocalTime timeOfNow = now.toLocalTime();
		// then print the single parts (date and time of day)
		System.out.println("Today is " + today + " and now is " + timeOfNow + " that day");
		// print the full timestamp
		System.out.println("Full date and time are now " + now);
		// or print the epoch milliseconds (A ZONE OR AN OFFSET IS NEEDED THEN)
		System.out.println("Moment in time of now is " + now.toInstant(ZoneOffset.UTC).toEpochMilli() + " in UTC");
	}

	public static int getDayNumber(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	public static int getDayNumberNew(LocalDate date) {
		DayOfWeek day = date.getDayOfWeek();
		return day.getValue();
	}

	public static String getDayString(Date date, Locale locale) {
		if (locale == null) {
			locale = Locale.US;
		}
		DateFormat formatter = new SimpleDateFormat("EEEE", locale);
		return formatter.format(date);
	}

	public static String getDayStringNew(LocalDate date, Locale locale) {
		DayOfWeek day = date.getDayOfWeek();
		return day.getDisplayName(TextStyle.FULL, locale);
	}

	public static LocalDate addDaysSkippingWeekends(LocalDate date, int days) {
		LocalDate result = date;
		int addedDays = 0;
		while (addedDays < days) {
			result = result.plusDays(1);
			if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
				++addedDays;
			}
		}
		return result;
	}

	public static LocalDate subtractDaysSkippingWeekends(LocalDate date, int days) {
		LocalDate result = date;
		int subtractedDays = 0;
		while (subtractedDays < days) {
			result = result.minusDays(1);
			if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
				++subtractedDays;
			}
		}
		return result;
	}

}
//java.util.Date now = new java.util.Date();
//java.sql.Date date = new java.sql.Date(now.getTime());

//Comparing Dates
//LocalDate firstDate = LocalDate.of(2019, 8, 10);
//LocalDate secondDate = LocalDate.of(2019, 7, 1);
//assertThat(firstDate.isAfter(secondDate), is(true));

//assertThat(firstDate.isEqual(firstDate), is(true));
//assertThat(firstDate.isEqual(secondDate), is(false));
//https://www.baeldung.com/java-comparing-dates

//https://www.baeldung.com/java-random-dates

/*
 * public class DateValidatorUsingDateFormat implements DateValidator { private
 * String dateFormat;
 * 
 * public DateValidatorUsingDateFormat(String dateFormat) { this.dateFormat =
 * dateFormat; }
 * 
 * @Override public boolean isValid(String dateStr) { DateFormat sdf = new
 * SimpleDateFormat(this.dateFormat); sdf.setLenient(false); try {
 * sdf.parse(dateStr); } catch (ParseException e) { return false; } return true;
 * } }
 * 
 * 
 * public class DateValidatorUsingLocalDate implements DateValidator { private
 * DateTimeFormatter dateFormatter;
 * 
 * public DateValidatorUsingLocalDate(DateTimeFormatter dateFormatter) {
 * this.dateFormatter = dateFormatter; }
 * 
 * @Override public boolean isValid(String dateStr) { try {
 * LocalDate.parse(dateStr, this.dateFormatter); } catch (DateTimeParseException
 * e) { return false; } return true; } }
 * 
 * 
 * public class DateValidatorUsingDateTimeFormatter implements DateValidator {
 * private DateTimeFormatter dateFormatter;
 * 
 * public DateValidatorUsingDateTimeFormatter(DateTimeFormatter dateFormatter) {
 * this.dateFormatter = dateFormatter; }
 * 
 * @Override public boolean isValid(String dateStr) { try {
 * this.dateFormatter.parse(dateStr); } catch (DateTimeParseException e) {
 * return false; } return true; } }
 * 
 * DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd",
 * Locale.US) .withResolverStyle(ResolverStyle.STRICT); DateValidator validator
 * = new DateValidatorUsingDateTimeFormatter(dateFormatter);
 * 
 * assertTrue(validator.isValid("2019-02-28"));
 * assertFalse(validator.isValid("2019-02-30"));
 * 
 * 
 * <dependency> <groupId>commons-validator</groupId>
 * <artifactId>commons-validator</artifactId> <version>1.6</version>
 * </dependency>
 */
