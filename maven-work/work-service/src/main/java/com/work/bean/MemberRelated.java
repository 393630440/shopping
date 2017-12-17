package com.work.bean;

public class MemberRelated {
    private String id;

    private String member;

    private String memberName;

    private String memberImg;

    private String memberFather;

    private String fatherName;

    private String fatherImg;

    private String relType;

    private Long createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member == null ? null : member.trim();
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public String getMemberImg() {
        return memberImg;
    }

    public void setMemberImg(String memberImg) {
        this.memberImg = memberImg == null ? null : memberImg.trim();
    }

    public String getMemberFather() {
        return memberFather;
    }

    public void setMemberFather(String memberFather) {
        this.memberFather = memberFather == null ? null : memberFather.trim();
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName == null ? null : fatherName.trim();
    }

    public String getFatherImg() {
        return fatherImg;
    }

    public void setFatherImg(String fatherImg) {
        this.fatherImg = fatherImg == null ? null : fatherImg.trim();
    }

    public String getRelType() {
        return relType;
    }

    public void setRelType(String relType) {
        this.relType = relType == null ? null : relType.trim();
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }
}