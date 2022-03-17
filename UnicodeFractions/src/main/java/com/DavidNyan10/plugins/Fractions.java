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

	// var superscript = {
	// 0: "⁰",
	// 1: "¹",
	// 2: "²",
	// 3: "³",
	// 4: "⁴",
	// 5: "⁵",
	// 6: "⁶",
	// 7: "⁷",
	// 8: "⁸",
	// 9: "⁹",
	// "+": "⁺",
	// "-": "⁻",
	// "=": "⁼",
	// "(": "⁽",
	// ")": "⁾",
	// a: "ᵃ",
	// b: "ᵇ",
	// c: "ᶜ",
	// d: "ᵈ",
	// e: "ᵉ",
	// f: "ᶠ",
	// g: "ᵍ",
	// h: "ʰ",
	// i: "ⁱ",
	// j: "ʲ",
	// k: "ᵏ",
	// l: "ˡ",
	// m: "ᵐ",
	// n: "ⁿ",
	// o: "ᵒ",
	// p: "ᵖ",
	// r: "ʳ",
	// s: "ˢ",
	// t: "ᵗ",
	// u: "ᵘ",
	// v: "ᵛ",
	// w: "ʷ",
	// x: "ˣ",
	// y: "ʸ",
	// z: "ᶻ",
	// " ": " "
	// };

	public static HashMap<String, String> superscript = new HashMap<String, String>() {
		{
			put("0", "⁰");
			put("1", "¹");
			put("2", "²");
			put("3", "³");
			put("4", "⁴");
			put("5", "⁵");
			put("6", "⁶");
			put("7", "⁷");
			put("8", "⁸");
			put("9", "⁹");
			put("+", "⁺");
			put("-", "⁻");
			put("=", "⁼");
			put("(", "⁽");
			put(")", "⁾");
			put("a", "ᵃ");
			put("b", "ᵇ");
			put("c", "ᶜ");
			put("d", "ᵈ");
			put("e", "ᵉ");
			put("f", "ᶠ");
			put("g", "ᵍ");
			put("h", "ʰ");
			put("i", "ⁱ");
			put("j", "ʲ");
			put("k", "ᵏ");
			put("l", "ˡ");
			put("m", "ᵐ");
			put("n", "ⁿ");
			put("o", "ᵒ");
			put("p", "ᵖ");
			put("r", "ʳ");
			put("s", "ˢ");
			put("t", "ᵗ");
			put("u", "ᵘ");
			put("v", "ᵛ");
			put("w", "ʷ");
			put("x", "ˣ");
			put("y", "ʸ");
			put("z", "ᶻ");
			put(" ", " ");
		}
	};

	// var subscript = {
	// 0: "₀",
	// 1: "₁",
	// 2: "₂",
	// 3: "₃",
	// 4: "₄",
	// 5: "₅",
	// 6: "₆",
	// 7: "₇",
	// 8: "₈",
	// 9: "₉",
	// "+": "₊",
	// "-": "₋",
	// "=": "₌",
	// "(": "₍",
	// ")": "₎",
	// a: "ₐ",
	// e: "ₑ",
	// h: "ₕ",
	// i: "ᵢ",
	// j: "ⱼ",
	// k: "ₖ",
	// l: "ₗ",
	// m: "ₘ",
	// n: "ₙ",
	// o: "ₒ",
	// p: "ₚ",
	// r: "ᵣ",
	// s: "ₛ",
	// t: "ₜ",
	// u: "ᵤ",
	// v: "ᵥ",
	// x: "ₓ",
	// " ": " "
	// };

	public static HashMap<String, String> subscript = new HashMap<String, String>() {
		{
			put("0", "₀");
			put("1", "₁");
			put("2", "₂");
			put("3", "₃");
			put("4", "₄");
			put("5", "₅");
			put("6", "₆");
			put("7", "₇");
			put("8", "₈");
			put("9", "₉");
			put("+", "₊");
			put("-", "₋");
			put("=", "₌");
			put("(", "₍");
			put(")", "₎");
			put("a", "ₐ");
			put("e", "ₑ");
			put("h", "ₕ");
			put("i", "ᵢ");
			put("j", "ⱼ");
			put("k", "ₖ");
			put("l", "ₗ");
			put("m", "ₘ");
			put("n", "ₙ");
			put("o", "ₒ");
			put("p", "ₚ");
			put("r", "ᵣ");
			put("s", "ₛ");
			put("t", "ₜ");
			put("u", "ᵤ");
			put("v", "ᵥ");
			put("x", "ₓ");
			put(" ", " ");
		}
	};

	// var fractions = {
	// "1/2": "½",
	// "1/3": "⅓",
	// "2/3": "⅔",
	// "1/4": "¼",
	// "3/4": "¾",
	// "1/5": "⅕",
	// "2/5": "⅖",
	// "3/5": "⅗",
	// "4/5": "⅘",
	// "1/6": "⅙",
	// "5/6": "⅚",
	// "1/7": "⅐",
	// "1/8": "⅛",
	// "3/8": "⅜",
	// "5/8": "⅝",
	// "7/8": "⅞",
	// "1/9": "⅑",
	// "1/10": "⅒"
	// };

	public static HashMap<String, String> fractions = new HashMap<String, String>() {
		{
			put("1/2", "½");
			put("1/3", "⅓");
			put("2/3", "⅔");
			put("1/4", "¼");
			put("3/4", "¾");
			put("1/5", "⅕");
			put("2/5", "⅖");
			put("3/5", "⅗");
			put("4/5", "⅘");
			put("1/6", "⅙");
			put("5/6", "⅚");
			put("1/7", "⅐");
			put("1/8", "⅛");
			put("3/8", "⅜");
			put("5/8", "⅝");
			put("7/8", "⅞");
			put("1/9", "⅑");
			put("1/10", "⅒");
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
			simp = reduce(numerator, denominator);
			// System.out.println("reducing " + orig + " to " + simp);
			simpString = map(simp[0], simp[1]);
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
				if (replacement[0].charAt(0) == "⁻".charAt(0)) {
					replacement[0] = Fractions.setCharAt(replacement[0], 0, "-");
				}
				if (replacement[1].charAt(0) == "⁻".charAt(0)) {
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

	public static void main(String[] args) {
		System.out.println(Fractions.replaceFractionsInString("I have 4/3 apples and 2/5 oranges"));
	}
}
