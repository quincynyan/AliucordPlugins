package com.davidnyan10.plugins;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fractions {
	public static String setCharAt(String str, int index, String chr) {
		if (index > str.length() - 1)
			return str;
		return str.substring(0, index) + chr + str.substring(index + 1);
	}

	public static String[] reduce(String num, String den) {
		if (num.startsWith("+")) {
			num = num.substring(1);
		}
		if (den.startsWith("+")) {
			den = den.substring(1);
		}
		Boolean neg = Integer.parseInt(num) < 0 != Integer.parseInt(den) < 0;
		num = Math.abs(Integer.parseInt(num)) + "";
		den = Math.abs(Integer.parseInt(den)) + "";
		int g = gcd(Integer.parseInt(num), Integer.parseInt(den));
		return new String[] { neg ? "-" : "" + (Integer.parseInt(num) / g), (Integer.parseInt(den) / g) + "" };
	}

	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public static HashMap<String, String> superscript = new HashMap<String, String>() {
		{
			put("0", Character.toString('\u2070'));
			put("1", Character.toString('\u00B9'));
			put("2", Character.toString('\u00B2'));
			put("3", Character.toString('\u00B3'));
			put("4", Character.toString('\u2074'));
			put("5", Character.toString('\u2075'));
			put("6", Character.toString('\u2076'));
			put("7", Character.toString('\u2077'));
			put("8", Character.toString('\u2078'));
			put("9", Character.toString('\u2079'));
			put("+", Character.toString('\u207A'));
			put("-", Character.toString('\u207B'));
			put("=", Character.toString('\u207C'));
			put("(", Character.toString('\u207D'));
			put(")", Character.toString('\u207E'));
			put("a", Character.toString('\u1D43'));
			put("b", Character.toString('\u1D47'));
			put("c", Character.toString('\u1D9C'));
			put("d", Character.toString('\u1D48'));
			put("e", Character.toString('\u1D49'));
			put("f", Character.toString('\u1DA0'));
			put("g", Character.toString('\u1D4D'));
			put("h", Character.toString('\u02B0'));
			put("i", Character.toString('\u2071'));
			put("j", Character.toString('\u02B2'));
			put("k", Character.toString('\u1D4F'));
			put("l", Character.toString('\u02E1'));
			put("m", Character.toString('\u1D50'));
			put("n", Character.toString('\u207F'));
			put("o", Character.toString('\u1D52'));
			put("p", Character.toString('\u1D56'));
			put("r", Character.toString('\u02B3'));
			put("s", Character.toString('\u02E2'));
			put("t", Character.toString('\u1D57'));
			put("u", Character.toString('\u1D58'));
			put("v", Character.toString('\u1D5B'));
			put("w", Character.toString('\u02B7'));
			put("x", Character.toString('\u02E3'));
			put("y", Character.toString('\u02B8'));
			put("z", Character.toString('\u1DBB'));
			put(" ", Character.toString(' '));
		}
	};

	public static HashMap<String, String> subscript = new HashMap<String, String>() {
		{
			put("0", Character.toString('\u2080'));
			put("1", Character.toString('\u2081'));
			put("2", Character.toString('\u2082'));
			put("3", Character.toString('\u2083'));
			put("4", Character.toString('\u2084'));
			put("5", Character.toString('\u2085'));
			put("6", Character.toString('\u2086'));
			put("7", Character.toString('\u2087'));
			put("8", Character.toString('\u2088'));
			put("9", Character.toString('\u2089'));
			put("+", Character.toString('\u208A'));
			put("-", Character.toString('\u208B'));
			put("=", Character.toString('\u208C'));
			put("(", Character.toString('\u208D'));
			put(")", Character.toString('\u208E'));
			put("a", Character.toString('\u2090'));
			put("e", Character.toString('\u2091'));
			put("h", Character.toString('\u2095'));
			put("i", Character.toString('\u1D62'));
			put("j", Character.toString('\u2C7C'));
			put("k", Character.toString('\u2096'));
			put("l", Character.toString('\u2097'));
			put("m", Character.toString('\u2098'));
			put("n", Character.toString('\u2099'));
			put("o", Character.toString('\u2092'));
			put("p", Character.toString('\u209A'));
			put("r", Character.toString('\u1D63'));
			put("s", Character.toString('\u209B'));
			put("t", Character.toString('\u209C'));
			put("u", Character.toString('\u1D64'));
			put("v", Character.toString('\u1D65'));
			put("x", Character.toString('\u2093'));
			put(" ", Character.toString(' '));
		}
	};

	public static HashMap<String, String> fractions = new HashMap<String, String>() {
		{
			put("1/2", Character.toString('\u00BD'));
			put("1/3", Character.toString('\u2153'));
			put("2/3", Character.toString('\u2154'));
			put("1/4", Character.toString('\u00BC'));
			put("3/4", Character.toString('\u00BE'));
			put("1/5", Character.toString('\u2155'));
			put("2/5", Character.toString('\u2156'));
			put("3/5", Character.toString('\u2157'));
			put("4/5", Character.toString('\u2158'));
			put("1/6", Character.toString('\u2159'));
			put("5/6", Character.toString('\u215A'));
			put("1/7", Character.toString('\u2150'));
			put("1/8", Character.toString('\u215B'));
			put("3/8", Character.toString('\u215C'));
			put("5/8", Character.toString('\u215D'));
			put("7/8", Character.toString('\u215E'));
			put("1/9", Character.toString('\u2151'));
			put("1/10", Character.toString('\u2152'));
		}
	};

	public static String slash = "/";

	public static String[] getFraction(String numerator, String denominator) {
		numerator = numerator.trim();
		denominator = denominator.trim();

		String orig = Fractions.map(numerator, denominator);
		String[] simp;
		String simpString = "";
		if (Pattern.compile("^[+-]?\\d+$").matcher(numerator).matches()) {
			try {
				simp = reduce(numerator, denominator);
				// System.out.println("reducing " + orig + " to " + simp);
				simpString = map(simp[0], simp[1]);
			} catch (Exception e) {
				simpString = "";
			}
		}
		if (simpString == orig) {
			simpString = "";
		}
		return new String[] { orig, simpString };
	}

	public static String map(String num, String den) {
		if (Fractions.fractions.get(num + "/" + den) != null) {
			return Fractions.fractions.get(num + "/" + den);
		}
		String numOut = "";
		String denOut = "";
		for (String val : num.split("")) {
			String correspondingNum = Fractions.superscript.get(val);
			if (correspondingNum == null) {
				throw new Error();
			}
			numOut += correspondingNum;
		}
		System.out.println(den);
		for (String val : den.split("")) {
			String correspondingNun = Fractions.subscript.get(val);
			if (correspondingNun == null) {
				throw new Error();
			}
			denOut += correspondingNun;
		}
		return numOut + Fractions.slash + denOut;
	}

	public static String replaceFractionsInString(String str) {
		// var fractions = str.match(/(?<=\s|^)[-)(+0-9x]+\/[-)(+0-9x]+(?=\s|$)/g);
		List<String> allMatches = new ArrayList<String>();
		Pattern p = Pattern.compile("(?<=\\s|^)[-)(+0-9x]+/[-)(+0-9x]+(?=\\s|$)");
		Matcher m = p.matcher(str);
		while (m.find()) {
			allMatches.add(m.group());
		}
		String[] fractions = allMatches.toArray(new String[0]);
		if (fractions.length == 0) {
			return str;
		}
		for (String fraction : fractions) {
			if (fraction.startsWith("(") &&
					fraction.endsWith(")") &&
					fraction.length() != 3) {
				String num = Fractions.setCharAt(fraction.split("/")[0], 0, "");
				String den = Fractions.setCharAt(fraction.split("/")[1], fraction.split("/")[1].length() - 1, "");
				String[] replacement = getFraction(num, den);
				if (replacement[0].charAt(0) == Character.toString('\u207B').charAt(0)) {
					replacement[0] = Fractions.setCharAt(replacement[0], 0, "-");
				}
				if (replacement[1].charAt(0) == Character.toString('\u207B').charAt(0)) {
					replacement[1] = Fractions.setCharAt(replacement[1], 0, "-");
				}
				// str = str.replace(fraction, replacement[1] || replacement[0]);
				str = str.replace(fraction,
						replacement[(replacement[1] != null && !replacement[1].equals("")) ? 1 : 0]);
			} else {
				String num = fraction.split("/")[0];
				String den = fraction.split("/")[1];
				String[] replacement = getFraction(num, den);
				str = str.replace(fraction, replacement[0]);
				if (replacement[1] != null && !replacement[1].equals("")) {
					str = str.replace(replacement[1], replacement[0]);
				}
			}
		}
		return str;
	}
}
