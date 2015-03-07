package net.tsz.afinal.annotation.view;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface ViewInject
{
  public abstract String click();

  public abstract int id();

  public abstract String itemClick();

  public abstract String itemLongClick();

  public abstract String longClick();

  public abstract Select select();
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.annotation.view.ViewInject
 * JD-Core Version:    0.6.2
 */