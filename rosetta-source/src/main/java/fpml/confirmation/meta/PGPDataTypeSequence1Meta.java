package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PGPDataTypeSequence1;
import fpml.confirmation.validation.PGPDataTypeSequence1TypeFormatValidator;
import fpml.confirmation.validation.PGPDataTypeSequence1Validator;
import fpml.confirmation.validation.exists.PGPDataTypeSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PGPDataTypeSequence1.class)
public class PGPDataTypeSequence1Meta implements RosettaMetaData<PGPDataTypeSequence1> {

	@Override
	public List<Validator<? super PGPDataTypeSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PGPDataTypeSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PGPDataTypeSequence1> validator() {
		return new PGPDataTypeSequence1Validator();
	}

	@Override
	public Validator<? super PGPDataTypeSequence1> typeFormatValidator() {
		return new PGPDataTypeSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PGPDataTypeSequence1, Set<String>> onlyExistsValidator() {
		return new PGPDataTypeSequence1OnlyExistsValidator();
	}
}
