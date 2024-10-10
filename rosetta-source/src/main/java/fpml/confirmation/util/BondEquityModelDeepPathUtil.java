package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.BondChoiceModel;
import fpml.confirmation.BondEquityModel;
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.EquityAsset;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.ProductReference;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class BondEquityModelDeepPathUtil {
	private final BondChoiceModelDeepPathUtil bondChoiceModelDeepPathUtil;
	
	@Inject
	public BondEquityModelDeepPathUtil(BondChoiceModelDeepPathUtil bondChoiceModelDeepPathUtil) {
		this.bondChoiceModelDeepPathUtil = bondChoiceModelDeepPathUtil;
	}
	
	public ExchangeId chooseExchangeId(BondEquityModel bondEquityModel) {
		final MapperS<BondChoiceModel> bondChoiceModel = MapperS.of(bondEquityModel).<BondChoiceModel>map("getBondChoiceModel", _bondEquityModel -> _bondEquityModel.getBondChoiceModel());
		if (exists(bondChoiceModel).getOrDefault(false)) {
			return bondChoiceModel.<ExchangeId>map("chooseExchangeId", _bondChoiceModel -> bondChoiceModelDeepPathUtil.chooseExchangeId(_bondChoiceModel)).get();
		}
		final MapperS<EquityAsset> equity = MapperS.of(bondEquityModel).<EquityAsset>map("getEquity", _bondEquityModel -> _bondEquityModel.getEquity());
		if (exists(equity).getOrDefault(false)) {
			return equity.<ExchangeId>map("getExchangeId", equityAsset -> equityAsset.getExchangeId()).get();
		}
		return null;
	}
	
	public ClearanceSystem chooseClearanceSystem(BondEquityModel bondEquityModel) {
		final MapperS<BondChoiceModel> bondChoiceModel = MapperS.of(bondEquityModel).<BondChoiceModel>map("getBondChoiceModel", _bondEquityModel -> _bondEquityModel.getBondChoiceModel());
		if (exists(bondChoiceModel).getOrDefault(false)) {
			return bondChoiceModel.<ClearanceSystem>map("chooseClearanceSystem", _bondChoiceModel -> bondChoiceModelDeepPathUtil.chooseClearanceSystem(_bondChoiceModel)).get();
		}
		final MapperS<EquityAsset> equity = MapperS.of(bondEquityModel).<EquityAsset>map("getEquity", _bondEquityModel -> _bondEquityModel.getEquity());
		if (exists(equity).getOrDefault(false)) {
			return equity.<ClearanceSystem>map("getClearanceSystem", equityAsset -> equityAsset.getClearanceSystem()).get();
		}
		return null;
	}
	
	public List<InstrumentId> chooseInstrumentId(BondEquityModel bondEquityModel) {
		final MapperS<BondChoiceModel> bondChoiceModel = MapperS.of(bondEquityModel).<BondChoiceModel>map("getBondChoiceModel", _bondEquityModel -> _bondEquityModel.getBondChoiceModel());
		if (exists(bondChoiceModel).getOrDefault(false)) {
			return bondChoiceModel.<InstrumentId>mapC("chooseInstrumentId", _bondChoiceModel -> bondChoiceModelDeepPathUtil.chooseInstrumentId(_bondChoiceModel)).getMulti();
		}
		final MapperS<EquityAsset> equity = MapperS.of(bondEquityModel).<EquityAsset>map("getEquity", _bondEquityModel -> _bondEquityModel.getEquity());
		if (exists(equity).getOrDefault(false)) {
			return equity.<InstrumentId>mapC("getInstrumentId", equityAsset -> equityAsset.getInstrumentId()).getMulti();
		}
		return Collections.<InstrumentId>emptyList();
	}
	
	public String chooseDescription(BondEquityModel bondEquityModel) {
		final MapperS<BondChoiceModel> bondChoiceModel = MapperS.of(bondEquityModel).<BondChoiceModel>map("getBondChoiceModel", _bondEquityModel -> _bondEquityModel.getBondChoiceModel());
		if (exists(bondChoiceModel).getOrDefault(false)) {
			return bondChoiceModel.<String>map("chooseDescription", _bondChoiceModel -> bondChoiceModelDeepPathUtil.chooseDescription(_bondChoiceModel)).get();
		}
		final MapperS<EquityAsset> equity = MapperS.of(bondEquityModel).<EquityAsset>map("getEquity", _bondEquityModel -> _bondEquityModel.getEquity());
		if (exists(equity).getOrDefault(false)) {
			return equity.<String>map("getDescription", equityAsset -> equityAsset.getDescription()).get();
		}
		return null;
	}
	
	public IdentifiedCurrency chooseCurrency(BondEquityModel bondEquityModel) {
		final MapperS<BondChoiceModel> bondChoiceModel = MapperS.of(bondEquityModel).<BondChoiceModel>map("getBondChoiceModel", _bondEquityModel -> _bondEquityModel.getBondChoiceModel());
		if (exists(bondChoiceModel).getOrDefault(false)) {
			return bondChoiceModel.<IdentifiedCurrency>map("chooseCurrency", _bondChoiceModel -> bondChoiceModelDeepPathUtil.chooseCurrency(_bondChoiceModel)).get();
		}
		final MapperS<EquityAsset> equity = MapperS.of(bondEquityModel).<EquityAsset>map("getEquity", _bondEquityModel -> _bondEquityModel.getEquity());
		if (exists(equity).getOrDefault(false)) {
			return equity.<IdentifiedCurrency>map("getCurrency", equityAsset -> equityAsset.getCurrency()).get();
		}
		return null;
	}
	
	public ProductReference chooseDefinition(BondEquityModel bondEquityModel) {
		final MapperS<BondChoiceModel> bondChoiceModel = MapperS.of(bondEquityModel).<BondChoiceModel>map("getBondChoiceModel", _bondEquityModel -> _bondEquityModel.getBondChoiceModel());
		if (exists(bondChoiceModel).getOrDefault(false)) {
			return bondChoiceModel.<ProductReference>map("chooseDefinition", _bondChoiceModel -> bondChoiceModelDeepPathUtil.chooseDefinition(_bondChoiceModel)).get();
		}
		final MapperS<EquityAsset> equity = MapperS.of(bondEquityModel).<EquityAsset>map("getEquity", _bondEquityModel -> _bondEquityModel.getEquity());
		if (exists(equity).getOrDefault(false)) {
			return equity.<ProductReference>map("getDefinition", equityAsset -> equityAsset.getDefinition()).get();
		}
		return null;
	}
	
	public String chooseId(BondEquityModel bondEquityModel) {
		final MapperS<BondChoiceModel> bondChoiceModel = MapperS.of(bondEquityModel).<BondChoiceModel>map("getBondChoiceModel", _bondEquityModel -> _bondEquityModel.getBondChoiceModel());
		if (exists(bondChoiceModel).getOrDefault(false)) {
			return bondChoiceModel.<String>map("chooseId", _bondChoiceModel -> bondChoiceModelDeepPathUtil.chooseId(_bondChoiceModel)).get();
		}
		final MapperS<EquityAsset> equity = MapperS.of(bondEquityModel).<EquityAsset>map("getEquity", _bondEquityModel -> _bondEquityModel.getEquity());
		if (exists(equity).getOrDefault(false)) {
			return equity.<String>map("getId", equityAsset -> equityAsset.getId()).get();
		}
		return null;
	}
	
}
