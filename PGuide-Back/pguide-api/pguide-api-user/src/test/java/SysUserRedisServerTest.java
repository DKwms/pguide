import org.junit.jupiter.api.Test;
import org.pguide.user.entity.SysAuthInfo;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author DKwms
 * @Date 2024/1/30 16:41
 * @description
 */
public class SysUserRedisServerTest {


    // just test the logic,without use the spring's environment
    @Test
    void justTest(){
        List<SysAuthInfo> fakeDataList = generateFakeSysAuthInfoList(1);

        for (SysAuthInfo sysAuthInfo : fakeDataList) {
            System.out.println(sysAuthInfo);
        }
        // Print the generated fake data

        Map<String, List<String>> collect = fakeDataList.stream()
                .filter(
                        e -> "open".equals(e.getSysType())
                )
                .collect(
                        Collectors.toMap(
                                SysAuthInfo::getSysName,
                                e -> {
                                    String[] split = e.getSysUser().split(";");
                                    return Arrays.asList(split);
                                })
                );

        collect.entrySet().forEach(System.out::println);
    }

    public static List<SysAuthInfo> generateFakeSysAuthInfoList(int size) {
        List<SysAuthInfo> sysAuthInfoList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            SysAuthInfo sysAuthInfo = new SysAuthInfo();
            sysAuthInfo.setSysId(i + 1); // Assuming sysId starts from 1
            sysAuthInfo.setSysName(generateRandomString(8));
            //sysAuthInfo.setSysType(random.nextBoolean() ? "open" : "close");
            sysAuthInfo.setSysType("open");
            sysAuthInfo.setSysUser(generateRandomString(6)+";"+generateRandomString(6));
            sysAuthInfo.setCreated(LocalDateTime.now());
            sysAuthInfo.setUpdated(LocalDateTime.now());
            sysAuthInfo.setDeleted(0);

            sysAuthInfoList.add(sysAuthInfo);
        }

        return sysAuthInfoList;
    }

    private static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder randomString = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            randomString.append(characters.charAt(random.nextInt(characters.length())));
        }

        return randomString.toString();
    }
}
