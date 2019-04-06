package model.entity.exercicio4.model.bo;

import java.util.ArrayList;

import model.entity.exercicio4.model.dao.NivelDAO;
import model.entity.exercicio4.model.vo.NivelVO;

public class NivelBO {

	public ArrayList<NivelVO> consultarNivelBO() {
		
		NivelDAO nivelDAO = new NivelDAO();
		return nivelDAO.consultarNivelVO();
	}
	
}
