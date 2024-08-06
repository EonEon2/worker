package org.example.worker.dao;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.example.worker.common.ConnectionUtil;
import org.example.worker.vo.SupervisorVO;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Log4j2
public enum SupervisorDAO {
    INSTANCE;

    SupervisorDAO() {
    }

    public Integer mInsert(SupervisorVO supervisorVO) throws Exception {

        String sql = "insert into supervisor (sid, spw, dept) values (?, ?, ?)";

        @Cleanup Connection con = ConnectionUtil.INSTANCE.getDs().getConnection();
        @Cleanup PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, supervisorVO.getSid());
        ps.setString(2, supervisorVO.getSpw());
        ps.setString(3, supervisorVO.getDept());

        int count = ps.executeUpdate();

        if (count != 1) {
            throw new Exception();
        }

        return supervisorVO.getSno();
    }

}