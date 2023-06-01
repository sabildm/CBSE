import dk.sdu.student.stmor21.common.services.IGamePluginService;
import dk.sdu.student.stmor21.common.services.IEntityProcessingService;

module Asteroids {
    requires Common;
    requires CommonAsteroids;
    provides IGamePluginService with dk.sdu.student.stmor21.asteroids.AsteroidPlugin;
    provides IEntityProcessingService with dk.sdu.student.stmor21.asteroids.AsteroidControlSystem;
}