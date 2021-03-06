/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;
/**
 * Add your docs here.
 */
public class OI {
    public static Joystick atkJoy1 = new Joystick(RobotMap.joyPort1);
    public static Joystick atkJoy2 = new Joystick(RobotMap.joyPort2);
    
    //public static Joystick atkJoy2 = new Joystick(RobotMap.joyPort2);

    public static Button hatchPer = new JoystickButton(atkJoy2, 1);//baby
    public static Button hatchOut = new JoystickButton(atkJoy2, 2);
    //public static Button cargoauton = new JoystickButton(atkJoy1, 2);
    /*public static Button testCounter = new JoystickButton(atkJoy1, 5);*/

    //public static Button cargoIn = new JoystickButton(atkJoy2, 3); //backwards
    //public static Button cargoOut = new JoystickButton(atkJoy2, 4); //forwards

    //public static Button cargoPiston = new JoystickButton(atkJoy2, 5);

    //public static Button liftUp = new JoystickButton(atkJoy1, 3);
    //public static Button liftDown = new JoystickButton(atkJoy1, 2);

    public static Button frontClimb = new JoystickButton(atkJoy1, 1);
    public static Button rearClimb = new JoystickButton(atkJoy1, 2);

    public static Button autoAlign1 = new JoystickButton(atkJoy1, 3);
    public static Button autoAlign2 = new JoystickButton(atkJoy1,4);

    public static Button liftUp = new JoystickButton(atkJoy2, 6);
    public static Button liftDown = new JoystickButton(atkJoy2,5);
    public static Button downToZero = new JoystickButton(atkJoy2, 4);

    //public static Button cargoOutZ = new JoystickButton(atkJoy1, 12);
    //public static Button cargoInZ = new JoystickButton(atkJoy1, 12);

    //public static Button i2ctest = new JoystickButton(atkJoy1, 3);
    //public static Button serialtest = new JoystickButton(atkJoy1, 4);

    public static void bindButtons(){
        //serialtest.whenPressed(new SerialTest());
        
        //hatch
        hatchPer.whenPressed(new HatchIntakeCom());
        hatchOut.whenPressed(new HatchOutCom());
        
/*
        //cargoauton.whenPressed(new DriveAuton());
        cargoIn.whileHeld(new CargoIn()); 
        cargoOut.whileHeld(new CargoOut());
        cargoIn.whenReleased(new StopAcquirer());
        cargoOut.whenReleased(new StopAcquirer());
        //cargoPiston.whenPressed(new CargoPiston());
        */
        
        liftUp.whenPressed(new CascadeUp());
        liftDown.whenPressed(new CascadeDown());
        downToZero.whenPressed(new DownToZero());

        //liftUp.whenPressed(new RocketUp());
        //liftDown.whenPressed(new RocketDown());
        
        //climber manual
        frontClimb.whenPressed(new FrontClimb());
        rearClimb.whenPressed(new RearClimb());

        autoAlign1.whileHeld(new AutoAlign_PID(.3,.3));
        autoAlign2.whileHeld(new AutoAlign());
        autoAlign1.whenReleased(new StopAlign());
        autoAlign2.whenReleased(new StopAlign());

        //testCounter.whenPressed(new PrintTest());

        //cargoOutZ.whenReleased(new CargoOutZ());
        //cargoInZ.whileHeld(new CargoInZ());
    
    }
    
}