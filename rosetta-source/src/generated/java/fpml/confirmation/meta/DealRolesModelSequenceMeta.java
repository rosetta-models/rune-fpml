package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DealRolesModelSequence;
import fpml.confirmation.validation.DealRolesModelSequenceTypeFormatValidator;
import fpml.confirmation.validation.DealRolesModelSequenceValidator;
import fpml.confirmation.validation.exists.DealRolesModelSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DealRolesModelSequence.class)
public class DealRolesModelSequenceMeta implements RosettaMetaData<DealRolesModelSequence> {

	@Override
	public List<Validator<? super DealRolesModelSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DealRolesModelSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DealRolesModelSequence> validator() {
		return new DealRolesModelSequenceValidator();
	}

	@Override
	public Validator<? super DealRolesModelSequence> typeFormatValidator() {
		return new DealRolesModelSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DealRolesModelSequence, Set<String>> onlyExistsValidator() {
		return new DealRolesModelSequenceOnlyExistsValidator();
	}
}
