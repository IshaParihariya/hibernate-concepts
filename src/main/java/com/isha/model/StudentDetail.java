package com.isha.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="StudentDetail")
@Cacheable // level 2 cache
@Cache(usage= CacheConcurrencyStrategy.READ_ONLY) // read only cuz need cache for data reading purpose
public class StudentDetail
{
    @Id
    @Column(name="SID")
    public Integer sid;
    @Column(name="SNAME")
    public String sname;
    @Column(name="SEMAIL")
    public String semail;
    @Column(name="SCITY")
    public String scity;

    // constructor
   public StudentDetail()
    {
        System.out.println("zero param constructor");
    }
    //getter setter
    public Integer getSid()
    {
        return sid;
    }
    public void setSid(Integer sid)
    {
        this.sid=sid;
    }
    public String getSname()
    {
        return sname;
    }
    public void setSname(String sname)
    {
        this.sname = sname;
    }

    public String getSemail()
    {
        return semail;
    }

    public void setSemail(String semail)
    {
       this.semail=semail;
    }

    public String getScity()
    {
        return scity;
    }
    public void setScity(String scity)
    {
        this.scity=scity;
    }
    // for printing in the console
    @Override
    public String toString()
    {
        return "Student [sid = "+sid+" , sname = "+sname+" , semail= "+semail+" scity = "+scity+" ]";
    }
}
