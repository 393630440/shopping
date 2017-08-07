package com.tianrui.web.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/** 字符串工具类 */
public class StringUtils {
	private static final String FOLDER_SEPARATOR = "/";

	private static final String WINDOWS_FOLDER_SEPARATOR = "\\";

	private static final String TOP_PATH = "..";

	private static final String CURRENT_PATH = ".";

	private static final String NULL = "null";

	private static final char EXTENSION_SEPARATOR = '.';

	// ---------------------------------------------------------------------
	// General convenience methods for working with Strings
	// ---------------------------------------------------------------------

	public static boolean isEquals(String str1, String str2) {
		return formatString(str1, "").equals(formatString(str2, ""));
	}

	/**
	 * 在字符串source前面添加addstr，直至source的位数等于digit
	 */
	public static String addStrAtFront(String source, String addstr, int digit) {
		source = isNull(source) ? "" : source.trim();
		addstr = isNull(addstr) ? " " : addstr;
		for (int i = source.length(); i < digit; i++) {
			source = addstr + source;
		}
		return source;
	}

	/**
	 * 在字符串source后面添加addstr，直至source的位数等于digit
	 */
	public static String addStrAtBack(String source, String addstr, int digit) {
		source = isNull(source) ? "" : source.trim();
		addstr = isNull(addstr) ? " " : addstr;
		for (int i = source.length(); i < digit; i++) {
			source = source + addstr;
		}
		return source;
	}

	/**
	 * 格式化字符串：如果source为空，返回tag，否则返回source
	 */
	public static String formatString(String source, String tag) {
		if (isNull(source)) {
			return trimWhitespace(tag);
		}
		return trimWhitespace(source);
	}

