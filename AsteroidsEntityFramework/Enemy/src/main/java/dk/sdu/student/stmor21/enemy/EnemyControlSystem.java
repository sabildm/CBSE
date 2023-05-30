package dk.sdu.student.stmor21.enemy;

import dk.sdu.student.stmor21.common.data.Entity;
import dk.sdu.student.stmor21.common.data.GameData;
import dk.sdu.student.stmor21.common.data.World;
import dk.sdu.student.stmor21.common.data.entityparts.LifePart;
import dk.sdu.student.stmor21.common.data.entityparts.MovingPart;
import dk.sdu.student.stmor21.common.data.entityparts.PositionPart;
import dk.sdu.student.stmor21.common.services.IEntityProcessingService;
import dk.sdu.student.stmor21.bullet.BulletControlSystem;

import java.util.Random;

public class EnemyControlSystem implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {

        for (Entity enemy : world.getEntities(Enemy.class)) {
            PositionPart positionPart = enemy.getPart(PositionPart.class);
            MovingPart movingPart = enemy.getPart(MovingPart.class);
            LifePart lifePart = enemy.getPart(LifePart.class);


            Random rand = new Random();
            int random = rand.nextInt(20);

            if (random == 0){
                movingPart.setUp(true);
                movingPart.setRight(false);
                movingPart.setLeft(false);
                BulletControlSystem bullet = new BulletControlSystem();
                world.addEntity(bullet.createBullet(enemy,gameData));
            } else if (random == 1) {
                movingPart.setUp(false);
                movingPart.setRight(true);
                movingPart.setLeft(false);
            } else if (random == 2) {
                movingPart.setUp(false);
                movingPart.setRight(false);
                movingPart.setLeft(true);
            }

            movingPart.process(gameData, enemy);
            positionPart.process(gameData, enemy);
            lifePart.process(gameData, enemy);

            if(lifePart.getLife() <= lifePart.getExpiration()){
                world.removeEntity(enemy);
            }

            updateShape(enemy);
        }
    }

    private void updateShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * 8);
        shapey[0] = (float) (y + Math.sin(radians) * 8);

        shapex[1] = (float) (x + Math.cos(radians - 4 * 3.1415f / 5) * 8);
        shapey[1] = (float) (y + Math.sin(radians - 4 * 3.1145f / 5) * 8);

        shapex[2] = (float) (x + Math.cos(radians + 3.1415f) * 8);
        shapey[2] = (float) (y + Math.sin(radians + 3.1415f) * 8);

        shapex[3] = (float) (x + Math.cos(radians + 4 * 3.1415f / 5) * 8);
        shapey[3] = (float) (y + Math.sin(radians + 4 * 3.1415f / 5) * 8);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }
}
