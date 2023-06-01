package dk.sdu.student.stmor21.asteroids;

import dk.sdu.student.stmor21.common.data.Entity;
import dk.sdu.student.stmor21.common.data.GameData;
import dk.sdu.student.stmor21.common.data.World;
import dk.sdu.student.stmor21.common.data.entityparts.LifePart;
import dk.sdu.student.stmor21.common.data.entityparts.MovingPart;
import dk.sdu.student.stmor21.common.data.entityparts.PositionPart;
import dk.sdu.student.stmor21.common.services.IEntityProcessingService;
import dk.sdu.student.stmor21.commonAsteroids.Asteroid;

import java.util.Random;

public class AsteroidControlSystem implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {

        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            PositionPart positionPart = asteroid.getPart(PositionPart.class);
            MovingPart movingPart = asteroid.getPart(MovingPart.class);
            LifePart lifePart = asteroid.getPart(LifePart.class);
            AsteroidPlugin asteroidPlugin = new AsteroidPlugin();

            Random rand = new Random();
            int random = rand.nextInt(20);

            if (random == 0){
                movingPart.setUp(true);
                movingPart.setRight(false);
                movingPart.setLeft(false);
            } else if (random == 1) {
                movingPart.setUp(false);
                movingPart.setRight(true);
                movingPart.setLeft(false);
            } else if (random == 2) {
                movingPart.setUp(false);
                movingPart.setRight(false);
                movingPart.setLeft(true);
            }

            movingPart.process(gameData, asteroid);
            positionPart.process(gameData, asteroid);
            lifePart.process(gameData,asteroid);

            if(lifePart.isIsHit()){
                asteroidPlugin.createSplitAsteroid(asteroid,gameData,world);
            }
            updateShape(asteroid);
        }
    }

    public void updateShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();
        float radius = entity.getRadius();

        shapex[0] = (float) (x + Math.cos(radians) * radius);
        shapey[0] = (float) (y + Math.sin(radians) * radius);

        shapex[1] = (float) (x + Math.cos(radians - 3.1415f / 5) * radius);
        shapey[1] = (float) (y + Math.sin(radians - 3.1145f / 5) * radius);

        shapex[2] = (float) (x + Math.cos(radians + 3.1415f) * radius);
        shapey[2] = (float) (y + Math.sin(radians + 3.1415f) * radius);

        shapex[3] = (float) (x + Math.cos(radians + 4 * 3.1415f / 5) * radius);
        shapey[3] = (float) (y + Math.sin(radians + 4 * 3.1415f / 5) * radius);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);


    }
}
