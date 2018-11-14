import java.util.HashMap;import java.util.Map;public class abc {    private static String[] str1 = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};    private static String[] str2 = {"", "十", "百", "千"};    static Map<Long, String> testNums = new HashMap<>();    static {        testNums.put(3L, "三");        testNums.put(13L, "十三");        testNums.put(113L, "一百一十三");        testNums.put(30L, "三十");        testNums.put(300L, "三百");        testNums.put(3000L, "三千");        testNums.put(3003L, "三千零三");        testNums.put(111122223333L, "一千一百一十一亿二千二百二十二万三千三百三十三");        testNums.put(100020003000L, "一千亿二千万三千");        testNums.put(100020000300L, "一千亿二千万零三百");        testNums.put(100002000300L, "一千亿零二百万零三百");        testNums.put(111022203303L, "一千一百一十亿二千二百二十万三千三百零三");        testNums.put(10000000001L,"一百亿零一");        testNums.put(10000000101L,"一百亿零一百零一");        testNums.put(10000001001L,"一百亿零一千零一");        testNums.put(10000010001L,"一百亿零一万零一");        testNums.put(10000100001L,"一百亿零一十万零一");        testNums.put(10001000001L,"一百亿零一百万零一");        testNums.put(10010000001L,"一百亿零一千万零一");        testNums.put(10100000001L,"一百零一亿零一");        testNums.put(11000000001L,"一百一十亿零一");    }    public static void main(String[] args) {        int errorCount = 0;        int okCount = 0;        for (Map.Entry<Long, String> entrySet : testNums.entrySet()) {            String result = numToChinese(entrySet.getKey());            String expectResult = entrySet.getValue();            if (!expectResult.equals(result)) {                errorCount++;                System.out.println("<<<-----------------------------");                System.out.println("输入：" + entrySet.getKey());                System.out.println("预期：" + entrySet.getValue());                System.out.println("返回：" + result);                System.out.println("----------------------------->>>");            } else {                okCount++;            }        }        System.out.println("处理完毕，错误个数为" + errorCount);        System.out.println("处理完毕，正确个数为" + okCount);    }    private static String numToChinese(Long inputNum) {        int index = 0;        StringBuffer sb = new StringBuffer();        int num;        while (inputNum != 0) {            num = (int)(inputNum % 10);            if (num >= 0) {                String chineseForOneNum = str1[num];                if (index < 4) {                    sb.insert(0, chineseForOneNum);                    if (num != 0) {                        sb.insert(1, str2[index]);                    }                    index++;                } else if (index >= 4 && index < 8) {                    sb.insert(0, chineseForOneNum);                    if (num != 0) {                        sb.insert(1, str2[index % 4]);                    } else {                    }                    index++;                    if (!sb.toString().contains("万")) {                        sb.insert(1, "万");                    }                } else if (index >= 8 && index < 12) {                    sb.insert(0, chineseForOneNum);                    if (num != 0) {                        sb.insert(1, str2[index % 8]);                    }                    index++;                    if (!sb.toString().contains("亿")) {                        sb.insert(1, "亿");                    }                }                inputNum = inputNum / 10;            } else {                break;            }        }        String res = sb.toString();        while (res.contains("零零")) {            res = res.replace("零零", "零");        }        res = res.replace("零亿", "亿");        res = res.replace("零万", "万");        res = res.replace("亿万", "亿零");        res = res.replace("零零", "零");        if (res.endsWith("零")) {            res = res.substring(0, res.length() - 1);        }        if (res.startsWith("一十")) {            res = res.substring(1);        }        return res;    }}