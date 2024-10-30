package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityNotionalAmount;
import fpml.confirmation.validation.CommodityNotionalAmountTypeFormatValidator;
import fpml.confirmation.validation.CommodityNotionalAmountValidator;
import fpml.confirmation.validation.exists.CommodityNotionalAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityNotionalAmount.class)
public class CommodityNotionalAmountMeta implements RosettaMetaData<CommodityNotionalAmount> {

	@Override
	public List<Validator<? super CommodityNotionalAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityNotionalAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityNotionalAmount> validator() {
		return new CommodityNotionalAmountValidator();
	}

	@Override
	public Validator<? super CommodityNotionalAmount> typeFormatValidator() {
		return new CommodityNotionalAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityNotionalAmount, Set<String>> onlyExistsValidator() {
		return new CommodityNotionalAmountOnlyExistsValidator();
	}
}
