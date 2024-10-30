package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CompressionActivitySequence0;
import fpml.confirmation.validation.CompressionActivitySequence0TypeFormatValidator;
import fpml.confirmation.validation.CompressionActivitySequence0Validator;
import fpml.confirmation.validation.exists.CompressionActivitySequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CompressionActivitySequence0.class)
public class CompressionActivitySequence0Meta implements RosettaMetaData<CompressionActivitySequence0> {

	@Override
	public List<Validator<? super CompressionActivitySequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CompressionActivitySequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CompressionActivitySequence0> validator() {
		return new CompressionActivitySequence0Validator();
	}

	@Override
	public Validator<? super CompressionActivitySequence0> typeFormatValidator() {
		return new CompressionActivitySequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CompressionActivitySequence0, Set<String>> onlyExistsValidator() {
		return new CompressionActivitySequence0OnlyExistsValidator();
	}
}
