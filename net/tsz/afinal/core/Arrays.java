package net.tsz.afinal.core;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

public class Arrays
{
  static
  {
    if (!Arrays.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }

  public static <T> List<T> asList(T[] paramArrayOfT)
  {
    return new ArrayList(paramArrayOfT);
  }

  public static int binarySearch(byte[] paramArrayOfByte, byte paramByte)
  {
    return binarySearch(paramArrayOfByte, 0, paramArrayOfByte.length, paramByte);
  }

  public static int binarySearch(byte[] paramArrayOfByte, int paramInt1, int paramInt2, byte paramByte)
  {
    checkBinarySearchBounds(paramInt1, paramInt2, paramArrayOfByte.length);
    int i = paramInt1;
    int j = paramInt2 - 1;
    while (true)
    {
      int k;
      if (i > j)
        k = i ^ 0xFFFFFFFF;
      byte b;
      do
      {
        return k;
        k = i + j >>> 1;
        b = paramArrayOfByte[k];
        if (b < paramByte)
        {
          i = k + 1;
          break;
        }
      }
      while (b <= paramByte);
      j = k - 1;
    }
  }

  public static int binarySearch(char[] paramArrayOfChar, char paramChar)
  {
    return binarySearch(paramArrayOfChar, 0, paramArrayOfChar.length, paramChar);
  }

  public static int binarySearch(char[] paramArrayOfChar, int paramInt1, int paramInt2, char paramChar)
  {
    checkBinarySearchBounds(paramInt1, paramInt2, paramArrayOfChar.length);
    int i = paramInt1;
    int j = paramInt2 - 1;
    while (true)
    {
      int k;
      if (i > j)
        k = i ^ 0xFFFFFFFF;
      char c;
      do
      {
        return k;
        k = i + j >>> 1;
        c = paramArrayOfChar[k];
        if (c < paramChar)
        {
          i = k + 1;
          break;
        }
      }
      while (c <= paramChar);
      j = k - 1;
    }
  }

  public static int binarySearch(double[] paramArrayOfDouble, double paramDouble)
  {
    return binarySearch(paramArrayOfDouble, 0, paramArrayOfDouble.length, paramDouble);
  }

  public static int binarySearch(double[] paramArrayOfDouble, int paramInt1, int paramInt2, double paramDouble)
  {
    checkBinarySearchBounds(paramInt1, paramInt2, paramArrayOfDouble.length);
    int i = paramInt1;
    int j = paramInt2 - 1;
    while (true)
    {
      int k;
      if (i > j)
        k = i ^ 0xFFFFFFFF;
      long l1;
      long l2;
      do
      {
        double d;
        do
        {
          return k;
          k = i + j >>> 1;
          d = paramArrayOfDouble[k];
          if (d < paramDouble)
          {
            i = k + 1;
            break;
          }
          if (d > paramDouble)
          {
            j = k - 1;
            break;
          }
        }
        while ((d != 0.0D) && (d == paramDouble));
        l1 = Double.doubleToLongBits(d);
        l2 = Double.doubleToLongBits(paramDouble);
        if (l1 < l2)
        {
          i = k + 1;
          break;
        }
      }
      while (l1 <= l2);
      j = k - 1;
    }
  }

  public static int binarySearch(float[] paramArrayOfFloat, float paramFloat)
  {
    return binarySearch(paramArrayOfFloat, 0, paramArrayOfFloat.length, paramFloat);
  }

  public static int binarySearch(float[] paramArrayOfFloat, int paramInt1, int paramInt2, float paramFloat)
  {
    checkBinarySearchBounds(paramInt1, paramInt2, paramArrayOfFloat.length);
    int i = paramInt1;
    int j = paramInt2 - 1;
    while (true)
    {
      int k;
      if (i > j)
        k = i ^ 0xFFFFFFFF;
      int m;
      int n;
      do
      {
        float f;
        do
        {
          return k;
          k = i + j >>> 1;
          f = paramArrayOfFloat[k];
          if (f < paramFloat)
          {
            i = k + 1;
            break;
          }
          if (f > paramFloat)
          {
            j = k - 1;
            break;
          }
        }
        while ((f != 0.0F) && (f == paramFloat));
        m = Float.floatToIntBits(f);
        n = Float.floatToIntBits(paramFloat);
        if (m < n)
        {
          i = k + 1;
          break;
        }
      }
      while (m <= n);
      j = k - 1;
    }
  }

  public static int binarySearch(int[] paramArrayOfInt, int paramInt)
  {
    return binarySearch(paramArrayOfInt, 0, paramArrayOfInt.length, paramInt);
  }

  public static int binarySearch(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    checkBinarySearchBounds(paramInt1, paramInt2, paramArrayOfInt.length);
    int i = paramInt1;
    int j = paramInt2 - 1;
    while (true)
    {
      int k;
      if (i > j)
        k = i ^ 0xFFFFFFFF;
      int m;
      do
      {
        return k;
        k = i + j >>> 1;
        m = paramArrayOfInt[k];
        if (m < paramInt3)
        {
          i = k + 1;
          break;
        }
      }
      while (m <= paramInt3);
      j = k - 1;
    }
  }

  public static int binarySearch(long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong)
  {
    checkBinarySearchBounds(paramInt1, paramInt2, paramArrayOfLong.length);
    int i = paramInt1;
    int j = paramInt2 - 1;
    while (true)
    {
      int k;
      if (i > j)
        k = i ^ 0xFFFFFFFF;
      long l;
      do
      {
        return k;
        k = i + j >>> 1;
        l = paramArrayOfLong[k];
        if (l < paramLong)
        {
          i = k + 1;
          break;
        }
      }
      while (l <= paramLong);
      j = k - 1;
    }
  }

  public static int binarySearch(long[] paramArrayOfLong, long paramLong)
  {
    return binarySearch(paramArrayOfLong, 0, paramArrayOfLong.length, paramLong);
  }

  public static int binarySearch(Object[] paramArrayOfObject, int paramInt1, int paramInt2, Object paramObject)
  {
    checkBinarySearchBounds(paramInt1, paramInt2, paramArrayOfObject.length);
    int i = paramInt1;
    int j = paramInt2 - 1;
    while (true)
    {
      int k;
      if (i > j)
        k = i ^ 0xFFFFFFFF;
      int m;
      do
      {
        return k;
        k = i + j >>> 1;
        m = ((Comparable)paramArrayOfObject[k]).compareTo(paramObject);
        if (m < 0)
        {
          i = k + 1;
          break;
        }
      }
      while (m <= 0);
      j = k - 1;
    }
  }

  public static <T> int binarySearch(T[] paramArrayOfT, int paramInt1, int paramInt2, T paramT, Comparator<? super T> paramComparator)
  {
    int k;
    if (paramComparator == null)
    {
      k = binarySearch(paramArrayOfT, paramInt1, paramInt2, paramT);
      return k;
    }
    checkBinarySearchBounds(paramInt1, paramInt2, paramArrayOfT.length);
    int i = paramInt1;
    int j = paramInt2 - 1;
    while (true)
    {
      if (i > j)
        return i ^ 0xFFFFFFFF;
      k = i + j >>> 1;
      int m = paramComparator.compare(paramArrayOfT[k], paramT);
      if (m < 0)
      {
        i = k + 1;
      }
      else
      {
        if (m <= 0)
          break;
        j = k - 1;
      }
    }
  }

  public static int binarySearch(Object[] paramArrayOfObject, Object paramObject)
  {
    return binarySearch(paramArrayOfObject, 0, paramArrayOfObject.length, paramObject);
  }

  public static <T> int binarySearch(T[] paramArrayOfT, T paramT, Comparator<? super T> paramComparator)
  {
    return binarySearch(paramArrayOfT, 0, paramArrayOfT.length, paramT, paramComparator);
  }

  public static int binarySearch(short[] paramArrayOfShort, int paramInt1, int paramInt2, short paramShort)
  {
    checkBinarySearchBounds(paramInt1, paramInt2, paramArrayOfShort.length);
    int i = paramInt1;
    int j = paramInt2 - 1;
    while (true)
    {
      int k;
      if (i > j)
        k = i ^ 0xFFFFFFFF;
      short s;
      do
      {
        return k;
        k = i + j >>> 1;
        s = paramArrayOfShort[k];
        if (s < paramShort)
        {
          i = k + 1;
          break;
        }
      }
      while (s <= paramShort);
      j = k - 1;
    }
  }

  public static int binarySearch(short[] paramArrayOfShort, short paramShort)
  {
    return binarySearch(paramArrayOfShort, 0, paramArrayOfShort.length, paramShort);
  }

  private static void checkBinarySearchBounds(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt2)
      throw new IllegalArgumentException();
    if ((paramInt1 < 0) || (paramInt2 > paramInt3))
      throw new ArrayIndexOutOfBoundsException();
  }

