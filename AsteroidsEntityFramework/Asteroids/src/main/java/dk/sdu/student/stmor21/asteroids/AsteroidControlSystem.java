package dk.sdu.student.stmor21.asteroids;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Random;

public class AsteroidControlSystem implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {

        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            PositionPart positionPart = asteroid.getPart(PositionPart.class);
            MovingPart movingPart = asteroid.getPart(MovingPart.class);


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

            updateShape(asteroid);
        }
    }

    private void updateShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * 20);
        shapey[0] = (float) (y + Math.sin(radians) * 20);

        shapex[1] = (float) (x + Math.cos(radians - 3.1415f / 5) * 20);
        shapey[1] = (float) (y + Math.sin(radians - 3.1145f / 5) * 20);

        shapex[2] = (float) (x + Math.cos(radians + 3.1415f) * 20);
        shapey[2] = (float) (y + Math.sin(radians + 3.1415f) * 20);

        shapex[3] = (float) (x + Math.cos(radians + 4 * 3.1415f / 5) * 20);
        shapey[3] = (float) (y + Math.sin(radians + 4 * 3.1415f / 5) * 20);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }
}
