package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPerformanceSwapBase;
import fpml.confirmation.validation.CommodityPerformanceSwapBaseTypeFormatValidator;
import fpml.confirmation.validation.CommodityPerformanceSwapBaseValidator;
import fpml.confirmation.validation.exists.CommodityPerformanceSwapBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityPerformanceSwapBase.class)
public class CommodityPerformanceSwapBaseMeta implements RosettaMetaData<CommodityPerformanceSwapBase> {

	@Override
	public List<Validator<? super CommodityPerformanceSwapBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityPerformanceSwapBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityPerformanceSwapBase> validator() {
		return new CommodityPerformanceSwapBaseValidator();
	}

	@Override
	public Validator<? super CommodityPerformanceSwapBase> typeFormatValidator() {
		return new CommodityPerformanceSwapBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPerformanceSwapBase, Set<String>> onlyExistsValidator() {
		return new CommodityPerformanceSwapBaseOnlyExistsValidator();
	}
}
