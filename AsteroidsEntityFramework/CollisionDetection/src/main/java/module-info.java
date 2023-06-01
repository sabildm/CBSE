import dk.sdu.student.stmor21.common.services.IPostEntityProcessingService;

module CollisionDetection {
    requires Common;
    provides IPostEntityProcessingService with dk.sdu.student.stmor21.collisionDetection.CollisionDetection;
}