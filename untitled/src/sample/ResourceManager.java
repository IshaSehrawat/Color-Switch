package sample;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResourceManager {
    private static int i=0;
    public static void Save(Serializable data,String filename) throws Exception{
        int ii=(int)ResourceManager.Load("Nsaved",0);
        i=ii;
        try(ObjectOutputStream oo=new ObjectOutputStream(Files.newOutputStream(Paths.get(filename+Integer.toString(i%10))))){
            oo.writeObject(data);
        }
    }
    public static Object Load(String filename,int j) throws Exception{
        try(ObjectInputStream oo=new ObjectInputStream(Files.newInputStream(Paths.get(filename+Integer.toString(j))))){
            return oo.readObject();
        }
    }
    public static void Save2(Serializable data,String filename) throws Exception{
        try(ObjectOutputStream oo=new ObjectOutputStream(Files.newOutputStream(Paths.get(filename+"0")))){
            oo.writeObject(data);
        }
    }
}
