package com.Controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Entity.QuestionsEntity;
import com.Repository.QuestionsRepository;
import com.bean.Questions;
import com.bean.ResponseBean;

@CrossOrigin
@RestController
public class QuestionsController {


	@Autowired
	QuestionsRepository service;
	
	/*
	 * @GetMapping("/get-students") public List<Questions> GetSudents(){
	 * List<Questions> result = new ArrayList<>(); List<QuestionsEntity> entities =
	 * service.findAll(); if (entities != null && entities.size() > 0){
	 * entities.forEach(x->{ Questions item = new Questions(); item.Que_id =
	 * x.Que_id; item.Questions = x.Questions; item.opt1 = x.opt1; item.opt2 =
	 * x.opt2; item.opt3 = x.opt3; item.opt4 = x.opt4; item.correct = x.correct;
	 * result.add(item); }); } return result; }
	 * 
	 * @PostMapping("/addFile") public List<Questions>
	 * importExcelFile(@RequestParam("file1") MultipartFile files)throws IOException
	 * { List<Questions> students = new ArrayList<>(); XSSFWorkbook workbook = new
	 * XSSFWorkbook(files.getInputStream()); // Read student data form excel file
	 * sheet1. XSSFSheet worksheet = workbook.getSheetAt(0); for (int index = 0;
	 * index < worksheet.getPhysicalNumberOfRows(); index++) { if (index > 0) {
	 * XSSFRow row = worksheet.getRow(index); Questions student = new Questions();
	 * student.Questions = getCellValue(row, 0); student.opt1 = getCellValue(row,
	 * 1); student.opt2 = getCellValue(row, 2); student.opt3 = getCellValue(row,3);
	 * student.opt4 = getCellValue(row, 4); student.correct = getCellValue(row, 5);
	 * students.add(student); } }
	 * 
	 * List<QuestionsEntity> entities = new ArrayList<>(); if (students.size() > 0)
	 * { students.forEach(x->{ QuestionsEntity entity = new QuestionsEntity();
	 * entity.Questions= x.Questions; entity.opt1 = x.opt1; entity.opt2 = x.opt2;
	 * entity.opt3 = x.opt3; entity.opt4 = x.opt4; entity.correct = x.correct;
	 * entities.add(entity); }); service.saveAll(entities); } return students; }
	 * 
	 * private int convertStringToInt(String str) { int result = 0; if (str == null
	 * || str.isEmpty() || str.trim().isEmpty()) { return result; } result =
	 * Integer.parseInt(str); return result; } private String getCellValue(Row row,
	 * int cellNo) { DataFormatter formatter = new DataFormatter(); Cell cell =
	 * row.getCell(cellNo); return formatter.formatCellValue(cell); }
	 */
	
	@PostMapping("/addFile")
	public ResponseBean<String> addFile(@RequestBody ArrayList<String[]> que)
	{
		for(String[] question : que) {
			service.save(new QuestionsEntity(0, question[0], question[1], question[2], question[3], question[4], question[5]));
		}
		System.out.println(que);
		return new ResponseBean<String>();
	}
	
	@GetMapping("getFile")
	public ResponseBean<QuestionsEntity> getFile()
	{
		ResponseBean res=new ResponseBean();
		List<QuestionsEntity> list=service.findAll();
		res.setData(list);
		res.setMessage("Get All Questions");
		res.setStatus(200);
		return res;
		
	}
}
