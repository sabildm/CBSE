package dk.sdu.sdtudent.stmor21.asteroids;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.student.stmor21.asteroids.AsteroidPlugin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AsteroidControlSystem {
    private GameData gameData;
    private World world;
    private IGamePluginService asteroidPlugin;

    @BeforeEach
    void setup(){
        gameData = new GameData();
        world = new World();
        asteroidPlugin = new AsteroidPlugin();
    }

    @DisplayName("Asteroids are added")

    @Test
    void addAsteroidToWorld(){
        asteroidPlugin.start(gameData,world);
        assertTrue(world.getEntities().stream().collect(Collectors.toList()).toArray().length>=0);
    }
}
