package dk.sdu.student.stmor21.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.student.stmor21.commonBullet.Bullet;
import dk.sdu.student.stmor21.commonBullet.BulletSPI;

public class BulletPlugin implements IGamePluginService {
    private Entity bullet;

    public void bulletPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {

    }


    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(bullet);
    }
}
