/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Greg
 */
public class ImageUtilities {

    public static BufferedImage HERO;
    public static BufferedImage HERO_IDLE_1;
    public static BufferedImage HERO_IDLE_2;
    public static BufferedImage HERO_SHOOTING;
    public static BufferedImage HERO_WALK_1;
    public static BufferedImage HERO_WALK_2;

    public static BufferedImage ENEMY_RIFLE;
    public static BufferedImage ENEMY_RIFLE_IDLE_1;
    public static BufferedImage ENEMY_RIFLE_IDLE_2;
    public static BufferedImage ENEMY_RIFLE_SHOOTING;
    public static BufferedImage ENEMY_RIFLE_WALK_1;
    public static BufferedImage ENEMY_RIFLE_WALK_2;

    public static BufferedImage ENEMY_FLAMER;
    public static BufferedImage ENEMY_FLAMER_IDLE_1;
    public static BufferedImage ENEMY_FLAMER_IDLE_2;
    public static BufferedImage ENEMY_FLAMER_SHOOTING_1;
    public static BufferedImage ENEMY_FLAMER_SHOOTING_2;
    public static BufferedImage ENEMY_FLAMER_SHOOTING_3;
    public static BufferedImage ENEMY_FLAMER_WALK_1;
    public static BufferedImage ENEMY_FLAMER_WALK_2;
    public static BufferedImage ENEMY_FLAMER_DYING_1;
    public static BufferedImage ENEMY_FLAMER_DYING_2;

    public static BufferedImage ENEMY_SNIPER_IDLE;
    public static BufferedImage ENEMY_SNIPER_SHOOTING;
    public static BufferedImage ENEMY_SNIPER_SHOOTING_1;
    public static BufferedImage ENEMY_SNIPER_SHOOTING_2;
    public static BufferedImage ENEMY_SNIPER_SHOOTING_3;
    
    public static BufferedImage ENEMY_RADIO_IDLE;
    public static BufferedImage ENEMY_RADIO_IDLE_1;
    public static BufferedImage ENEMY_RADIO_IDLE_2;
    public static BufferedImage ENEMY_RADIO_SHOOTING_1;
    public static BufferedImage ENEMY_RADIO_SHOOTING_2;
    public static BufferedImage ENEMY_RADIO_SHOOTING_3;
    public static BufferedImage ENEMY_RADIO_SHOOTING_4;
    
    public static BufferedImage ENEMY_MORTAR;
    public static BufferedImage ENEMY_MORTAR_1;
    public static BufferedImage ENEMY_MORTAR_2;
    public static BufferedImage ENEMY_MORTAR_3;
    public static BufferedImage ENEMY_MORTAR_4;
    public static BufferedImage ENEMY_MORTAR_5;
    public static BufferedImage ENEMY_MORTAR_6;
    public static BufferedImage ENEMY_MORTAR_7;
    public static BufferedImage ENEMY_MORTAR_8;

    public static BufferedImage ENEMY_TANK_BOTTOM;
    public static BufferedImage ENEMY_TANK_TURRET_1;
    public static BufferedImage ENEMY_TANK_TURRET_2;
    public static BufferedImage ENEMY_TANK_TURRET_3;
    public static BufferedImage ENEMY_TANK_TURRET_DYING;
    
    public static BufferedImage FLAMES;
    public static BufferedImage EXPLOSION;
    public static BufferedImage SMOKE;
    public static BufferedImage GROUND_SCAR;
    public static BufferedImage BULLET;
    public static BufferedImage ROCKET;
    public static BufferedImage SNIPER_BULLET;
    public static BufferedImage MORTAR_ROUND;
    public static BufferedImage PLANE;

    public static BufferedImage SANDBAG;
    public static BufferedImage ROCK_1;
    public static BufferedImage ROCK_2;
    public static BufferedImage ROCK_3;
    public static BufferedImage ROCK_4;
    public static BufferedImage TREE_TRUNK;
    public static BufferedImage TREE_LEAVES_1;
    public static BufferedImage TREE_LEAVES_2;
    
    public static BufferedImage PICK_UP_MACHINE_GUN;
    public static BufferedImage PICK_UP_ROCKET_LAUNCHER;
    public static BufferedImage PICK_UP_MED_KIT;

    public static BufferedImage LEVEL_BACKGROUND;

