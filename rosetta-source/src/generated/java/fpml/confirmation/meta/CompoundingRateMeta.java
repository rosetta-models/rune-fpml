package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CompoundingRate;
import fpml.confirmation.validation.CompoundingRateTypeFormatValidator;
import fpml.confirmation.validation.CompoundingRateValidator;
import fpml.confirmation.validation.exists.CompoundingRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CompoundingRate.class)
public class CompoundingRateMeta implements RosettaMetaData<CompoundingRate> {

	@Override
	public List<Validator<? super CompoundingRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CompoundingRate>create(fpml.confirmation.validation.datarule.CompoundingRateChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CompoundingRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CompoundingRate> validator() {
		return new CompoundingRateValidator();
	}

	@Override
	public Validator<? super CompoundingRate> typeFormatValidator() {
		return new CompoundingRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CompoundingRate, Set<String>> onlyExistsValidator() {
		return new CompoundingRateOnlyExistsValidator();
	}
}
