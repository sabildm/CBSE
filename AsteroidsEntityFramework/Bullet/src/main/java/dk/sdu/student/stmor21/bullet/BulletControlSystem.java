package dk.sdu.student.stmor21.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Random;

public class BulletControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity bullet : world.getEntities(Bullet.class)) {
            PositionPart positionPart = bullet.getPart(PositionPart.class);
            MovingPart movingPart = bullet.getPart(MovingPart.class);
            LifePart lifePart = bullet.getPart(LifePart.class);
            lifePart.reduceExpiration(gameData.getDelta());

            movingPart.setUp(true);

            movingPart.process(gameData, bullet);
            positionPart.process(gameData, bullet);
            lifePart.process(gameData, bullet);

            if (lifePart.getExpiration() <= 0 ) {
                world.removeEntity(bullet);
            }


            updateShape(bullet);
        }
    }

    private void updateShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * 3);
        shapey[0] = (float) (y + Math.sin(radians) * 3);

        shapex[1] = (float) (x + Math.cos(radians - 4 * 3.1415f / 5) * 3);
        shapey[1] = (float) (y + Math.sin(radians - 4 * 3.1145f / 5) * 3);

        shapex[2] = (float) (x + Math.cos(radians + 3.1415f) * 3);
        shapey[2] = (float) (y + Math.sin(radians + 3.1415f) * 3);

        shapex[3] = (float) (x + Math.cos(radians + 4 * 3.1415f / 5) * 3);
        shapey[3] = (float) (y + Math.sin(radians + 4 * 3.1415f / 5) * 3);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }
}
