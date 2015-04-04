import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class _04_SoccerResults {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int numOfPlays = Integer.parseInt(input.nextLine());

		Map<String, Integer[]> goalsMap = new TreeMap<String, Integer[]>();
		Map<String, TreeSet<String>> matchesPlayedMap = new TreeMap<String, TreeSet<String>>();

		for (int i = 0; i < numOfPlays; i++) {
			String currLine = input.nextLine();
			String[] teamInfo = currLine.split("[/:-]+");
			String firstTeam = "\"" + teamInfo[0].trim() + "\"";
			String secondTeam = "\"" + teamInfo[1].trim() + "\"";
			Integer homeGoals = Integer.parseInt(teamInfo[2].trim());
			Integer aweyGoals = Integer.parseInt(teamInfo[3].trim());

			if (goalsMap.containsKey(firstTeam)) {
				Integer[] goals = goalsMap.get(firstTeam);
				if (goals[0] == null) {
					goals[0] = 0;
				}
				if (goals[1] == null) {
					goals[1] = 0;
				}
				goals[0] += homeGoals;
				goals[1] += aweyGoals;
			} else {
				Integer[] goals = new Integer[2];
				goals[0] = homeGoals;
				goals[1] = aweyGoals;
				goalsMap.put(firstTeam, goals);
			}
			if (goalsMap.containsKey(secondTeam)) {
				Integer[] goals = goalsMap.get(secondTeam);
				if (goals[0] == null) {
					goals[0] = 0;
				}
				if (goals[1] == null) {
					goals[1] = 0;
				}
				goals[0] += aweyGoals;
				goals[1] += homeGoals;
			} else {
				Integer[] goals = new Integer[2];
				goals[0] = aweyGoals;
				goals[1] = homeGoals;
				goalsMap.put(secondTeam, goals);
			}

			if (matchesPlayedMap.containsKey(firstTeam)) {
				TreeSet<String> teamSet = matchesPlayedMap.get(firstTeam);
				teamSet.add(secondTeam);
				matchesPlayedMap.put(firstTeam, teamSet);
			} else {
				TreeSet<String> teamSet = new TreeSet<String>();
				teamSet.add(secondTeam);
				matchesPlayedMap.put(firstTeam, teamSet);
			}
			if (matchesPlayedMap.containsKey(secondTeam)) {
				TreeSet<String> teamSet = matchesPlayedMap.get(secondTeam);
				teamSet.add(firstTeam);
				matchesPlayedMap.put(secondTeam, teamSet);
			} else {
				TreeSet<String> teamSet = new TreeSet<String>();
				teamSet.add(firstTeam);
				matchesPlayedMap.put(secondTeam, teamSet);
			}
		}
		System.out.print("{");
		String result = "";
		for (Map.Entry<String, Integer[]> entryGoalSet : goalsMap.entrySet()) {
			Integer goalsScored = entryGoalSet.getValue()[0];
			Integer goalsConceded = entryGoalSet.getValue()[1];

			String teamsAndScores = String
					.format("%s:{\"goalsScored\":%s,\"goalsConceded\":%s,\"matchesPlayedWith\":",
							entryGoalSet.getKey(), goalsScored, goalsConceded);

			String teamsMatches = matchesPlayedMap.get(entryGoalSet.getKey())
					.toString().replaceAll(", ", ",")
					+ "},";

			result += teamsAndScores + teamsMatches;
		}
		result = result.substring(0, result.length() - 1) + "}";
		System.out.println(result);
	}
}
