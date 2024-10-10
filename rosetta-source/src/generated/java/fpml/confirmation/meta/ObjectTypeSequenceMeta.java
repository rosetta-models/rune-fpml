package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ObjectTypeSequence;
import fpml.confirmation.validation.ObjectTypeSequenceTypeFormatValidator;
import fpml.confirmation.validation.ObjectTypeSequenceValidator;
import fpml.confirmation.validation.exists.ObjectTypeSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ObjectTypeSequence.class)
public class ObjectTypeSequenceMeta implements RosettaMetaData<ObjectTypeSequence> {

	@Override
	public List<Validator<? super ObjectTypeSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObjectTypeSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ObjectTypeSequence> validator() {
		return new ObjectTypeSequenceValidator();
	}

	@Override
	public Validator<? super ObjectTypeSequence> typeFormatValidator() {
		return new ObjectTypeSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObjectTypeSequence, Set<String>> onlyExistsValidator() {
		return new ObjectTypeSequenceOnlyExistsValidator();
	}
}
