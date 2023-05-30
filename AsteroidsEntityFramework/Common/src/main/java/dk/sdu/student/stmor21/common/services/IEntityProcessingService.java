package dk.sdu.student.stmor21.common.services;

import dk.sdu.student.stmor21.common.data.GameData;
import dk.sdu.student.stmor21.common.data.World;

public interface IEntityProcessingService {

    void process(GameData gameData, World world);
}
