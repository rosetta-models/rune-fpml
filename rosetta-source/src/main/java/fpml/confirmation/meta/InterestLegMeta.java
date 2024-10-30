package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InterestLeg;
import fpml.confirmation.validation.InterestLegTypeFormatValidator;
import fpml.confirmation.validation.InterestLegValidator;
import fpml.confirmation.validation.exists.InterestLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=InterestLeg.class)
public class InterestLegMeta implements RosettaMetaData<InterestLeg> {

	@Override
	public List<Validator<? super InterestLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InterestLeg> validator() {
		return new InterestLegValidator();
	}

	@Override
	public Validator<? super InterestLeg> typeFormatValidator() {
		return new InterestLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestLeg, Set<String>> onlyExistsValidator() {
		return new InterestLegOnlyExistsValidator();
	}
}
