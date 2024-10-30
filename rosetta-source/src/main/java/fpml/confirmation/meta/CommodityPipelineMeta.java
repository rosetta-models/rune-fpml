package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPipeline;
import fpml.confirmation.validation.CommodityPipelineTypeFormatValidator;
import fpml.confirmation.validation.CommodityPipelineValidator;
import fpml.confirmation.validation.exists.CommodityPipelineOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityPipeline.class)
public class CommodityPipelineMeta implements RosettaMetaData<CommodityPipeline> {

	@Override
	public List<Validator<? super CommodityPipeline>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityPipeline, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityPipeline> validator() {
		return new CommodityPipelineValidator();
	}

	@Override
	public Validator<? super CommodityPipeline> typeFormatValidator() {
		return new CommodityPipelineTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPipeline, Set<String>> onlyExistsValidator() {
		return new CommodityPipelineOnlyExistsValidator();
	}
}
