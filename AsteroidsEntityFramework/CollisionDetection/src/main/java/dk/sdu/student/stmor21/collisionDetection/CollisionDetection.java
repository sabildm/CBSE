package dk.sdu.student.stmor21.collisionDetection;
import dk.sdu.student.stmor21.common.data.Entity;
import dk.sdu.student.stmor21.common.data.GameData;
import dk.sdu.student.stmor21.common.data.World;
import dk.sdu.student.stmor21.common.data.entityparts.LifePart;
import dk.sdu.student.stmor21.common.data.entityparts.PositionPart;
import dk.sdu.student.stmor21.common.services.IPostEntityProcessingService;

public class CollisionDetection implements IPostEntityProcessingService{
    @Override
    public void process(GameData gameData, World world) {
        for (Entity entity : world.getEntities()){
            for (Entity collisionDetection : world.getEntities()){
                LifePart entityLife = entity.getPart(LifePart.class);

                if (entity.getID().equals(collisionDetection.getID())) {
                    continue;

                }

                // CollisionDetection
                if (this.collition(entity, collisionDetection)) {
                    // if entity has been hit, and should have its life reduced
                    if (entityLife.getLife() > 0) {
                        entityLife.setLife(entityLife.getLife() - 1);
                        entityLife.setIsHit(true);
                        // if entity is out of life - remove
                        if (entityLife.getLife() <= 0) {
                            world.removeEntity(entity);
                        }
                    }
                }
            }
        }
    }

    public Boolean collition(Entity entity1, Entity entity2) {
        PositionPart ent1 = entity1.getPart(PositionPart.class);
        PositionPart ent2 = entity2.getPart(PositionPart.class);

        float dx = ent1.getX() - ent2.getX();
        float dy = ent1.getY() - ent2.getY();

        float dist = (float) Math.sqrt(dx * dx + dy * dy);

        if (dist < (entity1.getRadius() + entity2.getRadius())) {
            return true;
        }
        return false;
    }

}

