package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquityExpirationModelSequence;
import fpml.confirmation.validation.EquityExpirationModelSequenceTypeFormatValidator;
import fpml.confirmation.validation.EquityExpirationModelSequenceValidator;
import fpml.confirmation.validation.exists.EquityExpirationModelSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EquityExpirationModelSequence.class)
public class EquityExpirationModelSequenceMeta implements RosettaMetaData<EquityExpirationModelSequence> {

	@Override
	public List<Validator<? super EquityExpirationModelSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityExpirationModelSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EquityExpirationModelSequence> validator() {
		return new EquityExpirationModelSequenceValidator();
	}

	@Override
	public Validator<? super EquityExpirationModelSequence> typeFormatValidator() {
		return new EquityExpirationModelSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityExpirationModelSequence, Set<String>> onlyExistsValidator() {
		return new EquityExpirationModelSequenceOnlyExistsValidator();
	}
}
