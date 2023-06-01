import dk.sdu.student.stmor21.common.services.IGamePluginService;
import dk.sdu.student.stmor21.common.services.IEntityProcessingService;
import dk.sdu.student.stmor21.commonBullet.BulletSPI;

module Player{
    requires Common;
    requires CommonPlayer;
    requires CommonBullet;

    uses BulletSPI;

    provides IGamePluginService with dk.sdu.student.stmor21.playersystem.PlayerPlugin;
    provides IEntityProcessingService with  dk.sdu.student.stmor21.playersystem.PlayerControlSystem;
}