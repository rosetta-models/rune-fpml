package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PGPDataTypeSequence0;
import fpml.confirmation.validation.PGPDataTypeSequence0TypeFormatValidator;
import fpml.confirmation.validation.PGPDataTypeSequence0Validator;
import fpml.confirmation.validation.exists.PGPDataTypeSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PGPDataTypeSequence0.class)
public class PGPDataTypeSequence0Meta implements RosettaMetaData<PGPDataTypeSequence0> {

	@Override
	public List<Validator<? super PGPDataTypeSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PGPDataTypeSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PGPDataTypeSequence0> validator() {
		return new PGPDataTypeSequence0Validator();
	}

	@Override
	public Validator<? super PGPDataTypeSequence0> typeFormatValidator() {
		return new PGPDataTypeSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PGPDataTypeSequence0, Set<String>> onlyExistsValidator() {
		return new PGPDataTypeSequence0OnlyExistsValidator();
	}
}
