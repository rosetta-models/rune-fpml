package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.X509DataTypeSequence;
import fpml.confirmation.validation.X509DataTypeSequenceTypeFormatValidator;
import fpml.confirmation.validation.X509DataTypeSequenceValidator;
import fpml.confirmation.validation.exists.X509DataTypeSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=X509DataTypeSequence.class)
public class X509DataTypeSequenceMeta implements RosettaMetaData<X509DataTypeSequence> {

	@Override
	public List<Validator<? super X509DataTypeSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.X509DataTypeSequence>create(fpml.confirmation.validation.datarule.X509DataTypeSequenceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super X509DataTypeSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super X509DataTypeSequence> validator() {
		return new X509DataTypeSequenceValidator();
	}

	@Override
	public Validator<? super X509DataTypeSequence> typeFormatValidator() {
		return new X509DataTypeSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super X509DataTypeSequence, Set<String>> onlyExistsValidator() {
		return new X509DataTypeSequenceOnlyExistsValidator();
	}
}
