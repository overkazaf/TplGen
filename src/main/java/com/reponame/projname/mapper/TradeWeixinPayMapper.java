package main.java.com.reponame.projname.mapper;

import java.util.*;
import main.java.com.reponame.projname.entity.TradeWeixinPay;
public interface TradeWeixinPayMapper {    public int addTradeWeixinPay (TradeWeixinPay tradeWeixinPay);	public int addAllTradeWeixinPays (List<TradeWeixinPay> tradeWeixinPayList);		public int modifyTradeWeixinPay (TradeWeixinPay tradeWeixinPay);	public int modifyAllTradeWeixinPays (List<TradeWeixinPay> tradeWeixinPayList);		public int removeTradeWeixinPayById (Integer tradeWeixinPayId);	public int removeAllTradeWeixinPays (List<Integer> idList);		public TradeWeixinPay queryTradeWeixinPayById(Integer tradeWeixinPayId);	public List<TradeWeixinPay> queryAllTradeWeixinPays();	}