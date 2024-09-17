package ch.teko.bir.jumpdude.Jetpack;

public class JetpackModel {

    private final Jetpack jetpack; 
    private final int groundY;
        
    public JetpackModel(int groundY){
        this.groundY = groundY;
        jetpack = new Jetpack(6000, groundY - 80, 70, 70);
    }

    public Jetpack getJetpack() {
        return jetpack;
    }
}
