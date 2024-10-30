package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxBarrierFeature;
import fpml.confirmation.validation.FxBarrierFeatureTypeFormatValidator;
import fpml.confirmation.validation.FxBarrierFeatureValidator;
import fpml.confirmation.validation.exists.FxBarrierFeatureOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxBarrierFeature.class)
public class FxBarrierFeatureMeta implements RosettaMetaData<FxBarrierFeature> {

	@Override
	public List<Validator<? super FxBarrierFeature>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxBarrierFeature>create(fpml.confirmation.validation.datarule.FxBarrierFeatureChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxBarrierFeature, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxBarrierFeature> validator() {
		return new FxBarrierFeatureValidator();
	}

	@Override
	public Validator<? super FxBarrierFeature> typeFormatValidator() {
		return new FxBarrierFeatureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxBarrierFeature, Set<String>> onlyExistsValidator() {
		return new FxBarrierFeatureOnlyExistsValidator();
	}
}
