package biz.board;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

/**
 * VO(Value Object)
 *
 * 레이어와 레이어 사이에서 관련된 데이터를 한꺼번에 주고받을 목적으로 사용하는 클래스
 * DTO(Data Transfer Object)라고 부르기도 함
 */
public class BoardVO {
    private int seq;
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private int cnt;
    private String searchCondition;
    private String searchKeyword;
    private MultipartFile uploadFile;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    @JsonIgnore
    public String getSearchCondition() {
        return searchCondition;
    }

    public void setSearchCondition(String searchCondition) {
        this.searchCondition = searchCondition;
    }

    @JsonIgnore
    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    @JsonIgnore
    public MultipartFile getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(MultipartFile uploadFile) {
        this.uploadFile = uploadFile;
    }

    @Override
    public String toString() {
        return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate=" + regDate + ", cnt=" + cnt + "]";
    }


}
