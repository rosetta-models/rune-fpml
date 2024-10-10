package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FixedLeg;
import fpml.confirmation.validation.FixedLegTypeFormatValidator;
import fpml.confirmation.validation.FixedLegValidator;
import fpml.confirmation.validation.exists.FixedLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FixedLeg.class)
public class FixedLegMeta implements RosettaMetaData<FixedLeg> {

	@Override
	public List<Validator<? super FixedLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FixedLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FixedLeg> validator() {
		return new FixedLegValidator();
	}

	@Override
	public Validator<? super FixedLeg> typeFormatValidator() {
		return new FixedLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedLeg, Set<String>> onlyExistsValidator() {
		return new FixedLegOnlyExistsValidator();
	}
}
