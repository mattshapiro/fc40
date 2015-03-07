package com.google.ads.mediation;

public abstract interface MediationAdapter<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS extends MediationServerParameters>
{
  public abstract void destroy();

  public abstract Class<ADDITIONAL_PARAMETERS> getAdditionalParametersType();

  public abstract Class<SERVER_PARAMETERS> getServerParametersType();
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.MediationAdapter
 * JD-Core Version:    0.6.2
 */