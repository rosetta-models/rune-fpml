package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FeeLeg;
import fpml.confirmation.validation.FeeLegTypeFormatValidator;
import fpml.confirmation.validation.FeeLegValidator;
import fpml.confirmation.validation.exists.FeeLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FeeLeg.class)
public class FeeLegMeta implements RosettaMetaData<FeeLeg> {

	@Override
	public List<Validator<? super FeeLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FeeLeg>create(fpml.confirmation.validation.datarule.FeeLegChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FeeLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FeeLeg> validator() {
		return new FeeLegValidator();
	}

	@Override
	public Validator<? super FeeLeg> typeFormatValidator() {
		return new FeeLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FeeLeg, Set<String>> onlyExistsValidator() {
		return new FeeLegOnlyExistsValidator();
	}
}
