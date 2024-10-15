package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPerformanceSwapLeg;
import fpml.confirmation.validation.CommodityPerformanceSwapLegTypeFormatValidator;
import fpml.confirmation.validation.CommodityPerformanceSwapLegValidator;
import fpml.confirmation.validation.exists.CommodityPerformanceSwapLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityPerformanceSwapLeg.class)
public class CommodityPerformanceSwapLegMeta implements RosettaMetaData<CommodityPerformanceSwapLeg> {

	@Override
	public List<Validator<? super CommodityPerformanceSwapLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityPerformanceSwapLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityPerformanceSwapLeg> validator() {
		return new CommodityPerformanceSwapLegValidator();
	}

	@Override
	public Validator<? super CommodityPerformanceSwapLeg> typeFormatValidator() {
		return new CommodityPerformanceSwapLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPerformanceSwapLeg, Set<String>> onlyExistsValidator() {
		return new CommodityPerformanceSwapLegOnlyExistsValidator();
	}
}
