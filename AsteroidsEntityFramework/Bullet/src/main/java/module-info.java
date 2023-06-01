import dk.sdu.student.stmor21.common.services.IEntityProcessingService;
import dk.sdu.student.stmor21.common.services.IGamePluginService;
import dk.sdu.student.stmor21.commonBullet.BulletSPI;

module Bullet {

    requires Common;
    requires CommonBullet;
    provides IGamePluginService with dk.sdu.student.stmor21.bullet.BulletPlugin;
    provides IEntityProcessingService with dk.sdu.student.stmor21.bullet.BulletControlSystem;
    provides BulletSPI with dk.sdu.student.stmor21.bullet.BulletControlSystem;

    exports dk.sdu.student.stmor21.bullet;
}