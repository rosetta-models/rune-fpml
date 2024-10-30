package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DSAKeyValueTypeSequence1;
import fpml.confirmation.validation.DSAKeyValueTypeSequence1TypeFormatValidator;
import fpml.confirmation.validation.DSAKeyValueTypeSequence1Validator;
import fpml.confirmation.validation.exists.DSAKeyValueTypeSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DSAKeyValueTypeSequence1.class)
public class DSAKeyValueTypeSequence1Meta implements RosettaMetaData<DSAKeyValueTypeSequence1> {

	@Override
	public List<Validator<? super DSAKeyValueTypeSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DSAKeyValueTypeSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DSAKeyValueTypeSequence1> validator() {
		return new DSAKeyValueTypeSequence1Validator();
	}

	@Override
	public Validator<? super DSAKeyValueTypeSequence1> typeFormatValidator() {
		return new DSAKeyValueTypeSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DSAKeyValueTypeSequence1, Set<String>> onlyExistsValidator() {
		return new DSAKeyValueTypeSequence1OnlyExistsValidator();
	}
}
