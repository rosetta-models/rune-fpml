package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.VolatilityCap;
import fpml.confirmation.validation.VolatilityCapTypeFormatValidator;
import fpml.confirmation.validation.VolatilityCapValidator;
import fpml.confirmation.validation.exists.VolatilityCapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=VolatilityCap.class)
public class VolatilityCapMeta implements RosettaMetaData<VolatilityCap> {

	@Override
	public List<Validator<? super VolatilityCap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.VolatilityCap>create(fpml.confirmation.validation.datarule.VolatilityCapChoice.class)
		);
	}
	
	@Override
	public List<Function<? super VolatilityCap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super VolatilityCap> validator() {
		return new VolatilityCapValidator();
	}

	@Override
	public Validator<? super VolatilityCap> typeFormatValidator() {
		return new VolatilityCapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VolatilityCap, Set<String>> onlyExistsValidator() {
		return new VolatilityCapOnlyExistsValidator();
	}
}
