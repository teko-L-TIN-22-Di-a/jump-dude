package ch.teko.bir.jumpdude.Ground;

import java.awt.Graphics2D;

import ch.teko.bir.jumpdude.ILevelElement;

public class Ground implements ILevelElement {
    private final GroundModel groundModel;

    public Ground(GroundModel model)
    {
        groundModel = model;
    }

    public void draw(Graphics2D graphics2d, int windowWidth)
    {
        graphics2d.setColor(groundModel.getGroundColor());
        graphics2d.fillRect(groundModel.getGroundX(), groundModel.getGroundY(), windowWidth, groundModel.getGroundHeight());
    }
}