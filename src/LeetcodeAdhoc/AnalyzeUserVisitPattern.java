package LeetcodeAdhoc;


import java.util.*;

public class AnalyzeUserVisitPattern {
    public static void main(String[] args) {
        String[] username = new String[] {"h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"};
        int[] timestamp = new int[] {527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,
                926837079,317455832,411747930};
        String[] website = new String[] {"hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi",
                "hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"};
        List<String> result = mostVisitedPattern(username, timestamp, website);
        System.out.println(result);
    }

    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // brute force thru
        List<Visit> visits = new ArrayList<>();
        for (int i = 0; i < username.length; i++) {
            visits.add(new Visit(username[i], timestamp[i], website[i]));
        }

        Collections.sort(visits, (a, b) -> a.timestamp - b.timestamp);
        // map users to list of websites they visited
        Map<String, List<String>> userToSiteMap = new HashMap<>();

        for(Visit visit : visits) {
            userToSiteMap.putIfAbsent(visit.username, new ArrayList<>());
            userToSiteMap.get(visit.username).add(visit.website);
        }

        Map<List<String>, Integer> userSiteVisitsFreq = new HashMap<>();

        for (List<String> sites : userToSiteMap.values()) {
            if (sites.size() < 3) continue;
            Set<List<String>> seqOfThree = generateSequenceOfThree(sites);
            for (List<String> seq : seqOfThree) {
                userSiteVisitsFreq.put(seq, userSiteVisitsFreq.getOrDefault(seq, 0) + 1);
            }
        }
        List<String> result = new ArrayList<>();
        int maxVisits = 0;
        for (Map.Entry<List<String>, Integer> entry : userSiteVisitsFreq.entrySet()) {
            if (entry.getValue() > maxVisits) {
                maxVisits = entry.getValue();
                result = entry.getKey();
            } else if (entry.getValue() == maxVisits) {
                if (entry.getKey().toString().compareTo(result.toString()) < 0) {
                    result = entry.getKey();
                }
            }
        }
        return result;
    }

    private static Set<List<String>> generateSequenceOfThree(List<String> websites) {
        Set<List<String>> set = new HashSet<>();
        for (int i = 0; i < websites.size(); i++) {
            for (int j = i + 1; j < websites.size(); j++) {
                for (int k = j + 1; k < websites.size(); k++) {
                    List<String> seq = new ArrayList<>();
                    seq.add(websites.get(i));
                    seq.add(websites.get(j));
                    seq.add(websites.get(k));
                    set.add(seq);
                }
            }
        }
        return set;
    }

    static class Visit {
        String username;
        int timestamp;
        String website;

        public Visit(String username, int timestamp, String website) {
            this.username = username;
            this.timestamp = timestamp;
            this.website = website;
        }
    }
}
