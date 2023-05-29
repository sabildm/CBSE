package dk.sdu.student.stmor21.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class BulletPlugin implements IGamePluginService {
    private Entity bullet;

    public void bulletPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {

    }

    public Entity createBullet(Entity shooter, GameData gameData) {
        PositionPart shooterPosition = shooter.getPart(PositionPart.class);

        float deacceleration = 10;
        float acceleration = 400;
        float maxSpeed = 400;
        float rotationSpeed = 5;
        float x = shooterPosition.getX();
        float y = shooterPosition.getY();
        float radians = shooterPosition.getRadians();

        Entity bullet = new Bullet();
        bullet.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        bullet.add(new PositionPart(x, y, radians));
        bullet.add(new LifePart(1,1));


        return bullet;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(bullet);
    }
}
