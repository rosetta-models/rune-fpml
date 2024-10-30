package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DSAKeyValueTypeSequence0;
import fpml.confirmation.validation.DSAKeyValueTypeSequence0TypeFormatValidator;
import fpml.confirmation.validation.DSAKeyValueTypeSequence0Validator;
import fpml.confirmation.validation.exists.DSAKeyValueTypeSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DSAKeyValueTypeSequence0.class)
public class DSAKeyValueTypeSequence0Meta implements RosettaMetaData<DSAKeyValueTypeSequence0> {

	@Override
	public List<Validator<? super DSAKeyValueTypeSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DSAKeyValueTypeSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DSAKeyValueTypeSequence0> validator() {
		return new DSAKeyValueTypeSequence0Validator();
	}

	@Override
	public Validator<? super DSAKeyValueTypeSequence0> typeFormatValidator() {
		return new DSAKeyValueTypeSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DSAKeyValueTypeSequence0, Set<String>> onlyExistsValidator() {
		return new DSAKeyValueTypeSequence0OnlyExistsValidator();
	}
}