	/**
	 * 格式化字符串：如果source为空，返回"0"；如果不是数字，返回"0"；返回整数字符串
	 */
	public static String formatInteger(String source) {
		try {
			String rtn = source.replaceAll("\\,", "");
			Long.valueOf(rtn);
			return trimWhitespace(rtn);
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}

	/**
	 * 格式化字符串：如果source为空，返回"0"；如果不是数字，返回"0"；返回浮点型字符串
	 * 
	 * @param source
	 * @return
	 */
	public static String formatDouble(String source) {
		try {
			String rtn = source.replaceAll("\\,", "");
			Double.valueOf(rtn);
			return trimWhitespace(rtn);
		} catch (Exception e) {
			e.printStackTrace();
			return "0.00";
		}
	}

	public static boolean isNull(CharSequence str) {
		return str == null || (str == null || str.toString().trim().length() == 0
				|| str.toString().trim().toLowerCase().equals(NULL));
	}

	public static boolean isNull(String str) {
		return isNull((CharSequence) str);
	}

	public static boolean hasLength(CharSequence str) {
		return !isNull(str);
	}

	public static boolean hasLength(String str) {
		return hasLength((CharSequence) str);
	}

	public static boolean hasText(CharSequence str) {
		if (!hasLength(str))
			return false;

		int strLen = str.length();
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(str.charAt(i)))
				return true;
		}
		return false;
	}

	public static boolean hasText(String str) {
		return hasText((CharSequence) str);
	}

	public static boolean containsWhitespace(CharSequence str) {
		if (!hasLength(str))
			return false;

		int strLen = str.length();
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(str.charAt(i)))
				return true;
		}
		return false;
	}

	public static boolean containsWhitespace(String str) {
		return containsWhitespace((CharSequence) str);
	}

	public static String trimWhitespace(String str) {
		if (!hasLength(str))
			return "";

		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
			sb.deleteCharAt(0);
		}
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	public static String trimAllWhitespace(String str) {
		if (!hasLength(str))
			return str;

		StringBuilder sb = new StringBuilder(str);
		int index = 0;
		while (sb.length() > index) {
			if (Character.isWhitespace(sb.charAt(index)))
				sb.deleteCharAt(index);
			else
				index++;
		}
		return sb.toString();
	}

	public static String trimLeadingWhitespace(String str) {
		if (!hasLength(str))
			return str;

		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

	public static String trimTrailingWhitespace(String str) {
		if (!hasLength(str))
			return str;

		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	public static String trimLeadingCharacter(String str, char leadingCharacter) {
		if (!hasLength(str))
			return str;

		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && sb.charAt(0) == leadingCharacter) {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

	public static String trimTrailingCharacter(String str, char trailingCharacter) {
		if (!hasLength(str))
			return str;

		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && sb.charAt(sb.length() - 1) == trailingCharacter) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	public static boolean startsWithIgnoreCase(String str, String prefix) {
		if (str == null || prefix == null)
			return false;

		if (str.startsWith(prefix))
			return true;

		if (str.length() < prefix.length())
			return false;

		String lcStr = str.substring(0, prefix.length()).toLowerCase();
		String lcPrefix = prefix.toLowerCase();
		return lcStr.equals(lcPrefix);
	}

	public static boolean endsWithIgnoreCase(String str, String suffix) {
		if (str == null || suffix == null)
			return false;

		if (str.endsWith(suffix))
			return true;

		if (str.length() < suffix.length())
			return false;

		String lcStr = str.substring(str.length() - suffix.length()).toLowerCase();
		String lcSuffix = suffix.toLowerCase();
		return lcStr.equals(lcSuffix);
	}

	public static boolean substringMatch(CharSequence str, int index, CharSequence substring) {
		for (int j = 0; j < substring.length(); j++) {
			int i = index + j;
			if (i >= str.length() || str.charAt(i) != substring.charAt(j))
				return false;
		}
		return true;
	}

	public static int countOccurrencesOf(String str, String sub) {
		if (str == null || sub == null || str.length() == 0 || sub.length() == 0)
			return 0;

		int count = 0;
		int pos = 0;
		int idx;
		while ((idx = str.indexOf(sub, pos)) != -1) {
			++count;
			pos = idx + sub.length();
		}
		return count;
	}

	public static String replace(String inString, String oldPattern, String newPattern) {
		if (!hasLength(inString) || !hasLength(oldPattern) || newPattern == null)
			return inString;

		StringBuilder sb = new StringBuilder();
		int pos = 0; // our position in the old string
		int index = inString.indexOf(oldPattern);
		// the index of an occurrence we've found, or -1
		int patLen = oldPattern.length();
		while (index >= 0) {
			sb.append(inString.substring(pos, index));
			sb.append(newPattern);
			pos = index + patLen;
			index = inString.indexOf(oldPattern, pos);
		}
		sb.append(inString.substring(pos));
		// remember to append any characters to the right of a match
		return sb.toString();
	}

	public static String delete(String inString, String pattern) {
		return replace(inString, pattern, "");
	}

	public static String deleteAny(String inString, String charsToDelete) {
		if (!hasLength(inString) || !hasLength(charsToDelete))
			return inString;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < inString.length(); i++) {
			char c = inString.charAt(i);
			if (charsToDelete.indexOf(c) == -1)
				sb.append(c);
		}
		return sb.toString();
	}

	// ---------------------------------------------------------------------
	// Convenience methods for working with formatted Strings
	// ---------------------------------------------------------------------

	public static String quote(String str) {
		return (str != null ? "'" + str + "'" : null);
	}

	public static Object quoteIfString(Object obj) {
		return (obj instanceof String ? quote((String) obj) : obj);
	}

	public static String unqualify(String qualifiedName) {
		return unqualify(qualifiedName, '.');
	}

	public static String unqualify(String qualifiedName, char separator) {
		return qualifiedName.substring(qualifiedName.lastIndexOf(separator) + 1);
	}

	public static String capitalize(String str) {
		return changeFirstCharacterCase(str, true);
	}

	public static String uncapitalize(String str) {
		return changeFirstCharacterCase(str, false);
	}

	private static String changeFirstCharacterCase(String str, boolean capitalize) {
		if (str == null || str.length() == 0)
			return str;

		StringBuilder sb = new StringBuilder(str.length());
		if (capitalize)
			sb.append(Character.toUpperCase(str.charAt(0)));
		else
			sb.append(Character.toLowerCase(str.charAt(0)));

		sb.append(str.substring(1));
		return sb.toString();
	}

	public static String getFilename(String path) {
		if (path == null)
			return null;

		int separatorIndex = path.lastIndexOf(FOLDER_SEPARATOR);
		return (separatorIndex != -1 ? path.substring(separatorIndex + 1) : path);
	}

	public static String getFilenameExtension(String path) {
		if (path == null)
			return null;

		int sepIndex = path.lastIndexOf(EXTENSION_SEPARATOR);
		return (sepIndex != -1 ? path.substring(sepIndex + 1) : null);
	}

	public static String stripFilenameExtension(String path) {
		if (path == null)
			return null;

		int sepIndex = path.lastIndexOf(EXTENSION_SEPARATOR);
		return (sepIndex != -1 ? path.substring(0, sepIndex) : path);
	}

	public static String applyRelativePath(String path, String relativePath) {
		int separatorIndex = path.lastIndexOf(FOLDER_SEPARATOR);
		if (separatorIndex != -1) {
			String newPath = path.substring(0, separatorIndex);
			if (!relativePath.startsWith(FOLDER_SEPARATOR)) {
				newPath += FOLDER_SEPARATOR;
			}
			return newPath + relativePath;
		} else {
			return relativePath;
		}
	}

	public static String cleanPath(String path) {
		if (path == null)
			return null;

		String pathToUse = replace(path, WINDOWS_FOLDER_SEPARATOR, FOLDER_SEPARATOR);

		// Strip prefix from path to analyze, to not treat it as part of the
		// first path element. This is necessary to correctly parse paths like
		// "file:core/../core/io/Resource.class", where the ".." should just
		// strip the first "core" directory while keeping the "file:" prefix.
		int prefixIndex = pathToUse.indexOf(":");
		String prefix = "";
		if (prefixIndex != -1) {
			prefix = pathToUse.substring(0, prefixIndex + 1);
			pathToUse = pathToUse.substring(prefixIndex + 1);
		}
		if (pathToUse.startsWith(FOLDER_SEPARATOR)) {
			prefix = prefix + FOLDER_SEPARATOR;
			pathToUse = pathToUse.substring(1);
		}

		String[] pathArray = delimitedListToStringArray(pathToUse, FOLDER_SEPARATOR);
		List<String> pathElements = new LinkedList<String>();
		int tops = 0;

		for (int i = pathArray.length - 1; i >= 0; i--) {
			String element = pathArray[i];
			if (CURRENT_PATH.equals(element)) {
				// Points to current directory - drop it.
			} else if (TOP_PATH.equals(element)) {
				// Registering top path found.
				tops++;
			} else {
				if (tops > 0) {
					// Merging path element with element corresponding to top
					// path.
					tops--;
				} else {
					// Normal path element found.
					pathElements.add(0, element);
				}
			}
		}

		// Remaining top paths need to be retained.
		for (int i = 0; i < tops; i++) {
			pathElements.add(0, TOP_PATH);
		}

		return prefix + collectionToDelimitedString(pathElements, FOLDER_SEPARATOR);
	}

	public static boolean pathEquals(String path1, String path2) {
		return cleanPath(path1).equals(cleanPath(path2));
	}

	public static Locale parseLocaleString(String localeString) {
		String[] parts = tokenizeToStringArray(localeString, "_ ", false, false);
		String language = (parts.length > 0 ? parts[0] : "");
		String country = (parts.length > 1 ? parts[1] : "");
		String variant = "";
		if (parts.length >= 2) {
			// There is definitely a variant, and it is everything after the
			// country
			// code sans the separator between the country code and the variant.
			int endIndexOfCountryCode = localeString.indexOf(country) + country.length();
			// Strip off any leading '_' and whitespace, what's left is the
			// variant.
			variant = trimLeadingWhitespace(localeString.substring(endIndexOfCountryCode));
			if (variant.startsWith("_"))
				variant = trimLeadingCharacter(variant, '_');
		}
		return (language.length() > 0 ? new Locale(language, country, variant) : null);
	}

	public static String toLanguageTag(Locale locale) {
		return locale.getLanguage() + (hasText(locale.getCountry()) ? "-" + locale.getCountry() : "");
	}

	// ---------------------------------------------------------------------
	// Convenience methods for working with String arrays
	// ---------------------------------------------------------------------

	public static String[] addStringToArray(String[] array, String str) {
		if (ObjectUtils.isEmpty(array))
			return new String[] { str };

		String[] newArr = new String[array.length + 1];
		System.arraycopy(array, 0, newArr, 0, array.length);
		newArr[array.length] = str;
		return newArr;
	}

	public static String[] concatenateStringArrays(String[] array1, String[] array2) {
		if (ObjectUtils.isEmpty(array1))
			return array2;

		if (ObjectUtils.isEmpty(array2))
			return array1;

		String[] newArr = new String[array1.length + array2.length];
		System.arraycopy(array1, 0, newArr, 0, array1.length);
		System.arraycopy(array2, 0, newArr, array1.length, array2.length);
		return newArr;
	}

	public static String[] mergeStringArrays(String[] array1, String[] array2) {
		if (ObjectUtils.isEmpty(array1))
			return array2;

		if (ObjectUtils.isEmpty(array2))
			return array1;

		List<String> result = new ArrayList<String>();
		result.addAll(Arrays.asList(array1));
		for (String str : array2) {
			if (!result.contains(str))
				result.add(str);
		}
		return toStringArray(result);
	}

	public static String[] sortStringArray(String[] array) {
		if (ObjectUtils.isEmpty(array))
			return new String[0];

		Arrays.sort(array);
		return array;
	}

	public static String[] toStringArray(Collection<String> collection) {
		if (collection == null)
			return null;

		return collection.toArray(new String[collection.size()]);
	}

	public static String[] toStringArray(Enumeration<String> enumeration) {
		if (enumeration == null)
			return null;

		List<String> list = Collections.list(enumeration);
		return list.toArray(new String[list.size()]);
	}

	public static String[] trimArrayElements(String[] array) {
		if (ObjectUtils.isEmpty(array))
			return new String[0];

		String[] result = new String[array.length];
		for (int i = 0; i < array.length; i++) {
			String element = array[i];
			result[i] = (element != null ? element.trim() : null);
		}
		return result;
	}

	public static String[] removeDuplicateStrings(String[] array) {
		if (ObjectUtils.isEmpty(array))
			return array;

		Set<String> set = new TreeSet<String>();
		for (String element : array) {
			set.add(element);
		}
		return toStringArray(set);
	}

	public static String[] split(String toSplit, String delimiter) {
		if (!hasLength(toSplit) || !hasLength(delimiter))
			return null;

		int offset = toSplit.indexOf(delimiter);
		if (offset < 0)
			return null;

		String beforeDelimiter = toSplit.substring(0, offset);
		String afterDelimiter = toSplit.substring(offset + delimiter.length());
		return new String[] { beforeDelimiter, afterDelimiter };
	}

	public static Properties splitArrayElementsIntoProperties(String[] array, String delimiter) {
		return splitArrayElementsIntoProperties(array, delimiter, null);
	}

	public static Properties splitArrayElementsIntoProperties(String[] array, String delimiter, String charsToDelete) {
		if (ObjectUtils.isEmpty(array))
			return null;

		Properties result = new Properties();
		for (String element : array) {
			if (charsToDelete != null)
				element = deleteAny(element, charsToDelete);

			String[] splittedElement = split(element, delimiter);
			if (splittedElement == null)
				continue;

			result.setProperty(splittedElement[0].trim(), splittedElement[1].trim());
		}
		return result;
	}

	public static String[] tokenizeToStringArray(String str, String delimiters) {
		return tokenizeToStringArray(str, delimiters, true, true);
	}

	public static String[] tokenizeToStringArray(String str, String delimiters, boolean trimTokens,
			boolean ignoreEmptyTokens) {
		if (str == null)
			return null;

		StringTokenizer st = new StringTokenizer(str, delimiters);
		List<String> tokens = new ArrayList<String>();
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (trimTokens)
				token = token.trim();
			if (!ignoreEmptyTokens || token.length() > 0)
				tokens.add(token);
		}
		return toStringArray(tokens);
	}

	public static String[] delimitedListToStringArray(String str, String delimiter) {
		return delimitedListToStringArray(str, delimiter, null);
	}

	public static String[] delimitedListToStringArray(String str, String delimiter, String charsToDelete) {
		if (str == null)
			return new String[0];

		if (delimiter == null)
			return new String[] { str };

		List<String> result = new ArrayList<String>();
		if ("".equals(delimiter)) {
			for (int i = 0; i < str.length(); i++) {
				result.add(deleteAny(str.substring(i, i + 1), charsToDelete));
			}
		} else {
			int pos = 0;
			int delPos;
			while ((delPos = str.indexOf(delimiter, pos)) != -1) {
				result.add(deleteAny(str.substring(pos, delPos), charsToDelete));
				pos = delPos + delimiter.length();
			}
			if (str.length() > 0 && pos <= str.length()) {
				// Add rest of String, but not in case of empty input.
				result.add(deleteAny(str.substring(pos), charsToDelete));
			}
		}
		return toStringArray(result);
	}

	public static String[] commaDelimitedListToStringArray(String str) {
		return delimitedListToStringArray(str, ",");
	}

	public static Set<String> commaDelimitedListToSet(String str) {
		Set<String> set = new TreeSet<String>();
		String[] tokens = commaDelimitedListToStringArray(str);
		for (String token : tokens) {
			set.add(token);
		}
		return set;
	}

	public static String collectionToDelimitedString(Collection<String> coll, String delim, String prefix,
			String suffix) {
		if (CollectionUtils.isEmpty(coll))
			return "";

		StringBuilder sb = new StringBuilder();
		Iterator<String> it = coll.iterator();
		while (it.hasNext()) {
			sb.append(prefix).append(it.next()).append(suffix);
			if (it.hasNext())
				sb.append(delim);
		}
		return sb.toString();
	}

	public static String collectionToDelimitedString(Collection<String> coll, String delim) {
		return collectionToDelimitedString(coll, delim, "", "");
	}

	public static String collectionToCommaDelimitedString(Collection<String> coll) {
		return collectionToDelimitedString(coll, ",");
	}

	public static String arrayToDelimitedString(Object[] arr, String delim) {
		if (ObjectUtils.isEmpty(arr))
			return "";

		if (arr.length == 1)
			return ObjectUtils.nullSafeToString(arr[0]);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (i > 0)
				sb.append(delim);
			sb.append(arr[i]);
		}
		return sb.toString();
	}

	public static String arrayToCommaDelimitedString(Object[] arr) {
		return arrayToDelimitedString(arr, ",");
	}

	public static String selectInSplit(String[] paramArrayOfString) {
		if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
			return null;

		String str1 = "";
		for (int i = 0; i < paramArrayOfString.length; ++i)
			if (paramArrayOfString[i] != null) {
				String str2 = String.valueOf(paramArrayOfString[i]);
				if (str2.trim().length() == 0)
					break;
				str1 = str1 + "'" + str2.trim() + "',";
			}
		if (str1.length() == 0)
			return null;
		str1 = "(" + str1.substring(0, str1.length() - 1) + ")";
		return str1;
	}

	public static boolean notEmpty(String str) {
		return str != null && !"".equals(str) && !"null".equals(str);
	}

	public static boolean isEmpty(String str) {
		return str == null || "".equals(str) || "null".equals(str);
	}

}