import vn.medianews.*;
import java.util.*;
import java.util.stream.Collectors;

public class SapXepChuoiSoLuongNguyenAm {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN699", qCode = "erxWJr6S";

        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();

        // a) lấy dữ liệu
        List<String> input = port.requestStringArray(msv, qCode);
        if (input == null) input = Collections.emptyList();

        // b) gom nhóm theo số nguyên âm, nhóm sắp theo count tăng dần
        Map<Integer, List<String>> groups = new TreeMap<>();
        for (String raw : input) {
            String s = raw == null ? "" : raw.trim();
            int k = countVowels(s);
            groups.computeIfAbsent(k, _k -> new ArrayList<>()).add(s);
        }
        // sort trong từng nhóm theo thứ tự TỰ NHIÊN của String (case-sensitive)
        for (List<String> g : groups.values()) {
            Collections.sort(g); // <-- quan trọng
        }

        // tạo List<String> kết quả: "từ1, từ2, ..."
        List<String> result = groups.values().stream()
                .map(list -> String.join(", ", list))
                .collect(Collectors.toList());

        // c) submit
        port.submitCharacterStringArray(msv, qCode, result);

        System.out.println("Input   : " + input);
        System.out.println("Submit  : " + result);
    }

    private static int countVowels(String s) {
        if (s == null) return 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') cnt++;
        }
        return cnt;
    }
}
