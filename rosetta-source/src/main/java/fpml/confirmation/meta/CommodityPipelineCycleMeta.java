package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPipelineCycle;
import fpml.confirmation.validation.CommodityPipelineCycleTypeFormatValidator;
import fpml.confirmation.validation.CommodityPipelineCycleValidator;
import fpml.confirmation.validation.exists.CommodityPipelineCycleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityPipelineCycle.class)
public class CommodityPipelineCycleMeta implements RosettaMetaData<CommodityPipelineCycle> {

	@Override
	public List<Validator<? super CommodityPipelineCycle>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityPipelineCycle, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityPipelineCycle> validator() {
		return new CommodityPipelineCycleValidator();
	}

	@Override
	public Validator<? super CommodityPipelineCycle> typeFormatValidator() {
		return new CommodityPipelineCycleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPipelineCycle, Set<String>> onlyExistsValidator() {
		return new CommodityPipelineCycleOnlyExistsValidator();
	}
}
