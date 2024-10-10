package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InterestRateStream;
import fpml.confirmation.validation.InterestRateStreamTypeFormatValidator;
import fpml.confirmation.validation.InterestRateStreamValidator;
import fpml.confirmation.validation.exists.InterestRateStreamOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=InterestRateStream.class)
public class InterestRateStreamMeta implements RosettaMetaData<InterestRateStream> {

	@Override
	public List<Validator<? super InterestRateStream>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestRateStream, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InterestRateStream> validator() {
		return new InterestRateStreamValidator();
	}

	@Override
	public Validator<? super InterestRateStream> typeFormatValidator() {
		return new InterestRateStreamTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestRateStream, Set<String>> onlyExistsValidator() {
		return new InterestRateStreamOnlyExistsValidator();
	}
}
