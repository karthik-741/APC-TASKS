import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    // Map to store customer check-in details: id -> CheckInInfo(stationName, time)
    private Map<Integer, CheckInInfo> checkIns;
    
    // Map to store route stats: "startStation->endStation" -> RouteData(totalTime, totalTrips)
    private Map<String, RouteData> routeStats;

    // Helper class for check-in records
    private static class CheckInInfo {
        String stationName;
        int time;

        CheckInInfo(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    // Helper class for aggregate trip metrics
    private static class RouteData {
        double totalTime;
        int totalTrips;

        RouteData(double totalTime, int totalTrips) {
            this.totalTime = totalTime;
            this.totalTrips = totalTrips;
        }
    }

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routeStats = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkIns.remove(id); // remove check-in record when checking out
        String routeKey = info.stationName + "->" + stationName;
        int tripDuration = t - info.time;

        RouteData stats = routeStats.getOrDefault(routeKey, new RouteData(0, 0));
        stats.totalTime += tripDuration;
        stats.totalTrips += 1;
        
        routeStats.put(routeKey, stats);
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteData stats = routeStats.get(routeKey);
        return stats.totalTime / stats.totalTrips;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */