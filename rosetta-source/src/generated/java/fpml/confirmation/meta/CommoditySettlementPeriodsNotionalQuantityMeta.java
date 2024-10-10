package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommoditySettlementPeriodsNotionalQuantity;
import fpml.confirmation.validation.CommoditySettlementPeriodsNotionalQuantityTypeFormatValidator;
import fpml.confirmation.validation.CommoditySettlementPeriodsNotionalQuantityValidator;
import fpml.confirmation.validation.exists.CommoditySettlementPeriodsNotionalQuantityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommoditySettlementPeriodsNotionalQuantity.class)
public class CommoditySettlementPeriodsNotionalQuantityMeta implements RosettaMetaData<CommoditySettlementPeriodsNotionalQuantity> {

	@Override
	public List<Validator<? super CommoditySettlementPeriodsNotionalQuantity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommoditySettlementPeriodsNotionalQuantity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommoditySettlementPeriodsNotionalQuantity> validator() {
		return new CommoditySettlementPeriodsNotionalQuantityValidator();
	}

	@Override
	public Validator<? super CommoditySettlementPeriodsNotionalQuantity> typeFormatValidator() {
		return new CommoditySettlementPeriodsNotionalQuantityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommoditySettlementPeriodsNotionalQuantity, Set<String>> onlyExistsValidator() {
		return new CommoditySettlementPeriodsNotionalQuantityOnlyExistsValidator();
	}
}
