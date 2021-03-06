package com.example.hotel.blimpl.admin;

import com.example.hotel.bl.admin.AdminService;
import com.example.hotel.data.admin.AdminMapper;
import com.example.hotel.data.hotel.HotelMapper;
import com.example.hotel.enums.UserType;
import com.example.hotel.po.User;
import com.example.hotel.vo.HotelVO;
import com.example.hotel.vo.ResponseVO;
import com.example.hotel.vo.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenyizong
 */
@Service
public class AdminServiceImpl implements AdminService {

    private final static String ACCOUNT_EXIST = "账号已存在";

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    HotelMapper hotelMapper;

    @Override
    public ResponseVO addStaff(UserForm userForm) {
        User user = new User();
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setUserType(UserType.Staff);
        try {
            adminMapper.addStaff(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(ACCOUNT_EXIST);
        }
        return ResponseVO.buildSuccess(true);
    }

    @Override
    public List<User> getAllStaffs() {
        return adminMapper.getAllStaffs();
    }

    @Override
    public ResponseVO addBusi(UserForm userForm) {
        User user = new User();
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setUserType(UserType.Busi);
        try {
            adminMapper.addBusi(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(ACCOUNT_EXIST);
        }
        return ResponseVO.buildSuccess(true);
    }

    @Override
    public List<User> getAllBusis() {
        return adminMapper.getAllBusis();
    }

    @Override
    public List<User> getAllClients() {
        return adminMapper.getAllClients();
    }

    @Override
    public int getHotelIdByStaffId(int staffId) {
        HotelVO hotelVO = hotelMapper.selectByStaffId(staffId);
        if (hotelVO == null) {
            System.out.println("该酒店工作人员未绑定酒店");
            return -1;
        } else {
            return hotelVO.getId();
        }
    }
}