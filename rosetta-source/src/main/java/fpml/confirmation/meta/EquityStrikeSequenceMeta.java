package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquityStrikeSequence;
import fpml.confirmation.validation.EquityStrikeSequenceTypeFormatValidator;
import fpml.confirmation.validation.EquityStrikeSequenceValidator;
import fpml.confirmation.validation.exists.EquityStrikeSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EquityStrikeSequence.class)
public class EquityStrikeSequenceMeta implements RosettaMetaData<EquityStrikeSequence> {

	@Override
	public List<Validator<? super EquityStrikeSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityStrikeSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EquityStrikeSequence> validator() {
		return new EquityStrikeSequenceValidator();
	}

	@Override
	public Validator<? super EquityStrikeSequence> typeFormatValidator() {
		return new EquityStrikeSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityStrikeSequence, Set<String>> onlyExistsValidator() {
		return new EquityStrikeSequenceOnlyExistsValidator();
	}
}