    public ImageUtilities() {
        try {
            HERO = ImageIO.read(getClass().getResource("/Assets/Hero.png"));
            HERO_IDLE_1 = ImageIO.read(getClass().getResource("/Assets/HeroIdle1.png"));
            HERO_IDLE_2 = ImageIO.read(getClass().getResource("/Assets/HeroIdle2.png"));
            HERO_SHOOTING = ImageIO.read(getClass().getResource("/Assets/HeroShooting.png"));
            HERO_WALK_1 = ImageIO.read(getClass().getResource("/Assets/HeroWalk1.png"));
            HERO_WALK_2 = ImageIO.read(getClass().getResource("/Assets/HeroWalk2.png"));

            ENEMY_FLAMER = ImageIO.read(getClass().getResource("/Assets/EnemyFlamer.png"));
            ENEMY_FLAMER_IDLE_1 = ImageIO.read(getClass().getResource("/Assets/EnemyFlamerIdle1.png"));
            ENEMY_FLAMER_IDLE_2 = ImageIO.read(getClass().getResource("/Assets/EnemyFlamerIdle2.png"));
            ENEMY_FLAMER_SHOOTING_1 = ImageIO.read(getClass().getResource("/Assets/EnemyFlamerShooting1.png"));
            ENEMY_FLAMER_SHOOTING_2 = ImageIO.read(getClass().getResource("/Assets/EnemyFlamerShooting2.png"));
            ENEMY_FLAMER_SHOOTING_3 = ImageIO.read(getClass().getResource("/Assets/EnemyFlamerShooting3.png"));
            ENEMY_FLAMER_WALK_1 = ImageIO.read(getClass().getResource("/Assets/EnemyFlamerWalk1.png"));
            ENEMY_FLAMER_WALK_2 = ImageIO.read(getClass().getResource("/Assets/EnemyFlamerWalk2.png"));
            ENEMY_FLAMER_DYING_1 = ImageIO.read(getClass().getResource("/Assets/EnemyFlamerDying1.png"));
            ENEMY_FLAMER_DYING_2 = ImageIO.read(getClass().getResource("/Assets/EnemyFlamerDying2.png"));

            ENEMY_RIFLE = ImageIO.read(getClass().getResource("/Assets/EnemyRifle.png"));
            ENEMY_RIFLE_IDLE_1 = ImageIO.read(getClass().getResource("/Assets/EnemyRifleIdle1.png"));
            ENEMY_RIFLE_IDLE_2 = ImageIO.read(getClass().getResource("/Assets/EnemyRifleIdle2.png"));
            ENEMY_RIFLE_SHOOTING = ImageIO.read(getClass().getResource("/Assets/EnemyRifleShooting.png"));
            ENEMY_RIFLE_WALK_1 = ImageIO.read(getClass().getResource("/Assets/EnemyRifleWalk1.png"));
            ENEMY_RIFLE_WALK_2 = ImageIO.read(getClass().getResource("/Assets/EnemyRifleWalk2.png"));

            ENEMY_MORTAR = ImageIO.read(getClass().getResource("/Assets/EnemyMortar.png"));
            ENEMY_MORTAR_1 = ImageIO.read(getClass().getResource("/Assets/EnemyMortar1.png"));
            ENEMY_MORTAR_2 = ImageIO.read(getClass().getResource("/Assets/EnemyMortar2.png"));
            ENEMY_MORTAR_3 = ImageIO.read(getClass().getResource("/Assets/EnemyMortar3.png"));
            ENEMY_MORTAR_4 = ImageIO.read(getClass().getResource("/Assets/EnemyMortar4.png"));
            ENEMY_MORTAR_5 = ImageIO.read(getClass().getResource("/Assets/EnemyMortar5.png"));
            ENEMY_MORTAR_6 = ImageIO.read(getClass().getResource("/Assets/EnemyMortar6.png"));
            ENEMY_MORTAR_7 = ImageIO.read(getClass().getResource("/Assets/EnemyMortar7.png"));
            ENEMY_MORTAR_8 = ImageIO.read(getClass().getResource("/Assets/EnemyMortar8.png"));

            ENEMY_SNIPER_IDLE = ImageIO.read(getClass().getResource("/Assets/EnemySniper.png"));
            ENEMY_SNIPER_SHOOTING = ImageIO.read(getClass().getResource("/Assets/EnemySniperShooting.png"));
            ENEMY_SNIPER_SHOOTING_1 = ImageIO.read(getClass().getResource("/Assets/EnemySniperShooting1.png"));
            ENEMY_SNIPER_SHOOTING_2 = ImageIO.read(getClass().getResource("/Assets/EnemySniperShooting2.png"));
            ENEMY_SNIPER_SHOOTING_3 = ImageIO.read(getClass().getResource("/Assets/EnemySniperShooting3.png"));
            
            ENEMY_RADIO_IDLE = ImageIO.read(getClass().getResource("/Assets/RadioEnemy.png"));
            ENEMY_RADIO_IDLE_1 = ImageIO.read(getClass().getResource("/Assets/RadioEnemy1.png"));
            ENEMY_RADIO_IDLE_2 = ImageIO.read(getClass().getResource("/Assets/RadioEnemy3.png"));
            ENEMY_RADIO_SHOOTING_1 = ImageIO.read(getClass().getResource("/Assets/RadioEnemyShooting1.png"));
            ENEMY_RADIO_SHOOTING_2 = ImageIO.read(getClass().getResource("/Assets/RadioEnemyShooting2.png"));
            ENEMY_RADIO_SHOOTING_3 = ImageIO.read(getClass().getResource("/Assets/RadioEnemyShooting3.png"));
            ENEMY_RADIO_SHOOTING_4 = ImageIO.read(getClass().getResource("/Assets/RadioEnemyShooting4.png"));
            
            ENEMY_TANK_BOTTOM = ImageIO.read(getClass().getResource("/Assets/TankBottom.png"));
            ENEMY_TANK_TURRET_1 = ImageIO.read(getClass().getResource("/Assets/TankTurret1.png"));
            ENEMY_TANK_TURRET_2 = ImageIO.read(getClass().getResource("/Assets/TankTurret2.png"));
            ENEMY_TANK_TURRET_3 = ImageIO.read(getClass().getResource("/Assets/TankTurret3.png"));
            ENEMY_TANK_TURRET_DYING = ImageIO.read(getClass().getResource("/Assets/TankTurretDying.png"));;
            
            FLAMES = ImageIO.read(getClass().getResource("/Assets/Flames.png"));
            PLANE = ImageIO.read(getClass().getResource("/Assets/Plane.png"));
            SMOKE = ImageIO.read(getClass().getResource("/Assets/Smoke.png"));
            EXPLOSION = ImageIO.read(getClass().getResource("/Assets/Explosion.png"));
            GROUND_SCAR = ImageIO.read(getClass().getResource("/Assets/GroundScar.png"));
            BULLET = ImageIO.read(getClass().getResource("/Assets/Bullet.png"));
            ROCKET = ImageIO.read(getClass().getResource("/Assets/Rocket.png"));
            SNIPER_BULLET = ImageIO.read(getClass().getResource("/Assets/SniperBullet.png"));
            MORTAR_ROUND = ImageIO.read(getClass().getResource("/Assets/MortarRound.png"));

            SANDBAG = ImageIO.read(getClass().getResource("/Assets/SandBag.png"));
            ROCK_1 = ImageIO.read(getClass().getResource("/Assets/Rock1.png"));
            ROCK_2 = ImageIO.read(getClass().getResource("/Assets/Rock2.png"));
            ROCK_3 = ImageIO.read(getClass().getResource("/Assets/Rock3.png"));
            ROCK_4 = ImageIO.read(getClass().getResource("/Assets/Rock4.png"));
            TREE_TRUNK = ImageIO.read(getClass().getResource("/Assets/TreeTrunk.png"));
            TREE_LEAVES_1 = ImageIO.read(getClass().getResource("/Assets/TreeLeaves1.png"));
            TREE_LEAVES_2 = ImageIO.read(getClass().getResource("/Assets/TreeLeaves2.png"));

            PICK_UP_MACHINE_GUN = ImageIO.read(getClass().getResource("/Assets/MachineGunPickup.png"));
            PICK_UP_ROCKET_LAUNCHER = ImageIO.read(getClass().getResource("/Assets/RocketLauncherPickup.png"));
            PICK_UP_MED_KIT = ImageIO.read(getClass().getResource("/Assets/MedKitPickup.png"));
            
            LEVEL_BACKGROUND = ImageIO.read(getClass().getResource("/Assets/GrassBackground.png"));
        
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open file");
            System.exit(-1);
        }
    }
}
