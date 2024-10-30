package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DividendConditionsSequence;
import fpml.confirmation.validation.DividendConditionsSequenceTypeFormatValidator;
import fpml.confirmation.validation.DividendConditionsSequenceValidator;
import fpml.confirmation.validation.exists.DividendConditionsSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DividendConditionsSequence.class)
public class DividendConditionsSequenceMeta implements RosettaMetaData<DividendConditionsSequence> {

	@Override
	public List<Validator<? super DividendConditionsSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DividendConditionsSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DividendConditionsSequence> validator() {
		return new DividendConditionsSequenceValidator();
	}

	@Override
	public Validator<? super DividendConditionsSequence> typeFormatValidator() {
		return new DividendConditionsSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendConditionsSequence, Set<String>> onlyExistsValidator() {
		return new DividendConditionsSequenceOnlyExistsValidator();
	}
}
