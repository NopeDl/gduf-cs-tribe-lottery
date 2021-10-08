package com.bigliang.draw.entity;

/**
 * @author 大雨两点
 */
public class Prize {

  /**
   * 奖品ID
   */
  private long pid;
  /**
   * 奖品等级
   */
  private long pgrade;
  /**
   * 奖品数量
   */
  private long pcount;
  /**
   * 奖品数量
   */
  private String pdescription;
  /**
   * 奖品名称
   */
  private String pname;
  /**
   * 奖品权重
   */
  private double pweight;
  /**
   * 开始号
   */
  private int startCode;
  /**
   * 结束号
   */
  private int endCode;
  /**
   * 命中号码
   */
  private int hitCode;

  /**
   * 是否中奖
   */
  private boolean winning = false;

  public boolean isWinning() {
    return winning;
  }

  public void setWinning(boolean winning) {
    this.winning = winning;
  }

  public int getHitCode() {
    return hitCode;
  }

  public void setHitCode(int hitCode) {
    this.hitCode = hitCode;
  }

  public long getPid() {
    return pid;
  }

  public void setPid(long pid) {
    this.pid = pid;
  }


  public long getPgrade() {
    return pgrade;
  }

  public void setPgrade(long pgrade) {
    this.pgrade = pgrade;
  }


  public long getPcount() {
    return pcount;
  }

  public void setPcount(long pcount) {
    this.pcount = pcount;
  }


  public String getPdescription() {
    return pdescription;
  }

  public void setPdescription(String pdescription) {
    this.pdescription = pdescription;
  }


  public String getPname() {
    return pname;
  }

  public void setPname(String pname) {
    this.pname = pname;
  }


  public double getPweight() {
    return pweight;
  }

  public void setPweight(double pweight) {
    this.pweight = pweight;
  }

  public int getStartCode() {
    return startCode;
  }

  public void setStartCode(int startCode) {
    this.startCode = startCode;
  }

  public int getEndCode() {
    return endCode;
  }

  public void setEndCode(int endCode) {
    this.endCode = endCode;
  }
}
