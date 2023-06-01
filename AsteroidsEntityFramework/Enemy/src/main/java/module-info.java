import dk.sdu.student.stmor21.common.services.IGamePluginService;
import dk.sdu.student.stmor21.common.services.IEntityProcessingService;
import dk.sdu.student.stmor21.bullet.BulletControlSystem;

module Enemy{
    requires Common;
    requires CommonEnemy;
    requires CommonBullet;
    requires Bullet;


    provides IGamePluginService with dk.sdu.student.stmor21.enemy.EnemyPlugin;
    provides IEntityProcessingService with dk.sdu.student.stmor21.enemy.EnemyControlSystem;
}