package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPerformanceSwapEarlyTermination;
import fpml.confirmation.validation.CommodityPerformanceSwapEarlyTerminationTypeFormatValidator;
import fpml.confirmation.validation.CommodityPerformanceSwapEarlyTerminationValidator;
import fpml.confirmation.validation.exists.CommodityPerformanceSwapEarlyTerminationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityPerformanceSwapEarlyTermination.class)
public class CommodityPerformanceSwapEarlyTerminationMeta implements RosettaMetaData<CommodityPerformanceSwapEarlyTermination> {

	@Override
	public List<Validator<? super CommodityPerformanceSwapEarlyTermination>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityPerformanceSwapEarlyTermination, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityPerformanceSwapEarlyTermination> validator() {
		return new CommodityPerformanceSwapEarlyTerminationValidator();
	}

	@Override
	public Validator<? super CommodityPerformanceSwapEarlyTermination> typeFormatValidator() {
		return new CommodityPerformanceSwapEarlyTerminationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPerformanceSwapEarlyTermination, Set<String>> onlyExistsValidator() {
		return new CommodityPerformanceSwapEarlyTerminationOnlyExistsValidator();
	}
}
