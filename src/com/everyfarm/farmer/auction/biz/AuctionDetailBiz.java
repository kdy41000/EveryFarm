package com.everyfarm.farmer.auction.biz;

import java.util.List;

import com.everyfarm.farmer.auction.dto.AuctionDetailDto;

public interface AuctionDetailBiz {

	// 1. 경매 진행 현황
	public List<AuctionDetailDto> runnigAuction(String mem_id);
	// 2. 경매 완료 내역
	public List<AuctionDetailDto> finishAuction(String mem_id);
	// 3. 경매 환불 현황
	// 3-1. 환불 요청 내역
	public List<AuctionDetailDto> refundApplyAuction(String mem_id);
	// 3-2. 환불 완료 내역
	public List<AuctionDetailDto> refundFinishAuction(String mem_id);
	
}
