package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPerformanceSwap;
import fpml.confirmation.validation.CommodityPerformanceSwapTypeFormatValidator;
import fpml.confirmation.validation.CommodityPerformanceSwapValidator;
import fpml.confirmation.validation.exists.CommodityPerformanceSwapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityPerformanceSwap.class)
public class CommodityPerformanceSwapMeta implements RosettaMetaData<CommodityPerformanceSwap> {

	@Override
	public List<Validator<? super CommodityPerformanceSwap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityPerformanceSwap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityPerformanceSwap> validator() {
		return new CommodityPerformanceSwapValidator();
	}

	@Override
	public Validator<? super CommodityPerformanceSwap> typeFormatValidator() {
		return new CommodityPerformanceSwapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPerformanceSwap, Set<String>> onlyExistsValidator() {
		return new CommodityPerformanceSwapOnlyExistsValidator();
	}
}
