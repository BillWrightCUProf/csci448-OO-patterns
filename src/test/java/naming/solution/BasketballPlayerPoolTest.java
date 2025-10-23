package naming.solution;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BasketballPlayerPoolTest {

    Integer NUMBER_OF_PLAYERS_ON_A_BASKETBALL_TEAM = 5;

    @Test
    void testTeamCreation() {
        naming.solution.BasketballPlayerPool playerPool = new naming.solution.BasketballPlayerPool();
        List<String> homeTeam = playerPool.selectPlayers(NUMBER_OF_PLAYERS_ON_A_BASKETBALL_TEAM);
        List<String> awayTeam = playerPool.selectPlayers(NUMBER_OF_PLAYERS_ON_A_BASKETBALL_TEAM);
        System.out.println(homeTeam);
        System.out.println(awayTeam);
    }
}