package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CompressionActivitySequence1;
import fpml.confirmation.validation.CompressionActivitySequence1TypeFormatValidator;
import fpml.confirmation.validation.CompressionActivitySequence1Validator;
import fpml.confirmation.validation.exists.CompressionActivitySequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CompressionActivitySequence1.class)
public class CompressionActivitySequence1Meta implements RosettaMetaData<CompressionActivitySequence1> {

	@Override
	public List<Validator<? super CompressionActivitySequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CompressionActivitySequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CompressionActivitySequence1> validator() {
		return new CompressionActivitySequence1Validator();
	}

	@Override
	public Validator<? super CompressionActivitySequence1> typeFormatValidator() {
		return new CompressionActivitySequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CompressionActivitySequence1, Set<String>> onlyExistsValidator() {
		return new CompressionActivitySequence1OnlyExistsValidator();
	}
}
