/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MR_SZH
 */



import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;

//  - 音乐播放器类 - @author lt - time 2016-7-5 来自 http://blog.csdn.net/c1481118216/article/details/51835634

public class MusicPlay 
{
    Player player;
    File music;
    
    public  MusicPlay (File file)//
    {
        this.music = file;
    }
    //播放方法
    public void play() throws FileNotFoundException, JavaLayerException {

            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(music));
            player = new Player(buffer);
            player.play();
    }
}