  public static byte[] copyOf(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt < 0)
      throw new NegativeArraySizeException();
    return copyOfRange(paramArrayOfByte, 0, paramInt);
  }

  public static char[] copyOf(char[] paramArrayOfChar, int paramInt)
  {
    if (paramInt < 0)
      throw new NegativeArraySizeException();
    return copyOfRange(paramArrayOfChar, 0, paramInt);
  }

  public static double[] copyOf(double[] paramArrayOfDouble, int paramInt)
  {
    if (paramInt < 0)
      throw new NegativeArraySizeException();
    return copyOfRange(paramArrayOfDouble, 0, paramInt);
  }

  public static float[] copyOf(float[] paramArrayOfFloat, int paramInt)
  {
    if (paramInt < 0)
      throw new NegativeArraySizeException();
    return copyOfRange(paramArrayOfFloat, 0, paramInt);
  }

  public static int[] copyOf(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt < 0)
      throw new NegativeArraySizeException();
    return copyOfRange(paramArrayOfInt, 0, paramInt);
  }

  public static long[] copyOf(long[] paramArrayOfLong, int paramInt)
  {
    if (paramInt < 0)
      throw new NegativeArraySizeException();
    return copyOfRange(paramArrayOfLong, 0, paramInt);
  }

  public static <T> T[] copyOf(T[] paramArrayOfT, int paramInt)
  {
    if (paramArrayOfT == null)
      throw new NullPointerException();
    if (paramInt < 0)
      throw new NegativeArraySizeException();
    return copyOfRange(paramArrayOfT, 0, paramInt);
  }

  public static <T, U> T[] copyOf(U[] paramArrayOfU, int paramInt, Class<? extends T[]> paramClass)
  {
    if (paramInt < 0)
      throw new NegativeArraySizeException();
    return copyOfRange(paramArrayOfU, 0, paramInt, paramClass);
  }

  public static short[] copyOf(short[] paramArrayOfShort, int paramInt)
  {
    if (paramInt < 0)
      throw new NegativeArraySizeException();
    return copyOfRange(paramArrayOfShort, 0, paramInt);
  }

  public static boolean[] copyOf(boolean[] paramArrayOfBoolean, int paramInt)
  {
    if (paramInt < 0)
      throw new NegativeArraySizeException();
    return copyOfRange(paramArrayOfBoolean, 0, paramInt);
  }

  public static byte[] copyOfRange(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
      throw new IllegalArgumentException();
    int i = paramArrayOfByte.length;
    if ((paramInt1 < 0) || (paramInt1 > i))
      throw new ArrayIndexOutOfBoundsException();
    int j = paramInt2 - paramInt1;
    int k = Math.min(j, i - paramInt1);
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, k);
    return arrayOfByte;
  }

  public static char[] copyOfRange(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
      throw new IllegalArgumentException();
    int i = paramArrayOfChar.length;
    if ((paramInt1 < 0) || (paramInt1 > i))
      throw new ArrayIndexOutOfBoundsException();
    int j = paramInt2 - paramInt1;
    int k = Math.min(j, i - paramInt1);
    char[] arrayOfChar = new char[j];
    System.arraycopy(paramArrayOfChar, paramInt1, arrayOfChar, 0, k);
    return arrayOfChar;
  }

  public static double[] copyOfRange(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
      throw new IllegalArgumentException();
    int i = paramArrayOfDouble.length;
    if ((paramInt1 < 0) || (paramInt1 > i))
      throw new ArrayIndexOutOfBoundsException();
    int j = paramInt2 - paramInt1;
    int k = Math.min(j, i - paramInt1);
    double[] arrayOfDouble = new double[j];
    System.arraycopy(paramArrayOfDouble, paramInt1, arrayOfDouble, 0, k);
    return arrayOfDouble;
  }

  public static float[] copyOfRange(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
      throw new IllegalArgumentException();
    int i = paramArrayOfFloat.length;
    if ((paramInt1 < 0) || (paramInt1 > i))
      throw new ArrayIndexOutOfBoundsException();
    int j = paramInt2 - paramInt1;
    int k = Math.min(j, i - paramInt1);
    float[] arrayOfFloat = new float[j];
    System.arraycopy(paramArrayOfFloat, paramInt1, arrayOfFloat, 0, k);
    return arrayOfFloat;
  }

  public static int[] copyOfRange(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
      throw new IllegalArgumentException();
    int i = paramArrayOfInt.length;
    if ((paramInt1 < 0) || (paramInt1 > i))
      throw new ArrayIndexOutOfBoundsException();
    int j = paramInt2 - paramInt1;
    int k = Math.min(j, i - paramInt1);
    int[] arrayOfInt = new int[j];
    System.arraycopy(paramArrayOfInt, paramInt1, arrayOfInt, 0, k);
    return arrayOfInt;
  }

  public static long[] copyOfRange(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
      throw new IllegalArgumentException();
    int i = paramArrayOfLong.length;
    if ((paramInt1 < 0) || (paramInt1 > i))
      throw new ArrayIndexOutOfBoundsException();
    int j = paramInt2 - paramInt1;
    int k = Math.min(j, i - paramInt1);
    long[] arrayOfLong = new long[j];
    System.arraycopy(paramArrayOfLong, paramInt1, arrayOfLong, 0, k);
    return arrayOfLong;
  }

  public static <T> T[] copyOfRange(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfT.length;
    if (paramInt1 > paramInt2)
      throw new IllegalArgumentException();
    if ((paramInt1 < 0) || (paramInt1 > i))
      throw new ArrayIndexOutOfBoundsException();
    int j = paramInt2 - paramInt1;
    int k = Math.min(j, i - paramInt1);
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
    System.arraycopy(paramArrayOfT, paramInt1, arrayOfObject, 0, k);
    return arrayOfObject;
  }

  public static <T, U> T[] copyOfRange(U[] paramArrayOfU, int paramInt1, int paramInt2, Class<? extends T[]> paramClass)
  {
    if (paramInt1 > paramInt2)
      throw new IllegalArgumentException();
    int i = paramArrayOfU.length;
    if ((paramInt1 < 0) || (paramInt1 > i))
      throw new ArrayIndexOutOfBoundsException();
    int j = paramInt2 - paramInt1;
    int k = Math.min(j, i - paramInt1);
    Object[] arrayOfObject = (Object[])Array.newInstance(paramClass.getComponentType(), j);
    System.arraycopy(paramArrayOfU, paramInt1, arrayOfObject, 0, k);
    return arrayOfObject;
  }

  public static short[] copyOfRange(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
      throw new IllegalArgumentException();
    int i = paramArrayOfShort.length;
    if ((paramInt1 < 0) || (paramInt1 > i))
      throw new ArrayIndexOutOfBoundsException();
    int j = paramInt2 - paramInt1;
    int k = Math.min(j, i - paramInt1);
    short[] arrayOfShort = new short[j];
    System.arraycopy(paramArrayOfShort, paramInt1, arrayOfShort, 0, k);
    return arrayOfShort;
  }

  public static boolean[] copyOfRange(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
      throw new IllegalArgumentException();
    int i = paramArrayOfBoolean.length;
    if ((paramInt1 < 0) || (paramInt1 > i))
      throw new ArrayIndexOutOfBoundsException();
    int j = paramInt2 - paramInt1;
    int k = Math.min(j, i - paramInt1);
    boolean[] arrayOfBoolean = new boolean[j];
    System.arraycopy(paramArrayOfBoolean, paramInt1, arrayOfBoolean, 0, k);
    return arrayOfBoolean;
  }

  public static boolean deepEquals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (paramArrayOfObject1 == paramArrayOfObject2);
    while (true)
    {
      return true;
      if ((paramArrayOfObject1 == null) || (paramArrayOfObject2 == null) || (paramArrayOfObject1.length != paramArrayOfObject2.length))
        return false;
      for (int i = 0; i < paramArrayOfObject1.length; i++)
        if (!deepEqualsElements(paramArrayOfObject1[i], paramArrayOfObject2[i]))
          return false;
    }
  }

  private static boolean deepEqualsElements(Object paramObject1, Object paramObject2)
  {
    boolean bool;
    if (paramObject1 == paramObject2)
      bool = true;
    Class localClass1;
    Class localClass2;
    do
    {
      do
      {
        do
        {
          return bool;
          bool = false;
        }
        while (paramObject1 == null);
        bool = false;
      }
      while (paramObject2 == null);
      localClass1 = paramObject1.getClass().getComponentType();
      localClass2 = paramObject2.getClass().getComponentType();
      bool = false;
    }
    while (localClass1 != localClass2);
    if (localClass1 == null)
      return paramObject1.equals(paramObject2);
    if (!localClass1.isPrimitive())
      return deepEquals((Object[])paramObject1, (Object[])paramObject2);
    if (localClass1.equals(Integer.TYPE))
      return equals((int[])paramObject1, (int[])paramObject2);
    if (localClass1.equals(Character.TYPE))
      return equals((char[])paramObject1, (char[])paramObject2);
    if (localClass1.equals(Boolean.TYPE))
      return equals((boolean[])paramObject1, (boolean[])paramObject2);
    if (localClass1.equals(Byte.TYPE))
      return equals((byte[])paramObject1, (byte[])paramObject2);
    if (localClass1.equals(Long.TYPE))
      return equals((long[])paramObject1, (long[])paramObject2);
    if (localClass1.equals(Float.TYPE))
      return equals((float[])paramObject1, (float[])paramObject2);
    if (localClass1.equals(Double.TYPE))
      return equals((double[])paramObject1, (double[])paramObject2);
    return equals((short[])paramObject1, (short[])paramObject2);
  }

  public static int deepHashCode(Object[] paramArrayOfObject)
  {
    int i = 0;
    int j;
    if (paramArrayOfObject == null)
      j = 0;
    while (true)
    {
      return j;
      j = 1;
      int k = paramArrayOfObject.length;
      while (i < k)
      {
        j = deepHashCodeElement(paramArrayOfObject[i]) + j * 31;
        i++;
      }
    }
  }

  private static int deepHashCodeElement(Object paramObject)
  {
    if (paramObject == null)
      return 0;
    Class localClass = paramObject.getClass().getComponentType();
    if (localClass == null)
      return paramObject.hashCode();
    if (!localClass.isPrimitive())
      return deepHashCode((Object[])paramObject);
    if (localClass.equals(Integer.TYPE))
      return hashCode((int[])paramObject);
    if (localClass.equals(Character.TYPE))
      return hashCode((char[])paramObject);
    if (localClass.equals(Boolean.TYPE))
      return hashCode((boolean[])paramObject);
    if (localClass.equals(Byte.TYPE))
      return hashCode((byte[])paramObject);
    if (localClass.equals(Long.TYPE))
      return hashCode((long[])paramObject);
    if (localClass.equals(Float.TYPE))
      return hashCode((float[])paramObject);
    if (localClass.equals(Double.TYPE))
      return hashCode((double[])paramObject);
    return hashCode((short[])paramObject);
  }

  public static String deepToString(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null)
      return "null";
    StringBuilder localStringBuilder = new StringBuilder(9 * paramArrayOfObject.length);
    deepToStringImpl(paramArrayOfObject, new Object[] { paramArrayOfObject }, localStringBuilder);
    return localStringBuilder.toString();
  }

  private static void deepToStringImpl(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, StringBuilder paramStringBuilder)
  {
    if (paramArrayOfObject1 == null)
    {
      paramStringBuilder.append("null");
      return;
    }
    paramStringBuilder.append('[');
    int i = 0;
    if (i >= paramArrayOfObject1.length)
    {
      paramStringBuilder.append(']');
      return;
    }
    if (i != 0)
      paramStringBuilder.append(", ");
    Object localObject = paramArrayOfObject1[i];
    if (localObject == null)
      paramStringBuilder.append("null");
    while (true)
    {
      i++;
      break;
      Class localClass1 = localObject.getClass();
      if (localClass1.isArray())
      {
        Class localClass2 = localClass1.getComponentType();
        if (localClass2.isPrimitive())
        {
          if (Boolean.TYPE.equals(localClass2))
            paramStringBuilder.append(toString((boolean[])localObject));
          else if (Byte.TYPE.equals(localClass2))
            paramStringBuilder.append(toString((byte[])localObject));
          else if (Character.TYPE.equals(localClass2))
            paramStringBuilder.append(toString((char[])localObject));
          else if (Double.TYPE.equals(localClass2))
            paramStringBuilder.append(toString((double[])localObject));
          else if (Float.TYPE.equals(localClass2))
            paramStringBuilder.append(toString((float[])localObject));
          else if (Integer.TYPE.equals(localClass2))
            paramStringBuilder.append(toString((int[])localObject));
          else if (Long.TYPE.equals(localClass2))
            paramStringBuilder.append(toString((long[])localObject));
          else if (Short.TYPE.equals(localClass2))
            paramStringBuilder.append(toString((short[])localObject));
          else
            throw new AssertionError();
        }
        else
        {
          assert ((localObject instanceof Object[]));
          if (deepToStringImplContains(paramArrayOfObject2, localObject))
          {
            paramStringBuilder.append("[...]");
          }
          else
          {
            Object[] arrayOfObject1 = (Object[])localObject;
            Object[] arrayOfObject2 = new Object[1 + paramArrayOfObject2.length];
            System.arraycopy(paramArrayOfObject2, 0, arrayOfObject2, 0, paramArrayOfObject2.length);
            arrayOfObject2[paramArrayOfObject2.length] = arrayOfObject1;
            deepToStringImpl(arrayOfObject1, arrayOfObject2, paramStringBuilder);
          }
        }
      }
      else
      {
        paramStringBuilder.append(paramArrayOfObject1[i]);
      }
    }
  }

  private static boolean deepToStringImplContains(Object[] paramArrayOfObject, Object paramObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0));
    while (true)
    {
      return false;
      int i = paramArrayOfObject.length;
      for (int j = 0; j < i; j++)
        if (paramArrayOfObject[j] == paramObject)
          return true;
    }
  }

  public static boolean equals(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == paramArrayOfByte2);
    while (true)
    {
      return true;
      if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte1.length != paramArrayOfByte2.length))
        return false;
      for (int i = 0; i < paramArrayOfByte1.length; i++)
        if (paramArrayOfByte1[i] != paramArrayOfByte2[i])
          return false;
    }
  }

  public static boolean equals(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    if (paramArrayOfChar1 == paramArrayOfChar2);
    while (true)
    {
      return true;
      if ((paramArrayOfChar1 == null) || (paramArrayOfChar2 == null) || (paramArrayOfChar1.length != paramArrayOfChar2.length))
        return false;
      for (int i = 0; i < paramArrayOfChar1.length; i++)
        if (paramArrayOfChar1[i] != paramArrayOfChar2[i])
          return false;
    }
  }

  public static boolean equals(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    if (paramArrayOfDouble1 == paramArrayOfDouble2);
    while (true)
    {
      return true;
      if ((paramArrayOfDouble1 == null) || (paramArrayOfDouble2 == null) || (paramArrayOfDouble1.length != paramArrayOfDouble2.length))
        return false;
      for (int i = 0; i < paramArrayOfDouble1.length; i++)
        if (Double.doubleToLongBits(paramArrayOfDouble1[i]) != Double.doubleToLongBits(paramArrayOfDouble2[i]))
          return false;
    }
  }

  public static boolean equals(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (paramArrayOfFloat1 == paramArrayOfFloat2);
    while (true)
    {
      return true;
      if ((paramArrayOfFloat1 == null) || (paramArrayOfFloat2 == null) || (paramArrayOfFloat1.length != paramArrayOfFloat2.length))
        return false;
      for (int i = 0; i < paramArrayOfFloat1.length; i++)
        if (Float.floatToIntBits(paramArrayOfFloat1[i]) != Float.floatToIntBits(paramArrayOfFloat2[i]))
          return false;
    }
  }

  public static boolean equals(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramArrayOfInt1 == paramArrayOfInt2);
    while (true)
    {
      return true;
      if ((paramArrayOfInt1 == null) || (paramArrayOfInt2 == null) || (paramArrayOfInt1.length != paramArrayOfInt2.length))
        return false;
      for (int i = 0; i < paramArrayOfInt1.length; i++)
        if (paramArrayOfInt1[i] != paramArrayOfInt2[i])
          return false;
    }
  }

  public static boolean equals(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (paramArrayOfLong1 == paramArrayOfLong2);
    while (true)
    {
      return true;
      if ((paramArrayOfLong1 == null) || (paramArrayOfLong2 == null) || (paramArrayOfLong1.length != paramArrayOfLong2.length))
        return false;
      for (int i = 0; i < paramArrayOfLong1.length; i++)
        if (paramArrayOfLong1[i] != paramArrayOfLong2[i])
          return false;
    }
  }

  public static boolean equals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (paramArrayOfObject1 == paramArrayOfObject2);
    while (true)
    {
      return true;
      if ((paramArrayOfObject1 == null) || (paramArrayOfObject2 == null) || (paramArrayOfObject1.length != paramArrayOfObject2.length))
        return false;
      for (int i = 0; i < paramArrayOfObject1.length; i++)
      {
        Object localObject1 = paramArrayOfObject1[i];
        Object localObject2 = paramArrayOfObject2[i];
        if (localObject1 == null)
        {
          if (localObject2 == null);
        }
        else
          while (!localObject1.equals(localObject2))
            return false;
      }
    }
  }

  public static boolean equals(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    if (paramArrayOfShort1 == paramArrayOfShort2);
    while (true)
    {
      return true;
      if ((paramArrayOfShort1 == null) || (paramArrayOfShort2 == null) || (paramArrayOfShort1.length != paramArrayOfShort2.length))
        return false;
      for (int i = 0; i < paramArrayOfShort1.length; i++)
        if (paramArrayOfShort1[i] != paramArrayOfShort2[i])
          return false;
    }
  }

  public static boolean equals(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    if (paramArrayOfBoolean1 == paramArrayOfBoolean2);
    while (true)
    {
      return true;
      if ((paramArrayOfBoolean1 == null) || (paramArrayOfBoolean2 == null) || (paramArrayOfBoolean1.length != paramArrayOfBoolean2.length))
        return false;
      for (int i = 0; i < paramArrayOfBoolean1.length; i++)
        if (paramArrayOfBoolean1[i] != paramArrayOfBoolean2[i])
          return false;
    }
  }

  public static void fill(byte[] paramArrayOfByte, byte paramByte)
  {
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfByte.length)
        return;
      paramArrayOfByte[i] = paramByte;
    }
  }

  public static void fill(int[] paramArrayOfInt, int paramInt)
  {
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfInt.length)
        return;
      paramArrayOfInt[i] = paramInt;
    }
  }

  public static void fill(Object[] paramArrayOfObject, Object paramObject)
  {
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfObject.length)
        return;
      paramArrayOfObject[i] = paramObject;
    }
  }

  public static void fill(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfBoolean.length)
        return;
      paramArrayOfBoolean[i] = paramBoolean;
    }
  }

  public static int hashCode(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j;
    if (paramArrayOfByte == null)
      j = 0;
    while (true)
    {
      return j;
      j = 1;
      int k = paramArrayOfByte.length;
      while (i < k)
      {
        j = paramArrayOfByte[i] + j * 31;
        i++;
      }
    }
  }

  public static int hashCode(char[] paramArrayOfChar)
  {
    int i = 0;
    int j;
    if (paramArrayOfChar == null)
      j = 0;
    while (true)
    {
      return j;
      j = 1;
      int k = paramArrayOfChar.length;
      while (i < k)
      {
        j = paramArrayOfChar[i] + j * 31;
        i++;
      }
    }
  }

  public static int hashCode(double[] paramArrayOfDouble)
  {
    int i = 0;
    int j;
    if (paramArrayOfDouble == null)
      j = 0;
    while (true)
    {
      return j;
      j = 1;
      int k = paramArrayOfDouble.length;
      while (i < k)
      {
        long l = Double.doubleToLongBits(paramArrayOfDouble[i]);
        j = j * 31 + (int)(l ^ l >>> 32);
        i++;
      }
    }
  }

  public static int hashCode(float[] paramArrayOfFloat)
  {
    int i = 0;
    int j;
    if (paramArrayOfFloat == null)
      j = 0;
    while (true)
    {
      return j;
      j = 1;
      int k = paramArrayOfFloat.length;
      while (i < k)
      {
        float f = paramArrayOfFloat[i];
        j = j * 31 + Float.floatToIntBits(f);
        i++;
      }
    }
  }

  public static int hashCode(int[] paramArrayOfInt)
  {
    int i = 0;
    int j;
    if (paramArrayOfInt == null)
      j = 0;
    while (true)
    {
      return j;
      j = 1;
      int k = paramArrayOfInt.length;
      while (i < k)
      {
        j = paramArrayOfInt[i] + j * 31;
        i++;
      }
    }
  }

  public static int hashCode(long[] paramArrayOfLong)
  {
    int i = 0;
    int j;
    if (paramArrayOfLong == null)
      j = 0;
    while (true)
    {
      return j;
      j = 1;
      int k = paramArrayOfLong.length;
      while (i < k)
      {
        long l = paramArrayOfLong[i];
        j = j * 31 + (int)(l ^ l >>> 32);
        i++;
      }
    }
  }

  public static int hashCode(Object[] paramArrayOfObject)
  {
    int i = 0;
    if (paramArrayOfObject == null)
    {
      j = 0;
      return j;
    }
    int j = 1;
    int k = paramArrayOfObject.length;
    label15: Object localObject;
    if (i < k)
    {
      localObject = paramArrayOfObject[i];
      if (localObject != null)
        break label47;
    }
    label47: for (int m = 0; ; m = localObject.hashCode())
    {
      j = m + j * 31;
      i++;
      break label15;
      break;
    }
  }

  public static int hashCode(short[] paramArrayOfShort)
  {
    int i = 0;
    int j;
    if (paramArrayOfShort == null)
      j = 0;
    while (true)
    {
      return j;
      j = 1;
      int k = paramArrayOfShort.length;
      while (i < k)
      {
        j = paramArrayOfShort[i] + j * 31;
        i++;
      }
    }
  }

  public static int hashCode(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null)
    {
      i = 0;
      return i;
    }
    int i = 1;
    int j = paramArrayOfBoolean.length;
    int k = 0;
    label15: int n;
    if (k < j)
    {
      int m = paramArrayOfBoolean[k];
      n = i * 31;
      if (m == 0)
        break label53;
    }
    label53: for (int i1 = 1231; ; i1 = 1237)
    {
      i = n + i1;
      k++;
      break label15;
      break;
    }
  }

  public static String toString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return "null";
    if (paramArrayOfByte.length == 0)
      return "[]";
    StringBuilder localStringBuilder = new StringBuilder(6 * paramArrayOfByte.length);
    localStringBuilder.append('[');
    localStringBuilder.append(paramArrayOfByte[0]);
    for (int i = 1; ; i++)
    {
      if (i >= paramArrayOfByte.length)
      {
        localStringBuilder.append(']');
        return localStringBuilder.toString();
      }
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayOfByte[i]);
    }
  }

  public static String toString(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null)
      return "null";
    if (paramArrayOfChar.length == 0)
      return "[]";
    StringBuilder localStringBuilder = new StringBuilder(3 * paramArrayOfChar.length);
    localStringBuilder.append('[');
    localStringBuilder.append(paramArrayOfChar[0]);
    for (int i = 1; ; i++)
    {
      if (i >= paramArrayOfChar.length)
      {
        localStringBuilder.append(']');
        return localStringBuilder.toString();
      }
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayOfChar[i]);
    }
  }

  public static String toString(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble == null)
      return "null";
    if (paramArrayOfDouble.length == 0)
      return "[]";
    StringBuilder localStringBuilder = new StringBuilder(7 * paramArrayOfDouble.length);
    localStringBuilder.append('[');
    localStringBuilder.append(paramArrayOfDouble[0]);
    for (int i = 1; ; i++)
    {
      if (i >= paramArrayOfDouble.length)
      {
        localStringBuilder.append(']');
        return localStringBuilder.toString();
      }
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayOfDouble[i]);
    }
  }

  public static String toString(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
      return "null";
    if (paramArrayOfFloat.length == 0)
      return "[]";
    StringBuilder localStringBuilder = new StringBuilder(7 * paramArrayOfFloat.length);
    localStringBuilder.append('[');
    localStringBuilder.append(paramArrayOfFloat[0]);
    for (int i = 1; ; i++)
    {
      if (i >= paramArrayOfFloat.length)
      {
        localStringBuilder.append(']');
        return localStringBuilder.toString();
      }
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayOfFloat[i]);
    }
  }

  public static String toString(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null)
      return "null";
    if (paramArrayOfInt.length == 0)
      return "[]";
    StringBuilder localStringBuilder = new StringBuilder(6 * paramArrayOfInt.length);
    localStringBuilder.append('[');
    localStringBuilder.append(paramArrayOfInt[0]);
    for (int i = 1; ; i++)
    {
      if (i >= paramArrayOfInt.length)
      {
        localStringBuilder.append(']');
        return localStringBuilder.toString();
      }
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayOfInt[i]);
    }
  }

  public static String toString(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null)
      return "null";
    if (paramArrayOfLong.length == 0)
      return "[]";
    StringBuilder localStringBuilder = new StringBuilder(6 * paramArrayOfLong.length);
    localStringBuilder.append('[');
    localStringBuilder.append(paramArrayOfLong[0]);
    for (int i = 1; ; i++)
    {
      if (i >= paramArrayOfLong.length)
      {
        localStringBuilder.append(']');
        return localStringBuilder.toString();
      }
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayOfLong[i]);
    }
  }

  public static String toString(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null)
      return "null";
    if (paramArrayOfObject.length == 0)
      return "[]";
    StringBuilder localStringBuilder = new StringBuilder(7 * paramArrayOfObject.length);
    localStringBuilder.append('[');
    localStringBuilder.append(paramArrayOfObject[0]);
    for (int i = 1; ; i++)
    {
      if (i >= paramArrayOfObject.length)
      {
        localStringBuilder.append(']');
        return localStringBuilder.toString();
      }
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayOfObject[i]);
    }
  }

  public static String toString(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null)
      return "null";
    if (paramArrayOfShort.length == 0)
      return "[]";
    StringBuilder localStringBuilder = new StringBuilder(6 * paramArrayOfShort.length);
    localStringBuilder.append('[');
    localStringBuilder.append(paramArrayOfShort[0]);
    for (int i = 1; ; i++)
    {
      if (i >= paramArrayOfShort.length)
      {
        localStringBuilder.append(']');
        return localStringBuilder.toString();
      }
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayOfShort[i]);
    }
  }

  public static String toString(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null)
      return "null";
    if (paramArrayOfBoolean.length == 0)
      return "[]";
    StringBuilder localStringBuilder = new StringBuilder(7 * paramArrayOfBoolean.length);
    localStringBuilder.append('[');
    localStringBuilder.append(paramArrayOfBoolean[0]);
    for (int i = 1; ; i++)
    {
      if (i >= paramArrayOfBoolean.length)
      {
        localStringBuilder.append(']');
        return localStringBuilder.toString();
      }
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayOfBoolean[i]);
    }
  }

  private static class ArrayList<E> extends AbstractList<E>
    implements List<E>, Serializable, RandomAccess
  {
    private static final long serialVersionUID = -2764017481108945198L;
    private final E[] a;

    ArrayList(E[] paramArrayOfE)
    {
      if (paramArrayOfE == null)
        throw new NullPointerException();
      this.a = paramArrayOfE;
    }

    public boolean contains(Object paramObject)
    {
      boolean bool = true;
      Object[] arrayOfObject2;
      int m;
      if (paramObject != null)
      {
        arrayOfObject2 = this.a;
        int k = arrayOfObject2.length;
        m = 0;
        if (m < k);
      }
      label79: 
      while (true)
      {
        bool = false;
        do
          return bool;
        while (paramObject.equals(arrayOfObject2[m]));
        m++;
        break;
        Object[] arrayOfObject1 = this.a;
        int i = arrayOfObject1.length;
        for (int j = 0; ; j++)
        {
          if (j >= i)
            break label79;
          if (arrayOfObject1[j] == null)
            break;
        }
      }
    }

    public E get(int paramInt)
    {
      try
      {
        Object localObject = this.a[paramInt];
        return localObject;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        throw localArrayIndexOutOfBoundsException;
      }
    }

    public int indexOf(Object paramObject)
    {
      int j;
      if (paramObject != null)
      {
        j = 0;
        if (j < this.a.length);
      }
      while (true)
      {
        return -1;
        if (paramObject.equals(this.a[j]))
          return j;
        j++;
        break;
        for (int i = 0; i < this.a.length; i++)
          if (this.a[i] == null)
            return i;
      }
    }

    public int lastIndexOf(Object paramObject)
    {
      int j;
      if (paramObject != null)
      {
        j = -1 + this.a.length;
        if (j >= 0);
      }
      while (true)
      {
        return -1;
        if (paramObject.equals(this.a[j]))
          return j;
        j--;
        break;
        for (int i = -1 + this.a.length; i >= 0; i--)
          if (this.a[i] == null)
            return i;
      }
    }

    public E set(int paramInt, E paramE)
    {
      Object localObject = this.a[paramInt];
      this.a[paramInt] = paramE;
      return localObject;
    }

    public int size()
    {
      return this.a.length;
    }

    public Object[] toArray()
    {
      return (Object[])this.a.clone();
    }

    public <T> T[] toArray(T[] paramArrayOfT)
    {
      int i = size();
      if (i > paramArrayOfT.length)
        paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
      System.arraycopy(this.a, 0, paramArrayOfT, 0, i);
      if (i < paramArrayOfT.length)
        paramArrayOfT[i] = null;
      return paramArrayOfT;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.core.Arrays
 * JD-Core Version:    0.6.2
 */