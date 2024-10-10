package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.StrategyFeature;
import fpml.confirmation.validation.StrategyFeatureTypeFormatValidator;
import fpml.confirmation.validation.StrategyFeatureValidator;
import fpml.confirmation.validation.exists.StrategyFeatureOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=StrategyFeature.class)
public class StrategyFeatureMeta implements RosettaMetaData<StrategyFeature> {

	@Override
	public List<Validator<? super StrategyFeature>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.StrategyFeature>create(fpml.confirmation.validation.datarule.StrategyFeatureChoice.class)
		);
	}
	
	@Override
	public List<Function<? super StrategyFeature, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super StrategyFeature> validator() {
		return new StrategyFeatureValidator();
	}

	@Override
	public Validator<? super StrategyFeature> typeFormatValidator() {
		return new StrategyFeatureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StrategyFeature, Set<String>> onlyExistsValidator() {
		return new StrategyFeatureOnlyExistsValidator();
	}
}
