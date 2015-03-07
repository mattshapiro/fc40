package com.allinone.free.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ReadAllTextFileToNewFile
{
  public static void uniteTextFile(String paramString1, String paramString2, FileOutputStream paramFileOutputStream)
  {
    Object localObject1 = null;
    FileOutputStream localFileOutputStream = null;
    File localFile1 = new File(paramString1);
    File localFile2 = new File(paramString2);
    try
    {
      boolean bool1 = localFile2.exists();
      localObject1 = null;
      localFileOutputStream = null;
      if (!bool1)
        localFile2.createNewFile();
      boolean bool2 = localFile2.isDirectory();
      localObject1 = null;
      localFileOutputStream = null;
      if (bool2)
      {
        System.out.println("newFilePathAndName必须是文件而不能是目录.");
        return;
      }
      localObject1 = null;
      localFileOutputStream = null;
      if (paramFileOutputStream == null)
      {
        localFileOutputStream = new FileOutputStream(localFile2);
        boolean bool3 = localFile1.exists();
        localObject1 = null;
        if (!bool3)
          break label280;
        boolean bool4 = localFile1.isDirectory();
        localObject1 = null;
        if (!bool4)
          break label267;
        arrayOfFile = localFile1.listFiles();
        i = 0;
        localObject2 = null;
      }
    }
    catch (Exception localException1)
    {
      while (true)
        try
        {
          File[] arrayOfFile;
          int j = arrayOfFile.length;
          if (i >= j)
          {
            localObject1 = localObject2;
            if (paramFileOutputStream == null)
            {
              localFileOutputStream.close();
              return;
              localException1 = localException1;
              localException1.printStackTrace();
              if (localFileOutputStream != null);
              try
              {
                localFileOutputStream.close();
                if (localObject1 == null)
                  continue;
                ((FileInputStream)localObject1).close();
                return;
              }
              catch (Exception localException3)
              {
                return;
              }
              localFileOutputStream = paramFileOutputStream;
            }
          }
          else if (arrayOfFile[i].isFile())
          {
            System.out.println(arrayOfFile[i].getName());
            localObject1 = new FileInputStream(arrayOfFile[i]);
            byte[] arrayOfByte = new byte[((FileInputStream)localObject1).available()];
            ((FileInputStream)localObject1).read(arrayOfByte);
            localFileOutputStream.write(arrayOfByte);
            ((FileInputStream)localObject1).close();
            localFileOutputStream.flush();
            continue;
            label267: System.out.println("你输入的不是文件夹路径/名称!,而是一个文件.");
            localObject1 = null;
            continue;
            label280: System.out.println("文件或文件夹不存在!");
            localObject1 = null;
          }
        }
        catch (Exception localException2)
        {
          int i;
          localObject1 = localObject2;
          continue;
          localObject1 = localObject2;
          continue;
          return;
          i++;
          Object localObject2 = localObject1;
        }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.utils.ReadAllTextFileToNewFile
 * JD-Core Version:    0.6.2
 */