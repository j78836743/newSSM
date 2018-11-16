package com.etoak.controller;

import com.etoak.bean.Bicycle;
import com.etoak.service.BicycleService;
import com.etoak.util.OrderNode;
import com.etoak.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping(value="/bicycle")
public class BicycleController {
@Autowired
private BicycleService bicycleservice;

	@RequestMapping(value="/bicycleaddAndUpdate",method=RequestMethod.GET)
	public String empAddandUpdate(){
		return "/bicycle/addAndUpdate";
	}

	@RequestMapping(value="/list",
			method=RequestMethod.GET)
	public String list() {
		return "bicycle/list";
	}

	@ResponseBody
	@RequestMapping(value="/query")
	public Map<String,Object> query(
			Integer page,Integer rows,Bicycle bicycle) {
		return bicycleservice.query(page, rows, bicycle);

	}
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ResultMsg add(Bicycle bicycle){
		String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		bicycle.setBicyclecode(uuid.substring(uuid.length()-5));
		try{
			bicycleservice.doAdd(bicycle);

			return new ResultMsg(200,"新增"+bicycle.getBicycleName()+"success");
		}catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(500,bicycle
					.getPublish()+"的"+bicycle.getBicycleName()+"已存在哦");
		}
	}
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public ResultMsg update(Bicycle bicycle){
        try{
            bicycleservice.update(bicycle);
            return new ResultMsg(200,"修改员工"+bicycle.getBicycleName()+"success");
        }catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(500,"已存在辣");
        }

    }

	@ResponseBody
	@RequestMapping(value="/getbicyclecodeAndbicycleName")
	public List<OrderNode> getType(){
		return 	bicycleservice.getbicyclecodeAndbicycleName();


	}

	@ResponseBody
	@RequestMapping(value = "/remove")
	public ResultMsg remove(HttpServletRequest request,
						 HttpServletResponse response) throws Exception {

		response.setCharacterEncoding("UTF-8");

		Integer id = Integer.valueOf(request.getParameter("id"));
		Bicycle b = bicycleservice.getbicycleId(id);
		if (b.getBicyclecount() != b.getNowcount()){
			return new ResultMsg(500, "不能删有没还的");
		}

		boolean bool = bicycleservice.remove(id);

		if (bool) {
			return new ResultMsg(200, "ok");
		}else {
			return new ResultMsg(500, "已经没了");
		}
	}


	}



