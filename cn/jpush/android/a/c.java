package cn.jpush.android.a;

import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;

final class c extends PhoneStateListener
{
  c(b paramb)
  {
  }

  public final void onCellLocationChanged(CellLocation paramCellLocation)
  {
    b.a(this.a, false);
  }

  public final void onSignalStrengthChanged(int paramInt)
  {
    b.a(this.a, paramInt);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.a.c
 * JD-Core Version:    0.6.2
 */