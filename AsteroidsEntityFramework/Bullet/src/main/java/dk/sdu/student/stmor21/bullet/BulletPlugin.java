package dk.sdu.student.stmor21.bullet;

import dk.sdu.student.stmor21.common.data.Entity;
import dk.sdu.student.stmor21.common.data.GameData;
import dk.sdu.student.stmor21.common.data.World;
import dk.sdu.student.stmor21.common.services.IGamePluginService;

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
