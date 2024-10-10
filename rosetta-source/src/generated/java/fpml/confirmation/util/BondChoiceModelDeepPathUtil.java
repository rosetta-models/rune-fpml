package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.Bond;
import fpml.confirmation.BondCalculationModel;
import fpml.confirmation.BondChoiceModel;
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.ConvertibleBond;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.FixedIncomeSecurityContentModel;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.ProductReference;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class BondChoiceModelDeepPathUtil {
	public ExchangeId chooseExchangeId(BondChoiceModel bondChoiceModel) {
		final MapperS<Bond> bond = MapperS.of(bondChoiceModel).<Bond>map("getBond", _bondChoiceModel -> _bondChoiceModel.getBond());
		if (exists(bond).getOrDefault(false)) {
			return bond.<ExchangeId>map("getExchangeId", _bond -> _bond.getExchangeId()).get();
		}
		final MapperS<ConvertibleBond> convertibleBond = MapperS.of(bondChoiceModel).<ConvertibleBond>map("getConvertibleBond", _bondChoiceModel -> _bondChoiceModel.getConvertibleBond());
		if (exists(convertibleBond).getOrDefault(false)) {
			return convertibleBond.<ExchangeId>map("getExchangeId", _convertibleBond -> _convertibleBond.getExchangeId()).get();
		}
		return null;
	}
	
	public ClearanceSystem chooseClearanceSystem(BondChoiceModel bondChoiceModel) {
		final MapperS<Bond> bond = MapperS.of(bondChoiceModel).<Bond>map("getBond", _bondChoiceModel -> _bondChoiceModel.getBond());
		if (exists(bond).getOrDefault(false)) {
			return bond.<ClearanceSystem>map("getClearanceSystem", _bond -> _bond.getClearanceSystem()).get();
		}
		final MapperS<ConvertibleBond> convertibleBond = MapperS.of(bondChoiceModel).<ConvertibleBond>map("getConvertibleBond", _bondChoiceModel -> _bondChoiceModel.getConvertibleBond());
		if (exists(convertibleBond).getOrDefault(false)) {
			return convertibleBond.<ClearanceSystem>map("getClearanceSystem", _convertibleBond -> _convertibleBond.getClearanceSystem()).get();
		}
		return null;
	}
	
	public BondCalculationModel chooseBondCalculationModel(BondChoiceModel bondChoiceModel) {
		final MapperS<Bond> bond = MapperS.of(bondChoiceModel).<Bond>map("getBond", _bondChoiceModel -> _bondChoiceModel.getBond());
		if (exists(bond).getOrDefault(false)) {
			return bond.<BondCalculationModel>map("getBondCalculationModel", _bond -> _bond.getBondCalculationModel()).get();
		}
		final MapperS<ConvertibleBond> convertibleBond = MapperS.of(bondChoiceModel).<ConvertibleBond>map("getConvertibleBond", _bondChoiceModel -> _bondChoiceModel.getConvertibleBond());
		if (exists(convertibleBond).getOrDefault(false)) {
			return convertibleBond.<BondCalculationModel>map("getBondCalculationModel", _convertibleBond -> _convertibleBond.getBondCalculationModel()).get();
		}
		return null;
	}
	
	public BigDecimal chooseParValue(BondChoiceModel bondChoiceModel) {
		final MapperS<Bond> bond = MapperS.of(bondChoiceModel).<Bond>map("getBond", _bondChoiceModel -> _bondChoiceModel.getBond());
		if (exists(bond).getOrDefault(false)) {
			return bond.<BigDecimal>map("getParValue", _bond -> _bond.getParValue()).get();
		}
		final MapperS<ConvertibleBond> convertibleBond = MapperS.of(bondChoiceModel).<ConvertibleBond>map("getConvertibleBond", _bondChoiceModel -> _bondChoiceModel.getConvertibleBond());
		if (exists(convertibleBond).getOrDefault(false)) {
			return convertibleBond.<BigDecimal>map("getParValue", _convertibleBond -> _convertibleBond.getParValue()).get();
		}
		return null;
	}
	
	public List<InstrumentId> chooseInstrumentId(BondChoiceModel bondChoiceModel) {
		final MapperS<Bond> bond = MapperS.of(bondChoiceModel).<Bond>map("getBond", _bondChoiceModel -> _bondChoiceModel.getBond());
		if (exists(bond).getOrDefault(false)) {
			return bond.<InstrumentId>mapC("getInstrumentId", _bond -> _bond.getInstrumentId()).getMulti();
		}
		final MapperS<ConvertibleBond> convertibleBond = MapperS.of(bondChoiceModel).<ConvertibleBond>map("getConvertibleBond", _bondChoiceModel -> _bondChoiceModel.getConvertibleBond());
		if (exists(convertibleBond).getOrDefault(false)) {
			return convertibleBond.<InstrumentId>mapC("getInstrumentId", _convertibleBond -> _convertibleBond.getInstrumentId()).getMulti();
		}
		return Collections.<InstrumentId>emptyList();
	}
	
	public FixedIncomeSecurityContentModel chooseFixedIncomeSecurityContentModel(BondChoiceModel bondChoiceModel) {
		final MapperS<Bond> bond = MapperS.of(bondChoiceModel).<Bond>map("getBond", _bondChoiceModel -> _bondChoiceModel.getBond());
		if (exists(bond).getOrDefault(false)) {
			return bond.<FixedIncomeSecurityContentModel>map("getFixedIncomeSecurityContentModel", _bond -> _bond.getFixedIncomeSecurityContentModel()).get();
		}
		final MapperS<ConvertibleBond> convertibleBond = MapperS.of(bondChoiceModel).<ConvertibleBond>map("getConvertibleBond", _bondChoiceModel -> _bondChoiceModel.getConvertibleBond());
		if (exists(convertibleBond).getOrDefault(false)) {
			return convertibleBond.<FixedIncomeSecurityContentModel>map("getFixedIncomeSecurityContentModel", _convertibleBond -> _convertibleBond.getFixedIncomeSecurityContentModel()).get();
		}
		return null;
	}
	
	public String chooseDescription(BondChoiceModel bondChoiceModel) {
		final MapperS<Bond> bond = MapperS.of(bondChoiceModel).<Bond>map("getBond", _bondChoiceModel -> _bondChoiceModel.getBond());
		if (exists(bond).getOrDefault(false)) {
			return bond.<String>map("getDescription", _bond -> _bond.getDescription()).get();
		}
		final MapperS<ConvertibleBond> convertibleBond = MapperS.of(bondChoiceModel).<ConvertibleBond>map("getConvertibleBond", _bondChoiceModel -> _bondChoiceModel.getConvertibleBond());
		if (exists(convertibleBond).getOrDefault(false)) {
			return convertibleBond.<String>map("getDescription", _convertibleBond -> _convertibleBond.getDescription()).get();
		}
		return null;
	}
	
	public IdentifiedCurrency chooseCurrency(BondChoiceModel bondChoiceModel) {
		final MapperS<Bond> bond = MapperS.of(bondChoiceModel).<Bond>map("getBond", _bondChoiceModel -> _bondChoiceModel.getBond());
		if (exists(bond).getOrDefault(false)) {
			return bond.<IdentifiedCurrency>map("getCurrency", _bond -> _bond.getCurrency()).get();
		}
		final MapperS<ConvertibleBond> convertibleBond = MapperS.of(bondChoiceModel).<ConvertibleBond>map("getConvertibleBond", _bondChoiceModel -> _bondChoiceModel.getConvertibleBond());
		if (exists(convertibleBond).getOrDefault(false)) {
			return convertibleBond.<IdentifiedCurrency>map("getCurrency", _convertibleBond -> _convertibleBond.getCurrency()).get();
		}
		return null;
	}
	
	public ProductReference chooseDefinition(BondChoiceModel bondChoiceModel) {
		final MapperS<Bond> bond = MapperS.of(bondChoiceModel).<Bond>map("getBond", _bondChoiceModel -> _bondChoiceModel.getBond());
		if (exists(bond).getOrDefault(false)) {
			return bond.<ProductReference>map("getDefinition", _bond -> _bond.getDefinition()).get();
		}
		final MapperS<ConvertibleBond> convertibleBond = MapperS.of(bondChoiceModel).<ConvertibleBond>map("getConvertibleBond", _bondChoiceModel -> _bondChoiceModel.getConvertibleBond());
		if (exists(convertibleBond).getOrDefault(false)) {
			return convertibleBond.<ProductReference>map("getDefinition", _convertibleBond -> _convertibleBond.getDefinition()).get();
		}
		return null;
	}
	
	public String chooseId(BondChoiceModel bondChoiceModel) {
		final MapperS<Bond> bond = MapperS.of(bondChoiceModel).<Bond>map("getBond", _bondChoiceModel -> _bondChoiceModel.getBond());
		if (exists(bond).getOrDefault(false)) {
			return bond.<String>map("getId", _bond -> _bond.getId()).get();
		}
		final MapperS<ConvertibleBond> convertibleBond = MapperS.of(bondChoiceModel).<ConvertibleBond>map("getConvertibleBond", _bondChoiceModel -> _bondChoiceModel.getConvertibleBond());
		if (exists(convertibleBond).getOrDefault(false)) {
			return convertibleBond.<String>map("getId", _convertibleBond -> _convertibleBond.getId()).get();
		}
		return null;
	}
	
	public BigDecimal chooseFaceAmount(BondChoiceModel bondChoiceModel) {
		final MapperS<Bond> bond = MapperS.of(bondChoiceModel).<Bond>map("getBond", _bondChoiceModel -> _bondChoiceModel.getBond());
		if (exists(bond).getOrDefault(false)) {
			return bond.<BigDecimal>map("getFaceAmount", _bond -> _bond.getFaceAmount()).get();
		}
		final MapperS<ConvertibleBond> convertibleBond = MapperS.of(bondChoiceModel).<ConvertibleBond>map("getConvertibleBond", _bondChoiceModel -> _bondChoiceModel.getConvertibleBond());
		if (exists(convertibleBond).getOrDefault(false)) {
			return convertibleBond.<BigDecimal>map("getFaceAmount", _convertibleBond -> _convertibleBond.getFaceAmount()).get();
		}
		return null;
	}
	
}
