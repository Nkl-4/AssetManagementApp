package com.cg.ama.service.report;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ama.model.ShipmentModel;
import com.cg.ama.repo.ShipmentRepo;
import com.cg.ama.service.EMParser;


@Service
public class ReportServiceImpl implements IReportService {
	
	@Autowired
	private EMParser parser;
	
	@Autowired
	private ShipmentRepo shipmentRepo;
	
	public ReportServiceImpl() {
		super();
	}

	public ReportServiceImpl(EMParser parser, ShipmentRepo shipmentRepo) {
		super();
		this.parser = new EMParser();
		this.shipmentRepo = shipmentRepo;
	}

	@Override
	public List<ShipmentModel> getShipmentsByWeek(int week, int month, int year) {
		
		LocalDate startDate = LocalDate.of(year, month-1, 1);
		LocalDate endDate;
		switch (week) {
		case 1:
			endDate = startDate.plusDays(6);
			break;
		case 2:
			startDate = startDate.plusDays(7);
			endDate = startDate.plusDays(6);
			break;
		case 3:
			startDate = startDate.plusDays(14);
			endDate = startDate.plusDays(6);
			break;
		case 4:
			startDate = startDate.plusDays(21);
			endDate = startDate.plusDays(6);
			break;
		default:
			endDate = startDate.plusDays(6);
			break;
		}
		
		return shipmentRepo.getShipmentsInfo(startDate, endDate).stream().map(parser::parse).collect(Collectors.toList());
	}

	@Override
	public List<ShipmentModel> getShipmentsByMonth(int month, int year) {
		LocalDate startDate = LocalDate.of(year, month, 01);
		LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
		
		return shipmentRepo.getShipmentsInfo(startDate, endDate).stream().map(parser::parse).collect(Collectors.toList());
	}
	
	@Override
	public List<ShipmentModel> findAllByWeekly() {
		return shipmentRepo.getShipmentsInfoWeekly().stream().map(parser::parse).collect(Collectors.toList());
			}
	
	@Override
	public List<ShipmentModel> findAllByMonthly() {
		return shipmentRepo.getShipmentsInfoWeekly().stream().map(parser::parse).collect(Collectors.toList());
			}
}
