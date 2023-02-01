package testData;

import com.creditdatamw.zerocell.annotation.Column;

import io.github.sskorol.data.Sheet;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Sheet(name = "Sheet1")
public class TestData {
    
    @Column(name = "testCaseName", index = 0)
    public String testCaseName;
    @Column(name = "expected", index = 1)
    public String expected;
//    @Column(name = "userId")
//    public String userId;
//    @Column(name = "password")
//    public String password;
//    @Column(name = "errorMsg")
//    public String errorMsg;
//    @Column(name = "validMsg")
//    public String validMsg;
}
